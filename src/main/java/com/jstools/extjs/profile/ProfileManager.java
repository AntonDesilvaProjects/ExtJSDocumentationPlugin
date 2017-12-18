package com.jstools.extjs.profile;

import com.google.gson.*;
import com.jstools.extjs.common.DocumentationConstants;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
    Responsible for loading profiles from user's hard disk and call
    DocumentationReader to read code. Doc reader will call a parser
    to generate a list of document objects
*/
@Component
public class ProfileManager {

    List<Profile> profiles;
    HashMap<Integer, Profile> profileMap;

    public ProfileManager()
    {
        profileMap = new HashMap<Integer, Profile>();
        String profileJson = this.getProfileFileContents( DocumentationConstants.PROFILE_LOCATION );
        profiles = this.generateProfilesFromJson(profileJson);
    }
    private String getProfileFileContents(String profilePath)
    {
        try {
            BufferedReader bufferedReader = new BufferedReader( new FileReader(profilePath ) );
            StringBuilder fileContents = new StringBuilder();
            String currentLine = null;
            while( (currentLine = bufferedReader.readLine()) != null )
            {
                fileContents.append(currentLine);
            }
            return fileContents.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    private List<Profile> generateProfilesFromJson(String json)
    {
        List<Profile> profileList = new ArrayList<Profile>();
        Gson jsonConverter = new Gson();
        JsonObject profileObject = new JsonParser().parse(json).getAsJsonObject();
        JsonArray profiles = profileObject.getAsJsonArray("profiles");
        for(JsonElement profile : profiles )
        {
            Profile currentProfile = jsonConverter.fromJson( profile, Profile.class );
            profileList.add( currentProfile );
            profileMap.put( currentProfile.getId(), currentProfile );
        }
        return profileList;
    }

    public Profile getProfile(int profileId)
    {
        return this.profileMap.get( profileId );
    }
    public List<Profile> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<Profile> profiles) {
        this.profiles = profiles;
    }
}

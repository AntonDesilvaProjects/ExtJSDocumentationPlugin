package com.jstools.extjs;

import com.jstools.extjs.common.DocumentationConstants;
import com.jstools.extjs.documentation.Documentation;
import com.jstools.extjs.profile.ProfileManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class ApplicationRunner {
    public static void main(String[] args)
    {
        setProfileLocation( args );
        DocumentationConstants.ACTIVE_DOCUMENTATION_ROOT = new ProfileManager().getProfile(1).getDocumentationRoot();
        SpringApplication.run(ApplicationRunner.class, args);
    }
    public static void setProfileLocation( String[] args )
    {
        if( args.length > 0 )
        {
            System.out.println("Using profile at " + args[0]);
            DocumentationConstants.PROFILE_LOCATION = args[0];
        }
        else
        {
            System.out.println("Using profile in current directory: " + System.getProperty("user.dir")  );
            DocumentationConstants.PROFILE_LOCATION = System.getProperty("user.dir") + "\\extjs_profiles.json";
        }
    }
}

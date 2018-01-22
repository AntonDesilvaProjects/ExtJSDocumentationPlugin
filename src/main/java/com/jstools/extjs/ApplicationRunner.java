package com.jstools.extjs;

import com.jstools.extjs.common.DocumentationConstants;
import com.jstools.extjs.profile.ProfileManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class ApplicationRunner {
    public static void main(String[] args)
    {
        DocumentationConstants.ACTIVE_DOCUMENTATION_ROOT = new ProfileManager().getProfile(1).getDocumentationRoot();
        System.out.println( System.getProperty("user.dir") );
        SpringApplication.run(ApplicationRunner.class, args);
    }
}

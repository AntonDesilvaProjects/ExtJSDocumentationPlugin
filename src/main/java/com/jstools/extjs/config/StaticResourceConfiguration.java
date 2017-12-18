package com.jstools.extjs.config;

import com.jstools.extjs.common.DocumentationConstants;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class StaticResourceConfiguration extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        //"file:///C:/Users/Anton/Downloads/extjs-652-docs/"
        registry.addResourceHandler("/docs/**").addResourceLocations("file:///" + DocumentationConstants.ACTIVE_DOCUMENTATION_ROOT);
    }
}

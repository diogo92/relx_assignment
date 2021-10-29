package com.relx.naming;

import com.relx.naming.controllers.NamingController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

/**
 * Jersey resource config for registering the REST services
 */
@Component
public class NamingServiceConfig extends ResourceConfig {

    public NamingServiceConfig(){
        super();
        register(NamingController.class);
    }
}

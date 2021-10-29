package com.relx.naming;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


/**
 * {@inheritDoc}
 */
public class ServletInitializer extends SpringBootServletInitializer {

    /**
     * {@inheritDoc}
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(NamingApplication.class);
    }
}

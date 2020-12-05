package com.se2.easypc.auth.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter{

    private static final String[] publicResources = new String[]{ "/api/**" };
    private static final String[] adminResources = new String[]{"/api/create/**","/api/delete/**","/api/motherboard/compatible-cpus/**"};

    @Override
    public void configure( HttpSecurity httpSecurity ) throws Exception{
        httpSecurity
                .authorizeRequests( )
                .antMatchers( adminResources ).hasAuthority("ROLE_ADMIN")
                .antMatchers( publicResources ).permitAll( )
                .and( ).cors( ).disable( );
    }

}
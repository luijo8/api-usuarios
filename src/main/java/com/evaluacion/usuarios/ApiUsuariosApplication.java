package com.evaluacion.usuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.evaluacion.security.JWTAuthorizationFilter;


@SpringBootApplication
public class ApiUsuariosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiUsuariosApplication.class, args);
	}

	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {
		

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			 http.csrf().disable()
			.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
			.authorizeRequests()
			.antMatchers(HttpMethod.POST, "/api/usuarios/createtoken").permitAll()
			.anyRequest().authenticated()
			;
		}
		
		@Override
	    public void configure(WebSecurity web) {
	        web.ignoring()
	           .antMatchers("/h2-console/**")
	           .antMatchers("/v2/api-docs",
	        		        "/v3/api-docs",
       		        		"/configuration/ui",  
       		        		"/configuration/security", 
	                        "/webjars/**",
	                        "/swagger-ui.html",
	    	                "/swagger-resources/**", 
	    					"/swagger-ui/**", 
	    					"/swagger-ui/index.html**",
	    					"/v2/api-docs/swagger-ui.html",
	    					"/api/swagger-ui.html",
	    					"/webjars/**", 
	    					"/actuator/health",
	    					"/api/usuarios/swagger-ui/index.html"
	                        );
	    }			
	}

}

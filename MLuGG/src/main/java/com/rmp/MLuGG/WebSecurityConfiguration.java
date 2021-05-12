package com.rmp.MLuGG;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.rmp.MLuGG.Services.CustomJwtAuthenticationFilter;
import com.rmp.MLuGG.Services.CustomUserDetailsService;
import com.rmp.MLuGG.Services.JwtAuthenticationEntryPoint;


@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService userDetailsService;
    
	@Autowired
	private CustomJwtAuthenticationFilter customJwtAuthenticationFilter;
	
	@Autowired
  	private JwtAuthenticationEntryPoint unauthorizedHandler;
    
    @Bean
    public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}


    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.csrf().disable().authorizeRequests()
    	.antMatchers("/authenticate").permitAll()
    	.antMatchers("/Client*").hasAnyRole("ADMIN","USER")
    	.antMatchers("/Client*").hasAnyRole("ADMIN","USER")
    	.antMatchers("/ServicesOn*").hasAnyRole("ADMIN","USER")
    	.antMatchers("/Products*").hasAnyRole("ADMIN","USER")
    	.antMatchers("//Person").hasAuthority("ADMIN")
        .antMatchers("/helloadmin").hasAuthority("ADMIN")
        .antMatchers("/hellouser").hasAuthority("USER")
        
        .anyRequest().authenticated()
      	.and().exceptionHandling()
        .authenticationEntryPoint(unauthorizedHandler).and()
      	.sessionManagement()
      	.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
      	http.addFilterBefore(customJwtAuthenticationFilter, 
      	UsernamePasswordAuthenticationFilter.class);
    }
      		

}

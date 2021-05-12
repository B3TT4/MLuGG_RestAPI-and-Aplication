package com.rmp.MLuGG.Details;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.rmp.MLuGG.Models.Person;

public class CustomUserDetails implements UserDetails{
	
	private Person person;
	
	    public CustomUserDetails(Person person) {
	        super();
	        this.person = person;
	    }
	 
	 	@Override
	    public Collection<? extends GrantedAuthority> getAuthorities() {
	        return Collections.singleton(new SimpleGrantedAuthority(person.getRole()));
	    }

	    @Override
	    public String getPassword() {
	        return person.getPassword();
	    }

	    @Override
	    public String getUsername() {
	        return person.getUsername();
	    }

	    @Override
	    public boolean isAccountNonExpired() {
	        return true;
	    }

	    @Override
	    public boolean isAccountNonLocked() {
	        return true;
	    }

	    @Override
	    public boolean isCredentialsNonExpired() {
	        return true;
	    }

	    @Override
	    public boolean isEnabled() {
	        return true;
	    }

}

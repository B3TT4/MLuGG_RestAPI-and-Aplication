package com.rmp.MLuGG.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.rmp.MLuGG.Details.CustomUserDetails;
import com.rmp.MLuGG.Models.Person;
import com.rmp.MLuGG.Repositories.PersonRespository;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private PersonRespository personRepository;
	

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Person person = personRepository.findByUsername(username);
        if(person == null) {
            throw new UsernameNotFoundException("Usuário não encontrado");
        }
        return new CustomUserDetails(person);
    }
    
}

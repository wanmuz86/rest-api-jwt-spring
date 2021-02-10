package com.anak2u.restapijwt.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.anak2u.restapijwt.entity.User;
import com.anak2u.restapijwt.repository.UserRepository;
import com.anak2u.restapijwt.security.services.UserPrinciple;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
    UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username)
                .orElseThrow(() -> 
                      new UsernameNotFoundException("User Not Found with -> username or email : " + username)
      );

      return UserPrinciple.build(user);
	}


	
	

}

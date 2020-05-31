package com.kj.userservice.services;

import com.kj.userservice.models.User;
import com.kj.userservice.repositories.UserRepository;
import com.kj.userservice.utils.enums.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MongoUserService implements UserDetailsService {
//    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private final UserRepository userRepository;

    @Autowired
    public MongoUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByUsername(username);
//
//        if(user == null) {
//            throw new UsernameNotFoundException("User not found");
//        }
//
//        List<GrantedAuthority> authorityList = getAuthorityList(user.getRoles());
//
//        return buildUserForAuthentication(user, authorityList);
        return null;
    }


    // TODO make utils or nah idk
    private List<GrantedAuthority> getAuthorityList(List<UserRole> roleList) {
        return roleList.stream().map(role -> new SimpleGrantedAuthority(role.name())).collect(Collectors.toList());
    }

    private UserDetails buildUserForAuthentication(User user, List<GrantedAuthority> authorityList) {
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorityList);
    }
}

package com.kj.authservice.services;

import com.kj.authservice.models.User;
import com.kj.authservice.repositories.UserRepository;
import com.kj.authservice.utils.enums.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    BCryptPasswordEncoder encoder;
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if(user == null) {
            throw new UsernameNotFoundException("No such user exists");
        }

        List<GrantedAuthority> authorityList = getAuthorityList(user.getRoles());

        return buildUserForAuthentication(user, authorityList);
    }

    // TODO Probably needs common service
    private List<GrantedAuthority> getAuthorityList(List<UserRole> roleList) {
        return roleList.stream().map(role -> new SimpleGrantedAuthority(role.name())).collect(Collectors.toList());
    }

    private UserDetails buildUserForAuthentication(User user, List<GrantedAuthority> authorityList) {
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorityList);
    }
}

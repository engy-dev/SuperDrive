package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.UserMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.SuperUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SuperUser superUser = userMapper.findByUsername(username);
        if (superUser == null) {
            throw new UsernameNotFoundException("");
        }
        return superUser;
    }

    public SuperUser register(SuperUser superUser) throws Exception {
        String encodedPassword = passwordEncoder.encode(superUser.getPassword());
        superUser.setPassword(encodedPassword);
        superUser.setEnabled(true);
        superUser.setRole("USER");
        try {
            userMapper.insertUser(superUser);
        } catch (Exception e) {
            throw e;
        }
        return superUser;
    }
}

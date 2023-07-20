package com.quotalab.snsclone.global.security.principle;

import com.quotalab.snsclone.domain.user.domain.User;
import com.quotalab.snsclone.domain.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthDetailService implements UserDetailsService {

    private final UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username){
        User user = userRepository.findById(Long.parseLong(username)).orElseThrow(()-> CustomUsernameNotFoundException.EXCEPTION);
        return new AuthDetails(user);
    }
}

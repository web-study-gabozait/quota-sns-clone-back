package com.quotalab.snsclone.global.security.util;

import com.quotalab.snsclone.domain.user.domain.User;
import com.quotalab.snsclone.domain.user.domain.repository.UserRepository;
import com.quotalab.snsclone.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SecurityUtil {

        private final UserRepository userRepository;

        public User getCurrentUser() {
            Long seq = Long.parseLong(SecurityContextHolder.getContext().getAuthentication().getName());
            return userRepository.findById(seq).orElseThrow(() -> UserNotFoundException.EXCEPTION);
        }

}

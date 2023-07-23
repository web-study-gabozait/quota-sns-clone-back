package com.quotalab.snsclone.domain.auth.service;

import com.quotalab.snsclone.domain.auth.exception.NotJoinUserException;
import com.quotalab.snsclone.domain.auth.exception.PasswordNotMatchException;
import com.quotalab.snsclone.domain.auth.exception.UserEmailExistsException;
import com.quotalab.snsclone.domain.auth.presentation.dto.request.CreateUserRequest;
import com.quotalab.snsclone.domain.auth.presentation.dto.request.LoginRequest;
import com.quotalab.snsclone.domain.auth.presentation.dto.response.LoginResponse;
import com.quotalab.snsclone.domain.user.domain.User;
import com.quotalab.snsclone.domain.user.domain.repository.UserRepository;
import com.quotalab.snsclone.domain.user.exception.UserNotFoundException;
import com.quotalab.snsclone.domain.user.presentation.dto.response.UserResponse;
import com.quotalab.snsclone.global.annotation.ServiceWithTransactionalReadOnly;
import com.quotalab.snsclone.global.enums.JWT;
import com.quotalab.snsclone.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

@ServiceWithTransactionalReadOnly
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void join(CreateUserRequest request) {

            if(userRepository.existsByEmail(request.getEmail())) {
                throw UserEmailExistsException.EXCEPTION;
            }

            String pw = passwordEncoder.encode(request.getPasswd());
            User user = User.builder()
                    .name(request.getName())
                    .email(request.getEmail())
                    .passwd(pw)
                    .profile_image_url(request.getProfile_image_url())
                    .build();

            userRepository.save(user);
    }

    @Transactional
    public LoginResponse login(LoginRequest request) {
        if(!userRepository.existsByEmail(request.getEmail())) {
            throw NotJoinUserException.EXCEPTION;
        }

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        if(!passwordEncoder.matches(request.getPasswd(), user.getPasswd())) {
            throw PasswordNotMatchException.EXCEPTION;
        }

        user.increaseLoginCount();

        User increasedUser = userRepository.save(user);

        String accessToken = jwtTokenProvider.generateToken(increasedUser.getSeq(), JWT.ACCESS);

        return LoginResponse.builder()
                .user(new UserResponse(increasedUser))
                .accessToken(accessToken)
                .build();
    }

}

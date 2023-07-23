package com.quotalab.snsclone.domain.user.service;

import com.quotalab.snsclone.domain.user.domain.User;
import com.quotalab.snsclone.domain.user.domain.repository.UserRepository;
import com.quotalab.snsclone.domain.user.presentation.dto.request.ExistsEmailRequest;
import com.quotalab.snsclone.domain.user.presentation.dto.response.UserResponse;
import com.quotalab.snsclone.global.annotation.ServiceWithTransactionalReadOnly;
import com.quotalab.snsclone.global.security.util.SecurityUtil;
import lombok.RequiredArgsConstructor;

@ServiceWithTransactionalReadOnly
@RequiredArgsConstructor
public class UserService {

    private final SecurityUtil securityUtil;
    private final UserRepository userRepository;

    public UserResponse getMyUserInfo() {
        return new UserResponse(securityUtil.getCurrentUser());
    }

    public boolean existsEmail(ExistsEmailRequest request) {

        boolean isExistEmail = userRepository.existsByEmail(request.getEmail());

        return isExistEmail;
    }

}

package com.quotalab.snsclone.domain.user.service;

import com.quotalab.snsclone.domain.user.domain.User;
import com.quotalab.snsclone.domain.user.presentation.dto.response.UserResponse;
import com.quotalab.snsclone.global.annotation.ServiceWithTransactionalReadOnly;
import com.quotalab.snsclone.global.security.util.SecurityUtil;
import lombok.RequiredArgsConstructor;

@ServiceWithTransactionalReadOnly
@RequiredArgsConstructor
public class UserService {

    private final SecurityUtil securityUtil;

    public UserResponse getMyUserInfo() {
        return new UserResponse(securityUtil.getCurrentUser());
    }

}

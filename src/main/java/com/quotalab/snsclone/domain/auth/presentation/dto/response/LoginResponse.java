package com.quotalab.snsclone.domain.auth.presentation.dto.response;

import com.quotalab.snsclone.domain.user.presentation.dto.response.UserResponse;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoginResponse {

    private UserResponse user;
    private String accessToken;

}

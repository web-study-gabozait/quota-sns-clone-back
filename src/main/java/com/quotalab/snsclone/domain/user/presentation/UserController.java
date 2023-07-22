package com.quotalab.snsclone.domain.user.presentation;

import com.quotalab.snsclone.domain.user.presentation.dto.response.UserResponse;
import com.quotalab.snsclone.domain.user.service.UserService;
import com.quotalab.snsclone.global.annotation.AuthenticationCheck;
import com.quotalab.snsclone.global.response.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor
public class UserController {

    private UserService userService;

    @AuthenticationCheck
    @GetMapping("/me")
    public ResponseData<UserResponse> getMyInfo() {
        UserResponse response = userService.getMyUserInfo();
        return new ResponseData<>(
                HttpStatus.OK,
                "내 유저 정보 조회 성공",
                response
        );
    }

}

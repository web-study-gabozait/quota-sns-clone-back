package com.quotalab.snsclone.domain.auth.presentation;

import com.quotalab.snsclone.domain.auth.presentation.dto.request.CreateUserRequest;
import com.quotalab.snsclone.domain.auth.presentation.dto.request.LoginRequest;
import com.quotalab.snsclone.domain.auth.presentation.dto.response.LoginResponse;
import com.quotalab.snsclone.domain.auth.service.AuthService;
import com.quotalab.snsclone.global.response.Response;
import com.quotalab.snsclone.global.response.ResponseData;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseData<LoginResponse> login(
            @RequestBody @Valid LoginRequest request
    ) {
        LoginResponse response = authService.login(request);
        return new ResponseData<>(
                HttpStatus.CREATED,
                "로그인 성공",
                response
        );
    }

    @PostMapping("/join")
    public Response join(
            @RequestBody @Valid CreateUserRequest request
    ) {
        authService.join(request);
        return new Response(
                HttpStatus.CREATED,
                "회원가입 성공"
        );
    }


}

package com.quotalab.snsclone.domain.user.exception.error;

import com.quotalab.snsclone.global.exception.ErrorProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum UserExceptionCode implements ErrorProperty {

    USER_NAME_NOT_FOUND(404, "Username Not Found"),
    USER_NOT_FOUND(404, "해당 유저는 존재하지 않습니다"),
    USER_EMAIL_EXIST(409, "해당 이메일은 이미 존재합니다");

    private final int status;
    private final String message;

}

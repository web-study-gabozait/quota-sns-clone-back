package com.quotalab.snsclone.domain.auth.exception.error;

import com.quotalab.snsclone.global.exception.ErrorProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public enum AuthExceptionCode implements ErrorProperty {

    EMAIL_EXIST(403, "이미 가입된 이메일입니다"),
    NOT_JOIN_USER(400, "가입되지 않은 이메일입니다"),
    PASSWORD_NOT_MATCH(400, "비밀번호가 일치하지 않습니다");

    private final int status;
    private final String message;
}

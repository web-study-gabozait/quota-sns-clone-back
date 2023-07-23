package com.quotalab.snsclone.domain.auth.exception;

import com.quotalab.snsclone.domain.auth.exception.error.AuthExceptionCode;
import com.quotalab.snsclone.global.exception.CustomException;

public class PasswordNotMatchException extends CustomException {


    private PasswordNotMatchException() {
        super(AuthExceptionCode.PASSWORD_NOT_MATCH);
    }

    public static final CustomException EXCEPTION = new PasswordNotMatchException();

}

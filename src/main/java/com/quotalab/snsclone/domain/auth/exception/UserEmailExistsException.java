package com.quotalab.snsclone.domain.auth.exception;

import com.quotalab.snsclone.domain.auth.exception.error.AuthExceptionCode;
import com.quotalab.snsclone.domain.user.exception.error.UserExceptionCode;
import com.quotalab.snsclone.global.exception.CustomException;

public class UserEmailExistsException extends CustomException {

    public static final  CustomException EXCEPTION = new UserEmailExistsException();

    private UserEmailExistsException() {
        super(AuthExceptionCode.EMAIL_EXIST);
    }
}

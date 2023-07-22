package com.quotalab.snsclone.domain.user.exception;

import com.quotalab.snsclone.domain.user.exception.error.UserExceptionCode;
import com.quotalab.snsclone.global.exception.CustomException;

public class UserNotFoundException extends CustomException {

    public static final CustomException EXCEPTION = new UserNotFoundException();

    private  UserNotFoundException() {
        super(UserExceptionCode.USER_NOT_FOUND);
    }
}

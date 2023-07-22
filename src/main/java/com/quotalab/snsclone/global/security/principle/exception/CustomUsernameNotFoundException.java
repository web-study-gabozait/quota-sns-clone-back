package com.quotalab.snsclone.global.security.principle.exception;

import com.quotalab.snsclone.domain.user.exception.error.UserExceptionCode;
import com.quotalab.snsclone.global.exception.CustomException;

public class CustomUsernameNotFoundException extends CustomException {

    private CustomUsernameNotFoundException() {
        super(UserExceptionCode.USER_NAME_NOT_FOUND);
    }

    public static final CustomException EXCEPTION = new CustomUsernameNotFoundException();
}

package com.quotalab.snsclone.domain.auth.exception;

import com.quotalab.snsclone.domain.auth.exception.error.AuthExceptionCode;
import com.quotalab.snsclone.global.exception.CustomException;

public class NotJoinUserException extends CustomException  {

    public static final CustomException EXCEPTION = new NotJoinUserException();

    private NotJoinUserException() {
        super(AuthExceptionCode.NOT_JOIN_USER);
    }

}

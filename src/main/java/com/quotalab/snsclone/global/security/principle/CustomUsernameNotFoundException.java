package com.quotalab.snsclone.global.security.principle;

import com.quotalab.snsclone.global.exception.CustomException;
import org.springframework.http.HttpStatus;

public class CustomUsernameNotFoundException extends CustomException {

    private CustomUsernameNotFoundException() {
        super();
    }

    public static final CustomException EXCEPTION = new CustomUsernameNotFoundException();
}

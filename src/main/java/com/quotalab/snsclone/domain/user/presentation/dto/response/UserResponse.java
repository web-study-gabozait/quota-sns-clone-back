package com.quotalab.snsclone.domain.user.presentation.dto.response;

import com.quotalab.snsclone.domain.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class UserResponse {

    private Long seq;
    private String name;
    private String email;
    private String profile_image_url;
    private int login_count;
    private LocalDateTime last_login_at;
    private LocalDateTime create_at;

    public  UserResponse(User user) {
        this.seq = user.getSeq();
        this.email = user.getEmail();
        this.name = user.getName();
        this.profile_image_url = user.getProfile_image_url();
        this.last_login_at = user.getLast_login_at();
        this.create_at = user.getCreate_at();
        this.login_count = user.getLogin_count();
    }

}

package com.quotalab.snsclone.domain.user.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity(name = "user")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    @Column
    private String name;

    @Column
    private String email;
    @Column
    private String passwd;

    @Column
    private String profile_image_url;

    @Column
    private int login_count;

    @Column
    private LocalDateTime last_login_at;

    @Column
    private LocalDateTime create_at;

    public void updatePasswd(String passwd) {
        this.passwd =passwd;
    }

    public void updateInfo(String profile_image_url, String email) {
        this.profile_image_url = profile_image_url;
        this.email = email;
    }

    public void updateLastLoginAt() {
        this.last_login_at = LocalDateTime.now();
    }

    public void increaseLoginCount() {
        this.login_count++;
    }

    @Builder
    public User(Long seq, String name, String passwd, String email, String profile_image_url) {
       this.seq = seq;
       this.name = name;
       this.passwd = passwd;
       this.email = email;
       this.profile_image_url = profile_image_url;
       this.create_at = LocalDateTime.now();
       this.login_count = 0;
    }

}

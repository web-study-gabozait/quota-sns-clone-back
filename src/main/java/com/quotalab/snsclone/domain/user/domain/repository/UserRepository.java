package com.quotalab.snsclone.domain.user.domain.repository;

import com.quotalab.snsclone.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface UserRepository extends JpaRepository<User, Long> {



}

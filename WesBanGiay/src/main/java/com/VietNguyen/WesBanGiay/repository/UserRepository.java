package com.VietNguyen.WesBanGiay.repository;

import com.VietNguyen.WesBanGiay.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmailAndPassword(String email, String password);

}

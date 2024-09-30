package com.example.PlayGround.PlayGround.Repo;

import com.example.PlayGround.PlayGround.DTO.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    User findByUserIdOrMobileOrEmail(Long userId, String mobile, String email);
    User findByMobileOrEmail(String mobile, String email);
}

package com.users.userservice.repository;

import com.users.userservice.model.Session;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {

 Optional<Session> findByTokenAndUser_Id(String token, Long user_id);

}
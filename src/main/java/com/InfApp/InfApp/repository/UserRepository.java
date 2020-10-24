package com.InfApp.InfApp.repository;

import com.InfApp.InfApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository//do dodawnia uzywnikow
public interface UserRepository extends JpaRepository <User, Long> {
}

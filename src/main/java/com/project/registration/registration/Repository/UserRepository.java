package com.project.registration.registration.Repository;

import com.project.registration.registration.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

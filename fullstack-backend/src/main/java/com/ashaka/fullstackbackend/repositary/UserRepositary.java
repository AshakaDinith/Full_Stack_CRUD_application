package com.ashaka.fullstackbackend.repositary;

import com.ashaka.fullstackbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositary extends JpaRepository<User,Long> {
}

package com.example.ApiClassRomm.repository;

import com.example.ApiClassRomm.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepositorie extends JpaRepository<User,Integer> {
}

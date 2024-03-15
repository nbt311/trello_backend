package com.example.trellobackend.repositories;

import com.example.trellobackend.dto.UserDTO;
import com.example.trellobackend.models.Role;
import com.example.trellobackend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
    @Query("SELECT new com.example.trellobackend.dto.UserDTO(u.id,u.username, u.email, u.avatarUrl) FROM User u WHERE u.username LIKE %:query% OR u.email LIKE %:query%")
    List<UserDTO> findUsersByPartialMatch(@Param("query") String query);

    List<User> findByRoles(Role role);
}

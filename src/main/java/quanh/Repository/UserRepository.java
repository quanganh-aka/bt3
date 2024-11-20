package quanh.Repository;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import quanh.Entity.Users;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    // Custom query to get user by username using JPQL
    @Query("SELECT u FROM Users u WHERE u.username = :username")
    Users getUserByUsername(@Param("username") String username);

    // Find user by email
    Optional<Users> findByEmail(String email);

    // Find user by username or email
    Optional<Users> findByUsernameOrEmail(String username, String email);

    // Find user by username
    Optional<Users> findByUsername(String username);

    // Check if a username exists
    Boolean existsByUsername(String username);

    // Check if an email exists
    Boolean existsByEmail(String email);
}


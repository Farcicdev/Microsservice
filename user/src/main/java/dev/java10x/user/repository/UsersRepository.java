package dev.java10x.user.repository;

import dev.java10x.user.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsersRepository extends JpaRepository<Users, UUID> {
}

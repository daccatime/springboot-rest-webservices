package net.javaguides.springbootrestwebservices.repository;

import net.javaguides.springbootrestwebservices.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}

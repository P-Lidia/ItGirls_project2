package ru.itgirls.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itgirls.core.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}

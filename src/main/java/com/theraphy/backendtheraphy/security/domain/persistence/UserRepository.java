package com.theraphy.backendtheraphy.security.domain.persistence;

import com.theraphy.backendtheraphy.security.domain.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    User findByType(String type);
    User findByEmail(String email);
}

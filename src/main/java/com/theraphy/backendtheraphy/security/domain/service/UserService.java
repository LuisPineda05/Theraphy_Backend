package com.theraphy.backendtheraphy.security.domain.service;


import com.theraphy.backendtheraphy.security.domain.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    List<User> getAll();
    Page<User> getAll(Pageable pageable);
    User getById(Long userId);
    User create(User user);


}
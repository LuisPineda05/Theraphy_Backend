package com.theraphy.backendtheraphy.security.service;

import com.theraphy.backendtheraphy.security.domain.model.entity.User;
import com.theraphy.backendtheraphy.security.domain.persistence.UserRepository;
import com.theraphy.backendtheraphy.security.domain.service.UserService;
import com.theraphy.backendtheraphy.shared.exception.ResourceNotFoundException;
import com.theraphy.backendtheraphy.shared.exception.ResourceValidationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private static final String ENTITY = "User";

    private final UserRepository userRepository;

    private final Validator validator;

    public UserServiceImpl(UserRepository userRepository, Validator validator) {
        this.userRepository = userRepository;
        this.validator = validator;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Page<User> getAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public User getById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, userId));
    }

    @Override
    public User create(User user) {

        Set<ConstraintViolation<User>> violations = validator.validate(user);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        // Name Uniqueness validation
        User userWithEmail = userRepository.findByEmail(user.getEmail());

        if(userWithEmail != null)
            throw new ResourceValidationException(ENTITY,
                    "This email is already linked to another account.");

        return userRepository.save(user);
    }
}

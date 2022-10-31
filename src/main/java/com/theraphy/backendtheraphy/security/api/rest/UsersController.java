package com.theraphy.backendtheraphy.security.api.rest;

import com.theraphy.backendtheraphy.security.domain.service.UserService;
import com.theraphy.backendtheraphy.security.mapping.UserMapper;
import com.theraphy.backendtheraphy.security.resource.CreateUserResource;
import com.theraphy.backendtheraphy.security.resource.UserResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/users", produces = "application/json")
public class UsersController {
    private final UserService userService;

    private final UserMapper mapper;

    public UsersController(UserService userService, UserMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    /*


    @PostMapping
    public UserResource createUser(@RequestBody CreateUserResource resource) {
        return mapper.toResource(userService.create(mapper.toModel(resource)));
    }

    */
    @GetMapping
    public Page<UserResource> getAllUsers(Pageable pageable) {
        return mapper.modelListPage(userService.getAll(), pageable);
    }

    @GetMapping("{studentId}")
    public UserResource getUserById(@PathVariable Long userId) {
        return mapper.toResource(userService.getById(userId));
    }

    @PostMapping
    public ResponseEntity<UserResource> createStudent(@RequestBody CreateUserResource resource) {
        return new ResponseEntity<>(mapper.toResource(userService.create(mapper.toModel(resource))), HttpStatus.CREATED);
    }



}

package com.triptogether.api.user.controller;

import com.triptogether.api.common.model.User;
import com.triptogether.api.common.dto.ResponseData;
import com.triptogether.api.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<ResponseData<User>> getUserProfile(@PathVariable("userId") String userId) {
        ResponseData<User> response = userService.getUserProfile(userId);
        return ResponseEntity.ok(response);
    }
}

package com.busbooking.controller;
import com.busbooking.dto.ApiResponse;
import com.busbooking.model.User;
import com.busbooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired private UserService userService;

    @PostMapping("/register")
    public ApiResponse<?> register(@RequestBody User user) {
        try {
            User saved = userService.register(user);
            saved.setPassword(null);
            return new ApiResponse<>(true, "Registration successful!", saved);
        } catch (Exception e) {
            return new ApiResponse<>(false, e.getMessage(), null);
        }
    }

    @PostMapping("/login")
    public ApiResponse<?> login(@RequestBody Map<String, String> body) {
        try {
            User user = userService.login(body.get("email"), body.get("password"));
            user.setPassword(null);
            return new ApiResponse<>(true, "Login successful!", user);
        } catch (Exception e) {
            return new ApiResponse<>(false, e.getMessage(), null);
        }
    }

    @GetMapping
    public ApiResponse<?> getAllUsers() {
        return new ApiResponse<>(true, "Success", userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ApiResponse<?> getUserById(@PathVariable Long id) {
        return userService.getUserById(id)
            .map(u -> new ApiResponse<>(true, "Success", (Object)u))
            .orElse(new ApiResponse<>(false, "User not found", null));
    }
}

package com.busbooking.service;
import com.busbooking.model.User;
import com.busbooking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class UserService {
    @Autowired private UserRepository userRepository;

    public User register(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already registered!");
        }
        return userRepository.save(user);
    }

    public User login(String email, String password) {
        Optional<User> userOpt = userRepository.findByEmail(email);
        if (userOpt.isPresent() && password.equals(userOpt.get().getPassword())) {
            return userOpt.get();
        }
        throw new RuntimeException("Invalid email or password!");
    }

    public List<User> getAllUsers() { return userRepository.findAll(); }
    public Optional<User> getUserById(Long id) { return userRepository.findById(id); }
}

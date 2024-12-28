package com.example.users_store;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @TrackUserAction
    public List<User> findall() {
        return userRepository.findAll();
    }

    @TrackUserAction
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @TrackUserAction
    public User save(User user) {
        return userRepository.save(user);
    }

    @TrackUserAction
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}

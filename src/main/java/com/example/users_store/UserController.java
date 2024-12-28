package com.example.users_store;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @TrackUserAction
    public List<User> findAll(){
        return userService.findall();
    }

    @GetMapping("/{id}")
    @TrackUserAction
    public ResponseEntity<User> findById(@PathVariable Long id){
        Optional<User> user = userService.findById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @TrackUserAction
    public User save(@RequestBody User user){
        return userService.save(user);
    }

    @PutMapping("/{id}")
    @TrackUserAction
    public User update(@RequestBody User user, @PathVariable Long id){
        user.setId(id);
        return userService.save(user);
    }

    @DeleteMapping("/{id}")
    @TrackUserAction
    public void deleteById(@PathVariable Long id){
        userService.deleteById(id);
    }
}

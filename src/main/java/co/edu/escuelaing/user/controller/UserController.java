package co.edu.escuelaing.user.controller;

import co.edu.escuelaing.user.dto.UserRequest;
import co.edu.escuelaing.user.dto.UserResponse;
import co.edu.escuelaing.user.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService svc;

    public UserController(UserService svc) {
        this.svc = svc;
    }

    @PostMapping
    public UserResponse create(@RequestBody UserRequest req) {
        return svc.create(req);
    }

    @GetMapping
    public List<UserResponse> findAll() {
        return svc.findAll();
    }

    @GetMapping("/{id}")
    public UserResponse findById(@PathVariable UUID id) {
        return svc.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        svc.delete(id);
    }
}

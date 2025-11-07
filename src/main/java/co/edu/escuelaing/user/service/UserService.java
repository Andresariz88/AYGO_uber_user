package co.edu.escuelaing.user.service;

import co.edu.escuelaing.user.dto.UserRequest;
import co.edu.escuelaing.user.dto.UserResponse;
import co.edu.escuelaing.user.entity.UserEntity;
import co.edu.escuelaing.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public UserResponse create(UserRequest u) {
        UserEntity e = new UserEntity();
        e.setName(u.getName());
        e.setEmail(u.getEmail());
        e.setPhone(u.getPhone());
        repo.save(e);

        return new UserResponse(e.getId(), e.getName(), e.getEmail(), e.getPhone());
    }

    public List<UserResponse> findAll() {
        return repo.findAll().stream()
                .map(e -> new UserResponse(e.getId(), e.getName(), e.getEmail(), e.getPhone()))
                .toList();
    }

    public UserResponse findById(UUID id) {
        UserEntity e = repo.findById(id).orElseThrow();
        return new UserResponse(e.getId(), e.getName(), e.getEmail(), e.getPhone());
    }

    public void delete(UUID id) {
        repo.deleteById(id);
    }
}

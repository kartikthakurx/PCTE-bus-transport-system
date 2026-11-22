package com.pcte.transport.controller;

import com.pcte.transport.entity.User;
import com.pcte.transport.repo.UserRepo;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = {"http://localhost:5500", "http://127.0.0.1:5500"})
@RequiredArgsConstructor
public class UserController {

  private final UserRepo userRepo;

  // List users (for admin panel)
  @GetMapping
  public List<User> all() {
    return userRepo.findAll();
  }

  // Register
  @PostMapping
  public ResponseEntity<?> create(@RequestBody User u) {
    // Basic checks
    if (u.getEmail() == null || u.getPassword() == null || u.getName() == null) {
      return ResponseEntity.badRequest().body("Missing fields");
    }
    // Default role
    if (u.getRole() == null || u.getRole().isBlank()) {
      u.setRole("USER");
    }
    // Ensure insert
    u.setId(null);
    // TODO: hash password before saving
    try {
      User saved = userRepo.save(u);
      // Do not return password to clients
      saved.setPassword(null);
      return ResponseEntity.ok(saved);
    } catch (Exception ex) {
      return ResponseEntity.badRequest().body("Email may already exist");
    }
  }

  // Update user
  @PutMapping("/{id}")
  public ResponseEntity<?> update(@PathVariable Long id, @RequestBody User u) {
    User cur = userRepo.findById(id).orElse(null);
    if (cur == null) return ResponseEntity.notFound().build();

    if (u.getName() != null) cur.setName(u.getName());
    if (u.getEmail() != null) cur.setEmail(u.getEmail());
    if (u.getRole() != null) cur.setRole(u.getRole());
    if (u.getPassword() != null && !u.getPassword().isBlank()) {
      cur.setPassword(u.getPassword());
    }

    User saved = userRepo.save(cur);
    saved.setPassword(null);
    return ResponseEntity.ok(saved);
  }

  // Delete user
  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    userRepo.deleteById(id);
  }

  // Login
@PostMapping("/login")
public ResponseEntity<?> login(@RequestBody LoginDTO cred) {
  if (cred.getEmail() == null || cred.getPassword() == null) {
    return ResponseEntity.badRequest().body("Missing credentials");
  }

  var opt = userRepo.findByEmail(cred.getEmail());
  if (opt.isEmpty()) {
    return ResponseEntity.status(401).body("Invalid email or password");
  }

  var db = opt.get();
  if (!db.getPassword().equals(cred.getPassword())) { // TODO: use hash later
    return ResponseEntity.status(401).body("Invalid email or password");
  }

  db.setPassword(null); // never return password to client
  return ResponseEntity.ok(db);
}

  @Data
  public static class LoginDTO {
    private String email;
    private String password;
  }
}

package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    public enum Role {
        ADMIN, INSTRUCTOR, STUDENT
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    // -------- getters & setters --------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    // -------- builder (keeps TestNG safe) --------
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final User u = new User();

        public Builder id(Long id) {
            u.setId(id);
            return this;
        }

        public Builder fullName(String fullName) {
            u.setFullName(fullName);
            return this;
        }

        public Builder email(String email) {
            u.setEmail(email);
            return this;
        }

        public Builder password(String password) {
            u.setPassword(password);
            return this;
        }

        public Builder role(Role role) {
            u.setRole(role);
            return this;
        }

        public User build() {
            return u;
        }
    }
}

package com.example.demo.entity;

public class User {

    public enum Role { ADMIN, INSTRUCTOR, STUDENT }

    private Long id;
    private String fullName;
    private String email;
    private String password;
    private Role role;

    // ✅ REQUIRED GETTERS & SETTERS
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }

    // builder used in tests
    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private final User u = new User();
        public Builder id(Long id){ u.setId(id); return this; }
        public Builder fullName(String n){ u.setFullName(n); return this; }
        public Builder email(String e){ u.setEmail(e); return this; }
        public Builder password(String p){ u.setPassword(p); return this; }
        public Builder role(Role r){ u.setRole(r); return this; }
        public User build(){ return u; }
    }
}

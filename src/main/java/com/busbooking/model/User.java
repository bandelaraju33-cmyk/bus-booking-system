package com.busbooking.model;
import jakarta.persistence.*;
@Entity
@Table(name = "users")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String name;
    @Column(unique = true) private String email;
    private String password;
    private String phone;
    private String role = "USER";
    public Long getUserId() { return userId; }
    public void setUserId(Long v) { this.userId = v; }
    public String getName() { return name; }
    public void setName(String v) { this.name = v; }
    public String getEmail() { return email; }
    public void setEmail(String v) { this.email = v; }
    public String getPassword() { return password; }
    public void setPassword(String v) { this.password = v; }
    public String getPhone() { return phone; }
    public void setPhone(String v) { this.phone = v; }
    public String getRole() { return role; }
    public void setRole(String v) { this.role = v; }
}

package com.horus.yoga.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.horus.yoga.config.Auditable;
import com.horus.yoga.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "yoga_user")
public class User extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "first_name", length = 50, nullable = false)
    @Size(min = 3)
    private String firstName;

    @Column(name = "last_name", length = 50, nullable = false)
    @Size(min = 3)
    private String lastName;

    @Column(unique = true, nullable = false, length = 11)
    @Pattern(regexp = "\\+?[0-9]+", message = "Invalid phone number")
    private String phone;

    @Column(unique = true, nullable = false)
    @Email
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(nullable = false)
    private String password;

    private String nationality;

    @Column(name = "date_of_birth", nullable = false)
    private Date dateOfBirth;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @JsonIgnore
    @OneToMany(mappedBy="user",fetch=FetchType.EAGER)
    private Set<Authority> authorities;

    public UUID getId() {
        return id;
    }

    public User setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public User setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getNationality() {
        return nationality;
    }

    public User setNationality(String nationality) {
        this.nationality = nationality;
        return this;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public User setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public Role getRole() {
        return role;
    }

    public User setRole(Role role) {
        this.role = role;
        return this;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public User setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", nationality='" + nationality + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", role=" + role +
                ", authorities=" + authorities +
                '}';
    }
}

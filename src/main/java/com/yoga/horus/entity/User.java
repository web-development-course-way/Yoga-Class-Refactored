package com.yoga.horus.entity;

import com.yoga.horus.config.Auditable;
import com.yoga.horus.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="yoga_user")
public class User extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name="first_name",length = 50, nullable = false)
    @Size(min = 3)
    private String firstName;

    @Column(name="last_name",length = 50, nullable = false)
    @Size(min = 3)
    private String lastName;

    @Column(unique = true,nullable = false,length = 11)
    @Pattern(regexp = "\\+?[0-9]+", message = "Invalid phone number")
    private String phone;

    @Column(unique = true,nullable = false)
    @Email
    private String email;

    private String nationality;

    @Column(name="date_of_birth",nullable = false)
    private Date dateOfBirth;

    @Column(nullable = false)
    @Enumerated (EnumType.STRING)
    private Role role;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

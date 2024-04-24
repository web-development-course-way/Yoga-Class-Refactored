package com.horus.yoga.entity;

import com.horus.yoga.config.Auditable;
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

    private String nationality;

    @Column(name = "date_of_birth", nullable = false)
    private Date dateOfBirth;


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
}

package com.yoga.horus.entity;

import com.yoga.horus.enums.Role;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="users")
public class YogaUser {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name="first_name",length = 50, nullable = false)
    private String firstName;

    @Column(name="last_name",length = 50, nullable = false)
    private String lastName;

    @Column(unique = true,nullable = false)
    private String phone;

    @Column(unique = true,nullable = false)
    private String email;

    private String nationality;

    @Column(name="date_of_birth",nullable = false)
    private Date dateOfBirth;

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
}

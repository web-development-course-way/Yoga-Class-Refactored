package com.yoga.horus.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "class")
public class YogaClass {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(length = 100)
    private String description;

    @Column(nullable = false)
    private int duration;

    @Column(nullable = false)
    private int capacity;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}

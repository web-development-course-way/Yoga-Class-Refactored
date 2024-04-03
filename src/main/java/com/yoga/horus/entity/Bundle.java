package com.yoga.horus.entity;


import com.yoga.horus.config.Auditable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.UUID;

@Entity
@Table(name = "bundle")
public class Bundle extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false,length = 50,unique = true)
    @Size(min = 3)
    private String name;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private int numberOfClasses;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

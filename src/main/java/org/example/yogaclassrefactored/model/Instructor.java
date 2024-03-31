package org.example.yogaclassrefactored.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "instructor")
public class Instructor extends User { }

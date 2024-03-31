package com.yoga.horus.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

import java.util.UUID;

@Embeddable
public class AttendanceId {

    @Column(name = "user_id")
    private UUID userId;

    @Column(name = "class_id")
    private UUID yogaClassId;

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public UUID getYogaClassId() {
        return yogaClassId;
    }

    public void setYogaClassId(UUID yogaClassId) {
        this.yogaClassId = yogaClassId;
    }
}

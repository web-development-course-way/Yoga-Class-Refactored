package com.yoga.horus.entity;

import com.yoga.horus.config.Auditable;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table (name = "class_attendance")
public class Attendance extends Auditable {

    @EmbeddedId
    private AttendanceId id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User users;

    @ManyToOne
    @MapsId("yogaClassId")
    @JoinColumn(name = "class_id")
    private YogaClass yogaClass;

    @Column(name = "attendance_date",nullable = false)
    private Date attendanceDate;

    public AttendanceId getId() {
        return id;
    }

    public void setId(AttendanceId id) {
        this.id = id;
    }

    public User getYogaUser() {
        return users;
    }

    public void setYogaUser(User yogaUser) {
        this.users = yogaUser;
    }

    public YogaClass getYogaClass() {
        return yogaClass;
    }

    public void setYogaClass(YogaClass yogaClass) {
        this.yogaClass = yogaClass;
    }

    public Date getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(Date attendanceDate) {
        this.attendanceDate = attendanceDate;
    }
}

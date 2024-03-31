package com.yoga.horus.entity;

import com.yoga.horus.enums.PaymentMethod;
import com.yoga.horus.enums.PaymentStatus;
import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "payment")
public class YogaPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "subscription_id",nullable = false)
    @OneToMany
    private UUID subscriptionId;

    @Column(nullable = false)
    private int amount;

    @Column(name ="payment_date", nullable = false)
    private Date paymentDate;

    @Column(name = "payment_method",nullable = false)
    @Enumerated
    private PaymentMethod paymentMethod;

    @Column(name = "payment_status",nullable = false)
    @Enumerated
    private PaymentStatus paymentStatus;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(UUID subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}

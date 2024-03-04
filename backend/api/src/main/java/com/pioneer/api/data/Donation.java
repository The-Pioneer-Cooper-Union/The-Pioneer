package com.pioneer.api.data;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="donation")
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="donation_id", unique = true, nullable = false)
    private Long donationId;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    @Column(name="donation_comment")
    private String donationComment;

    @Column(name="donation_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date donationDate;

    @Column(name="donation_amount", nullable = false)
    private Long donationAmount;

    @Transient
    private Long userId;

    public Donation(Long donationId, User user, String donationComment, Date donationDate, Long donationAmount) {
        this.donationId = donationId;
        this.user = user;
        this.donationComment = donationComment;
        this.donationDate = donationDate;
        this.donationAmount = donationAmount;
    }

    public Donation() {

    }


    public Long getDonationId() {
        return donationId;
    }

    public void setDonationId(Long donationId) {
        this.donationId = donationId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDonationComment() {
        return donationComment;
    }

    public void setDonationComment(String donationComment) {
        this.donationComment = donationComment;
    }

    public Date getDonationDate() {
        return donationDate;
    }

    public void setDonationDate(Date donationDate) {
        this.donationDate = donationDate;
    }

    public Long getDonationAmount() {
        return donationAmount;
    }

    public void setDonationAmount(Long donationAmount) {
        this.donationAmount = donationAmount;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
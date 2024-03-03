package com.pioneer.api.data;
import jakarta.persistance.*;

@Entity
@Table(num="donation")
public class Donation {
    @Id
    @Column(name="donation_id", unique = true, nullable = false)
    private Long DonationId;
    
    @Column(name="user_id", nullable = false)
    private Long UserId;

    @Column(name="donation_comment")
    private String donation_comment;

    @Column(name="donation_date", nullable = false)
    private Date donation_date;

    @Column(name="donation_amount", nullable = false)
    private Long donation_amount;

    public Donation(Long DonationId, Long UserId, String donation_comment, 
    Date donation_date, Long donation_amount) {
        this.DonationId = DonationId;
        this.UserId = UserId;
        this.donation_comment = donation_comment;
        this.donation_date = donation_date;
        this.donation_amount = donation_amount;
    }

    public Donation() {

    }

    public Long getDonationId() {
        return DonationId;
    }

    public void setDonationId(Long DonationId) {
        this.DonationId = DonationId;
    }

    public Long getUserId() {
        return UserId;
    }

    public void setUserId(Long UserId) {
        this.UserId = UserId;
    }

    public String getDonationComment() {
        return donation_comment;
    }

    public void setDonationComment(String donation_comment) {
        this.donation_comment = donation_comment;
    }

    public Date getDonationDate() {
        return donation_date;
    }

    public void setDonationDate(Date donation_date) {
        this.donation_date = donation_date;
    }

    public Long getDonationAmount() {
        return donation_amount;
    }

    public void setDonationAmount(Long donation_amount) {
        this.donation_amount = donation_amount;
    }

}
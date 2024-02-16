package com.pioneer.api.data;

import jakarta.persistence.*;

@Entity
@Table(name="USERS")
public class users {
    @Id
    @Column(name="USER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @Column(name="USERNAME", unique = true, nullable = false)
    private String username;

    @Column(name="EMAIL", unique = true, nullable = false)
    private String email;

    @Column(name="PASSWORD_HASH", nullable = false)
    private String password_hash;

    @Enumerated(EnumType.STRING)
    @Column(name="USER_TYPE", nullable = false)
    private user_type user_type;

    @Enumerated(EnumType.STRING)
    @Column(name="MAJOR", nullable = false)
    private major major;

    @Column(name="GRADUATION_YEAR", nullable = false)
    private Integer graduation_year;

    @Column(name="PROFILE_PIC")
    private String profile_pic;

    @Column(name="SHORT_BIO")
    private String short_bio;

    // Getters and setters


    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword_hash() {
        return password_hash;
    }

    public void setPassword_hash(String password_hash) {
        this.password_hash = password_hash;
    }

    public com.pioneer.api.data.user_type getUser_type() {
        return user_type;
    }

    public void setUser_type(com.pioneer.api.data.user_type user_type) {
        this.user_type = user_type;
    }

    public com.pioneer.api.data.major getMajor() {
        return major;
    }

    public void setMajor(com.pioneer.api.data.major major) {
        this.major = major;
    }

    public Integer getGraduation_year() {
        return graduation_year;
    }

    public void setGraduation_year(Integer graduation_year) {
        this.graduation_year = graduation_year;
    }

    public String getProfile_pic() {
        return profile_pic;
    }

    public void setProfile_pic(String profile_pic) {
        this.profile_pic = profile_pic;
    }

    public String getShort_bio() {
        return short_bio;
    }

    public void setShort_bio(String short_bio) {
        this.short_bio = short_bio;
    }
}
package com.pioneer.api.business;

import com.pioneer.api.data.Donation;
import com.pioneer.api.data.DonationRepository;


import com.pioneer.api.data.User;
import com.pioneer.api.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class DonationService {

    private final DonationRepository donationRepository;
    private final UserRepository userRepository;

    @Autowired
    public DonationService(DonationRepository donationRepository, UserRepository userRepository) {
        this.donationRepository = donationRepository;
        this.userRepository = userRepository;
    }

    public Donation addDonation(Donation donation) {
        User user = userRepository.findById(donation.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with id " + donation.getUserId()));
        donation.setUser(user);
        return donationRepository.save(donation);
    }

    public void deleteDonation(Long donationId){
        donationRepository.deleteById(donationId);
    }

    public void updateDonationInfo(Donation donation) {
        User user = userRepository.findById(donation.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with id " + donation.getUserId()));
        donation.setUser(user);
        donationRepository.save(donation);
    }

    public Optional<Donation> findDonationByDonationId(Long donationId) {
        return donationRepository.findDonationByDonationId(donationId);
    }
}
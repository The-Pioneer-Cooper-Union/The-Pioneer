package com.pioneer.api.webservice;

import com.pioneer.api.business.DonationService;
import com.pioneer.api.data.Donation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/donation")
public class DonationController {

    private final DonationService donationService;

    @Autowired
    public DonationController(DonationService donationService) {
        this.donationService = donationService;
    }

    @PostMapping("/make-donation")
    public ResponseEntity<String> makeDonation(@RequestBody Donation donation) {
        try {
            Donation newDonation = donationService.addDonation(donation);
            return ResponseEntity.status(HttpStatus.CREATED).body("Donation made successfully. Donation ID: " + newDonation.getDonationId());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error making donation: " + e.getMessage());
        }
    }
    @DeleteMapping("/delete-donation/{donationId}")
    public ResponseEntity<String> removeDonation(@PathVariable Long donationId) {
        try {
            donationService.deleteDonation(donationId);
            return ResponseEntity.status(HttpStatus.OK).body("Donation deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error deleting Donation: " + e.getMessage());
        }
    }

    @PutMapping("/update-donation/{donationId}")
    public ResponseEntity<String> updateDonation(@PathVariable Long donationId, @RequestBody Donation donation) {
        try {
            // Set the userId of the user object to ensure it updates the existing user
            donation.setDonationId(donationId);
            donationService.updateDonationInfo(donation);
            return ResponseEntity.status(HttpStatus.OK).body("Donation Info updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error updating Donation Info: " + e.getMessage());
        }
    }

    @GetMapping("/donation-info/{donationId}")
    public ResponseEntity<Donation> getDonationInfo(@PathVariable Long donationId) {
        try {
            Optional<Donation> donation = donationService.findDonationByDonationId(donationId);

            return donation.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

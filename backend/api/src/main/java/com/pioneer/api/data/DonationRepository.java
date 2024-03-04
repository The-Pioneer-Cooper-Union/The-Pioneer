package com.pioneer.api.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long>  {

    Optional<Donation> findDonationByDonationId(Long userId);

}
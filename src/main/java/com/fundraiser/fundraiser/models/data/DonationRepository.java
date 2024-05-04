package com.fundraiser.fundraiser.models.data;

import com.fundraiser.fundraiser.models.Donation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonationRepository extends CrudRepository<Donation, Integer> {
}

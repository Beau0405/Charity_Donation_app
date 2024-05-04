package com.fundraiser.fundraiser.models.data;

import com.fundraiser.fundraiser.models.Campaign;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampaignRepository extends CrudRepository<Campaign, Integer> {
}

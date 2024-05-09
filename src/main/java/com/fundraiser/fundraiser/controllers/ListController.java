package com.fundraiser.fundraiser.controllers;

import com.fundraiser.fundraiser.models.Campaign;
import com.fundraiser.fundraiser.models.data.CampaignRepository;
import com.fundraiser.fundraiser.models.data.DonationRepository;
import com.fundraiser.fundraiser.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Optional;

@Controller
@RequestMapping(value = "list")
public class ListController {
    @Autowired
    private CampaignRepository campaignRepository;
    @Autowired
    private DonationRepository donationRepository;
    @Autowired
    private UserRepository userRepository;

    static HashMap<String, String> columnNames = new HashMap<>();

    public ListController(){
        columnNames.put("all", "All Active Campaigns");

    }

    @GetMapping("")
    public String list(Model model, Campaign campaign){
        Iterable<Campaign> campaigns;
        campaigns = campaignRepository.findAll();
        model.addAttribute("campaigns", campaigns);
        return "list";
    }

    @PostMapping("")
    public String campaignLinkRedirect(Model model, @PathVariable int campaignId){
        Optional<Campaign> campaign = campaignRepository.findById(campaignId);
        model.addAttribute("campaign", campaign);
         return "redirect:campaign/view/" + campaignId;
    }

}

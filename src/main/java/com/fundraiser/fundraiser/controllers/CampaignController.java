package com.fundraiser.fundraiser.controllers;

import com.fundraiser.fundraiser.models.Campaign;
import com.fundraiser.fundraiser.models.data.CampaignRepository;
import com.fundraiser.fundraiser.models.data.DonationRepository;
import com.fundraiser.fundraiser.models.data.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Scope("session")
@RequestMapping("/campaign")
public class CampaignController {

    @Autowired
    private CampaignRepository campaignRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DonationRepository donationRepository;

    @GetMapping("create")
    public String displayCreateCampaignForm(Model model){
        model.addAttribute(new Campaign());
        model.addAttribute("title","Create Campaign");
        return "campaign/create";
    }

    @PostMapping("create")
    public String processCreateCampaignForm(@ModelAttribute @Valid Campaign campaign, Errors errors, Model model, HttpServletRequest request){
        if (errors.hasErrors()){
            model.addAttribute(new Campaign());
            model.addAttribute("title","Create Campaign");
            return "create";
        }

        campaignRepository.save(campaign);
        HttpSession session = request.getSession();
        session.setAttribute("campaign", campaign.getId());
        return "redirect:/donation/contribute";
    }
//    @Autowired
//    private CampaignService campaignService;
//
//    @GetMapping("/complete")
//    public List<Campaign> getAllCampaignsComplete(){
//        return campaignService.findAllCampaignsComplete();
//    }
//
//    @GetMapping
//    public Campaign[] getAllCampaigns(){
//        return campaignService.findAllCampaigns();
//    }
}

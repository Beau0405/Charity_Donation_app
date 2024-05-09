package com.fundraiser.fundraiser.controllers;

import com.fundraiser.fundraiser.models.Campaign;
import com.fundraiser.fundraiser.models.Donation;
import com.fundraiser.fundraiser.models.User;
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
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
    public String processCreateCampaignForm(@ModelAttribute @Valid Campaign campaign, User user, Errors errors, Model model, HttpServletRequest request){
        if (errors.hasErrors()){
            model.addAttribute(new Campaign());
            model.addAttribute("title","Create Campaign");
            return "create";
        }

        campaignRepository.save(campaign);
        HttpSession session = request.getSession();
        session.setAttribute("user", user.getId());
        return "redirect:/list";
    }

    @GetMapping("view/{campaignId}")
    public String displayCampaign(Model model, @PathVariable int campaignId, Donation donation){
        Optional optCampaign = campaignRepository.findById(campaignId);

        if (optCampaign.isPresent()) {
            Campaign campaign = (Campaign) optCampaign.get();
            model.addAttribute("campaign", campaign);
            model.addAttribute("donation", donation);
                        return "campaign/view";
        } else {
            return "redirect:../";
        }
    }

    @PostMapping("view/{campaignId}")
    public String processDonationForm(Model model, Donation donation){
        model.addAttribute("donation", donation);
        donationRepository.save(donation);
        return "redirect:/list";
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

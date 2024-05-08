package com.fundraiser.fundraiser.controllers;

import com.fundraiser.fundraiser.models.Donation;
import com.fundraiser.fundraiser.models.data.CampaignRepository;
import com.fundraiser.fundraiser.models.data.DonationRepository;
import com.fundraiser.fundraiser.models.data.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("donation")
public class DonationController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CampaignRepository campaignRepository;
    @Autowired
    private DonationRepository donationRepository;

    @GetMapping("contribute")
    public String displayDonationForm(Model model){
        model.addAttribute(new Donation());
        model.addAttribute("title","Donation Contribution");
        return "donation/contribute";
    }

    @PostMapping("contribute")
    public String processCreateDonationForm(@ModelAttribute @Valid Donation donation, Errors errors, Model model, HttpServletRequest request){
        if (errors.hasErrors()){
            model.addAttribute(new Donation());
            model.addAttribute("title","Donation Contribution");
            return "donation/contribute";
        }

        donationRepository.save(donation);
        HttpSession session = request.getSession();
        session.setAttribute("donation", donation.getAmount());
        return "redirect:";
    }
}

package com.Greg.VotarPeli;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
public class VoteController {

    @Autowired
    private VoteService votoService;

    @GetMapping({ "/" })
    public String showMain(Model model) {
        model.addAttribute("formVoto", new FormVoto()); // empty envelope
        model.addAttribute("votes", votoService.getVotesList()); // current counts
        return "main";
    }

    @PostMapping({ "/" })
    public String regVote(@Valid @ModelAttribute("formVoto") FormVoto formVoto,
            BindingResult bindRslt,
            Model model) {

        // envelope rejected by the form rules (empty, bad email, no film)
        if (bindRslt.hasErrors()) {
            model.addAttribute("votes", votoService.getVotesList());
            return "main";
        }

        try {
            // envelope OK: hand the contents to the service
            votoService.registerVote(formVoto.getEmail(), formVoto.getMovieIndex());
        } catch (RuntimeException e) {
            // service refused (already voted / invalid film)
            model.addAttribute("errorMsg", e.getMessage());
            model.addAttribute("votes", votoService.getVotesList());
            return "main";
        }

        return "redirect:/"; // success: GET shows the updated counts
    }
}

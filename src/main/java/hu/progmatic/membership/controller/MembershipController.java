package hu.progmatic.membership.controller;

import hu.progmatic.membership.model.Membership;
import hu.progmatic.membership.repository.MembershipRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MembershipController {
    private final MembershipRepository membershipRepository;

    public MembershipController(MembershipRepository membershipRepository) {
        this.membershipRepository = membershipRepository;
    }

    @GetMapping("/")
    public String listAllMemberships(Model model) {
        List<Membership> memberships = (List<Membership>) membershipRepository.findAll();
        model.addAttribute("result", memberships);

        return "result";
    }

    @GetMapping("/nagyok")
    public String listNagyNames(Model model) {
        List<Membership> memberships = membershipRepository.findByNameContaining("nagy");
        model.addAttribute("result", memberships);

        return "result";
    }

    @GetMapping("/search")
    public String searchMemberships(@RequestParam(name = "pattern", required = false) String pattern, Model model) {
        List<Membership> memberships;

        if (pattern == null) {
            // alapértelmezetten minden tagságot kilistázunk
            memberships = (List<Membership>) membershipRepository.findAll();
        } else {
            // ha van keresési feltétel, akkor csak a feltételeknek megfelelő tagságokat listázzuk
            memberships = membershipRepository.findByNameContaining(pattern);
        }

        model.addAttribute("result", memberships);

        return "result";
    }

}

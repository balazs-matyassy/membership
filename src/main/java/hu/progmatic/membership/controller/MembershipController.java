package hu.progmatic.membership.controller;

import hu.progmatic.membership.model.Membership;
import hu.progmatic.membership.repository.MembershipRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

}

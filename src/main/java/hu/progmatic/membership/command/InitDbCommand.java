package hu.progmatic.membership.command;

import hu.progmatic.membership.model.Membership;
import hu.progmatic.membership.repository.MembershipRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class InitDbCommand implements CommandLineRunner {
    private final MembershipRepository membershipRepository;

    public InitDbCommand(MembershipRepository membershipRepository) {
        this.membershipRepository = membershipRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Generating test memberships...");

        membershipRepository.save(new Membership("Kovács József", LocalDate.now().plusDays(10)));
        System.out.println("Membership for Kovács József generated.");

        membershipRepository.save(new Membership("Kovács István", LocalDate.now().plusDays(5)));
        System.out.println("Membership for Kovács István generated.");

        membershipRepository.save(new Membership("Nagy Péter", LocalDate.now().minusDays(10)));
        System.out.println("Membership for Nagy Péter generated.");

        membershipRepository.save(new Membership("Édes Anna", LocalDate.now().plusDays(100)));
        System.out.println("Membership for Édes Anna generated.");

        membershipRepository.save(new Membership("Nagy Rozála", LocalDate.now().plusDays(50)));
        System.out.println("Membership for Nagy Rozália generated.");
    }
}

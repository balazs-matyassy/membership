package hu.progmatic.membership.repository;

import hu.progmatic.membership.model.Membership;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface MembershipRepository extends CrudRepository<Membership, Long> {

    List<Membership> findByNameContaining(String search);

    List<Membership> findByValidityBetween(LocalDate from, LocalDate to);

}

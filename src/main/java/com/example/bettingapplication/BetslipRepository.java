package com.example.bettingapplication;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BetslipRepository extends JpaRepository<Betslip, Long> {
}

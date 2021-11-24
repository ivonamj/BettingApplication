package com.example.bettingapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class Controller {
    private final ServiceBM serviceBM;

    @Autowired
    public Controller(ServiceBM serviceBM) {
        this.serviceBM = serviceBM;
    }

    @GetMapping("/matches")
    public List<Match> GetMatches() {
        return serviceBM.getMatches();
    }

    @PostMapping("/matches")
    public void AddBetslip(@RequestBody Betslip betslip) { serviceBM.addBetslip(betslip); }

    @GetMapping("/betslip")
    public List<ResultBetslips> GetBetslips() {
        return serviceBM.getBetslips();
    }

    @GetMapping("/wallet")
    public Double UpdateWallet() {
        return Config.wallet;
    }
}

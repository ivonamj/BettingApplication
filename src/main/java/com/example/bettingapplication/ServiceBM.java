package com.example.bettingapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceBM {
    private final BetslipRepository betslipRepository;
    private final MatchRepository matchRepository;

    @Autowired
    public ServiceBM (BetslipRepository betslipRepository, MatchRepository matchRepository) {
        this.betslipRepository = betslipRepository;
        this.matchRepository = matchRepository;
    }

    public List<Match> getMatches() {
        return matchRepository.findAll();
    }

    public void addBetslip(Betslip betslip) {
        if (betslip.getPayment() != null && Config.wallet > betslip.getPayment() && betslip.getPlacedBetslip() != "0000000000") {
            Double odds = 1.0;
            List<Match> matches = matchRepository.findAll();

            for (int i = 0; i < matches.size(); i++) {
                if (betslip.getPlacedBetslip().charAt(i) == '1')
                    odds *= matches.get(i).getHome_win();
                else if (betslip.getPlacedBetslip().charAt(i) == '2')
                    odds *= matches.get(i).getAway_win();
                else if (betslip.getPlacedBetslip().charAt(i) == 'X')
                    odds *= matches.get(i).getDraw();
            }

            BigDecimal possibleGain = new BigDecimal(odds * betslip.getPayment());

            betslipRepository.save(new Betslip(betslip.getPlacedBetslip(), betslip.getPayment(), Math.round(odds*100.0)/100.0, possibleGain));

            Config.wallet -= betslip.getPayment();
        }
    }

    public List<ResultBetslips> getBetslips() {
        List<Match> matches = matchRepository.findAll();
        List<Betslip> betslips = betslipRepository.findAll();
        List<ResultBetslips> resultBetslips = new ArrayList<>();

        for (int i = 0; i < betslips.size(); i++) {
            List<MatchOnBetslip> matchesOnBetslip = new ArrayList<>();
            for (int j = 0; j < betslips.get(i).getPlacedBetslip().length(); j++) {
                if (betslips.get(i).getPlacedBetslip().charAt(j) == '1')
                    matchesOnBetslip.add(new MatchOnBetslip(matches.get(j).getName(),
                            betslips.get(i).getPlacedBetslip().charAt(j), matches.get(j).getHome_win()));
                else if (betslips.get(i).getPlacedBetslip().charAt(j) == '2')
                    matchesOnBetslip.add(new MatchOnBetslip(matches.get(j).getName(),
                            betslips.get(i).getPlacedBetslip().charAt(j), matches.get(j).getAway_win()));
                else if (betslips.get(i).getPlacedBetslip().charAt(j) == 'X')
                    matchesOnBetslip.add(new MatchOnBetslip(matches.get(j).getName(),
                            betslips.get(i).getPlacedBetslip().charAt(j), matches.get(j).getDraw()));
            }
            System.out.println( matchesOnBetslip);
            resultBetslips.add(new ResultBetslips(matchesOnBetslip, betslips.get(i).getPayment(),
                    betslips.get(i).getOdds(), betslips.get(i).getPossibleGain()));
        }

        return resultBetslips;
    }
}

package com.example.bettingapplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    public static Double wallet = 1000.0;

    private void insertMatches(MatchRepository matchRepository) {
        matchRepository.save(new Match("B. Mgladbach x Gr. Furth", 1.30, 10.50, 5.40));
        matchRepository.save(new Match("Atalanta x Spezia", 1.25, 11.50, 6.50));
        matchRepository.save(new Match("Atl. Madrid x Osasuna", 1.45, 8.30, 4.40));
        matchRepository.save(new Match("Watford x Man. Utd", 6.10, 1.55, 4.40));
        matchRepository.save(new Match("Bor. Dortmund x Stuttgart", 1.35, 8.40, 5.30));
        matchRepository.save(new Match("Liverpool x Arsenal", 1.50, 6.20, 4.70));
        matchRepository.save(new Match("FC Sevilla x Alaves", 1.40, 8.30, 4.60));
        matchRepository.save(new Match("Fiorentina x AC Milan", 3.20, 2.30, 3.40));
        matchRepository.save(new Match("Barcelona x Espanyol", 1.40, 7.70, 5.20));
        matchRepository.save(new Match("Paris SG x Nantes", 1.25, 11.50, 6.40));
    }

    @Bean
    CommandLineRunner commandLineRunner(MatchRepository matchRepository) {
        return (args) -> {
            insertMatches(matchRepository);
        };
    }
}

package com.example.WorldCup;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
@SpringBootApplication
public class WorldCupScoreboard {
    private List<Match> matches;

    public WorldCupScoreboard(List<Match> matches) {
        this.matches = matches;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public Match getMatch(String team1, String team2) {
        for (Match match : matches) {
            if (match.getTeam1().equals(team1) && match.getTeam2().equals(team2)) {
                return match;
            }
        }
        return null;
    }

    public String getScore(String team1, String team2) {
        Match match = getMatch(team1, team2);
        if (match == null) {
            return null;
        }
        if (match.getScore1() < 0 || match.getScore1() > 10 || match.getScore2() < 0 || match.getScore2() > 10) {
            throw new IllegalArgumentException("Invalid score");
        }
        return String.format("%d - %d", match.getScore1(), match.getScore2());
    }
}

package com.example.WorldCup;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WorldCupApplicationTests {

	@Test
	void getScore_MatchCurrentlyBeingPlayed_ScoreIsReturned() {
		List<Match> matches = new ArrayList<>();
		matches.add(new Match("France", "India", 2, 1));
		WorldCupScoreboard scoreboard = new WorldCupScoreboard(matches);
		String score = scoreboard.getScore("France", "India");
		assertEquals("2 - 1", score);
	}

	@Test
	void getScore_MatchNotCurrentlyBeingPlayed_NullIsReturned() {
		List<Match> matches = new ArrayList<>();
		matches.add(new Match("France", "India", 2, 1));
		WorldCupScoreboard scoreboard = new WorldCupScoreboard(matches);
		String score = scoreboard.getScore("Brazil", "India");
		assertNull(score);
	}

	@Test
	void getScore_InvalidTeamName_NullIsReturned() {
		List<Match> matches = new ArrayList<>();
		matches.add(new Match("France", "India", 2, 1));
		WorldCupScoreboard scoreboard = new WorldCupScoreboard(matches);
		String score = scoreboard.getScore("Invalid Team", "India");
		assertNull(score);
	}

	@Test
	void getScore_InvalidScore_ExceptionIsThrown() {
		List<Match> matches = new ArrayList<>();
		matches.add(new Match("France", "India", 2, 11));
		WorldCupScoreboard scoreboard = new WorldCupScoreboard(matches);
		assertThrows(IllegalArgumentException.class, () -> {
			scoreboard.getScore("France", "India");
		});
	}

}

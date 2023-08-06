package com.example.WorldCup;

import java.util.ArrayList;
import java.util.List;

public class WorldCupApplication {

	public static void main(String[] args) {
		List<Match> matches = new ArrayList<>();
		matches.add(new Match("France", "Argentina", 2, 1));
		matches.add(new Match("Brazil", "Spain", 3, 2));
		WorldCupScoreboard scoreboard = new WorldCupScoreboard(matches);
		String score = scoreboard.getScore("France", "Argentina");
		System.out.println(score); // Prints "2 - 1"
	}

}

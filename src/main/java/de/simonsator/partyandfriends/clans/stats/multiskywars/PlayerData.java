package de.simonsator.partyandfriends.clans.stats.multiskywars;

/**
 * @author simonbrungs
 * @version 1.0.0 30.11.16
 */
public class PlayerData {
	public final int wins;
	public final int assists;
	public final int deaths;
	public final int kills;

	public PlayerData(int wins, int assists, int deaths, int kills) {
		this.wins = wins;
		this.assists = assists;
		this.deaths = deaths;
		this.kills = kills;
	}
}

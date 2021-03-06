package de.simonsator.partyandfriends.clans.stats.multiskywars.luck;

import de.simonsator.partyandfriends.clans.stats.multiskywars.MSWStats;
import de.simonsator.partyandfriends.clans.stats.multiskywars.MSWStatsConnection;
import de.simonsator.partyandfriends.clans.stats.multiskywars.PlayerData;

import java.util.UUID;
import java.util.regex.Matcher;

/**
 * @author simonbrungs
 * @version 1.0.0 17.01.17
 */
public class LuckStatProviderSingle extends MSWStats {

	public LuckStatProviderSingle(String pName, MSWStatsConnection pCon, Matcher pKillsMessage, Matcher pWinsMessage, Matcher pAssistsMessage, Matcher pDeathsMessage) {
		super(pName, pCon, pKillsMessage, pWinsMessage, pAssistsMessage, pDeathsMessage);
	}

	protected PlayerData getPlayerData(UUID player) {
		return CONNECTION.getPlayerDataLucky(player);
	}
}

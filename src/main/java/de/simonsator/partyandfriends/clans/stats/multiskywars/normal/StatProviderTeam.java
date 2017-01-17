package de.simonsator.partyandfriends.clans.stats.multiskywars.normal;

import de.simonsator.partyandfriends.clans.stats.multiskywars.MSWStats;
import de.simonsator.partyandfriends.clans.stats.multiskywars.MSWStatsConnection;
import de.simonsator.partyandfriends.clans.stats.multiskywars.PlayerData;

import java.util.UUID;
import java.util.regex.Matcher;

/**
 * @author simonbrungs
 * @version 1.0.0 17.01.17
 */
public class StatProviderTeam extends MSWStats {
	public StatProviderTeam(String pName, MSWStatsConnection pCon, Matcher pKillsMessage, Matcher pWinsMessage, Matcher pAssistsMessage, Matcher pDeathsMessage) {
		super(pName, pCon, pKillsMessage, pWinsMessage, pAssistsMessage, pDeathsMessage);
	}

	protected PlayerData getPlayerData(UUID pPlayer) {
		return CONNECTION.getPlayerDataMulti(pPlayer);
	}
}

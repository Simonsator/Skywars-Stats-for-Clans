package de.simonsator.partyandfriends.clans.stats.multiskywars.luck;

import de.simonsator.partyandfriends.api.pafplayers.OnlinePAFPlayer;
import de.simonsator.partyandfriends.api.pafplayers.PAFPlayer;
import de.simonsator.partyandfriends.clan.api.Clan;
import de.simonsator.partyandfriends.clan.api.ClanStat;
import de.simonsator.partyandfriends.clans.stats.multiskywars.MSWStatsConnection;
import de.simonsator.partyandfriends.clans.stats.multiskywars.PlayerData;

import java.util.ArrayList;
import java.util.List;

/**
 * @author simonbrungs
 * @version 1.0.0 17.01.17
 */
public class LuckStatProvider implements ClanStat {
	private final String NAME;
	private final MSWStatsConnection CONNECTION;

	public LuckStatProvider(String pName, MSWStatsConnection pCon) {
		NAME = pName;
		CONNECTION = pCon;
	}

	public void stats(OnlinePAFPlayer pSender, Clan pClan) {
		List<PAFPlayer> players = pClan.getAllPlayers();
		List<PlayerData> playerData = new ArrayList<PlayerData>();
		for (PAFPlayer player : players) {
			PlayerData data = CONNECTION.getPlayerDataLucky(player.getUniqueId());
			if (data != null)
				playerData.add(data);
		}
	}

	public String getName() {
		return NAME;
	}
}

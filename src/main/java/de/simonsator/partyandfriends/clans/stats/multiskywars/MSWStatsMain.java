package de.simonsator.partyandfriends.clans.stats.multiskywars;

import de.simonsator.partyandfriends.api.pafplayers.OnlinePAFPlayer;
import de.simonsator.partyandfriends.api.pafplayers.PAFPlayer;
import de.simonsator.partyandfriends.clan.api.Clan;
import de.simonsator.partyandfriends.clan.commands.ClanCommands;
import de.simonsator.partyandfriends.clan.commands.subcommands.Stats;
import de.simonsator.partyandfriends.utilities.Language;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author simonbrungs
 * @version 1.0.0 17.01.17
 */
public class MSWStatsMain extends Plugin {
	private Configuration config;
	private MSWStatsConnection connection;
	private Configuration messagesConfig;

	public void onEnable() {
		try {
			config = (new MSWStatsConfig(new File(getDataFolder(), "config.yml"))).getCreatedConfiguration();
			messagesConfig = (new MSWStatsMessages(Language.OWN, new File(getDataFolder(), "messages.yml"))).getCreatedConfiguration();
		} catch (IOException e) {
			e.printStackTrace();
		}
		connection = new MSWStatsConnection(config.getString("database.db"), "jdbc:mysql://" + config.getString("database.host") + ":" + config.getInt("database.port"), config.getString("database.user"), config.getString("database.password"));
		((Stats) ClanCommands.getInstance().getSubCommand(Stats.class)).registerClanStats(this, this);
	}

	public void stats(OnlinePAFPlayer pSender, Clan pClan) {
		List<PAFPlayer> players = pClan.getAllPlayers();
		List<PlayerData> playerData = new ArrayList<PlayerData>();
		for (PAFPlayer player : players) {
			PlayerData data = connection.getPlayerData(player.getUniqueId());
			if (data != null)
				playerData.add(data);
		}
		int wins = 0;
		int deaths = 0;
		int loses = 0;
		int destroyedBeds = 0;
		int games = 0;
		int kills = 0;
		double kds = 0;
		for (PlayerData data : playerData) {
			wins += data.wins;
			deaths += data.deaths;
			loses += data.loses;
			destroyedBeds += data.destroyedBeds;
			games += data.games;
			kds += data.kd;
			kills += data.kills;
		}
		kds = kds / playerData.size();
		if (kds != kds)
			kds = 0;
		pSender.sendMessage(messagesConfig.getString("ClanStats.Wins").replace("[WON]", wins + ""));
		pSender.sendMessage(messagesConfig.getString("ClanStats.Lost").replace("[LOST]", loses + ""));
		pSender.sendMessage(messagesConfig.getString("ClanStats.Played").replace("[GAMES]", games + ""));
		pSender.sendMessage(messagesConfig.getString("ClanStats.DestroyedBeds").replace("[BEDS]", destroyedBeds + ""));
		pSender.sendMessage(messagesConfig.getString("ClanStats.KD").replace("[KD]", kds + ""));
		pSender.sendMessage(messagesConfig.getString("ClanStats.Kills").replace("[KILLS]", kills + ""));
		pSender.sendMessage(messagesConfig.getString("ClanStats.Deaths").replace("[DEATHS]", deaths + ""));
	}

	public String getName() {
		return config.getString("ClanStats.Name");
	}
}

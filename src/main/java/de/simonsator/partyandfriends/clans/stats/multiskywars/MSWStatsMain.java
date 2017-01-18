package de.simonsator.partyandfriends.clans.stats.multiskywars;

import de.simonsator.partyandfriends.clan.commands.ClanCommands;
import de.simonsator.partyandfriends.clan.commands.subcommands.Stats;
import de.simonsator.partyandfriends.clans.stats.multiskywars.luck.LuckStatProviderSingle;
import de.simonsator.partyandfriends.clans.stats.multiskywars.luck.LuckStatProviderTeam;
import de.simonsator.partyandfriends.clans.stats.multiskywars.normal.StatProviderSingle;
import de.simonsator.partyandfriends.clans.stats.multiskywars.normal.StatProviderTeam;
import de.simonsator.partyandfriends.utilities.Language;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;

import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

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
		String path = "LuckSingle.";
		if (config.getBoolean("Use.LuckySolo"))
			((Stats) ClanCommands.getInstance().getSubCommand(Stats.class)).registerClanStats(new LuckStatProviderSingle(messagesConfig.getString(path + "Name"), connection, Pattern.compile("[KILLS]", Pattern.LITERAL).matcher(messagesConfig.getString(path + "Kills")), Pattern.compile("[WINS]", Pattern.LITERAL).matcher(messagesConfig.getString(path + "Wins")), Pattern.compile("[ASSISTS]", Pattern.LITERAL).matcher(messagesConfig.getString(path + "Assists")), Pattern.compile("[DEATHS]", Pattern.LITERAL).matcher(messagesConfig.getString(path + "Deaths"))), this);
		path = "LuckTeam.";
		if (config.getBoolean("Use.LuckyTeam"))
			((Stats) ClanCommands.getInstance().getSubCommand(Stats.class)).registerClanStats(new LuckStatProviderTeam(messagesConfig.getString(path + "Name"), connection, Pattern.compile("[KILLS]", Pattern.LITERAL).matcher(messagesConfig.getString(path + "Kills")), Pattern.compile("[WINS]", Pattern.LITERAL).matcher(messagesConfig.getString(path + "Wins")), Pattern.compile("[ASSISTS]", Pattern.LITERAL).matcher(messagesConfig.getString(path + "Assists")), Pattern.compile("[DEATHS]", Pattern.LITERAL).matcher(messagesConfig.getString(path + "Deaths"))), this);
		path = "NormalNormal.";
		if (config.getBoolean("Use.NormalSolo"))
			((Stats) ClanCommands.getInstance().getSubCommand(Stats.class)).registerClanStats(new StatProviderSingle(messagesConfig.getString(path + "Name"), connection, Pattern.compile("[KILLS]", Pattern.LITERAL).matcher(messagesConfig.getString(path + "Kills")), Pattern.compile("[WINS]", Pattern.LITERAL).matcher(messagesConfig.getString(path + "Wins")), Pattern.compile("[ASSISTS]", Pattern.LITERAL).matcher(messagesConfig.getString(path + "Assists")), Pattern.compile("[DEATHS]", Pattern.LITERAL).matcher(messagesConfig.getString(path + "Deaths"))), this);
		path = "NormaTeam.";
		if (config.getBoolean("Use.NormalTeam"))
			((Stats) ClanCommands.getInstance().getSubCommand(Stats.class)).registerClanStats(new StatProviderTeam(messagesConfig.getString(path + "Name"), connection, Pattern.compile("[KILLS]", Pattern.LITERAL).matcher(messagesConfig.getString(path + "Kills")), Pattern.compile("[WINS]", Pattern.LITERAL).matcher(messagesConfig.getString(path + "Wins")), Pattern.compile("[ASSISTS]", Pattern.LITERAL).matcher(messagesConfig.getString(path + "Assists")), Pattern.compile("[DEATHS]", Pattern.LITERAL).matcher(messagesConfig.getString(path + "Deaths"))), this);

	}
}

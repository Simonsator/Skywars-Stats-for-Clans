package de.simonsator.partyandfriends.clans.stats.multiskywars;

import de.simonsator.partyandfriends.utilities.Language;
import de.simonsator.partyandfriends.utilities.LanguageConfiguration;

import java.io.File;
import java.io.IOException;

/**
 * @author simonbrungs
 * @version 1.0.0 30.11.16
 */
public class MSWStatsMessages extends LanguageConfiguration {

	public MSWStatsMessages(Language pLanguage, File pFile) throws IOException {
		super(pLanguage, pFile);
		readFile();
		loadDefaultValues();
		saveFile();
		process(configuration);
	}

	private void loadDefaultValues() {
		set("LuckSingle.Name", "MultiSkyWars-Lucky-Normal");
		set("LuckSingle.Kills", "&7The clan has &a[KILLS] &7kills.");
		set("LuckSingle.Wins", "&7The clan has won &a[WINS] &7times.");
		set("LuckSingle.Assists", "&7The clan has &a[ASSISTS] &7assists.");
		set("LuckSingle.Deaths", "&7The clan has died &a[DEATHS] &7times.");
		set("LuckTeam.Name", "MultiSkyWars-Lucky-Team");
		set("LuckTeam.Kills", "&7The clan has &a[KILLS] &7kills.");
		set("LuckTeam.Wins", "&7The clan has won &a[WINS] &7times.");
		set("LuckTeam.Assists", "&7The clan has &a[ASSISTS] &7assists.");
		set("LuckTeam.Deaths", "&7The clan has died &a[DEATHS] &7times.");
		set("NormalNormal.Name", "MultiSkyWars-Normal");
		set("NormalNormal.Kills", "&7The clan has &a[KILLS] &7 kills.");
		set("NormalNormal.Wins", "&7The clan has won &a[WINS] &7times.");
		set("NormalNormal.Assists", "&7The clan has &a[ASSISTS] &7assists.");
		set("NormalNormal.Deaths", "&7The clan has died &a[DEATHS] &7times.");
		set("NormaTeam.Name", "MultiSkyWars-Team");
		set("NormaTeam.Kills", "&7The clan has &a[KILLS] &7 kills.");
		set("NormaTeam.Wins", "&7The clan has won &a[WINS] &7times.");
		set("NormaTeam.Assists", "&7The clan has &a[ASSISTS] &7assists.");
		set("NormaTeam.Deaths", "&7The clan has died &a[DEATHS] &7times.");

	}

	public void reloadConfiguration() throws IOException {
		configuration = (new MSWStatsMessages(LANGUAGE.OWN, FILE)).getCreatedConfiguration();
	}
}

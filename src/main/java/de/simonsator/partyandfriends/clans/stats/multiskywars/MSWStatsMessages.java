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
		set("ClanStats.Name", "MultiSkyWars");
		set("ClanStats.Lost", "&7The clan has lost &a[LOST] &7games.");
		set("ClanStats.Played", "&7The clan has played &a[GAMES] &7games.");
		set("ClanStats.DestroyedBeds", "&7The clan has destroyed &a[BEDS] &7beds.");
		set("ClanStats.KD", "&7The average K/D of the clan is &a[KD]&7.");
		set("ClanStats.Kills", "&7The people of the clan have killed &a[KILLS] &7people.");
		set("ClanStats.Deaths", "&7The people of the clan have died &a[DEATHS]&7 times.");
	}

	public void reloadConfiguration() throws IOException {
		configuration = (new MSWStatsMessages(LANGUAGE.OWN, FILE)).getCreatedConfiguration();
	}
}

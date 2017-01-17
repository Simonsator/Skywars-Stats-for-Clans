package de.simonsator.partyandfriends.clans.stats.multiskywars;

import de.simonsator.partyandfriends.utilities.ConfigurationCreator;

import java.io.File;
import java.io.IOException;

/**
 * @author simonbrungs
 * @version 1.0.0 30.11.16
 */
public class MSWStatsConfig extends ConfigurationCreator {
	protected MSWStatsConfig(File file) throws IOException {
		super(file);
		readFile();
		loadDefaultValues();
		saveFile();
	}

	private void loadDefaultValues() {
		set("database.host", "localhost");
		set("database.port", 3306);
		set("database.db", "minecraft");
		set("database.user", "root");
		set("database.password", "password");
	}

	public void reloadConfiguration() throws IOException {
		configuration = (new MSWStatsConfig(FILE)).getCreatedConfiguration();
	}
}

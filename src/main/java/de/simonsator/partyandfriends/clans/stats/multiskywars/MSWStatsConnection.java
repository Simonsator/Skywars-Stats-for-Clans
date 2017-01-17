package de.simonsator.partyandfriends.clans.stats.multiskywars;

import de.simonsator.partyandfriends.communication.sql.SQLCommunication;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

/**
 * @author simonbrungs
 * @version 1.0.0 17.01.17
 */
public class MSWStatsConnection extends SQLCommunication {
	protected MSWStatsConnection(String pDatabase, String pURL, String pUserName, String pPassword) {
		super(pDatabase, pURL, pUserName, pPassword);
	}

	public PlayerData getPlayerDataLucky(UUID pUUID) {
		Connection con = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			rs = (stmt = con.createStatement()).executeQuery("select lucky_kills, lucky_wins, lucky_assists, lucky_deaths from `"
					+ DATABASE + "`." + "bw_stats_players WHERE player_uuid='" + pUUID.toString() + "' LIMIT 1");
			if (rs.next())
				return new PlayerData(rs.getInt("lucky_wins"), rs.getInt("lucky_assists"), rs.getInt("lucky_deaths"),
						rs.getInt("lucky_kills"));
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			close(rs, stmt);
		}
		return null;
	}

	public PlayerData getPlayerDataLuckyTeam(UUID pUUID) {
		Connection con = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			rs = (stmt = con.createStatement()).executeQuery("select lucky_team_kills, lucky_team_wins, lucky_team_assists, lucky_team_deaths from `"
					+ DATABASE + "`." + "skywars_players WHERE player_uuid='" + pUUID.toString() + "' LIMIT 1");
			if (rs.next())
				return new PlayerData(rs.getInt("lucky_team_wins"), rs.getInt("lucky_team_assists"), rs.getInt("lucky_team_deaths"),
						rs.getInt("lucky_team_kills"));
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			close(rs, stmt);
		}
		return null;
	}

	public PlayerData getPlayerData(UUID pUUID) {
		Connection con = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			rs = (stmt = con.createStatement()).executeQuery("select normal_kills, normal_wins, normal_assists, normal_deaths from `"
					+ DATABASE + "`." + "skywars_players WHERE player_uuid='" + pUUID.toString() + "' LIMIT 1");
			if (rs.next())
				return new PlayerData(rs.getInt("normal_wins"), rs.getInt("normal_assists"), rs.getInt("normal_deaths"),
						rs.getInt("normal_kills"));
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			close(rs, stmt);
		}
		return null;
	}

	public PlayerData getPlayerDataMulti(UUID pUUID) {
		Connection con = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			rs = (stmt = con.createStatement()).executeQuery("select normal_team_kills, normal_team_wins, normal_team_assists, normal_team_deaths from `"
					+ DATABASE + "`." + "skywars_players WHERE player_uuid='" + pUUID.toString() + "' LIMIT 1");
			if (rs.next())
				return new PlayerData(rs.getInt("normal_team_wins"), rs.getInt("normal_team_assists"), rs.getInt("normal_team_deaths"),
						rs.getInt("normal_team_kills"));
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			close(rs, stmt);
		}
		return null;
	}
}

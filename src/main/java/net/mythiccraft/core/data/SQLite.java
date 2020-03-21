package net.mythiccraft.core.data;

import net.mythiccraft.core.Core;

import java.io.File;
import java.sql.Connection;

/**
 * @author Taylor Hughes
 */
public class SQLite implements Storage {

    private Core plugin;
    private Connection connection;
    private String database;
    private File databaseFile;

    public SQLite(Core plugin, String database) {
        this.plugin = plugin;
        this.database = database;
        this.databaseFile = new File(plugin.getDataFolder(), database + ".db");
    }

    @Override
    public String getName() {
        return "SQLite";
    }

    @Override
    public String getDatabase() {
        return database;
    }

    @Override
    public Type getType() {
        return Type.SQLITE;
    }

    public File getDatabaseFile() {
        return databaseFile;
    }

    @Override
    public Connection getConnection() {
        return connection;
    }

    @Override
    public void connect() {

    }

    @Override
    public void shutdown() {

    }

    @Override
    public void reconnect() {

    }
}

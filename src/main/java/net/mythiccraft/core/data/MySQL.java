package net.mythiccraft.core.data;

import net.mythiccraft.core.Core;

import java.sql.Connection;

/**
 * @author Taylor Hughes
 */
public class MySQL implements Storage {

    private Core plugin;
    private String database, username, password;
    private int port;

    public MySQL(Core plugin, String database, String username, String password, int port) {
        this.plugin = plugin;
        this.database = database;
        this.username = username;
        this.password = password;
        this.port = port;
    }

    public Core getPlugin() {
        return plugin;
    }

    public int getPort() {
        return port;
    }

    @Override
    public String getName() {
        return "MySQL";
    }

    @Override
    public String getDatabase() {
        return database;
    }

    @Override
    public Type getType() {
        return Type.MYSQL;
    }

    @Override
    public Connection getConnection() {
        return null;
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

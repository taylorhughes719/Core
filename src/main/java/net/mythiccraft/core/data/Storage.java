package net.mythiccraft.core.data;

import java.sql.Connection;

/**
 * Storage interface
 */
public interface Storage {

    String getName();

    String getDatabase();

    Type getType();

    default String getDisplayName() {
        return getType().getDisplayName();
    }

    Connection getConnection();

    void connect();

    void shutdown();

    void reconnect();




    /**
     * Storage types
     */
    enum Type {

        MYSQL("MySQL"), H2("h2"), SQLITE("SQLite");

        private final String display;

        Type(String display) {
            this.display = display;
        }

        public String getDisplayName() {
            return display;
        }
    }
}

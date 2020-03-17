package net.mythiccraft.core.config;

import com.google.common.io.ByteStreams;

import net.mythiccraft.core.Core;

import net.mythiccraft.core.util.Text;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

/**
 * A custom file configuration.
 *
 * @version 1.0.0
 */
public class FileConfig {

    private Core plugin;
    private File file;
    private FileConfiguration config;
    private String name;

    public FileConfig(Core plugin, String file) {
        this.plugin = plugin;
        this.file = new File(this.plugin.getDataFolder(), file);
        this.name = file;
        this.config = new YamlConfiguration();
    }

    public String getFileName() {
        return this.file.getName();
    }

    public String getFilePath() {
        return this.file.getPath();
    }

    public File getFile() {
        return this.file;
    }

    @SuppressWarnings("UnstableApiUsage")
    public void load() {
        this.plugin.getLogger().info("Loading file configuration: " + this.file.getName());
        try {
            if (this.file.exists()) {
                this.config.load(this.file);
            }
            else {
                ByteStreams.copy(Objects.requireNonNull(this.plugin.getResource(this.file.getName())), new FileOutputStream(this.file));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void save() {
        try {
            this.plugin.getLogger().info("Saving config file " + this.name + "");
            this.config.save(this.file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void reload() {
        try {
            this.config.save(this.file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.load();
    }

    public FileConfiguration getConfig() {
        return this.config;
    }

    public ConfigurationSection getConfigSection(String path) {
        return this.config.getConfigurationSection(path);
    }

    public String getString(String key) {
        return Text.colorize(this.config.getString(key, null));
    }

    public String getString(String key, String def) {
        return Text.colorize(this.config.getString(key, def));
    }

    public List<String> getStringList(String key) {
        return Text.colorize(this.config.getStringList(key));
    }

    public long getLong(String key) {
        return this.config.getLong(key);
    }

    public int getInt(String key) {
        return this.config.getInt(key);
    }

    public double getDouble(String key) {
        return this.config.getDouble(key);
    }

    public boolean getBoolean(String key) {
        return this.config.getBoolean(key);
    }

    public void set(String key, Object value) {
        this.config.set(key, value);
    }

    public void set(String key, Location value) {
        this.config.set(key + ".World:", Objects.requireNonNull(value.getWorld()).getName());
        this.config.set(key + ".X", value.getX());
        this.config.set(key + ".Y", value.getY());
        this.config.set(key + ".Z", value.getZ());
        this.config.set(key + ".Pitch", value.getPitch());
        this.config.set(key + ".Yaw", value.getYaw());
    }
}

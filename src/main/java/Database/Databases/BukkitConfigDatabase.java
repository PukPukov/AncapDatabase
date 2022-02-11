package Database.Databases;

import Database.Database;
import Database.Exception.ANRDBException;
import Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class BukkitConfigDatabase implements Database {

    private File cfgFile;

    private FileConfiguration cfg;

    private String fileName;

    public BukkitConfigDatabase(String fileName) {
        this.createDatabaseFile(fileName);
        this.registerDatabase(fileName);
        this.validate();
        this.notifyForCreation();
    }

    private void createDatabaseFile(String fileName) {
        File file = new File(Main.getInstance().getDataFolder(), fileName);
        this.createFile(file);
    }

    private void createFile(File file) {
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void registerDatabase(String fileName) {
        this.cfgFile = new File(Main.getInstance().getDataFolder(), fileName);
        this.fileName = fileName;
        this.cfg = YamlConfiguration.loadConfiguration(this.cfgFile);
    }

    private void validate() {
        if (!cfgFile.exists()) {
            throw new ANRDBException("FileDatabase don't exist");
        }
    }

    private void notifyForCreation() {
        Bukkit.getServer().getConsoleSender().sendMessage("[AncapDatabase] BukkitConfigDB "+fileName+" успешно создана.");
    }

    @Override
    public void write(String path, Object value) {
        this.cfg.set(path, value);
    }

    @Override
    public String getString(String path) {
        return this.cfg.getString(path);
    }

    @Override
    public String[] getStrings(String path) {
        return this.cfg.getStringList(path).toArray(new String[0]);
    }

    @Override
    public String[] getKeys(String path) {
        ConfigurationSection section = this.cfg.getConfigurationSection(path);
        return section.getKeys(false).toArray(new String[0]);
    }

    @Override
    public boolean isSet(String path) {
        return this.cfg.isSet(path);
    }
}

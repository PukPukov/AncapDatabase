package Database.Databases.BukkitConfigDatabase;

import Database.Database;
import Database.Exception.ANRDBException;
import Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class BukkitConfigDatabase implements Database {

    private File cfgFile;

    private FileConfiguration cfg;

    private String fileName;

    public BukkitConfigDatabase(String fileName) {
        this.createDatabaseFile(fileName);
        this.registerClass(fileName);
        this.validate();
        this.notifyForLoading();
    }

    private void createDatabaseFile(String fileName) {
        this.prepareDataFolder();
        this.createFile(new File(Main.getInstance().getDataFolder(), fileName));
    }

    private void prepareDataFolder() {
        Main.getInstance().getDataFolder().mkdirs();
    }

    private void createFile(File file) {
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void registerClass(String fileName) {
        this.cfgFile = new File(Main.getInstance().getDataFolder(), fileName);
        this.fileName = fileName;
        this.cfg = YamlConfiguration.loadConfiguration(this.cfgFile);
    }

    private void validate() {
        this.validateFileCreation();
    }

    private void validateFileCreation() {
        if (!cfgFile.exists()) {
            throw new ANRDBException("FileDatabase don't exist");
        }
    }

    private void notifyForLoading() {
        Bukkit.getServer().getConsoleSender().sendMessage("[AncapDatabase] BukkitConfigDB "+fileName+" успешно создана.");
    }

    @Override
    public void save() {
        try {
            cfg.save(cfgFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeNoSave(String path, Object value) {
        this.cfg.set(path, value);
    }

    @Override
    public void write(String path, Object value) {
        this.writeNoSave(path, value);
        this.save();
    }

    @Override
    public String getString(String path) {
        return this.cfg.getString(path);
    }

    @Override
    public List<String> getStrings(String path) {
        return this.cfg.getStringList(path);
    }

    @Override
    public String[] getKeys(String path) {
        ConfigurationSection section = this.cfg.getConfigurationSection(path);
        if (section == null) {
            return new String[0];
        }
        return section.getKeys(false).toArray(new String[0]);
    }

    @Override
    public boolean isSet(String path) {
        return this.cfg.isSet(path);
    }
}

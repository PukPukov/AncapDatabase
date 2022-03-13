package Database.Databases.JSONDatabase;

import Database.Database;

import java.util.List;

public class JSONDatabase implements Database {

    @Override
    public void save() {

    }

    @Override
    public void write(String path, Object value) {
    }

    @Override
    public void writeNoSave(String path, Object value) {

    }

    @Override
    public String getString(String path) {
        return null;
    }

    @Override
    public List<String> getStrings(String path) {
        return null;
    }

    @Override
    public String[] getKeys(String path) {
        return new String[0];
    }

    @Override
    public boolean isSet(String path) {
        return false;
    }
}

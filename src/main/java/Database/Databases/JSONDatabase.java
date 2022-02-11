package Database.Databases;

import Database.Database;

public class JSONDatabase implements Database {

    @Override
    public void write(String path, Object value) {
    }

    @Override
    public String getString(String path) {
        return null;
    }

    @Override
    public String[] getStrings(String path) {
        return new String[0];
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

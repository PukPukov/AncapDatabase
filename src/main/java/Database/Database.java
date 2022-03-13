package Database;

import java.util.List;

public interface Database {

    void save();
    void write(String path, Object value);
    void writeNoSave(String path, Object value);
    String getString(String path);
    List<String> getStrings(String path);
    String[] getKeys(String path);
    boolean isSet(String path);
}

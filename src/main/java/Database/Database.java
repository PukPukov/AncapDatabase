package Database;

public interface Database {

    void write(String path, Object value);
    String getString(String path);
    String[] getStrings(String path);
    String[] getKeys(String path);
    boolean isSet(String path);

}

package se.file;

import java.io.*;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

/**
 * @author zhangyaowen
 */
public class ResourceTest {

    void createProperties() throws IOException {
        Map<String, String> mysqlProperties = generateMap();
        String mysqlPropertiesName = "mysql";
        boolean isStoredProperties = this.storeProperties(mysqlProperties, mysqlPropertiesName);
        if (isStoredProperties) {
            System.out.println("properties file stored");
        }
    }

    Map<String, String> generateMap() throws IOException {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("jdbc.url", "jdbc:mysql://127.0.0.1:3306/web");
        map.put("user", "root");
        map.put("password", "secret");
        return map;
    }

    boolean storeProperties(Map<String, String> map, String propertiesName) throws IOException {
        if (map.isEmpty()) {
            return false;
        }
        Properties properties = new Properties();
        map.forEach(properties::setProperty);
        String suffix = ".properties";
        if (propertiesName.lastIndexOf(suffix) == -1) {
            propertiesName += suffix;
        }
        File propertiesFile = new File(propertiesName);
        if (!propertiesFile.exists()) {
            if (!propertiesFile.createNewFile()) {
                return false;
            }
        }
        try (OutputStream propertiesStream = new FileOutputStream(propertiesFile)) {
            properties.store(propertiesStream, propertiesName);
            return true;
        }
    }

    void dumpDefaultProperty() {
        Properties defaultProperty = System.getProperties();
        defaultProperty.forEach((k, v)->System.out.println(k.toString() + ": " + v.toString()));
    }

    void preference() throws IOException, BackingStoreException {
        Preferences userRoot = Preferences.userRoot();
        Preferences systemRoot = Preferences.systemRoot();
        System.out.println(userRoot.absolutePath());
        System.out.println(systemRoot.absolutePath());
        Preferences currentNode = Preferences.userNodeForPackage(this.getClass());
        currentNode.put("far", "bar");
        currentNode.put("date", LocalDate.now().toString());
        File outputTree = new File("preferences_tree.xml");
        outputTree.createNewFile();
        File outputNode = new File("preferences_node.xml");
        outputNode.createNewFile();
        currentNode.exportSubtree(new FileOutputStream(outputTree));
        currentNode.exportNode(new FileOutputStream(outputNode));
    }

    public static void main(String[] args) throws IOException, BackingStoreException {
        ResourceTest resourceTest = new ResourceTest();
        resourceTest.preference();
    }


}

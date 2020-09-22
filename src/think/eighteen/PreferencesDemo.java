package think.eighteen;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class PreferencesDemo {
    public static void main(String[] args) throws BackingStoreException {
        Preferences preferences = Preferences.userNodeForPackage(PreferencesDemo.class);
        preferences.put("Location", "Oz");
        preferences.put("Footwear", "Ruby");
        preferences.putInt("Companions", 4);
        preferences.putBoolean("Are there witches?", true);
        int usageCount = preferences.getInt("UsageCount", 0);
        usageCount++;
        preferences.putInt("UsageCount", usageCount);
        for (String key : preferences.keys()) {
            System.out.println(key + ":" + preferences.get(key, null));
        }
        System.out.println("How many companions does Dorothy have? " + preferences.getInt("Companions", 0));
    }
}

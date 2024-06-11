package net.minecraft.src;

import java.util.Random;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.ArrayList;
import net.minecraft.client.Minecraft;
import java.awt.Desktop;
import java.net.URI;


public class Helper {
    private static Random random;
    public static boolean seizure_item_mode_enabled = false;
    public static boolean show_version = true;

    public static int version_number = 3;
    public static int snapshot_number = 4;

    public static String version = "";
    public static String mod_name = "assphat";
    public static boolean log_user_shit_lol = false;
    
    // Block.java calls these
    public static boolean random_explosions = true;
    public static int random_explosion_chance = 100; // 1/int
    public static Minecraft mc = Minecraft.theMinecraft;

    // version info
    public static int versionType = 2;
    /*
         0 = release
         1 = snapshot
         2 = debug
     */
    
    // testing stuff
    public static boolean testing_enabled = false;

    static {
        random = new Random();
    }
    
    public Helper() {

    }
    
    public static String getTitle() {
        if (versionType == 0) {
            testing_enabled = false;
            version = "r" + version_number;
        } else {
            version = "r" + version_number + "s" + snapshot_number;
            if (versionType == 2) {
                testing_enabled = true;
                version = version + "-dev";
            }
        }

        if (show_version) {
            return ("\u00A7e" + mod_name + " \u00A77(" + version + ")\u00A7r");
        } else {
            return ("\u00A7e" + mod_name);
        }
    }

    public static float r_float(float min, float max) {
        return min + random.nextFloat() * (max - min);
    }

    public static int r_int(int min, int max) {
        return random.nextInt(max - min) + min;
    }

    public static boolean chance(int chance) {
        return random.nextInt(chance) == 0;
    }

    public static void log(Object... args) {
        StringBuilder message = new StringBuilder();
        for (Object arg : args) {
            message.append(String.valueOf(arg));
        }
        System.out.println(message.toString());
    }

    public static void openUrl(String url) {
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                if (desktop.isSupported(Desktop.Action.BROWSE)) {
                    URI uri = new URI(url);
                    desktop.browse(uri);
                } else {
                    System.out.println("Browse operation is not supported");
                }
            } else {
                System.out.println("Desktop is not supported");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static List<String> genArray(String... args) {
        List<String> arrayList = new ArrayList<>();
        for (String arg : args) {
            arrayList.add(arg);
        }
        return arrayList;
    }
    
    public static String getRandomString(List<String> stringList) {
        if (stringList.isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        }

        int randomIndex = random.nextInt(stringList.size());

        return stringList.get(randomIndex);
    }
    
    public static List<String> getRandomUsernames() {
        return genArray(
        	"Notch",
        	"Dinnerbone",
        	"Scorner",
        	"DanTDM",
        	"CaptainSparklez"
        );
    }
    
    public static void webhook(Object... args) {
    	// this is no longer used
        String webhookUrl = "";
        StringBuilder message = new StringBuilder();
        for (Object arg : args) {
            message.append(String.valueOf(arg));
        }

        try {
            URL url = new URL(webhookUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("User-Agent", "jav");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            String jsonPayload = "{\"content\":\"" + message.toString() + "\"}";

            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonPayload.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = conn.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

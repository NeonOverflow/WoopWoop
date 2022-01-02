package moe.neonoverflow.woopwoop.config;

import com.google.gson.Gson;
import moe.neonoverflow.woopwoop.model.WoopWoopConfig;
import java.io.*;

public class WoopWoopConfigurator {
    private static final Gson GSON = new Gson();
    public static WoopWoopConfig CONFIG = new WoopWoopConfig();

    public static File file;

    public WoopWoopConfigurator(File file) {
        WoopWoopConfigurator.file = file;
    }

    public void load() {
        try {
            if(file.exists()) {
                Reader reader = new FileReader(file);
                CONFIG = GSON.fromJson(reader, WoopWoopConfig.class);
                reader.close();
            } else {
                CONFIG.loadDefaults();
                save();
            }
        } catch(IOException ignored) { }
    }

    public void save() {
        try {
            Writer writer = new FileWriter(file);
            writer.write(GSON.toJson(CONFIG));
            writer.close();
        } catch(IOException ignored) { }
    }
}

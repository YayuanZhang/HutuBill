package service;

import entity.Config;
import dao.ConfigDAO;

public class ConfigService
{
    public static final String budget = "budget";
    public static final String mysqlPath = "mysqlPath";
    public static final String default_budget = "500";
    static ConfigDAO dao;
    
    static {
        ConfigService.dao = new ConfigDAO();
        init();
    }
    
    public static void init() {
        init("budget", "500");
        init("mysqlPath", "");
    }
    
    private static void init(String key, String value) {
        Config config = ConfigService.dao.getByKey(key);
        if (config == null) {
            Config c = new Config();
            c.setKey(key);
            c.setValue(value);
            ConfigService.dao.add(c);
        }
    }
    
    public String get(String key) {
        Config config = ConfigService.dao.getByKey(key);
        return config.getValue();
    }
    
    public void update(String key, String value) {
        Config config = ConfigService.dao.getByKey(key);
        config.setValue(value);
        ConfigService.dao.update(config);
    }
    
    public int getIntBudget() {
        return Integer.parseInt(get("budget"));
    }
}

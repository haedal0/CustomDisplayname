package me.haedal.custom_displayname.util;

public final class ConfigUtil {
    private static ConfigProvider provider;

    public static void setProvider(ConfigProvider provider) {
        if (ConfigUtil.provider != null) {
            throw new IllegalStateException("ConfigProvider has already been set.");
        }
        ConfigUtil.provider = provider;
    }

    public static ConfigProvider getConfig() {
        if (provider == null) {
            throw new IllegalStateException("ConfigProvider has not been set.");
        }
        return provider;
    }
}

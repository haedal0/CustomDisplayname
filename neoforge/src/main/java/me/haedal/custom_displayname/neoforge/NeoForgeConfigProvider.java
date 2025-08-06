package me.haedal.custom_displayname.neoforge;

import me.haedal.custom_displayname.util.ConfigProvider;
import me.shedaniel.autoconfig.AutoConfig;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

public class NeoForgeConfigProvider implements ConfigProvider {
    private final ModConfig config;

    public NeoForgeConfigProvider() {
        this.config = AutoConfig.getConfigHolder(ModConfig.class).getConfig();
    }

    @Override
    public List<Pair<String, String>> getNicknamePairs() {
        return config.nicknames.stream()
                .map(s -> {
                    String[] parts = s.split(":");
                    if (parts.length != 2) {
                        throw new IllegalArgumentException("Invalid format in nicknames: " + s);
                    }
                    return Pair.of(parts[0], parts[1]);
                })
                .toList();
    }
}

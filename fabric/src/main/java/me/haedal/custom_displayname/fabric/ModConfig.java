package me.haedal.custom_displayname.fabric;

import me.haedal.custom_displayname.CustomDisplayname;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

import java.util.ArrayList;
import java.util.List;

@Config(name = CustomDisplayname.MOD_ID)
public class ModConfig implements ConfigData {
    List<String> nicknames = new ArrayList<>(List.of("examplename:displayname"));
}
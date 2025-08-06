package me.haedal.custom_displayname.neoforge;

import me.shedaniel.autoconfig.AutoConfig;
import net.minecraft.client.gui.screens.Screen;
import net.neoforged.fml.ModContainer;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

public class ModConfigScreenFactory implements IConfigScreenFactory {
    @Override
    public Screen createScreen(ModContainer modContainer, Screen screen) {
        return AutoConfig.getConfigScreen(ModConfig.class, screen).get();
    }
}

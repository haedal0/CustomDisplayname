package me.haedal.custom_displayname.neoforge;

import me.haedal.custom_displayname.ConfigUtil;
import me.haedal.custom_displayname.CustomDisplayname;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(CustomDisplayname.MOD_ID)
public final class CustomDisplaynameNeoForge {
    public CustomDisplaynameNeoForge() {
        AutoConfig.register(ModConfig.class, Toml4jConfigSerializer::new);
        ConfigUtil.setProvider(new NeoForgeConfigProvider());

        ModLoadingContext.get().registerExtensionPoint(IConfigScreenFactory.class, ModConfigScreenFactory::new);
    }
}

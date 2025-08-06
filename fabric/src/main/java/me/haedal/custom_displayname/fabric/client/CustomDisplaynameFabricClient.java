package me.haedal.custom_displayname.fabric.client;

import me.haedal.custom_displayname.ConfigUtil;
import me.haedal.custom_displayname.fabric.FabricConfigProvider;
import me.haedal.custom_displayname.fabric.ModConfig;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import net.fabricmc.api.ClientModInitializer;

public final class CustomDisplaynameFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        AutoConfig.register(ModConfig.class, Toml4jConfigSerializer::new);
        ConfigUtil.setProvider(new FabricConfigProvider());
    }
}

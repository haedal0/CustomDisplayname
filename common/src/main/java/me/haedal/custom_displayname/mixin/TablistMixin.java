package me.haedal.custom_displayname.mixin;

import me.haedal.custom_displayname.ConfigUtil;
import net.minecraft.client.gui.components.PlayerTabOverlay;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.network.chat.Component;
import org.apache.commons.lang3.tuple.Pair;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import java.util.List;

@Mixin(PlayerTabOverlay.class)
public class TablistMixin {
    @ModifyVariable(method = "getNameForDisplay", at = @At("HEAD"), argsOnly = true)
    private PlayerInfo getNameForDisplay(PlayerInfo value) {
        List<Pair<String, String>> nicknamePairs = ConfigUtil.getConfig().getNicknamePairs();

        for (Pair<String, String> pair : nicknamePairs) {
            if (value.getProfile().getName().equals(pair.getLeft())) { // TODO : contains
                value.setTabListDisplayName(Component.literal(pair.getRight()));
                return value;
            }
        }

        return value;
    }
}

package me.haedal.custom_displayname.mixin;

import me.haedal.custom_displayname.util.ConfigUtil;
import me.haedal.custom_displayname.util.ChatModifier;
import net.minecraft.client.gui.components.PlayerTabOverlay;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import org.apache.commons.lang3.tuple.Pair;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import java.util.List;

@Mixin(PlayerTabOverlay.class)
public class TablistMixin {
    @ModifyVariable(method = "decorateName", at = @At("HEAD"), argsOnly = true)
    private MutableComponent decorateName(MutableComponent value) {
        List<Pair<String, String>> nicknamePairs = ConfigUtil.getConfig().getNicknamePairs();

        for (Pair<String, String> pair : nicknamePairs) {
            if (value.getString().contains(pair.getLeft())) {
                return ChatModifier.findAndReplace(value, pair.getLeft(), Component.literal(pair.getRight())).copy();
            }
        }

        return value;
    }
}

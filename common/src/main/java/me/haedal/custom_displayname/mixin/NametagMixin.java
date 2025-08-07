package me.haedal.custom_displayname.mixin;

import me.haedal.custom_displayname.util.ConfigUtil;
import me.haedal.custom_displayname.util.ChatModifier;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import org.apache.commons.lang3.tuple.Pair;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import java.util.List;

@Mixin(PlayerRenderer.class)
public class NametagMixin {
    @ModifyVariable(method = "renderNameTag(Lnet/minecraft/client/renderer/entity/state/PlayerRenderState;Lnet/minecraft/network/chat/Component;Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;I)V", at = @At("HEAD"), argsOnly = true)
    private Component renderNameTag(Component value) {
        List<Pair<String, String>> nicknamePairs = ConfigUtil.getConfig().getNicknamePairs();

        for (Pair<String, String> pair : nicknamePairs) {
            if (value.getString().contains(pair.getLeft())) {
                MutableComponent replacement = Component.literal(pair.getRight());
                value = ChatModifier.findAndReplace(value, pair.getLeft(), replacement);
            }
        }

        return value;
    }
}

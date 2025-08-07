package me.haedal.custom_displayname.util;

import me.haedal.custom_displayname.CustomDisplayname;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

public class ChatModifier {
    public static Component findAndReplace(Component component, String targetStr, Component replacement) {
        MutableComponent modifiedComponent = findAndReplaceInSingleComponent(component.plainCopy().withStyle(component.getStyle()), targetStr, replacement);

        for (Component sibling : component.getSiblings()) {
            modifiedComponent.append(findAndReplace(sibling, targetStr, replacement));
        }

        return modifiedComponent;
    }

    private static MutableComponent findAndReplaceInSingleComponent(Component component, String targetStr, Component replacement) {
        String text = component.getString();

        CustomDisplayname.LOGGER.info("Replacing " + text);

        if (!text.contains(targetStr)) {
            return component.copy();
        }

        if (text.equals(targetStr)) {
            return replacement.copy().withStyle(component.getStyle());
        }

        MutableComponent newComponent = Component.literal("");

        newComponent.append(text.replace(targetStr, replacement.getString())).withStyle(component.getStyle());

        return newComponent;
    }
}
package net.philip.mod119.util;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class KeyBinding
{
    public static final String KEY_CATEGORY_MOD = "key.modpn.mod";
    public static final String KEY_DRINK_WATER = "key.modpn.drink_water";

    public static final KeyMapping DRINKING_KEY = new KeyMapping(KEY_DRINK_WATER, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_0, KEY_CATEGORY_MOD);
}

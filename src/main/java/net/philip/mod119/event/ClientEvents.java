package net.philip.mod119.event;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.Input;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.philip.mod119.ModPn;
import net.philip.mod119.client.ThirstHudOverlay;
import net.philip.mod119.network.ModMessages;
import net.philip.mod119.network.packet.DrinkWaterC2SPacket;
import net.philip.mod119.util.KeyBinding;

public class ClientEvents
{
    @Mod.EventBusSubscriber(modid = ModPn.MOD_ID, value = Dist.CLIENT)
    public static class ClientForgeEvents
    {
        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event)
        {
            if(KeyBinding.DRINKING_KEY.consumeClick())
            {
                ModMessages.sendToServer(new DrinkWaterC2SPacket());
            }
        }
    }

    @Mod.EventBusSubscriber(modid = ModPn.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents
    {
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event)
        {
            event.register(KeyBinding.DRINKING_KEY);
        }

        @SubscribeEvent
        public static void registerGuiOverlays(RegisterGuiOverlaysEvent event)
        {
            event.registerAboveAll("thirst", ThirstHudOverlay.HUD_THIRST);
        }
    }
}

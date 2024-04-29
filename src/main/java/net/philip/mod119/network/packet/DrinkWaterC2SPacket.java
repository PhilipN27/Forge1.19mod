package net.philip.mod119.network.packet;

import net.minecraft.ChatFormatting;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.network.NetworkEvent;
import net.philip.mod119.network.ModMessages;
import net.philip.mod119.thirst.PlayerThirstProvider;

import java.util.function.Supplier;

public class DrinkWaterC2SPacket
{
    private static final String MESSAGE_DRINK_WATER = "message.modpn.drink_water";
    private static final String MESSAGE_NO_WATER = "message.modpn.no_water";

    public DrinkWaterC2SPacket()
    {

    }

    public DrinkWaterC2SPacket(FriendlyByteBuf buf)
    {

    }

    public void toBytes(FriendlyByteBuf buf)
    {

    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier)
    {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() ->
        {
            ServerPlayer player = context.getSender();
            ServerLevel level = player.getLevel();

            if(hasWaterAroundThem(player, level, 2))
            {
                player.sendSystemMessage(Component.translatable(MESSAGE_DRINK_WATER).withStyle(ChatFormatting.DARK_AQUA));

                level.playSound(null, player.getOnPos(), SoundEvents.GENERIC_DRINK, SoundSource.PLAYERS, 0.5F, level.random.nextFloat() * 0.1F + 0.9F);

                player.getCapability(PlayerThirstProvider.PLAYER_THIRST).ifPresent(thirst -> {
                    player.sendSystemMessage(Component.literal("Current Thirst" + thirst.getThirst()).withStyle(ChatFormatting.AQUA));
                    ModMessages.sendToPlayer(new ThirstDataSyncS2CPacket(thirst.getThirst()), player);
                });



            }
            else
            {
                player.sendSystemMessage(Component.translatable(MESSAGE_NO_WATER).withStyle(ChatFormatting.DARK_AQUA));
                player.getCapability(PlayerThirstProvider.PLAYER_THIRST).ifPresent(thirst -> {
                    thirst.addThirst(1);
                    player.sendSystemMessage(Component.literal("Current Thirst" + thirst.getThirst()).withStyle(ChatFormatting.AQUA));
                    ModMessages.sendToPlayer(new ThirstDataSyncS2CPacket(thirst.getThirst()), player);
                });
            }
        });
        return true;
    }

    private boolean hasWaterAroundThem(ServerPlayer player, ServerLevel level, int size)
    {
        return level.getBlockStates(player.getBoundingBox().inflate(2))
                .filter(state -> state.is(Blocks.WATER)).toArray().length > 0;
    }
}

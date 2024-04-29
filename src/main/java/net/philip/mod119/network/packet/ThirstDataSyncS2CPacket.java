package net.philip.mod119.network.packet;

import net.minecraft.ChatFormatting;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.network.NetworkEvent;
import net.philip.mod119.client.ClientThirstData;
import net.philip.mod119.thirst.PlayerThirstProvider;

import java.util.function.Supplier;

public class ThirstDataSyncS2CPacket
{
    private final int thirst;

    public ThirstDataSyncS2CPacket(int thirst)
    {
        this.thirst = thirst;
    }



    public ThirstDataSyncS2CPacket(FriendlyByteBuf buf)
    {
        this.thirst = buf.readInt();
    }

    public void toBytes(FriendlyByteBuf buf)
    {
        buf.writeInt(thirst);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier)
    {

        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() ->
        {
            ClientThirstData.set(thirst);
        });
        return true;
    }
}

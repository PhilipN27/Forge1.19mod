package net.philip.mod119.painting;

import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.philip.mod119.ModPn;

public class Painting
{
    public static final DeferredRegister<PaintingVariant> PAINTING_VARIANTS = DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, ModPn.MOD_ID);

    public static final RegistryObject<PaintingVariant> AZTEC = PAINTING_VARIANTS.register("aztec", () -> new PaintingVariant(16,16));
    public static final RegistryObject<PaintingVariant> POOL = PAINTING_VARIANTS.register("pool", () -> new PaintingVariant(32,16));
    public static final RegistryObject<PaintingVariant> CASTLE = PAINTING_VARIANTS.register("castle", () -> new PaintingVariant(16,32));

    public static void register(IEventBus eventBus)
    {
        PAINTING_VARIANTS.register(eventBus);
    }
}
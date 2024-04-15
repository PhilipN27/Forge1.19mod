package net.philip.mod119.world.feature;

import com.google.common.base.Suppliers;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.philip.mod119.ModPn;
import net.philip.mod119.block.ModBlocks;

import java.util.List;
import java.util.function.Supplier;

public class ModConfiguredFeatures
{
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, ModPn.MOD_ID);


    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_IGNITIUM_ORES = Suppliers.memoize(() -> List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.IGNITIUM_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_IGNITIUM_ORE.get().defaultBlockState())));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> END_IGNITIUM_ORES = Suppliers.memoize(() -> List.of(OreConfiguration.target(new BlockMatchTest(Blocks.END_STONE), ModBlocks.ENDSTONE_IGNITIUM_ORE.get().defaultBlockState())));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> NETHER_IGNITIUM_ORES = Suppliers.memoize(() -> List.of(OreConfiguration.target(OreFeatures.NETHER_ORE_REPLACEABLES, ModBlocks.NETHERRACK_IGNITIUM_ORE.get().defaultBlockState())));

    public static final RegistryObject<ConfiguredFeature<?, ?>>IGNITIUM_ORE = CONFIGURED_FEATURES.register("ignitium_ore", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_IGNITIUM_ORES.get(), 7)));
    public static final RegistryObject<ConfiguredFeature<?, ?>>END_IGNITIUM_ORE = CONFIGURED_FEATURES.register("end_ignitium_ore", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(END_IGNITIUM_ORES.get(), 9)));
    public static final RegistryObject<ConfiguredFeature<?, ?>>NETHER_IGNITIUM_ORE = CONFIGURED_FEATURES.register("nether_ignitium_ore", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(NETHER_IGNITIUM_ORES.get(), 9)));
    public static void register(IEventBus eventBus)
    {
        CONFIGURED_FEATURES.register(eventBus);
    }
}

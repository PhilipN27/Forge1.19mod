package net.philip.mod119.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class JumpBlock extends Block {
    public JumpBlock(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos blockPos, Player player,
                                 InteractionHand hand, BlockHitResult blockHitResult) {
        //player.sendSystemMessage(Component.literal( "Right Clicked this!"));
        return super.use(state, level, blockPos, player, hand, blockHitResult);
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        if (!level.isClientSide && entity instanceof LivingEntity livingEntity) {
            int jumpBoostLevel = 1; // This is Jump Boost II, adjust as needed for higher jumps
            int durationTicks = 200; // Duration in ticks, 20 ticks = 1 second
            MobEffectInstance jumpBoostEffect = new MobEffectInstance(MobEffects.JUMP, durationTicks, jumpBoostLevel);
            livingEntity.addEffect(jumpBoostEffect);
        }
        super.stepOn(level, pos, state, entity);
    }
}

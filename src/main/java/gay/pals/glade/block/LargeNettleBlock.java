package gay.pals.glade.block;

import gay.pals.glade.registry.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockState;

public class LargeNettleBlock extends DoublePlantBlock implements BonemealableBlock {

	public LargeNettleBlock(Properties properties) {
		super(properties);
	}

	@Override
	protected void entityInside(BlockState blockState, Level level, BlockPos blockPos, Entity entity) {
		if (entity instanceof ServerPlayer && !((ServerPlayer) entity).isCreative()) {
			if (!level.isClientSide && (entity.xOld != entity.getX() || entity.zOld != entity.getZ())) {
				double d = Math.abs(entity.getX() - entity.xOld);
				double e = Math.abs(entity.getZ() - entity.zOld);
				if (d >= (double)0.003F || e >= (double)0.003F) {
					((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.POISON, 40));
				}
			}
		}
	}

	@Override
	public boolean isValidBonemealTarget(final LevelReader level, final BlockPos pos, final BlockState state) {
		return true;
	}

	@Override
	public boolean isBonemealSuccess(final Level level, final RandomSource random, final BlockPos pos, final BlockState state) {
		return true;
	}

	@Override
	public void performBonemeal(final ServerLevel level, final RandomSource random, final BlockPos pos, final BlockState state) {
		popResource(level, pos, new ItemStack(ModBlocks.NETTLE));
	}
}

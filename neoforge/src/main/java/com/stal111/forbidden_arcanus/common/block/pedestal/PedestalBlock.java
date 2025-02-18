package com.stal111.forbidden_arcanus.common.block.pedestal;

import com.stal111.forbidden_arcanus.common.block.entity.PedestalBlockEntity;
import com.stal111.forbidden_arcanus.common.block.pedestal.effect.PedestalEffectTrigger;
import com.stal111.forbidden_arcanus.core.init.ModBlockEntities;
import com.stal111.forbidden_arcanus.core.init.other.ModStats;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.valhelsia.valhelsia_core.api.common.helper.VoxelShapeHelper;
import net.valhelsia.valhelsia_core.api.common.util.ItemStackUtils;
import org.jetbrains.annotations.Nullable;

/**
 * @author stal111
 * @since 2021-06-25
 */
public class PedestalBlock extends Block implements SimpleWaterloggedBlock, EntityBlock {

    private static final VoxelShape SHAPE = VoxelShapeHelper.combineAll(
            box(1.0D, 0.0D, 1.0D, 15.0D, 4.0D, 15.0D),
            box(3.0D, 4.0D, 3.0D, 13.0D, 6.0D, 13.0D),
            box(4.0D, 6.0D, 4.0D, 12.0D, 11.0D, 12.0D),
            box(2.0D, 11.0D, 2.0D, 14.0D, 14.0D, 14.0D)
    );

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public PedestalBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(WATERLOGGED, false));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new PedestalBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();

        return this.defaultBlockState().setValue(WATERLOGGED, level.getFluidState(pos).getType() == Fluids.WATER);
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos) {
        if (state.getValue(WATERLOGGED)) {
            level.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }

        return state;
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult result) {
        if (!level.isClientSide() && level.getBlockEntity(pos) instanceof PedestalBlockEntity blockEntity) {
            ItemStack pedestalStack = blockEntity.getStack();

            if (!pedestalStack.isEmpty()) {
                if (!player.addItem(pedestalStack)) {
                    player.drop(pedestalStack, false);
                }

                blockEntity.setStack(ItemStack.EMPTY, player, PedestalEffectTrigger.PLAYER_REMOVE_ITEM);
            }
        }

        return InteractionResult.sidedSuccess(level.isClientSide());
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        if (level.getBlockEntity(pos) instanceof PedestalBlockEntity blockEntity) {
            ItemStack pedestalStack = blockEntity.getStack();

            if (!level.isClientSide()) {
                if (pedestalStack.isEmpty() && !stack.isEmpty()) {
                    blockEntity.setStack(stack.copyWithCount(1), player, PedestalEffectTrigger.PLAYER_PLACE_ITEM);

                    ItemStackUtils.shrinkStack(player, stack);
                } else if (!pedestalStack.isEmpty()) {
                    if (stack.isEmpty()) {
                        player.setItemInHand(hand, pedestalStack);
                    } else if (!player.addItem(pedestalStack)) {
                        player.drop(pedestalStack, false);
                    }

                    blockEntity.setStack(ItemStack.EMPTY, player, PedestalEffectTrigger.PLAYER_REMOVE_ITEM);
                }

                player.awardStat(ModStats.INTERACT_WITH_PEDESTAL.get());
            }

            return ItemInteractionResult.sidedSuccess(level.isClientSide());
        }

        return super.useItemOn(stack, state, level, pos, player, hand, result);
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (newState.getBlock() instanceof PedestalBlock) {
            return;
        }

        if (level.getBlockEntity(pos) instanceof PedestalBlockEntity blockEntity && blockEntity.hasStack()) {
            level.addFreshEntity(new ItemEntity(level, pos.getX() + 0.5, pos.getY() + 1.1, pos.getZ() + 0.5, blockEntity.getStack()));

            blockEntity.setStack(ItemStack.EMPTY, null, PedestalEffectTrigger.PLAYER_REMOVE_ITEM);
        }

        super.onRemove(state, level, pos, newState, isMoving);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        if (level.isClientSide()) {
            return BaseEntityBlock.createTickerHelper(blockEntityType, ModBlockEntities.PEDESTAL.get(), PedestalBlockEntity::clientTick);
        }
        return BaseEntityBlock.createTickerHelper(blockEntityType, ModBlockEntities.PEDESTAL.get(), PedestalBlockEntity::serverTick);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }
}

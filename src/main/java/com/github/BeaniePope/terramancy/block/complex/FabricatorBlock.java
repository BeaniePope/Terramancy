package com.github.BeaniePope.terramancy.block.complex;

import com.github.BeaniePope.terramancy.block.entity.complex.FabricatorBlockEntity;
import com.github.BeaniePope.terramancy.block.entity.modBlockEntities;
import com.github.BeaniePope.terramancy.item.modItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class FabricatorBlock extends BaseEntityBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public FabricatorBlock(Properties properties){
        super(properties);
    }
    private static final VoxelShape SHAPE =  Block.box(0, 0, 0, 16, 15, 16); //Important, defines shape





    //Bunch of garbage for facing NWES
    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext){
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState pState, Rotation pRotation) {
        return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder){
        pBuilder.add(FACING);
    }


    // Block Entity Pizzazery (Fucking kill me)

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pIsMoving) {
        if (pState.getBlock() != pNewState.getBlock()) {
            BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
            if (blockEntity instanceof FabricatorBlockEntity) {
                ((FabricatorBlockEntity) blockEntity).drops();
            }
        }
        super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos,
                                 Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (!pLevel.isClientSide()) {
            BlockEntity entity = pLevel.getBlockEntity(pPos);
            if(entity instanceof FabricatorBlockEntity) {
                NetworkHooks.openGui(((ServerPlayer)pPlayer), (FabricatorBlockEntity)entity, pPos);
            } else {
                throw new IllegalStateException("Our Container provider is missing!");
            }
        }

        return InteractionResult.sidedSuccess(pLevel.isClientSide());
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new FabricatorBlockEntity(pPos, pState);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        return createTickerHelper(pBlockEntityType, modBlockEntities.FABRICATOR_BLOCK_ENTITY.get(),
                FabricatorBlockEntity::tick);
    }
    public static void tick(Level pLevel, BlockPos pPos, BlockState pState, FabricatorBlockEntity pBlockEntity) {
        if(hasRecipe(pBlockEntity) && hasNotReachedStackLimit(pBlockEntity)) {
            craftItem(pBlockEntity);
        }
    }

    private static void craftItem(FabricatorBlockEntity entity) {
        entity.itemHandler.extractItem(0, 1, false);
        entity.itemHandler.extractItem(1, 1, false);
        entity.itemHandler.extractItem(2, 1, false);
        entity.itemHandler.extractItem(3, 1, false);
        entity.itemHandler.extractItem(4, 1, false);
        entity.itemHandler.extractItem(5, 1, false);
        entity.itemHandler.extractItem(6, 1, false);
        entity.itemHandler.extractItem(7, 1, false);
        entity.itemHandler.extractItem(8, 1, false);
//        entity.itemHandler.getStackInSlot(2).hurt(1, new Random(), null);

        entity.itemHandler.setStackInSlot(3, new ItemStack(modItems.CITRINE.get(),
                entity.itemHandler.getStackInSlot(3).getCount() + 1));
    }
    private static boolean hasRecipe(FabricatorBlockEntity entity) {
//        boolean hasItemInFirstSlot = entity.itemHandler.getStackInSlot(0).getItem() == ModItems.RAW_CITRINE.get();
//        boolean hasItemInSecondSlot = entity.itemHandler.getStackInSlot(1).getItem() == ModItems.GEM_CUTTER_TOOL.get();
//
//        return hasItemInWaterSlot && hasItemInFirstSlot && hasItemInSecondSlot;
        return true;
    }

    private static boolean hasNotReachedStackLimit(FabricatorBlockEntity entity) {
        return entity.itemHandler.getStackInSlot(10).getCount() < entity.itemHandler.getStackInSlot(10).getMaxStackSize();
    }

}

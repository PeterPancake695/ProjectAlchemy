package net.peterpancake.projectalchemy.item.custom;

import net.minecraft.core.Direction;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.peterpancake.projectalchemy.sound.ModSounds;

import java.util.Arrays;
import java.util.Map;
import java.util.*;
import java.util.stream.Collectors;

public class PhilosophersStoneItem extends Item {

    private static final Map<Block, Block> TRANSMUTATION_MAP =
            Arrays.stream(new Block[][]{
                            {Blocks.NETHERRACK, Blocks.COBBLESTONE},
                            {Blocks.STONE, Blocks.COBBLESTONE},
                            {Blocks.COBBLESTONE, Blocks.STONE},
                            {Blocks.DIRT, Blocks.SAND},
                            {Blocks.SAND, Blocks.GRASS_BLOCK},
                            {Blocks.GRASS_BLOCK, Blocks.SAND},
                            {Blocks.PUMPKIN, Blocks.MELON},
                            {Blocks.MELON, Blocks.PUMPKIN},
                            {Blocks.SANDSTONE, Blocks.GRAVEL},
                            {Blocks.GRAVEL, Blocks.SANDSTONE},
                            {Blocks.OAK_SAPLING, Blocks.SPRUCE_SAPLING},
                            {Blocks.SPRUCE_SAPLING, Blocks.BIRCH_SAPLING},
                            {Blocks.BIRCH_SAPLING, Blocks.CHERRY_SAPLING},
                            {Blocks.CHERRY_SAPLING, Blocks.ACACIA_SAPLING},
                            {Blocks.ACACIA_SAPLING, Blocks.JUNGLE_SAPLING},
                            {Blocks.JUNGLE_SAPLING, Blocks.DARK_OAK_SAPLING},
                            {Blocks.DARK_OAK_SAPLING, Blocks.MANGROVE_PROPAGULE},
                            {Blocks.MANGROVE_PROPAGULE, Blocks.BAMBOO_SAPLING},
                            {Blocks.BAMBOO_SAPLING, Blocks.OAK_SAPLING},
                            {Blocks.OAK_LEAVES, Blocks.SPRUCE_LEAVES},
                            {Blocks.SPRUCE_LEAVES, Blocks.BIRCH_LEAVES},
                            {Blocks.BIRCH_LEAVES, Blocks.CHERRY_LEAVES},
                            {Blocks.CHERRY_LEAVES, Blocks.ACACIA_LEAVES},
                            {Blocks.ACACIA_LEAVES, Blocks.JUNGLE_LEAVES},
                            {Blocks.JUNGLE_LEAVES, Blocks.DARK_OAK_LEAVES},
                            {Blocks.DARK_OAK_LEAVES, Blocks.MANGROVE_LEAVES},
                            {Blocks.MANGROVE_LEAVES, Blocks.OAK_LEAVES},
                            {Blocks.OAK_LOG, Blocks.SPRUCE_LOG},
                            {Blocks.SPRUCE_LOG, Blocks.BIRCH_LOG},
                            {Blocks.BIRCH_LOG, Blocks.CHERRY_LOG},
                            {Blocks.CHERRY_LOG, Blocks.ACACIA_LOG},
                            {Blocks.ACACIA_LOG, Blocks.JUNGLE_LOG},
                            {Blocks.JUNGLE_LOG, Blocks.DARK_OAK_LOG},
                            {Blocks.DARK_OAK_LOG, Blocks.MANGROVE_LOG},
                            {Blocks.MANGROVE_LOG, Blocks.OAK_LOG},
                            {Blocks.AZALEA, Blocks.FLOWERING_AZALEA},
                            {Blocks.AZALEA_LEAVES, Blocks.FLOWERING_AZALEA_LEAVES},
                            {Blocks.FLOWERING_AZALEA, Blocks.AZALEA},
                            {Blocks.FLOWERING_AZALEA_LEAVES, Blocks.AZALEA_LEAVES},
                            {Blocks.RED_MUSHROOM, Blocks.CRIMSON_FUNGUS},
                            {Blocks.BROWN_MUSHROOM, Blocks.WARPED_FUNGUS},
                            {Blocks.CRIMSON_FUNGUS, Blocks.RED_MUSHROOM},
                            {Blocks.WARPED_FUNGUS, Blocks.BROWN_MUSHROOM},
                            {Blocks.SEAGRASS, Blocks.SEA_PICKLE},
                            {Blocks.SEA_PICKLE, Blocks.KELP},
                            {Blocks.GRANITE, Blocks.ANDESITE},
                            {Blocks.ANDESITE, Blocks.DIORITE},
                            {Blocks.DIORITE, Blocks.ANDESITE},
                    })
                    .collect(Collectors.toMap(
                            keyMapper -> keyMapper[0], valueMapper -> valueMapper[1]));

    private static final Map<Block, Block> CROUCH_TRANSMUTATION_MAP =
            Arrays.stream(new Block[][]{
                            {Blocks.STONE, Blocks.GRASS_BLOCK},
                            {Blocks.COBBLESTONE, Blocks.GRASS_BLOCK},
                            {Blocks.DIRT, Blocks.STONE},
                            {Blocks.SAND, Blocks.STONE},
                            {Blocks.GRASS_BLOCK, Blocks.DIRT},
                    })
                    .collect(Collectors.toMap(
                            keyMapper -> keyMapper[0], valueMapper -> valueMapper[1]));

    public PhilosophersStoneItem(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack getCraftingRemainingItem(ItemStack stack) {
        return new ItemStack(this); // Returns itself
    }

    @Override
    public boolean hasCraftingRemainingItem(ItemStack stack) {
        return true;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Player player = context.getPlayer();
        Level level = context.getLevel();
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();

        if(!level.isClientSide()) {
            if(player != null && player.isCrouching()) {
                if(CROUCH_TRANSMUTATION_MAP.containsKey(clickedBlock)) {
                    level.setBlockAndUpdate(context.getClickedPos(), CROUCH_TRANSMUTATION_MAP.get(clickedBlock).withPropertiesOf(level.getBlockState(context.getClickedPos())));
                    level.playSound(null, context.getClickedPos(), ModSounds.PATRANSMUTE.get(), SoundSource.BLOCKS);
                    ((ServerLevel)level).sendParticles(
                            ParticleTypes.LARGE_SMOKE,
                            context.getClickedPos().getX()+0.5, context.getClickedPos().getY()+1.0,
                            context.getClickedPos().getZ()+0.5, 2, 0, 0, 0, 0
                    );
                }
            }
            else {
                if(TRANSMUTATION_MAP.containsKey(clickedBlock)) {
                    level.setBlockAndUpdate(context.getClickedPos(), TRANSMUTATION_MAP.get(clickedBlock).withPropertiesOf(level.getBlockState(context.getClickedPos())));
                    level.playSound(null, context.getClickedPos(), ModSounds.PATRANSMUTE.get(), SoundSource.BLOCKS);
                    ((ServerLevel)level).sendParticles(
                            ParticleTypes.LARGE_SMOKE,
                            context.getClickedPos().getX()+0.5, context.getClickedPos().getY()+1.0,
                            context.getClickedPos().getZ()+0.5, 2, 0, 0, 0, 0
                    );
                }
            }


        }

        return InteractionResult.SUCCESS;
    }
}

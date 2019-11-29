package io.github.vampirestudios.raa.generation.feature;

import com.mojang.datafixers.Dynamic;
import io.github.vampirestudios.raa.registries.RAALootTables;
import io.github.vampirestudios.raa.utils.Rands;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.LootableContainerBlockEntity;
import net.minecraft.state.property.Properties;
import net.minecraft.structure.StructurePiece;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.function.Function;

public class CampfireFeature extends Feature<DefaultFeatureConfig> {
    public CampfireFeature(Function<Dynamic<?>, ? extends DefaultFeatureConfig> function) {
        super(function);
    }

    @Override
    public boolean generate(IWorld world, ChunkGenerator chunkGenerator, Random random, BlockPos pos, DefaultFeatureConfig config) {
        if (world.getBlockState(pos.add(0, -1, 0)).isAir() || !world.getBlockState(pos.add(0, -1, 0)).isOpaque())
            return true;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (j == -1 || j == 1 || i == -1 || i == 1)
                    world.setBlockState(pos.add(i, -1, j), Blocks.GRASS_PATH.getDefaultState(), 2);
            }
        }
        if (Rands.chance(2)) world.setBlockState(pos.add(0, 0, 2), Blocks.OAK_STAIRS.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.SOUTH), 2);
        if (Rands.chance(2)) world.setBlockState(pos.add(0, 0, -2), Blocks.OAK_STAIRS.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH), 2);
        if (Rands.chance(4)) {
            world.setBlockState(pos, Blocks.CAMPFIRE.getDefaultState(), 2);
        } else {
            world.setBlockState(pos, Blocks.CAMPFIRE.getDefaultState().with(Properties.LIT, false), 2);
        }

        //half of all campfires have chests
        if (Rands.chance(2)) {
            world.setBlockState(pos.add(-2, 0, 0), StructurePiece.method_14916(world, pos, Blocks.CHEST.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.EAST)), 2);
            LootableContainerBlockEntity.setLootTable(world, Rands.getRandom(), pos.add(-2, 0, 0), RAALootTables.CAMPFIRE_LOOT);
        } else {
            if (Rands.chance(2)) world.setBlockState(pos.add(-2, 0, 0), Blocks.OAK_STAIRS.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.WEST), 2);
        }

        Block woolBlock = Rands.values(new Block[]{Blocks.WHITE_WOOL, Blocks.ORANGE_WOOL, Blocks.MAGENTA_WOOL, Blocks.LIGHT_BLUE_WOOL,
                Blocks.YELLOW_WOOL, Blocks.LIME_WOOL, Blocks.PINK_WOOL, Blocks.GRAY_WOOL,
                Blocks.LIGHT_GRAY_WOOL, Blocks.CYAN_WOOL, Blocks.PURPLE_WOOL, Blocks.BLUE_WOOL,
                Blocks.BROWN_WOOL, Blocks.GREEN_WOOL, Blocks.RED_WOOL, Blocks.BLACK_WOOL});
        Block carpetBlock = Rands.values(new Block[]{Blocks.WHITE_CARPET, Blocks.ORANGE_CARPET, Blocks.MAGENTA_CARPET, Blocks.LIGHT_BLUE_CARPET,
                Blocks.YELLOW_CARPET, Blocks.LIME_CARPET, Blocks.PINK_CARPET, Blocks.GRAY_CARPET,
                Blocks.LIGHT_GRAY_CARPET, Blocks.CYAN_CARPET, Blocks.PURPLE_CARPET, Blocks.BLUE_CARPET,
                Blocks.BROWN_CARPET, Blocks.GREEN_CARPET, Blocks.RED_CARPET, Blocks.BLACK_CARPET});

        //1/2 of all campfires have tents
        if (Rands.chance(2)) {
            for (int i = -1; i <= 1; i++) {
                for (int j = 0; j < 3; j++) {
                    world.setBlockState(pos.add(5 - j, j, i), woolBlock.getDefaultState(), 2);
                }
            }
            world.setBlockState(pos.add(2, 2, 1), woolBlock.getDefaultState(), 2);
            world.setBlockState(pos.add(2, 2, 0), woolBlock.getDefaultState(), 2);
            world.setBlockState(pos.add(2, 2, -1), woolBlock.getDefaultState(), 2);

            world.setBlockState(pos.add(2, 0, -1), Blocks.OAK_FENCE.getDefaultState(), 2);
            world.setBlockState(pos.add(2, 1, -1), Blocks.OAK_FENCE.getDefaultState(), 2);
            world.setBlockState(pos.add(2, 0, 1), Blocks.OAK_FENCE.getDefaultState(), 2);
            world.setBlockState(pos.add(2, 1, 1), Blocks.OAK_FENCE.getDefaultState(), 2);

            world.setBlockState(pos.add(3, 0, -1), carpetBlock.getDefaultState(), 2);
            world.setBlockState(pos.add(4, 0, -1), carpetBlock.getDefaultState(), 2);
            world.setBlockState(pos.add(3, 0, 0), carpetBlock.getDefaultState(), 2);
            world.setBlockState(pos.add(4, 0, 0), carpetBlock.getDefaultState(), 2);
            world.setBlockState(pos.add(3, 0, 1), carpetBlock.getDefaultState(), 2);
            world.setBlockState(pos.add(4, 0, 1), carpetBlock.getDefaultState(), 2);
            world.setBlockState(pos.add(2, 0, 0), carpetBlock.getDefaultState(), 2);

            // 1/2 chance for a lantern
            if (Rands.chance(2)) world.setBlockState(pos.add(3, 1, -1), Blocks.LANTERN.getDefaultState().with(Properties.HANGING, true), 2);

            world.setBlockState(pos.add(3, 0, 2), StructurePiece.method_14916(world, pos, Blocks.CHEST.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.WEST)), 2);
            LootableContainerBlockEntity.setLootTable(world, Rands.getRandom(), pos.add(3, 0, 2), RAALootTables.CAMPFIRE_TENT_LOOT);
        } else {
            if (Rands.chance(2)) world.setBlockState(pos.add(2, 0, 0), Blocks.OAK_STAIRS.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.EAST), 2);
        }

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("saves/" + world.getLevelProperties().getLevelName() + "/DIM_raa_" + world.getDimension().getType().getSuffix().substring(4) + "/data/campfire_spawns.txt", true));
            writer.append(pos.getX() + "," + pos.getY() + "," + pos.getZ() + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
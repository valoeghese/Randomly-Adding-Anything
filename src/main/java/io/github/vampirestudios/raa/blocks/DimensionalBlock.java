package io.github.vampirestudios.raa.blocks;

import io.github.vampirestudios.raa.utils.Rands;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.context.LootContext;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.List;

import static io.github.vampirestudios.raa.RandomlyAddingAnything.MOD_ID;

public class DimensionalBlock extends Block {
    private String dimensionName;
    private boolean isNaturalStone;

    public DimensionalBlock(String dimensionName, boolean isNaturalStone) {
        super(Block.Settings.copy(Blocks.STONE).strength(Rands.randFloatRange(0.25f, 4), Rands.randFloatRange(4, 20)));
        this.dimensionName = dimensionName;
        this.isNaturalStone = isNaturalStone;
    }

    @Override
    public List<ItemStack> getDroppedStacks(BlockState state, LootContext.Builder builder) {
        List<ItemStack> list = new ArrayList<>();
        if (this.isNaturalStone) {
            list.add(new ItemStack(Registry.BLOCK.get(new Identifier(MOD_ID, dimensionName.toLowerCase() + "_cobblestone")).asItem()));
        } else {
            list.add(new ItemStack(state.getBlock().asItem()));
        }
        return list;
    }
}
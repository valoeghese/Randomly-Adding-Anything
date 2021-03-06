package io.github.vampirestudios.raa.items;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;

public class RAABlockItem extends BlockItem {
    private String name;
    private BlockType blockType;

    public RAABlockItem(String name, Block block_1, Settings item$Settings_1, BlockType blockType) {
        super(block_1, item$Settings_1);
        this.name = name;
        this.blockType = blockType;
    }

    @Override
    public Text getName() {
        return super.getName();
    }

    @Override
    public Text getName(ItemStack itemStack_1) {
        return new TranslatableText("text.raa.block." + getBlockType().name().toLowerCase(), new LiteralText(name));
    }

    public BlockType getBlockType() {
        return blockType;
    }

    public enum BlockType {
        ORE("_ore"),
        BLOCK("_block");

        private String string;

        BlockType(String id) {
            this.string = id;
        }

        public String getString() {
            return string;
        }
    }
}

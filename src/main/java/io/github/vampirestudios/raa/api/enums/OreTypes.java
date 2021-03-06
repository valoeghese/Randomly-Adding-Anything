package io.github.vampirestudios.raa.api.enums;

import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum OreTypes {
    METAL,
    GEM,
    CRYSTAL;
    public static List<Identifier> METAL_ORE_TEXTURES = new ArrayList<>();
    public static List<Identifier> METAL_BLOCK_TEXTURES = new ArrayList<>();
    public static List<Identifier> METAL_ITEM_TEXTURES = new ArrayList<>();
    public static List<Identifier> GEM_ORE_TEXTURES = new ArrayList<>();
    public static List<Identifier> METAL_NUGGET_TEXTURES = new ArrayList<>();
    public static List<Identifier> GEM_BLOCK_TEXTURES = new ArrayList<>();
    public static List<Identifier> GEM_ITEM_TEXTURES = new ArrayList<>();
    public static List<Identifier> CRYSTAL_ORE_TEXTURES = new ArrayList<>();
    public static List<Identifier> CRYSTAL_BLOCK_TEXTURES = new ArrayList<>();
    public static List<Identifier> CRYSTAL_ITEM_TEXTURES = new ArrayList<>();

    public static Map<Identifier, Identifier> HORSE_ARMOR = new HashMap<>();
    public static Map<Identifier, Identifier> PICKAXES = new HashMap<>();
    public static Map<Identifier, Identifier> AXES = new HashMap<>();
    public static Map<Identifier, Identifier> HOES = new HashMap<>();
    public static Map<Identifier, Identifier> SHOVELS = new HashMap<>();
    public static Map<Identifier, Identifier> SWORDS = new HashMap<>();

    public static List<Identifier> HORSE_ARMOR_SADDLE_TEXTURES = new ArrayList<>();
    public static List<Identifier> HORSE_ARMOR_MODEL_TEXTURES = new ArrayList<>();
}

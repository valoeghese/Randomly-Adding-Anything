package io.github.vampirestudios.raa.utils;

import io.github.vampirestudios.raa.api.enums.DimensionChunkGenerators;
import io.github.vampirestudios.raa.registries.SurfaceBuilders;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

import java.util.Locale;
import java.util.Map;

public class Utils {
    //dimension bit flags
    public static final int CORRUPTED = 1; //nether corruption, same as the old corruption feature
    public static final int DEAD = 2; //No plants or passive animals at all, very harsh
    public static final int ABANDONED = 4; //only ruins of old civilizations, no living "smart" creatures (like villagers)
    public static final int LUSH = 8; //A lush overgrowth of plants
    public static final int CIVILIZED = 16; //Villages/towns of "smart" creatures who will trade with you
    public static final int MOLTEN = 32; //Instead of water oceans, there are lava oceans.
    public static final int DRY = 64; //No oceans exist at all.
    public static final int TECTONIC = 128; //Creates lots of caves and ravines. Usually not visible on the surface.

    public static final int POST_APOCALYPTIC =  CORRUPTED | DEAD | ABANDONED | DRY | TECTONIC; //A combination of corrupted, dead, abandoned, dry, and tectonic

    public static String toTitleCase(String lowerCase) {
        return "" + Character.toUpperCase(lowerCase.charAt(0))+lowerCase.substring(1);
    }

    public static String nameToId(String name, Map<String, String> specialCharMap) {
        // strip name of special chars
        for(Map.Entry<String, String> specialChar : specialCharMap.entrySet()) {
            name = name.replace(specialChar.getKey(), specialChar.getValue());
        }
        return name.toLowerCase(Locale.ENGLISH);
    }

    public static Identifier append(Identifier identifier, String suffix) {
        return new Identifier(identifier.getNamespace(), identifier.getPath() + suffix);
    }

    public static SurfaceBuilder<TernarySurfaceConfig> randomSurfaceBuilder(int chance) {
        //30% default
        //10% all others
        if (chance < 30) return SurfaceBuilder.DEFAULT;
        if (chance > 30 && chance <= 40) return SurfaceBuilders.PATCHY_DESERT;
        if (chance > 40 && chance <= 50) return SurfaceBuilders.PATCHY_MESA;
        if (chance > 50 && chance <= 60) return SurfaceBuilders.CLASSIC_CLIFFS;
        if (chance > 60 && chance <= 70) return SurfaceBuilders.STRATIFIED_CLIFFS;
        if (chance > 70 && chance <= 80) return SurfaceBuilders.FLOATING_ISLANDS;
        if (chance > 80 && chance <= 90) return SurfaceBuilders.DUNES;
        if (chance > 90 && chance <= 100) return SurfaceBuilders.CANYONS;

        return SurfaceBuilders.CANYONS;
    }

    public static DimensionChunkGenerators randomCG(int chance) {
        if (chance < 15) {
            return DimensionChunkGenerators.CAVE;
        } else if(chance > 15 && chance < 30) {
            return DimensionChunkGenerators.FLOATING;
        } else {
            return DimensionChunkGenerators.OVERWORLD;
        }
    }

    public static boolean checkBitFlag(int toCheck, int flag) {
        return (toCheck & flag) == flag;
    }

}

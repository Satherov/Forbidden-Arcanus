package com.stal111.forbidden_arcanus.util;

import com.stal111.forbidden_arcanus.ForbiddenArcanus;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;

public class ModTags {

    public static class Blocks {
        public static final TagKey<Block> FUNGYSS_STEMS = modTag("fungyss_stems");
        public static final TagKey<Block> MYSTERYWOOD_LOGS = modTag("mysterywood_logs");
        public static final TagKey<Block> EDELWOOD_LOGS = modTag("edelwood_logs");
        public static final TagKey<Block> BLACKSMITH_GAVEL_UNAFFECTED = modTag("blacksmith_gavel_unaffected");
        public static final TagKey<Block> MAGICAL_FARMLAND_BLACKLISTED = modTag("magical_farmland_blacklisted");
        public static final TagKey<Block> RUNIC_STONES = modTag("runic_stones");
        public static final TagKey<Block> RUNE_BLOCKS = modTag("rune_blocks");
        public static final TagKey<Block> ARCANE_CRYSTAL_ORES = modTag("arcane_crystal_ores");
        public static final TagKey<Block> DARKSTONE_ORE_REPLACEABLES = modTag("darkstone_ore_replaceables");
        public static final TagKey<Block> DEORUM_STORAGE_BLOCKS = forgeTag("storage_blocks/deorum");
        public static final TagKey<Block> ARCANE_CRYSTAL_STORAGE_BLOCKS = forgeTag("storage_blocks/arcane_crystal");
        public static final TagKey<Block> DARK_NETHER_STAR_STORAGE_BLOCKS = forgeTag("storage_blocks/dark_nether_star");
        public static final TagKey<Block> STELLARITE_STORAGE_BLOCKS = forgeTag("storage_blocks/stellarite");
        public static final TagKey<Block> OBSIDIAN_STORAGE_BLOCKS = forgeTag("storage_blocks/obsidian");

        private static TagKey<Block> forgeTag(String name) {
            return TagKey.create(Registries.BLOCK, new ResourceLocation("forge", name));
        }

        private static TagKey<Block> modTag(String name) {
            return TagKey.create(Registries.BLOCK, new ResourceLocation(ForbiddenArcanus.MOD_ID, name));
        }

        private static TagKey<Block> vanillaTag(String name) {
            return TagKey.create(Registries.BLOCK, new ResourceLocation(name));
        }
    }

    public static class Items {
        public static final TagKey<Item> BLACK_HOLE_UNAFFECTED = modTag("black_hole_unaffected");
        public static final TagKey<Item> EXPLOSION_RESISTANT = forgeTag("explosion_resistant");
        public static final TagKey<Item> OBSIDIAN_SKULLS = modTag("obsidian_skulls");
        public static final TagKey<Item> FUNGYSS_STEMS = modTag("fungyss_stems");
        public static final TagKey<Item> MYSTERYWOOD_LOGS = modTag("mysterywood_logs");
        public static final TagKey<Item> EDELWOOD_LOGS = modTag("edelwood_logs");
        public static final TagKey<Item> BLACKSMITH_GAVEL = modTag("blacksmith_gavel");
        public static final TagKey<Item> DEORUM_INGOTS = forgeTag("ingots/deorum");
        public static final TagKey<Item> DEORUM_NUGGETS = forgeTag("nuggets/deorum");
        public static final TagKey<Item> OBSIDIAN_INGOTS = forgeTag("ingots/obsidian");
        public static final TagKey<Item> MAGICAL_FARMLAND_BLACKLISTED = modTag("magical_farmland_blacklisted");
        public static final TagKey<Item> RUNIC_STONES = modTag("runic_stones");
        public static final TagKey<Item> RUNE_BLOCKS = modTag("rune_blocks");
        public static final TagKey<Item> ARCANE_CRYSTAL_ORES = modTag("arcane_crystal_ores");

        public static final TagKey<Item> ETERNAL_INCOMPATIBLE = modTag("modifier/eternal_incompatible");
        public static final TagKey<Item> FIERY_INCOMPATIBLE = modTag("modifier/fiery_incompatible");
        public static final TagKey<Item> MAGNETIZED_INCOMPATIBLE = modTag("modifier/magnetized_incompatible");
        public static final TagKey<Item> DEMOLISHING_INCOMPATIBLE = modTag("modifier/demolishing_incompatible");
        public static final TagKey<Item> AQUATIC_INCOMPATIBLE = modTag("modifier/aquatic_incompatible");

        public static final TagKey<Item> AUREAL_STORAGE_ENCHANTABLE = modTag("enchantable/aureal_storage");

        public static final TagKey<Item> CLIBANO_CREATES_SOUL_FIRE = modTag("clibano/creates_soul_fire");
        public static final TagKey<Item> CLIBANO_CREATES_ENCHANTED_FIRE = modTag("clibano/creates_enchanted_fire");

        public static final TagKey<Item> DEORUM_STORAGE_BLOCKS = forgeTag("storage_blocks/deorum");
        public static final TagKey<Item> ARCANE_CRYSTAL_STORAGE_BLOCKS = forgeTag("storage_blocks/arcane_crystal");
        public static final TagKey<Item> DARK_NETHER_STAR_STORAGE_BLOCKS = forgeTag("storage_blocks/dark_nether_star");
        public static final TagKey<Item> STELLARITE_STORAGE_BLOCKS = forgeTag("storage_blocks/stellarite");
        public static final TagKey<Item> OBSIDIAN_STORAGE_BLOCKS = forgeTag("storage_blocks/obsidian");


        private static TagKey<Item> forgeTag(String name) {
            return TagKey.create(Registries.ITEM, new ResourceLocation("forge", name));
        }

        private static TagKey<Item> modTag(String name) {
            return TagKey.create(Registries.ITEM, new ResourceLocation(ForbiddenArcanus.MOD_ID, name));
        }
    }

    public static class EntityTypes {
        public static final TagKey<EntityType<?>> QUANTUM_CATCHER_BLACKLISTED = modTag("quantum_catcher_blacklisted");
        public static final TagKey<EntityType<?>> BLACK_HOLE_AFFECTED = modTag("black_hole_affected");
        public static final TagKey<EntityType<?>> SPAWNS_LOST_SOUL_CHANCE = modTag("spawns_lost_soul_chance");
        public static final TagKey<EntityType<?>> SPAWNS_CORRUPT_LOST_SOUL_CHANCE = modTag("spawns_corrupt_lost_soul_chance");

        private static TagKey<EntityType<?>> modTag(String name) {
            return TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation(ForbiddenArcanus.MOD_ID, name));
        }
    }

    public static class Enchantments {
        public static final TagKey<Enchantment> INDESTRUCTIBLE_BLACKLISTED = modTag("indestructible_blacklisted");

        public static final TagKey<Enchantment> ETERNAL_INCOMPATIBLE = modTag("modifier/eternal_incompatible");
        public static final TagKey<Enchantment> FIERY_INCOMPATIBLE = modTag("modifier/fiery_incompatible");
        public static final TagKey<Enchantment> MAGNETIZED_INCOMPATIBLE = modTag("modifier/magnetized_incompatible");
        public static final TagKey<Enchantment> DEMOLISHING_INCOMPATIBLE = modTag("modifier/demolishing_incompatible");
        public static final TagKey<Enchantment> AQUATIC_INCOMPATIBLE = modTag("modifier/aquatic_incompatible");

        private static TagKey<Enchantment> modTag(String name) {
            return TagKey.create(Registries.ENCHANTMENT, new ResourceLocation(ForbiddenArcanus.MOD_ID, name));
        }
    }

    public static class Biomes {
        public static final TagKey<Biome> IS_PLAINS = forgeTag("is_plains");
        public static final TagKey<Biome> IS_DESERT = forgeTag("is_desert");

        public static final TagKey<Biome> HAS_NIPA = modTag("has_structure/nipa");
        public static final TagKey<Biome> HAS_NIPA_ALWAYS_FLOATING = modTag("has_structure/nipa_always_floating");

        public static final TagKey<Biome> SPAWNS_CORRUPT_LOST_SOUL = forgeTag("spawns_corrupt_lost_soul");

        private static TagKey<Biome> forgeTag(String name) {
            return TagKey.create(Registries.BIOME, new ResourceLocation("forge", name));
        }

        private static TagKey<Biome> modTag(String name) {
            return TagKey.create(Registries.BIOME, new ResourceLocation(ForbiddenArcanus.MOD_ID, name));
        }
    }
}

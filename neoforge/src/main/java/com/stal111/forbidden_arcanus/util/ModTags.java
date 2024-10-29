package com.stal111.forbidden_arcanus.util;

import com.stal111.forbidden_arcanus.ForbiddenArcanus;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
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
        public static final TagKey<Block> DEORUM_STORAGE_BLOCKS = commonTag("storage_blocks/deorum");
        public static final TagKey<Block> ARCANE_CRYSTAL_STORAGE_BLOCKS = commonTag("storage_blocks/arcane_crystal");
        public static final TagKey<Block> STELLARITE_STORAGE_BLOCKS = commonTag("storage_blocks/stellarite");
        public static final TagKey<Block> OBSIDIANSTEEL_STORAGE_BLOCKS = commonTag("storage_blocks/obsidiansteel");
        public static final TagKey<Block> HEPHAESTUS_FORGES = modTag("hephaestus_forges");
        public static final TagKey<Block> ORES_ARCANE_CRYSTAL = commonTag("ores/arcane_crystal");
        public static final TagKey<Block> ORES_RUNIC = commonTag("ores/runic");
        public static final TagKey<Block> ORES_STELLARITE = commonTag("ores/stellarite");

        private static TagKey<Block> commonTag(String name) {
            return TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("c", name));
        }

        private static TagKey<Block> modTag(String name) {
            return TagKey.create(Registries.BLOCK, ForbiddenArcanus.location(name));
        }
    }

    public static class Items {
        public static final TagKey<Item> BLACK_HOLE_UNAFFECTED = modTag("black_hole_unaffected");
        public static final TagKey<Item> EXPLOSION_RESISTANT = commonTag("explosion_resistant");
        public static final TagKey<Item> OBSIDIAN_SKULLS = modTag("obsidian_skulls");
        public static final TagKey<Item> FUNGYSS_STEMS = modTag("fungyss_stems");
        public static final TagKey<Item> MYSTERYWOOD_LOGS = modTag("mysterywood_logs");
        public static final TagKey<Item> EDELWOOD_LOGS = modTag("edelwood_logs");
        public static final TagKey<Item> BLACKSMITH_GAVEL = modTag("blacksmith_gavel");
        public static final TagKey<Item> DEORUM_INGOTS = commonTag("ingots/deorum");
        public static final TagKey<Item> DEORUM_NUGGETS = commonTag("nuggets/deorum");
        public static final TagKey<Item> OBSIDIANSTEEL_INGOTS = commonTag("ingots/obsidiansteel");
        public static final TagKey<Item> MAGICAL_FARMLAND_BLACKLISTED = modTag("magical_farmland_blacklisted");
        public static final TagKey<Item> RUNIC_STONES = modTag("runic_stones");
        public static final TagKey<Item> RUNE_BLOCKS = modTag("rune_blocks");
        public static final TagKey<Item> ARCANE_CRYSTAL_ORES = modTag("arcane_crystal_ores");
        public static final TagKey<Item> HEPHAESTUS_FORGES = modTag("hephaestus_forges");

        public static final TagKey<Item> ETERNAL_INCOMPATIBLE = modTag("modifier/eternal_incompatible");
        public static final TagKey<Item> FIERY_INCOMPATIBLE = modTag("modifier/fiery_incompatible");
        public static final TagKey<Item> MAGNETIZED_INCOMPATIBLE = modTag("modifier/magnetized_incompatible");
        public static final TagKey<Item> DEMOLISHING_INCOMPATIBLE = modTag("modifier/demolishing_incompatible");
        public static final TagKey<Item> AQUATIC_INCOMPATIBLE = modTag("modifier/aquatic_incompatible");
        public static final TagKey<Item> SOULBOUND_INCOMPATIBLE = modTag("modifier/soulbound_incompatible");

        public static final TagKey<Item> SOULBOUND_APPLICABLE = modTag("modifier/soulbound_applicable");

        public static final TagKey<Item> AUREAL_STORAGE_ENCHANTABLE = modTag("enchantable/aureal_storage");

        public static final TagKey<Item> CLIBANO_CREATES_SOUL_FIRE = modTag("clibano/creates_soul_fire");
        public static final TagKey<Item> CLIBANO_CREATES_ENCHANTED_FIRE = modTag("clibano/creates_enchanted_fire");

        public static final TagKey<Item> DEORUM_STORAGE_BLOCKS = commonTag("storage_blocks/deorum");
        public static final TagKey<Item> ARCANE_CRYSTAL_STORAGE_BLOCKS = commonTag("storage_blocks/arcane_crystal");
        public static final TagKey<Item> STELLARITE_STORAGE_BLOCKS = commonTag("storage_blocks/stellarite");
        public static final TagKey<Item> OBSIDIANSTEEL_STORAGE_BLOCKS = commonTag("storage_blocks/obsidiansteel");

        public static final TagKey<Item> ORES_ARCANE_CRYSTAL = commonTag("ores/arcane_crystal");
        public static final TagKey<Item> ORES_RUNIC = commonTag("ores/runic");
        public static final TagKey<Item> ORES_STELLARITE = commonTag("ores/stellarite");

        private static TagKey<Item> commonTag(String name) {
            return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", name));
        }

        private static TagKey<Item> modTag(String name) {
            return TagKey.create(Registries.ITEM, ForbiddenArcanus.location(name));
        }
    }

    public static class EntityTypes {
        public static final TagKey<EntityType<?>> QUANTUM_CATCHER_BLACKLISTED = modTag("quantum_catcher_blacklisted");
        public static final TagKey<EntityType<?>> BOSS_CATCHER_BLACKLISTED = modTag("boss_catcher_blacklisted");
        public static final TagKey<EntityType<?>> BLACK_HOLE_AFFECTED = modTag("black_hole_affected");
        public static final TagKey<EntityType<?>> SPAWNS_LOST_SOUL_CHANCE = modTag("spawns_lost_soul_chance");
        public static final TagKey<EntityType<?>> SPAWNS_CORRUPT_LOST_SOUL_CHANCE = modTag("spawns_corrupt_lost_soul_chance");
        public static final TagKey<EntityType<?>> TEST_TUBE_BLACKLISTED = modTag("test_tube_blacklisted");

        private static TagKey<EntityType<?>> modTag(String name) {
            return TagKey.create(Registries.ENTITY_TYPE, ForbiddenArcanus.location(name));
        }
    }

    public static class Enchantments {
        public static final TagKey<Enchantment> ETERNAL_INCOMPATIBLE = modTag("modifier/eternal_incompatible");
        public static final TagKey<Enchantment> FIERY_INCOMPATIBLE = modTag("modifier/fiery_incompatible");
        public static final TagKey<Enchantment> MAGNETIZED_INCOMPATIBLE = modTag("modifier/magnetized_incompatible");
        public static final TagKey<Enchantment> DEMOLISHING_INCOMPATIBLE = modTag("modifier/demolishing_incompatible");
        public static final TagKey<Enchantment> AQUATIC_INCOMPATIBLE = modTag("modifier/aquatic_incompatible");
        public static final TagKey<Enchantment> SOULBOUND_INCOMPATIBLE = modTag("modifier/soulbound_incompatible");

        private static TagKey<Enchantment> modTag(String name) {
            return TagKey.create(Registries.ENCHANTMENT, ForbiddenArcanus.location(name));
        }
    }
}

package com.stal111.forbidden_arcanus.data.server.tags;

import com.stal111.forbidden_arcanus.core.init.ModBlocks;
import com.stal111.forbidden_arcanus.core.init.ModItems;
import com.stal111.forbidden_arcanus.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.valhelsia.valhelsia_core.datagen.DataProviderContext;
import net.valhelsia.valhelsia_core.datagen.tags.ValhelsiaItemTagsProvider;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

/**
 * Mod Item Tags Provider <br>
 * Forbidden Arcanus - com.stal111.forbidden_arcanus.data.server.tags.ModItemTagsProvider
 *
 * @author stal111
 * @since 2021-02-11
 */
public class ModItemTagsProvider extends ValhelsiaItemTagsProvider {

    public ModItemTagsProvider(DataProviderContext context, CompletableFuture<TagLookup<Block>> blockTagsLookup) {
        super(context, blockTagsLookup);
    }

    @Override
    protected void addTags(@NotNull HolderLookup.Provider provider) {
        this.tag(ModTags.Items.OBSIDIAN_SKULLS).add(ModBlocks.OBSIDIAN_SKULL.getSkull().asItem(), ModBlocks.CRACKED_OBSIDIAN_SKULL.getSkull().asItem(), ModBlocks.FRAGMENTED_OBSIDIAN_SKULL.getSkull().asItem(), ModBlocks.FADING_OBSIDIAN_SKULL.getSkull().asItem(), ModBlocks.AUREALIC_OBSIDIAN_SKULL.getSkull().asItem(), ModBlocks.ETERNAL_OBSIDIAN_SKULL.getSkull().asItem());
       // this.tag(Tags.Items.HEADS).addTag(ModTags.Items.OBSIDIAN_SKULLS);
        this.tag(ModTags.Items.BLACKSMITH_GAVEL).add(
                ModItems.WOODEN_BLACKSMITH_GAVEL.get(),
                ModItems.STONE_BLACKSMITH_GAVEL.get(),
                ModItems.GOLDEN_BLACKSMITH_GAVEL.get(),
                ModItems.IRON_BLACKSMITH_GAVEL.get(),
                ModItems.DIAMOND_BLACKSMITH_GAVEL.get(),
                ModItems.NETHERITE_BLACKSMITH_GAVEL.get(),
                ModItems.REINFORCED_DEORUM_BLACKSMITH_GAVEL.get()
        );
        this.tag(ModTags.Items.DEORUM_INGOTS).add(ModItems.DEORUM_INGOT.get());
        this.tag(ModTags.Items.DEORUM_NUGGETS).add(ModItems.DEORUM_NUGGET.get());
        this.tag(ModTags.Items.OBSIDIANSTEEL_INGOTS).add(ModItems.OBSIDIANSTEEL_INGOT.get());
        this.tag(ModTags.Items.MAGICAL_FARMLAND_BLACKLISTED).add(Items.WHEAT_SEEDS, Items.BEETROOT_SEEDS, Items.MELON_SEEDS, Items.PUMPKIN_SEEDS, ModItems.GOLDEN_ORCHID_SEEDS.get());
        this.tag(Tags.Items.INGOTS).addTags(ModTags.Items.DEORUM_INGOTS, ModTags.Items.OBSIDIANSTEEL_INGOTS);
        this.tag(ItemTags.PICKAXES).add(ModItems.DRACO_ARCANUS_PICKAXE.get(), ModItems.REINFORCED_DEORUM_PICKAXE.get());
        this.tag(ItemTags.ARROWS).add(ModItems.BOOM_ARROW.get(), ModItems.DRACO_ARCANUS_ARROW.get());
        this.tag(ModTags.Items.BLACK_HOLE_UNAFFECTED).add(ModItems.STELLARITE_PIECE.get(), ModBlocks.STELLARITE_BLOCK.get().asItem(), ModBlocks.STELLA_ARCANUM.get().asItem(), ModItems.ETERNAL_STELLA.get(), ModItems.DARK_NETHER_STAR.get(), Items.NETHER_STAR, Items.BEDROCK, Items.OBSIDIAN, Items.CRYING_OBSIDIAN, Items.ENCHANTING_TABLE, Items.END_PORTAL_FRAME, Items.ENDER_CHEST, Items.RESPAWN_ANCHOR).addTag(ModTags.Items.HEPHAESTUS_FORGES);
        this.tag(ModTags.Items.EXPLOSION_RESISTANT).add(Items.NETHER_STAR, ModItems.DARK_NETHER_STAR.get(), ModItems.STELLARITE_PIECE.get(), ModItems.ETERNAL_STELLA.get(), ModBlocks.STELLARITE_BLOCK.get().asItem());
        this.tag(Tags.Items.SEEDS).add(ModItems.GOLDEN_ORCHID_SEEDS.get());

        this.tag(ModTags.Items.ETERNAL_INCOMPATIBLE);
        this.tag(ModTags.Items.FIERY_INCOMPATIBLE);
        this.tag(ModTags.Items.MAGNETIZED_INCOMPATIBLE);
        this.tag(ModTags.Items.DEMOLISHING_INCOMPATIBLE);
        this.tag(ModTags.Items.AQUATIC_INCOMPATIBLE);
        this.tag(ModTags.Items.SOULBOUND_INCOMPATIBLE);

        this.tag(ModTags.Items.SOULBOUND_APPLICABLE).addTags(Tags.Items.TOOLS, Tags.Items.ARMORS);

        this.tag(ModTags.Items.CLIBANO_CREATES_SOUL_FIRE).add(ModItems.SOUL.get(), ModItems.CORRUPT_SOUL.get());
        this.tag(ModTags.Items.CLIBANO_CREATES_ENCHANTED_FIRE).add(ModItems.ENCHANTED_SOUL.get());

        this.tag(ItemTags.STONE_TOOL_MATERIALS).add(ModBlocks.DARKSTONE.get().asItem());
        this.tag(ItemTags.STONE_CRAFTING_MATERIALS).add(ModBlocks.DARKSTONE.get().asItem());

        this.copy(ModTags.Blocks.FUNGYSS_STEMS, ModTags.Items.FUNGYSS_STEMS);
        this.copy(ModTags.Blocks.MYSTERYWOOD_LOGS, ModTags.Items.MYSTERYWOOD_LOGS);
        this.copy(ModTags.Blocks.EDELWOOD_LOGS, ModTags.Items.EDELWOOD_LOGS);
        this.copy(BlockTags.LOGS, ItemTags.LOGS);
        this.copy(BlockTags.PLANKS, ItemTags.PLANKS);
        this.copy(BlockTags.WOODEN_SLABS, ItemTags.WOODEN_SLABS);
        this.copy(BlockTags.WOODEN_STAIRS, ItemTags.WOODEN_STAIRS);
        this.copy(BlockTags.WOODEN_PRESSURE_PLATES, ItemTags.WOODEN_PRESSURE_PLATES);
        this.copy(BlockTags.WOODEN_BUTTONS, ItemTags.WOODEN_BUTTONS);
        this.copy(BlockTags.BUTTONS, ItemTags.BUTTONS);
        this.copy(BlockTags.WOODEN_FENCES, ItemTags.WOODEN_FENCES);
        this.copy(BlockTags.WOODEN_DOORS, ItemTags.WOODEN_DOORS);
        this.copy(BlockTags.DOORS, ItemTags.DOORS);
        this.copy(BlockTags.WOODEN_TRAPDOORS, ItemTags.WOODEN_TRAPDOORS);
        this.copy(BlockTags.TRAPDOORS, ItemTags.TRAPDOORS);
        this.copy(Tags.Blocks.FENCES_WOODEN, Tags.Items.FENCES_WOODEN);
        this.copy(Tags.Blocks.FENCE_GATES_WOODEN, Tags.Items.FENCE_GATES_WOODEN);
        this.copy(ModTags.Blocks.RUNIC_STONES, ModTags.Items.RUNIC_STONES);
        this.copy(ModTags.Blocks.RUNE_BLOCKS, ModTags.Items.RUNE_BLOCKS);
        this.copy(ModTags.Blocks.ARCANE_CRYSTAL_ORES, ModTags.Items.ARCANE_CRYSTAL_ORES);
        //this.copy(BlockTags.STANDING_SIGNS, ItemTags.SIGNS);
        this.copy(BlockTags.SAPLINGS, ItemTags.SAPLINGS);
        this.copy(BlockTags.LEAVES, ItemTags.LEAVES);
        this.copy(BlockTags.SMALL_FLOWERS, ItemTags.SMALL_FLOWERS);
        this.copy(ModTags.Blocks.DEORUM_STORAGE_BLOCKS, ModTags.Items.DEORUM_STORAGE_BLOCKS);
        this.copy(ModTags.Blocks.ARCANE_CRYSTAL_STORAGE_BLOCKS, ModTags.Items.ARCANE_CRYSTAL_STORAGE_BLOCKS);
        this.copy(ModTags.Blocks.STELLARITE_STORAGE_BLOCKS, ModTags.Items.STELLARITE_STORAGE_BLOCKS);
        this.copy(ModTags.Blocks.OBSIDIANSTEEL_STORAGE_BLOCKS, ModTags.Items.OBSIDIANSTEEL_STORAGE_BLOCKS);
        this.copy(Tags.Blocks.STORAGE_BLOCKS, Tags.Items.STORAGE_BLOCKS);
        this.copy(ModTags.Blocks.HEPHAESTUS_FORGES, ModTags.Items.HEPHAESTUS_FORGES);
        this.copy(ModTags.Blocks.ORES_ARCANE_CRYSTAL, ModTags.Items.ORES_ARCANE_CRYSTAL);
        this.copy(ModTags.Blocks.ORES_RUNIC, ModTags.Items.ORES_RUNIC);
        this.copy(ModTags.Blocks.ORES_STELLARITE, ModTags.Items.ORES_STELLARITE);
        this.copy(Tags.Blocks.ORES, Tags.Items.ORES);
        this.copy(Tags.Blocks.ORES_IN_GROUND_STONE, Tags.Items.ORES_IN_GROUND_STONE);
        this.copy(Tags.Blocks.ORES_IN_GROUND_DEEPSLATE, Tags.Items.ORES_IN_GROUND_DEEPSLATE);
    }
}

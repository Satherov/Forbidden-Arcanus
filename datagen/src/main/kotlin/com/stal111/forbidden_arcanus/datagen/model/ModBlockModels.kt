package com.stal111.forbidden_arcanus.datagen.model

import com.stal111.forbidden_arcanus.ForbiddenArcanus
import com.stal111.forbidden_arcanus.common.block.DeskBlock
import com.stal111.forbidden_arcanus.common.block.HephaestusForgeBlock
import com.stal111.forbidden_arcanus.common.block.pedestal.PedestalBlock
import com.stal111.forbidden_arcanus.common.block.properties.ModBlockStateProperties
import com.stal111.forbidden_arcanus.common.block.properties.ObeliskPart
import com.stal111.forbidden_arcanus.common.block.properties.PillarType
import com.stal111.forbidden_arcanus.core.init.ModBlocks
import com.stal111.forbidden_arcanus.data.FABlockFamilies
import net.minecraft.core.Direction
import net.minecraft.data.models.BlockModelGenerators
import net.minecraft.data.models.blockstates.MultiVariantGenerator
import net.minecraft.data.models.blockstates.PropertyDispatch
import net.minecraft.data.models.blockstates.Variant
import net.minecraft.data.models.blockstates.VariantProperties
import net.minecraft.data.models.model.DelegatedModel
import net.minecraft.data.models.model.ModelLocationUtils
import net.minecraft.data.models.model.ModelTemplates
import net.minecraft.data.models.model.TextureMapping
import net.minecraft.data.models.model.TextureSlot
import net.minecraft.data.models.model.TexturedModel
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.level.ItemLike
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.RotatedPillarBlock
import net.minecraft.world.level.block.state.properties.BlockStateProperties
import net.valhelsia.dataforge.model.BlockModelGenerator
import net.valhelsia.dataforge.model.createModel

class ModBlockModels(private val generators: BlockModelGenerators) : BlockModelGenerator(generators) {

    private val texturedModels = mapOf(
        ModBlocks.CUT_SOULLESS_SANDSTONE.get() to TexturedModel.COLUMN.get(ModBlocks.CUT_SOULLESS_SANDSTONE.get())
    )

    override fun generate() {
        FABlockFamilies.getAllFamilies()
            .filter { it.shouldGenerateModel() }
            .forEach { this.family(it.baseBlock).generateFor(it) }

        this.generators.createTrivialCube(ModBlocks.SOULLESS_SAND.get())
        this.generators.createTrivialCube(ModBlocks.GILDED_CHISELED_POLISHED_DARKSTONE.get())
        this.generators.createTrivialCube(ModBlocks.TILED_POLISHED_DARKSTONE_BRICKS.get())
        this.generators.createTrivialCube(ModBlocks.QUANTUM_INJECTOR.get())
        this.createEmissiveLayerCube(ModBlocks.ARCANE_CRYSTAL_ORE.get(), "arcane_crystal_ore")
        this.createEmissiveLayerCube(ModBlocks.DEEPSLATE_ARCANE_CRYSTAL_ORE.get(), "arcane_crystal_ore")
        this.createEmissiveLayerCube(ModBlocks.RUNIC_STONE.get(), "runic_stone")
        this.createEmissiveLayerCube(ModBlocks.RUNIC_DEEPSLATE.get(), "runic_stone")
        this.createEmissiveLayerCube(ModBlocks.RUNIC_DARKSTONE.get(), "runic_stone")
        this.generators.createTrivialCube(ModBlocks.STELLA_ARCANUM.get())
        this.createEmissiveCube(ModBlocks.ARCANE_CRYSTAL_BLOCK.get())
        this.generators.createTrivialCube(ModBlocks.CORRUPTED_ARCANE_CRYSTAL_BLOCK.get())
        this.generators.createTrivialCube(ModBlocks.RUNE_BLOCK.get())
        this.generators.createTrivialCube(ModBlocks.STELLARITE_BLOCK.get())
        this.generators.createTrivialCube(ModBlocks.DEORUM_BLOCK.get())
        this.generators.createTrivialCube(ModBlocks.OBSIDIANSTEEL_BLOCK.get())
        this.generators.createTrivialCube(ModBlocks.AURUM_LEAVES.get())
        this.generators.createTrivialCube(ModBlocks.NUGGETY_AURUM_LEAVES.get())
        this.generators.createTrivialCube(ModBlocks.FUNGYSS_BLOCK.get())

        this.createForbiddenomicon(ModBlocks.FORBIDDENOMICON.get())
        this.createDesk(ModBlocks.DESK.get(), false)
        this.createDesk(ModBlocks.RESEARCH_DESK.get(), true)
        this.createPedestal(ModBlocks.DARKSTONE_PEDESTAL.get())
        this.createPedestal(ModBlocks.MAGNETIZED_DARKSTONE_PEDESTAL.get())
        this.createClibanoCore(ModBlocks.CLIBANO_CORE.get())
        this.createClibanoCenter(ModBlocks.CLIBANO_CENTER.get())
        this.createClibanoCorner(ModBlocks.CLIBANO_CORNER.get())
        this.createClibanoSideHorizontal(ModBlocks.CLIBANO_SIDE_HORIZONTAL.get())
        this.createClibanoSideVertical(ModBlocks.CLIBANO_SIDE_VERTICAL.get())
        this.createHephaestusForge(ModBlocks.HEPHAESTUS_FORGE_TIER_1.get())
        this.createHephaestusForge(ModBlocks.HEPHAESTUS_FORGE_TIER_2.get())
        this.createHephaestusForge(ModBlocks.HEPHAESTUS_FORGE_TIER_3.get())
        this.createHephaestusForge(ModBlocks.HEPHAESTUS_FORGE_TIER_4.get())
        this.createHephaestusForge(ModBlocks.HEPHAESTUS_FORGE_TIER_5.get())
        this.createObelisk(ModBlocks.ARCANE_CRYSTAL_OBELISK.get())
        this.createObelisk(ModBlocks.CORRUPTED_ARCANE_CRYSTAL_OBELISK.get())
        this.createUtremJar(ModBlocks.UTREM_JAR.get())
        this.blockStateOutput.accept(
            createSimpleBlock(
                ModBlocks.ESSENCE_UTREM_JAR.get(),
                ModelLocationUtils.getModelLocation(ModBlocks.UTREM_JAR.get())
            )
        )
        this.createPillar(ModBlocks.ARCANE_POLISHED_DARKSTONE_PILLAR.get())
        this.createNonTemplateModelBlock(ModBlocks.QUANTUM_CORE.get())
        this.generators.createDoor(ModBlocks.DEORUM_DOOR.get())
        this.generators.createTrapdoor(ModBlocks.DEORUM_TRAPDOOR.get())
        this.generators.createAxisAlignedPillarBlockCustomModel(
            ModBlocks.DEORUM_CHAIN.get(),
            ModBlocks.DEORUM_CHAIN.getModelLocation()
        )
        this.generators.createGlassBlocks(ModBlocks.DEORUM_GLASS.get(), ModBlocks.DEORUM_GLASS_PANE.get())
        this.generators.createGlassBlocks(ModBlocks.RUNIC_GLASS.get(), ModBlocks.RUNIC_GLASS_PANE.get())
        this.generators.createLantern(ModBlocks.DEORUM_LANTERN.get())
        this.generators.createLantern(ModBlocks.DEORUM_SOUL_LANTERN.get())
        this.generators.createPlant(
            ModBlocks.FUNGYSS.get(),
            ModBlocks.POTTED_FUNGYSS.get(),
            BlockModelGenerators.TintState.NOT_TINTED
        )
        this.generators.createPlant(
            ModBlocks.AURUM_SAPLING.get(),
            ModBlocks.POTTED_AURUM_SAPLING.get(),
            BlockModelGenerators.TintState.NOT_TINTED
        )
        this.generators.createPlant(
            ModBlocks.GROWING_EDELWOOD.get(),
            ModBlocks.POTTED_GROWING_EDELWOOD.get(),
            BlockModelGenerators.TintState.NOT_TINTED
        )
        this.generators.createPlant(
            ModBlocks.YELLOW_ORCHID.get(),
            ModBlocks.POTTED_YELLOW_ORCHID.get(),
            BlockModelGenerators.TintState.NOT_TINTED
        )
        this.generators.woodProvider(ModBlocks.FUNGYSS_STEM.get())
            .log(ModBlocks.FUNGYSS_STEM.get())
            .wood(ModBlocks.FUNGYSS_HYPHAE.get())
        this.generators.woodProvider(ModBlocks.AURUM_LOG.get())
            .logWithHorizontal(ModBlocks.AURUM_LOG.get())
            .wood(ModBlocks.AURUM_WOOD.get())
        this.generators.woodProvider(ModBlocks.STRIPPED_AURUM_LOG.get())
            .logWithHorizontal(ModBlocks.STRIPPED_AURUM_LOG.get())
            .wood(ModBlocks.STRIPPED_AURUM_WOOD.get())
        this.createHollowLog(ModBlocks.EDELWOOD_LOG.get())
        this.createHollowLogWithFace(ModBlocks.CARVED_EDELWOOD_LOG.get())
        this.blockStateOutput.accept(
            createSimpleBlock(
                ModBlocks.EDELWOOD_BRANCH.get(),
                ModelLocationUtils.getModelLocation(ModBlocks.EDELWOOD_BRANCH.get())
            )
        )
        this.createMagicalFarmland()

        this.blockEntityModels(
            ModelLocationUtils.getModelLocation(ModBlocks.OBSIDIAN_SKULL.getSkull()),
            Blocks.SOUL_SAND
        ).createWithCustomBlockItemModel(
            ModelTemplates.SKULL_INVENTORY,
            ModBlocks.OBSIDIAN_SKULL.getSkull(),
            ModBlocks.CRACKED_OBSIDIAN_SKULL.getSkull(),
            ModBlocks.FRAGMENTED_OBSIDIAN_SKULL.getSkull(),
            ModBlocks.FADING_OBSIDIAN_SKULL.getSkull(),
            ModBlocks.AUREALIC_OBSIDIAN_SKULL.getSkull(),
            ModBlocks.ETERNAL_OBSIDIAN_SKULL.getSkull()
        ).createWithoutBlockItem(
            ModBlocks.OBSIDIAN_SKULL.getWallSkull(),
            ModBlocks.CRACKED_OBSIDIAN_SKULL.getWallSkull(),
            ModBlocks.FRAGMENTED_OBSIDIAN_SKULL.getWallSkull(),
            ModBlocks.FADING_OBSIDIAN_SKULL.getWallSkull(),
            ModBlocks.AUREALIC_OBSIDIAN_SKULL.getWallSkull(),
            ModBlocks.ETERNAL_OBSIDIAN_SKULL.getWallSkull()
        )
    }

    private fun family(block: Block): BlockModelGenerators.BlockFamilyProvider {
        val texturedModel = this.texturedModels.getOrDefault(block, TexturedModel.CUBE.get(block))
        return this.generators.BlockFamilyProvider(texturedModel.mapping).fullBlock(block, texturedModel.template)
    }

    private fun blockEntityModels(
        modelLocation: ResourceLocation,
        block: Block
    ) = this.generators.BlockEntityModelGenerator(modelLocation, block)

    private fun createEmissiveCube(block: Block) = this.blockStateOutput.accept(
        createSimpleBlock(
            block,
            ModModelTemplates.CUBE_ALL_EMISSIVE.createModel(block, ModTextureMapping.emissiveCube(block))
        )
    )


    private fun createEmissiveLayerCube(block: Block, folder: String) = this.blockStateOutput.accept(
        createSimpleBlock(
            block,
            ModModelTemplates.CUBE_ALL_EMISSIVE_LAYER.createModel(
                block,
                ModTextureMapping.emissiveLayerCube(block, folder)
            )
        )
    )

    private fun createForbiddenomicon(block: Block) {
        val textureMapping = ModTextureMapping.forbiddenomicon(block)
        val model = ModModelTemplates.FORBIDDENOMICON.createModel(block, textureMapping)

        this.blockStateOutput.accept(
            createSimpleBlock(block, model).with(BlockModelGenerators.createHorizontalFacingDispatch())
        )
    }

    private fun createDesk(block: DeskBlock, research: Boolean) {
        val textureMapping = ModTextureMapping.desk(research)
        val model = ModModelTemplates.DESK.createModel(block, textureMapping)

        this.blockStateOutput.accept(
            createSimpleBlock(block, model).with(BlockModelGenerators.createHorizontalFacingDispatch())
        )
    }

    private fun createPedestal(block: PedestalBlock) {
        val textureMapping = ModTextureMapping.pedestal(block)
        val model = ModModelTemplates.PEDESTAL.createModel(block, textureMapping)

        this.blockStateOutput.accept(createSimpleBlock(block, model))
    }

    private fun createClibanoCore(block: Block) {
        val textureMapping = ModTextureMapping.clibanoCore()
        val model = ModelTemplates.CUBE_ORIENTABLE.createModel(block, textureMapping)

        this.blockStateOutput.accept(
            createSimpleBlock(block, model).with(BlockModelGenerators.createHorizontalFacingDispatch())
        )
    }

    private fun createClibanoCenter(block: Block) {
        val dispatch = PropertyDispatch.property(ModBlockStateProperties.CLIBANO_CENTER_TYPE).generate {
            val model = ModModelTemplates.CLIBANO_CENTER.createModel(
                block,
                ModTextureMapping.clibanoCenter(it),
                "_" + it.serializedName
            )

            Variant.variant().with(VariantProperties.MODEL, model)
        }

        this.blockStateOutput.accept(
            MultiVariantGenerator.multiVariant(block).with(dispatch).with(BlockModelGenerators.createFacingDispatch())
        )
    }

    private fun createClibanoCorner(block: Block) {
        val model = ForbiddenArcanus.location("block/clibano_corner")

        val dispatch = PropertyDispatch.property(BlockStateProperties.BOTTOM).generate {
            Variant.variant().with(
                VariantProperties.X_ROT,
                if (it) VariantProperties.Rotation.R90 else VariantProperties.Rotation.R0
            )
        }

        this.blockStateOutput.accept(
            createSimpleBlock(block, model).with(dispatch).with(BlockModelGenerators.createHorizontalFacingDispatch())
        )
    }

    private fun createClibanoSideHorizontal(block: Block) {
        val typeDispatch = PropertyDispatch.property(ModBlockStateProperties.CLIBANO_SIDE_TYPE).generate {
            val textureMapping = ModTextureMapping.clibanoSide(it)
            val model = ModModelTemplates.CLIBANO_SIDE_HORIZONTAL.createModel(
                block,
                textureMapping,
                "_${it.serializedName}"
            )

            Variant.variant().with(VariantProperties.MODEL, model)
        }

        val facingDispatch =
            PropertyDispatch.properties(BlockStateProperties.HORIZONTAL_FACING, ModBlockStateProperties.MIRRORED)
                .select(
                    Direction.EAST,
                    false,
                    Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                )
                .select(
                    Direction.EAST,
                    true,
                    Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0)
                        .with(VariantProperties.X_ROT, VariantProperties.Rotation.R180)
                )
                .select(
                    Direction.SOUTH,
                    false,
                    Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180)
                )
                .select(
                    Direction.SOUTH,
                    true,
                    Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                        .with(VariantProperties.X_ROT, VariantProperties.Rotation.R180)
                )
                .select(
                    Direction.WEST,
                    false,
                    Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)
                )
                .select(
                    Direction.WEST,
                    true,
                    Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180)
                        .with(VariantProperties.X_ROT, VariantProperties.Rotation.R180)
                )
                .select(Direction.NORTH, false, Variant.variant())
                .select(
                    Direction.NORTH,
                    true,
                    Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)
                        .with(VariantProperties.X_ROT, VariantProperties.Rotation.R180)
                )

        this.blockStateOutput.accept(MultiVariantGenerator.multiVariant(block).with(typeDispatch).with(facingDispatch))
    }

    private fun createClibanoSideVertical(block: Block) {
        val typeDispatch = PropertyDispatch.property(ModBlockStateProperties.CLIBANO_SIDE_TYPE).generate {
            val textureMapping = ModTextureMapping.clibanoSide(it)
            val model = ModModelTemplates.CLIBANO_SIDE_VERTICAL.createModel(
                block,
                textureMapping,
                "_${it.serializedName}"
            )

            Variant.variant().with(VariantProperties.MODEL, model)
        }

        val facingDispatch =
            PropertyDispatch.properties(BlockStateProperties.HORIZONTAL_FACING, ModBlockStateProperties.MIRRORED)
                .select(
                    Direction.EAST,
                    false,
                    Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                )
                .select(
                    Direction.EAST,
                    true,
                    Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)
                        .with(VariantProperties.X_ROT, VariantProperties.Rotation.R180)
                )
                .select(
                    Direction.SOUTH,
                    false,
                    Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180)
                )
                .select(
                    Direction.SOUTH,
                    true,
                    Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0)
                        .with(VariantProperties.X_ROT, VariantProperties.Rotation.R180)
                )
                .select(
                    Direction.WEST,
                    false,
                    Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)
                )
                .select(
                    Direction.WEST,
                    true,
                    Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                        .with(VariantProperties.X_ROT, VariantProperties.Rotation.R180)
                )
                .select(Direction.NORTH, false, Variant.variant())
                .select(
                    Direction.NORTH,
                    true,
                    Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180)
                        .with(VariantProperties.X_ROT, VariantProperties.Rotation.R180)
                )

        this.blockStateOutput.accept(MultiVariantGenerator.multiVariant(block).with(typeDispatch).with(facingDispatch))
    }

    private fun createHephaestusForge(block: HephaestusForgeBlock) {
        val textureMapping = ModTextureMapping.hephaestusForge(block.level.asInt)
        val model = ModModelTemplates.HEPHAESTUS_FORGE.createModel(block, textureMapping)

        this.blockStateOutput.accept(createSimpleBlock(block, model))
    }

    private fun createObelisk(block: Block) {
        val dispatch = PropertyDispatch.property(ModBlockStateProperties.OBELISK_PART).generate {
            val textureMapping = ModTextureMapping.obelisk(block, it)
            val model = ModModelTemplates.OBELISK[ObeliskPart.UPPER]!!.createModel(
                block,
                textureMapping,
                "_${it.serializedName}"
            )

            Variant.variant().with(VariantProperties.MODEL, model)
        }

        this.blockStateOutput.accept(MultiVariantGenerator.multiVariant(block).with(dispatch))
    }

    private fun createUtremJar(block: Block) {
        val textureMapping = ModTextureMapping.utremJar(block)
        val model = ModModelTemplates.UTREM_JAR.createModel(block, textureMapping)

        this.blockStateOutput.accept(createSimpleBlock(block, model))
    }

    private fun createPillar(block: Block) {
        val dispatch = PropertyDispatch.properties(ModBlockStateProperties.PILLAR_TYPE, RotatedPillarBlock.AXIS)
            .generate { part, axis ->
                Variant.variant()
                    .with(
                        VariantProperties.MODEL,
                        ForbiddenArcanus.location("block/arcane_polished_darkstone_pillar" + if (part == PillarType.SINGLE) "" else "_" + if (axis == Direction.Axis.Z) part.opposite else part.serializedName)
                    )
                    .with(
                        VariantProperties.Y_ROT,
                        if (axis == Direction.Axis.X) VariantProperties.Rotation.R90 else VariantProperties.Rotation.R0
                    )
                    .with(
                        VariantProperties.X_ROT,
                        if (axis == Direction.Axis.Y) VariantProperties.Rotation.R0 else VariantProperties.Rotation.R90
                    )
            }

        this.blockStateOutput.accept(MultiVariantGenerator.multiVariant(block).with(dispatch))
    }

    private fun createHollowLog(block: Block) {
        val textureMapping = ModTextureMapping.edelwoodLog()
        val model = ModModelTemplates.HOLLOW_LOG.createModel(block, textureMapping)

        this.blockStateOutput.accept(createSimpleBlock(block, model))
    }

    private fun createHollowLogWithFace(block: Block) {
        val textureMapping = ModTextureMapping.edelwoodLogWithFace(false)
        val textureMappingWithLeaves = ModTextureMapping.edelwoodLogWithFace(true)

        val model = ModModelTemplates.HOLLOW_LOG_FACE.createModel(block, textureMapping)
        val modelWithLaves = ModModelTemplates.HOLLOW_LOG_FACE_AND_LEAVES.createModel(
            block,
            textureMappingWithLeaves,
            "_leaves",
        )

        val dispatch = PropertyDispatch.property(ModBlockStateProperties.LEAVES).generate {
            Variant.variant().with(VariantProperties.MODEL, if (it) modelWithLaves else model)
        }

        this.blockStateOutput.accept(
            createSimpleBlock(
                block,
                model
            ).with(BlockModelGenerators.createHorizontalFacingDispatch()).with(dispatch)
        )
    }

    private fun createMagicalFarmland() {
        val textureMapping = TextureMapping()
            .put(TextureSlot.DIRT, ForbiddenArcanus.location("block/magical_dirt"))
            .put(TextureSlot.TOP, TextureMapping.getBlockTexture(ModBlocks.MAGICAL_FARMLAND.get()))
        val moistTextureMapping = TextureMapping()
            .put(TextureSlot.DIRT, ForbiddenArcanus.location("block/magical_dirt"))
            .put(TextureSlot.TOP, TextureMapping.getBlockTexture(ModBlocks.MAGICAL_FARMLAND.get(), "_moist"))

        val model = ModelTemplates.FARMLAND.createModel(ModBlocks.MAGICAL_FARMLAND.get(), textureMapping)
        val moistModel = ModelTemplates.FARMLAND.createModel(
            ModBlocks.MAGICAL_FARMLAND.get(),
            moistTextureMapping,
            "_moist"
        )

        this.blockStateOutput.accept(
            MultiVariantGenerator.multiVariant(ModBlocks.MAGICAL_FARMLAND.get()).with(
                BlockModelGenerators.createEmptyOrFullDispatch(
                    BlockStateProperties.MOISTURE,
                    7,
                    moistModel,
                    model
                )
            )
        )
    }

    private fun createNonTemplateModelBlock(block: Block) {
        this.createNonTemplateModelBlock(block, block)
    }

    private fun createNonTemplateModelBlock(block: Block, modelBlock: Block) {
        this.blockStateOutput.accept(createSimpleBlock(block, ModelLocationUtils.getModelLocation(modelBlock)))
    }

    fun delegateItemModel(block: Block, resourceLocation: ResourceLocation) {
        this.modelOutput.accept(ModelLocationUtils.getModelLocation(block.asItem()), DelegatedModel(resourceLocation))
    }

    companion object {
        fun createSimpleBlock(block: Block, resourceLocation: ResourceLocation): MultiVariantGenerator {
            return MultiVariantGenerator.multiVariant(
                block,
                Variant.variant().with(VariantProperties.MODEL, resourceLocation)
            )
        }
    }
}
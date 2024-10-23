package com.stal111.forbidden_arcanus.datagen.model

import com.stal111.forbidden_arcanus.ForbiddenArcanus
import com.stal111.forbidden_arcanus.common.block.properties.ObeliskPart
import com.stal111.forbidden_arcanus.common.block.properties.clibano.ClibanoCenterType
import com.stal111.forbidden_arcanus.common.block.properties.clibano.ClibanoSideType
import com.stal111.forbidden_arcanus.core.init.ModBlocks
import com.stal111.forbidden_arcanus.data.model.ModLocationUtils
import com.stal111.forbidden_arcanus.data.model.ModTextureSlots
import net.minecraft.core.Holder
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.data.models.model.TextureMapping
import net.minecraft.data.models.model.TextureSlot
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block

object ModTextureMapping {
    private const val FORBIDDENOMICON = "forbiddenomicon"
    private const val DESK = "desk"
    private const val PEDESTAL = "pedestal"
    private const val CLIBANO = "clibano"
    private const val HEPHAESTUS_FORGE = "hephaestus_forge"
    private const val OBELISK = "obelisk"
    private const val UTREM_JAR = "utrem_jar"
    private const val QUANTUM_CATCHER = "quantum_catcher"
    private const val EDELWOOD_LOG = "edelwood_log"

    private val FORGE_BLOCK_TEXTURES = listOf(
        ResourceLocation.withDefaultNamespace("block/smithing_table_bottom"),
        ForbiddenArcanus.location("block/edelwood_planks"),
        ForbiddenArcanus.location("block/chiseled_polished_darkstone"),
        ForbiddenArcanus.location("block/chiseled_polished_darkstone"),
        ForbiddenArcanus.location("block/stellarite_block")
    )

    fun emissiveCube(block: Block) = TextureMapping()
        .put(TextureSlot.ALL, getBlockTexture(block))

    fun emissiveLayerCube(block: Block, folder: String) = TextureMapping()
        .put(TextureSlot.ALL, getBlockTexture(block, folder))
        .put(ModTextureSlots.LAYER, getBlockTexture(block, folder, "_layer"))


    fun forbiddenomicon(block: Block) = TextureMapping()
        .put(TextureSlot.FRONT, getBlockTexture(block, FORBIDDENOMICON, "_front"))
        .put(TextureSlot.BACK, getBlockTexture(block, FORBIDDENOMICON, "_back"))
        .put(TextureSlot.INSIDE, getBlockTexture(block, FORBIDDENOMICON, "_inside"))
        .put(TextureSlot.SIDE, getBlockTexture(block, FORBIDDENOMICON, "_side"))


    fun desk(research: Boolean): TextureMapping {
        val desk = ModBlocks.DESK.get()
        val researchDesk = ModBlocks.RESEARCH_DESK.get()

        return TextureMapping()
            .put(TextureSlot.FRONT, getBlockTexture(desk, DESK, "_front"))
            .put(TextureSlot.BACK, getBlockTexture(if (research) researchDesk else desk, DESK, "_back"))
            .put(TextureSlot.INSIDE, getBlockTexture(desk, DESK, "_inside"))
            .put(TextureSlot.SIDE, getBlockTexture(if (research) researchDesk else desk, DESK, "_side"))
            .put(TextureSlot.TOP, getBlockTexture(desk, DESK, "_top"))
            .put(TextureSlot.BOTTOM, getBlockTexture(desk, DESK, "_bottom"))
    }

    fun pedestal(block: Block) = TextureMapping()
        .put(TextureSlot.SIDE, getBlockTexture(block, PEDESTAL))
        .put(TextureSlot.TOP, getBlockTexture(block, PEDESTAL, "_top"))

    fun clibanoCore() = TextureMapping()
        .put(TextureSlot.SIDE, getBlockTexture(CLIBANO, "clibano_center_side"))
        .put(TextureSlot.FRONT, getBlockTexture(CLIBANO, "clibano_center_front_off"))
        .put(TextureSlot.TOP, getBlockTexture(CLIBANO, "clibano_center_top"))


    fun clibanoCenter(type: ClibanoCenterType) = TextureMapping().put(
        TextureSlot.TEXTURE,
        getBlockTexture(
            CLIBANO,
            type.fireType?.serializedName?.let { "$it/clibano_center_front" }
                ?: "clibano_center_${type.serializedName}")
    )


    fun clibanoSide(type: ClibanoSideType) = TextureMapping()
        .put(
            TextureSlot.SIDE,
            getBlockTexture(
                CLIBANO,
                if (type == ClibanoSideType.OFF) "clibano_side_off" else type.serializedName + "/clibano_side"
            )
        )

    fun hephaestusForge(tier: Int): TextureMapping {
        val folder = "$HEPHAESTUS_FORGE/tier_$tier"
        return TextureMapping()
            .put(TextureSlot.TOP, getBlockTexture(folder, "top"))
            .put(ModTextureSlots.TOP_LAYER, getBlockTexture(folder, "top_layer"))
            .put(TextureSlot.SIDE, getBlockTexture(folder, "side"))
            .put(ModTextureSlots.SIDE_LAYER, getBlockTexture(folder, "side_layer"))
            .put(ModTextureSlots.CLOTH_SIDE, getBlockTexture(folder, "cloth_side"))
            .put(TextureSlot.BOTTOM, getBlockTexture(folder, "bottom"))
            .put(ModTextureSlots.BLOCK, FORGE_BLOCK_TEXTURES[tier - 1]!!)
    }

    fun obelisk(block: Block, part: ObeliskPart) = TextureMapping()
        .put(TextureSlot.TOP, getBlockTexture(block, OBELISK, "_top"))
        .put(TextureSlot.TEXTURE, getBlockTexture(block, OBELISK, "_" + part.serializedName))


    fun utremJar(block: Block) = TextureMapping()
        .put(TextureSlot.SIDE, getBlockTexture(block, UTREM_JAR, "_side"))
        .put(TextureSlot.TOP, getBlockTexture(block, UTREM_JAR, "_top"))
        .put(TextureSlot.BOTTOM, getBlockTexture(block, UTREM_JAR, "_bottom"))


    fun quantumCatcher(folder: String = "") = TextureMapping()
        .put(TextureSlot.SIDE, ModLocationUtils.getItem(QUANTUM_CATCHER + folder, "quantum_catcher_side"))
        .put(TextureSlot.TOP, ModLocationUtils.getItem(QUANTUM_CATCHER + folder, "quantum_catcher_top"))
        .put(ModTextureSlots.INNER, ModLocationUtils.getItem(QUANTUM_CATCHER, "quantum_catcher_inner"))


    fun edelwoodLog(): TextureMapping {
        val block = ModBlocks.EDELWOOD_LOG.get()

        return TextureMapping()
            .put(ModTextureSlots.LOG, getBlockTexture(block, EDELWOOD_LOG))
            .put(TextureSlot.TOP, getBlockTexture(block, EDELWOOD_LOG, "_top"))
            .put(TextureSlot.INSIDE, getBlockTexture(block, EDELWOOD_LOG, "_inside"))
    }

    fun edelwoodLogWithFace(leaves: Boolean): TextureMapping {
        val block = ModBlocks.EDELWOOD_LOG.get()

        val mapping = TextureMapping()
            .put(ModTextureSlots.LOG, getBlockTexture(block, EDELWOOD_LOG))
            .put(TextureSlot.TOP, getBlockTexture(block, EDELWOOD_LOG, "_top"))
            .put(TextureSlot.INSIDE, getBlockTexture(block, EDELWOOD_LOG, "_inside"))
            .put(TextureSlot.FRONT, getBlockTexture(block, EDELWOOD_LOG, "_face"))

        if (leaves) {
            mapping.put(ModTextureSlots.LEAVES, getBlockTexture(block, EDELWOOD_LOG, "_leaves"))
        }

        return mapping
    }

    fun getBlockTexture(block: Block) = BuiltInRegistries.BLOCK.getKey(block).withPrefix("block/")

    fun getBlockTexture(block: Block, folder: String) = ModLocationUtils.getBlock(block, folder)

    fun getBlockTexture(block: Block, folder: String, suffix: String) = ModLocationUtils.getBlock(block, folder, suffix)

    fun getBlockTexture(folder: String, texture: String) = ForbiddenArcanus.location("block/$folder/$texture")

    fun geItemTexture(item: Holder<Item>, folder: String, suffix: String) =
        ModLocationUtils.getItem(folder, item, suffix)
}

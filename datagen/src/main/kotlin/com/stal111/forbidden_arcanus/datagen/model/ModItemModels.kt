package com.stal111.forbidden_arcanus.datagen.model

import com.stal111.forbidden_arcanus.ForbiddenArcanus
import com.stal111.forbidden_arcanus.core.init.ModBlocks
import com.stal111.forbidden_arcanus.core.init.ModItems
import net.minecraft.data.models.ItemModelGenerators
import net.minecraft.data.models.model.ModelLocationUtils
import net.minecraft.data.models.model.TextureMapping
import net.valhelsia.dataforge.model.ItemModelGenerator
import net.valhelsia.dataforge.model.createModel

class ModItemModels(generators: ItemModelGenerators) : ItemModelGenerator(generators) {

    override fun generate() {
        generateFlatBlockItem(ModBlocks.DEORUM_CHAIN)
        generateFlatBlockItem(ModBlocks.NIPA)
        generateFlatBlockItem(ModBlocks.ARCANE_DRAGON_EGG)
        generateFlatBlockItem(ModBlocks.ARCANE_CRYSTAL_OBELISK)
        generateFlatBlockItem(ModBlocks.CORRUPTED_ARCANE_CRYSTAL_OBELISK)

        generateBatch(
            ModItems.SANITY_METER,
            ModItems.EDELWOOD_BUCKET,
            ModItems.EDELWOOD_WATER_BUCKET,
            ModItems.EDELWOOD_LAVA_BUCKET,
            ModItems.EDELWOOD_MILK_BUCKET,
            ModItems.EDELWOOD_POWDER_SNOW_BUCKET,
            ModItems.OBSIDIANSTEEL_INGOT,
            ModItems.MUNDABITUR_DUST,
            ModItems.CORRUPTI_DUST,
            ModItems.FERROGNETIC_MIXTURE,
            ModItems.SOUL,
            ModItems.CORRUPT_SOUL,
            ModItems.ENCHANTED_SOUL,
            ModItems.AUREAL_BOTTLE,
            ModItems.SPLASH_AUREAL_BOTTLE,
            ModItems.ARCANE_CRYSTAL,
            ModItems.CORRUPTED_ARCANE_CRYSTAL,
            ModItems.RUNE,
            ModItems.STELLARITE_PIECE,
            ModItems.XPETRIFIED_ORB,
            ModItems.DARK_NETHER_STAR,
            ModItems.DEORUM_NUGGET,
            ModItems.DEORUM_INGOT,
            ModItems.ARCANE_CRYSTAL_DUST,
            ModItems.ARCANE_CRYSTAL_DUST_SPECK,
            ModItems.ARCANE_BONE_MEAL,
            ModItems.DARK_MATTER,
            ModItems.ENDER_PEARL_FRAGMENT,
            ModItems.DRAGON_SCALE,
            ModItems.SILVER_DRAGON_SCALE,
            ModItems.GOLDEN_DRAGON_SCALE,
            ModItems.AQUATIC_DRAGON_SCALE,
            ModItems.BAT_WING,
            ModItems.BAT_SOUP,
            ModItems.TENTACLE,
            ModItems.COOKED_TENTACLE,
            ModItems.EDELWOOD_STICK,
            ModItems.WAX,
            ModItems.SPAWNER_SCRAP,
            ModItems.BOOM_ARROW,
            ModItems.DRACO_ARCANUS_ARROW,
            ModItems.EDELWOOD_OIL,
            ModItems.GOLDEN_ORCHID_SEEDS,
            ModItems.AURUM_BOAT,
            ModItems.AURUM_CHEST_BOAT,
            ModItems.EDELWOOD_BOAT,
            ModItems.EDELWOOD_CHEST_BOAT,
            ModItems.APPLY_MODIFIER_SMITHING_TEMPLATE,
            ModItems.ETERNAL_STELLA,
            ModItems.TERRASTOMP_PRISM,
            ModItems.SEA_PRISM,
            ModItems.WHIRLWIND_PRISM,
            ModItems.SMELTER_PRISM,
            ModItems.SOUL_BINDING_CRYSTAL,
            ModItems.BLACKSMITH_GAVEL_HEAD,
            ModItems.TEST_TUBE
        )

        generateBatch(
            ModItems.DRACO_ARCANUS_STAFF,
            ModItems.DRACO_ARCANUS_SWORD,
            ModItems.DRACO_ARCANUS_SHOVEL,
            ModItems.DRACO_ARCANUS_PICKAXE,
            ModItems.DRACO_ARCANUS_AXE,
            ModItems.DRACO_ARCANUS_HOE,
            ModItems.DRACO_ARCANUS_SCEPTER,
            ModItems.WOODEN_BLACKSMITH_GAVEL,
            ModItems.STONE_BLACKSMITH_GAVEL,
            ModItems.GOLDEN_BLACKSMITH_GAVEL,
            ModItems.IRON_BLACKSMITH_GAVEL,
            ModItems.DIAMOND_BLACKSMITH_GAVEL,
            ModItems.NETHERITE_BLACKSMITH_GAVEL,
            ModItems.REINFORCED_DEORUM_BLACKSMITH_GAVEL,
            folder = TOOL
        )

        generateBatch(
            ModItems.DRACO_ARCANUS_HELMET,
            ModItems.DRACO_ARCANUS_CHESTPLATE,
            ModItems.DRACO_ARCANUS_LEGGINGS,
            ModItems.DRACO_ARCANUS_BOOTS,
            ModItems.TYR_HELMET,
            ModItems.TYR_CHESTPLATE,
            ModItems.TYR_LEGGINGS,
            ModItems.TYR_BOOTS,
            ModItems.MORTEM_HELMET,
            ModItems.MORTEM_CHESTPLATE,
            ModItems.MORTEM_LEGGINGS,
            ModItems.MORTEM_BOOTS,
            folder = ARMOR
        )

        generateBatch(
            ModItems.ARTISAN_RELIC,
            ModItems.CRESCENT_MOON,
            ModItems.CRIMSON_STONE,
            ModItems.SOUL_CRIMSON_STONE,
            ModItems.ELEMENTARIUM,
            ModItems.DIVINE_PACT,
            ModItems.MALEDICTUS_PACT,
            folder = ENHANCER
        )

        ModModelTemplates.QUANTUM_CATCHER.createModel(
            ModItems.QUANTUM_CATCHER.getModelLocation(),
            ModTextureMapping.quantumCatcher()
        )
        ModItems.DYED_QUANTUM_CATCHERS.forEach { (color, registryEntry) ->
            ModModelTemplates.QUANTUM_CATCHER.createModel(
                registryEntry.getModelLocation(),
                ModTextureMapping.quantumCatcher("/$color")
            )
        }
        ModModelTemplates.QUANTUM_CATCHER.createModel(
            ModItems.BOSS_CATCHER.getModelLocation(),
            ModTextureMapping.quantumCatcher("/boss_catcher")
        )

        ModModelTemplates.UTREM_JAR_ITEM.createModel(
            ModelLocationUtils.getModelLocation(ModBlocks.ESSENCE_UTREM_JAR.get().asItem()),
            TextureMapping.particle(ModBlocks.UTREM_JAR.get())
        )

        val aurealTank0 = generateItem(ModItems.AUREAL_TANK, folder = AUREAL_TANK, suffix = "_0")
        val aurealTank1 = generateItem(ModItems.AUREAL_TANK, folder = AUREAL_TANK, suffix = "_1")
        val aurealTank2 = generateItem(ModItems.AUREAL_TANK, folder = AUREAL_TANK, suffix = "_2")
        val aurealTank3 = generateItem(ModItems.AUREAL_TANK, folder = AUREAL_TANK, suffix = "_3")

        val aurealTankMax = generateItem(ModItems.AUREAL_TANK, folder = AUREAL_TANK, suffix = "_max")
        val aurealTankMax0 = generateItem(ModItems.AUREAL_TANK, folder = AUREAL_TANK, suffix = "_max_0")
        val aurealTankMax1 = generateItem(ModItems.AUREAL_TANK, folder = AUREAL_TANK, suffix = "_max_1")
        val aurealTankMax2 = generateItem(ModItems.AUREAL_TANK, folder = AUREAL_TANK, suffix = "_max_2")
        val aurealTankMax3 = generateItem(ModItems.AUREAL_TANK, folder = AUREAL_TANK, suffix = "_max_3")

        val amount = ForbiddenArcanus.location("amount")
        val max = ForbiddenArcanus.location("max")

        generateWithOverrides(
            item = ModItems.AUREAL_TANK,
            folder = AUREAL_TANK,
            overrides = arrayOf(
                ModelPredicate(aurealTank0, ModelProperty(amount, 0.25f), ModelProperty(max, 0.0f)),
                ModelPredicate(aurealTank1, ModelProperty(amount, 0.5f), ModelProperty(max, 0.0f)),
                ModelPredicate(aurealTank2, ModelProperty(amount, 0.75f), ModelProperty(max, 0.0f)),
                ModelPredicate(aurealTank3, ModelProperty(amount, 1.0f), ModelProperty(max, 0.0f)),
                ModelPredicate(aurealTankMax, ModelProperty(amount, 0.0f), ModelProperty(max, 1.0f)),
                ModelPredicate(aurealTankMax0, ModelProperty(amount, 0.25f), ModelProperty(max, 1.0f)),
                ModelPredicate(aurealTankMax1, ModelProperty(amount, 0.5f), ModelProperty(max, 1.0f)),
                ModelPredicate(aurealTankMax2, ModelProperty(amount, 0.75f), ModelProperty(max, 1.0f)),
                ModelPredicate(aurealTankMax3, ModelProperty(amount, 1.0f), ModelProperty(max, 1.0f))
            )
        )

        val bloodTestTube0 = generateItem(ModItems.BLOOD_TEST_TUBE, folder = BLOOD_TEST_TUBE, suffix = "_0")
        val bloodTestTube1 = generateItem(ModItems.BLOOD_TEST_TUBE, folder = BLOOD_TEST_TUBE, suffix = "_1")
        val bloodTestTube2 = generateItem(ModItems.BLOOD_TEST_TUBE, folder = BLOOD_TEST_TUBE, suffix = "_2")
        val bloodTestTube3 = generateItem(ModItems.BLOOD_TEST_TUBE, folder = BLOOD_TEST_TUBE, suffix = "_3")
        val bloodTestTube4 = generateItem(ModItems.BLOOD_TEST_TUBE, folder = BLOOD_TEST_TUBE, suffix = "_4")
        val bloodTestTube5 = generateItem(ModItems.BLOOD_TEST_TUBE, folder = BLOOD_TEST_TUBE, suffix = "_5")

        generateWithOverrides(
            ModItems.BLOOD_TEST_TUBE,
            folder = BLOOD_TEST_TUBE,
            overrides = arrayOf(
                ModelPredicate(bloodTestTube0, ModelProperty(amount, 0.1f)),
                ModelPredicate(bloodTestTube1, ModelProperty(amount, 0.25f)),
                ModelPredicate(bloodTestTube2, ModelProperty(amount, 0.5f)),
                ModelPredicate(bloodTestTube3, ModelProperty(amount, 0.75f)),
                ModelPredicate(bloodTestTube4, ModelProperty(amount, 0.9f)),
                ModelPredicate(bloodTestTube5, ModelProperty(amount, 1.0f))
            )
        )
    }

    companion object {
        private const val ARMOR = "armor"
        private const val TOOL = "tool"
        private const val ENHANCER = "enhancer"
        private const val AUREAL_TANK = "aureal_tank"
        private const val BLOOD_TEST_TUBE = "blood_test_tube"
    }
}

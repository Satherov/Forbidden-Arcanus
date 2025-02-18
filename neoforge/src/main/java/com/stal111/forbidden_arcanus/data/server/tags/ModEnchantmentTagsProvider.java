package com.stal111.forbidden_arcanus.data.server.tags;

import com.stal111.forbidden_arcanus.ForbiddenArcanus;
import com.stal111.forbidden_arcanus.data.ModEnchantments;
import com.stal111.forbidden_arcanus.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.tags.EnchantmentTagsProvider;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.world.item.enchantment.Enchantments;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.valhelsia.valhelsia_core.datagen.DataProviderContext;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

/**
 * Mod Enchantment Tags Provider
 * Forbidden Arcanus - com.stal111.forbidden_arcanus.data.server.tags.ModEnchantmentTagsProvider
 *
 * @author stal111
 * @since 2021-02-27
 */
public class ModEnchantmentTagsProvider extends EnchantmentTagsProvider {

    public ModEnchantmentTagsProvider(DataProviderContext context, ExistingFileHelper fileHelper) {
        super(context.output(), context.lookupProvider(), ForbiddenArcanus.MOD_ID, fileHelper);
    }

    @Override
    protected void addTags(@NotNull HolderLookup.Provider provider) {
        this.tag(ModTags.Enchantments.ETERNAL_INCOMPATIBLE).add(Enchantments.UNBREAKING, Enchantments.MENDING);
        this.tag(ModTags.Enchantments.FIERY_INCOMPATIBLE).add(Enchantments.SILK_TOUCH);
        this.tag(ModTags.Enchantments.MAGNETIZED_INCOMPATIBLE);
        this.tag(ModTags.Enchantments.DEMOLISHING_INCOMPATIBLE);
        this.tag(ModTags.Enchantments.AQUATIC_INCOMPATIBLE);
        this.tag(EnchantmentTags.NON_TREASURE).add(ModEnchantments.SOUL_LOOTING);
    }

    @Nonnull
    @Override
    public String getName() {
        return ForbiddenArcanus.MOD_ID + ": Enchantment Tags";
    }
}

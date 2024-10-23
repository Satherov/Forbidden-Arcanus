package com.stal111.forbidden_arcanus.datagen

import com.stal111.forbidden_arcanus.ForbiddenArcanus
import com.stal111.forbidden_arcanus.datagen.model.ModBlockModels
import com.stal111.forbidden_arcanus.datagen.model.ModItemModels
import net.valhelsia.dataforge.DataCollector
import net.valhelsia.dataforge.DataProviderContext
import net.valhelsia.dataforge.DataTarget
import net.valhelsia.dataforge.model.DataForgeModelProvider

class ProviderCollector : DataCollector() {
    override fun collectData(context: DataProviderContext) {
        val blocks = ForbiddenArcanus.REGISTRY_MANAGER.blockHelper.registryEntries.map { { it.value() } }

        with(DataTarget.CLIENT) {
            addProvider(this, DataForgeModelProvider(context, blocks, ::ModBlockModels) { ModItemModels(it) })
        }
    }
}
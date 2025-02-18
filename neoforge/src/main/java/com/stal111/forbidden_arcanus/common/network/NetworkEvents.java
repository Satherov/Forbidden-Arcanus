package com.stal111.forbidden_arcanus.common.network;

import com.stal111.forbidden_arcanus.ForbiddenArcanus;
import com.stal111.forbidden_arcanus.common.network.clientbound.*;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

/**
 * @author stal111
 * @since 02.03.2024
 */
public class NetworkEvents {

    @SubscribeEvent
    private void registerPackets(RegisterPayloadHandlersEvent event) {
        final PayloadRegistrar registrar = event.registrar(ForbiddenArcanus.MOD_ID).versioned("1.0");

        registrar.playToClient(SetClibanoResiduesPayload.TYPE, SetClibanoResiduesPayload.STREAM_CODEC, SetClibanoResiduesPayload::handle);
        registrar.playToClient(TransformPedestalPayload.TYPE, TransformPedestalPayload.STREAM_CODEC, TransformPedestalPayload::handle);
        registrar.playToClient(SpawnParticlePayload.TYPE, SpawnParticlePayload.STREAM_CODEC, SpawnParticlePayload::handle);
        registrar.playToClient(UpdateEssencePayload.TYPE, UpdateEssencePayload.STREAM_CODEC, UpdateEssencePayload::handle);
        registrar.playToClient(AdvancedBlockEventPayload.TYPE, AdvancedBlockEventPayload.STREAM_CODEC, AdvancedBlockEventPayload::handle);
    }
}

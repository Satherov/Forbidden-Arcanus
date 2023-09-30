package com.stal111.forbidden_arcanus.common.network.clientbound;

import com.stal111.forbidden_arcanus.common.aureal.AurealHelper;
import com.stal111.forbidden_arcanus.common.network.ClientPacketHandler;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.network.CustomPayloadEvent;
import net.minecraftforge.network.NetworkDirection;

/**
 * Update Aureal Packet <br>
 * Forbidden Arcanus - com.stal111.forbidden_arcanus.network.UpdateAurealPacket
 *
 * @author stal111
 * @version 16.2.0
 * @since 2021-01-27
 */
public record UpdateAurealPacket(CompoundTag tag) {

    public UpdateAurealPacket(Player player) {
        this(AurealHelper.save(new CompoundTag(), AurealHelper.getCapability(player)));
    }

    public static void encode(UpdateAurealPacket packet, FriendlyByteBuf buffer) {
        buffer.writeNbt(packet.tag);
    }

    public static UpdateAurealPacket decode(FriendlyByteBuf buffer) {
        return new UpdateAurealPacket(buffer.readNbt());
    }

    public static void consume(UpdateAurealPacket packet, CustomPayloadEvent.Context context) {
        context.enqueueWork(() -> {
            assert context.getDirection() == NetworkDirection.PLAY_TO_CLIENT;

            ClientPacketHandler.handleUpdateAureal(packet);
        });
        context.setPacketHandled(true);
    }
}

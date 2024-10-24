package com.stal111.forbidden_arcanus.common.entity.lostsoul;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class EnchantedLostSoul extends AbstractLostSoul {

    public EnchantedLostSoul(EntityType<? extends AbstractLostSoul> entityType, Level level) {
        super(entityType, level, Vec3.fromRGB24(253 << 16 | 225 << 8 | 238).toVector3f());
    }
}

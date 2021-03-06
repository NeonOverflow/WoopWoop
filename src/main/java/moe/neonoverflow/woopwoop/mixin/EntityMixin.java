package moe.neonoverflow.woopwoop.mixin;

import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Entity.class)
public abstract class EntityMixin {
    @Shadow protected boolean onGround;
    @Shadow protected abstract boolean getFlag(int index);
    @Shadow public abstract boolean hasVehicle();
}

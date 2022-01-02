package moe.neonoverflow.woopwoop.mixin;

import moe.neonoverflow.woopwoop.PullUpPlayer;
import net.fabricmc.loader.impl.util.log.Log;
import net.fabricmc.loader.impl.util.log.LogCategory;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends EntityMixin {
    @Shadow public abstract ItemStack getEquippedStack(EquipmentSlot var1);
    @Shadow public abstract boolean hasStatusEffect(StatusEffect effect);

    @Inject(method = "tickFallFlying", at = @At("HEAD"))
    private void tickFallFlying(CallbackInfo info) {
        if(!this.hasVehicle() && !this.hasStatusEffect(StatusEffects.LEVITATION) && !this.onGround && this.getFlag(7)) {
            ItemStack chestEquipment = this.getEquippedStack(EquipmentSlot.CHEST);
            if(chestEquipment.getDamage() > 20 && chestEquipment.isOf(Items.ELYTRA) && !PullUpPlayer.isPlaying()) {
                PullUpPlayer.play();
            }
        }
    }
}

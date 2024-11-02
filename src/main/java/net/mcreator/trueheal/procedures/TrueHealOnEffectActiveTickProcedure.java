package net.mcreator.trueheal.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class TrueHealOnEffectActiveTickProcedure {
	public static void execute(Entity entity, double amplifier) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 0) {
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth((float) Math.min((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + amplifier, entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1));
		}
	}
}

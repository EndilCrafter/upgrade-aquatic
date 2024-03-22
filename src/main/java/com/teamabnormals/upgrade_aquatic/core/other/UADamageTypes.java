package com.teamabnormals.upgrade_aquatic.core.other;

import com.teamabnormals.upgrade_aquatic.core.UpgradeAquatic;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

public class UADamageTypes {
	public static final ResourceKey<DamageType> GUARDIAN_SPINE = createKey("guardian_spine");
	public static final ResourceKey<DamageType> ELDER_GUARDIAN_SPINE = createKey("elder_guardian_spine");
	public static final ResourceKey<DamageType> JELLYFISH_STING = createKey("jellyfish_sting");

	public static void bootstrap(BootstapContext<DamageType> context) {
		context.register(GUARDIAN_SPINE, new DamageType(UpgradeAquatic.MOD_ID + ".guardianSpine", 0.1F));
		context.register(ELDER_GUARDIAN_SPINE, new DamageType(UpgradeAquatic.MOD_ID + ".elderGuardianSpine", 0.1F));
		context.register(JELLYFISH_STING, new DamageType(UpgradeAquatic.MOD_ID + ".jellyfishSting", 0.1F));
	}

	public static DamageSource guardianSpine(Level level, boolean elder) {
		return level.damageSources().source(elder ? ELDER_GUARDIAN_SPINE : GUARDIAN_SPINE);
	}

	public static DamageSource jellyfishSting(Level level, @Nullable Entity causingEntity) {
		return level.damageSources().source(JELLYFISH_STING, causingEntity);
	}

	public static ResourceKey<DamageType> createKey(String name) {
		return ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(UpgradeAquatic.MOD_ID, name));
	}
}
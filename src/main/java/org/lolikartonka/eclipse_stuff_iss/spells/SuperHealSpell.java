package org.lolikartonka.eclipse_stuff_iss.spells;

import io.redspace.ironsspellbooks.api.config.DefaultConfig;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.registry.SchoolRegistry;
import io.redspace.ironsspellbooks.api.spells.*;
import io.redspace.ironsspellbooks.api.util.AnimationHolder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import org.lolikartonka.eclipse_stuff_iss.Eclipse_stuff_iss;

import java.util.Optional;

@AutoSpellConfig
public class SuperHealSpell extends AbstractSpell {
    private final DefaultConfig defaultConfig = new DefaultConfig()
            .setMinRarity(SpellRarity.RARE)
            .setSchoolResource(SchoolRegistry.HOLY_RESOURCE)
            .setMaxLevel(3)
            .setCooldownSeconds(12)
            .build();

    public SuperHealSpell() {
        this.manaCostPerLevel = 10;
        this.baseSpellPower = 6;
        this.spellPowerPerLevel = 1;
        this.castTime = 0;
        this.baseManaCost = 30;
    }

    @Override
    public CastType getCastType() {
        return CastType.INSTANT;
    }

    @Override public DefaultConfig getDefaultConfig() { return defaultConfig; }

    @SuppressWarnings({"deprecation", "removal"})
    @Override
    public ResourceLocation getSpellResource() {
        return new ResourceLocation(Eclipse_stuff_iss.MODID, "super_heal");
    }

    @Override
    public Optional<SoundEvent> getCastStartSound() {
        return Optional.empty();
    }

    @Override
    public Optional<SoundEvent> getCastFinishSound() {
        return Optional.empty();
    }

    @Override
    public AnimationHolder getCastStartAnimation() {
        return SpellAnimations.SELF_CAST_ANIMATION;
    }

    @Override
    public void onCast(Level level, int spellLevel, LivingEntity caster,
                       CastSource source, MagicData magicData) {
        if (!level.isClientSide) {
            float amount = 4f + 2f * spellLevel;
            caster.heal(amount);
        }
        super.onCast(level, spellLevel, caster, source, magicData);
    }
}
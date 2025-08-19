package org.lolikartonka.eclipse_stuff_iss.registry;

import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.lolikartonka.eclipse_stuff_iss.Eclipse_stuff_iss;
import org.lolikartonka.eclipse_stuff_iss.spells.SuperHealSpell;

public class SpellsRegistry {
    public static final DeferredRegister<AbstractSpell> SPELLS =
            DeferredRegister.create(SpellRegistry.SPELL_REGISTRY_KEY, Eclipse_stuff_iss.MODID);

    public static final RegistryObject<AbstractSpell> SUPER_HEAL =
            SPELLS.register("super_heal", SuperHealSpell::new);

    public static void register(IEventBus modBus) {
        SPELLS.register(modBus);
    }
}

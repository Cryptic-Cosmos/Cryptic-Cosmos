package com.crypticcosmos.crypticcosmos.registries;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SoundEventRegistries {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, CrypticCosmos.MOD_ID);

    // Lunara music
    public static final RegistryObject<SoundEvent> MUSIC_LUNARA = registerSoundEvent("lunara");
    public static final RegistryObject<SoundEvent> MUSIC_MONDROVE_GROVES = registerSoundEvent("mondrove_groves");
    public static final RegistryObject<SoundEvent> MUSIC_ACERBIC_ISLES = registerSoundEvent("acerbic_isles");
    public static final RegistryObject<SoundEvent> MUSIC_ABYSS = registerSoundEvent("abyss");

    // entity noises
    public static final RegistryObject<SoundEvent> MAKROSSA_RAMBLER_AMBIENCE = registerSoundEvent("entity.makrossa_rambler_living");
    public static final RegistryObject<SoundEvent> MAKROSSA_RAMBLER_HURT = registerSoundEvent("entity.makrossa_rambler_hurt");
    public static final RegistryObject<SoundEvent> MAKROSSA_RAMBLER_DEATH = registerSoundEvent("entity.makrossa_rambler_death");

    public static final RegistryObject<SoundEvent> GROMBLE_FROG_AMBIENCE = registerSoundEvent("entity.gromble_frog_living");
    public static final RegistryObject<SoundEvent> GROMBLE_FROG_HURT = registerSoundEvent("entity.gromble_frog_hurt");
    public static final RegistryObject<SoundEvent> GROMBLE_FROG_DEATH = registerSoundEvent("entity.gromble_frog_death");

    private static RegistryObject<SoundEvent> registerSoundEvent(String id) {
        return SOUND_EVENTS.register(id, () -> new SoundEvent(CrypticCosmos.id(id)));
    }
}
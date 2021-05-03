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
    public static final RegistryObject<SoundEvent> MOON_BEAST_AMBIENCE = registerSoundEvent("entity.moon_beast_living");
    public static final RegistryObject<SoundEvent> MOON_BEAST_HURT = registerSoundEvent("entity.moon_beast_hurt");
    public static final RegistryObject<SoundEvent> MOON_BEAST_DEATH = registerSoundEvent("entity.moon_beast_death");

    private static RegistryObject<SoundEvent> registerSoundEvent(String id) {
        return SOUND_EVENTS.register(id, () -> new SoundEvent(CrypticCosmos.id(id)));
    }
}
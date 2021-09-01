package com.crypticcosmos.crypticcosmos.util;

import net.minecraft.data.DataGenerator;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.SoundDefinition;
import net.minecraftforge.common.data.SoundDefinitionsProvider;

import java.util.Arrays;
import java.util.function.Supplier;

import static com.crypticcosmos.crypticcosmos.CrypticCosmos.MOD_ID;
import static com.crypticcosmos.crypticcosmos.CrypticCosmos.id;
import static com.crypticcosmos.crypticcosmos.register.SoundEventRegistries.*;

public class SoundsGenerator extends SoundDefinitionsProvider {
    /**
     * Creates a new instance of this data provider.
     *
     * @param generator The data generator instance provided by the event you are initializing this provider in.
     * @param helper    The existing file helper provided by the event you are initializing this provider in.
     */
    public SoundsGenerator(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, MOD_ID, helper);
    }

    @Override
    public void registerSounds() {
        // lunara
        add(MUSIC_LUNARA, definition()
                .with(sound(id("lunara/albedo")).stream())
        );

        // mondrove groves
        add(MUSIC_MONDROVE_GROVES, definition()
                .with(sound(id("lunara/payper")).stream(),
                        sound(id("lunara/albedo")).stream()
                )
        );

        // acerbic_isles
        add(MUSIC_ACERBIC_ISLES, definition()
                .with(sound(id("lunara/toru")).stream(),
                        sound(id("lunara/albedo")).stream()
                )
        );

        // abyss
        add(MUSIC_ABYSS, definition()
                .with(sound(id("abyss/altum")),
                        sound(id("abyss/styx")),
                        sound(id("abyss/ourea")),
                        sound(id("abyss/cocytus"))
                )
        );

        // entity.makrossa_rambler_living
        addSound(MAKROSSA_RAMBLER_AMBIENT, "subtitles.entity.makrossa_rambler_ambient",
                "makrossa_rambler/makrossa_rambler_ambient",
                "makrossa_rambler/makrossa_rambler_ambient2",
                "makrossa_rambler/makrossa_rambler_ambient3"
        );

        // entity.makrossa_rambler_hurt
        addSound(MAKROSSA_RAMBLER_HURT, "subtitles.entity.makrossa_rambler_hurt",
                "makrossa_rambler/makrossa_rambler_hurt",
                "makrossa_rambler/makrossa_rambler_hurt2",
                "makrossa_rambler/makrossa_rambler_hurt3"
        );

        // entity.makrossa_rambler_death
        addSound(MAKROSSA_RAMBLER_DEATH, "subtitles.entity.makrossa_rambler_death",
                "makrossa_rambler/makrossa_rambler_death");

        // gromble_frog_living
        addSound(GROMBLE_FROG_AMBIENT, "subtitles.entity.gromble_frog_ambient",
                "gromble_frog/gromble_frog_ambient",
                "gromble_frog/gromble_frog_ambient2",
                "gromble_frog/gromble_frog_ambient3"
        );

        // gromble_frog_hurt
        addSound(GROMBLE_FROG_HURT, "subtitles.entity.gromble_frog_hurt",
                "gromble_frog/gromble_frog_hurt",
                "gromble_frog/gromble_frog_hurt2",
                "gromble_frog/gromble_frog_hurt3"
        );

        addSound(GROMBLE_FROG_DEATH, "subtitles.entity.gromble_frog_death",
                "gromble_frog/gromble_frog_death");
    }

    protected void addSound(Supplier<SoundEvent> sound, String subtitleKey, String... sounds) {
        final SoundDefinition soundDefinition = definition().subtitle(subtitleKey);
        Arrays.stream(sounds).forEach(s -> soundDefinition.with(sound(id(s))));

        add(sound, soundDefinition);
    }
}

package net.peterpancake.projectalchemy.sound;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.util.DeferredSoundType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.peterpancake.projectalchemy.ProjectAlchemy;

import java.util.function.Supplier;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, ProjectAlchemy.MOD_ID);

    public static final Supplier<SoundEvent> CHARGETICK = registerSoundEvent("chargetick");
    public static final Supplier<SoundEvent> GUST = registerSoundEvent("gust");
    public static final Supplier<SoundEvent> KINESIS = registerSoundEvent("kinesis");
    public static final Supplier<SoundEvent> LAUNCH = registerSoundEvent("launch");
    public static final Supplier<SoundEvent> NOVA = registerSoundEvent("nova");
    public static final Supplier<SoundEvent> PACHARGE = registerSoundEvent("pacharge");
    public static final Supplier<SoundEvent> PADESTRUCT = registerSoundEvent("padestruct");
    public static final Supplier<SoundEvent> PAHEAL = registerSoundEvent("paheal");
    public static final Supplier<SoundEvent> PAPOWER = registerSoundEvent("papower");
    public static final Supplier<SoundEvent> PATRANSMUTE = registerSoundEvent("patransmute");
    public static final Supplier<SoundEvent> PAUNCHARGE = registerSoundEvent("pauncharge");
    public static final Supplier<SoundEvent> PAWATERMAGIC = registerSoundEvent("pawatermagic");
    public static final Supplier<SoundEvent> PAWINDMAGIC = registerSoundEvent("pawindmagic");
    public static final Supplier<SoundEvent> PHILBALL = registerSoundEvent("philball");
    public static final Supplier<SoundEvent> TOCK = registerSoundEvent("tock");

    private static Supplier<SoundEvent> registerSoundEvent(String name) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(ProjectAlchemy.MOD_ID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}

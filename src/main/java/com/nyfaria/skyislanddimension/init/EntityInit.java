package com.nyfaria.skyislanddimension.init;

import com.nyfaria.skyislanddimension.SkyIslandDimension;
import com.nyfaria.skyislanddimension.entity.canon.SkyCannonEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class EntityInit {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, SkyIslandDimension.MOD_ID);

    public static final RegistryObject<EntityType<SkyCannonEntity>> SKY_CANNON = registerEntity("sky_cannon", () -> EntityType.Builder.<SkyCannonEntity>of(SkyCannonEntity::new, EntityClassification.MISC)
            .sized(1f, 1.5f).setShouldReceiveVelocityUpdates(false));



    @SubscribeEvent
    public static void attribs(EntityAttributeCreationEvent e) {

    }


    private static <T extends Entity> RegistryObject<EntityType<T>> registerEntity(String name, Supplier<EntityType.Builder<T>> supplier) {
        return ENTITIES.register(name, () -> supplier.get().build(name));
    }
}

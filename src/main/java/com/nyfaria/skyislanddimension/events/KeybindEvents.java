package com.nyfaria.skyislanddimension.events;

import com.nyfaria.skyislanddimension.SkyIslandDimension;
import com.nyfaria.skyislanddimension.cap.caps.BuffCapability;
import com.nyfaria.skyislanddimension.entity.canon.SkyCannonEntity;
import com.nyfaria.skyislanddimension.network.NetworkHandler;
import com.nyfaria.skyislanddimension.network.ToggleCannonPacket;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.client.util.InputMappings;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, modid = SkyIslandDimension.MOD_ID, value = Dist.CLIENT)
public class KeybindEvents {

    private static final List<KeyBinding> keyBindings = new ArrayList<>();

    public static final KeyBinding EXIT_ABILITY_SCREEN = registerInGameKeyBinding("keys.buffabilities.exit_ability_screen", GLFW.GLFW_KEY_V);

    public static void init() {
        keyBindings.forEach(ClientRegistry::registerKeyBinding);
    }

    @SubscribeEvent
    public static void keyInput(InputEvent.KeyInputEvent e) {
        if (Minecraft.getInstance().level == null)
            return;
        PlayerEntity player = Minecraft.getInstance().player;
        if (didPress(e, EXIT_ABILITY_SCREEN)) {

            if(player.isPassenger()){
                if(player.getVehicle() instanceof SkyCannonEntity){
                    //player.getVehicle().ejectPassengers();
                    NetworkHandler.INSTANCE.sendToServer(new ToggleCannonPacket());
                    Vector3d view = player.getViewVector(0);
                    player.push(view.x * 20, view.y * 20 , view.z * 20 );

                }
            }


        }
    }


    private static boolean didPress(InputEvent.KeyInputEvent event, KeyBinding keyBinding) {
        return event.getAction() == GLFW.GLFW_PRESS && isKey(event, keyBinding);
    }

    private static boolean isKey(InputEvent.KeyInputEvent event, KeyBinding keyBinding) {
        return keyBinding.matches(event.getKey(), event.getScanCode()) && keyBinding.isConflictContextAndModifierActive();
    }

    private static KeyBinding registerInGameKeyBinding(String description, int keyCode) {
        return registerKeyBinding(description, KeyConflictContext.IN_GAME, keyCode);

    }
    private static KeyBinding registerKeyBinding(String description, KeyConflictContext conflictContext, int keyCode) {
        KeyBinding key = new KeyBinding(description, conflictContext, InputMappings.Type.KEYSYM.getOrCreate(keyCode), "keys.category.buffabilities");
        keyBindings.add(key);
        return key;
    }

}

package biotech;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import gregapi.data.CS;
import gregapi.data.IL;
import gregapi.data.MD;
import gregapi.util.ST;
import gregapi.util.UT;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

import javax.annotation.Nullable;
import java.util.List;

import static gregapi.data.CS.*;

public class EventHandler {

    public static void init() {
        EventHandler handler = new EventHandler();
        FMLCommonHandler.instance().bus().register(handler);
        MinecraftForge.EVENT_BUS.register(handler);
    }

    public static void handleDrops(EntityLivingBase aDead, String aClass, List<EntityItem> aDrops, int aLooting, boolean aBurn, boolean aPlayerKill) {
        if (Loader.isModLoaded("wildmobsmod")) {
            boolean RIB = F, DOG = F, BIG = F, SCR = T;
            if ("EntityDread".equalsIgnoreCase(aClass)) {
            } else if ("EntityFaded".equalsIgnoreCase(aClass)) {
                SCR = F;
            } else if ("EntityMagmaPlant".equalsIgnoreCase(aClass)) {
                SCR = F;
            } else if ("EntitySeaScorpion".equalsIgnoreCase(aClass)) {
                SCR = F;
                drop(aDead, aDrops, aLooting, aBurn, ST.make(MD.HaC, "crayfishrawItem", 1), ST.make(MD.HaC, "crayfishcookedItem", 1));
            } else if ("EntityTarantula".equalsIgnoreCase(aClass)) {
                SCR = F;
                // Spider
            } else if ("EntityZomgus".equalsIgnoreCase(aClass)) {
                SCR = F;
                // zombie mushroom
            } else if ("EntityArmadillo".equalsIgnoreCase(aClass)) {

            } else if ("EntityBison".equalsIgnoreCase(aClass)) {
                RIB = T;
                BIG = T;
            } else if ("EntityButterfly".equalsIgnoreCase(aClass)) {
                SCR = F;

            } else if ("EntityCheetah".equalsIgnoreCase(aClass)) {
                DOG = T;
            } else if ("EntityCougar".equalsIgnoreCase(aClass)) {
                DOG = T;
            } else if ("EntityDeer".equalsIgnoreCase(aClass)) {
                drop(aDead, aDrops, aLooting, aBurn, ST.make(MD.HaC, "venisonrawItem", 1), ST.make(MD.HaC, "venisoncookedItem", 1));
                RIB = T;
            } else if ("EntityDireWolf".equalsIgnoreCase(aClass)) {
                DOG = T;
                BIG = T;
            } else if ("EntityDragonfly".equalsIgnoreCase(aClass)) {
                SCR = F;
            } else if ("EntityFox".equalsIgnoreCase(aClass)) {
                DOG = T;
            } else if ("EntityGoat".equalsIgnoreCase(aClass)) {
            } else if ("EntityHyena".equalsIgnoreCase(aClass)) {
                DOG = T;
            } else if ("EntityJellyfish".equalsIgnoreCase(aClass)) {
                SCR = F;
                drop(aDead, aDrops, aLooting, aBurn, ST.make(MD.HaC, "jellyfish", 1));
            } else if ("EntityMouse".equalsIgnoreCase(aClass)) {
                drop(aDead, aDrops, aLooting, aBurn, IL.Food_Cheese_Sliced.get(1));
            } else if ("EntityWMOcelot".equalsIgnoreCase(aClass)) {
                DOG = T;
            } else if ("EntityWMWolf".equalsIgnoreCase(aClass)) {
                DOG = T;
            } else if ("EntityGoose".equalsIgnoreCase(aClass)) {
                drop(aDead, aDrops, aLooting, aBurn, IL.Food_Gooseberry.get(1)); // make sense
            }
            int tAmount = 1;
            if (BIG) tAmount += 1;
            if (DOG)
                drop(aDead, aDrops, aLooting, aBurn, IL.Food_DogMeat_Raw.get(tAmount), IL.Food_DogMeat_Cooked.get(tAmount));
            if (RIB)
                drop(aDead, aDrops, aLooting, aBurn, IL.Food_Rib_Raw.get(tAmount), IL.Food_Rib_Cooked.get(tAmount));
            if (RIB)
                drop(aDead, aDrops, aLooting, aBurn, IL.Food_RibEyeSteak_Raw.get(tAmount), IL.Food_RibEyeSteak_Cooked.get(tAmount));
            if (SCR)
                drop(aDead, aDrops, aLooting, aBurn, IL.Food_Scrap_Meat.get(tAmount));
        }
    }

    private static void drop(EntityLivingBase aDead, List<EntityItem> aDrops, int aLooting, boolean aBurn, ItemStack aRaw) {
        drop(aDead, aDrops, aLooting, aBurn, aRaw, NI);
    }

    private static void drop(EntityLivingBase aDead, List<EntityItem> aDrops, int aLooting, boolean aBurn, ItemStack aRaw, @Nullable ItemStack aCooked) {
        if (aRaw == NI) return;
        if (aCooked == CS.NI) aCooked = aRaw.copy();
        if (aCooked == NI) return;
        int tAmount = RNGSUS.nextInt(3);
        if (aLooting > 0) tAmount += RNGSUS.nextInt(aLooting + 1);
        while (tAmount-- > 0) aDrops.add(ST.entity(aDead, aBurn ? aCooked : aRaw));
    }

    @SubscribeEvent
    public void onEntityLivingDropsEventEvent(LivingDropsEvent aEvent) {
        if (aEvent.entity.worldObj.isRemote || aEvent.entity instanceof EntityPlayer || aEvent.entityLiving == null)
            return;
        handleDrops(aEvent.entityLiving, UT.Reflection.getLowercaseClass(aEvent.entityLiving), aEvent.drops, aEvent.lootingLevel, aEvent.entityLiving.isBurning(), aEvent.recentlyHit);
    }
}

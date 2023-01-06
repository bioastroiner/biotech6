package biotech;

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
import net.minecraftforge.event.entity.living.LivingDropsEvent;

import javax.annotation.Nullable;
import java.util.List;

import static gregapi.data.CS.*;

public class EventHandler {
    public static void handleDrops(EntityLivingBase aDead, String aClass, List<EntityItem> aDrops, int aLooting, boolean aBurn, boolean aPlayerKill) {
        if (Loader.isModLoaded("wildmobsmod")) {
            boolean RIB = F, DOG = F, BIG = F;
            if ("Dread".equalsIgnoreCase(aClass)) {
            } else if ("Faded".equalsIgnoreCase(aClass)) {
            } else if ("MagmaPlant".equalsIgnoreCase(aClass)) {
            } else if ("SeaScorpion".equalsIgnoreCase(aClass)) {
                burntDrop(aDead, aDrops, aLooting, aBurn, ST.make(MD.HaC, "crayfishrawItem", 1), ST.make(MD.HaC, "crayfishcookedItem", 1));
            } else if ("Tarantula".equalsIgnoreCase(aClass)) {
                // Spider
            } else if ("Zomgus".equalsIgnoreCase(aClass)) {
                // zombie mushroom
            } else if ("Armadillo".equalsIgnoreCase(aClass)) {

            } else if ("Bison".equalsIgnoreCase(aClass)) {
                RIB = T;
                BIG = T;
            } else if ("Butterfly".equalsIgnoreCase(aClass)) {

            } else if ("Cheetah".equalsIgnoreCase(aClass)) {
                DOG = T;
            } else if ("Cougar".equalsIgnoreCase(aClass)) {
                DOG = T;
            } else if ("Deer".equalsIgnoreCase(aClass)) {
                burntDrop(aDead, aDrops, aLooting, aBurn, ST.make(MD.HaC, "venisonrawItem", 1), ST.make(MD.HaC, "venisoncookedItem", 1));
                RIB = T;
            } else if ("DireWolf".equalsIgnoreCase(aClass)) {
                DOG = T;
                BIG = T;
            } else if ("Dragonfly".equalsIgnoreCase(aClass)) {
                
            } else if ("Fox".equalsIgnoreCase(aClass)) {
                DOG = T;
            } else if ("Goat".equalsIgnoreCase(aClass)) {
                burntDrop(aDead, aDrops, aLooting, aBurn, IL.Food_Mutton_Cooked.get(1), IL.Food_Mutton_Raw.get(1));
            } else if ("Hyena".equalsIgnoreCase(aClass)) {
                DOG = T;
            } else if ("Jellyfish".equalsIgnoreCase(aClass)) {
                burntDrop(aDead, aDrops, aLooting, aBurn, ST.make(MD.HaC, "jellyfish", 1), CS.NI);
            } else if ("Mouse".equalsIgnoreCase(aClass)) {
                burntDrop(aDead, aDrops, aLooting, aBurn, IL.Food_Cheese.get(1), null);
            } else if ("WMOcelot".equalsIgnoreCase(aClass)) {
                DOG = T;
                burntDrop(aDead, aDrops, aLooting, aBurn, IL.Food_DogMeat_Cooked.get(1), IL.Food_DogMeat_Raw.get(1));
            } else if ("WMWolf".equalsIgnoreCase(aClass)) {
                DOG = T;
                burntDrop(aDead, aDrops, aLooting, aBurn, IL.Food_DogMeat_Cooked.get(1), IL.Food_DogMeat_Raw.get(1));
            } else if ("goose".equalsIgnoreCase(aClass)) {
                burntDrop(aDead, aDrops, aLooting, aBurn, ST.make(MD.HaC, "turkeyrawItem", 1), ST.make(MD.HaC, "turkeycookedItem", 1)); // turkey = goose
                burntDrop(aDead, aDrops, aLooting, aBurn, IL.Food_Gooseberry.get(1), NI); // make sense
            }
            int tAmount = 1;
            if (BIG) tAmount += RNGSUS.nextInt(1);
            if (DOG)
                burntDrop(aDead, aDrops, aLooting, aBurn, IL.Food_DogMeat_Cooked.get(tAmount), IL.Food_DogMeat_Raw.get(tAmount));
            if (RIB)
                burntDrop(aDead, aDrops, aLooting, aBurn, IL.Food_Rib_Raw.get(tAmount), IL.Food_Rib_Raw.get(tAmount));
            if (RIB)
                burntDrop(aDead, aDrops, aLooting, aBurn, IL.Food_RibEyeSteak_Raw.get(tAmount), IL.Food_RibEyeSteak_Raw.get(tAmount));
        }
    }

    private static void burntDrop(EntityLivingBase aDead, List<EntityItem> aDrops, int aLooting, boolean aBurn, ItemStack aRaw, @Nullable ItemStack aCooked) {
        if (aCooked == CS.NI) aCooked = aRaw.copy();
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

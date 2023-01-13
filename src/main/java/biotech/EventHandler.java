package biotech;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import gregapi.util.UT;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

public class EventHandler {

    public static void init() {
        EventHandler handler = new EventHandler();
        FMLCommonHandler.instance().bus().register(handler);
        MinecraftForge.EVENT_BUS.register(handler);
    }

    @SubscribeEvent
    public void onEntityLivingDropsEventEvent(LivingDropsEvent aEvent) {
        if (aEvent.entity.worldObj.isRemote || aEvent.entity instanceof EntityPlayer || aEvent.entityLiving == null)
            return;
        /* WildMobs drops */
        WildMobs_Compat.handleDrops(aEvent.entityLiving, UT.Reflection.getLowercaseClass(aEvent.entityLiving), aEvent.drops, aEvent.lootingLevel, aEvent.entityLiving.isBurning(), aEvent.recentlyHit);
    }
}

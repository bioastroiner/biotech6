package biotech;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.*;
import gravisuite.GraviSuite;
import gregapi.api.Abstract_Proxy;
import gregapi.code.ModData;
import gregapi.data.*;
import gregapi.oredict.OreDictManager;
import gregapi.oredict.OreDictMaterial;
import gregapi.oredict.OreDictPrefix;
import gregapi.oredict.event.IOreDictListenerEvent;
import gregapi.oredict.event.OreDictListenerEvent_Names;
import gregapi.oredict.listeners.OreDictListenerItem_Rocks;
import gregapi.recipes.Recipe;
import gregapi.util.CR;
import gregapi.util.OM;
import gregapi.util.ST;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static gregapi.data.CS.NI;
import static gregapi.data.MT.*;

@Mod(modid = BioTech6Mod.MOD_ID, name = BioTech6Mod.MOD_NAME, version = BioTech6Mod.VERSION, dependencies = "required-after:gregapi_post")
public final class BioTech6Mod extends gregapi.api.Abstract_Mod {

    public static final String MOD_ID = Tags.MODID;
    public static final String MOD_NAME = Tags.MODNAME;
    public static final String VERSION = Tags.VERSION;
    public static ModData MOD_BT6 = new ModData(MOD_ID, MOD_NAME);
    public static final ModData MOD_WM = new ModData("wildmobsmod", "Wild Mobs");
    public static final Logger LOG = LogManager.getLogger(MOD_ID);

    @Mod.Instance
    public static BioTech6Mod INSTANCE;
    @SidedProxy(modId = MOD_ID, clientSide = Tags.CLIENTSIDE, serverSide = Tags.SERVERSIDE)
    public static Abstract_Proxy PROXY;

    public BioTech6Mod() {
        INSTANCE = this;
    }

    @Override
    public String getModID() {
        return MOD_ID;
    }

    @Override
    public String getModName() {
        return MOD_NAME;
    }

    @Override
    public String getModNameForLog() {
        return MOD_ID + "_LOGGER";
    }

    public static void log(String message){
        LOG.log(Level.DEBUG, "BioTech_Mod: "+message);
    }

    public static void out(String message){
        log("BioTech_Mod: "+message);
    }

    public static void err(String message){
        LOG.log(Level.ERROR,"BioTech_Mod: "+message);
    }

    @Override
    public Abstract_Proxy getProxy() {
        return PROXY;
    }

    // Do not change these 7 Functions. Just keep them this way.
    @Mod.EventHandler
    public final void onPreLoad(FMLPreInitializationEvent aEvent) {
        onModPreInit(aEvent);
    }

    @Mod.EventHandler
    public final void onLoad(FMLInitializationEvent aEvent) {
        onModInit(aEvent);
    }

    @Mod.EventHandler
    public final void onPostLoad(FMLPostInitializationEvent aEvent) {
        onModPostInit(aEvent);
    }

    @Mod.EventHandler
    public final void onServerStarting(FMLServerStartingEvent aEvent) {
        onModServerStarting(aEvent);
    }

    @Mod.EventHandler
    public final void onServerStarted(FMLServerStartedEvent aEvent) {
        onModServerStarted(aEvent);
    }

    @Mod.EventHandler
    public final void onServerStopping(FMLServerStoppingEvent aEvent) {
        onModServerStopping(aEvent);
    }

    @Mod.EventHandler
    public final void onServerStopped(FMLServerStoppedEvent aEvent) {
        onModServerStopped(aEvent);
    }

    @Override
    public void onModPreInit2(FMLPreInitializationEvent aEvent) {
        out("PreInit");
        EventHandler.init();
        MetaTileEntities.init();
        WildMobs_Compat.init();

//        ModData MOD_GS = new ModData("GraviSuite", "Gravitation Suite");
//        ItemStack ic2_glass_fiber = ST.make(MD.IC2,"itemCable",1,9);
//        CR.remove(ic2_glass_fiber);
//        CR.remove(ST.make(MOD_GS,"itemSimpleItem",1,1));
//        RM.Nanofab.addRecipe2(true,16,100,ST.make(MD.GT,"gt.multitileentity",1,24900), OP.dust.mat(EnergiumRed,2),ic2_glass_fiber );
//        RM.Nanofab.addRecipe2(true,16,100,ic2_glass_fiber, OP.wireGt01.mat(YttriumBariumCuprate,1),ST.make(MOD_GS,"itemSimpleItem",1,1) ); // TODO fix YttierumBariumWire

        new OreDictListenerEvent_Names() {
            @Override
            public void addAllListeners() {
                addListener("gemCertusQuartz", new IOreDictListenerEvent() {
                    @Override
                    public void onOreRegistration(OreDictRegistrationContainer aEvent) {
                        RM.ae_grinder(10, aEvent.mStack, OP.dust.mat(MT.CertusQuartz, 1));
                        MetaTileEntities.Assembler.addRecipeX(CS.T, 16, 100 ,new ItemStack[]{aEvent.mStack, OM.dust(aEvent.mMaterial)},OM.dust(aEvent.mMaterial)); //TODO remove
                        out("CHECK" + " X " + aEvent.mOreDictName);
                    }
                });
            }
        };
//        new OreDictListenerItem_Rocks(){
//            @Override
//            public void addAllListeners() {
////                addListener("gemCertusQuartz", new IOreDictListenerEvent() {
////                    @Override
////                    public void onOreRegistration(OreDictRegistrationContainer aEvent) {
////                        RM.ae_grinder(10, aEvent.mStack, OP.dust.mat(MT.CertusQuartz, 1));
////                    }
////                });
//            }
//        };

    }

    @Override
    public void onModInit2(FMLInitializationEvent aEvent) {
        out("BioTech_Mod: Init");
    }

    @Override
    public void onModPostInit2(FMLPostInitializationEvent aEvent) {
        out("PostInit");
    }

    @Override
    public void onModServerStarting2(FMLServerStartingEvent aEvent) {
        // Insert your ServerStarting Code here and not above
    }

    @Override
    public void onModServerStarted2(FMLServerStartedEvent aEvent) {
        // Insert your ServerStarted Code here and not above
    }

    @Override
    public void onModServerStopping2(FMLServerStoppingEvent aEvent) {
        // Insert your ServerStopping Code here and not above
    }

    @Override
    public void onModServerStopped2(FMLServerStoppedEvent aEvent) {
        // Insert your ServerStopped Code here and not above
    }
}

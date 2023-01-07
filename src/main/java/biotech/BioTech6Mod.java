package biotech;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.*;
import gregapi.api.Abstract_Proxy;
import gregapi.code.ModData;

@Mod(modid = BioTech6Mod.MOD_ID, name = BioTech6Mod.MOD_NAME, version = BioTech6Mod.VERSION, dependencies = "required-after:gregapi_post")
public final class BioTech6Mod extends gregapi.api.Abstract_Mod {

    public static final String MOD_ID = Tags.MODID;
    public static final String MOD_NAME = Tags.MODNAME;
    public static final String VERSION = Tags.VERSION;
    public static ModData MOD_DATA = new ModData(MOD_ID, MOD_NAME);

    @SidedProxy(modId = MOD_ID, clientSide = Tags.CLIENTSIDE, serverSide = Tags.SERVERSIDE)
    public static Abstract_Proxy PROXY;

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
        new Compat_Recipes_WildMobs(new ModData("wildmobs", "Wild Mobs"), this);
    }

    @Override
    public void onModInit2(FMLInitializationEvent aEvent) {

    }

    @Override
    public void onModPostInit2(FMLPostInitializationEvent aEvent) {
        // Insert your PostInit Code here and not above
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

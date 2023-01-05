package com.biotech;

@cpw.mods.fml.common.Mod(modid=BioTech6Mod.MOD_ID, name=BioTech6Mod.MOD_NAME, version=BioTech6Mod.VERSION, dependencies="required-after:gregapi_post")
public final class BioTech6Mod extends gregapi.api.Abstract_Mod {
	/** Your Mod-ID has to be LOWERCASE and without Spaces. Uppercase Chars and Spaces can create problems with Resource Packs. This is a vanilla forge "Issue". */
	public static final String MOD_ID = "biotech6"; // <-- TODO: you need to change this to the ID of your own Mod, and then remove this Comment after you did that.
	/** This is your Mods Name */
	public static final String MOD_NAME = "BioTech6 CoreMod"; // <-- TODO: you need to change this to the Name of your own Mod, and then remove this Comment after you did that.
	/** This is your Mods Version */
	public static final String VERSION = "1.0.0-MC1710"; // <-- TODO: you need to change this to the Version of your own Mod, and then remove this Comment after you did that.
	/** Contains a ModData Object for ID and Name. Doesn't have to be changed. */
	public static gregapi.code.ModData MOD_DATA = new gregapi.code.ModData(MOD_ID, MOD_NAME);

	@cpw.mods.fml.common.SidedProxy(modId = MOD_ID, clientSide = "gregapi.api.example.Example_Proxy_Client", serverSide = "gregapi.api.example.Example_Proxy_Server")
	public static gregapi.api.Abstract_Proxy PROXY;

	@Override public String getModID() {return MOD_ID;}
	@Override public String getModName() {return MOD_NAME;}
	@Override public String getModNameForLog() {return "BioTech6";}
	@Override public gregapi.api.Abstract_Proxy getProxy() {return PROXY;}

	// Do not change these 7 Functions. Just keep them this way.
	@cpw.mods.fml.common.Mod.EventHandler public final void onPreLoad           (cpw.mods.fml.common.event.FMLPreInitializationEvent    aEvent) {onModPreInit(aEvent);}
	@cpw.mods.fml.common.Mod.EventHandler public final void onLoad              (cpw.mods.fml.common.event.FMLInitializationEvent       aEvent) {onModInit(aEvent);}
	@cpw.mods.fml.common.Mod.EventHandler public final void onPostLoad          (cpw.mods.fml.common.event.FMLPostInitializationEvent   aEvent) {onModPostInit(aEvent);}
	@cpw.mods.fml.common.Mod.EventHandler public final void onServerStarting    (cpw.mods.fml.common.event.FMLServerStartingEvent       aEvent) {onModServerStarting(aEvent);}
	@cpw.mods.fml.common.Mod.EventHandler public final void onServerStarted     (cpw.mods.fml.common.event.FMLServerStartedEvent        aEvent) {onModServerStarted(aEvent);}
	@cpw.mods.fml.common.Mod.EventHandler public final void onServerStopping    (cpw.mods.fml.common.event.FMLServerStoppingEvent       aEvent) {onModServerStopping(aEvent);}
	@cpw.mods.fml.common.Mod.EventHandler public final void onServerStopped     (cpw.mods.fml.common.event.FMLServerStoppedEvent        aEvent) {onModServerStopped(aEvent);}

	@Override
	public void onModPreInit2(cpw.mods.fml.common.event.FMLPreInitializationEvent aEvent) {

	}

	@Override
	public void onModPostInit2(cpw.mods.fml.common.event.FMLPostInitializationEvent aEvent) {
		// Insert your PostInit Code here and not above
	}

	@Override
	public void onModServerStarting2(cpw.mods.fml.common.event.FMLServerStartingEvent aEvent) {
		// Insert your ServerStarting Code here and not above
	}

	@Override
	public void onModServerStarted2(cpw.mods.fml.common.event.FMLServerStartedEvent aEvent) {
		// Insert your ServerStarted Code here and not above
	}

	@Override
	public void onModServerStopping2(cpw.mods.fml.common.event.FMLServerStoppingEvent aEvent) {
		// Insert your ServerStopping Code here and not above
	}

	@Override
	public void onModServerStopped2(cpw.mods.fml.common.event.FMLServerStoppedEvent aEvent) {
		// Insert your ServerStopped Code here and not above
	}
}

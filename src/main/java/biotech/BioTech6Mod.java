package biotech;

import com.wildmobsmod.items.WildMobsModItems;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.*;
import gregapi.api.Abstract_Proxy;
import gregapi.code.ModData;
import gregapi.data.CS;
import gregapi.data.FL;
import gregapi.data.MT;
import gregapi.data.RM;
import gregapi.oredict.OreDictItemData;
import gregapi.util.OM;
import gregapi.util.ST;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import static gregapi.data.CS.*;

@Mod(modid = BioTech6Mod.MOD_ID, name = BioTech6Mod.MOD_NAME, version = BioTech6Mod.VERSION, dependencies = "required-after:gregapi_post")
public final class BioTech6Mod extends gregapi.api.Abstract_Mod {

    public static final String MOD_ID = Tags.MODID;
    public static final String MOD_NAME = Tags.MODNAME;
    public static final String VERSION = Tags.VERSION;
    public static ModData MOD_DATA = new ModData(MOD_ID, MOD_NAME);

    public static final ModData MOD_WM = new ModData("wildmobsmod", "Wild Mobs");

    @Mod.Instance
    public static BioTech6Mod INSTANCE;

    @SidedProxy(modId = MOD_ID, clientSide = Tags.CLIENTSIDE, serverSide = Tags.SERVERSIDE)
    public static Abstract_Proxy PROXY;

    public BioTech6Mod(){
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
        OUT.println("BioTech_Mod: PreInit");
        EventHandler.init();
        //MinecraftForge.EVENT_BUS.register(this);
        //MinecraftForge.EVENT_BUS.register(EventHandler.class);
        //new Compat_Recipes_WildMobs(new ModData("wildmobsmod", "Wild Mobs"), this);

//        new OreDictListenerEvent_Names() {
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


        /************************************************************************************************************************/
        ItemStack test1 = ST.make(MOD_WM,"venison",1);
        ItemStack test2 = ST.make(WildMobsModItems.rawVenison,1,W);

        CS.FoodsGT.put(ST.make(MOD_WM, "venison", 1), 0, 0, 0, 0, 12);
        CS.FoodsGT.put(ST.make(MOD_WM, "cooked_venison", 1), 0, 0, 0, 10, 12);
        CS.FoodsGT.put(ST.make(MOD_WM, "calamari", 1), 0, 0, 0, 0, 12);
        CS.FoodsGT.put(ST.make(MOD_WM, "cooked_calamari", 1), 0, 0, 0, 10, 12);
        CS.FoodsGT.put(ST.make(MOD_WM, "bison_meat", 1), 0, 0, 0, 0, 12);
        CS.FoodsGT.put(ST.make(MOD_WM, "cooked_bison_meat", 1), 0, 0, 0, 10, 12);
        CS.FoodsGT.put(ST.make(MOD_WM, "chevon", 1), 0, 0, 0, 0, 12);
        CS.FoodsGT.put(ST.make(MOD_WM, "cooked_chevon", 1), 0, 0, 0, 10, 12);
        CS.FoodsGT.put(ST.make(MOD_WM, "goose", 1), 0, 0, 0, 0, 12);
        CS.FoodsGT.put(ST.make(MOD_WM, "cooked_goose", 1), 0, 0, 0, 10, 12);
        CS.FoodsGT.put(ST.make(MOD_WM, "mouse", 1), 0, 0, 0, 0, 12);
        CS.FoodsGT.put(ST.make(MOD_WM, "cooked_mouse", 1), 0, 0, 0, 10, 12);

        OUT.println("BioTech_Mod: Registring WildMobs OreDicts.");
        OM.reg(ST.make(MOD_WM, "venison", 1), "foodVensionraw");
        OM.reg(ST.make(MOD_WM, "venison", 1), "listAllvensionraw");
        OM.reg(ST.make(MOD_WM, "chevon", 1), "listAllmuttonraw");
        OM.reg(ST.make(MOD_WM, "cooked_venison", 1), "foodVensioncooked");
        OM.reg(ST.make(MOD_WM, "cooked_venison", 1), "listAllvensioncooked");
        OM.reg(ST.make(MOD_WM, "cooked_chevon", 1), "listAllmuttoncooked");

        OM.reg(ST.make(MOD_WM, "calamari", 1), "foodCalamariraw");
        OM.reg(ST.make(MOD_WM, "calamari", 1), "listAllcalamariraw");
        OM.reg(ST.make(MOD_WM, "cooked_calamari", 1), "foodCalamaricooked");
        OM.reg(ST.make(MOD_WM, "cooked_calamari", 1), "listAllcalamaricooked");

        OM.reg(ST.make(MOD_WM, "bison_meat", 1), "listAllbeef");
        OM.reg(ST.make(MOD_WM, "cooked_bison_meat", 1), "listAllcookedbeef"); // TODO: check this
        OM.reg(ST.make(MOD_WM, "bison_meat", 1), "listAllbison");
        OM.reg(ST.make(MOD_WM, "cooked_bison_meat", 1), "listAllcookedbison");

        OM.reg(ST.make(MOD_WM, "bison_meat", 1), "listAllmeatraw");
        OM.reg(ST.make(MOD_WM, "calamari", 1), "listAllmeatraw");
        OM.reg(ST.make(MOD_WM, "chevon", 1), "listAllmeatraw");
        OM.reg(ST.make(MOD_WM, "goose", 1), "listAllmeatraw");
        OM.reg(ST.make(MOD_WM, "mouse", 1), "listAllmeatraw");
        OM.reg(ST.make(MOD_WM, "venison", 1), "listAllmeatraw");

        OM.reg(ST.make(MOD_WM, "cooked_bison_meat", 1), "listAllmeatcooked");
        OM.reg(ST.make(MOD_WM, "cooked_calamari", 1), "listAllmeatcooked");
        OM.reg(ST.make(MOD_WM, "cooked_chevon", 1), "listAllmeatcooked");
        OM.reg(ST.make(MOD_WM, "cooked_goose", 1), "listAllmeatcooked");
        OM.reg(ST.make(MOD_WM, "cooked_mouse", 1), "listAllmeatcooked");
        OM.reg(ST.make(MOD_WM, "cooked_venison", 1), "listAllmeatcooked");

        OUT.println("BioTech_Mod: Recipes for WildMobs Items.");
        RM.Mixer.addRecipe1(T, 16, 16, ST.make(MOD_WM, "fur", 1), FL.Water.make(1000), NF, ST.make(Items.leather, 1, W));
        RM.Mixer.addRecipe1(T, 16, 16, ST.make(MOD_WM, "bison_leather", 1), FL.Water.make(1000), NF, ST.make(Items.leather, 1, W));
        RM.Mixer.addRecipe1(T, 16, 16, ST.make(MOD_WM, "fur", 1), FL.Water.make(1000), NF, ST.make(Items.leather, 1, W));
        RM.Generifier.addRecipe1(T, 16, 16, ST.make(MOD_WM, "infected_flesh", 1), NF, NF, ST.make(Items.rotten_flesh, 1, W));

        RM.Shredder.addRecipe1(T, 16, 16, ST.make(MOD_WM, "armadillo_shell", 1), OM.dust(MT.Ca, U / 9));
        RM.Shredder.addRecipe1(T, 16, 16, ST.make(MOD_WM, "thick_bone", 1), OM.dust(MT.Bone, U * 10));

        OM.data(ST.make(MOD_WM, "bison_leather", 1), new OreDictItemData(MT.Leather, U));
        OM.data(ST.make(MOD_WM, "fur", 1), new OreDictItemData(MT.Leather, U));
        OM.data(ST.make(MOD_WM, "armadillo_shell", 1), new OreDictItemData(MT.Bone, U9));
        OM.data(ST.make(MOD_WM, "thick_bone", 1), new OreDictItemData(MT.Bone, U * 10));
        OM.data(ST.make(MOD_WM, "venison", 1), new OreDictItemData(MT.MeatRaw, U * 3, MT.Bone, U2));
        OM.data(ST.make(MOD_WM, "infected_flesh", 1), new OreDictItemData(MT.MeatRotten, U * 2, MT.Bone, U9));

        //OM.data(ST.make(WM, "slimeDrop", 1), new OreDictItemData(MT.SlimyBone, U * 10));

        OM.data(ST.make(MOD_WM, "cooked_bison_meat", 1), new OreDictItemData(MT.MeatCooked, U * 4, MT.Bone, U4));
        OM.data(ST.make(MOD_WM, "cooked_calamari", 1), new OreDictItemData(MT.FishCooked, U * 2));
        OM.data(ST.make(MOD_WM, "cooked_chevon", 1), new OreDictItemData(MT.MeatCooked, U * 3, MT.Bone, U9));
        OM.data(ST.make(MOD_WM, "cooked_goose", 1), new OreDictItemData(MT.MeatCooked, U * 3, MT.Bone, U9));
        OM.data(ST.make(MOD_WM, "cooked_mouse", 1), new OreDictItemData(MT.MeatCooked, U * 1, MT.Bone, U9));
        OM.data(ST.make(MOD_WM, "cooked_venison", 1), new OreDictItemData(MT.MeatCooked, U * 3, MT.Bone, U9));

        OM.data(ST.make(MOD_WM, "bison_meat", 1), new OreDictItemData(MT.MeatRaw, U * 3, MT.Bone, U4));
        OM.data(ST.make(MOD_WM, "calamari", 1), new OreDictItemData(MT.FishRaw, U * 2));
        OM.data(ST.make(MOD_WM, "chevon", 1), new OreDictItemData(MT.MeatRaw, U * 3, MT.Bone, U9));
        OM.data(ST.make(MOD_WM, "goose", 1), new OreDictItemData(MT.MeatRaw, U * 3, MT.Bone, U9));
        OM.data(ST.make(MOD_WM, "mouse", 1), new OreDictItemData(MT.MeatRaw, U2, MT.Bone, U9));
        OM.data(ST.make(MOD_WM, "venison", 1), new OreDictItemData(MT.MeatRaw, U * 3, MT.Bone, U9));
        /************************************************************************************************************************/
    }

    @Override
    public void onModInit2(FMLInitializationEvent aEvent) {
        OUT.println("BioTech_Mod: Init");
    }

    @Override
    public void onModPostInit2(FMLPostInitializationEvent aEvent) {
        OUT.println("BioTech_Mod: PostInit");
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

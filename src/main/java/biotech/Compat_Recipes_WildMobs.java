package biotech;

import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import gregapi.api.Abstract_Mod;
import gregapi.code.ModData;
import gregapi.compat.CompatMods;
import gregapi.data.CS;
import gregapi.data.FL;
import gregapi.data.MT;
import gregapi.data.RM;
import gregapi.oredict.event.OreDictListenerEvent_Names;
import gregapi.util.OM;
import gregapi.util.ST;
import net.minecraft.init.Items;

import static gregapi.data.CS.*;

public class Compat_Recipes_WildMobs extends CompatMods {
    public final String mID;

    public Compat_Recipes_WildMobs(ModData aMod, Abstract_Mod aGTMod) {
        super(aMod, aGTMod);
        mID = aMod.mID;
    }

    @Override
    public void onPostLoad(FMLPostInitializationEvent aEvent) {
        OUT.println("BioTech_Mod: Doing WildMobs Recipes.");
        new OreDictListenerEvent_Names() {
            @Override
            public void addAllListeners() {
//                addListener("gemCertusQuartz", new IOreDictListenerEvent() {
//                    @Override
//                    public void onOreRegistration(OreDictRegistrationContainer aEvent) {
//                        RM.ae_grinder(10, aEvent.mStack, OP.dust.mat(MT.CertusQuartz, 1));
//                    }
//                });
            }
        };

        CS.FoodsGT.put(ST.make(mMod, "venison", 1), 0, 0, 0, 0, 12);
        CS.FoodsGT.put(ST.make(mMod, "cooked_venison", 1), 0, 0, 0, 10, 12);
        CS.FoodsGT.put(ST.make(mMod, "calamari", 1), 0, 0, 0, 0, 12);
        CS.FoodsGT.put(ST.make(mMod, "cooked_calamari", 1), 0, 0, 0, 10, 12);
        CS.FoodsGT.put(ST.make(mMod, "bison_meat", 1), 0, 0, 0, 0, 12);
        CS.FoodsGT.put(ST.make(mMod, "cooked_bison_meat", 1), 0, 0, 0, 10, 12);
        CS.FoodsGT.put(ST.make(mMod, "chevon", 1), 0, 0, 0, 0, 12);
        CS.FoodsGT.put(ST.make(mMod, "cooked_chevon", 1), 0, 0, 0, 10, 12);
        CS.FoodsGT.put(ST.make(mMod, "goose", 1), 0, 0, 0, 0, 12);
        CS.FoodsGT.put(ST.make(mMod, "cooked_goose", 1), 0, 0, 0, 10, 12);
        CS.FoodsGT.put(ST.make(mMod, "mouse", 1), 0, 0, 0, 0, 12);
        CS.FoodsGT.put(ST.make(mMod, "cooked_mouse", 1), 0, 0, 0, 10, 12);

        OM.reg(ST.make(mMod, "venison", 1), "foodVensionraw");
        OM.reg(ST.make(mMod, "venison", 1), "listAllvensionraw");
        OM.reg(ST.make(mMod, "cooked_venison", 1), "foodVensioncooked");
        OM.reg(ST.make(mMod, "cooked_venison", 1), "listAllvensioncooked");

        OM.reg(ST.make(mMod, "calamari", 1), "foodCalamariraw");
        OM.reg(ST.make(mMod, "calamari", 1), "listAllcalamariraw");
        OM.reg(ST.make(mMod, "cooked_calamari", 1), "foodCalamaricooked");
        OM.reg(ST.make(mMod, "cooked_calamari", 1), "listAllcalamaricooked");

        OM.reg(ST.make(mMod, "bison_meat", 1), "listAllbeef");
        OM.reg(ST.make(mMod, "cooked_bison_meat", 1), "listAllcookedbeef"); // TODO: check this
        OM.reg(ST.make(mMod, "bison_meat", 1), "listAllbison");
        OM.reg(ST.make(mMod, "cooked_bison_meat", 1), "listAllcookedbison");

        OM.reg(ST.make(mMod, "bison_meat", 1), "listAllmeatraw");
        OM.reg(ST.make(mMod, "calamari", 1), "listAllmeatraw");
        OM.reg(ST.make(mMod, "chevon", 1), "listAllmeatraw");
        OM.reg(ST.make(mMod, "goose", 1), "listAllmeatraw");
        OM.reg(ST.make(mMod, "mouse", 1), "listAllmeatraw");
        OM.reg(ST.make(mMod, "venison", 1), "listAllmeatraw");

        OM.reg(ST.make(mMod, "cooked_bison_meat", 1), "listAllmeatcooked");
        OM.reg(ST.make(mMod, "cooked_calamari", 1), "listAllmeatcooked");
        OM.reg(ST.make(mMod, "cooked_chevon", 1), "listAllmeatcooked");
        OM.reg(ST.make(mMod, "cooked_goose", 1), "listAllmeatcooked");
        OM.reg(ST.make(mMod, "cooked_mouse", 1), "listAllmeatcooked");
        OM.reg(ST.make(mMod, "cooked_venison", 1), "listAllmeatcooked");

        RM.Mixer.addRecipe1(T, 16, 16, ST.make(mMod, "fur", 1), FL.Water.make(1000), NF, ST.make(Items.leather, 1, W));
        RM.Mixer.addRecipe1(T, 16, 16, ST.make(mMod, "bison_leather", 1), FL.Water.make(1000), NF, ST.make(Items.leather, 1, W));

        RM.Shredder.addRecipe1(T, 16, 16, ST.make(mMod, "armadillo_shell", 1), OM.dust(MT.Ca, U / 9));
        RM.Shredder.addRecipe1(T, 16, 16, ST.make(mMod, "thick_bone", 1), OM.dust(MT.Bone, U * 10));


    }
}

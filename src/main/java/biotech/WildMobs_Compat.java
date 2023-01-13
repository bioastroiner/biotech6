package biotech;

import gregapi.data.*;
import gregapi.oredict.OreDictItemData;
import gregapi.util.OM;
import gregapi.util.ST;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import javax.annotation.Nullable;
import java.util.List;

import static biotech.BioTech6Mod.MOD_WM;
import static biotech.BioTech6Mod.out;
import static gregapi.data.CS.*;

public class WildMobs_Compat {
    public static void init() {
        if (!MOD_WM.mLoaded) return;
        out("WildMobs Compat with GT6");
        handleItemsData();
    }

    private static void handleItemsData() {
        /* GT data */
        out("Item Data for WildMobs");
        OM.data(ST.make(MOD_WM, "bison_leather", 1), new OreDictItemData(MT.Leather, U));
        OM.data(ST.make(MOD_WM, "fur", 1), new OreDictItemData(MT.Leather, U));
        OM.data(ST.make(MOD_WM, "armadillo_shell", 1), new OreDictItemData(MT.Bone, U * 5));
        OM.data(ST.make(MOD_WM, "thick_bone", 1), new OreDictItemData(MT.Bone, U * 10));
        OM.data(ST.make(MOD_WM, "venison", 1), new OreDictItemData(MT.MeatRaw, U * 3, MT.Bone, U2));
        OM.data(ST.make(MOD_WM, "infected_flesh", 1), new OreDictItemData(MT.MeatRotten, U * 2, MT.Bone, U9));
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

        /* Ore Dicts */
        OM.reg(ST.make(MOD_WM, "venison", 1), "foodVenisonraw");
        OM.reg(ST.make(MOD_WM, "venison", 1), "listAllvenisonraw");
        OM.reg(ST.make(MOD_WM, "chevon", 1), "listAllmuttonraw");
        OM.reg(ST.make(MOD_WM, "cooked_venison", 1), "foodVenisoncooked");
        OM.reg(ST.make(MOD_WM, "cooked_venison", 1), "listAllvenisoncooked");
        OM.reg(ST.make(MOD_WM, "cooked_chevon", 1), "listAllmuttoncooked");

        OM.reg(ST.make(MOD_WM, "calamari", 1), "foodCalamariraw");
        OM.reg(ST.make(MOD_WM, "calamari", 1), "listAllcalamariraw");
        OM.reg(ST.make(MOD_WM, "cooked_calamari", 1), "foodCalamaricooked");
        OM.reg(ST.make(MOD_WM, "cooked_calamari", 1), "listAllcalamaricooked");

        OM.reg(ST.make(MOD_WM, "bison_meat", 1), "listAllbeef");
        OM.reg(ST.make(MOD_WM, "cooked_bison_meat", 1), "listAllcookedbeef");
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

        /* Recipes */
        RM.Mixer.addRecipe1(T, 16, 16, ST.make(MOD_WM, "fur", 1), FL.Water.make(1000), NF, ST.make(Items.leather, 1, W));
        RM.Mixer.addRecipe1(T, 16, 16, ST.make(MOD_WM, "bison_leather", 1), FL.Water.make(1000), NF, ST.make(Items.leather, 1, W));
        RM.Mixer.addRecipe1(T, 16, 16, ST.make(MOD_WM, "fur", 1), FL.Water.make(1000), NF, ST.make(Items.leather, 1, W));
        RM.Generifier.addRecipe1(T, 16, 16, ST.make(MOD_WM, "infected_flesh", 1), NF, NF, ST.make(Items.rotten_flesh, 1, W));
    }

    public static void handleDrops(EntityLivingBase aDead, String aClass, List<EntityItem> aDrops, int aLooting, boolean aBurn, boolean aPlayerKill) {
        if (!MOD_WM.mLoaded) return;
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
}

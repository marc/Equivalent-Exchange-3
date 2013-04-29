// Originally built to work with Tekkit Lite 0.6.1 (the item ids are based on it).
// Note: If you are using this addon to build a custom ee3-universal-pre1f.jar, you need to replace the ee3-universal-pre1f.jar file in the server's mods directory for the recipes to work.
//          If you do not update the client's ee3-universal-pre1f.jar, the recipes still work, but the 4 ion thrusters will not be visible in the crafting bench output.
//          When you click the crafting bench output, you will pick up 4 ion thrusters and the 2 empty electric jetpacks will be consumed.
//
// TO DO: Dynamically look up the ids for empty electric jetpacks (from IC2) and ion thrusters (from modular powersuits).
package com.pahimar.ee3.core.addons;

import java.util.logging.Level;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

import com.pahimar.ee3.core.helper.LogHelper;
import com.pahimar.ee3.core.helper.RecipeHelper;
import com.pahimar.ee3.recipe.RecipesTransmutationStone;

import cpw.mods.fml.common.Loader;

public class AddonPowerSuits {

    public static void initWorld() {

        if (Loader.isModLoaded("mmmPowersuits")) {
            try {

                for (ItemStack stone : RecipesTransmutationStone.transmutationStones) {
			// 2 empty electric jetpacks (30209:26) (with a minium stone) into 4 ion thrusters (25031:4)
			// (Effectively turns two electric jetpacks into one modular powersuit jetpack since it takes 4 ion thrusters to add the jetpack to the powersuit torso. )
			// The game shows empty electric jetpacks in the inventory as 30209:26, but NEI shows a 30209:27 empty jetpack... adding both options as recipes, as well as one of each.
			RecipeHelper.addRecipe(new ItemStack(25031, 4, 4), stone, new ItemStack(30209, 1, 26), new ItemStack(30209, 1, 26));
			RecipeHelper.addRecipe(new ItemStack(25031, 4, 4), stone, new ItemStack(30209, 1, 27), new ItemStack(30209, 1, 27));
			RecipeHelper.addRecipe(new ItemStack(25031, 4, 4), stone, new ItemStack(30209, 1, 26), new ItemStack(30209, 1, 27));
                }

                LogHelper.log(Level.INFO, "Loaded mmmPowersuits addon");
            }
            catch (Exception e) {
                LogHelper.log(Level.SEVERE, "Could not load mmmPowersuits addon");
                e.printStackTrace(System.err);
            }
        }
    }

}

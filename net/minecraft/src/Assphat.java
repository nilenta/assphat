package net.minecraft.src;

import java.util.Random;


public class Assphat {
    private static Random random;
    
    static {
        random = new Random();
    }
    
    public Assphat() {
        
    }
    
    public static void addRecipes(CraftingManager var1) { 
    	/*
    	   * add new recipes :3
    	   * 
    	   * no shit for armor types and weapons, still have to go to stuff like RecipesWeapons.java and shit. 
    	   * Womp womp!
    	*/
    	//var1.addRecipe(new ItemStack(Item.fiberglassDust, 4), "#", '#', Block.fiberglass);
        var1.addRecipe(new ItemStack(Block.fiberglass, 1), "##", "##", '#', Item.fiberglassDust);
    }
}

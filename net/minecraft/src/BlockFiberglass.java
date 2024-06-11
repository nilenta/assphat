package net.minecraft.src;

import java.util.Random;

public class BlockFiberglass extends Block {
	EntityPlayer last_person;
    public BlockFiberglass(int var1, int var2) {
        super(var1, var2, Material.ground);
    }

    public int idDropped(int var1, Random var2) {
        return Item.fiberglassDust.shiftedIndex;
    }

    public int quantityDropped(Random var1) {
        return Helper.r_int(1, 4);
    	//return 64;
    }
    
    public void onEntityCollidedWithBlock(World var1, int var2, int var3, int var4, Entity var5) {
        var5.motionX *= 0.1D;
        var5.motionZ *= 0.1D;
    }
    
    
    /*public void randomDisplayTick(World var1, int var2, int var3, int var4, Random var5) {
    	if (var5.nextInt(32) == 0) {
    		//helper.log("ok  ", "x ", var2, "y ", var3, "z ", var4);
    		EntityPlayer personFound = var1.getClosestPlayer((double)(var2), (double)(var3), (double)(var4), 6.0D);
    		if (personFound != null) {
    			if (personFound != last_person && last_person != null) {
    				last_person.radiated = false;
    			}
    			last_person = personFound;
    			personFound.radiation += 5;
    			helper.log("radiation: ", personFound.radiation);
    			personFound.radiated = true;
    			
    		} else {
    			if (last_person != null) {
    				last_person.radiated = false;
    			}
    			
    		}
    	}
    }*/
}

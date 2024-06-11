package net.minecraft.src;

import java.util.Random;

public class BlockDryingTable extends Block {
    protected BlockDryingTable(int var1) {
        super(var1, Material.wood);
        this.blockIndexInTexture = 125;
        float var11 = 0.1875F;
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.75F, 1.0F);
    }
    
    public boolean isOpaqueCube() {
        return false;
    }

    public boolean renderAsNormalBlock() {
        return false;
    }

    public int getRenderType() {
        return 0;
    }
    
    public int getBlockTextureFromSide(int var1) {
        if (var1 == 1) {
            return this.blockIndexInTexture + 2;
        } else if (var1 == 0) {
            return this.blockIndexInTexture + 1;
        } else {
            return this.blockIndexInTexture;
        }
    }

    public boolean canPlaceBlockAt(World var1, int var2, int var3, int var4) {
        return true;
    }
    
    public boolean blockActivated(World var1, int var2, int var3, int var4, EntityPlayer var5) {
    	Helper.mc.displayGuiScreen(new GuiDryingTable(var5.inventory, var1, var2, var3, var4));
        return true;
    }
}

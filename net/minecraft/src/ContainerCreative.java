package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;

public class ContainerCreative extends Container {
    public List field_35375_a = new ArrayList();

    public ContainerCreative(EntityPlayer var1) {
        Block[] var2 = new Block[]{Block.cobblestone, Block.stone, Block.oreDiamond, Block.oreGold, Block.oreIron, Block.oreCoal, Block.oreLapis, Block.oreRedstone, Block.blockClay, Block.blockDiamond, Block.blockGold, Block.blockSteel, Block.bedrock, Block.blockLapis, Block.brick, Block.cobblestoneMossy, Block.stairSingle, Block.stairSingle, Block.stairSingle, Block.stairSingle, Block.stairSingle, Block.stairSingle, Block.obsidian, Block.netherrack, Block.slowSand, Block.glowStone, Block.wood, Block.wood, Block.wood, Block.leaves, Block.dirt, Block.grass, Block.sand, Block.sandStone, Block.gravel, Block.web, Block.planks, Block.sapling, Block.sapling, Block.sapling, Block.deadBush, Block.sponge, Block.ice, Block.blockSnow, Block.plantYellow, Block.plantRed, Block.mushroomBrown, Block.mushroomRed, Block.reed, Block.cactus, Block.pumpkin, Block.pumpkinLantern, Block.chest, Block.workbench, Block.glass, Block.tnt, Block.bookShelf, Block.cloth, Block.cloth, Block.cloth, Block.cloth, Block.cloth, Block.cloth, Block.cloth, Block.cloth, Block.cloth, Block.cloth, Block.cloth, Block.cloth, Block.cloth, Block.cloth, Block.cloth, Block.cloth, Block.dispenser, Block.stoneOvenIdle, Block.jukebox, Block.pistonStickyBase, Block.pistonBase, Block.fence, Block.ladder, Block.rail, Block.railPowered, Block.railDetector, Block.torchWood, Block.stairCompactPlanks, Block.stairCompactCobblestone, Block.lever, Block.pressurePlateStone, Block.pressurePlatePlanks, Block.torchRedstoneActive, Block.button, Block.cake, Block.trapdoor};
        int var3 = 0;
        int var4 = 0;
        int var5 = 0;
        int var6 = 0;
        int var7 = 0;

        int var8;
        int var9;
        for(var8 = 0; var8 < var2.length; ++var8) {
            var9 = 0;
            if(var2[var8] == Block.cloth) {
                var9 = var3++;
            } else if(var2[var8] == Block.stairSingle) {
                var9 = var4++;
            } else if(var2[var8] == Block.wood) {
                var9 = var5++;
            } else if(var2[var8] == Block.sapling) {
                var9 = var6++;
            }

            this.field_35375_a.add(new ItemStack(var2[var8], 1, var9));
        }

        for(var8 = 256; var8 < Item.itemsList.length; ++var8) {
            if(Item.itemsList[var8] != null) {
                this.field_35375_a.add(new ItemStack(Item.itemsList[var8]));
            }
        }

        for(var8 = 1; var8 < 16; ++var8) {
            this.field_35375_a.add(new ItemStack(Item.dyePowder.shiftedIndex, 1, var8));
        }

        InventoryPlayer var11 = var1.inventory;

        for(var9 = 0; var9 < 9; ++var9) {
            for(int var10 = 0; var10 < 8; ++var10) {
                this.addSlot(new Slot(GuiContainerCreative.func_35310_g(), var10 + var9 * 8, 8 + var10 * 18, 18 + var9 * 18));
            }
        }

        for(var9 = 0; var9 < 9; ++var9) {
            this.addSlot(new Slot(var11, var9, 8 + var9 * 18, 184));
        }

        this.func_35374_a(0.0F);
    }

    public boolean canInteractWith(EntityPlayer var1) {
        return true;
    }

    public void func_35374_a(float var1) {
        int var2 = this.field_35375_a.size() / 8 - 8 + 1;
        int var3 = (int)((double)(var1 * (float)var2) + 0.5D);
        if(var3 < 0) {
            var3 = 0;
        }

        for(int var4 = 0; var4 < 9; ++var4) {
            for(int var5 = 0; var5 < 8; ++var5) {
                int var6 = var5 + (var4 + var3) * 8;
                if(var6 >= 0 && var6 < this.field_35375_a.size()) {
                    GuiContainerCreative.func_35310_g().setInventorySlotContents(var5 + var4 * 8, (ItemStack)this.field_35375_a.get(var6));
                } else {
                    GuiContainerCreative.func_35310_g().setInventorySlotContents(var5 + var4 * 8, (ItemStack)null);
                }
            }
        }

    }

    protected void func_35373_b(int var1, int var2, boolean var3, EntityPlayer var4) {
    }


    public boolean isUsableByPlayer(EntityPlayer var1) {
        return false;
    }
}

package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;

class ContainerCreative extends Container {
    public List field_35375_a = new ArrayList();
    public Block[] allItems = new Block[]{Block.stone, Block.cobblestone, Block.brick, Block.dirt, Block.planks, Block.wood, Block.wood, Block.wood, Block.leaves, Block.torchWood, Block.fence, Block.glass, Block.grass, Block.sand, Block.sandStone, Block.gravel, Block.sponge, Block.ice, Block.snow, Block.blockSnow, Block.stairSingle, Block.stairSingle, Block.stairSingle, Block.stairSingle, Block.chest, Block.workbench, Block.stoneOvenIdle, Block.tnt, Block.musicBlock, Block.jukebox, Block.trapdoor, Block.ladder, Block.blockDiamond, Block.blockGold, Block.blockSteel, Block.blockLapis, Block.bedrock, Block.sapling, Block.sapling, Block.sapling, Block.deadBush, Block.mushroomBrown, Block.mushroomRed, Block.plantRed, Block.plantYellow, Block.web, Block.reed, Block.bookShelf, Block.blockClay, Block.cactus, Block.obsidian, Block.netherrack, Block.glowStone, Block.slowSand, Block.pumpkin, Block.pumpkinLantern, Block.cobblestoneMossy, Block.pistonBase, Block.pistonStickyBase, Block.dispenser, Block.lever, Block.torchRedstoneActive, Block.button, Block.oreCoal, Block.oreIron, Block.oreDiamond, Block.oreGold, Block.oreLapis, Block.oreRedstone, Block.stairCompactPlanks, Block.stairCompactCobblestone, Block.cloth, Block.cloth, Block.cloth, Block.cloth, Block.cloth, Block.cloth, Block.cloth, Block.cloth, Block.cloth, Block.cloth, Block.cloth, Block.cloth, Block.cloth, Block.cloth, Block.cloth, Block.cloth, Block.rail, Block.railDetector, Block.railPowered, Block.fire, Block.mobSpawner};
    public Item[] foodStuffs = new Item[]{Item.porkRaw, Item.porkCooked, Item.appleRed, Item.appleGold, Item.fishCooked, Item.fishRaw};
    public Block[] buildingBlocks = new Block[]{Block.cobblestone, Block.stone, Block.wood, Block.wood, Block.wood, Block.planks, Block.bookShelf, Block.blockClay, Block.reed, Block.brick, Block.torchWood, Block.fence, Block.dirt, Block.sand, Block.gravel, Block.sandStone, Block.sponge, Block.ice, Block.snow, Block.blockSnow, Block.stairSingle, Block.stairSingle, Block.stairCompactCobblestone, Block.stairCompactPlanks, Block.plantRed, Block.plantYellow, Block.web};
    public Block[] functional = new Block[]{Block.chest, Block.stoneOvenIdle, Block.workbench, Block.musicBlock, Block.jukebox, Block.dispenser, Block.button, Block.pressurePlatePlanks, Block.pressurePlateStone, Block.lever};
    public Block[] blocksToAdd = new Block[0];

    public ContainerCreative(EntityPlayer var1, String var2) {
        Block[] var3 = new Block[0];
        Item[] var4 = new Item[0];
        if(var2 == "allitems") {
            this.blocksToAdd = this.allItems;
        } else if(var2 == "foodstuffs") {
            var4 = this.foodStuffs;
        } else if(var2 == "building") {
            this.blocksToAdd = this.buildingBlocks;
        } else if(var2 == "functional") {
            this.blocksToAdd = this.functional;
        }

        int var5 = 0;
        int var6 = 0;
        int var7 = 0;
        int var8 = 0;
        boolean var9 = false;
        int var10 = 1;

        int var11;
        int var12;
        for(var11 = 0; var11 < this.blocksToAdd.length; ++var11) {
            var12 = 0;
            if(this.blocksToAdd[var11] == Block.cloth) {
                var12 = var5++;
            } else if(this.blocksToAdd[var11] == Block.stairSingle) {
                var12 = var6++;
            } else if(this.blocksToAdd[var11] == Block.wood) {
                var12 = var7++;
            } else if(this.blocksToAdd[var11] == Block.sapling) {
                var12 = var8++;
            } else if(this.blocksToAdd[var11] == Block.tallGrass) {
                var12 = var10++;
            }

            this.field_35375_a.add(new ItemStack(this.blocksToAdd[var11], 1, var12));
        }

        if(var2 == "foodstuffs") {
            for(var11 = 256; var11 < Item.itemsList.length; ++var11) {
                if(Item.itemsList[var11] != null && Item.itemsList[var11] instanceof ItemFood) {
                    this.field_35375_a.add(new ItemStack(Item.itemsList[var11]));
                }
            }
        } else if(var2 == "allitems") {
            for(var11 = 256; var11 < Item.itemsList.length; ++var11) {
                if(Item.itemsList[var11] != null) {
                    this.field_35375_a.add(new ItemStack(Item.itemsList[var11]));
                }
            }

            for(var11 = 1; var11 < 16; ++var11) {
                this.field_35375_a.add(new ItemStack(Item.dyePowder.shiftedIndex, 1, var11));
            }
        } else if(var2 == "tools") {
            for(var11 = 256; var11 < Item.itemsList.length; ++var11) {
                if(Item.itemsList[var11] != null && Item.itemsList[var11] instanceof ItemTool || Item.itemsList[var11] instanceof ItemSword || Item.itemsList[var11] instanceof ItemFishingRod) {
                    this.field_35375_a.add(new ItemStack(Item.itemsList[var11]));
                }
            }
        } else if(var2 == "combat") {
            for(var11 = 256; var11 < Item.itemsList.length; ++var11) {
                if(Item.itemsList[var11] != null && Item.itemsList[var11] instanceof ItemArmor || Item.itemsList[var11] instanceof ItemSword || Item.itemsList[var11] instanceof ItemFishingRod || Item.itemsList[var11] instanceof ItemBow || Item.itemsList[var11] == Item.arrow) {
                    this.field_35375_a.add(new ItemStack(Item.itemsList[var11]));
                }
            }
        } else if(var2 == "building") {
            for(var11 = 1; var11 < 16; ++var11) {
                this.field_35375_a.add(new ItemStack(Block.cloth, 1, var11));
            }

            this.field_35375_a.add(new ItemStack(Item.bucketWater, 1, var11));
            this.field_35375_a.add(new ItemStack(Item.bucketLava, 1, var11));

            for(var11 = 1; var11 < 16; ++var11) {
                this.field_35375_a.add(new ItemStack(Item.dyePowder.shiftedIndex, 1, var11));
            }
        } else if(var2 == "functional") {
            this.field_35375_a.add(new ItemStack(Item.redstone, 1, var11));
            this.field_35375_a.add(new ItemStack(Item.redstoneRepeater, 1, var11));
            this.field_35375_a.add(new ItemStack(Item.doorSteel, 1, var11));
            this.field_35375_a.add(new ItemStack(Item.doorWood, 1, var11));
        }

        InventoryPlayer var13 = var1.inventory;

        for(var12 = 0; var12 < 9; ++var12) {
            for(int var14 = 0; var14 < 8; ++var14) {
                this.addSlot(new Slot(GuiContainerCreative.func_35310_g(), var14 + var12 * 8, 8 + var14 * 18, 18 + var12 * 18));
            }
        }

        for(var12 = 0; var12 < 9; ++var12) {
            this.addSlot(new Slot(var13, var12, 8 + var12 * 18, 184));
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

    @Override
    public boolean isUsableByPlayer(EntityPlayer var1) {
        return true;
    }
}

package net.minecraft.src;

public class GuiTests_Items extends GuiScreen {
	protected GuiScreen parentGui;
    private StatFileWriter statFileWriter;
	
    public GuiTests_Items(GuiScreen var1, StatFileWriter var2) {
    	this.parentGui = var1;
        this.statFileWriter = var2;
    }

    public void initGui() {
    	byte var1 = -16;
    	this.controlList.add(new GuiButton(17000, this.width / 2 - 100, this.height / 4 + 0 + var1, 98, 20, "cocaine"));
    	this.controlList.add(new GuiButton(17001, this.width / 2 + 2, this.height / 4 + 0 + var1, 98, 20, "full gear & others"));
    	this.controlList.add(new GuiButton(17002, this.width / 2 - 100, this.height / 4 + 24 + var1, 98, 20, "single item"));
    	this.controlList.add(new GuiButton(17003, this.width / 2 + 2, this.height / 4 + 24 + var1, 98, 20, "building blocks"));
    	this.controlList.add(new GuiButton(17004, this.width / 2 - 100, this.height / 4 + 48 + var1, 98, 20, "armor tests"));
    	
        
        
    	this.controlList.add(new GuiButton(15000, this.width / 2 - 100, this.height / 6 + 168, "Done"));
    }
    
    protected void actionPerformed(GuiButton var1) {
        if (var1.enabled) {
            if (var1.id == 15000) {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen(this.parentGui);
            }
            if (var1.id == 17000) {
            	this.mc.thePlayer.addChatMessage("heres some stuff lol");
            	this.mc.thePlayer.entityDropItem(new ItemStack(Item.cocaine, 64), -1.0F);
            }
            if (var1.id == 17001) {
            	this.mc.thePlayer.addChatMessage("gave u full diamond shit");
            	this.mc.thePlayer.entityDropItem(new ItemStack(Item.swordDiamond, 1), -1.0F);
            	this.mc.thePlayer.entityDropItem(new ItemStack(Item.pickaxeDiamond, 1), -1.0F);
            	this.mc.thePlayer.entityDropItem(new ItemStack(Item.axeDiamond, 1), -1.0F);
            	this.mc.thePlayer.entityDropItem(new ItemStack(Item.shovelDiamond, 1), -1.0F);
            	this.mc.thePlayer.entityDropItem(new ItemStack(Item.helmetDiamond, 1), -1.0F);
            	this.mc.thePlayer.entityDropItem(new ItemStack(Item.bootsDiamond, 1), -1.0F);
            	this.mc.thePlayer.entityDropItem(new ItemStack(Item.legsDiamond, 1), -1.0F);
            	this.mc.thePlayer.entityDropItem(new ItemStack(Item.plateDiamond, 1), -1.0F);
            	/*this.mc.thePlayer.entityDropItem(new ItemStack(Item.cocaine, 64), -1.0F);
            	this.mc.thePlayer.entityDropItem(new ItemStack(Item.cocaleaf, 64), -1.0F);
            	this.mc.thePlayer.entityDropItem(new ItemStack(Block.fiberglass, 64), -1.0F)*/;
            	this.mc.thePlayer.entityDropItem(new ItemStack(Item.bed, 1), -1.0F);
            	this.mc.thePlayer.entityDropItem(new ItemStack(Block.stoneOvenIdle, 6), -1.0F);
            	this.mc.thePlayer.entityDropItem(new ItemStack(Block.workbench, 1), -1.0F);
            	this.mc.thePlayer.entityDropItem(new ItemStack(Block.chest, 64), -1.0F);
            	this.mc.thePlayer.entityDropItem(new ItemStack(Block.wood, 64), -1.0F);
            	this.mc.thePlayer.entityDropItem(new ItemStack(Block.wood, 64), -1.0F);
            	this.mc.thePlayer.entityDropItem(new ItemStack(Block.wood, 64), -1.0F);
            	this.mc.thePlayer.entityDropItem(new ItemStack(Block.wood, 64), -1.0F);
            }
            
            if (var1.id == 17002) {
            	this.mc.thePlayer.addChatMessage("gave u a single item");
				this.mc.thePlayer.entityDropItem(new ItemStack(Item.minecartEmpty, 1), -1.0F);


			}
            
            if (var1.id == 17003) {
            	this.mc.thePlayer.addChatMessage("here take building bliocks");
            	this.mc.thePlayer.entityDropItem(new ItemStack(Block.wood, 128), -1.0F);
            	this.mc.thePlayer.entityDropItem(new ItemStack(Block.cobblestone, 128), -1.0F);
            	this.mc.thePlayer.entityDropItem(new ItemStack(Block.glass, 128), -1.0F);
            	this.mc.thePlayer.entityDropItem(new ItemStack(Block.torchWood, 128), -1.0F);
            	this.mc.thePlayer.entityDropItem(new ItemStack(Item.coal, 128), -1.0F);
            }
            
            if (var1.id == 17004) {
            	this.mc.thePlayer.addChatMessage("armor");
            	/*this.mc.thePlayer.entityDropItem(new ItemStack(Block.tnt, 64), -1.0F);
            	this.mc.thePlayer.entityDropItem(new ItemStack(Block.fiberglass, 64), -1.0F);*/
            	this.mc.thePlayer.entityDropItem(new ItemStack(Item.helmetFiberGlass, 1), -1.0F);
            	this.mc.thePlayer.entityDropItem(new ItemStack(Item.plateFiberGlass, 1), -1.0F);
            	this.mc.thePlayer.entityDropItem(new ItemStack(Item.legsFiberGlass, 1), -1.0F);
            	this.mc.thePlayer.entityDropItem(new ItemStack(Item.bootsFiberGlass, 1), -1.0F);
            	
            }
        }
    }

    public void drawScreen(int var1, int var2, float var3) {
        /*
         * this is the red background thingy
        this.drawGradientRect(0, 0, this.width, this.height, -12574688, -11530224);
        this.drawCenteredString(this.fontRenderer, this.message1, this.width / 2, 90, 16777215);
        this.drawCenteredString(this.fontRenderer, this.message2, this.width / 2, 110, 16777215);
        super.drawScreen(var1, var2, var3);
        */
    	this.drawDefaultBackground();
    	this.drawCenteredString(this.fontRenderer, "item testing", this.width / 2, 20, 16777215);
        super.drawScreen(var1, var2, var3);
    }

    protected void keyTyped(char var1, int var2) {
    }
}

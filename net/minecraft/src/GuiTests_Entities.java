package net.minecraft.src;

public class GuiTests_Entities extends GuiScreen {
	protected GuiScreen parentGui;
    private StatFileWriter statFileWriter;
	
    public GuiTests_Entities(GuiScreen var1, StatFileWriter var2) {
    	this.parentGui = var1;
        this.statFileWriter = var2;
    }

    public void initGui() {
    	byte var1 = -16;
        this.controlList.add(new GuiButton(170, this.width / 2 - 100, this.height / 4 + 0 + var1, 98, 20, "entity test"));
        this.controlList.add(new GuiButton(171, this.width / 2 + 2, this.height / 4 + 0 + var1, 98, 20, "pig rain"));
        
        this.controlList.add(new GuiButton(172, this.width / 2 - 100, this.height / 4 + 24 + var1, 98, 20, "toggle creative"));
           
    	this.controlList.add(new GuiButton(15000, this.width / 2 - 100, this.height / 6 + 168, "Done"));
    }
    
    protected void actionPerformed(GuiButton var1) {
        if (var1.enabled) {
            if (var1.id == 15000) {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen(this.parentGui);
            }
            
            if (var1.id == 170) {
            	/*NBTTagCompound var16 = new NBTTagCompound();
            	var16.setString("Username", Helper.getRandomString(Helper.getRandomUsernames()));
            	
            	EntityLiving var9 = (EntityLiving)((EntityLiving)EntityList.createNPCInWorld(this.mc.theWorld, var16)); // helper.getRandomString(helper.getRandomUsernames())*/
            	
            	EntityLiving var9 = (EntityNPC)((EntityNPC)EntityList.createEntityInWorld("NPC", this.mc.theWorld));
            	//EntityLiving var9 = (EntityCow)((EntityCow)EntityList.createEntityInWorld("Cow", this.mc.theWorld));
            	
            	var9.setLocationAndAngles(this.mc.thePlayer.posX, this.mc.thePlayer.posY, this.mc.thePlayer.posZ, this.mc.theWorld.rand.nextFloat() * 360.0F, 0.0F);
            	
            	
            	//EntityLiving var9 = (EntityOtherPlayerMP)((EntityOtherPlayerMP)EntityList.createEntityInWorld("EntityOtherPlayerMP", this.mc.theWorld));
            	this.mc.theWorld.entityJoinedWorld(var9);
            	this.mc.thePlayer.addChatMessage("spawned an entity");
            }
            if (var1.id == 172) {
                if (this.mc.thePlayer.playerCapabilities.gameType == 0) {
                    this.mc.thePlayer.playerCapabilities.gameType = 1;
                    this.mc.thePlayer.addChatMessage("ur now creative");
                } else {
                    this.mc.thePlayer.playerCapabilities.gameType = 0;
                    this.mc.thePlayer.addChatMessage("ur now survival");
                }
            	
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
    	this.drawCenteredString(this.fontRenderer, "entity testing", this.width / 2, 20, 16777215);
        super.drawScreen(var1, var2, var3);
    }

    protected void keyTyped(char var1, int var2) {
    }
}

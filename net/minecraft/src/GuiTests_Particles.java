package net.minecraft.src;

public class GuiTests_Particles extends GuiScreen {
	protected GuiScreen parentGui;
    private StatFileWriter statFileWriter;
	
    public GuiTests_Particles(GuiScreen var1, StatFileWriter var2) {
    	this.parentGui = var1;
        this.statFileWriter = var2;
    }

    public void initGui() {
    	byte var1 = -16;
        this.controlList.add(new GuiButton(170, this.width / 2 - 100, this.height / 4 + 0 + var1, 98, 20, "smoke...."));
            
    	this.controlList.add(new GuiButton(15000, this.width / 2 - 100, this.height / 6 + 168, "Done"));
    }
    
    protected void actionPerformed(GuiButton var1) {
        if (var1.enabled) {
            if (var1.id == 15000) {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen(this.parentGui);
            }
            
            if (var1.id == 170) {
            	this.mc.theWorld.spawnParticle("lava", this.mc.thePlayer.posX, this.mc.thePlayer.posY, this.mc.thePlayer.posZ, 3.0D, 6.0D, 7.0D);
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
    	this.drawCenteredString(this.fontRenderer, "particle testing", this.width / 2, 20, 16777215);
        super.drawScreen(var1, var2, var3);
    }

    protected void keyTyped(char var1, int var2) {
    }
}

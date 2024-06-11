package net.minecraft.src;

public class GuiTests extends GuiScreen {
	protected GuiScreen parentGui;
    private StatFileWriter statFileWriter;
	
    public GuiTests(GuiScreen var1, StatFileWriter var2) {
    	this.parentGui = var1;
        this.statFileWriter = var2;
    }

    public void initGui() {
    	byte var1 = -16;
    	this.controlList.add(new GuiButton(2, this.width / 2 - 100, this.height / 4 + 0 + var1, 98, 20, "items & blocks"));
        this.controlList.add(new GuiButton(3, this.width / 2 + 2, this.height / 4 + 0 + var1, 98, 20, "entities"));
        
        this.controlList.add(new GuiButton(4, this.width / 2 - 100, this.height / 4 + 24 + var1, 98, 20, "particles"));
        this.controlList.add(new GuiButton(5, this.width / 2 +2, this.height / 4 + 24 + var1, 98, 20, "guis"));
        
        
    	this.controlList.add(new GuiButton(15000, this.width / 2 - 100, this.height / 6 + 168, "Done"));
    }
    
    protected void actionPerformed(GuiButton var1) {
        if (var1.enabled) {
            if (var1.id == 15000) {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen(this.parentGui);
            }
            if (var1.id == 2) {
            	this.mc.displayGuiScreen(new GuiTests_Items(this, this.statFileWriter));
            }
            
            if (var1.id == 3) {
            	this.mc.displayGuiScreen(new GuiTests_Entities(this, this.statFileWriter));
            }
            
            if (var1.id == 4) {
            	this.mc.displayGuiScreen(new GuiTests_Particles(this, this.statFileWriter));
            }
            
            if (var1.id == 5) {
            	this.mc.displayGuiScreen(new GuiTests_Guis(this, this.statFileWriter));
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
    	this.drawCenteredString(this.fontRenderer, "testing stuff", this.width / 2, 20, 16777215);
        super.drawScreen(var1, var2, var3);
    }

    protected void keyTyped(char var1, int var2) {
    }
}

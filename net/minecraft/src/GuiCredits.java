package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;


public class GuiCredits extends GuiScreen {
	protected GuiScreen parentGui;
	private float updateCounter = 0.0F;
	private List<String> lines = new ArrayList();
	
    public GuiCredits(GuiScreen var1, float updateCounter) {
    	this.parentGui = var1;
    	this.updateCounter = updateCounter;
    	
    	// add people
    	this.lines.add("\u00A7cMojang\u00A7r - For making Minecraft");
    	this.lines.add("\u00A7dnilenta\u00A7r - Mod Creator");
    	this.lines.add("\u00A79Stitch\u00A7r - Texture Creator");
    	
    	this.lines.add("");
    	this.lines.add("-------------------------------------");
    	this.lines.add("");
    	
    	this.lines.add("\u00A72Fursona\u00A7r - Ideas");
    	this.lines.add("\u00A74Fake Robin\u00A7r - Ideas");
    	
    	this.lines.add("");
    	this.lines.add("-------------------------------------");
    	this.lines.add("");
    	
    	this.lines.add("\u00A76Psychedelicraft (Mod)\u00A7r - Textures");
    	this.lines.add("\u00A7amicro\u00A7r - For being the faggot he is");
    	
    }
    
    public void updateScreen() {
        ++this.updateCounter;
    }

    public void initGui() {
    	byte var1 = -16;
		int var4 = this.height / 4 + 48;

		this.controlList.add(new GuiButton(15001, this.width / 2 - 100, var4 + 96, 98, 20, "Discord"));
    	this.controlList.add(new GuiButton(15000, this.width / 2 + 2, var4 + 96, 98, 20, "Exit"));
    }
    
    protected void actionPerformed(GuiButton var1) {
        if (var1.enabled) {
            if (var1.id == 15000) {
                this.mc.displayGuiScreen(this.parentGui);
            }
            if (var1.id == 15001) {
				Helper.openUrl("https://discord.gg/FteVKhk3Cg");
			}
        }
    }

    public void drawScreen(int var1, int var2, float var3) {
    	//this.drawDefaultBackground();
    	this.drawDefaultBackground2(this.updateCounter);
    	this.drawCenteredString(this.fontRenderer, "\u00A7b== Credits ==", this.width / 2, 20, 16777215);
    	
    	for(int var4 = 0; var4 < this.lines.size(); ++var4) {
			this.drawCenteredString(this.fontRenderer, (String)this.lines.get(var4), this.width / 2, 20 + ((var4 + 2) * 10), 16777215);
		}
        super.drawScreen(var1, var2, var3);
    }

    protected void keyTyped(char var1, int var2) {
    }
}

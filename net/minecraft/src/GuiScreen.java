package net.minecraft.src;

import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

public class GuiScreen extends Gui {
    protected Minecraft mc;
    public int width;
    public int height;
    protected List controlList = new ArrayList();
    public boolean allowUserInput = false;
    protected FontRenderer fontRenderer;
    public GuiParticle guiParticles;
    private static int panoramaFB;
	public static int panoramaCounter;
    private GuiButton selectedButton = null;

    public void drawScreen(int var1, int var2, float var3) {
        for(int var4 = 0; var4 < this.controlList.size(); ++var4) {
            GuiButton var5 = (GuiButton)this.controlList.get(var4);
            var5.drawButton(this.mc, var1, var2);
        }

    }

    protected void keyTyped(char var1, int var2) {
        if (var2 == 1) {
            this.mc.displayGuiScreen((GuiScreen)null);
            this.mc.setIngameFocus();
        }

    }

    public static String getClipboardString() {
        try {
            Transferable var0 = Toolkit.getDefaultToolkit().getSystemClipboard().getContents((Object)null);
            if (var0 != null && var0.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                String var1 = (String)var0.getTransferData(DataFlavor.stringFlavor);
                return var1;
            }
        } catch (Exception var2) {
        }

        return null;
    }

    protected void mouseClicked(int var1, int var2, int var3) {
        if (var3 == 0) {
            for(int var4 = 0; var4 < this.controlList.size(); ++var4) {
                GuiButton var5 = (GuiButton)this.controlList.get(var4);
                if (var5.mousePressed(this.mc, var1, var2)) {
                    this.selectedButton = var5;
                    this.mc.sndManager.playSoundFX("random.click", 1.0F, 1.0F);
                    this.actionPerformed(var5);
                }
            }
        }

    }

    protected void mouseMovedOrUp(int var1, int var2, int var3) {
        if (this.selectedButton != null && var3 == 0) {
            this.selectedButton.mouseReleased(var1, var2);
            this.selectedButton = null;
        }

    }

    protected void actionPerformed(GuiButton var1) {
    }

    public void setWorldAndResolution(Minecraft var1, int var2, int var3) {
        this.guiParticles = new GuiParticle(var1);
        this.mc = var1;
        this.fontRenderer = var1.fontRenderer;
        this.width = var2;
        this.height = var3;
        this.controlList.clear();
        this.initGui();
    }

    public void initGui() {
    }

    public void handleInput() {
        while(Mouse.next()) {
            this.handleMouseInput();
        }

        while(Keyboard.next()) {
            this.handleKeyboardInput();
        }

    }

    public void handleMouseInput() {
        int var1;
        int var2;
        if (Mouse.getEventButtonState()) {
            var1 = Mouse.getEventX() * this.width / this.mc.displayWidth;
            var2 = this.height - Mouse.getEventY() * this.height / this.mc.displayHeight - 1;
            this.mouseClicked(var1, var2, Mouse.getEventButton());
        } else {
            var1 = Mouse.getEventX() * this.width / this.mc.displayWidth;
            var2 = this.height - Mouse.getEventY() * this.height / this.mc.displayHeight - 1;
            this.mouseMovedOrUp(var1, var2, Mouse.getEventButton());
        }

    }

    public void handleKeyboardInput() {
        if (Keyboard.getEventKeyState()) {
            if (Keyboard.getEventKey() == 87) {
                this.mc.toggleFullscreen();
                return;
            }

            this.keyTyped(Keyboard.getEventCharacter(), Keyboard.getEventKey());
        }

    }

    public void updateScreen() {
    }

    public void onGuiClosed() {
    }
    
    public void drawDefaultBackground() {
        this.drawWorldBackground(0);
    }

    public void drawWorldBackground(int var1) {
        if (this.mc.theWorld != null) {
            this.drawGradientRect(0, 0, this.width, this.height, -1072689136, -804253680);
        } else {
            this.drawBackground(var1);
        }

    }

    public void drawBackground(int var1) {
        GL11.glDisable(2896 /*GL_LIGHTING*/);
        GL11.glDisable(2912 /*GL_FOG*/);
        Tessellator var2 = Tessellator.instance;
        GL11.glBindTexture(3553 /*GL_TEXTURE_2D*/, this.mc.renderEngine.getTexture("/gui/background.png"));
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        float var3 = 32.0F;
        var2.startDrawingQuads();
        var2.setColorOpaque_I(4210752);
        var2.addVertexWithUV(0.0D, (double)this.height, 0.0D, 0.0D, (double)((float)this.height / var3 + (float)var1));
        var2.addVertexWithUV((double)this.width, (double)this.height, 0.0D, (double)((float)this.width / var3), (double)((float)this.height / var3 + (float)var1));
        var2.addVertexWithUV((double)this.width, 0.0D, 0.0D, (double)((float)this.width / var3), (double)(0 + var1));
        var2.addVertexWithUV(0.0D, 0.0D, 0.0D, 0.0D, (double)(0 + var1));
        var2.draw();
    }
    
    // the new shit

    public void drawDefaultBackground2(float var1) {
		this.drawWorldBackground2(0, var1);
	}

	public void drawWorldBackground2(int var1, float var2) {
		if(this.mc.theWorld != null) {
			this.drawGradientRect(0, 0, this.width, this.height, -1072689136, -804253680);
		} else {
			this.drawBackground3(var1, var2);
		}
	}
	
	public void drawBackground3(int var1, float var2) {
		this.drawBackground4(var1, 16777215, var2);
	}
	

    public boolean doesGuiPauseGame() {
        return true;
    }

    public void deleteWorld(boolean var1, int var2) {
    }

    public void selectNextField() {
    }
    
    private void func_35355_b(float var1) {
		Tessellator var2 = Tessellator.instance;
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glPushMatrix();
		GL11.glLoadIdentity();
		GLU.gluPerspective(120.0F, 1.0F, 0.05F, 10.0F);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glPushMatrix();
		GL11.glLoadIdentity();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glDisable(GL11.GL_ALPHA_TEST);
		GL11.glDisable(GL11.GL_CULL_FACE);
		GL11.glDepthMask(false);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		byte var3 = 8;

		for(int var4 = 0; var4 < var3 * var3; ++var4) {
			GL11.glPushMatrix();
			float var5 = ((float)(var4 % var3) / (float)var3 - 0.5F) / 64.0F;
			float var6 = ((float)(var4 / var3) / (float)var3 - 0.5F) / 64.0F;
			float var7 = 0.0F;
			GL11.glTranslatef(var5, var6, var7);
			GL11.glRotatef(-MathHelper.sin(((float)panoramaCounter + var1) / 400.0F) * 25.0F + 20.0F, 1.0F, 0.0F, 0.0F);
			GL11.glRotatef(-((float)panoramaCounter + var1) * 0.1F, 0.0F, 1.0F, 0.0F);

			for(int var8 = 0; var8 < 6; ++var8) {
				GL11.glPushMatrix();
				if(var8 == 1) {
					GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
				}

				if(var8 == 2) {
					GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
				}

				if(var8 == 3) {
					GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
				}

				if(var8 == 4) {
					GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
				}

				if(var8 == 5) {
					GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
				}

				GL11.glBindTexture(GL11.GL_TEXTURE_2D, this.mc.renderEngine.getTexture("/title/bg/panorama" + var8 + ".png"));
				var2.startDrawingQuads();
				var2.setColorRGBA(255, 255, 255, 255 / (var4 + 1));
				float var9 = 0.0F;
				var2.addVertexWithUV(-1.0D, -1.0D, 1.0D, (double)(0.0F + var9), (double)(0.0F + var9));
				var2.addVertexWithUV(1.0D, -1.0D, 1.0D, (double)(1.0F - var9), (double)(0.0F + var9));
				var2.addVertexWithUV(1.0D, 1.0D, 1.0D, (double)(1.0F - var9), (double)(1.0F - var9));
				var2.addVertexWithUV(-1.0D, 1.0D, 1.0D, (double)(0.0F + var9), (double)(1.0F - var9));
				var2.draw();
				GL11.glPopMatrix();
			}

			GL11.glPopMatrix();
			GL11.glColorMask(true, true, true, false);
		}

		var2.setTranslationD(0.0D, 0.0D, 0.0D);
		GL11.glColorMask(true, true, true, true);
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glPopMatrix();
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glPopMatrix();
		GL11.glDepthMask(true);
		GL11.glEnable(GL11.GL_CULL_FACE);
		GL11.glEnable(GL11.GL_ALPHA_TEST);
		GL11.glEnable(GL11.GL_DEPTH_TEST);
	}

	private void func_35354_a(float var1) {
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, panoramaFB);
		GL11.glCopyTexSubImage2D(GL11.GL_TEXTURE_2D, 0, 0, 0, 0, 0, 256, 256);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glColorMask(true, true, true, false);
		Tessellator var2 = Tessellator.instance;
		var2.startDrawingQuads();
		byte var3 = 3;

		for(int var4 = 0; var4 < var3; ++var4) {
			var2.setColorRGBA_F(1.0F, 1.0F, 1.0F, 1.0F / (float)(var4 + 1));
			int var5 = this.width;
			int var6 = this.height;
			float var7 = (float)(var4 - var3 / 2) / 256.0F;
			var2.addVertexWithUV((double)var5, (double)var6, (double)this.zLevel, (double)(0.0F + var7), 0.0D);
			var2.addVertexWithUV((double)var5, 0.0D, (double)this.zLevel, (double)(1.0F + var7), 0.0D);
			var2.addVertexWithUV(0.0D, 0.0D, (double)this.zLevel, (double)(1.0F + var7), 1.0D);
			var2.addVertexWithUV(0.0D, (double)var6, (double)this.zLevel, (double)(0.0F + var7), 1.0D);
		}

		var2.draw();
		GL11.glColorMask(true, true, true, true);
	}

	private void func_35356_c(float var1) {
		GL11.glViewport(0, 0, 256, 256);
		this.func_35355_b(var1);
		this.func_35354_a(var1);
		this.func_35354_a(var1);
		this.func_35354_a(var1);
		this.func_35354_a(var1);
		this.func_35354_a(var1);
		this.func_35354_a(var1);
		this.func_35354_a(var1);
		this.func_35354_a(var1);
		GL11.glViewport(0, 0, this.mc.displayWidth, this.mc.displayHeight);
		Tessellator var2 = Tessellator.instance;
		var2.startDrawingQuads();
		float var3 = this.width > this.height ? 120.0F / (float)this.width : 120.0F / (float)this.height;
		float var4 = (float)this.height * var3 / 256.0F;
		float var5 = (float)this.width * var3 / 256.0F;
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR);
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_LINEAR);
		var2.setColorRGBA_F(1.0F, 1.0F, 1.0F, 1.0F);
		int var6 = this.width;
		int var7 = this.height;
		var2.addVertexWithUV(0.0D, (double)var7, (double)this.zLevel, (double)(0.5F - var4), (double)(0.5F + var5));
		var2.addVertexWithUV((double)var6, (double)var7, (double)this.zLevel, (double)(0.5F - var4), (double)(0.5F - var5));
		var2.addVertexWithUV((double)var6, 0.0D, (double)this.zLevel, (double)(0.5F + var4), (double)(0.5F - var5));
		var2.addVertexWithUV(0.0D, 0.0D, (double)this.zLevel, (double)(0.5F + var4), (double)(0.5F + var5));
		var2.draw();
	}

	public void drawBackground4(int var1, int var2, float var3) {
		if(panoramaFB == 0) {
			panoramaFB = this.mc.renderEngine.allocateAndSetupTexture(new BufferedImage(256, 256, 2));
		}

		this.func_35356_c(var3);
		if(var2 < 16777215) {
			GL11.glDisable(GL11.GL_TEXTURE_2D);
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glDisable(GL11.GL_ALPHA_TEST);
			GL11.glBlendFunc(GL11.GL_DST_COLOR, GL11.GL_ZERO);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			Tessellator var4 = Tessellator.instance;
			var4.startDrawingQuads();
			var4.setColorOpaque_I(var2);
			var4.addVertex((double)this.width, 0.0D, 0.0D);
			var4.addVertex(0.0D, 0.0D, 0.0D);
			var4.addVertex(0.0D, (double)this.height, 0.0D);
			var4.addVertex((double)this.width, (double)this.height, 0.0D);
			var4.draw();
			GL11.glDisable(GL11.GL_BLEND);
			GL11.glEnable(GL11.GL_ALPHA_TEST);
			GL11.glEnable(GL11.GL_TEXTURE_2D);
		}

	}
}

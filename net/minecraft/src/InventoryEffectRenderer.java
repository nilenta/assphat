package net.minecraft.src;

import java.util.Collection;
import java.util.Iterator;
import org.lwjgl.opengl.GL11;

public abstract class InventoryEffectRenderer extends GuiContainer {
    // this will later be used for stuff like potions!
    private boolean field_74222_o;

    public InventoryEffectRenderer(Container var1) {
        super(var1);
    }

    public void initGui() {
        super.initGui();

    }

    public void drawScreen(int var1, int var2, float var3) {
        super.drawScreen(var1, var2, var3);
    }
}

package net.minecraft.src;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class GuiContainerCreative extends GuiContainer {
    private static InventoryBasic field_35311_f = new InventoryBasic("tmp", 72);
    private float field_35312_g = 0.0F;
    private boolean field_35313_h = false;
    private boolean field_35314_i;
    private GuiButton survivalInventoryButton;
    private GuiButton allItemsCategoryButton;
    private GuiButton foodStuffsCategoryButton;
    private GuiButton constructionCategoryButton;
    private GuiButton functionalCategoryButton;
    private GuiButton combatCategoryButton;
    private GuiButton toolsCategoryButton;
    private GuiTextField searchField;
    public static String itemCategory = "allitems";

    public GuiContainerCreative(EntityPlayer var1) {
        super(new ContainerCreative(var1, itemCategory));
        var1.craftingInventory = this.inventorySlots;
        var1.addStat(AchievementList.openInventory, 1);
        this.ySize = 208;
    }

    @Override
    public void updateScreen() {
    }

    protected void func_35309_a(Slot var1, int var2, int var3, boolean var4) {
        InventoryPlayer var5;
        ItemStack var6;
        if(var1 != null) {
            ItemStack var7;
            if(var1.inventory == field_35311_f) {
                var5 = this.mc.thePlayer.inventory;
                var6 = var5.getItemStack();
                var7 = var1.getStack();
                if(var6 != null && var7 != null && var6.itemID == var7.itemID) {
                    if(var3 == 0) {
                        if(var4) {
                            var6.stackSize = var6.getMaxStackSize();
                        } else if(var6.stackSize < var6.getMaxStackSize()) {
                            ++var6.stackSize;
                        }
                    } else if(var6.stackSize <= 1) {
                        var5.setItemStack((ItemStack)null);
                    } else {
                        --var6.stackSize;
                    }
                } else if(var6 != null) {
                    var5.setItemStack((ItemStack)null);
                } else if(var7 == null) {
                    var5.setItemStack((ItemStack)null);
                } else if(var6 == null || var6.itemID != var7.itemID) {
                    var5.setItemStack(ItemStack.copyItemStack(var7));
                    var6 = var5.getItemStack();
                    if(var4) {
                        var6.stackSize = var6.getMaxStackSize();
                    }
                }
            } else {
                this.inventorySlots.slotClick(var1.slotNumber, var3, var4, this.mc.thePlayer);
                var7 = this.inventorySlots.getSlot(var1.slotNumber).getStack();
                this.mc.playerController.func_35637_a(var7, var1.slotNumber - this.inventorySlots.slots.size() + 9 + 36);
            }
        } else {
            var5 = this.mc.thePlayer.inventory;
            if(var5.getItemStack() != null) {
                if(var3 == 0) {
                    this.mc.thePlayer.dropPlayerItem(var5.getItemStack());
                    this.mc.playerController.func_35639_a(var5.getItemStack());
                    var5.setItemStack((ItemStack)null);
                }

                if(var3 == 1) {
                    var6 = var5.getItemStack().splitStack(1);
                    this.mc.thePlayer.dropPlayerItem(var6);
                    this.mc.playerController.func_35639_a(var6);
                    if(var5.getItemStack().stackSize == 0) {
                        var5.setItemStack((ItemStack)null);
                    }
                }
            }
        }

    }

    @Override
    public void initGui() {
        this.controlList.clear();
        this.controlList.add(this.survivalInventoryButton = new GuiButton(2, this.width / 2 + 90, this.height / 4 + 96 + 36, 20, 20, "S"));
        /*this.controlList.add(this.allItemsCategoryButton = new GuiButton(3, this.width / 2 - 110, this.height / 4 + 12, 20, 20, ""));
        this.controlList.add(this.foodStuffsCategoryButton = new GuiButton(4, this.width / 2 - 110, this.height / 4 + 35, 20, 20, ""));
        this.controlList.add(this.constructionCategoryButton = new GuiButton(5, this.width / 2 - 110, this.height / 4 + 58, 20, 20, ""));
        this.controlList.add(this.functionalCategoryButton = new GuiButton(6, this.width / 2 - 110, this.height / 4 + 81, 20, 20, ""));
        this.controlList.add(this.combatCategoryButton = new GuiButton(7, this.width / 2 - 110, this.height / 4 + 104, 20, 20, ""));
        this.controlList.add(this.toolsCategoryButton = new GuiButton(8, this.width / 2 - 110, this.height / 4 + 127, 20, 20, ""));*/
    }

    @Override
    protected void drawGuiContainerForegroundLayer() {
        this.fontRenderer.drawString("Creative", 8, 6, 4210752);
    }

    protected void refreshInventory() {
        this.mc.displayGuiScreen(new GuiContainerCreative(this.mc.thePlayer));
    }

    @Override
    public void handleMouseInput() {
        super.handleMouseInput();
        int var1 = Mouse.getEventDWheel();
        if(var1 != 0) {
            int var2 = ((ContainerCreative)this.inventorySlots).field_35375_a.size() / 8 - 8 + 1;
            if(var1 > 0) {
                var1 = 1;
            }

            if(var1 < 0) {
                var1 = -1;
            }

            this.field_35312_g = (float)((double)this.field_35312_g - (double)var1 / (double)var2);
            if(this.field_35312_g < 0.0F) {
                this.field_35312_g = 0.0F;
            }

            if(this.field_35312_g > 1.0F) {
                this.field_35312_g = 1.0F;
            }

            ((ContainerCreative)this.inventorySlots).func_35374_a(this.field_35312_g);
        }

    }

    @Override
    public void drawScreen(int var1, int var2, float var3) {
        boolean var4 = Mouse.isButtonDown(0);
        int var5 = (this.width - this.xSize) / 2;
        int var6 = (this.height - this.ySize) / 2;
        int var7 = var5 + 155;
        int var8 = var6 + 17;
        int var9 = var7 + 14;
        int var10 = var8 + 160 + 2;
        if(!this.field_35314_i && var4 && var1 >= var7 && var2 >= var8 && var1 < var9 && var2 < var10) {
            this.field_35313_h = true;
        }

        if(!var4) {
            this.field_35313_h = false;
        }

        this.field_35314_i = var4;
        if(this.field_35313_h) {
            this.field_35312_g = (float)(var2 - (var8 + 8)) / ((float)(var10 - var8) - 16.0F);
            if(this.field_35312_g < 0.0F) {
                this.field_35312_g = 0.0F;
            }

            if(this.field_35312_g > 1.0F) {
                this.field_35312_g = 1.0F;
            }

            ((ContainerCreative)this.inventorySlots).func_35374_a(this.field_35312_g);
        }

        super.drawScreen(var1, var2, var3);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(GL11.GL_LIGHTING);
        int var11 = this.mc.renderEngine.getTexture("/gui/allitems.png");

        this.mc.renderEngine.bindTexture(var11);
        this.drawTexturedModalRect(var5 + 154, var6 + 17 + (int)((float)(var10 - var8 - 17) * this.field_35312_g), 0, 208, 16, 16);
        /*if(this.survivalInventoryButton.isTouchingMouse) {
            int var12 = var1 + 12;
            int var13 = var2 - 12;
            int var14 = this.fontRenderer.getStringWidth("Survival Inventory");
            this.drawGradientRect(var12 - 3, var13 - 3, var12 + var14 + 3, var13 + 8 + 3, -1073741824, -1073741824);
            this.fontRenderer.drawStringWithShadow("Survival Inventory", var12, var13, -1);
        } else if(this.allItemsCategoryButton.isTouchingMouse) {
            this.drawTooltip(var1, var2, "All Items");
        } else if(this.foodStuffsCategoryButton.isTouchingMouse) {
            this.drawTooltip(var1, var2, "Foodstuffs");
        } else if(this.constructionCategoryButton.isTouchingMouse) {
            this.drawTooltip(var1, var2, "Construction");
        } else if(this.functionalCategoryButton.isTouchingMouse) {
            this.drawTooltip(var1, var2, "Functional");
        } else if(this.combatCategoryButton.isTouchingMouse) {
            this.drawTooltip(var1, var2, "Combat");
        } else if(this.toolsCategoryButton.isTouchingMouse) {
            this.drawTooltip(var1, var2, "Tools");
        }*/

        GL11.glPushMatrix();
        GL11.glRotatef(120.0F, 1.0F, 0.0F, 0.0F);
        RenderHelper.enableStandardItemLighting();
        GL11.glPopMatrix();
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glEnable('\u803a');
        GL11.glEnable(GL11.GL_COLOR_MATERIAL);
        GL11.glEnable(GL11.GL_LIGHTING);
        /*itemRenderer.renderItemIntoGUI(this.fontRenderer, this.mc.renderEngine, new ItemStack(Block.workbench), this.width / 2 + 92, this.height / 4 + 96 + 14);
        itemRenderer.renderItemIntoGUI(this.fontRenderer, this.mc.renderEngine, new ItemStack(Item.compass), this.width / 2 - 108, this.height / 4 + 14);
        itemRenderer.renderItemIntoGUI(this.fontRenderer, this.mc.renderEngine, new ItemStack(Item.porkCooked), this.width / 2 - 108, this.height / 4 + 37);
        itemRenderer.renderItemIntoGUI(this.fontRenderer, this.mc.renderEngine, new ItemStack(Block.brick), this.width / 2 - 108, this.height / 4 + 60);
        itemRenderer.renderItemIntoGUI(this.fontRenderer, this.mc.renderEngine, new ItemStack(Item.redstone), this.width / 2 - 108, this.height / 4 + 83);
        itemRenderer.renderItemIntoGUI(this.fontRenderer, this.mc.renderEngine, new ItemStack(Item.swordSteel), this.width / 2 - 108, this.height / 4 + 106);
        itemRenderer.renderItemIntoGUI(this.fontRenderer, this.mc.renderEngine, new ItemStack(Item.pickaxeDiamond), this.width / 2 - 108, this.height / 4 + 129);*/
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDepthMask(true);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float var1) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        int var2 = this.mc.renderEngine.getTexture("/gui/allitems.png");
        this.mc.renderEngine.bindTexture(var2);
        int var3 = (this.width - this.xSize) / 2;
        int var4 = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(var3, var4, 0, 0, this.xSize, this.ySize);
    }

    @Override
    protected void actionPerformed(GuiButton var1) {
        if(var1.id == 2) {
            this.mc.displayGuiScreen(new GuiInventory(this.mc.thePlayer));
        }

        if(var1.id == 3) {
            itemCategory = "allitems";
        }

        if(var1.id == 4) {
            itemCategory = "foodstuffs";
        }

    }

    static InventoryBasic func_35310_g() {
        return field_35311_f;
    }

    @Override
    protected void mouseClicked(int var1, int var2, int var3) {
        if(var3 == 0 || var3 == 1) {
            Slot var4 = this.getSlotAtPosition(var1, var2);
            int var5 = (this.width - this.xSize) / 2;
            int var6 = (this.height - this.ySize) / 2;
            boolean var7 = var1 < var5 || var2 < var6 || var1 >= var5 + this.xSize || var2 >= var6 + this.ySize;
            int var8 = -1;
            if(var4 != null) {
                var8 = var4.slotNumber;
            }

            if(var7) {
                if(this.survivalInventoryButton.isTouchingMouse) {
                    this.mc.displayGuiScreen(new GuiInventory(this.mc.thePlayer));
                }

                /*if(this.allItemsCategoryButton.isTouchingMouse) {
                    itemCategory = "allitems";
                    this.refreshInventory();
                }

                if(this.foodStuffsCategoryButton.isTouchingMouse) {
                    itemCategory = "foodstuffs";
                    this.refreshInventory();
                }

                if(this.constructionCategoryButton.isTouchingMouse) {
                    itemCategory = "building";
                    this.refreshInventory();
                }

                if(this.functionalCategoryButton.isTouchingMouse) {
                    itemCategory = "functional";
                    this.refreshInventory();
                }

                if(this.combatCategoryButton.isTouchingMouse) {
                    itemCategory = "combat";
                    this.refreshInventory();
                }

                if(this.toolsCategoryButton.isTouchingMouse) {
                    itemCategory = "tools";
                    this.refreshInventory();
                }*/
            }

            if(var8 != -1) {
                boolean var9 = var8 != -999 && (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT));
                this.func_35309_a(var4, var8, var3, var9);
            }
        }

    }
}

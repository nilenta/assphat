package net.minecraft.src;

public class ItemCocaine extends Item {

    public ItemCocaine(int var1) {
        super(var1);
        this.maxStackSize = 64;
    }

    public ItemStack onItemRightClick(ItemStack var1, World var2, EntityPlayer var3) {
        --var1.stackSize;
        if (!var3.is_speed_boost_enabled) var3.is_speed_boost_enabled = true;
        var3.speed_boost_timer = 0;
        var3.speed_boost += 0.08D;
        var3.cocaine_amount++;
        return var1;
    }
}

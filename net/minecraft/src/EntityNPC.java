package net.minecraft.src;


public class EntityNPC extends EntityAnimal {
	
	public EntityNPC(World var1) {
		super(var1);
		this.texture = "/mob/char.png";
		this.moveSpeed = 2.0F;
        this.health = 20;
	}
	
	public void onLivingUpdate() {
		super.onLivingUpdate();
	}

	public void onDeath(Entity var1) {
		super.onDeath(var1);
	}

	protected String getHurtSound() {
		return "random.hurt";
	}

	protected String getDeathSound() {
		return "random.hurt";
	}

	protected float getSoundVolume() {
		return 0.2F;
	}
	
	public void updateUsername(String var1) {
    	this.skinUrl = "http://betacraft.uk/MinecraftSkins/" + var1 + ".png";
        this.cloakUrl = "http://betacraft.uk/MinecraftCloaks/" + var1 + ".png";
        //this.playerCloakUrl = this.cloakUrl;
        this.username = var1;
    }

	/*protected int getDropItemId() {
		return Item.flint.shiftedIndex;
	}*/
}

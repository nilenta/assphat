package net.minecraft.src;

public class EntityNPC_OLD extends EntityLiving {
	public String playerCloakUrl;
	public byte field_9371_f = 0;
    public int score = 0;
    public float field_775_e;
    public float field_774_f;
    public int cocaine_amount;
    public boolean isSwinging = false;
    public int swingProgressInt = 0;
    public String username;
    public int dimension;
    public double field_20066_r;
    public double field_20065_s;
    public double field_20064_t;
    public double field_20063_u;
    public double field_20062_v;
    public double field_20061_w;
    protected boolean sleeping;
    private ChunkCoordinates bedChunkCoordinates;
    private int sleepTimer;
    public float field_22063_x;
    public float field_22062_y;
    public float field_22061_z;
	
    public EntityNPC_OLD(World var1) {
        super(var1);
        //this.texture = "/mob/char.png";
        this.moveSpeed = 0.5F;
        this.entityType = "humanoid";
        this.unused180 = 180.0F;
        this.health = 20;
        /*this.skinUrl = "http://betacraft.uk/MinecraftSkins/" + var5 + ".png";
        this.cloakUrl = "http://betacraft.uk/MinecraftCloaks/" + var5 + ".png";
        this.username = var5;*/
        //this.yOffset = 1.62F;
        this.setSize(0.6F, 1.8F);
       
    }
    
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(16, new Byte((byte)0));
    }
    
    public void updateUsername(String var1) {
    	this.skinUrl = "http://betacraft.uk/MinecraftSkins/" + var1 + ".png";
        this.cloakUrl = "http://betacraft.uk/MinecraftCloaks/" + var1 + ".png";
        this.playerCloakUrl = this.cloakUrl;
        this.username = var1;
    }
    
    
    protected String getHurtSound() {
        return "random.hurt";
    }
    public float getEyeHeight() {
        return 0.12F;
    }

    protected String getDeathSound() {
        return "random.hurt";
    }
    
    public void writeToNBT(NBTTagCompound var1) {
        super.writeToNBT(var1);
        var1.setString("Username", this.username);
    }
    
    public void readEntityFromNBT(NBTTagCompound var1) {
        super.readEntityFromNBT(var1);
        updateUsername(var1.getString("Username"));
    }
    
    public void readFromNBT(NBTTagCompound var1) {
        super.readEntityFromNBT(var1);
        updateUsername(var1.getString("Username"));
    }
    
}

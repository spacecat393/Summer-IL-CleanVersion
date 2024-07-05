package com.nali.list.entity;

import com.nali.data.BothData;
import com.nali.data.IBothDaNe;
import com.nali.small.entities.bytes.WorkBytes;
import com.nali.small.entities.memory.server.ServerEntitiesMemory;
import com.nali.small.entities.skinning.SkinningEntities;
import com.nali.small.entities.skinning.ai.frame.SkinningEntitiesLiveFrame;
import com.nali.small.entities.sounds.Sounds;
import com.nali.small.entity.EntityEInv;
import com.nali.summer.data.both.BothDaE22Locker;
import com.nali.summer.entity.bytes.E22LockerBytes;
import com.nali.summer.entity.memory.client.e22locker.ClientE22Locker;
import com.nali.summer.entity.sounds.SoundE22Locker;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.function.Supplier;

public class SummerE22Locker extends EntityEInv
{
    public static int eggPrimary = 0x1a69a7;
    public static int eggSecondary = 0xffffff;

    public final static DataParameter<Byte>[] BYTE_DATAPARAMETER_ARRAY = new DataParameter[BothDaE22Locker.MAX_SYNC];
    public final static DataParameter<Integer>[] INTEGER_DATAPARAMETER_ARRAY = new DataParameter[BothDaE22Locker.MAX_FRAME];
    public final static DataParameter<Float>[] FLOAT_DATAPARAMETER_ARRAY = new DataParameter[1];

    static
    {
        for (int i = 0; i < BYTE_DATAPARAMETER_ARRAY.length; ++i)
        {
            BYTE_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerE22Locker.class, DataSerializers.BYTE);
        }

        for (int i = 0; i < INTEGER_DATAPARAMETER_ARRAY.length; ++i)
        {
            INTEGER_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerE22Locker.class, DataSerializers.VARINT);
        }

        for (int i = 0; i < FLOAT_DATAPARAMETER_ARRAY.length; ++i)
        {
            FLOAT_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerE22Locker.class, DataSerializers.FLOAT);
        }
    }

    public SummerE22Locker(World world)
    {
        super(world);
    }

    @Override
    protected void entityInit() {

    }

//    @Override
//    public void applyEntityAttributes()
//    {
//        super.applyEntityAttributes();
//        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100.0D);
//        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.0D);
//        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(0.0D);
//    }

    @Override
    public byte[] getAI()
    {
        return ;
    }

    @Override
    public DataParameter<Byte>[] getByteDataParameterArray()
    {
        return BYTE_DATAPARAMETER_ARRAY;
    }

//    @Override
//    public AxisAlignedBB getMouthAxisAlignedBB()
//    {
//        return this.getEntityBoundingBox().grow(0.25);
//    }

//    @Override
//    public void collideWithNearbyEntities()
//    {
//    }

//    @Override
//    public boolean canBePushed()
//    {
//        return false;
//    }

//    @Override
//    public void heal(float value)
//    {
//        if (!this.world.isRemote)
//        {
//            ServerEntitiesMemory serverentitiesmemory = (ServerEntitiesMemory)this.bothentitiesmemory;
//
//            if (serverentitiesmemory.skinningentities != null)
//            {
//                serverentitiesmemory.skinningentities.heal(value);
//            }
//        }
//        else
//        {
//            super.heal(value);
//        }
//    }

//    @Override
//    public boolean canEat()
//    {
//        return this.world.isRemote || ((ServerEntitiesMemory)this.bothentitiesmemory).skinningentities != null;
//    }

//    @Override
//    public boolean canPat()
//    {
//        return false;
//    }

    @Override
    public boolean processInitialInteract(EntityPlayer entityplayer, EnumHand enumhand)
    {
        if (!this.world.isRemote)
        {
            ServerEntitiesMemory serverentitiesmemory = (ServerEntitiesMemory)this.bothentitiesmemory;
            serverentitiesmemory.statentitiesmemory.stat ^= 16;
        }
        return super.processInitialInteract(entityplayer, enumhand);
    }

    @Override
    public DataParameter<Integer>[] getIntegerDataParameterArray()
    {
        return INTEGER_DATAPARAMETER_ARRAY;
    }

    @Override
    public DataParameter<Float>[] getFloatDataParameterArray()
    {
        return FLOAT_DATAPARAMETER_ARRAY;
    }

    @Override
    public void newC()
    {

    }

    @Override
    public void newS()
    {

    }

    @Override
    public IBothDaNe getBD()
    {
        return BothDaE22Locker.IBOTHDASN;
    }

    @Override
    public Object getSD()
    {
        return null;
    }

//    @Override
//    @SideOnly(Side.CLIENT)
//    public Object createObjectRender()
//    {
//        return new E22LockerRender(new EntitiesRenderMemory(), this);
//    }

//    @Override
//    @SideOnly(Side.CLIENT)
//    public Object createSoundRender()
//    {
////        return SoundRender.getSoundRender(DATALOADER);
//        return new NoSoundRender();
//    }
//
//    @Override
//    @SideOnly(Side.CLIENT)
//    public int[] getIVIntArray()
//    {
//        return ClientE22LockerMemory.IV_INT_ARRAY;
//    }
}

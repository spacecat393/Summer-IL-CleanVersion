package com.nali.list.entities;

import com.nali.data.BothData;
import com.nali.summer.render.skinning.E22LockerRender;
import com.nali.render.EntitiesRenderMemory;
import com.nali.render.SoundRender;
import com.nali.small.entities.bytes.WorkBytes;
import com.nali.small.entities.memory.server.ServerEntitiesMemory;
import com.nali.small.entities.skinning.SkinningEntities;
import com.nali.small.entities.skinning.ai.frame.SkinningEntitiesLiveFrame;
import com.nali.small.entities.sounds.Sounds;
import com.nali.summer.data.both.E22LockerData;
import com.nali.summer.entities.bytes.E22LockerBytes;
import com.nali.summer.entities.memory.client.ClientE22LockerMemory;
import com.nali.summer.entities.sounds.E22LockerSounds;
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

import static com.nali.summer.render.RenderHelper.DATALOADER;

public class SummerE22Locker extends SkinningEntities
{
    public static int eggPrimary = 0x1a69a7;
    public static int eggSecondary = 0xffffff;

    public static BothData BOTHDATA = new E22LockerData();
    public static WorkBytes WORKBYTES = new E22LockerBytes();
    public static Sounds SOUNDS = new E22LockerSounds();

    public final static DataParameter<Byte>[] BYTE_DATAPARAMETER_ARRAY = new DataParameter[E22LockerData.MAX_SYNC];
    public final static DataParameter<Integer>[] INTEGER_DATAPARAMETER_ARRAY = new DataParameter[E22LockerData.MAX_FRAME];
    public final static DataParameter<Float>[] FLOAT_DATAPARAMETER_ARRAY = new DataParameter[1];

    public static int[][] FRAME_INT_2D_ARRAY = new int[][]
    {
        { 0, 297 },//react
        { 298, 302 },//noact
        { 303, 386 }//idle
    };

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
    public BothData createBothData()
    {
        return BOTHDATA;
    }

    @Override
    public WorkBytes createWorkBytes()
    {
        return WORKBYTES;
    }

    @Override
    public void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.0D);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(0.0D);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void updateClient()
    {
        super.updateClient();

        this.rotationYawHead = this.rotationYaw;
        this.prevRotationYawHead = this.rotationYaw;
        this.renderYawOffset = this.rotationYaw;
    }

    @Override
    public void updateServer()
    {
        ServerEntitiesMemory serverentitiesmemory = (ServerEntitiesMemory)this.bothentitiesmemory;
        super.updateServer();

        if (serverentitiesmemory.skinningentities != null && ((WorldServer)this.world).getEntityFromUuid(serverentitiesmemory.skinningentities.getUniqueID()) == null)
        {
            serverentitiesmemory.skinningentities = null;
        }

        this.renderYawOffset = this.rotationYaw;
    }

    @Override
    public void createServer()
    {
        ServerEntitiesMemory serverentitiesmemory = (ServerEntitiesMemory)this.bothentitiesmemory;
        serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array = new SkinningEntitiesLiveFrame[1];

        serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0] = new SkinningEntitiesLiveFrame(this, 0, FRAME_INT_2D_ARRAY);
        serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].condition_boolean_supplier_array = new Supplier[]
        {
            () -> serverentitiesmemory.skinningentities != null && (serverentitiesmemory.statentitiesmemory.stat & 16) == 16 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopFree(0, (byte)16),
            () -> serverentitiesmemory.skinningentities != null && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoop(2),
            () -> serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(1)
        };
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

    @Override
    public void collideWithNearbyEntities()
    {
    }

    @Override
    public boolean canBePushed()
    {
        return false;
    }

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
    @SideOnly(Side.CLIENT)
    public Object createObjectRender()
    {
        return new E22LockerRender(new EntitiesRenderMemory(), this);
    }

    @Override
    public Sounds createSounds()
    {
        return SOUNDS;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Object createSoundRender()
    {
        return SoundRender.getSoundRender(DATALOADER);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int[] getIVIntArray()
    {
        return ClientE22LockerMemory.IV_INT_ARRAY;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void createClientEntitiesMemory(SkinningEntities skinningentities, BothData bothdata, WorkBytes workbytes)
    {
        new ClientE22LockerMemory(skinningentities, bothdata, workbytes);
    }

    @Override
    public void initWriteEntityToNBT(NBTTagCompound nbttagcompound)
    {
    }

    @Override
    public void initReadEntityFromNBT(NBTTagCompound nbttagcompound)
    {
    }
}

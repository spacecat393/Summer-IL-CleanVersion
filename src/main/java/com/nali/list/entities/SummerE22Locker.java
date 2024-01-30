package com.nali.list.entities;

import com.nali.data.BothData;
import com.nali.small.entities.bytes.SkinningEntitiesBytes;
import com.nali.small.entities.skinning.SkinningEntities;
import com.nali.small.entities.skinning.ai.frame.SkinningEntitiesLiveFrame;
import com.nali.summer.data.E22LockerData;
import com.nali.summer.entities.bytes.E22LockerBytes;
import com.nali.summer.render.E22LockerRender;
import com.nali.summer.render.RenderHelper;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

import java.util.function.Supplier;

public class SummerE22Locker extends SkinningEntities
{
    public static int eggPrimary = 0x1a69a7;
    public static int eggSecondary = 0xffffff;
    public final static DataParameter<Integer>[] INTEGER_DATAPARAMETER_ARRAY = new DataParameter[E22LockerData.MAX_FRAME];
    public final static DataParameter<Float>[] FLOAT_DATAPARAMETER_ARRAY = new DataParameter[1];

    static
    {
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
        return new E22LockerData();
    }

    @Override
    public SkinningEntitiesBytes createBytes()
    {
        return new E22LockerBytes();
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
        super.updateServer();

        if (this.server_skinningentities != null && ((WorldServer)this.world).getEntityFromUuid(this.server_skinningentities.getUniqueID()) == null)
        {
            this.server_skinningentities = null;
        }

//        this.rotationYawHead = this.rotationYaw;
        this.renderYawOffset = this.rotationYaw;
    }

    @Override
    public void createServer()
    {
        this.server_skinningentitiesliveframe_array = new SkinningEntitiesLiveFrame[1];

        this.server_skinningentitiesliveframe_array[0] = new SkinningEntitiesLiveFrame(this, 0, new int[][]
        {
            { 0, 297 },//react
            { 298, 302 },//noact
            { 303, 386 }//idle
        });

        this.server_skinningentitiesliveframe_array[0].condition_boolean_supplier_array = new Supplier[]
        {
            () -> this.server_skinningentitiesliveframe_array[0].setFLoopFree(0, this.skinningentitiesbytes.SIT(), this.server_skinningentities != null && this.server_work_byte_array[this.skinningentitiesbytes.SIT()] == 1),
            () -> this.server_skinningentitiesliveframe_array[0].setFLoop(2, this.server_skinningentities != null),
            () -> this.server_skinningentitiesliveframe_array[0].setTLoop(1)
        };
    }

    @Override
    public AxisAlignedBB getMouthAxisAlignedBB()
    {
        return this.getEntityBoundingBox().grow(0.25);
    }

    @Override
    public void collideWithNearbyEntities()
    {
    }

//    @Override
//    public boolean canBeCollidedWith()
//    {
//        return false;
//    }

    @Override
    public boolean canBePushed()
    {
        return false;
    }

    @Override
    public void heal(float value)
    {
        if (this.server_skinningentities != null)
        {
            this.server_skinningentities.heal(value);
        }
        else
        {
            super.heal(value);
        }
    }

    @Override
    public boolean canEat()
    {
        return this.world.isRemote || this.server_skinningentities != null;
    }

    @Override
    public boolean canPat()
    {
        return false;
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
    public Object createClientObject()
    {
        return new E22LockerRender(this.bothdata, RenderHelper.DATALOADER, this);
    }
}

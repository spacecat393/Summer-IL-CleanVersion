package com.nali.list.entities;

import com.nali.data.BothData;
import com.nali.render.SkinningRender;
import com.nali.small.entities.bytes.SkinningEntitiesBytes;
import com.nali.small.entities.skinning.SkinningEntities;
import com.nali.small.entities.skinning.ai.frame.SkinningEntitiesLiveFrame;
import com.nali.summer.data.ArisData;
import com.nali.summer.entities.bytes.ArisBytes;
import com.nali.summer.render.ArisRender;
import com.nali.summer.render.RenderHelper;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.function.Supplier;

public class SummerAris extends SkinningEntities
{
    public static int eggPrimary = 0x454D60;
    public static int eggSecondary = 0xF8E9E4;
//    public final static DataParameter<Byte>[] BYTE_DATAPARAMETER_ARRAY = new DataParameter[ArisBytes.MAX_WORK];
    public final static DataParameter<Integer>[] INTEGER_DATAPARAMETER_ARRAY = new DataParameter[ArisData.MAX_FRAME];
    public final static DataParameter<Float>[] FLOAT_DATAPARAMETER_ARRAY = new DataParameter[1];

    static
    {
//        for (int i = 0; i < BYTE_DATAPARAMETER_ARRAY.length; ++i)
//        {
//            BYTE_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerAris.class, DataSerializers.BYTE);
//        }

        for (int i = 0; i < INTEGER_DATAPARAMETER_ARRAY.length; ++i)
        {
            INTEGER_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerAris.class, DataSerializers.VARINT);
        }

        for (int i = 0; i < FLOAT_DATAPARAMETER_ARRAY.length; ++i)
        {
            FLOAT_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerAris.class, DataSerializers.FLOAT);
        }
    }

    public SummerAris(World world)
    {
        super(world);
    }

    @Override
    public void updateClient()
    {
        SkinningRender skinningrender = (SkinningRender)this.client_object;
        int frame = skinningrender.frame_int_array[0];

        if (frame < 205)
        {
            skinningrender.model_boolean_array[5] = false;
            skinningrender.model_boolean_array[7] = false;
        }
        else
        {
            skinningrender.model_boolean_array[5] = true;
            skinningrender.model_boolean_array[7] = true;
        }

        float scale = skinningrender.scale;
        if (frame > 834 && frame < 861)
        {
            this.width = this.bothdata.Width() * scale;
            this.height = 0.65F * scale;
        }
        else if (frame > 737 && frame < 784)
        {
            this.width = 1.5F * scale;
            this.height = 0.2F * scale;
        }
        else
        {
            this.width = this.bothdata.Width() * scale;
            this.height = this.bothdata.Height() * scale;
        }
    }

//    @Override
//    public void initFakeFrame()
//    {
//
//    }

    @Override
    public AxisAlignedBB getMouthAxisAlignedBB()
    {
        SkinningRender skinningrender = (SkinningRender)this.client_object;
        int frame = skinningrender.frame_int_array[0];

        if (frame > 834 && frame < 861)
        {
            double hw = this.width / 2.0F;
            double hh = 0.5;
            Vec3d view_vec3d = this.getVectorForRotation(this.rotationPitch, this.rotationYaw + 90.0F).scale(0.5);
            double x = this.posX + view_vec3d.x;
            double y = this.posY + this.height / 2.0F + view_vec3d.y;
            double z = this.posZ + view_vec3d.z;
            return new AxisAlignedBB(x - hw, y, z - hw, x + hw, y + hh, z + hw);
        }
        else
        {
            return super.getMouthAxisAlignedBB();
        }
    }

//    @Override
//    public void initWriteEntityToNBT(NBTTagCompound nbttagcompound)
//    {
//        nbttagcompound.setInteger("int_0", 9);
//        nbttagcompound.setInteger("int_1", 19);
//        nbttagcompound.setInteger("int_2", 20);
//        nbttagcompound.setInteger("int_3", 21);
//        nbttagcompound.setInteger("int_4", 20);
//        nbttagcompound.setInteger("int_5", 22);
//        nbttagcompound.setInteger("int_6", 23);
//        nbttagcompound.setInteger("int_7", 22);
//        nbttagcompound.setInteger("int_8", 24);
//    }
//
//    @Override
//    public void initReadEntityFromNBT()
//    {
//        EntityDataManager entitydatamanager = this.getDataManager();
//        entitydatamanager.set(INTEGER_DATAPARAMETER_ARRAY[0], 9);
//        entitydatamanager.set(INTEGER_DATAPARAMETER_ARRAY[1], 19);
//        entitydatamanager.set(INTEGER_DATAPARAMETER_ARRAY[2], 20);
//        entitydatamanager.set(INTEGER_DATAPARAMETER_ARRAY[3], 21);
//        entitydatamanager.set(INTEGER_DATAPARAMETER_ARRAY[4], 20);
//        entitydatamanager.set(INTEGER_DATAPARAMETER_ARRAY[5], 22);
//        entitydatamanager.set(INTEGER_DATAPARAMETER_ARRAY[6], 23);
//        entitydatamanager.set(INTEGER_DATAPARAMETER_ARRAY[7], 22);
//        entitydatamanager.set(INTEGER_DATAPARAMETER_ARRAY[8], 24);
//    }

    @Override
    public BothData createBothData()
    {
        return new ArisData();
    }

    @Override
    public SkinningEntitiesBytes createBytes()
    {
        return new ArisBytes();
    }

    @Override
    public void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.05D);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(20.0D);
    }

    /**0-Die
     * 1-Sit
     * 2-StartAttack
     * 3-Run
     * 4-EndRun
     * 5-Walk
     * 6-HardReady
     * 7-SoftReady
     * 8-HardIdle
     * 9-SoftIdle
     * 10-Attacking
     * 11-EndAttack
     * 12-Reload*/
    @Override
    public void createServer()
    {
        this.server_skinningentitiesliveframe_array = new SkinningEntitiesLiveFrame[1];

        this.skinningentitiesattack.attack_frame_int_array = new int[]
        {
            603,
            650
        };
        this.skinningentitiesattack.max_ammo = 2;
        this.skinningentitiesattack.minimum_distance = 48.0F;

        this.server_skinningentitiesliveframe_array[0] = new SkinningEntitiesLiveFrame(this, 0, new int[][]
        {
            { 738, 783 },
            { 835, 860 },
            { 560, 576 },
            { 932, 948 },
            { 949, 999 },
            { 173, 204 },
            { 522, 559 },
            { 81, 172 },
            { 861, 931 },
            { 0, 80 },
            { 577, 643 },
            { 644, 660 },
            { 687, 737 }
        });

        this.server_skinningentitiesliveframe_array[0].condition_boolean_supplier_array = new Supplier[]
        {
            () -> this.server_skinningentitiesliveframe_array[0].setFLoop(0, this.isZeroMove()),
            () -> this.server_skinningentitiesliveframe_array[0].setTLoopFB(1, this.server_work_byte_array[this.skinningentitiesbytes.SIT()] == 1),
            () -> this.main_server_work_byte_array[this.skinningentitiesbytes.ATTACK()] == 1 && this.moveForward == 0 && this.server_skinningentitiesliveframe_array[0].setFLoopOffSet(3, 4),
            () -> this.server_skinningentitiesliveframe_array[0].setShoot(2, 10, 11, 12, false, this.skinningentitiesattack),
            () -> this.server_skinningentitiesliveframe_array[0].setTLoop(3, this.main_server_work_byte_array[this.skinningentitiesbytes.ATTACK()] == 1 && this.moveForward != 0),
            () -> this.server_skinningentitiesliveframe_array[0].setTLoop(5, this.moveForward != 0),
            //pat -> soft_ready
            //eat -> soft_ready
            () -> this.server_skinningentitiesliveframe_array[0].setFLoopFree(6, this.skinningentitiesbytes.HARD_READY(), this.server_work_byte_array[this.skinningentitiesbytes.HARD_READY()] == 1),
            () -> this.server_skinningentitiesliveframe_array[0].setFLoopFree(7, this.skinningentitiesbytes.SOFT_READY(), this.server_work_byte_array[this.skinningentitiesbytes.SOFT_READY()] == 1),
            () -> this.server_skinningentitiesliveframe_array[0].setTLoop(8, this.main_server_work_byte_array[this.skinningentitiesbytes.ATTACK()] == 1),
            () -> this.server_skinningentitiesliveframe_array[0].setTLoop(9)
        };
    }

//    @Override
//    public DataParameter<Byte>[] getByteDataParameterArray()
//    {
//        return BYTE_DATAPARAMETER_ARRAY;
//    }

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
        return new ArisRender(this.bothdata, RenderHelper.DATALOADER, this);
    }
}

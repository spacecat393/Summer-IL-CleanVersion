package com.nali.list.entities;

import com.nali.data.BothData;
import com.nali.render.SkinningRender;
import com.nali.small.entities.bytes.SkinningEntitiesBytes;
import com.nali.small.entities.skinning.SkinningEntities;
import com.nali.small.entities.skinning.ai.frame.SkinningEntitiesLiveFrame;
import com.nali.summer.data.SSHimiData;
import com.nali.summer.entities.bytes.SSHimiBytes;
import com.nali.summer.render.RenderHelper;
import com.nali.summer.render.SSHimiRender;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;

import java.util.function.Supplier;

public class SummerSSHimi extends SkinningEntities
{
//    public static int ID;
    public static int eggPrimary = 0xBE9478;
    public static int eggSecondary = 0xFFF6AE;
//    public final static DataParameter<Byte>[] BYTE_DATAPARAMETER_ARRAY = new DataParameter[SSHimiBytes.MAX_WORK];
    public final static DataParameter<Integer>[] INTEGER_DATAPARAMETER_ARRAY = new DataParameter[SSHimiData.MAX_FRAME];
    public final static DataParameter<Float>[] FLOAT_DATAPARAMETER_ARRAY = new DataParameter[1];

    static
    {
//        for (int i = 0; i < BYTE_DATAPARAMETER_ARRAY.length; ++i)
//        {
//            BYTE_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerSSHimi.class, DataSerializers.BYTE);
//        }

        for (int i = 0; i < INTEGER_DATAPARAMETER_ARRAY.length; ++i)
        {
            INTEGER_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerSSHimi.class, DataSerializers.VARINT);
        }

        for (int i = 0; i < FLOAT_DATAPARAMETER_ARRAY.length; ++i)
        {
            FLOAT_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerSSHimi.class, DataSerializers.FLOAT);
        }
    }

    public SummerSSHimi(World world)
    {
        super(world);
    }

    @Override
    public void updateClient()
    {
        SkinningRender skinningrender = (SkinningRender)this.client_object;
        int frame = skinningrender.frame_int_array[0];

        if (frame > 267 && frame < 284)
        {
            skinningrender.model_boolean_array[0] = false;
            skinningrender.model_boolean_array[1] = false;
            skinningrender.model_boolean_array[2] = false;
            skinningrender.model_boolean_array[3] = false;
            skinningrender.model_boolean_array[4] = false;
            skinningrender.model_boolean_array[6] = false;
            skinningrender.model_boolean_array[7] = false;
            skinningrender.model_boolean_array[12] = false;
        }
        else
        {
            skinningrender.model_boolean_array[0] = true;
            skinningrender.model_boolean_array[1] = true;
            skinningrender.model_boolean_array[2] = true;
            skinningrender.model_boolean_array[3] = true;
            skinningrender.model_boolean_array[4] = true;
            skinningrender.model_boolean_array[6] = true;
            skinningrender.model_boolean_array[7] = true;
            skinningrender.model_boolean_array[12] = true;
        }

        float scale = skinningrender.scale;
        if (frame < 379 || (frame > 590 && frame < 642))
        {
            this.width = 1.7F * scale;
            this.height = 1.5F * scale;
            skinningrender.model_boolean_array[9] = true;
            skinningrender.model_boolean_array[10] = true;
            skinningrender.model_boolean_array[11] = true;
        }
        else
        {
            this.width = this.bothdata.Width() * scale;
            this.height = this.bothdata.Height() * scale;
            skinningrender.model_boolean_array[9] = false;
            skinningrender.model_boolean_array[10] = false;
            skinningrender.model_boolean_array[11] = false;
        }

        skinningrender.model_boolean_array[5] = false;
    }

    @Override
    public void initFakeFrame()
    {
        ((SkinningRender)this.client_object).frame_int_array[0] = 379;
    }

//    @Override
//    public void initWriteEntityToNBT(NBTTagCompound nbttagcompound)
//    {
//        nbttagcompound.setInteger("int_0", 1);
//        nbttagcompound.setInteger("int_1", 2);
//        nbttagcompound.setInteger("int_2", 6);
//        nbttagcompound.setInteger("int_3", 3);
//        nbttagcompound.setInteger("int_4", 4);
//        nbttagcompound.setInteger("int_5", 8);
//        nbttagcompound.setInteger("int_6", 7);
//        nbttagcompound.setInteger("int_7", 9);
//        nbttagcompound.setInteger("int_8", 5);
//        nbttagcompound.setInteger("int_9", 0);
//        nbttagcompound.setInteger("int_10", 0);
//        nbttagcompound.setInteger("int_11", 0);
//        nbttagcompound.setInteger("int_12", 0);
//
//        nbttagcompound.setInteger("int_13", 379);
//    }
//
//    @Override
//    public void initReadEntityFromNBT()
//    {
//        EntityDataManager entitydatamanager = this.getDataManager();
//        entitydatamanager.set(INTEGER_DATAPARAMETER_ARRAY[0], 1);
//        entitydatamanager.set(INTEGER_DATAPARAMETER_ARRAY[1], 2);
//        entitydatamanager.set(INTEGER_DATAPARAMETER_ARRAY[2], 6);
//        entitydatamanager.set(INTEGER_DATAPARAMETER_ARRAY[3], 3);
//        entitydatamanager.set(INTEGER_DATAPARAMETER_ARRAY[4], 4);
//        entitydatamanager.set(INTEGER_DATAPARAMETER_ARRAY[5], 8);
//        entitydatamanager.set(INTEGER_DATAPARAMETER_ARRAY[6], 7);
//        entitydatamanager.set(INTEGER_DATAPARAMETER_ARRAY[7], 9);
//        entitydatamanager.set(INTEGER_DATAPARAMETER_ARRAY[8], 5);
//        entitydatamanager.set(INTEGER_DATAPARAMETER_ARRAY[9], 0);
//        entitydatamanager.set(INTEGER_DATAPARAMETER_ARRAY[10], 0);
//        entitydatamanager.set(INTEGER_DATAPARAMETER_ARRAY[11], 0);
//        entitydatamanager.set(INTEGER_DATAPARAMETER_ARRAY[12], 0);
//
//        entitydatamanager.set(INTEGER_DATAPARAMETER_ARRAY[13], 379);
//    }

    @Override
    public BothData createBothData()
    {
        return new SSHimiData();
    }

    @Override
    public SkinningEntitiesBytes createBytes()
    {
        return new SSHimiBytes();
    }

    @Override
    public void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.05D);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(40.0D);
    }

//    @Override
//    public void onUpdate()
//    {
////        if (!this.world.isRemote)
////        {
////            this.getDataManager().set(BYTE_DATAPARAMETER_ARRAY[4], (byte)1);
//////            EntityDataManager entitydatamanager = this.getDataManager();
//////            int max_part = this.getMaxPart();
//////            int frame = entitydatamanager.get(INTEGER_DATAPARAMETER_ARRAY[max_part]);
//////            if (frame < 540)
//////            {
//////                entitydatamanager.set(INTEGER_DATAPARAMETER_ARRAY[max_part], frame + 1);
//////            }
//////            else
//////            {
//////                entitydatamanager.set(INTEGER_DATAPARAMETER_ARRAY[max_part], 0);
//////            }
////        }
//        super.onUpdate();
//        this.rotationYaw += 1.0F;
//        this.rotationYawHead = this.rotationYaw;
//    }

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
            203
        };
        this.skinningentitiesattack.max_ammo = 1;
        this.skinningentitiesattack.minimum_distance = 32.0F;

        this.server_skinningentitiesliveframe_array[0] = new SkinningEntitiesLiveFrame(this, 0, new int[][]
        {
            { 285, 327 },
            { 591, 641 },
            { 180, 197 },
            { 68, 118 },
            { 119, 179 },
            { 506, 539 },
            { 422, 504 },
            { 0, 67 },
            { 540, 590 },
            { 251, 284 },
            { 379, 421 },
            { 198, 232 },
            { 233, 250 },
            { 328, 378 }
        });

        this.server_skinningentitiesliveframe_array[0].condition_boolean_supplier_array = new Supplier[]
        {
            () -> this.server_skinningentitiesliveframe_array[0].setFLoop(0, this.isZeroMove()),
            () -> this.server_skinningentitiesliveframe_array[0].setTLoopFB(1, this.server_work_byte_array[this.skinningentitiesbytes.SIT()] == 1),
            () -> this.main_server_work_byte_array[this.skinningentitiesbytes.ATTACK()] == 1 && this.moveForward == 0 && this.server_skinningentitiesliveframe_array[0].setFLoopOffSet(3, 4),
            () -> this.server_skinningentitiesliveframe_array[0].setShoot(2, 11, 12, 13, false, this.skinningentitiesattack),
            () -> this.server_skinningentitiesliveframe_array[0].setTLoop(3, this.main_server_work_byte_array[this.skinningentitiesbytes.ATTACK()] == 1 && this.moveForward != 0),
            () -> this.server_skinningentitiesliveframe_array[0].setTLoop(5, this.moveForward != 0),
            () -> this.server_skinningentitiesliveframe_array[0].setFLoopFree(6, this.skinningentitiesbytes.ON_PAT(), this.server_work_byte_array[this.skinningentitiesbytes.ON_PAT()] == 1),
            //eat -> pat
            () -> this.server_skinningentitiesliveframe_array[0].setFLoopFree(7, this.skinningentitiesbytes.HARD_READY(), this.server_work_byte_array[this.skinningentitiesbytes.HARD_READY()] == 1),
            () -> this.server_skinningentitiesliveframe_array[0].setFLoopFree(8, this.skinningentitiesbytes.SOFT_READY(), this.server_work_byte_array[this.skinningentitiesbytes.SOFT_READY()] == 1),
            () -> this.server_skinningentitiesliveframe_array[0].setFLoop(9, this.main_server_work_byte_array[this.skinningentitiesbytes.ATTACK()] == 1),
            () -> this.server_skinningentitiesliveframe_array[0].setTLoop(10)
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
        return new SSHimiRender(this.bothdata, RenderHelper.DATALOADER, this);
    }
}

package com.nali.list.entities;

import com.nali.data.BothData;
import com.nali.render.SkinningRender;
import com.nali.small.entities.bytes.SkinningEntitiesBytes;
import com.nali.small.entities.skinning.SkinningEntities;
import com.nali.small.entities.skinning.ai.frame.SkinningEntitiesLiveFrame;
import com.nali.summer.data.NasuData;
import com.nali.summer.entities.bytes.NasuBytes;
import com.nali.summer.render.RenderHelper;
import com.nali.summer.render.NasuRender;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;

import java.util.function.Supplier;

public class SummerNasu extends SkinningEntities
{
    public static int eggPrimary = 0xF1F6F9;
    public static int eggSecondary = 0xFB7290;
//    public final static DataParameter<Byte>[] BYTE_DATAPARAMETER_ARRAY = new DataParameter[NasuBytes.MAX_WORK];
    public final static DataParameter<Integer>[] INTEGER_DATAPARAMETER_ARRAY = new DataParameter[NasuData.MAX_FRAME];
    public final static DataParameter<Float>[] FLOAT_DATAPARAMETER_ARRAY = new DataParameter[1];

    static
    {
//        for (int i = 0; i < BYTE_DATAPARAMETER_ARRAY.length; ++i)
//        {
//            BYTE_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerNasu.class, DataSerializers.BYTE);
//        }

        for (int i = 0; i < INTEGER_DATAPARAMETER_ARRAY.length; ++i)
        {
            INTEGER_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerNasu.class, DataSerializers.VARINT);
        }

        for (int i = 0; i < FLOAT_DATAPARAMETER_ARRAY.length; ++i)
        {
            FLOAT_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerNasu.class, DataSerializers.FLOAT);
        }
    }

    public SummerNasu(World world)
    {
        super(world);
    }

    @Override
    public void updateClient()
    {
        SkinningRender skinningrender = (SkinningRender)this.client_object;
        int frame = skinningrender.frame_int_array[0];

        if (frame > 255)
        {
            skinningrender.model_boolean_array[0] = true;
            skinningrender.model_boolean_array[11] = true;
        }
        else
        {
            skinningrender.model_boolean_array[0] = false;
            skinningrender.model_boolean_array[11] = false;
        }

        skinningrender.model_boolean_array[9] = (frame > 313 && frame < 338) || (frame > 341 && frame < 383) || (frame > 827 && frame < 850);
        skinningrender.model_boolean_array[10] = (frame > -1 && frame < 226) || (frame > 306 && frame < 388) || (frame > 868 && frame < 1029);

        float scale = skinningrender.scale;
        if (frame > 765 && frame < 823)
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

//    @Override
//    public void initWriteEntityToNBT(NBTTagCompound nbttagcompound)
//    {
//        nbttagcompound.setInteger("int_0", 10);
//        nbttagcompound.setInteger("int_1", 9);
//        nbttagcompound.setInteger("int_2", 11);
//        nbttagcompound.setInteger("int_3", 12);
//        nbttagcompound.setInteger("int_4", 12);
//        nbttagcompound.setInteger("int_5", 13);
//        nbttagcompound.setInteger("int_6", 14);
//        nbttagcompound.setInteger("int_7", 18);
//        nbttagcompound.setInteger("int_8", 16);
//        nbttagcompound.setInteger("int_9", 11);
//        nbttagcompound.setInteger("int_10", 17);
//        nbttagcompound.setInteger("int_11", 15);
//    }
//
//    @Override
//    public void initReadEntityFromNBT()
//    {
//        EntityDataManager entitydatamanager = this.getDataManager();
//        entitydatamanager.set(INTEGER_DATAPARAMETER_ARRAY[0], 10);
//        entitydatamanager.set(INTEGER_DATAPARAMETER_ARRAY[1], 9);
//        entitydatamanager.set(INTEGER_DATAPARAMETER_ARRAY[2], 11);
//        entitydatamanager.set(INTEGER_DATAPARAMETER_ARRAY[3], 12);
//        entitydatamanager.set(INTEGER_DATAPARAMETER_ARRAY[4], 12);
//        entitydatamanager.set(INTEGER_DATAPARAMETER_ARRAY[5], 13);
//        entitydatamanager.set(INTEGER_DATAPARAMETER_ARRAY[6], 14);
//        entitydatamanager.set(INTEGER_DATAPARAMETER_ARRAY[7], 18);
//        entitydatamanager.set(INTEGER_DATAPARAMETER_ARRAY[8], 16);
//        entitydatamanager.set(INTEGER_DATAPARAMETER_ARRAY[9], 11);
//        entitydatamanager.set(INTEGER_DATAPARAMETER_ARRAY[10], 17);
//        entitydatamanager.set(INTEGER_DATAPARAMETER_ARRAY[11], 15);
//    }

    @Override
    public BothData createBothData()
    {
        return new NasuData();
    }

    @Override
    public SkinningEntitiesBytes createBytes()
    {
        return new NasuBytes();
    }

    @Override
    public void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.05D);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5.0D);
    }

    /**0-Die
     * 1-Sit
     * 2-StartAttack
     * 3-Heal-13
     * 4-Run-3
     * 5-EndRun-4
     * 6-Walk-5
     * 7-HardReady-6
     * 8-SoftReady-7
     * 9-HardIdle-8
     * 10-SoftIdle-9
     * 11-Attacking
     * 12-EndAttack
     * 13-Reload*/
    @Override
    public void createServer()
    {
        this.skinningentitiesattack.attack_frame_int_array = new int[]
        {
            698,
            701,
            703,
            707,
            711
        };
//        this.skinningentitiesattack.max_ammo = 16;
        this.skinningentitiesattack.minimum_distance = 8.0F;

        this.skinningentitiesheal.heal_frame_int_array = new int[]
        {
            868
        };

        this.server_skinningentitiesliveframe_array = new SkinningEntitiesLiveFrame[1];
        this.server_skinningentitiesliveframe_array[0] = new SkinningEntitiesLiveFrame(this, 0, new int[][]
        {
            { 766, 822 },
            { 405, 488 },
            { 684, 696 },
            { 489, 509 },
            { 510, 535 },
            { 185, 225 },
            { 1029, 1066 },
            { 68, 184 },
            { 536, 569 },
            { 0, 66 },
            { 697, 712 },
            { 713, 723 },
            { 570, 607 },
            { 823, 868 }
        });

        this.server_skinningentitiesliveframe_array[0].condition_boolean_supplier_array = new Supplier[]
        {
            () -> this.server_skinningentitiesliveframe_array[0].setFLoop(0, this.isZeroMove()),
            () -> this.server_skinningentitiesliveframe_array[0].setTLoop(1, this.server_work_byte_array[this.skinningentitiesbytes.SIT()] == 1),
            () -> this.main_server_work_byte_array[this.skinningentitiesbytes.ATTACK()] == 1 && this.moveForward == 0 && this.server_skinningentitiesliveframe_array[0].setFLoopOffSet(3, 4),
            () -> this.server_skinningentitiesliveframe_array[0].setShoot(2, 10, 11, 12, true, this.skinningentitiesattack),
            () -> this.server_skinningentitiesliveframe_array[0].setHeal(13, this.skinningentitiesheal),
            () -> this.server_skinningentitiesliveframe_array[0].setTLoop(3, this.main_server_work_byte_array[this.skinningentitiesbytes.ATTACK()] == 1 && this.moveForward != 0),
            () -> this.server_skinningentitiesliveframe_array[0].setTLoop(5, this.moveForward != 0),
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
        return new NasuRender(this.bothdata, RenderHelper.DATALOADER, this);
    }
}

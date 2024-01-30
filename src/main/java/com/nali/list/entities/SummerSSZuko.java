package com.nali.list.entities;

import com.nali.data.BothData;
import com.nali.render.SkinningRender;
import com.nali.small.entities.bytes.SkinningEntitiesBytes;
import com.nali.small.entities.skinning.SkinningEntities;
import com.nali.small.entities.skinning.ai.frame.SkinningEntitiesLiveFrame;
import com.nali.summer.data.SSZukoData;
import com.nali.summer.data.SeaHouseData;
import com.nali.summer.entities.bytes.SSZukoBytes;
import com.nali.summer.render.RenderHelper;
import com.nali.summer.render.SSZukoRender;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.Arrays;
import java.util.function.Supplier;

public class SummerSSZuko extends SkinningEntities
{
    public static int eggPrimary = 0xfff0e2;
    public static int eggSecondary = 0x645353;
    public final static DataParameter<Integer>[] INTEGER_DATAPARAMETER_ARRAY = new DataParameter[SSZukoData.MAX_FRAME + SeaHouseData.MAX_FRAME];
    public final static DataParameter<Float>[] FLOAT_DATAPARAMETER_ARRAY = new DataParameter[1];

    static
    {
        for (int i = 0; i < INTEGER_DATAPARAMETER_ARRAY.length; ++i)
        {
            INTEGER_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerSSZuko.class, DataSerializers.VARINT);
        }

        for (int i = 0; i < FLOAT_DATAPARAMETER_ARRAY.length; ++i)
        {
            FLOAT_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerSSZuko.class, DataSerializers.FLOAT);
        }
    }

    public SummerSSZuko(World world)
    {
        super(world);
    }

    @Override
    public void updateClient()
    {
        SSZukoRender sszukorender = (SSZukoRender)this.client_object;
        int frame = sszukorender.frame_int_array[0];

        if (frame > 481 && frame < 533)
        {
            Arrays.fill(sszukorender.seahouserender.model_boolean_array, true);
        }
        else if (frame > 532 && frame < 751)
        {
            sszukorender.seahouserender.model_boolean_array[0] = true;
            sszukorender.seahouserender.model_boolean_array[1] = false;
            sszukorender.seahouserender.model_boolean_array[2] = false;
        }
        else
        {
            Arrays.fill(sszukorender.seahouserender.model_boolean_array, false);
        }

        super.updateClient();
    }

    @Override
    public void initFakeFrame()
    {
        SSZukoRender sszukorender = (SSZukoRender)this.client_object;
        Arrays.fill(sszukorender.seahouserender.model_boolean_array, false);
    }

    @Override
    public AxisAlignedBB getMouthAxisAlignedBB()
    {
        SkinningRender skinningrender = (SkinningRender)this.client_object;
        int frame = skinningrender.frame_int_array[0];

        if (frame > 532 && frame < 751)
        {
            double hw = this.width / 2.0F;
            double hh = 0.5;
            Vec3d view_vec3d = this.getVectorForRotation(this.rotationPitch, this.rotationYaw + 180.0F).scale(0.5);
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
//        nbttagcompound.setInteger("int_0", 25);
//        nbttagcompound.setInteger("int_1", 9);
//        nbttagcompound.setInteger("int_2", 26);
//        nbttagcompound.setInteger("int_3", 27);
//        nbttagcompound.setInteger("int_4", 27);
//        nbttagcompound.setInteger("int_5", 28);
//        nbttagcompound.setInteger("int_6", 29);
//        nbttagcompound.setInteger("int_7", 30);
//        nbttagcompound.setInteger("int_8", 31);
//        nbttagcompound.setInteger("int_9", 32);
//        nbttagcompound.setInteger("int_10", 32);
//        nbttagcompound.setInteger("int_11", 32);
//        nbttagcompound.setInteger("int_12", 32);
//        nbttagcompound.setInteger("int_13", 31);
//
//        nbttagcompound.setInteger("int_15", -1);
//    }
//
//    @Override
//    public void initReadEntityFromNBT()
//    {
//        EntityDataManager entitydatamanager = this.getDataManager();
//        entitydatamanager.set(INTEGER_DATAPARAMETER_ARRAY[0], 25);
//        entitydatamanager.set(INTEGER_DATAPARAMETER_ARRAY[1], 9);
//        entitydatamanager.set(INTEGER_DATAPARAMETER_ARRAY[2], 26);
//        entitydatamanager.set(INTEGER_DATAPARAMETER_ARRAY[3], 27);
//        entitydatamanager.set(INTEGER_DATAPARAMETER_ARRAY[4], 27);
//        entitydatamanager.set(INTEGER_DATAPARAMETER_ARRAY[5], 28);
//        entitydatamanager.set(INTEGER_DATAPARAMETER_ARRAY[6], 29);
//        entitydatamanager.set(INTEGER_DATAPARAMETER_ARRAY[7], 30);
//        entitydatamanager.set(INTEGER_DATAPARAMETER_ARRAY[8], 31);
//        entitydatamanager.set(INTEGER_DATAPARAMETER_ARRAY[9], 32);
//        entitydatamanager.set(INTEGER_DATAPARAMETER_ARRAY[10], 32);
//        entitydatamanager.set(INTEGER_DATAPARAMETER_ARRAY[11], 32);
//        entitydatamanager.set(INTEGER_DATAPARAMETER_ARRAY[12], 32);
//        entitydatamanager.set(INTEGER_DATAPARAMETER_ARRAY[13], 31);
//    }

    @Override
    public void updateRendering(SkinningRender skinningrender, EntityDataManager entitydatamanager)
    {
        SSZukoRender sszukorender = (SSZukoRender)skinningrender;

        DataParameter<Integer>[] integer_dataparameter = this.getIntegerDataParameterArray();
//        int i = 0;
//        while (i < skinningrender.texture_index_int_array.length)
//        {
//            skinningrender.texture_index_int_array[i] = entitydatamanager.get(integer_dataparameter[i++]);
//        }
//
//        for (int x = 0; i < skinningrender.texture_index_int_array.length + sszukorender.seahouserender.texture_index_int_array.length; ++x)
//        {
//            sszukorender.seahouserender.texture_index_int_array[x] = entitydatamanager.get(integer_dataparameter[i++]);
//        }

        skinningrender.frame_int_array[0] = entitydatamanager.get(integer_dataparameter[0]);
        sszukorender.seahouserender.frame_int_array[0] = entitydatamanager.get(integer_dataparameter[1]);
    }

    @Override
    public BothData createBothData()
    {
        return new SSZukoData();
    }

    @Override
    public SkinningEntitiesBytes createBytes()
    {
        return new SSZukoBytes();
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
     * 2-Walk
     * 3-Protect
     * 4-HardReady
     * 5-SoftReady
     * 6-HardIdle
     * 7-SoftIdle
     * 8-ProtectSpawn
     * 9-ProtectAct
     * 10-ProtectEnd
     * 11-ProtectIdle*/
    @Override
    public void createServer()
    {
        this.server_skinningentitiesliveframe_array = new SkinningEntitiesLiveFrame[2];

        this.server_skinningentitiesliveframe_array[0] = new SkinningEntitiesLiveFrame(this, 0, new int[][]
        {
            { 0, 222 },
            { 0, 222 },
            { 381, 481 },
            { 482, 532 },
            { 223, 380 },
            { 0, 222 },
            { 533, 610 },//spawn
            { 611, 704 },//idle
            { 705, 725 },//act
            { 726, 750 }//end
        });
        this.server_skinningentitiesliveframe_array[0].condition_boolean_supplier_array = new Supplier[]
        {
            () -> this.server_skinningentitiesliveframe_array[0].setTLoop(0, this.isZeroMove()),
            () -> this.server_skinningentitiesliveframe_array[0].setProtect(6, 7, 8, 9, this.skinningentitiesprotect),
            () -> this.server_skinningentitiesliveframe_array[0].setTLoop(1, this.server_work_byte_array[this.skinningentitiesbytes.SIT()] == 1),
            () -> this.server_skinningentitiesliveframe_array[0].setTLoop(2, this.moveForward != 0),
            //pat -> soft_ready
            //eat -> soft_ready
            () -> this.server_skinningentitiesliveframe_array[0].setFLoopFree(3, this.skinningentitiesbytes.HARD_READY(), this.server_work_byte_array[this.skinningentitiesbytes.HARD_READY()] == 1),
            () -> this.server_skinningentitiesliveframe_array[0].setFLoopFree(4, this.skinningentitiesbytes.SOFT_READY(), this.server_work_byte_array[this.skinningentitiesbytes.SOFT_READY()] == 1),
            () -> this.server_skinningentitiesliveframe_array[0].setTLoop(5)
        };

        this.server_skinningentitiesliveframe_array[1] = new SkinningEntitiesLiveFrame(this, 1, new int[][]
        {
            { 0, 50 },
            { 0, 0 },
            { 51, 128 },//spawn
            { 129, 222 },//idle
            { 223, 243 },//act
            { 244, 269 }//end
        });
        this.server_skinningentitiesliveframe_array[1].condition_boolean_supplier_array = new Supplier[]
        {
            () -> this.server_skinningentitiesliveframe_array[1].setProtect(2, 3, 4, 5, this.skinningentitiesprotect),
            () -> this.server_skinningentitiesliveframe_array[1].setFLoopFree(0, this.skinningentitiesbytes.HARD_READY(), this.server_work_byte_array[this.skinningentitiesbytes.HARD_READY()] == 1),
            () -> this.server_skinningentitiesliveframe_array[1].setTLoop(1)
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
        return new SSZukoRender(this.bothdata, RenderHelper.DATALOADER, this);
    }
}

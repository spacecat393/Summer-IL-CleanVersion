package com.nali.list.entities;

import com.nali.data.BothData;
import com.nali.render.EntitiesRenderMemory;
import com.nali.small.entities.bytes.WorkBytes;
import com.nali.small.entities.memory.ClientEntitiesMemory;
import com.nali.small.entities.memory.server.ServerEntitiesMemory;
import com.nali.small.entities.skinning.SkinningEntities;
import com.nali.small.entities.skinning.ai.frame.SkinningEntitiesLiveFrame;
import com.nali.summer.data.SSZukoData;
import com.nali.summer.data.SeaHouseData;
import com.nali.summer.entities.bytes.SSZukoBytes;
import com.nali.summer.entities.memory.client.ClientSSZukoMemory;
import com.nali.summer.render.RenderHelper;
import com.nali.summer.render.SSZukoRender;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;

import java.util.Arrays;
import java.util.function.Supplier;

public class SummerSSZuko extends SkinningEntities
{
    public static int eggPrimary = 0xfff0e2;
    public static int eggSecondary = 0x645353;
    public final static DataParameter<Byte>[] BYTE_DATAPARAMETER_ARRAY = new DataParameter[SSZukoData.MAX_SYNC];
    public final static DataParameter<Integer>[] INTEGER_DATAPARAMETER_ARRAY = new DataParameter[SSZukoData.MAX_FRAME + SeaHouseData.MAX_FRAME];
    public final static DataParameter<Float>[] FLOAT_DATAPARAMETER_ARRAY = new DataParameter[1];

    public static int[][] SSZUKO_FRAME_INT_2D_ARRAY = new int[][]
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
    };
    public static int[][] SEAHOUSE_FRAME_INT_2D_ARRAY = new int[][]
    {
        { 0, 50 },
        { 0, 0 },
        { 51, 128 },//spawn
        { 129, 222 },//idle
        { 223, 243 },//act
        { 244, 269 }//end
    };

    static
    {
        for (int i = 0; i < BYTE_DATAPARAMETER_ARRAY.length; ++i)
        {
            BYTE_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerSSZuko.class, DataSerializers.BYTE);
        }

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
        ClientEntitiesMemory cliententitiesmemory = (ClientEntitiesMemory)this.bothentitiesmemory;
        SSZukoRender sszukorender = (SSZukoRender)cliententitiesmemory.objectrender;
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
        ClientEntitiesMemory cliententitiesmemory = (ClientEntitiesMemory)this.bothentitiesmemory;
        SSZukoRender sszukorender = (SSZukoRender)cliententitiesmemory.objectrender;
        Arrays.fill(sszukorender.seahouserender.model_boolean_array, false);
    }

//    @Override
//    public AxisAlignedBB getMouthAxisAlignedBB()
//    {
//        ClientEntitiesMemory cliententitiesmemory = (ClientEntitiesMemory)this.bothentitiesmemory;
//        SkinningRender skinningrender = (SkinningRender)cliententitiesmemory.objectrender;
//        int frame = skinningrender.frame_int_array[0];
//
//        if (frame > 532 && frame < 751)
//        {
//            double hw = this.width / 2.0F;
//            double hh = 0.5;
//            Vec3d view_vec3d = this.getVectorForRotation(this.rotationPitch, this.rotationYaw + 180.0F).scale(0.5);
//            double x = this.posX + view_vec3d.x;
//            double y = this.posY + this.height / 2.0F + view_vec3d.y;
//            double z = this.posZ + view_vec3d.z;
//            return new AxisAlignedBB(x - hw, y, z - hw, x + hw, y + hh, z + hw);
//        }
//        else
//        {
//            return super.getMouthAxisAlignedBB();
//        }
//    }

    @Override
    public void updateRendering(EntityDataManager entitydatamanager)
    {
        ClientEntitiesMemory cliententitiesmemory = (ClientEntitiesMemory)this.bothentitiesmemory;
        SSZukoRender sszukorender = (SSZukoRender)cliententitiesmemory.objectrender;

        DataParameter<Integer>[] integer_dataparameter = this.getIntegerDataParameterArray();

        sszukorender.frame_int_array[0] = entitydatamanager.get(integer_dataparameter[0]);
        sszukorender.seahouserender.frame_int_array[0] = entitydatamanager.get(integer_dataparameter[1]);
    }

    @Override
    public BothData createBothData()
    {
        return new SSZukoData();
    }

    @Override
    public WorkBytes createWorkBytes()
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

    @Override
    public void createServer()
    {
        ServerEntitiesMemory serverentitiesmemory = (ServerEntitiesMemory)this.bothentitiesmemory;
        WorkBytes workbytes = serverentitiesmemory.workbytes;
        serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array = new SkinningEntitiesLiveFrame[2];

        serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0] = new SkinningEntitiesLiveFrame(this, 0, SSZUKO_FRAME_INT_2D_ARRAY);
        serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].condition_boolean_supplier_array = new Supplier[]
        {
            () -> this.isZeroMove() && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(0),
            () -> serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setProtect(6, 7, 8, 9, serverentitiesmemory.entitiesaimemory.skinningentitiesprotect),
            () -> serverentitiesmemory.current_work_byte_array[workbytes.SIT()] == 1 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(1),
            () -> this.moveForward != 0 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(2),
            () -> (serverentitiesmemory.statentitiesmemory.stat & 4) == 4 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopFree(3, (byte)4),
            () -> ((serverentitiesmemory.statentitiesmemory.stat & 1) == 1 || (serverentitiesmemory.statentitiesmemory.stat & 2) == 2 || (serverentitiesmemory.statentitiesmemory.stat & 8) == 8) && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopFree(4, (byte)(1 + 2 + 8)),
            () -> serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(5)
        };

        serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[1] = new SkinningEntitiesLiveFrame(this, 1, SEAHOUSE_FRAME_INT_2D_ARRAY);
        serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[1].condition_boolean_supplier_array = new Supplier[]
        {
            () -> serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[1].setProtect(2, 3, 4, 5, serverentitiesmemory.entitiesaimemory.skinningentitiesprotect),
            () -> (serverentitiesmemory.statentitiesmemory.stat & 4) == 4 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[1].setFLoopFree(0, (byte)4),
            () -> serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[1].setTLoop(1)
        };
    }

    @Override
    public DataParameter<Byte>[] getByteDataParameterArray()
    {
        return BYTE_DATAPARAMETER_ARRAY;
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
    public Object createObjectRender()
    {
        return new SSZukoRender(new EntitiesRenderMemory(), this.bothentitiesmemory.bothdata, RenderHelper.DATALOADER, this);
    }

    @Override
    public int[] getIVIntArray()
    {
        return ClientSSZukoMemory.IV_INT_ARRAY;
    }

    @Override
    public void createClientEntitiesMemory(SkinningEntities skinningentities, BothData bothdata, WorkBytes workbytes)
    {
        new ClientSSZukoMemory(skinningentities, bothdata, workbytes);
    }
}

package com.nali.list.entities;

import com.nali.data.BothData;
import com.nali.render.SkinningRender;
import com.nali.small.entities.bytes.WorkBytes;
import com.nali.small.entities.memory.ClientEntitiesMemory;
import com.nali.small.entities.memory.server.ServerEntitiesMemory;
import com.nali.small.entities.skinning.SkinningEntities;
import com.nali.small.entities.skinning.ai.frame.SkinningEntitiesLiveFrame;
import com.nali.summer.data.NasuData;
import com.nali.summer.entities.bytes.NasuBytes;
import com.nali.summer.render.NasuRender;
import com.nali.summer.render.RenderHelper;
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
    public final static DataParameter<Integer>[] INTEGER_DATAPARAMETER_ARRAY = new DataParameter[NasuData.MAX_FRAME];
    public final static DataParameter<Float>[] FLOAT_DATAPARAMETER_ARRAY = new DataParameter[1];

    public static int[] ATTACK_FRAME_INT_ARRAY = new int[]
    {
        698,
        701,
        703,
        707,
        711
    };
    public static int[] HEAL_FRAME_INT_ARRAY = new int[]
    {
        868
    };
    public static int[][] FRAME_INT_2D_ARRAY = new int[][]
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
    };

    static
    {
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
        ClientEntitiesMemory cliententitiesmemory = (ClientEntitiesMemory)this.bothentitiesmemory;
        SkinningRender skinningrender = (SkinningRender)cliententitiesmemory.objectrender;
        BothData bothdata = cliententitiesmemory.bothdata;
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
            this.width = bothdata.Width() * scale;
            this.height = bothdata.Height() * scale;
        }
    }

    @Override
    public BothData createBothData()
    {
        return new NasuData();
    }

    @Override
    public WorkBytes createWorkBytes()
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

    @Override
    public void createServer()
    {
        ServerEntitiesMemory serverentitiesmemory = (ServerEntitiesMemory)this.bothentitiesmemory;
        WorkBytes workbytes = serverentitiesmemory.workbytes;
        serverentitiesmemory.entitiesaimemory.skinningentitiesattack.attack_frame_int_array = ATTACK_FRAME_INT_ARRAY;
//        serverentitiesmemory.entitiesaimemory.skinningentitiesattack.max_ammo = 16;
        serverentitiesmemory.entitiesaimemory.skinningentitiesattack.minimum_distance = 8.0F;

        serverentitiesmemory.entitiesaimemory.skinningentitiesheal.heal_frame_int_array = HEAL_FRAME_INT_ARRAY;

        serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array = new SkinningEntitiesLiveFrame[1];
        serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0] = new SkinningEntitiesLiveFrame(this, 0, FRAME_INT_2D_ARRAY);
        serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].condition_boolean_supplier_array = new Supplier[]
        {
            () -> this.isZeroMove() && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoop(0),
            () -> serverentitiesmemory.current_work_byte_array[workbytes.SIT()] == 1 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(1),
            () -> serverentitiesmemory.main_work_byte_array[workbytes.ATTACK()] == 1 && this.moveForward == 0 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopOffSet(3, 4),
            () -> serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setShoot(2, 10, 11, 12, true, serverentitiesmemory.entitiesaimemory.skinningentitiesattack),
            () -> serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setHeal(13, serverentitiesmemory.entitiesaimemory.skinningentitiesheal),
            () -> serverentitiesmemory.main_work_byte_array[workbytes.ATTACK()] == 1 && this.moveForward != 0 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(3),
            () -> this.moveForward != 0 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(5),
            () -> serverentitiesmemory.current_work_byte_array[workbytes.HARD_READY()] == 1 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopFree(6, workbytes.HARD_READY()),
            () -> serverentitiesmemory.current_work_byte_array[workbytes.SOFT_READY()] == 1 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopFree(7, workbytes.SOFT_READY()),
            () -> serverentitiesmemory.main_work_byte_array[workbytes.ATTACK()] == 1 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(8),
            () -> serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(9)
        };
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
        return new NasuRender(this.bothentitiesmemory.bothdata, RenderHelper.DATALOADER, this);
    }
}

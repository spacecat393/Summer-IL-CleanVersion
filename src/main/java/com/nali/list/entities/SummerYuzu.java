package com.nali.list.entities;

import com.nali.data.BothData;
import com.nali.render.EntitiesRenderMemory;
import com.nali.render.SkinningRender;
import com.nali.small.entities.bytes.WorkBytes;
import com.nali.small.entities.memory.ClientEntitiesMemory;
import com.nali.small.entities.memory.server.ServerEntitiesMemory;
import com.nali.small.entities.skinning.SkinningEntities;
import com.nali.small.entities.skinning.ai.frame.SkinningEntitiesLiveFrame;
import com.nali.summer.data.YuzuData;
import com.nali.summer.entities.bytes.YuzuBytes;
import com.nali.summer.entities.memory.client.ClientYuzuMemory;
import com.nali.summer.render.RenderHelper;
import com.nali.summer.render.YuzuRender;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;

import java.util.function.Supplier;

public class SummerYuzu extends SkinningEntities
{
    public static int eggPrimary = 0xfbdad0;
    public static int eggSecondary = 0xfc6c78;
    public final static DataParameter<Byte>[] BYTE_DATAPARAMETER_ARRAY = new DataParameter[YuzuData.MAX_SYNC];
    public final static DataParameter<Integer>[] INTEGER_DATAPARAMETER_ARRAY = new DataParameter[YuzuData.MAX_FRAME];
    public final static DataParameter<Float>[] FLOAT_DATAPARAMETER_ARRAY = new DataParameter[1];

    public static int[] ATTACK_FRAME_INT_ARRAY = new int[]
    {
        649,
        650,
        651
    };
    public static int[][] FRAME_INT_2D_ARRAY = new int[][]
    {
        { 717, 767 },
        { 526, 592 },
        { 627, 643 },
        { 844, 859 },
        { 860, 893 },
        { 113, 143 },
        { 806, 843 },
        { 34, 112 },
        { 593, 626 },
        { 0, 33 },
        { 644, 664 },
        { 703, 716 },
        { 768, 805 },
        { 665, 702 },//delay attack
        { 144, 441 },//locker react
        { 442, 525 }//locker idle
    };

    static
    {
        for (int i = 0; i < BYTE_DATAPARAMETER_ARRAY.length; ++i)
        {
            BYTE_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerYuzu.class, DataSerializers.BYTE);
        }

        for (int i = 0; i < INTEGER_DATAPARAMETER_ARRAY.length; ++i)
        {
            INTEGER_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerYuzu.class, DataSerializers.VARINT);
        }

        for (int i = 0; i < FLOAT_DATAPARAMETER_ARRAY.length; ++i)
        {
            FLOAT_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerYuzu.class, DataSerializers.FLOAT);
        }
    }

    public SummerYuzu(World world)
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

        float scale = skinningrender.entitiesrendermemory.scale;
        if (frame > 195 && frame < 222)
        {
            skinningrender.texture_index_int_array[8] = 66;
        }
        else if ((frame > 221 && frame < 250) || (frame > 354 && frame < 429))
        {
            skinningrender.texture_index_int_array[8] = 67;
        }
        else if (frame > 249 && frame < 266)
        {
            skinningrender.texture_index_int_array[8] = 68;
        }
        else if (frame > 301 && frame < 355)
        {
            skinningrender.texture_index_int_array[8] = 69;
        }
        else
        {
            skinningrender.texture_index_int_array[8] = 9;
        }

        if (frame > 716 && frame < 768)
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
        return new YuzuData();
    }

    @Override
    public WorkBytes createWorkBytes()
    {
        return new YuzuBytes();
    }

    @Override
    public void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.05D);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(10.0D);
    }

    @Override
    public void createServer()
    {
        ServerEntitiesMemory serverentitiesmemory = (ServerEntitiesMemory)this.bothentitiesmemory;
        WorkBytes workbytes = serverentitiesmemory.workbytes;
        serverentitiesmemory.entitiesaimemory.skinningentitiesplaywith.clasz = SummerE22Locker.class;

        serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array = new SkinningEntitiesLiveFrame[1];

        serverentitiesmemory.entitiesaimemory.skinningentitiesattack.attack_frame_int_array = ATTACK_FRAME_INT_ARRAY;
        serverentitiesmemory.entitiesaimemory.skinningentitiesattack.max_ammo = 4;
        serverentitiesmemory.entitiesaimemory.skinningentitiesattack.minimum_distance = 10.0F;

        serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0] = new SkinningEntitiesLiveFrame(this, 0, FRAME_INT_2D_ARRAY);
        serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].condition_boolean_supplier_array = new Supplier[]
        {
            () -> this.isZeroMove() && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoop(0),
            () -> serverentitiesmemory.entitiesaimemory.skinningentitiesplaywith.should_play && ((ServerEntitiesMemory)serverentitiesmemory.entitiesaimemory.skinningentitiesplaywith.playwith_skinningentities.bothentitiesmemory).current_work_byte_array[serverentitiesmemory.entitiesaimemory.skinningentitiesplaywith.playwith_skinningentities.bothentitiesmemory.workbytes.SIT()] == 1 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoop(14),
            () -> serverentitiesmemory.entitiesaimemory.skinningentitiesplaywith.should_play && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(15),
            () -> serverentitiesmemory.current_work_byte_array[workbytes.SIT()] == 1 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(1),
            () -> serverentitiesmemory.main_work_byte_array[workbytes.ATTACK()] == 1 && this.moveForward == 0 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopOffSet(3, 4),
            () -> serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setShoot(2, 10, 11, 12, false, serverentitiesmemory.entitiesaimemory.skinningentitiesattack),
            () -> serverentitiesmemory.main_work_byte_array[workbytes.ATTACK()] == 1 && this.moveForward != 0 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(3),
            () -> this.moveForward != 0 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(5),
            () -> serverentitiesmemory.current_work_byte_array[workbytes.HARD_READY()] == 1 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopFree(6, workbytes.HARD_READY()),
            () -> serverentitiesmemory.current_work_byte_array[workbytes.SOFT_READY()] == 1 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopFree(7, workbytes.SOFT_READY()),
            () -> serverentitiesmemory.main_work_byte_array[workbytes.ATTACK()] == 1 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(8),
            () -> serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(9)
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
        return new YuzuRender(new EntitiesRenderMemory(), this.bothentitiesmemory.bothdata, RenderHelper.DATALOADER, this);
    }

    @Override
    public void createClientEntitiesMemory(SkinningEntities skinningentities, BothData bothdata, WorkBytes workbytes)
    {
        new ClientYuzuMemory(skinningentities, bothdata, workbytes);
    }
}

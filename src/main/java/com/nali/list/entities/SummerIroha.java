package com.nali.list.entities;

import com.nali.data.BothData;
import com.nali.render.EntitiesRenderMemory;
import com.nali.render.SkinningRender;
import com.nali.small.entities.bytes.WorkBytes;
import com.nali.small.entities.memory.ClientEntitiesMemory;
import com.nali.small.entities.memory.server.ServerEntitiesMemory;
import com.nali.small.entities.skinning.SkinningEntities;
import com.nali.small.entities.skinning.ai.frame.SkinningEntitiesLiveFrame;
import com.nali.summer.data.IrohaData;
import com.nali.summer.entities.bytes.IrohaBytes;
import com.nali.summer.entities.memory.client.ClientIrohaMemory;
import com.nali.summer.render.IrohaRender;
import com.nali.summer.render.RenderHelper;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

import java.util.function.Supplier;

public class SummerIroha extends SkinningEntities
{
    public static int eggPrimary = 0xadb7c1;
    public static int eggSecondary = 0xc95b7e;
    public final static DataParameter<Byte>[] BYTE_DATAPARAMETER_ARRAY = new DataParameter[IrohaData.MAX_SYNC];
    public final static DataParameter<Integer>[] INTEGER_DATAPARAMETER_ARRAY = new DataParameter[IrohaData.MAX_FRAME];
    public final static DataParameter<Float>[] FLOAT_DATAPARAMETER_ARRAY = new DataParameter[1];

    public static int[] ATTACK_FRAME_INT_ARRAY = new int[]
    {
        534,
        789
    };
    public static int[][] FRAME_INT_2D_ARRAY = new int[][]
    {
        { 321, 371 },
        { 635, 685 },
        { 516, 532 },//start attack
        { 423, 473 },//loop move
        { 474, 515 },//end move
        { 143, 206 },//cafe walk
        { 51, 142 },
        { 258, 320 },
        { 207, 257 },
        { 372, 422 },
        { 0, 50 },
        { 533, 566 },
        { 567, 583 },
        { 584, 634 },
        { 686, 719 },// 14 start ride
        { 720, 770 },// 15 loop ride
        { 1034, 1084 },// 16 loop ride-move
        { 941, 982 },// 17 end ride-move
        { 983, 1033 },// 18 ride-panic
        { 890, 940 },// 19 ride-destroy
        { 771, 787 },// 20 start ride-attack
        { 788, 821 },// 21 loop ride-attack
        { 822, 838 },// 22 end ride-attack
        { 839, 889 }// 23 ride-reload
    };

    static
    {
        for (int i = 0; i < BYTE_DATAPARAMETER_ARRAY.length; ++i)
        {
            BYTE_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerIroha.class, DataSerializers.BYTE);
        }

        for (int i = 0; i < INTEGER_DATAPARAMETER_ARRAY.length; ++i)
        {
            INTEGER_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerIroha.class, DataSerializers.VARINT);
        }

        for (int i = 0; i < FLOAT_DATAPARAMETER_ARRAY.length; ++i)
        {
            FLOAT_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerIroha.class, DataSerializers.FLOAT);
        }
    }

    public SummerIroha(World world)
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
        if (frame > 257)
        {
            this.width = 1.7F * scale;
            this.height = 1.5F * scale;
            skinningrender.model_boolean_array[4] = true;
            skinningrender.model_boolean_array[5] = true;
        }
        else
        {
            this.width = bothdata.Width() * scale;
            this.height = bothdata.Height() * scale;
            skinningrender.model_boolean_array[4] = false;
            skinningrender.model_boolean_array[5] = false;
        }
    }

    @Override
    public BothData createBothData()
    {
        return new IrohaData();
    }

    @Override
    public WorkBytes createWorkBytes()
    {
        return new IrohaBytes();
    }

    @Override
    public void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.05D);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(40.0D);
    }

    @Override
    public void createServer()
    {
        ServerEntitiesMemory serverentitiesmemory = (ServerEntitiesMemory)this.bothentitiesmemory;
        WorkBytes workbytes = serverentitiesmemory.workbytes;
        serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array = new SkinningEntitiesLiveFrame[1];

        serverentitiesmemory.entitiesaimemory.skinningentitiesattack.attack_frame_int_array = ATTACK_FRAME_INT_ARRAY;
        serverentitiesmemory.entitiesaimemory.skinningentitiesattack.max_ammo = 1;
        serverentitiesmemory.entitiesaimemory.skinningentitiesattack.minimum_distance = 32.0F;

        serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0] = new SkinningEntitiesLiveFrame(this, 0, FRAME_INT_2D_ARRAY);
        serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].condition_boolean_supplier_array = new Supplier[]
        {
            () ->
            {
                int id = 14;
                boolean result = serverentitiesmemory.skinningentities != null && ((ServerEntitiesMemory)serverentitiesmemory.skinningentities.bothentitiesmemory).entitiesaimemory.skinningentitiesplaywith.first_playwith;
                if (result)
                {
                    ((ServerEntitiesMemory)serverentitiesmemory.skinningentities.bothentitiesmemory).entitiesaimemory.skinningentitiesliveframe_array[0].setFLoop(id - 1);
                    ((ServerEntitiesMemory)serverentitiesmemory.skinningentities.bothentitiesmemory).entitiesaimemory.skinningentitiesliveframe_array[0].stepFrame();
                    if (serverentitiesmemory.frame_int_array[serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].integer_index] == serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].int_2d_array[id][1])
                    {
                        ((ServerEntitiesMemory)serverentitiesmemory.skinningentities.bothentitiesmemory).entitiesaimemory.skinningentitiesplaywith.first_playwith = false;
                    }
                }

                return result && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoop(id);
            },
            () ->
            {
                int id = 19;
                boolean result = serverentitiesmemory.skinningentities != null && this.isZeroMove() && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoop(id);
                if (result)
                {
                    ((ServerEntitiesMemory)serverentitiesmemory.skinningentities.bothentitiesmemory).entitiesaimemory.skinningentitiesliveframe_array[0].setFLoop(id - 1);
                    ((ServerEntitiesMemory)serverentitiesmemory.skinningentities.bothentitiesmemory).entitiesaimemory.skinningentitiesliveframe_array[0].stepFrame();
                }

                return result;
            },
            () ->
            {
                int id = 18;
                boolean result = serverentitiesmemory.skinningentities != null && serverentitiesmemory.current_work_byte_array[workbytes.SIT()] == 1 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoopFB(id);
                if (result)
                {
                    ((ServerEntitiesMemory)serverentitiesmemory.skinningentities.bothentitiesmemory).entitiesaimemory.skinningentitiesliveframe_array[0].setTLoopFB(id - 1);
                    ((ServerEntitiesMemory)serverentitiesmemory.skinningentities.bothentitiesmemory).entitiesaimemory.skinningentitiesliveframe_array[0].stepFrame();
                }

                return result;
            },
            () ->
            {
                int id0 = 16;
                int id1 = 17;
                boolean result = serverentitiesmemory.skinningentities != null && this.moveForward == 0 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopOffSet(id0, id1);
                if (result)
                {
                    ((ServerEntitiesMemory)serverentitiesmemory.skinningentities.bothentitiesmemory).entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopOffSet(id0 - 1, id1 - 1);
                    ((ServerEntitiesMemory)serverentitiesmemory.skinningentities.bothentitiesmemory).entitiesaimemory.skinningentitiesliveframe_array[0].stepFrame();
                }

                return result;
            },
            () ->
            {
                int id0 = 20, id1 = 21, id2 = 22, id3 = 23;
                boolean result = serverentitiesmemory.skinningentities != null && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setShoot(id0, id1, id2, id3, false, serverentitiesmemory.entitiesaimemory.skinningentitiesattack);
                if (result)
                {
                    int id;
                    int frame = serverentitiesmemory.frame_int_array[0];
                    if (frame >= serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].int_2d_array[id0][0] && frame <= serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].int_2d_array[id0][1])
                    {
                        id = id0 - 1;
                    }
                    else if (frame >= serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].int_2d_array[id1][0] && frame <= serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].int_2d_array[id1][1])
                    {
                        id = id1 - 1;
                    }
                    else if (frame >= serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].int_2d_array[id2][0] && frame <= serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].int_2d_array[id2][1])
                    {
                        id = id1 - 1;
                    }
                    else
                    {
                        id = id3 - 1;
                    }

                    ((ServerEntitiesMemory)serverentitiesmemory.skinningentities.bothentitiesmemory).entitiesaimemory.skinningentitiesliveframe_array[0].setFLoop(id);
                    ((ServerEntitiesMemory)serverentitiesmemory.skinningentities.bothentitiesmemory).entitiesaimemory.skinningentitiesliveframe_array[0].step = serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].step;
                    ((ServerEntitiesMemory)serverentitiesmemory.skinningentities.bothentitiesmemory).entitiesaimemory.skinningentitiesliveframe_array[0].stepFrame();
                }

                return result;
            },
            () ->
            {
                int id = 15;
                boolean result = serverentitiesmemory.skinningentities != null && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(id);
                if (result)
                {
                    ((ServerEntitiesMemory)serverentitiesmemory.skinningentities.bothentitiesmemory).entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(id - 1);
                    ((ServerEntitiesMemory)serverentitiesmemory.skinningentities.bothentitiesmemory).entitiesaimemory.skinningentitiesliveframe_array[0].stepFrame();
                }

                return result;
            },

            () -> this.isZeroMove() && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoop(0),
            () -> serverentitiesmemory.current_work_byte_array[workbytes.SIT()] == 1 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoopFB(1),
            () -> serverentitiesmemory.main_work_byte_array[workbytes.ATTACK()] == 1 && this.moveForward == 0 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopOffSet(3, 4),
            () -> serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setShoot(2, 11, 12, 13, false, serverentitiesmemory.entitiesaimemory.skinningentitiesattack),
            () -> serverentitiesmemory.main_work_byte_array[workbytes.ATTACK()] == 1 && this.moveForward != 0 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(3),
            () -> this.moveForward != 0 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(5),
            () -> serverentitiesmemory.current_work_byte_array[workbytes.ON_PAT()] == 1 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopFree(6, workbytes.ON_PAT()),
            () -> serverentitiesmemory.current_work_byte_array[workbytes.HARD_READY()] == 1 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopFree(7, workbytes.HARD_READY()),
            () -> serverentitiesmemory.current_work_byte_array[workbytes.SOFT_READY()] == 1 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopFree(8, workbytes.SOFT_READY()),
            () -> serverentitiesmemory.main_work_byte_array[workbytes.ATTACK()] == 1 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoop(9),
            () -> serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(10)
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
        return new IrohaRender(new EntitiesRenderMemory(), this.bothentitiesmemory.bothdata, RenderHelper.DATALOADER, this);
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
    }

    @Override
    public void createClientEntitiesMemory(SkinningEntities skinningentities, BothData bothdata, WorkBytes workbytes)
    {
        new ClientIrohaMemory(skinningentities, bothdata, workbytes);
    }
}

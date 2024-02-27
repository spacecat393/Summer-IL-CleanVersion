package com.nali.list.entities;

import com.nali.data.BothData;
import com.nali.render.EntitiesRenderMemory;
import com.nali.render.SkinningRender;
import com.nali.small.entities.bytes.WorkBytes;
import com.nali.small.entities.memory.ClientEntitiesMemory;
import com.nali.small.entities.memory.server.ServerEntitiesMemory;
import com.nali.small.entities.skinning.SkinningEntities;
import com.nali.small.entities.skinning.ai.frame.SkinningEntitiesLiveFrame;
import com.nali.summer.data.IbukiData;
import com.nali.summer.data.IrohaData;
import com.nali.summer.entities.bytes.IbukiBytes;
import com.nali.summer.entities.memory.client.ClientIbukiMemory;
import com.nali.summer.render.IbukiRender;
import com.nali.summer.render.RenderHelper;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;

import java.util.function.Supplier;

public class SummerIbuki extends SkinningEntities
{
    public static int eggPrimary = 0xfef5cb;
    public static int eggSecondary = 0xab6402;
    public final static DataParameter<Byte>[] BYTE_DATAPARAMETER_ARRAY = new DataParameter[IbukiData.MAX_SYNC];
    public final static DataParameter<Integer>[] INTEGER_DATAPARAMETER_ARRAY = new DataParameter[IbukiData.MAX_FRAME + IrohaData.MAX_FRAME];
    public final static DataParameter<Float>[] FLOAT_DATAPARAMETER_ARRAY = new DataParameter[2];

    public static int[] ATTACK_FRAME_INT_ARRAY = new int[]
    {
        491,
        494,
        496
    };
    public static int[][] FRAME_INT_2D_ARRAY = new int[][]
    {
        { 297, 347 },
        { 348, 431 },
        { 474, 486 },//start attack
        { 1265, 1281 },//loop move
        { 1282, 1312 },//end move
        { 263, 296 },//cafe walk
        { 585, 622 },
        { 101, 262 },
        { 432, 473 },
        { 0, 100 },
        { 487, 517 },
        { 518, 528 },
        { 529, 584 },
        { 623, 656 },// 13 start ride
        { 1214, 1264 },// 14 loop ride
        { 657, 707 },// 15 loop ride-move
        { 878, 919 },// 16 end ride-move
        { 1163, 1213 },// 17 ride-panic
        { 827, 877 },// 18 ride-destroy
        { 708, 724 },// 19 start ride-attack
        { 725, 758 },// 20 loop ride-attack
        { 759, 775 },// 21 end ride-attack
        { 776, 826 }// 22 ride-reload
    };

    public static int[] IV_INT_ARRAY = new int[]
    {
        9, 2882,
        9, 5893,
        4, 290,
        9, 969,
        9, 624,
        14, 38
    };
    public static float[] ROTATION_FLOAT_ARRAY = new float[]
    {
        180.0F, -135.0F,
        -180.0F, -135.0F
    };
    public static float[] TRANSFORM_FLOAT_ARRAY = new float[]
    {
        0.0F, -0.55F * 0.5F, 0.0F,
        0.0F, -1.0F * 0.5F, 0.09F * 0.5F,
        0.025F * 0.5F, -1.3F * 0.5F, 0.11F * 0.5F,
        0.025F * 0.5F, -1.25F * 0.5F, 0.11F * 0.5F
    };

    static
    {
        for (int i = 0; i < BYTE_DATAPARAMETER_ARRAY.length; ++i)
        {
            BYTE_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerIbuki.class, DataSerializers.BYTE);
        }

        for (int i = 0; i < INTEGER_DATAPARAMETER_ARRAY.length; ++i)
        {
            INTEGER_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerIbuki.class, DataSerializers.VARINT);
        }

        for (int i = 0; i < FLOAT_DATAPARAMETER_ARRAY.length; ++i)
        {
            FLOAT_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerIbuki.class, DataSerializers.FLOAT);
        }
    }

    public SummerIbuki(World world)
    {
        super(world);
    }

    @Override
    public void updateClient()
    {
        ClientIbukiMemory cliententitiesmemory = (ClientIbukiMemory)this.bothentitiesmemory;
        SkinningRender skinningrender = (SkinningRender)cliententitiesmemory.objectrender;
        BothData bothdata = cliententitiesmemory.bothdata;
        int frame = skinningrender.frame_int_array[0];

        if (this.ticksExisted % 200 == 0)
        {
            skinningrender.model_boolean_array[0] = false;
            skinningrender.model_boolean_array[1] = false;
            skinningrender.model_boolean_array[11] = false;
            skinningrender.model_boolean_array[2] = true;
            skinningrender.model_boolean_array[12] = true;
            cliententitiesmemory.client_eyes_tick = 20;
        }
        else if (--cliententitiesmemory.client_eyes_tick <= 0)
        {
            skinningrender.model_boolean_array[0] = true;
            skinningrender.model_boolean_array[1] = true;
            skinningrender.model_boolean_array[11] = true;
            skinningrender.model_boolean_array[2] = false;
            skinningrender.model_boolean_array[12] = false;
        }

        float scale = skinningrender.entitiesrendermemory.scale;

        if (frame > 296 && frame < 348)
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
    public void updateRendering(EntityDataManager entitydatamanager)
    {
        super.updateRendering(entitydatamanager);
        ClientEntitiesMemory cliententitiesmemory = (ClientEntitiesMemory)this.bothentitiesmemory;
        IbukiRender ibukirender = (IbukiRender)cliententitiesmemory.objectrender;
        ibukirender.iroharender.frame_int_array[0] = entitydatamanager.get(this.getIntegerDataParameterArray()[1]);
    }

    @Override
    public void initFakeFrame()
    {
        ClientEntitiesMemory cliententitiesmemory = (ClientEntitiesMemory)this.bothentitiesmemory;
        SkinningRender skinningrender = (SkinningRender)cliententitiesmemory.objectrender;
        skinningrender.model_boolean_array[0] = false;
        skinningrender.model_boolean_array[1] = false;
        skinningrender.model_boolean_array[11] = false;
        skinningrender.model_boolean_array[2] = true;
        skinningrender.model_boolean_array[12] = true;
    }

    @Override
    public BothData createBothData()
    {
        return new IbukiData();
    }

    @Override
    public WorkBytes createWorkBytes()
    {
        return new IbukiBytes();
    }

    @Override
    public void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.05D);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(12.0D);
    }

    @Override
    public void createServer()
    {
        ServerEntitiesMemory serverentitiesmemory = (ServerEntitiesMemory)this.bothentitiesmemory;
        WorkBytes workbytes = serverentitiesmemory.workbytes;
        serverentitiesmemory.entitiesaimemory.skinningentitiesplaywith.clasz = SummerIroha.class;

        serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array = new SkinningEntitiesLiveFrame[1];

        serverentitiesmemory.entitiesaimemory.skinningentitiesattack.attack_frame_int_array = ATTACK_FRAME_INT_ARRAY;
        serverentitiesmemory.entitiesaimemory.skinningentitiesattack.max_ammo = 32;
        serverentitiesmemory.entitiesaimemory.skinningentitiesattack.minimum_distance = 17.0F;

        serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0] = new SkinningEntitiesLiveFrame(this, 0, FRAME_INT_2D_ARRAY);
        serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].condition_boolean_supplier_array = new Supplier[]
        {
            () -> this.isZeroMove() && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoop(0),
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
    public void updateServer()
    {
        ServerEntitiesMemory serverentitiesmemory = (ServerEntitiesMemory)this.bothentitiesmemory;
        super.updateServer();

//        if (serverentitiesmemory.entitiesaimemory.skinningentitiesplaywith.playwith_skinningentities != null && ((WorldServer)this.world).getEntityFromUuid(serverentitiesmemory.entitiesaimemory.skinningentitiesplaywith.playwith_skinningentities.getUniqueID()) == null)
//        {
//            serverentitiesmemory.entitiesaimemory.skinningentitiesplaywith.playwith_skinningentities = null;
//        }

        if (!serverentitiesmemory.entitiesaimemory.skinningentitiesplaywith.should_play && (serverentitiesmemory.sync_byte_array[0] & 128) == 128)
        {
            serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].lock = false;
            serverentitiesmemory.sync_byte_array[0] ^= (byte)128;
            this.getDataManager().set(this.getByteDataParameterArray()[0], serverentitiesmemory.sync_byte_array[0]);
        }
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
        ClientEntitiesMemory cliententitiesmemory = (ClientEntitiesMemory)this.bothentitiesmemory;
        cliententitiesmemory.itemlayerrender.iv_int_array = IV_INT_ARRAY;
        cliententitiesmemory.itemlayerrender.rotation_float_array = ROTATION_FLOAT_ARRAY;
        cliententitiesmemory.itemlayerrender.transform_float_array = TRANSFORM_FLOAT_ARRAY;
        return new IbukiRender(new EntitiesRenderMemory(), this.bothentitiesmemory.bothdata, RenderHelper.DATALOADER, this);
    }

    @Override
    public void onShouldPlayWith()
    {
        super.onShouldPlayWith();
        ServerEntitiesMemory serverentitiesmemory = (ServerEntitiesMemory)this.bothentitiesmemory;
        SkinningEntities playwith_skinningentities = serverentitiesmemory.entitiesaimemory.skinningentitiesplaywith.playwith_skinningentities;

        DataParameter<Byte> byte_dataparameter = this.getByteDataParameterArray()[0];
        serverentitiesmemory.sync_byte_array[0] = this.getDataManager().get(byte_dataparameter);
        if ((serverentitiesmemory.sync_byte_array[0] & 128) == 0)
        {
            serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].lock = true;
            serverentitiesmemory.sync_byte_array[0] ^= (byte)128;
            this.getDataManager().set(byte_dataparameter, serverentitiesmemory.sync_byte_array[0]);
        }
        this.getDataManager().set(this.getIntegerDataParameterArray()[1], playwith_skinningentities.getDataManager().get(playwith_skinningentities.getIntegerDataParameterArray()[0]));
        this.getDataManager().set(this.getFloatDataParameterArray()[1], playwith_skinningentities.getDataManager().get(playwith_skinningentities.getFloatDataParameterArray()[0]));
    }

    @Override
    public void collideWithNearbyEntities()
    {
        if (this.world.isRemote || ((ServerEntitiesMemory)this.bothentitiesmemory).entitiesaimemory.skinningentitiesplaywith.playwith_skinningentities == null || !((ServerEntitiesMemory)this.bothentitiesmemory).entitiesaimemory.skinningentitiesplaywith.should_play)
        {
            super.collideWithNearbyEntities();
        }
    }

    @Override
    public boolean canBePushed()
    {
        return this.world.isRemote || ((ServerEntitiesMemory)this.bothentitiesmemory).entitiesaimemory.skinningentitiesplaywith.playwith_skinningentities == null || !((ServerEntitiesMemory)this.bothentitiesmemory).entitiesaimemory.skinningentitiesplaywith.should_play;
    }

    @Override
    public ClientEntitiesMemory createClientEntitiesMemory(BothData bothdata, WorkBytes workbytes)
    {
        return new ClientIbukiMemory(bothdata, workbytes);
    }
}

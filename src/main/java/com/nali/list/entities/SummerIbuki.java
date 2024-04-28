package com.nali.list.entities;

import com.nali.data.BothData;
import com.nali.list.render.IbukiRender;
import com.nali.render.EntitiesRenderMemory;
import com.nali.render.SkinningRender;
import com.nali.small.entities.bytes.WorkBytes;
import com.nali.small.entities.memory.client.ClientEntitiesMemory;
import com.nali.small.entities.memory.server.ServerEntitiesMemory;
import com.nali.small.entities.skinning.SkinningEntities;
import com.nali.small.entities.skinning.ai.frame.SkinningEntitiesLiveFrame;
import com.nali.small.entities.sounds.Sounds;
import com.nali.summer.data.IbukiData;
import com.nali.summer.data.IrohaData;
import com.nali.summer.entities.bytes.IbukiBytes;
import com.nali.summer.entities.memory.client.ClientIbukiMemory;
import com.nali.summer.entities.sounds.IbukiSounds;
import com.nali.summer.render.SummerSoundRender;
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

    public static BothData BOTHDATA = new IbukiData();
    public static WorkBytes WORKBYTES = new IbukiBytes();
    public static Sounds SOUNDS = new IbukiSounds();

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
//            skinningrender.model_byte_array[0 / 8] &= 254;//255 - Math.pow(2, 0 % 8)
//            skinningrender.model_byte_array[1 / 8] &= 253;//255 - Math.pow(2, 1 % 8)
            skinningrender.model_byte_array[0] &= 254 & 253;
            skinningrender.model_byte_array[2 / 8] |= 4;//Math.pow(2, 2 % 8)
            skinningrender.model_byte_array[11 / 8] &= 247;//255 - Math.pow(2, 11 % 8)
            skinningrender.model_byte_array[12 / 8] |= 16;//Math.pow(2, 12 % 8)
            cliententitiesmemory.client_eyes_tick = 20;
        }
        else if (--cliententitiesmemory.client_eyes_tick <= 0)
        {
//            skinningrender.model_byte_array[0 / 8] |= 1;//Math.pow(2, 0 % 8)
//            skinningrender.model_byte_array[1 / 8] |= 2;//Math.pow(2, 1 % 8)
            skinningrender.model_byte_array[0] |= 1 | 2;
            skinningrender.model_byte_array[2 / 8] &= 251;//255 - Math.pow(2, 2 % 8)
            skinningrender.model_byte_array[11 / 8] |= 8;//Math.pow(2, 11 % 8)
            skinningrender.model_byte_array[12 / 8] &= 239;//255 - Math.pow(2, 12 % 8)
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
//        skinningrender.model_byte_array[0 / 8] &= 254;//255 - Math.pow(2, 0 % 8)
//        skinningrender.model_byte_array[1 / 8] &= 253;//255 - Math.pow(2, 1 % 8)
        skinningrender.model_byte_array[0] &= 254 & 253;
        skinningrender.model_byte_array[2 / 8] |= 4;//Math.pow(2, 2 % 8)
        skinningrender.model_byte_array[11 / 8] &= 247;//255 - Math.pow(2, 11 % 8)
        skinningrender.model_byte_array[12 / 8] |= 16;//Math.pow(2, 12 % 8)
    }

    @Override
    public BothData createBothData()
    {
        return BOTHDATA;
    }

    @Override
    public WorkBytes createWorkBytes()
    {
        return WORKBYTES;
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
        serverentitiesmemory.entitiesaimemory.skinningentitiesattack.max_magic_point = 32;
        serverentitiesmemory.entitiesaimemory.skinningentitiesattack.minimum_distance = 17.0F;

        serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0] = new SkinningEntitiesLiveFrame(this, 0, FRAME_INT_2D_ARRAY);
        serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].condition_boolean_supplier_array = new Supplier[]
        {
            () -> this.isZeroMove() && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoop(0),
            () -> (serverentitiesmemory.current_work_byte_array[workbytes.SIT() / 8] >> workbytes.SIT() % 8 & 1) == 1 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(1),
            () -> (serverentitiesmemory.main_work_byte_array[workbytes.ATTACK() / 8] >> workbytes.ATTACK() % 8 & 1) == 1 && this.moveForward == 0 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopOffSet(3, 4),
            () -> serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setShoot(2, 10, 11, 12, false, serverentitiesmemory.entitiesaimemory.skinningentitiesattack),
            () -> (serverentitiesmemory.main_work_byte_array[workbytes.ATTACK() / 8] >> workbytes.ATTACK() % 8 & 1) == 1 && this.moveForward != 0 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(3),
            () -> this.moveForward != 0 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(5),
            () -> (serverentitiesmemory.statentitiesmemory.stat & 4) == 4 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopFree(6, (byte)4),
            () -> ((serverentitiesmemory.statentitiesmemory.stat & 1) == 1 || (serverentitiesmemory.statentitiesmemory.stat & 2) == 2 || (serverentitiesmemory.statentitiesmemory.stat & 8) == 8) && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopFree(7, (byte)(1 + 2 + 8)),
            () -> (serverentitiesmemory.main_work_byte_array[workbytes.ATTACK() / 8] >> workbytes.ATTACK() % 8 & 1) == 1 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(8),
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
        return new IbukiRender(new EntitiesRenderMemory(), this);
    }

    @Override
    public Sounds createSounds()
    {
        return SOUNDS;
    }

    @Override
    public Object createSoundRender()
    {
        return new SummerSoundRender();
    }

    @Override
    public int[] getIVIntArray()
    {
        return ClientIbukiMemory.IV_INT_ARRAY;
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
    public void createClientEntitiesMemory(SkinningEntities skinningentities, BothData bothdata, WorkBytes workbytes)
    {
        new ClientIbukiMemory(skinningentities, bothdata, workbytes);
    }
}

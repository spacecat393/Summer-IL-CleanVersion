package com.nali.list.entities;

import com.nali.data.BothData;
import com.nali.list.render.SSHimiRender;
import com.nali.render.EntitiesRenderMemory;
import com.nali.render.SkinningRender;
import com.nali.small.entities.bytes.WorkBytes;
import com.nali.small.entities.memory.client.ClientEntitiesMemory;
import com.nali.small.entities.memory.server.ServerEntitiesMemory;
import com.nali.small.entities.skinning.SkinningEntities;
import com.nali.small.entities.skinning.ai.frame.SkinningEntitiesLiveFrame;
import com.nali.small.entities.sounds.Sounds;
import com.nali.summer.data.SSHimiData;
import com.nali.summer.entities.bytes.SSHimiBytes;
import com.nali.summer.entities.memory.client.ClientSSHimiMemory;
import com.nali.summer.entities.sounds.SSHimiSounds;
import com.nali.summer.render.SummerSoundRender;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;

import java.util.function.Supplier;

public class SummerSSHimi extends SkinningEntities
{
    public static int eggPrimary = 0xBE9478;
    public static int eggSecondary = 0xFFF6AE;

    public static BothData BOTHDATA = new SSHimiData();
    public static WorkBytes WORKBYTES = new SSHimiBytes();
    public static Sounds SOUNDS = new SSHimiSounds();

    public final static DataParameter<Byte>[] BYTE_DATAPARAMETER_ARRAY = new DataParameter[SSHimiData.MAX_SYNC];
    public final static DataParameter<Integer>[] INTEGER_DATAPARAMETER_ARRAY = new DataParameter[SSHimiData.MAX_FRAME];
    public final static DataParameter<Float>[] FLOAT_DATAPARAMETER_ARRAY = new DataParameter[1];

    public static int[] ATTACK_FRAME_INT_ARRAY = new int[]
    {
        203
    };
    public static int[][] FRAME_INT_2D_ARRAY = new int[][]
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
    };

    static
    {
        for (int i = 0; i < BYTE_DATAPARAMETER_ARRAY.length; ++i)
        {
            BYTE_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerSSHimi.class, DataSerializers.BYTE);
        }

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
        ClientEntitiesMemory cliententitiesmemory = (ClientEntitiesMemory)this.bothentitiesmemory;
        SkinningRender skinningrender = (SkinningRender)cliententitiesmemory.objectrender;
        BothData bothdata = cliententitiesmemory.bothdata;
        int frame = skinningrender.frame_int_array[0];

        if (frame > 267 && frame < 284)
        {
//            skinningrender.model_byte_array[0 / 8] &= 254;//255 - Math.pow(2, 0 % 8)
//            skinningrender.model_byte_array[1 / 8] &= 253;//255 - Math.pow(2, 1 % 8)
//            skinningrender.model_byte_array[2 / 8] &= 251;//255 - Math.pow(2, 2 % 8)
//            skinningrender.model_byte_array[3 / 8] &= 247;//255 - Math.pow(2, 3 % 8)
//            skinningrender.model_byte_array[4 / 8] &= 239;//255 - Math.pow(2, 4 % 8)
//            skinningrender.model_byte_array[6 / 8] &= 191;//255 - Math.pow(2, 6 % 8)
            skinningrender.model_byte_array[0] &= 254 & 253 & 251 & 247 & 239 & 191;
//            skinningrender.model_byte_array[11 / 8] &= 247;//255 - Math.pow(2, 11 % 8)
//            skinningrender.model_byte_array[12 / 8] &= 239;//255 - Math.pow(2, 12 % 8)
            skinningrender.model_byte_array[1] &= 247 & 239;
        }
        else
        {
//            skinningrender.model_byte_array[0 / 8] |= 1;//Math.pow(2, 0 % 8)
//            skinningrender.model_byte_array[1 / 8] |= 2;//Math.pow(2, 1 % 8)
//            skinningrender.model_byte_array[2 / 8] |= 4;//Math.pow(2, 2 % 8)
//            skinningrender.model_byte_array[3 / 8] |= 8;//Math.pow(2, 3 % 8)
//            skinningrender.model_byte_array[4 / 8] |= 16;//Math.pow(2, 4 % 8)
//            skinningrender.model_byte_array[6 / 8] |= 64;//Math.pow(2, 6 % 8)
            skinningrender.model_byte_array[0] |= 1 | 2 | 4 | 8 | 16 | 64;
//            skinningrender.model_byte_array[11 / 8] |= 8;//Math.pow(2, 11 % 8)
//            skinningrender.model_byte_array[12 / 8] |= 16;//Math.pow(2, 12 % 8)
            skinningrender.model_byte_array[1] |= 8 | 16;
        }

        float scale = skinningrender.entitiesrendermemory.scale;
        if (frame < 379 || (frame > 590 && frame < 642))
        {
            this.width = 1.7F * scale;
            this.height = 1.5F * scale;
//            skinningrender.model_byte_array[8 / 8] |= 1;//Math.pow(2, 8 % 8)
//            skinningrender.model_byte_array[9 / 8] |= 2;//Math.pow(2, 9 % 8)
//            skinningrender.model_byte_array[10 / 8] |= 4;//Math.pow(2, 10 % 8)
            skinningrender.model_byte_array[1] |= 1 | 2 | 4;
        }
        else
        {
            this.width = bothdata.Width() * scale;
            this.height = bothdata.Height() * scale;
//            skinningrender.model_byte_array[8 / 8] &= 254;//255 - Math.pow(2, 8 % 8)
//            skinningrender.model_byte_array[9 / 8] &= 253;//255 - Math.pow(2, 9 % 8)
//            skinningrender.model_byte_array[10 / 8] &= 251;//255 - Math.pow(2, 10 % 8)
            skinningrender.model_byte_array[1] &= 254 & 253 & 251;
        }

        skinningrender.model_byte_array[5 / 8] &= 223;//255 - Math.pow(2, 5 % 8)
    }

    @Override
    public void initFakeFrame()
    {
        ClientEntitiesMemory cliententitiesmemory = (ClientEntitiesMemory)this.bothentitiesmemory;
        ((SkinningRender)cliententitiesmemory.objectrender).frame_int_array[0] = 379;
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
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(40.0D);
    }

    @Override
    public void createServer()
    {
        ServerEntitiesMemory serverentitiesmemory = (ServerEntitiesMemory)this.bothentitiesmemory;
        WorkBytes workbytes = serverentitiesmemory.workbytes;
        serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array = new SkinningEntitiesLiveFrame[1];

        serverentitiesmemory.entitiesaimemory.skinningentitiesattack.attack_frame_int_array = ATTACK_FRAME_INT_ARRAY;
        serverentitiesmemory.entitiesaimemory.skinningentitiesattack.max_magic_point = 1;
        serverentitiesmemory.entitiesaimemory.skinningentitiesattack.minimum_distance = 32.0F;

        serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0] = new SkinningEntitiesLiveFrame(this, 0, FRAME_INT_2D_ARRAY);
        serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].condition_boolean_supplier_array = new Supplier[]
        {
            () -> this.isZeroMove() && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoop(0),
            () -> (serverentitiesmemory.current_work_byte_array[workbytes.SIT() / 8] >> workbytes.SIT() % 8 & 1) == 1 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoopFB(1),
            () -> (serverentitiesmemory.main_work_byte_array[workbytes.ATTACK() / 8] >> workbytes.ATTACK() % 8 & 1) == 1 && this.moveForward == 0 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopOffSet(3, 4),
            () -> serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setShoot(2, 11, 12, 13, false, serverentitiesmemory.entitiesaimemory.skinningentitiesattack),
            () -> (serverentitiesmemory.main_work_byte_array[workbytes.ATTACK() / 8] >> workbytes.ATTACK() % 8 & 1) == 1 && this.moveForward != 0 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(3),
            () -> this.moveForward != 0 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(5),
            () -> ((serverentitiesmemory.statentitiesmemory.stat & 1) == 1 || (serverentitiesmemory.statentitiesmemory.stat & 8) == 8) && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopFree(6, (byte)(1 + 8)),
            () -> (serverentitiesmemory.statentitiesmemory.stat & 4) == 4 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopFree(7, (byte)4),
            () -> (serverentitiesmemory.statentitiesmemory.stat & 2) == 2 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopFree(8, (byte)2),
            () -> (serverentitiesmemory.main_work_byte_array[workbytes.ATTACK() / 8] >> workbytes.ATTACK() % 8 & 1) == 1 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoop(9),
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
        return new SSHimiRender(new EntitiesRenderMemory(), this);
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
        return ClientSSHimiMemory.IV_INT_ARRAY;
    }

    @Override
    public void createClientEntitiesMemory(SkinningEntities skinningentities, BothData bothdata, WorkBytes workbytes)
    {
        new ClientSSHimiMemory(skinningentities, bothdata, workbytes);
    }
}

package com.nali.list.entities;

import com.nali.data.BothData;
import com.nali.list.render.NasuRender;
import com.nali.small.entities.bytes.WorkBytes;
import com.nali.small.entities.memory.client.ClientEntitiesMemory;
import com.nali.small.entities.memory.server.ServerEntitiesMemory;
import com.nali.small.entities.skinning.SkinningEntities;
import com.nali.small.entities.skinning.ai.frame.SkinningEntitiesLiveFrame;
import com.nali.small.entities.sounds.Sounds;
import com.nali.summer.data.both.NasuBothData;
import com.nali.summer.entities.bytes.NasuBytes;
import com.nali.summer.entities.memory.client.ClientNasuMemory;
import com.nali.summer.entities.sounds.NasuSounds;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.function.Supplier;

public class SummerNasu extends SkinningEntities
{
    public static int eggPrimary = 0xF1F6F9;
    public static int eggSecondary = 0xFB7290;

    public static BothData BOTHDATA = new NasuBothData();
    public static WorkBytes WORKBYTES = new NasuBytes();
    public static Sounds SOUNDS = new NasuSounds();

    public final static DataParameter<Byte>[] BYTE_DATAPARAMETER_ARRAY = new DataParameter[NasuBothData.MAX_SYNC];
    public final static DataParameter<Integer>[] INTEGER_DATAPARAMETER_ARRAY = new DataParameter[NasuBothData.MAX_FRAME];
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
        for (int i = 0; i < BYTE_DATAPARAMETER_ARRAY.length; ++i)
        {
            BYTE_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerNasu.class, DataSerializers.BYTE);
        }

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
    @SideOnly(Side.CLIENT)
    public void updateClient()
    {
        ClientEntitiesMemory cliententitiesmemory = (ClientEntitiesMemory)this.bothentitiesmemory;
        NasuRender skinningrender = (NasuRender)cliententitiesmemory.objectrender;
        BothData bothdata = cliententitiesmemory.bothdata;
        int frame = skinningrender.frame_int_array[0];

        if (frame > 255)
        {
            skinningrender.model_byte_array[0 / 8] |= 1;//Math.pow(2, 0 % 8)
            skinningrender.model_byte_array[10 / 8] |= 4;//Math.pow(2, 10 % 8)
        }
        else
        {
            skinningrender.model_byte_array[0 / 8] &= 254;//255 - Math.pow(2, 0 % 8)
            skinningrender.model_byte_array[10 / 8] &= 251;//255 - Math.pow(2, 10 % 8)
        }

        skinningrender.model_byte_array[8 / 8] = (byte)((frame > 313 && frame < 338) || (frame > 341 && frame < 383) || (frame > 827 && frame < 850)
        ? skinningrender.model_byte_array[8 / 8] | 1//Math.pow(2, 8 % 8)
        : skinningrender.model_byte_array[8 / 8] & 254);//255 - Math.pow(2, 8 % 8)
        skinningrender.model_byte_array[9 / 8] = (byte)((frame > -1 && frame < 226) || (frame > 306 && frame < 388) || (frame > 868 && frame < 1029)
        ? skinningrender.model_byte_array[9 / 8] | 2//Math.pow(2, 9 % 8)
        : skinningrender.model_byte_array[9 / 8] & 253//255 - Math.pow(2, 9 % 8)
        );

        float scale = skinningrender.entitiesrendermemory.scale;
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
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5.0D);
    }

    @Override
    public void createServer()
    {
        ServerEntitiesMemory serverentitiesmemory = (ServerEntitiesMemory)this.bothentitiesmemory;
        WorkBytes workbytes = serverentitiesmemory.workbytes;
        serverentitiesmemory.entitiesaimemory.skinningentitiesattack.attack_frame_int_array = ATTACK_FRAME_INT_ARRAY;
//        serverentitiesmemory.entitiesaimemory.skinningentitiesattack.max_magic_point = 16;
        serverentitiesmemory.entitiesaimemory.skinningentitiesattack.minimum_distance = 8.0F;

        serverentitiesmemory.entitiesaimemory.skinningentitiesheal.heal_frame_int_array = HEAL_FRAME_INT_ARRAY;

        serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array = new SkinningEntitiesLiveFrame[1];
        serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0] = new SkinningEntitiesLiveFrame(this, 0, FRAME_INT_2D_ARRAY);
        serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].condition_boolean_supplier_array = new Supplier[]
        {
            () -> this.isZeroMove() && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoop(0),
            () -> (serverentitiesmemory.current_work_byte_array[workbytes.SIT() / 8] >> workbytes.SIT() % 8 & 1) == 1 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(1),
            () -> (serverentitiesmemory.main_work_byte_array[workbytes.ATTACK() / 8] >> workbytes.ATTACK() % 8 & 1) == 1 && this.moveForward == 0 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopOffSet(3, 4),
            () -> serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setShoot(2, 10, 11, 12, true, serverentitiesmemory.entitiesaimemory.skinningentitiesattack),
            () -> serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setHeal(13, serverentitiesmemory.entitiesaimemory.skinningentitiesheal),
            () -> (serverentitiesmemory.main_work_byte_array[workbytes.ATTACK() / 8] >> workbytes.ATTACK() % 8 & 1) == 1 && this.moveForward != 0 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(3),
            () -> this.moveForward != 0 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(5),
            () -> (serverentitiesmemory.statentitiesmemory.stat & 4) == 4 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopFree(6, (byte)4),
            () -> ((serverentitiesmemory.statentitiesmemory.stat & 1) == 1 || (serverentitiesmemory.statentitiesmemory.stat & 2) == 2 || (serverentitiesmemory.statentitiesmemory.stat & 8) == 8) && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopFree(7, (byte)(1 + 2 + 8)),
            () -> (serverentitiesmemory.main_work_byte_array[workbytes.ATTACK() / 8] >> workbytes.ATTACK() % 8 & 1) == 1 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(8),
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

//    @Override
//    @SideOnly(Side.CLIENT)
//    public Object createObjectRender()
//    {
//        return new NasuRender(new EntitiesRenderMemory(), this);
//    }

    @Override
    public Sounds createSounds()
    {
        return SOUNDS;
    }

//    @Override
//    @SideOnly(Side.CLIENT)
//    public Object createSoundRender()
//    {
////        return SoundRender.getSoundRender(DATALOADER);
//        return new NoSoundRender();
//    }
//
//    @Override
//    @SideOnly(Side.CLIENT)
//    public int[] getIVIntArray()
//    {
//        return ClientNasuMemory.IV_INT_ARRAY;
//    }

    @Override
    @SideOnly(Side.CLIENT)
    public void createClientEntitiesMemory(SkinningEntities skinningentities, BothData bothdata, WorkBytes workbytes)
    {
        new ClientNasuMemory(skinningentities, bothdata, workbytes);
    }
}

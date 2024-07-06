package com.nali.list.entity;

import com.nali.data.BothData;
import com.nali.list.render.s.RenderResa;
import com.nali.small.entities.bytes.WorkBytes;
import com.nali.small.entities.memory.server.ServerEntitiesMemory;
import com.nali.small.entities.skinning.SkinningEntities;
import com.nali.small.entities.skinning.ai.frame.SkinningEntitiesLiveFrame;
import com.nali.small.entities.sounds.Sounds;
import com.nali.small.entity.EntityLeInv;
import com.nali.summer.da.both.BothDaResa;
import com.nali.summer.entity.memo.client.resa.ClientResa;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.function.Supplier;

public class SummerResa extends EntityLeInv
{
    public static int eggPrimary = 0x4e466d;
    public static int eggSecondary = 0xbdb5ff;

    public final static DataParameter<Byte>[] BYTE_DATAPARAMETER_ARRAY = new DataParameter[BothDaResa.MAX_SYNC];
    public final static DataParameter<Integer>[] INTEGER_DATAPARAMETER_ARRAY = new DataParameter[BothDaResa.MAX_FRAME];
    public final static DataParameter<Float>[] FLOAT_DATAPARAMETER_ARRAY = new DataParameter[1];

    public static int[] ATTACK_FRAME_INT_ARRAY = new int[]
    {
        369,
        375
    };
    public static int[][] FRAME_INT_2D_ARRAY = new int[][]
    {
        { 601, 651 },
        { 500, 600 },
        { 350, 394 },
        { 261, 277 },
        { 278, 298 },
        { 227, 260 },
        { 458, 499 },
        { 126, 226 },
        { 299, 349 },
        { 0, 125 },
        { 364, 394 },
        { 395, 405 },
        { 406, 457 }
    };

    static
    {
        for (int i = 0; i < BYTE_DATAPARAMETER_ARRAY.length; ++i)
        {
            BYTE_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerResa.class, DataSerializers.BYTE);
        }

        for (int i = 0; i < INTEGER_DATAPARAMETER_ARRAY.length; ++i)
        {
            INTEGER_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerResa.class, DataSerializers.VARINT);
        }

        for (int i = 0; i < FLOAT_DATAPARAMETER_ARRAY.length; ++i)
        {
            FLOAT_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerResa.class, DataSerializers.FLOAT);
        }
    }

    public SummerResa(World world)
    {
        super(world);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void updateClient()
    {
        ClientResa cliententitiesmemory = (ClientResa)this.bothentitiesmemory;
        RenderResa skinningrender = (RenderResa)cliententitiesmemory.objectrender;
        BothData bothdata = cliententitiesmemory.bothdata;
        int frame = skinningrender.frame_int_array[0];

        if (this.ticksExisted % 200 == 0)
        {
            skinningrender.model_byte_array[0 / 8] &= 255-1;//255 - Math.pow(2, 0 % 8)
            skinningrender.model_byte_array[5 / 8] |= 32;//Math.pow(2, 5 % 8)
            skinningrender.model_byte_array[8 / 8] &= 255-1;//255 - Math.pow(2, 8 % 8)
            cliententitiesmemory.client_eyes_tick = 20;
        }
        else if (--cliententitiesmemory.client_eyes_tick <= 0)
        {
            skinningrender.model_byte_array[0 / 8] |= 1;//Math.pow(2, 0 % 8)
            skinningrender.model_byte_array[5 / 8] &= 255-32;//255 - Math.pow(2, 5 % 8)
            skinningrender.model_byte_array[8 / 8] |= 1;//Math.pow(2, 8 % 8)
        }

        if (frame > 125 && frame < 227)
        {
            skinningrender.model_byte_array[6 / 8] |= 64;//Math.pow(2, 6 % 8)
        }
        else
        {
            skinningrender.model_byte_array[6 / 8] &= 255-64;//255 - Math.pow(2, 6 % 8)
        }

        float scale = skinningrender.entitiesrendermemory.scale;
        if (frame > 600 && frame < 652)
        {
            this.width = 1.5F * scale;
            this.height = 0.2F * scale;
        }
        else
        {
            this.width = bothdata.Width() * scale;
            this.height = bothdata.Height() * scale;
        }

//        skinningrender.model_byte_array[3 / 8] &= 255-8;//255 - Math.pow(2, 3 % 8)
    }

//    @Override
//    @SideOnly(Side.CLIENT)
//    public void initFakeFrame()
//    {
//        ClientEntitiesMemory cliententitiesmemory = (ClientEntitiesMemory)this.bothentitiesmemory;
//        ResaRender skinningrender = (ResaRender)cliententitiesmemory.objectrender;
//        skinningrender.model_byte_array[0 / 8] &= 255-1;//255 - Math.pow(2, 0 % 8)
////        skinningrender.model_byte_array[5 / 8] |= 32;//Math.pow(2, 5 % 8)
//        skinningrender.model_byte_array[8 / 8] &= 255-1;//255 - Math.pow(2, 8 % 8)
//    }

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
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(15.0D);
    }

    @Override
    public void createServer()
    {
        ServerEntitiesMemory serverentitiesmemory = (ServerEntitiesMemory)this.bothentitiesmemory;
        WorkBytes workbytes = serverentitiesmemory.workbytes;
        serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array = new SkinningEntitiesLiveFrame[1];

        serverentitiesmemory.entitiesaimemory.skinningentitiesattack.attack_frame_int_array = ATTACK_FRAME_INT_ARRAY;
        serverentitiesmemory.entitiesaimemory.skinningentitiesattack.max_magic_point = 4;
        serverentitiesmemory.entitiesaimemory.skinningentitiesattack.minimum_distance = 12.0F;

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
//        return new ResaRender(new EntitiesRenderMemory(), this);
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
//        return ClientResaMemory.IV_INT_ARRAY;
//    }

    @Override
    @SideOnly(Side.CLIENT)
    public void createClientEntitiesMemory(SkinningEntities skinningentities, BothData bothdata, WorkBytes workbytes)
    {
        new ClientResa(skinningentities, bothdata, workbytes);
    }
}

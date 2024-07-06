package com.nali.list.entity;

import com.nali.data.BothData;
import com.nali.list.render.s.RenderYuzu;
import com.nali.small.entities.bytes.WorkBytes;
import com.nali.small.entities.memory.client.ClientEntitiesMemory;
import com.nali.small.entities.memory.server.ServerEntitiesMemory;
import com.nali.small.entities.skinning.SkinningEntities;
import com.nali.small.entities.skinning.ai.frame.SkinningEntitiesLiveFrame;
import com.nali.small.entities.sounds.Sounds;
import com.nali.small.entity.EntityLeInv;
import com.nali.summer.da.both.BothDaYuzu;
import com.nali.summer.entity.memo.client.yuzu.ClientYuzu;
import com.nali.system.opengl.memory.OpenGLObjectMemory;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.function.Supplier;

import static com.nali.list.data.SummerData.TEXTURE_STEP;
import static com.nali.system.ClientLoader.OBJECT_LIST;

public class SummerYuzu extends EntityLeInv
{
    public static int eggPrimary = 0xfbdad0;
    public static int eggSecondary = 0xfc6c78;

    public final static DataParameter<Byte>[] BYTE_DATAPARAMETER_ARRAY = new DataParameter[BothDaYuzu.MAX_SYNC];
    public final static DataParameter<Integer>[] INTEGER_DATAPARAMETER_ARRAY = new DataParameter[BothDaYuzu.MAX_FRAME];
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
    @SideOnly(Side.CLIENT)
    public void updateClient()
    {
        ClientEntitiesMemory cliententitiesmemory = (ClientEntitiesMemory)this.bothentitiesmemory;
        RenderYuzu skinningrender = (RenderYuzu)cliententitiesmemory.objectrender;
        BothData bothdata = cliententitiesmemory.bothdata;
        int frame = skinningrender.frame_int_array[0];

        float scale = skinningrender.entitiesrendermemory.scale;
        if (frame > 195 && frame < 222)
        {
//            skinningrender.texture_index_int_array[8] = 66;
//            skinningrender.texture_map.put(skinningrender.dataloader.openglobjectmemory_array[skinningrender.clientdata.StartPart() + 8].element_array_buffer, 66);
//            skinningrender.texture_map.put(((OpenGLObjectMemory)skinningrender.dataloader.object_array[skinningrender.clientdata.StartPart() + 8]).element_array_buffer, 66);
            skinningrender.texture_map.put(((OpenGLObjectMemory)OBJECT_LIST.get(skinningrender.clientdata.StartPart() + 8)).element_array_buffer, 66 + TEXTURE_STEP);
        }
        else if ((frame > 221 && frame < 250) || (frame > 354 && frame < 429))
        {
//            skinningrender.texture_index_int_array[8] = 67;
//            skinningrender.texture_map.put(skinningrender.dataloader.openglobjectmemory_array[skinningrender.clientdata.StartPart() + 8].element_array_buffer, 67);
            skinningrender.texture_map.put(((OpenGLObjectMemory)OBJECT_LIST.get(skinningrender.clientdata.StartPart() + 8)).element_array_buffer, 67 + TEXTURE_STEP);
        }
        else if (frame > 249 && frame < 266)
        {
//            skinningrender.texture_index_int_array[8] = 68;
//            skinningrender.texture_map.put(skinningrender.dataloader.openglobjectmemory_array[skinningrender.clientdata.StartPart() + 8].element_array_buffer, 68);
            skinningrender.texture_map.put(((OpenGLObjectMemory)OBJECT_LIST.get(skinningrender.clientdata.StartPart() + 8)).element_array_buffer, 68 + TEXTURE_STEP);
        }
        else if (frame > 301 && frame < 355)
        {
//            skinningrender.texture_index_int_array[8] = 69;
//            skinningrender.texture_map.put(skinningrender.dataloader.openglobjectmemory_array[skinningrender.clientdata.StartPart() + 8].element_array_buffer, 69);
            skinningrender.texture_map.put(((OpenGLObjectMemory)OBJECT_LIST.get(skinningrender.clientdata.StartPart() + 8)).element_array_buffer, 69 + TEXTURE_STEP);
        }
        else
        {
//            skinningrender.texture_index_int_array[8] = 9;
//            skinningrender.texture_map.put(skinningrender.dataloader.openglobjectmemory_array[skinningrender.clientdata.StartPart() + 8].element_array_buffer, 9);
            skinningrender.texture_map.put(((OpenGLObjectMemory)OBJECT_LIST.get(skinningrender.clientdata.StartPart() + 8)).element_array_buffer, 9 + TEXTURE_STEP);
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
        serverentitiesmemory.entitiesaimemory.skinningentitiesattack.max_magic_point = 4;
        serverentitiesmemory.entitiesaimemory.skinningentitiesattack.minimum_distance = 10.0F;

        serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0] = new SkinningEntitiesLiveFrame(this, 0, FRAME_INT_2D_ARRAY);
        serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].condition_boolean_supplier_array = new Supplier[]
        {
            () -> this.isZeroMove() && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoop(0),
            () -> serverentitiesmemory.entitiesaimemory.skinningentitiesplaywith.should_play && (((ServerEntitiesMemory)serverentitiesmemory.entitiesaimemory.skinningentitiesplaywith.playwith_skinningentities.bothentitiesmemory).statentitiesmemory.stat & 16) == 16 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoop(14),
            () -> serverentitiesmemory.entitiesaimemory.skinningentitiesplaywith.should_play && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(15),
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
//        return new YuzuRender(new EntitiesRenderMemory(), this);
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
//        return new SoundRender();
//    }
//
//    @Override
//    @SideOnly(Side.CLIENT)
//    public int[] getIVIntArray()
//    {
//        return ClientYuzuMemory.IV_INT_ARRAY;
//    }

    @Override
    @SideOnly(Side.CLIENT)
    public void createClientEntitiesMemory(SkinningEntities skinningentities, BothData bothdata, WorkBytes workbytes)
    {
        new ClientYuzu(skinningentities, bothdata, workbytes);
    }
}

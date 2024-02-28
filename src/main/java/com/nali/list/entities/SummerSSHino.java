package com.nali.list.entities;

import com.nali.data.BothData;
import com.nali.render.EntitiesRenderMemory;
import com.nali.render.SkinningRender;
import com.nali.small.entities.bytes.WorkBytes;
import com.nali.small.entities.memory.ClientEntitiesMemory;
import com.nali.small.entities.skinning.SkinningEntities;
import com.nali.small.entities.skinning.ai.frame.SkinningEntitiesLiveFrame;
import com.nali.summer.data.SSHinoData;
import com.nali.summer.entities.bytes.SSHinoBytes;
import com.nali.summer.entities.memory.client.ClientSSHinoMemory;
import com.nali.summer.entities.memory.server.ServerSSHinoMemory;
import com.nali.summer.render.RenderHelper;
import com.nali.summer.render.SSHinoRender;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;

import java.util.function.Supplier;

public class SummerSSHino extends SkinningEntities
{
    public static int eggPrimary = 0xfef4f4;
    public static int eggSecondary = 0xffbac2;
    public final static DataParameter<Byte>[] BYTE_DATAPARAMETER_ARRAY = new DataParameter[SSHinoData.MAX_SYNC];
    public final static DataParameter<Integer>[] INTEGER_DATAPARAMETER_ARRAY = new DataParameter[SSHinoData.MAX_FRAME];
    public final static DataParameter<Float>[] FLOAT_DATAPARAMETER_ARRAY = new DataParameter[1];

    public static int[] ATTACK_FRAME_INT_ARRAY = new int[]
    {
        734
    };
    public static int[][] FRAME_INT_2D_ARRAY = new int[][]
    {
        { 409, 459 },
        { 596, 679 },
        { 715, 729 },
        { 680, 695 },
        { 696, 714 },
        { 313, 408 },
        { 558, 595 },
        { 167, 312 },
        { 507, 557 },
        { 0, 166 },
        { 730, 752 },
        { 753, 761 },
        { 762, 812 },
        { 460, 506 }
    };

    static
    {
        for (int i = 0; i < BYTE_DATAPARAMETER_ARRAY.length; ++i)
        {
            BYTE_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerSSHino.class, DataSerializers.BYTE);
        }

        for (int i = 0; i < INTEGER_DATAPARAMETER_ARRAY.length; ++i)
        {
            INTEGER_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerSSHino.class, DataSerializers.VARINT);
        }

        for (int i = 0; i < FLOAT_DATAPARAMETER_ARRAY.length; ++i)
        {
            FLOAT_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerSSHino.class, DataSerializers.FLOAT);
        }
    }

    public SummerSSHino(World world)
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

        if (frame < 409)
        {
            skinningrender.model_boolean_array[4] = false;
            skinningrender.model_boolean_array[5] = false;
            skinningrender.model_boolean_array[11] = false;
        }
        else
        {
            skinningrender.model_boolean_array[4] = true;
            skinningrender.model_boolean_array[5] = true;
            skinningrender.model_boolean_array[11] = true;
        }

        float scale = skinningrender.entitiesrendermemory.scale;
        if (frame > 408 && frame < 507)
        {
            this.width = 1.5F * scale;
            this.height = 0.2F * scale;
        }
        else
        {
            this.width = bothdata.Width() * scale;
            this.height = bothdata.Height() * scale;
        }

        skinningrender.model_boolean_array[6] = false;
    }

    @Override
    public BothData createBothData()
    {
        return new SSHinoData();
    }

    @Override
    public WorkBytes createWorkBytes()
    {
        return new SSHinoBytes();
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
        ServerSSHinoMemory serverentitiesmemory = (ServerSSHinoMemory)this.bothentitiesmemory;
        WorkBytes workbytes = serverentitiesmemory.workbytes;
        serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array = new SkinningEntitiesLiveFrame[1];

        serverentitiesmemory.entitiesaimemory.skinningentitiesattack.attack_frame_int_array = ATTACK_FRAME_INT_ARRAY;
        serverentitiesmemory.entitiesaimemory.skinningentitiesattack.max_ammo = 8;
        serverentitiesmemory.entitiesaimemory.skinningentitiesattack.minimum_distance = 32.0F;

        serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0] = new SkinningEntitiesLiveFrame(this, 0, FRAME_INT_2D_ARRAY);
        serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].condition_boolean_supplier_array = new Supplier[]
        {
            () ->
            {
                boolean result = this.isZeroMove();
                int id = 0;

                if (result)
                {
                    if (serverentitiesmemory.server_how_die)
                    {
                        id = 13;
                    }
                }
                else
                {
                    if (this.ticksExisted % 50 == 0)
                    {
                        serverentitiesmemory.server_how_die = !serverentitiesmemory.server_how_die;
                    }
                }

                return result && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoop(id);
            },

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
        return new SSHinoRender(new EntitiesRenderMemory(), this.bothentitiesmemory.bothdata, RenderHelper.DATALOADER, this);
    }

    @Override
    public void createServerEntitiesMemory(SkinningEntities skinningentities, BothData bothdata, WorkBytes workbytes)
    {
        new ServerSSHinoMemory(skinningentities, bothdata, workbytes);
    }

    @Override
    public void createClientEntitiesMemory(SkinningEntities skinningentities, BothData bothdata, WorkBytes workbytes)
    {
        new ClientSSHinoMemory(skinningentities, bothdata, workbytes);
    }
}

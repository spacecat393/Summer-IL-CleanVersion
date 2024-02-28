package com.nali.list.entities;

import com.nali.data.BothData;
import com.nali.render.EntitiesRenderMemory;
import com.nali.render.SkinningRender;
import com.nali.small.entities.bytes.WorkBytes;
import com.nali.small.entities.memory.ClientEntitiesMemory;
import com.nali.small.entities.skinning.SkinningEntities;
import com.nali.small.entities.skinning.ai.frame.SkinningEntitiesLiveFrame;
import com.nali.summer.data.SSUnaData;
import com.nali.summer.entities.bytes.SSUnaBytes;
import com.nali.summer.entities.memory.client.ClientSSUnaMemory;
import com.nali.summer.entities.memory.server.ServerSSUnaMemory;
import com.nali.summer.render.RenderHelper;
import com.nali.summer.render.SSUnaRender;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.function.Supplier;

public class SummerSSUna extends SkinningEntities
{
    public static int eggPrimary = 0x7d4a39;
    public static int eggSecondary = 0xf4c4d7;
    public final static DataParameter<Byte>[] BYTE_DATAPARAMETER_ARRAY = new DataParameter[SSUnaData.MAX_SYNC];
    public final static DataParameter<Integer>[] INTEGER_DATAPARAMETER_ARRAY = new DataParameter[SSUnaData.MAX_FRAME];
    public final static DataParameter<Float>[] FLOAT_DATAPARAMETER_ARRAY = new DataParameter[1];

    public static int[] ATTACK_FRAME_INT_ARRAY = new int[]
    {
        487,
        493,
        496
    };
    public static int[][] FRAME_INT_2D_ARRAY = new int[][]
    {
        { 264, 314 },
        { 315, 350 },
        { 470, 483 },
        { 612, 628 },
        { 629, 659 },
        { 232, 263 },
        { 432, 469 },
        { 81, 231 },
        { 660, 690 },
        { 0, 80 },
        { 484, 499 },
        { 500, 513 },
        { 514, 562 },
        { 563, 611 }
    };

    static
    {
        for (int i = 0; i < BYTE_DATAPARAMETER_ARRAY.length; ++i)
        {
            BYTE_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerSSUna.class, DataSerializers.BYTE);
        }

        for (int i = 0; i < INTEGER_DATAPARAMETER_ARRAY.length; ++i)
        {
            INTEGER_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerSSUna.class, DataSerializers.VARINT);
        }

        for (int i = 0; i < FLOAT_DATAPARAMETER_ARRAY.length; ++i)
        {
            FLOAT_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerSSUna.class, DataSerializers.FLOAT);
        }
    }

    public SummerSSUna(World world)
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

        if (frame < 264 || (frame > 562 && frame < 612))
        {
            skinningrender.model_boolean_array[8] = true;
        }
        else
        {
            skinningrender.model_boolean_array[8] = false;
        }

        float scale = skinningrender.entitiesrendermemory.scale;
        if (frame > 314 && frame < 351)
        {
            this.width = bothdata.Width() * scale;
            this.height = 0.65F * scale;
        }
        else if (frame > 263 && frame < 315)
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
    public AxisAlignedBB getMouthAxisAlignedBB()
    {
        ClientEntitiesMemory cliententitiesmemory = (ClientEntitiesMemory)this.bothentitiesmemory;
        SkinningRender skinningrender = (SkinningRender)cliententitiesmemory.objectrender;
        int frame = skinningrender.frame_int_array[0];

        if (frame > 314 && frame < 351)
        {
            double hw = this.width / 2.0F;
            double hh = 0.5;
            Vec3d view_vec3d = this.getVectorForRotation(this.rotationPitch, this.rotationYaw + 90.0F).scale(0.5);
            double x = this.posX + view_vec3d.x;
            double y = this.posY + this.height / 2.0F + view_vec3d.y;
            double z = this.posZ + view_vec3d.z;
            return new AxisAlignedBB(x - hw, y, z - hw, x + hw, y + hh, z + hw);
        }
        else
        {
            return super.getMouthAxisAlignedBB();
        }
    }

    @Override
    public BothData createBothData()
    {
        return new SSUnaData();
    }

    @Override
    public WorkBytes createWorkBytes()
    {
        return new SSUnaBytes();
    }

    @Override
    public void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.05D);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(20.0D);
    }

    @Override
    public void createServer()
    {
        ServerSSUnaMemory serverentitiesmemory = (ServerSSUnaMemory)this.bothentitiesmemory;
        WorkBytes workbytes = serverentitiesmemory.workbytes;
        serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array = new SkinningEntitiesLiveFrame[1];

        serverentitiesmemory.entitiesaimemory.skinningentitiesattack.attack_frame_int_array = ATTACK_FRAME_INT_ARRAY;
        serverentitiesmemory.entitiesaimemory.skinningentitiesattack.max_ammo = 8;
        serverentitiesmemory.entitiesaimemory.skinningentitiesattack.minimum_distance = 6.0F;

        serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0] = new SkinningEntitiesLiveFrame(this, 0, FRAME_INT_2D_ARRAY);
        serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].condition_boolean_supplier_array = new Supplier[]
        {
            () -> this.isZeroMove() && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoop(0),
            () -> serverentitiesmemory.current_work_byte_array[workbytes.SIT()] == 1 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoopFB(1),
            () -> serverentitiesmemory.main_work_byte_array[workbytes.ATTACK()] == 1 && this.moveForward == 0 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopOffSet(3, 4),
            () ->
            {
                int id = 13;
                if (serverentitiesmemory.main_work_byte_array[workbytes.AMMO()] <= 0)
                {
                    if (serverentitiesmemory.server_step_reload)
                    {
                        id = 12;
                    }
                }
                else
                {
                    if (this.ticksExisted % 50 == 0)
                    {
                        serverentitiesmemory.server_step_reload = !serverentitiesmemory.server_step_reload;
                    }
                }

                return serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setShoot(2, 10, 11, id, false, serverentitiesmemory.entitiesaimemory.skinningentitiesattack);
            },
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
        return new SSUnaRender(new EntitiesRenderMemory(), this.bothentitiesmemory.bothdata, RenderHelper.DATALOADER, this);
    }

    @Override
    public void createServerEntitiesMemory(SkinningEntities skinningentities, BothData bothdata, WorkBytes workbytes)
    {
        new ServerSSUnaMemory(skinningentities, bothdata, workbytes);
    }

    @Override
    public void createClientEntitiesMemory(SkinningEntities skinningentities, BothData bothdata, WorkBytes workbytes)
    {
        new ClientSSUnaMemory(skinningentities, bothdata, workbytes);
    }
}

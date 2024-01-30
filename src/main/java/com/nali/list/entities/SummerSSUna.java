package com.nali.list.entities;

import com.nali.data.BothData;
import com.nali.render.SkinningRender;
import com.nali.small.entities.bytes.SkinningEntitiesBytes;
import com.nali.small.entities.skinning.SkinningEntities;
import com.nali.small.entities.skinning.ai.frame.SkinningEntitiesLiveFrame;
import com.nali.summer.data.SSUnaData;
import com.nali.summer.entities.bytes.SSUnaBytes;
import com.nali.summer.render.SSUnaRender;
import com.nali.summer.render.RenderHelper;
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
    public final static DataParameter<Integer>[] INTEGER_DATAPARAMETER_ARRAY = new DataParameter[SSUnaData.MAX_FRAME];
    public final static DataParameter<Float>[] FLOAT_DATAPARAMETER_ARRAY = new DataParameter[1];

    public boolean server_step_reload;

    static
    {
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
        SkinningRender skinningrender = (SkinningRender)this.client_object;
        int frame = skinningrender.frame_int_array[0];

        if (frame < 264 || (frame > 562 && frame < 612))
        {
            skinningrender.model_boolean_array[8] = true;
        }
        else
        {
            skinningrender.model_boolean_array[8] = false;
        }

        float scale = skinningrender.scale;
        if (frame > 314 && frame < 351)
        {
            this.width = this.bothdata.Width() * scale;
            this.height = 0.65F * scale;
        }
        else if (frame > 263 && frame < 315)
        {
            this.width = 1.5F * scale;
            this.height = 0.2F * scale;
        }
        else
        {
            this.width = this.bothdata.Width() * scale;
            this.height = this.bothdata.Height() * scale;
        }
    }

    @Override
    public AxisAlignedBB getMouthAxisAlignedBB()
    {
        SkinningRender skinningrender = (SkinningRender)this.client_object;
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
    public SkinningEntitiesBytes createBytes()
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

    /**0-Die
     * 1-Sit
     * 2-StartAttack
     * 3-Run
     * 4-EndRun
     * 5-Walk
     * 6-HardReady
     * 7-SoftReady
     * 8-HardIdle
     * 9-SoftIdle
     * 10-Attacking
     * 11-EndAttack
     * 12-Reload*/
    @Override
    public void createServer()
    {
        this.server_skinningentitiesliveframe_array = new SkinningEntitiesLiveFrame[1];

        this.skinningentitiesattack.attack_frame_int_array = new int[]
        {
            487,
            493,
            496
        };
        this.skinningentitiesattack.max_ammo = 8;
        this.skinningentitiesattack.minimum_distance = 6.0F;

        this.server_skinningentitiesliveframe_array[0] = new SkinningEntitiesLiveFrame(this, 0, new int[][]
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
        });

        this.server_skinningentitiesliveframe_array[0].condition_boolean_supplier_array = new Supplier[]
        {
            () -> this.server_skinningentitiesliveframe_array[0].setFLoop(0, this.isZeroMove()),
            () -> this.server_skinningentitiesliveframe_array[0].setTLoopFB(1, this.server_work_byte_array[this.skinningentitiesbytes.SIT()] == 1),
            () -> this.main_server_work_byte_array[this.skinningentitiesbytes.ATTACK()] == 1 && this.moveForward == 0 && this.server_skinningentitiesliveframe_array[0].setFLoopOffSet(3, 4),
            () ->
            {
                int id = 13;
//                if (this.server_step_reload)
                if (this.main_server_work_byte_array[this.skinningentitiesbytes.AMMO()] <= 0)
                {
                    if (this.server_step_reload)
                    {
                        id = 12;
                    }
//                    id = 12;
//                    if (this.server_frame_int_array[this.server_skinningentitiesliveframe_array[0].integer_index] < this.server_skinningentitiesliveframe_array[0].int_2d_array[13][0] || this.server_frame_int_array[this.server_skinningentitiesliveframe_array[0].integer_index] > this.server_skinningentitiesliveframe_array[0].int_2d_array[13][1])
//                    {
//                    if (this.server_frame_int_array[this.server_skinningentitiesliveframe_array[0].integer_index] == this.server_skinningentitiesliveframe_array[0].int_2d_array[id][1])
//                    {
//                        this.server_step_reload = false;
//                    }
//                    }
                }
                else
                {
                    if (this.ticksExisted % 50 == 0)
                    {
                        this.server_step_reload = !this.server_step_reload;
                    }
                }

                return this.server_skinningentitiesliveframe_array[0].setShoot(2, 10, 11, id, false, this.skinningentitiesattack);
            },
            () -> this.server_skinningentitiesliveframe_array[0].setTLoop(3, this.main_server_work_byte_array[this.skinningentitiesbytes.ATTACK()] == 1 && this.moveForward != 0),
            () -> this.server_skinningentitiesliveframe_array[0].setTLoop(5, this.moveForward != 0),
            //pat -> soft_ready
            //eat -> soft_ready
            () -> this.server_skinningentitiesliveframe_array[0].setFLoopFree(6, this.skinningentitiesbytes.HARD_READY(), this.server_work_byte_array[this.skinningentitiesbytes.HARD_READY()] == 1),
            () -> this.server_skinningentitiesliveframe_array[0].setFLoopFree(7, this.skinningentitiesbytes.SOFT_READY(), this.server_work_byte_array[this.skinningentitiesbytes.SOFT_READY()] == 1),
            () -> this.server_skinningentitiesliveframe_array[0].setTLoop(8, this.main_server_work_byte_array[this.skinningentitiesbytes.ATTACK()] == 1),
            () -> this.server_skinningentitiesliveframe_array[0].setTLoop(9)
        };
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
    public Object createClientObject()
    {
        return new SSUnaRender(this.bothdata, RenderHelper.DATALOADER, this);
    }
}

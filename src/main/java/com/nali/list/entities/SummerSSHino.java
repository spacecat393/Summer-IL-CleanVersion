package com.nali.list.entities;

import com.nali.data.BothData;
import com.nali.render.SkinningRender;
import com.nali.small.entities.bytes.SkinningEntitiesBytes;
import com.nali.small.entities.skinning.SkinningEntities;
import com.nali.small.entities.skinning.ai.frame.SkinningEntitiesLiveFrame;
import com.nali.summer.data.SSHinoData;
import com.nali.summer.entities.bytes.SSHinoBytes;
import com.nali.summer.render.SSHinoRender;
import com.nali.summer.render.RenderHelper;
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

    public boolean server_how_die;

    static
    {
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
        SkinningRender skinningrender = (SkinningRender)this.client_object;
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

        float scale = skinningrender.scale;
//        if (frame >  && frame < )
//        {
//            this.width = this.bothdata.Width() * scale;
//            this.height = 0.65F * scale;
//        }
        /*else */if (frame > 408 && frame < 507)
        {
            this.width = 1.5F * scale;
            this.height = 0.2F * scale;
        }
        else
        {
            this.width = this.bothdata.Width() * scale;
            this.height = this.bothdata.Height() * scale;
        }

        skinningrender.model_boolean_array[6] = false;
    }

//    @Override
//    public AxisAlignedBB getMouthAxisAlignedBB()
//    {
//        SkinningRender skinningrender = (SkinningRender)this.client_object;
//        int frame = skinningrender.frame_int_array[0];
//
//        if (frame >  && frame < )
//        {
//            double hw = this.width / 2.0F;
//            double hh = 0.5;
//            Vec3d view_vec3d = this.getVectorForRotation(this.rotationPitch, this.rotationYaw + 90.0F).scale(0.5);
//            double x = this.posX + view_vec3d.x;
//            double y = this.posY + this.height / 2.0F + view_vec3d.y;
//            double z = this.posZ + view_vec3d.z;
//            return new AxisAlignedBB(x - hw, y, z - hw, x + hw, y + hh, z + hw);
//        }
//        else
//        {
//            return super.getMouthAxisAlignedBB();
//        }
//    }

    @Override
    public BothData createBothData()
    {
        return new SSHinoData();
    }

    @Override
    public SkinningEntitiesBytes createBytes()
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
        this.server_skinningentitiesliveframe_array = new SkinningEntitiesLiveFrame[1];

        this.skinningentitiesattack.attack_frame_int_array = ATTACK_FRAME_INT_ARRAY;
        this.skinningentitiesattack.max_ammo = 8;
        this.skinningentitiesattack.minimum_distance = 32.0F;

        this.server_skinningentitiesliveframe_array[0] = new SkinningEntitiesLiveFrame(this, 0, FRAME_INT_2D_ARRAY);
        this.server_skinningentitiesliveframe_array[0].condition_boolean_supplier_array = new Supplier[]
        {
            () ->
            {
                boolean result = this.isZeroMove();
                int id = 0;

                if (result)
                {
                    if (this.server_how_die)
                    {
                        id = 13;
                    }
                }
                else
                {
                    if (this.ticksExisted % 50 == 0)
                    {
                        this.server_how_die = !this.server_how_die;
                    }
                }

                return result && this.server_skinningentitiesliveframe_array[0].setFLoop(id);
            },

            () -> this.server_work_byte_array[this.skinningentitiesbytes.SIT()] == 1 && this.server_skinningentitiesliveframe_array[0].setTLoop(1),
            () -> this.main_server_work_byte_array[this.skinningentitiesbytes.ATTACK()] == 1 && this.moveForward == 0 && this.server_skinningentitiesliveframe_array[0].setFLoopOffSet(3, 4),
            () -> this.server_skinningentitiesliveframe_array[0].setShoot(2, 10, 11, 12, false, this.skinningentitiesattack),
            () -> this.main_server_work_byte_array[this.skinningentitiesbytes.ATTACK()] == 1 && this.moveForward != 0 && this.server_skinningentitiesliveframe_array[0].setTLoop(3),
            () -> this.moveForward != 0 && this.server_skinningentitiesliveframe_array[0].setTLoop(5),
            //pat -> soft_ready
            //eat -> soft_ready
            () -> this.server_work_byte_array[this.skinningentitiesbytes.HARD_READY()] == 1 && this.server_skinningentitiesliveframe_array[0].setFLoopFree(6, this.skinningentitiesbytes.HARD_READY()),
            () -> this.server_work_byte_array[this.skinningentitiesbytes.SOFT_READY()] == 1 && this.server_skinningentitiesliveframe_array[0].setFLoopFree(7, this.skinningentitiesbytes.SOFT_READY()),
            () -> this.main_server_work_byte_array[this.skinningentitiesbytes.ATTACK()] == 1 && this.server_skinningentitiesliveframe_array[0].setTLoop(8),
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
        return new SSHinoRender(this.bothdata, RenderHelper.DATALOADER, this);
    }
}

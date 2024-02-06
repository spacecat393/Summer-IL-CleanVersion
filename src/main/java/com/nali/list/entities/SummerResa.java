package com.nali.list.entities;

import com.nali.data.BothData;
import com.nali.render.SkinningRender;
import com.nali.small.entities.bytes.SkinningEntitiesBytes;
import com.nali.small.entities.skinning.SkinningEntities;
import com.nali.small.entities.skinning.ai.frame.SkinningEntitiesLiveFrame;
import com.nali.summer.data.ResaData;
import com.nali.summer.entities.bytes.ResaBytes;
import com.nali.summer.render.ResaRender;
import com.nali.summer.render.RenderHelper;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;

import java.util.function.Supplier;

public class SummerResa extends SkinningEntities
{
    public static int eggPrimary = 0x4e466d;
    public static int eggSecondary = 0xbdb5ff;
    public final static DataParameter<Integer>[] INTEGER_DATAPARAMETER_ARRAY = new DataParameter[ResaData.MAX_FRAME];
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

    public int client_eyes_tick;

    static
    {
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
    public void updateClient()
    {
        SkinningRender skinningrender = (SkinningRender)this.client_object;
        int frame = skinningrender.frame_int_array[0];

        if (this.ticksExisted % 200 == 0)
        {
            skinningrender.model_boolean_array[0] = false;
            skinningrender.model_boolean_array[9] = false;
            skinningrender.model_boolean_array[6] = true;
            this.client_eyes_tick = 20;
        }
        else if (--this.client_eyes_tick <= 0)
        {
            skinningrender.model_boolean_array[0] = true;
            skinningrender.model_boolean_array[9] = true;
            skinningrender.model_boolean_array[6] = false;
        }

        if (frame > 125 && frame < 227)
        {
            skinningrender.model_boolean_array[7] = true;
        }
        else
        {
            skinningrender.model_boolean_array[7] = false;
        }

        float scale = skinningrender.scale;
        if (frame > 600 && frame < 652)
        {
            this.width = 1.5F * scale;
            this.height = 0.2F * scale;
        }
        else
        {
            this.width = this.bothdata.Width() * scale;
            this.height = this.bothdata.Height() * scale;
        }

        skinningrender.model_boolean_array[4] = false;
    }

    @Override
    public void initFakeFrame()
    {
        SkinningRender skinningrender = (SkinningRender)this.client_object;
        skinningrender.model_boolean_array[0] = false;
        skinningrender.model_boolean_array[9] = false;
        skinningrender.model_boolean_array[6] = true;
    }

//    @Override
//    public AxisAlignedBB getMouthAxisAlignedBB()
//    {
//        SkinningRender skinningrender = (SkinningRender)this.client_object;
//        int frame = skinningrender.frame_int_array[0];
//
//        if (frame > 282 && frame < 477)
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
        return new ResaData();
    }

    @Override
    public SkinningEntitiesBytes createBytes()
    {
        return new ResaBytes();
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
        this.skinningentitiesattack.max_ammo = 4;
        this.skinningentitiesattack.minimum_distance = 12.0F;

        this.server_skinningentitiesliveframe_array[0] = new SkinningEntitiesLiveFrame(this, 0, FRAME_INT_2D_ARRAY);
        this.server_skinningentitiesliveframe_array[0].condition_boolean_supplier_array = new Supplier[]
        {
            () -> this.isZeroMove() && this.server_skinningentitiesliveframe_array[0].setFLoop(0),
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
        return new ResaRender(this.bothdata, RenderHelper.DATALOADER, this);
    }
}

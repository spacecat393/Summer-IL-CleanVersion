package com.nali.list.entities;

import com.nali.data.BothData;
import com.nali.render.SkinningRender;
import com.nali.small.entities.bytes.SkinningEntitiesBytes;
import com.nali.small.entities.skinning.SkinningEntities;
import com.nali.small.entities.skinning.ai.frame.SkinningEntitiesLiveFrame;
import com.nali.summer.data.IbukiData;
import com.nali.summer.entities.bytes.IbukiBytes;
import com.nali.summer.render.RenderHelper;
import com.nali.summer.render.IbukiRender;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.function.Supplier;

public class SummerIbuki extends SkinningEntities
{
    public static int eggPrimary = 0xfef5cb;
    public static int eggSecondary = 0xab6402;
    public final static DataParameter<Integer>[] INTEGER_DATAPARAMETER_ARRAY = new DataParameter[IbukiData.MAX_FRAME];
    public final static DataParameter<Float>[] FLOAT_DATAPARAMETER_ARRAY = new DataParameter[1];

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

    public int client_eyes_tick;

    static
    {
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
        SkinningRender skinningrender = (SkinningRender)this.client_object;
        int frame = skinningrender.frame_int_array[0];

        if (this.ticksExisted % 200 == 0)
        {
            skinningrender.model_boolean_array[0 + 6] = false;
            skinningrender.model_boolean_array[1 + 6] = false;
            skinningrender.model_boolean_array[11 + 6] = false;
            skinningrender.model_boolean_array[2 + 6] = true;
            skinningrender.model_boolean_array[12 + 6] = true;
            this.client_eyes_tick = 20;
        }
        else if (--this.client_eyes_tick <= 0)
        {
            skinningrender.model_boolean_array[0 + 6] = true;
            skinningrender.model_boolean_array[1 + 6] = true;
            skinningrender.model_boolean_array[11 + 6] = true;
            skinningrender.model_boolean_array[2 + 6] = false;
            skinningrender.model_boolean_array[12 + 6] = false;
        }

        float scale = skinningrender.scale;

        if (frame > 296 && frame < 348)
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
    public void initFakeFrame()
    {
        SkinningRender skinningrender = (SkinningRender)this.client_object;
        skinningrender.model_boolean_array[0 + 6] = false;
        skinningrender.model_boolean_array[1 + 6] = false;
        skinningrender.model_boolean_array[11 + 6] = false;
        skinningrender.model_boolean_array[2 + 6] = true;
        skinningrender.model_boolean_array[12 + 6] = true;
    }

    @Override
    public BothData createBothData()
    {
        return new IbukiData();
    }

    @Override
    public SkinningEntitiesBytes createBytes()
    {
        return new IbukiBytes();
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
        this.skinningentitiesplaywith.clasz = SummerIroha.class;

        this.server_skinningentitiesliveframe_array = new SkinningEntitiesLiveFrame[1];

        this.skinningentitiesattack.attack_frame_int_array = ATTACK_FRAME_INT_ARRAY;
        this.skinningentitiesattack.max_ammo = 32;
        this.skinningentitiesattack.minimum_distance = 17.0F;

        this.server_skinningentitiesliveframe_array[0] = new SkinningEntitiesLiveFrame(this, 0, FRAME_INT_2D_ARRAY);
        this.server_skinningentitiesliveframe_array[0].condition_boolean_supplier_array = new Supplier[]
        {
            () ->
            {
                boolean result = this.skinningentitiesplaywith.should_play;
                this.server_skinningentitiesliveframe_array[0].lock = result;
                return result;
            },
//            () -> this.server_skinningentitiesliveframe_array[0].setFLoop(13, this.skinningentitiesplaywith.should_play && this.skinningentitiesplaywith.playwith_skinningentities.server_work_byte_array[this.skinningentitiesplaywith.playwith_skinningentities.skinningentitiesbytes.SIT()] == 1),
//            () -> this.server_skinningentitiesliveframe_array[0].setTLoop(14, this.skinningentitiesplaywith.should_play),
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
//        this.itemlayerrender.hand_p = 67.8059367925672F;
//        this.itemlayerrender.legs_y = 84.03490369025576F / 2.0F + 180.0F;
//        this.itemlayerrender.legs_p = 6.773068689298493F;
//        this.itemlayerrender.feet_y = -17.22647259946362F / 2.0F;
//        this.itemlayerrender.feet_p = -174.64395393898405F;

//        this.itemlayerrender.c_left_hand_i = 9;
//        this.itemlayerrender.c_left_hand_v = 2857;
//        this.itemlayerrender.t_left_hand_i = 9;
//        this.itemlayerrender.t_left_hand_v = 2856;
//
//        this.itemlayerrender.c_right_hand_i = 9;
//        this.itemlayerrender.c_right_hand_v = 5899;
//        this.itemlayerrender.t_right_hand_i = 9;
//        this.itemlayerrender.t_right_hand_v = 5898;
//
//        this.itemlayerrender.c_head_i = 4;
//        this.itemlayerrender.c_head_v = 280;
//        this.itemlayerrender.t_head_i = 4;
//        this.itemlayerrender.t_head_v = 276;
//
//        this.itemlayerrender.c_chest_i = 9;
//        this.itemlayerrender.c_chest_v = 411;
//        this.itemlayerrender.t_chest_i = 9;
//        this.itemlayerrender.t_chest_v = 235;
//
//        this.itemlayerrender.c_legs_i = 9;
//        this.itemlayerrender.c_legs_v = 13;//! pos
//        this.itemlayerrender.t_legs_i = 9;
//        this.itemlayerrender.t_legs_v = 10434;//!
//
//        this.itemlayerrender.c_feet_i = 9;
//        this.itemlayerrender.c_feet_v = 2196;//!
//        this.itemlayerrender.t_feet_i = 9;
//        this.itemlayerrender.t_feet_v = 527;//!
        return new IbukiRender(this.bothdata, RenderHelper.DATALOADER, this);
    }

    @Override
    public void onShouldPlayWith()
    {
        float scale = this.getDataManager().get(this.getFloatDataParameterArray()[0]);
        float height = 1.5F * scale;

        SkinningEntities playwith_skinningentities = this.skinningentitiesplaywith.playwith_skinningentities;
        Vec3d view_vec3d = this.getVectorForRotation(0.0F, playwith_skinningentities.rotationYaw + 90.0F).scale(scale * 0.3F);
        Vec3d main_vec3d = this.getVectorForRotation(0.0F, playwith_skinningentities.rotationYaw).scale(scale * 0.2F);
        this.setPositionAndUpdate(playwith_skinningentities.posX + view_vec3d.x + main_vec3d.x, playwith_skinningentities.posY + height / 1.25F, playwith_skinningentities.posZ + view_vec3d.z + main_vec3d.z);
        this.rotationYaw = playwith_skinningentities.rotationYaw;
        this.rotationPitch = playwith_skinningentities.rotationPitch;
        this.renderYawOffset = playwith_skinningentities.renderYawOffset;
        this.fallDistance = 0;
    }

    @Override
    public void collideWithNearbyEntities()
    {
        if (this.skinningentitiesplaywith == null || !this.skinningentitiesplaywith.should_play)
        {
            super.collideWithNearbyEntities();
        }
    }

    @Override
    public boolean canBePushed()
    {
        return this.skinningentitiesplaywith == null || !this.skinningentitiesplaywith.should_play;
    }
}

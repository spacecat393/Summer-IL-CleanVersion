package com.nali.list.entities;

import com.nali.data.BothData;
import com.nali.render.SkinningRender;
import com.nali.small.entities.bytes.SkinningEntitiesBytes;
import com.nali.small.entities.skinning.SkinningEntities;
import com.nali.small.entities.skinning.ai.frame.SkinningEntitiesLiveFrame;
import com.nali.summer.data.YuzuData;
import com.nali.summer.entities.bytes.YuzuBytes;
import com.nali.summer.render.YuzuRender;
import com.nali.summer.render.RenderHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

import java.util.function.Supplier;

import static com.nali.small.entities.EntitiesMathHelper.isTooClose;

public class SummerYuzu extends SkinningEntities
{
    public static int eggPrimary = 0xfbdad0;
    public static int eggSecondary = 0xfc6c78;
    public final static DataParameter<Integer>[] INTEGER_DATAPARAMETER_ARRAY = new DataParameter[YuzuData.MAX_FRAME];
    public final static DataParameter<Float>[] FLOAT_DATAPARAMETER_ARRAY = new DataParameter[1];
//    public boolean server_how_attack;

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
    public void updateClient()
    {
        SkinningRender skinningrender = (SkinningRender)this.client_object;
        int frame = skinningrender.frame_int_array[0];

        float scale = skinningrender.scale;
        if (frame > 195 && frame < 222)
        {
            skinningrender.texture_index_int_array[8] = 66;
        }
        else if ((frame > 221 && frame < 250) || (frame > 354 && frame < 429))
        {
            skinningrender.texture_index_int_array[8] = 67;
        }
        else if (frame > 249 && frame < 266)
        {
            skinningrender.texture_index_int_array[8] = 68;
        }
        else if (frame > 301 && frame < 355)
        {
            skinningrender.texture_index_int_array[8] = 69;
        }
        else
        {
            skinningrender.texture_index_int_array[8] = 9;
        }

        if (frame > 716 && frame < 768)
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
    public BothData createBothData()
    {
        return new YuzuData();
    }

    @Override
    public SkinningEntitiesBytes createBytes()
    {
        return new YuzuBytes();
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
        this.skinningentitiesplaywith.clasz = SummerE22Locker.class;

        this.server_skinningentitiesliveframe_array = new SkinningEntitiesLiveFrame[1];

        this.skinningentitiesattack.attack_frame_int_array = ATTACK_FRAME_INT_ARRAY;
        this.skinningentitiesattack.max_ammo = 4;
        this.skinningentitiesattack.minimum_distance = 10.0F;

        this.server_skinningentitiesliveframe_array[0] = new SkinningEntitiesLiveFrame(this, 0, FRAME_INT_2D_ARRAY);
        this.server_skinningentitiesliveframe_array[0].condition_boolean_supplier_array = new Supplier[]
        {
            () -> this.isZeroMove() && this.server_skinningentitiesliveframe_array[0].setFLoop(0),
            () -> this.skinningentitiesplaywith.should_play && this.skinningentitiesplaywith.playwith_skinningentities.server_work_byte_array[this.skinningentitiesplaywith.playwith_skinningentities.skinningentitiesbytes.SIT()] == 1 && this.server_skinningentitiesliveframe_array[0].setFLoop(14),
            () -> this.skinningentitiesplaywith.should_play && this.server_skinningentitiesliveframe_array[0].setTLoop(15),
            () -> this.server_work_byte_array[this.skinningentitiesbytes.SIT()] == 1 && this.server_skinningentitiesliveframe_array[0].setTLoop(1),
            () -> this.main_server_work_byte_array[this.skinningentitiesbytes.ATTACK()] == 1 && this.moveForward == 0 && this.server_skinningentitiesliveframe_array[0].setFLoopOffSet(3, 4),
//            () ->
//            {
//                boolean result = this.skinningentitiesattack.state == 0 || this.skinningentitiesattack.state == 1 || this.skinningentitiesattack.state == 3;
//                int id = 10;
//                if (result)
//                {
//                    if (this.server_how_attack)
//                    {
//                        id = 13;
////                        if (this.server_frame_int_array[this.server_skinningentitiesliveframe_array[0].integer_index] == this.server_skinningentitiesliveframe_array[0].int_2d_array[id][1])
////                        {
////                            this.server_how_attack = false;
////                        }
//                    }
//                    else
//                    {
//                        if (this.server_frame_int_array[this.server_skinningentitiesliveframe_array[0].integer_index] == this.server_skinningentitiesliveframe_array[0].int_2d_array[id][1])
//                        {
//                            this.server_how_attack = this.ticksExisted % 3 == 0;
//                        }
//                    }
//                }
//                else
//                {
//                    if (this.ticksExisted % 50 == 0)
//                    {
//                        this.server_how_attack = !this.server_how_attack;
//                    }
//                }
//
//                return this.server_skinningentitiesliveframe_array[0].setShoot(2, id, 11, 12, false, this.skinningentitiesattack);
//            },
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
        return new YuzuRender(this.bothdata, RenderHelper.DATALOADER, this);
    }
}

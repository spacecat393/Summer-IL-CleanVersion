package com.nali.list.entities;

import com.nali.data.BothData;
import com.nali.render.SkinningRender;
import com.nali.small.entities.bytes.SkinningEntitiesBytes;
import com.nali.small.entities.skinning.SkinningEntities;
import com.nali.small.entities.skinning.ai.frame.SkinningEntitiesLiveFrame;
import com.nali.summer.data.SaoriData;
import com.nali.summer.entities.bytes.SaoriBytes;
import com.nali.summer.render.SaoriRender;
import com.nali.summer.render.RenderHelper;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.function.Supplier;

public class SummerSaori extends SkinningEntities
{
    public static int eggPrimary = 0x283756;
    public static int eggSecondary = 0x4a73bd;
    public final static DataParameter<Integer>[] INTEGER_DATAPARAMETER_ARRAY = new DataParameter[SaoriData.MAX_FRAME];
    public final static DataParameter<Float>[] FLOAT_DATAPARAMETER_ARRAY = new DataParameter[1];
    public boolean server_how_attack;

    static
    {
        for (int i = 0; i < INTEGER_DATAPARAMETER_ARRAY.length; ++i)
        {
            INTEGER_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerSaori.class, DataSerializers.VARINT);
        }

        for (int i = 0; i < FLOAT_DATAPARAMETER_ARRAY.length; ++i)
        {
            FLOAT_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerSaori.class, DataSerializers.FLOAT);
        }
    }

    public SummerSaori(World world)
    {
        super(world);
    }

    @Override
    public void updateClient()
    {
        SkinningRender skinningrender = (SkinningRender)this.client_object;
        int frame = skinningrender.frame_int_array[0];

        float scale = skinningrender.scale;
        if (frame > 889 && frame < 943)
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

        if (frame > 889 && frame < 943)
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
        return new SaoriData();
    }

    @Override
    public SkinningEntitiesBytes createBytes()
    {
        return new SaoriBytes();
    }

    @Override
    public void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.05D);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(15.0D);
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
            711,
            807,
            833,
            838,
            843,
            860
        };
        this.skinningentitiesattack.max_ammo = 32;
        this.skinningentitiesattack.minimum_distance = 70.0F;

        this.server_skinningentitiesliveframe_array[0] = new SkinningEntitiesLiveFrame(this, 0, new int[][]
        {
            { 890, 942 },
            { 492, 592 },
            { 688, 704 },
            { 593, 608 },
            { 609, 646 },
            { 358, 491 },
            { 943, 979 },
            { 241, 357 },
            { 647, 687 },
            { 0, 240 },
            { 705, 723 },
            { 724, 742 },
            { 743, 788 },
            { 789, 889 }//skill
//            { 980, 1013 }//delay attack
        });

        this.server_skinningentitiesliveframe_array[0].condition_boolean_supplier_array = new Supplier[]
        {
            () -> this.server_skinningentitiesliveframe_array[0].setFLoop(0, this.isZeroMove()),
            () -> this.server_skinningentitiesliveframe_array[0].setTLoop(1, this.server_work_byte_array[this.skinningentitiesbytes.SIT()] == 1),
            () -> this.main_server_work_byte_array[this.skinningentitiesbytes.ATTACK()] == 1 && this.moveForward == 0 && this.server_skinningentitiesliveframe_array[0].setFLoopOffSet(3, 4),
            () ->
            {
                int id = 10;
                int start_id = 2;

                if (this.server_how_attack)
                {
                    id = 13;
                    start_id = 13;
//                        for (int attack_frame : this.skinningentitiesattack.attack_frame_int_array)
//                        {
//                            if (this.server_frame_int_array[this.server_skinningentitiesliveframe_array[0].integer_index] == attack_frame)
//                            {
//                                this.skinningentitiesattack.state = 1;
//                                break;
//                            }
//                        }

                    if (this.server_frame_int_array[this.server_skinningentitiesliveframe_array[0].integer_index] == this.server_skinningentitiesliveframe_array[0].int_2d_array[id][1] - 1)
                    {
                        start_id = 2;
                        id = 10;
                        this.server_frame_int_array[this.server_skinningentitiesliveframe_array[0].integer_index] = this.server_skinningentitiesliveframe_array[0].int_2d_array[2][0];
                        this.server_how_attack = false;
                    }
//                        return this.server_skinningentitiesliveframe_array[0].setFLoop(id, true);
                }
//                else// if (this.server_how_attack == 2)
//                {
////                    id = 14;
////                    start_id = 14;
////                    if (this.server_frame_int_array[this.server_skinningentitiesliveframe_array[0].integer_index] == this.server_skinningentitiesliveframe_array[0].int_2d_array[id][1] - 1)
////                    {
////                        this.server_how_attack = 0;
////                    }
//////                        return this.server_skinningentitiesliveframe_array[0].setFLoop(id, true);
//                }

                if (this.server_frame_int_array[this.server_skinningentitiesliveframe_array[0].integer_index] == this.server_skinningentitiesliveframe_array[0].int_2d_array[id][1] - 1)
                {
                    this.server_how_attack = (byte)(this.ticksExisted % 20) == 0;
                }

//                {
//                    ++this.server_how_attack;
//
//                    if (this.server_how_attack > 2)
//                    {
//                        this.server_how_attack = 0;
//                    }
//                }

                return this.server_skinningentitiesliveframe_array[0].setShoot(start_id, id, 11, 12, false, this.skinningentitiesattack);
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
        return new SaoriRender(this.bothdata, RenderHelper.DATALOADER, this);
    }
}

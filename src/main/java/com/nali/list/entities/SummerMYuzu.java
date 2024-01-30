package com.nali.list.entities;

import com.nali.data.BothData;
import com.nali.render.SkinningRender;
import com.nali.small.entities.bytes.SkinningEntitiesBytes;
import com.nali.small.entities.skinning.SkinningEntities;
import com.nali.small.entities.skinning.ai.frame.SkinningEntitiesLiveFrame;
import com.nali.summer.data.MYuzuData;
import com.nali.summer.entities.bytes.MYuzuBytes;
import com.nali.summer.render.MYuzuRender;
import com.nali.summer.render.RenderHelper;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;

import java.util.function.Supplier;

public class SummerMYuzu extends SkinningEntities
{
    public static int eggPrimary = 0xfbdad0;
    public static int eggSecondary = 0xfc6c78;
    public final static DataParameter<Integer>[] INTEGER_DATAPARAMETER_ARRAY = new DataParameter[MYuzuData.MAX_FRAME];
    public final static DataParameter<Float>[] FLOAT_DATAPARAMETER_ARRAY = new DataParameter[1];

    static
    {
        for (int i = 0; i < INTEGER_DATAPARAMETER_ARRAY.length; ++i)
        {
            INTEGER_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerMYuzu.class, DataSerializers.VARINT);
        }

        for (int i = 0; i < FLOAT_DATAPARAMETER_ARRAY.length; ++i)
        {
            FLOAT_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerMYuzu.class, DataSerializers.FLOAT);
        }
    }

    public SummerMYuzu(World world)
    {
        super(world);
    }

    @Override
    public void updateClient()
    {
        SkinningRender skinningrender = (SkinningRender)this.client_object;
        int frame = skinningrender.frame_int_array[0];

        float scale = skinningrender.scale;
        if (frame < 513)
        {
            this.width = this.bothdata.Width() * scale;
            this.height = 0.65F * scale;
        }
        else if (/*frame > 512 && */frame < 564)
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
        ((SkinningRender)this.client_object).frame_int_array[0] = 110;
    }

    @Override
    public BothData createBothData()
    {
        return new MYuzuData();
    }

    @Override
    public SkinningEntitiesBytes createBytes()
    {
        return new MYuzuBytes();
    }

    @Override
    public void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.05D);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(10.0D);
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
            622
        };
//        this.skinningentitiesattack.max_ammo = 4;
        this.skinningentitiesattack.minimum_distance = 10.0F;

        this.server_skinningentitiesliveframe_array[0] = new SkinningEntitiesLiveFrame(this, 0, new int[][]
        {
            { 513, 563 },
            { 0, 321 },
            { 614, 643 },//loop attack
            { 598, 613 },
            { 479, 512 },
            { 695, 770 },
            { 644, 694 },
            { 564, 597 },
            { 0, 321 },
            { 322, 478 }//pat
        });

        this.server_skinningentitiesliveframe_array[0].condition_boolean_supplier_array = new Supplier[]
        {
            () -> this.server_skinningentitiesliveframe_array[0].setFLoop(0, this.isZeroMove()),
            () -> this.server_skinningentitiesliveframe_array[0].setTLoop(1, this.server_work_byte_array[this.skinningentitiesbytes.SIT()] == 1),

            () -> !(this.skinningentitiesattack.state == 0 || this.skinningentitiesattack.state == 1) && this.server_skinningentitiesliveframe_array[0].setFLoopOffSet(2, 2) && this.skinningentitiesfindmove.endGoalT(),
            () ->
            {
                boolean result = this.skinningentitiesattack.state == 0 || this.skinningentitiesattack.state == 1;
                if (result)
                {
                    this.server_skinningentitiesliveframe_array[0].step = 1;

                    if (this.server_frame_int_array[this.server_skinningentitiesliveframe_array[0].integer_index] < this.server_skinningentitiesliveframe_array[0].int_2d_array[2][0] || this.server_frame_int_array[this.server_skinningentitiesliveframe_array[0].integer_index] >= this.server_skinningentitiesliveframe_array[0].int_2d_array[2][1])
                    {
                        this.server_frame_int_array[this.server_skinningentitiesliveframe_array[0].integer_index] = this.server_skinningentitiesliveframe_array[0].int_2d_array[2][0];
                        this.server_skinningentitiesliveframe_array[0].step = 0;
                        return true;
                    }

                    for (int attack_frame : this.skinningentitiesattack.attack_frame_int_array)
                    {
                        if (this.server_frame_int_array[this.server_skinningentitiesliveframe_array[0].integer_index] == attack_frame)
                        {
                            this.skinningentitiesattack.state = 1;
                            break;
                        }
                    }
                }

                return result;
            },

            () -> this.server_skinningentitiesliveframe_array[0].setTLoop(3, this.main_server_work_byte_array[this.skinningentitiesbytes.ATTACK()] == 1 && this.moveForward != 0),
            () -> this.server_skinningentitiesliveframe_array[0].setTLoop(4, this.moveForward != 0),
            //eat -> pat
            () -> this.server_skinningentitiesliveframe_array[0].setFLoopFree(9, this.skinningentitiesbytes.ON_PAT(), this.server_work_byte_array[this.skinningentitiesbytes.ON_PAT()] == 1),
            () -> this.server_skinningentitiesliveframe_array[0].setFLoopFree(5, this.skinningentitiesbytes.HARD_READY(), this.server_work_byte_array[this.skinningentitiesbytes.HARD_READY()] == 1),
            () -> this.server_skinningentitiesliveframe_array[0].setFLoopFree(6, this.skinningentitiesbytes.SOFT_READY(), this.server_work_byte_array[this.skinningentitiesbytes.SOFT_READY()] == 1),
            () -> this.server_skinningentitiesliveframe_array[0].setTLoop(7, this.main_server_work_byte_array[this.skinningentitiesbytes.ATTACK()] == 1),
            () -> this.server_skinningentitiesliveframe_array[0].setTLoop(8)
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
        return new MYuzuRender(this.bothdata, RenderHelper.DATALOADER, this);
    }
}

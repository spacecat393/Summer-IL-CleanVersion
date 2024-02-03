package com.nali.list.entities;

import com.nali.data.BothData;
import com.nali.render.SkinningRender;
import com.nali.small.entities.bytes.SkinningEntitiesBytes;
import com.nali.small.entities.skinning.SkinningEntities;
import com.nali.small.entities.skinning.ai.frame.SkinningEntitiesLiveFrame;
import com.nali.summer.data.IrohaData;
import com.nali.summer.entities.bytes.IrohaBytes;
import com.nali.summer.render.RenderHelper;
import com.nali.summer.render.IrohaRender;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;

import java.util.function.Supplier;

public class SummerIroha extends SkinningEntities
{
    public static int eggPrimary = 0xadb7c1;
    public static int eggSecondary = 0xc95b7e;
    public final static DataParameter<Integer>[] INTEGER_DATAPARAMETER_ARRAY = new DataParameter[IrohaData.MAX_FRAME];
    public final static DataParameter<Float>[] FLOAT_DATAPARAMETER_ARRAY = new DataParameter[1];

    static
    {
        for (int i = 0; i < INTEGER_DATAPARAMETER_ARRAY.length; ++i)
        {
            INTEGER_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerIroha.class, DataSerializers.VARINT);
        }

        for (int i = 0; i < FLOAT_DATAPARAMETER_ARRAY.length; ++i)
        {
            FLOAT_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerIroha.class, DataSerializers.FLOAT);
        }
    }

    public SummerIroha(World world)
    {
        super(world);
    }

    @Override
    public void updateClient()
    {
        SkinningRender skinningrender = (SkinningRender)this.client_object;
        int frame = skinningrender.frame_int_array[0];

        float scale = skinningrender.scale;
        if (frame > 257)
        {
            this.width = 1.7F * scale;
            this.height = 1.5F * scale;
            skinningrender.model_boolean_array[4] = true;
            skinningrender.model_boolean_array[5] = true;
        }
        else
        {
            this.width = this.bothdata.Width() * scale;
            this.height = this.bothdata.Height() * scale;
            skinningrender.model_boolean_array[4] = false;
            skinningrender.model_boolean_array[5] = false;
        }
    }

    @Override
    public BothData createBothData()
    {
        return new IrohaData();
    }

    @Override
    public SkinningEntitiesBytes createBytes()
    {
        return new IrohaBytes();
    }

    @Override
    public void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.05D);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(40.0D);
    }

    @Override
    public void createServer()
    {
        this.server_skinningentitiesliveframe_array = new SkinningEntitiesLiveFrame[1];

        this.skinningentitiesattack.attack_frame_int_array = new int[]
        {
            534,
            789
        };
        this.skinningentitiesattack.max_ammo = 1;
        this.skinningentitiesattack.minimum_distance = 32.0F;

        this.server_skinningentitiesliveframe_array[0] = new SkinningEntitiesLiveFrame(this, 0, new int[][]
        {
            { 321, 371 },
            { 635, 685 },
            { 516, 532 },//start attack
            { 423, 473 },//loop move
            { 474, 515 },//end move
            { 143, 206 },//cafe walk
            { 51, 142 },
            { 258, 320 },
            { 207, 257 },
            { 372, 422 },
            { 0, 50 },
            { 533, 566 },
            { 567, 583 },
            { 584, 634 },
            { 686, 719 },// 14 start ride
            { 720, 770 },// 15 loop ride
            { 1034, 1084 },// 16 loop ride-move
            { 941, 982 },// 17 end ride-move
            { 983, 1033 },// 18 ride-panic
            { 890, 940 },// 19 ride-destroy
            { 771, 787 },// 20 start ride-attack
            { 788, 821 },// 21 loop ride-attack
            { 822, 838 },// 22 end ride-attack
            { 839, 889 }// 23 ride-reload
        });

        this.server_skinningentitiesliveframe_array[0].condition_boolean_supplier_array = new Supplier[]
        {
            () ->
            {
                int id = 14;
                boolean result = this.server_skinningentities != null && this.server_skinningentities.skinningentitiesplaywith.first_playwith;
                if (result)
                {
                    this.server_skinningentities.server_skinningentitiesliveframe_array[0].setFLoop(id - 1, true);
                    this.server_skinningentities.server_skinningentitiesliveframe_array[0].stepFrame();
                    if (this.server_frame_int_array[this.server_skinningentitiesliveframe_array[0].integer_index] == this.server_skinningentitiesliveframe_array[0].int_2d_array[id][1])
                    {
                        this.server_skinningentities.skinningentitiesplaywith.first_playwith = false;
                    }
                }

                return this.server_skinningentitiesliveframe_array[0].setFLoop(id, result);
            },
            () ->
            {
                int id = 19;
                boolean result = this.server_skinningentitiesliveframe_array[0].setFLoop(id, this.server_skinningentities != null && this.isZeroMove());
                if (result)
                {
                    this.server_skinningentities.server_skinningentitiesliveframe_array[0].setFLoop(id - 1, true);
                    this.server_skinningentities.server_skinningentitiesliveframe_array[0].stepFrame();
                }

                return result;
            },
            () ->
            {
                int id = 18;
                boolean result = this.server_skinningentities != null && this.server_skinningentitiesliveframe_array[0].setTLoopFB(id, this.server_work_byte_array[this.skinningentitiesbytes.SIT()] == 1);
                if (result)
                {
                    this.server_skinningentities.server_skinningentitiesliveframe_array[0].setTLoopFB(id - 1, true);
                    this.server_skinningentities.server_skinningentitiesliveframe_array[0].stepFrame();
                }

                return result;
            },
            () ->
            {
                int id0 = 16;
                int id1 = 17;
                boolean result = this.server_skinningentities != null && this.moveForward == 0 && this.server_skinningentitiesliveframe_array[0].setFLoopOffSet(id0, id1);
                if (result)
                {
                    this.server_skinningentities.server_skinningentitiesliveframe_array[0].setFLoopOffSet(id0 - 1, id1 - 1);
                    this.server_skinningentities.server_skinningentitiesliveframe_array[0].stepFrame();
                }

                return result;
            },
            () ->
            {
                int id0 = 20, id1 = 21, id2 = 22, id3 = 23;
                boolean result = this.server_skinningentities != null && this.server_skinningentitiesliveframe_array[0].setShoot(id0, id1, id2, id3, false, this.skinningentitiesattack);
                if (result)
                {
                    int id;
                    int frame = this.server_frame_int_array[0];
                    if (frame >= this.server_skinningentitiesliveframe_array[0].int_2d_array[id0][0] && frame <= this.server_skinningentitiesliveframe_array[0].int_2d_array[id0][1])
                    {
                        id = id0 - 1;
                    }
                    else if (frame >= this.server_skinningentitiesliveframe_array[0].int_2d_array[id1][0] && frame <= this.server_skinningentitiesliveframe_array[0].int_2d_array[id1][1])
                    {
                        id = id1 - 1;
                    }
                    else if (frame >= this.server_skinningentitiesliveframe_array[0].int_2d_array[id2][0] && frame <= this.server_skinningentitiesliveframe_array[0].int_2d_array[id2][1])
                    {
                        id = id1 - 1;
                    }
                    else
                    {
                        id = id3 - 1;
                    }

                    this.server_skinningentities.server_skinningentitiesliveframe_array[0].setFLoop(id, true);
                    this.server_skinningentities.server_skinningentitiesliveframe_array[0].step = this.server_skinningentitiesliveframe_array[0].step;
                    this.server_skinningentities.server_skinningentitiesliveframe_array[0].stepFrame();
                }

                return result;
            },
            () ->
            {
                int id = 15;
                boolean result = this.server_skinningentitiesliveframe_array[0].setTLoop(id, this.server_skinningentities != null);
                if (result)
                {
                    this.server_skinningentities.server_skinningentitiesliveframe_array[0].setTLoop(id - 1, true);
                    this.server_skinningentities.server_skinningentitiesliveframe_array[0].stepFrame();
                }

                return result;
            },

            () -> this.server_skinningentitiesliveframe_array[0].setFLoop(0, this.isZeroMove()),
            () -> this.server_skinningentitiesliveframe_array[0].setTLoopFB(1, this.server_work_byte_array[this.skinningentitiesbytes.SIT()] == 1),
            () -> this.main_server_work_byte_array[this.skinningentitiesbytes.ATTACK()] == 1 && this.moveForward == 0 && this.server_skinningentitiesliveframe_array[0].setFLoopOffSet(3, 4),
            () -> this.server_skinningentitiesliveframe_array[0].setShoot(2, 11, 12, 13, false, this.skinningentitiesattack),
            () -> this.server_skinningentitiesliveframe_array[0].setTLoop(3, this.main_server_work_byte_array[this.skinningentitiesbytes.ATTACK()] == 1 && this.moveForward != 0),
            () -> this.server_skinningentitiesliveframe_array[0].setTLoop(5, this.moveForward != 0),
            () -> this.server_skinningentitiesliveframe_array[0].setFLoopFree(6, this.skinningentitiesbytes.ON_PAT(), this.server_work_byte_array[this.skinningentitiesbytes.ON_PAT()] == 1),
            //eat -> pat
            () -> this.server_skinningentitiesliveframe_array[0].setFLoopFree(7, this.skinningentitiesbytes.HARD_READY(), this.server_work_byte_array[this.skinningentitiesbytes.HARD_READY()] == 1),
            () -> this.server_skinningentitiesliveframe_array[0].setFLoopFree(8, this.skinningentitiesbytes.SOFT_READY(), this.server_work_byte_array[this.skinningentitiesbytes.SOFT_READY()] == 1),
            () -> this.server_skinningentitiesliveframe_array[0].setFLoop(9, this.main_server_work_byte_array[this.skinningentitiesbytes.ATTACK()] == 1),
            () -> this.server_skinningentitiesliveframe_array[0].setTLoop(10)
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
        return new IrohaRender(this.bothdata, RenderHelper.DATALOADER, this);
    }
}

package com.nali.list.entities;

import com.nali.data.BothData;
import com.nali.render.SkinningRender;
import com.nali.small.entities.bytes.WorkBytes;
import com.nali.small.entities.memory.ClientEntitiesMemory;
import com.nali.small.entities.memory.server.ServerEntitiesMemory;
import com.nali.small.entities.skinning.SkinningEntities;
import com.nali.small.entities.skinning.ai.frame.SkinningEntitiesLiveFrame;
import com.nali.summer.data.IbukiData;
import com.nali.summer.entities.bytes.IbukiBytes;
import com.nali.summer.entities.memory.client.ClientIbukiMemory;
import com.nali.summer.render.IbukiRender;
import com.nali.summer.render.RenderHelper;
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
        ClientIbukiMemory cliententitiesmemory = (ClientIbukiMemory)this.bothentitiesmemory;
        SkinningRender skinningrender = (SkinningRender)cliententitiesmemory.objectrender;
        BothData bothdata = cliententitiesmemory.bothdata;
        int frame = skinningrender.frame_int_array[0];

        if (this.ticksExisted % 200 == 0)
        {
            skinningrender.model_boolean_array[0 + 6] = false;
            skinningrender.model_boolean_array[1 + 6] = false;
            skinningrender.model_boolean_array[11 + 6] = false;
            skinningrender.model_boolean_array[2 + 6] = true;
            skinningrender.model_boolean_array[12 + 6] = true;
            cliententitiesmemory.client_eyes_tick = 20;
        }
        else if (--cliententitiesmemory.client_eyes_tick <= 0)
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
            this.width = bothdata.Width() * scale;
            this.height = bothdata.Height() * scale;
        }
    }

    @Override
    public void initFakeFrame()
    {
        ClientEntitiesMemory cliententitiesmemory = (ClientEntitiesMemory)this.bothentitiesmemory;
        SkinningRender skinningrender = (SkinningRender)cliententitiesmemory.objectrender;
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
    public WorkBytes createWorkBytes()
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
        ServerEntitiesMemory serverentitiesmemory = (ServerEntitiesMemory)this.bothentitiesmemory;
        WorkBytes workbytes = serverentitiesmemory.workbytes;
        serverentitiesmemory.entitiesaimemory.skinningentitiesplaywith.clasz = SummerIroha.class;

        serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array = new SkinningEntitiesLiveFrame[1];

        serverentitiesmemory.entitiesaimemory.skinningentitiesattack.attack_frame_int_array = ATTACK_FRAME_INT_ARRAY;
        serverentitiesmemory.entitiesaimemory.skinningentitiesattack.max_ammo = 32;
        serverentitiesmemory.entitiesaimemory.skinningentitiesattack.minimum_distance = 17.0F;

        serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0] = new SkinningEntitiesLiveFrame(this, 0, FRAME_INT_2D_ARRAY);
        serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].condition_boolean_supplier_array = new Supplier[]
        {
            () ->
            {
                boolean result = serverentitiesmemory.entitiesaimemory.skinningentitiesplaywith.should_play;
                serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].lock = result;
                return result;
            },
            () -> this.isZeroMove() && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoop(0),
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
        ClientEntitiesMemory cliententitiesmemory = (ClientEntitiesMemory)this.bothentitiesmemory;
//        cliententitiesmemory.itemlayerrender.left_hand_y = -179.9285F;
//        cliententitiesmemory.itemlayerrender.left_hand_p = -5.5769753F;
//        cliententitiesmemory.itemlayerrender.right_hand_y = -5.5689473F;
//        cliententitiesmemory.itemlayerrender.right_hand_p = -6.0838437F;
//        cliententitiesmemory.itemlayerrender.head_y = -91.6525F;
//        cliententitiesmemory.itemlayerrender.head_p = 4.104715F;
//        cliententitiesmemory.itemlayerrender.legs_y = 84.03490369025576F / 2.0F + 180.0F;
//        cliententitiesmemory.itemlayerrender.legs_p = 6.773068689298493F;
//        cliententitiesmemory.itemlayerrender.feet_y = -17.22647259946362F / 2.0F;
//        cliententitiesmemory.itemlayerrender.feet_p = -174.64395393898405F;

        cliententitiesmemory.itemlayerrender.left_hand_i = 0;
        cliententitiesmemory.itemlayerrender.left_hand_v = 4;

        cliententitiesmemory.itemlayerrender.right_hand_i = 1;
        cliententitiesmemory.itemlayerrender.right_hand_v = 5;

        cliententitiesmemory.itemlayerrender.mouth_i = 20;
        cliententitiesmemory.itemlayerrender.mouth_v = 0;

        cliententitiesmemory.itemlayerrender.head_i = 5;
        cliententitiesmemory.itemlayerrender.head_v = 1;

        cliententitiesmemory.itemlayerrender.chest_i = 4;
        cliententitiesmemory.itemlayerrender.chest_v = 6;

        cliententitiesmemory.itemlayerrender.legs_i = 3;
        cliententitiesmemory.itemlayerrender.legs_v = 0;

        cliententitiesmemory.itemlayerrender.feet_i = 2;
        cliententitiesmemory.itemlayerrender.feet_v = 0;
        return new IbukiRender(this.bothentitiesmemory.bothdata, RenderHelper.DATALOADER, this);
    }

    @Override
    public void onShouldPlayWith()
    {
        ServerEntitiesMemory serverentitiesmemory = (ServerEntitiesMemory)this.bothentitiesmemory;
        float scale = this.getDataManager().get(this.getFloatDataParameterArray()[0]);
        float height = 1.5F * scale;

        SkinningEntities playwith_skinningentities = serverentitiesmemory.entitiesaimemory.skinningentitiesplaywith.playwith_skinningentities;
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
        if (this.world.isRemote || ((ServerEntitiesMemory)this.bothentitiesmemory).entitiesaimemory.skinningentitiesplaywith == null || !((ServerEntitiesMemory)this.bothentitiesmemory).entitiesaimemory.skinningentitiesplaywith.should_play)
        {
            super.collideWithNearbyEntities();
        }
    }

    @Override
    public boolean canBePushed()
    {
        return this.world.isRemote || ((ServerEntitiesMemory)this.bothentitiesmemory).entitiesaimemory.skinningentitiesplaywith == null || !((ServerEntitiesMemory)this.bothentitiesmemory).entitiesaimemory.skinningentitiesplaywith.should_play;
    }

    @Override
    public ClientEntitiesMemory createClientEntitiesMemory(BothData bothdata, WorkBytes workbytes)
    {
        return new ClientIbukiMemory(bothdata, workbytes);
    }
}

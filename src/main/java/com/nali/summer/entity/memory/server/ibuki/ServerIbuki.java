package com.nali.summer.entity.memory.server.ibuki;

import com.nali.data.IBothDaNe;
import com.nali.data.IBothDaSn;
import com.nali.list.entity.SummerIroha;
import com.nali.small.entity.EntityLeInv;
import com.nali.small.entity.IMixLe;
import com.nali.small.entity.Inventory;
import com.nali.small.entity.memo.server.ServerSleInv;
import com.nali.small.entity.memo.server.ai.MixAIE;
import com.nali.small.entity.memo.server.ai.frame.FrameS;
import com.nali.sound.ISoundLe;
import net.minecraft.network.datasync.DataParameter;

import java.util.function.Supplier;

public class ServerIbuki<SD extends ISoundLe, BD extends IBothDaNe & IBothDaSn, E extends EntityLeInv, I extends IMixLe<SD, BD, E>, A extends MixAIE<SD, BD, E, I, ?>> extends ServerSleInv<SD, BD, E, I, A>
{
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

    public FrameS[] frames_array;

    public ServerIbuki(I i, Inventory inventory)
    {
        super(i, inventory);
    }

    @Override
    public void initFrame()
    {

    }

    @Override
    public FrameS[] getFrameSArray()
    {
        return frames_array;
    }

    @Override
    public int[][] getFrame2DIntArray()
    {
        return FRAME_INT_2D_ARRAY;
    }

    @Override
    public void updateServer()
    {

    }

    @Override
    public void createServer()
    {
        ServerEntitiesMemory serverentitiesmemory = (ServerEntitiesMemory)this.bothentitiesmemory;
        WorkBytes workbytes = serverentitiesmemory.workbytes;
        serverentitiesmemory.entitiesaimemory.skinningentitiesplaywith.clasz = SummerIroha.class;

        serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array = new SkinningEntitiesLiveFrame[1];

        serverentitiesmemory.entitiesaimemory.skinningentitiesattack.attack_frame_int_array = ATTACK_FRAME_INT_ARRAY;
        serverentitiesmemory.entitiesaimemory.skinningentitiesattack.max_magic_point = 32;
        serverentitiesmemory.entitiesaimemory.skinningentitiesattack.minimum_distance = 17.0F;

        serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0] = new SkinningEntitiesLiveFrame(this, 0, FRAME_INT_2D_ARRAY);
        serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].condition_boolean_supplier_array = new Supplier[]
                {
                        () -> this.isZeroMove() && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoop(0),
                        () -> (serverentitiesmemory.current_work_byte_array[workbytes.SIT() / 8] >> workbytes.SIT() % 8 & 1) == 1 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(1),
                        () -> (serverentitiesmemory.main_work_byte_array[workbytes.ATTACK() / 8] >> workbytes.ATTACK() % 8 & 1) == 1 && this.moveForward == 0 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopOffSet(3, 4),
                        () -> serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setShoot(2, 10, 11, 12, false, serverentitiesmemory.entitiesaimemory.skinningentitiesattack),
                        () -> (serverentitiesmemory.main_work_byte_array[workbytes.ATTACK() / 8] >> workbytes.ATTACK() % 8 & 1) == 1 && this.moveForward != 0 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(3),
                        () -> this.moveForward != 0 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(5),
                        () -> (serverentitiesmemory.statentitiesmemory.stat & 4) == 4 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopFree(6, (byte)4),
                        () -> ((serverentitiesmemory.statentitiesmemory.stat & 1) == 1 || (serverentitiesmemory.statentitiesmemory.stat & 2) == 2 || (serverentitiesmemory.statentitiesmemory.stat & 8) == 8) && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopFree(7, (byte)(1 + 2 + 8)),
                        () -> (serverentitiesmemory.main_work_byte_array[workbytes.ATTACK() / 8] >> workbytes.ATTACK() % 8 & 1) == 1 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(8),
                        () -> serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(9)
                };
    }

    @Override
    public void updateServer()
    {
        ServerEntitiesMemory serverentitiesmemory = (ServerEntitiesMemory)this.bothentitiesmemory;
        super.updateServer();

//        if (serverentitiesmemory.entitiesaimemory.skinningentitiesplaywith.playwith_skinningentities != null && ((WorldServer)this.world).getEntityFromUuid(serverentitiesmemory.entitiesaimemory.skinningentitiesplaywith.playwith_skinningentities.getUniqueID()) == null)
//        {
//            serverentitiesmemory.entitiesaimemory.skinningentitiesplaywith.playwith_skinningentities = null;
//        }

        if (!serverentitiesmemory.entitiesaimemory.skinningentitiesplaywith.should_play && (serverentitiesmemory.sync_byte_array[0] & 128) == 128)
        {
            serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].lock = false;
            serverentitiesmemory.sync_byte_array[0] ^= (byte)128;
            this.getDataManager().set(this.getByteDataParameterArray()[0], serverentitiesmemory.sync_byte_array[0]);
        }
    }

    @Override
    public void onShouldPlayWith()
    {
        super.onShouldPlayWith();
        ServerEntitiesMemory serverentitiesmemory = (ServerEntitiesMemory)this.bothentitiesmemory;
        SkinningEntities playwith_skinningentities = serverentitiesmemory.entitiesaimemory.skinningentitiesplaywith.playwith_skinningentities;

        DataParameter<Byte> byte_dataparameter = this.getByteDataParameterArray()[0];
        serverentitiesmemory.sync_byte_array[0] = this.getDataManager().get(byte_dataparameter);
        if ((serverentitiesmemory.sync_byte_array[0] & 128) == 0)
        {
            serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].lock = true;
            serverentitiesmemory.sync_byte_array[0] ^= (byte)128;
            this.getDataManager().set(byte_dataparameter, serverentitiesmemory.sync_byte_array[0]);
        }
        this.getDataManager().set(this.getIntegerDataParameterArray()[1], playwith_skinningentities.getDataManager().get(playwith_skinningentities.getIntegerDataParameterArray()[0]));
        this.getDataManager().set(this.getFloatDataParameterArray()[1], playwith_skinningentities.getDataManager().get(playwith_skinningentities.getFloatDataParameterArray()[0]));
    }
}

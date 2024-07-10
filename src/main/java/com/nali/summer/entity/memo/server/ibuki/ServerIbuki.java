package com.nali.summer.entity.memo.server.ibuki;

import com.nali.small.entity.EntityLeInv;
import com.nali.small.entity.IMixLe;
import com.nali.small.entity.Inventory;
import com.nali.small.entity.memo.server.ServerSleInv;
import com.nali.small.entity.memo.server.ai.frame.FrameS;
import com.nali.small.entity.memo.server.ai.frame.floop.FrameSleFLoopDie;
import com.nali.small.entity.memo.server.ai.frame.floop.FrameSleFLoopDieSSle;
import com.nali.small.entity.memo.server.ai.frame.floop.FrameSleFLoopSSleStart;
import com.nali.small.entity.memo.server.ai.frame.floopfree.FrameSFLoopFreeHardReady;
import com.nali.small.entity.memo.server.ai.frame.floopfree.FrameSleFLoopFreePSrE;
import com.nali.small.entity.memo.server.ai.frame.floopoffset.FrameSleFLoopOffSetAttackEndWalk;
import com.nali.small.entity.memo.server.ai.frame.floopoffset.FrameSleFLoopOffSetAttackEndWalkSSle;
import com.nali.small.entity.memo.server.ai.frame.shoot.FrameSleShoot;
import com.nali.small.entity.memo.server.ai.frame.shoot.FrameSleShootSSle;
import com.nali.small.entity.memo.server.ai.frame.tloop.*;
import com.nali.small.entity.memo.server.ai.frame.tloopfb.FrameSleTLoopFBSitSSle;
import com.nali.sound.ISoundDaLe;
import com.nali.summer.da.both.BothDaIbuki;

public class ServerIbuki<SD extends ISoundDaLe, BD extends BothDaIbuki<SD>, E extends EntityLeInv, I extends IMixLe<SD, BD, E>, A extends MixAIIbuki<SD, BD, E, I, ?>> extends ServerSleInv<SD, BD, E, I, A>
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
    public static byte[] FRAME_BYTE_ARRAY = new byte[]
    {
        0, 13,
        0, 18,
        0, 17,
        0, 15, 16,
        0, 19, 20, 21, 22,

        0, 0,
        0, 1,
        0, 3, 4,
        0, 2, 10, 11, 12,
        0, 3,
        0, 5,
        0, 6,
        0, 7,
        0, 8,
        0, 9
    };
    public FrameS[][] frames_2d_array;
//    public AILePlayWithSSle aileplaywithssle;

    public ServerIbuki(I i, Inventory inventory)
    {
        super(i, inventory);
    }

    @Override
    public void initFrame()
    {
        this.frames_2d_array = new FrameS[][]
        {
            {
                new FrameSleFLoopSSleStart(this, 0),
                new FrameSleFLoopDieSSle(this, 2),
                new FrameSleTLoopFBSitSSle(this, 4),
                new FrameSleFLoopOffSetAttackEndWalkSSle(this, 6),
                new FrameSleShootSSle(this, 9),
                new FrameSleTLoopSSleRSeStand(this, 14),

                new FrameSleFLoopDie(this, /*0+*/19),
                new FrameSTLoopSit(this, 2+19),
                new FrameSleFLoopOffSetAttackEndWalk(this, 4+19),
                new FrameSleShoot(this, 7+19),
                new FrameSleTLoopAttackWalk(this, 12+19),
                new FrameSleTLoopWalk(this, 14+19),
                new FrameSFLoopFreeHardReady(this, 16+19),
                new FrameSleFLoopFreePSrE(this, 18+19),
                new FrameSleTLoopAttackStand(this, 20+19),
                new FrameSTLoop(this, 22+19)
            }
        };
//        () -> this.isZeroMove() && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoop(0),
//        () -> (serverentitiesmemory.current_work_byte_array[workbytes.SIT() / 8] >> workbytes.SIT() % 8 & 1) == 1 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(1),
//        () -> (serverentitiesmemory.main_work_byte_array[workbytes.ATTACK() / 8] >> workbytes.ATTACK() % 8 & 1) == 1 && this.moveForward == 0 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopOffSet(3, 4),
//        () -> serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setShoot(2, 10, 11, 12, false, serverentitiesmemory.entitiesaimemory.skinningentitiesattack),
//        () -> (serverentitiesmemory.main_work_byte_array[workbytes.ATTACK() / 8] >> workbytes.ATTACK() % 8 & 1) == 1 && this.moveForward != 0 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(3),
//        () -> this.moveForward != 0 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(5),
//        () -> (serverentitiesmemory.statentitiesmemory.stat & 4) == 4 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopFree(6, (byte)4),
//        () -> ((serverentitiesmemory.statentitiesmemory.stat & 1) == 1 || (serverentitiesmemory.statentitiesmemory.stat & 2) == 2 || (serverentitiesmemory.statentitiesmemory.stat & 8) == 8) && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopFree(7, (byte)(1 + 2 + 8)),
//        () -> (serverentitiesmemory.main_work_byte_array[workbytes.ATTACK() / 8] >> workbytes.ATTACK() % 8 & 1) == 1 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(8),
//        () -> serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(9)
    }

    @Override
    public void updateServer()
    {
//        if (serverentitiesmemory.entitiesaimemory.skinningentitiesplaywith.playwith_skinningentities != null && ((WorldServer)this.world).getEntityFromUuid(serverentitiesmemory.entitiesaimemory.skinningentitiesplaywith.playwith_skinningentities.getUniqueID()) == null)
//        {
//            serverentitiesmemory.entitiesaimemory.skinningentitiesplaywith.playwith_skinningentities = null;
//        }

//        if (!serverentitiesmemory.entitiesaimemory.skinningentitiesplaywith.should_play && (serverentitiesmemory.sync_byte_array[0] & 128) == 128)
        if (this.a.aileplaywithssle.s2 == null && (this.sync_byte_array[0] & 128) == 128)
        {
//            serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].lock = false;
            this.sync_byte_array[0] ^= (byte)128;
            this.i.getE().getDataManager().set(this.i.getByteDataParameterArray()[0], this.sync_byte_array[0]);
        }
    }

//    @Override
//    public void onShouldPlayWith()
//    {
//        super.onShouldPlayWith();
//        ServerEntitiesMemory serverentitiesmemory = (ServerEntitiesMemory)this.bothentitiesmemory;
//        SkinningEntities playwith_skinningentities = serverentitiesmemory.entitiesaimemory.skinningentitiesplaywith.playwith_skinningentities;
//
//        DataParameter<Byte> byte_dataparameter = this.getByteDataParameterArray()[0];
//        serverentitiesmemory.sync_byte_array[0] = this.getDataManager().get(byte_dataparameter);
//        if ((serverentitiesmemory.sync_byte_array[0] & 128) == 0)
//        {
//            serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].lock = true;
//            serverentitiesmemory.sync_byte_array[0] ^= (byte)128;
//            this.getDataManager().set(byte_dataparameter, serverentitiesmemory.sync_byte_array[0]);
//        }
//        this.getDataManager().set(this.getIntegerDataParameterArray()[1], playwith_skinningentities.getDataManager().get(playwith_skinningentities.getIntegerDataParameterArray()[0]));
//        this.getDataManager().set(this.getFloatDataParameterArray()[1], playwith_skinningentities.getDataManager().get(playwith_skinningentities.getFloatDataParameterArray()[0]));
//    }

//    @Override
//    public void collideWithNearbyEntities()
//    {
//        if (this.world.isRemote || ((ServerEntitiesMemory)this.bothentitiesmemory).entitiesaimemory.skinningentitiesplaywith.playwith_skinningentities == null || !((ServerEntitiesMemory)this.bothentitiesmemory).entitiesaimemory.skinningentitiesplaywith.should_play)
//        {
//            super.collideWithNearbyEntities();
//        }
//    }
//
//    @Override
//    public boolean canBePushed()
//    {
//        return this.world.isRemote || ((ServerEntitiesMemory)this.bothentitiesmemory).entitiesaimemory.skinningentitiesplaywith.playwith_skinningentities == null || !((ServerEntitiesMemory)this.bothentitiesmemory).entitiesaimemory.skinningentitiesplaywith.should_play;
//    }

    @Override
    public FrameS[][] getFrameS2DArray()
    {
        return this.frames_2d_array;
    }

    @Override
    public byte[] getFrameByteArray()
    {
        return FRAME_BYTE_ARRAY;
    }

    @Override
    public int[][] getFrame2DIntArray()
    {
        return FRAME_INT_2D_ARRAY;
    }
}

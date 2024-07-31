package com.nali.summer.entity.memo.server.natsu;

import com.nali.da.IBothDaNe;
import com.nali.da.IBothDaSn;
import com.nali.small.entity.EntityLeInv;
import com.nali.small.entity.IMixLe;
import com.nali.small.entity.Inventory;
import com.nali.small.entity.memo.server.ServerSleInv;
import com.nali.small.entity.memo.server.ai.MixAIE;
import com.nali.small.entity.memo.server.ai.frame.FrameS;
import com.nali.small.entity.memo.server.ai.frame.FrameSleHeal;
import com.nali.small.entity.memo.server.ai.frame.floop.FrameSleFLoopDie;
import com.nali.small.entity.memo.server.ai.frame.floopfree.FrameSFLoopFreeHardReady;
import com.nali.small.entity.memo.server.ai.frame.floopfree.FrameSleFLoopFreePSrE;
import com.nali.small.entity.memo.server.ai.frame.floopoffset.FrameSleFLoopOffSetAttackEndWalk;
import com.nali.small.entity.memo.server.ai.frame.shoot.FrameSleShootBF;
import com.nali.small.entity.memo.server.ai.frame.tloop.*;
import com.nali.sound.ISoundDaLe;

public class ServerNatsu<SD extends ISoundDaLe, BD extends IBothDaNe & IBothDaSn, E extends EntityLeInv, I extends IMixLe<SD, BD, E>, A extends MixAIE<SD, BD, E, I, ?>> extends ServerSleInv<SD, BD, E, I, A>
{
    public static int[][] FRAME_INT_2D_ARRAY = new int[][]
    {
        { 766, 822 },
        { 405, 488 },
        { 684, 696 },
        { 489, 509 },
        { 510, 535 },
        { 185, 225 },
        { 1029, 1066 },
        { 68, 184 },
        { 536, 569 },
        { 0, 66 },
        { 697, 712 },
        { 713, 723 },
        { 570, 607 },
        { 823, 868 }
    };
    public static byte[] FRAME_BYTE_ARRAY = new byte[]
    {
        0, 0,
        0, 1,
        0, 3, 4,
        0, 2, 10, 11, 12,
        0, 13,
        0, 3,
        0, 5,
        0, 6,
        0, 7,
        0, 8,
        0, 9
    };
    public FrameS[][] frames_2d_array;

    public ServerNatsu(I i, Inventory inventory)
    {
        super(i, inventory);
    }

    @Override
    public void initFrame()
    {
        this.frames_2d_array = new FrameS[][]
        {
            {
                new FrameSleFLoopDie(this, 0),
                new FrameSTLoopSit(this, 2),
                new FrameSleFLoopOffSetAttackEndWalk(this, 4),
                new FrameSleShootBF(this, 7),
                new FrameSleHeal(this, 12),
                new FrameSleTLoopAttackWalk(this, 14),
                new FrameSleTLoopWalk(this, 16),
                new FrameSFLoopFreeHardReady(this, 18),
                new FrameSleFLoopFreePSrE(this, 20),
                new FrameSleTLoopAttackStand(this, 22),
                new FrameSTLoop(this, 24)
            }
        };
//        () -> this.isZeroMove() && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoop(0),
//        () -> (serverentitiesmemory.current_work_byte_array[workbytes.SIT() / 8] >> workbytes.SIT() % 8 & 1) == 1 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(1),
//        () -> (serverentitiesmemory.main_work_byte_array[workbytes.ATTACK() / 8] >> workbytes.ATTACK() % 8 & 1) == 1 && this.moveForward == 0 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopOffSet(3, 4),
//        () -> serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setShoot(2, 10, 11, 12, true, serverentitiesmemory.entitiesaimemory.skinningentitiesattack),
//        () -> serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setHeal(13, serverentitiesmemory.entitiesaimemory.skinningentitiesheal),
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

    }

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

package com.nali.summer.entity.memory.server.aris;

import com.nali.small.entity.EntityLeInv;
import com.nali.small.entity.IMixLe;
import com.nali.small.entity.Inventory;
import com.nali.small.entity.memo.server.ServerSleInv;
import com.nali.small.entity.memo.server.ai.frame.FrameS;
import com.nali.small.entity.memo.server.ai.frame.FrameSleShoot;
import com.nali.small.entity.memo.server.ai.frame.floop.FrameSleFLoopDie;
import com.nali.small.entity.memo.server.ai.frame.floopfree.FrameSFLoopFreeSit;
import com.nali.small.entity.memo.server.ai.frame.floopfree.FrameSleFLoopFreePSE;
import com.nali.small.entity.memo.server.ai.frame.floopoffset.FrameSleFLoopOffSetEndAttackWalk;
import com.nali.small.entity.memo.server.ai.frame.tloop.FrameSTLoop;
import com.nali.small.entity.memo.server.ai.frame.tloop.FrameSleTLoopAttackStand;
import com.nali.small.entity.memo.server.ai.frame.tloop.FrameSleTLoopAttackWalk;
import com.nali.small.entity.memo.server.ai.frame.tloop.FrameSleTLoopWalk;
import com.nali.small.entity.memo.server.ai.frame.tloopfb.FrameSTLoopFBSit;
import com.nali.sound.ISoundLe;
import com.nali.summer.data.both.BothDaAris;

public class ServerAris<SD extends ISoundLe, BD extends BothDaAris<SD>, E extends EntityLeInv, I extends IMixLe<SD, BD, E>, A extends MixAIAris<SD, BD, E, I, ?>> extends ServerSleInv<SD, BD, E, I, A>
{
    public static int[][] FRAME_INT_2D_ARRAY = new int[][]
    {
        { 738, 783 },
        { 835, 860 },
        { 560, 576 },
        { 932, 948 },
        { 949, 999 },
        { 173, 204 },
        { 522, 559 },
        { 81, 172 },
        { 861, 931 },
        { 0, 80 },
        { 577, 643 },
        { 644, 660 },
        { 687, 737 }
    };

    public FrameS[] frames_array;

    public ServerAris(I i, Inventory inventory)
    {
        super(i, inventory);
    }

    @Override
    public void updateServer()
    {

    }

    @Override
    public void initFrame()
    {
        this.frames_array = new FrameS[]
        {
            new FrameSleFLoopDie(this, (byte)0, (byte)0),
            new FrameSTLoopFBSit(this, (byte)0, (byte)1),
            new FrameSleFLoopOffSetEndAttackWalk(this, (byte)0, (byte)3, (byte)4),
            new FrameSleShoot(this, (byte)0, (byte)2, (byte)10, (byte)11, (byte)12),
            new FrameSleTLoopAttackWalk(this, (byte)0, (byte)3),
            new FrameSleTLoopWalk(this, (byte)0, (byte)5),
            new FrameSFLoopFreeSit(this, (byte)0, (byte)6),
            new FrameSleFLoopFreePSE(this, (byte)0, (byte)7),
            new FrameSleTLoopAttackStand(this, (byte)0, (byte)8),
            new FrameSTLoop(this, (byte)0, (byte)9)
        };
//        () -> this.isZeroMove() && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoop(0),
//        () -> (serverentitiesmemory.current_work_byte_array[workbytes.SIT() / 8] >> workbytes.SIT() % 8 & 1) == 1 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoopFB(1),
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
    public FrameS[] getFrameSArray()
    {
        return this.frames_array;
    }

    @Override
    public int[][] getFrame2DIntArray()
    {
        return FRAME_INT_2D_ARRAY;
    }
}

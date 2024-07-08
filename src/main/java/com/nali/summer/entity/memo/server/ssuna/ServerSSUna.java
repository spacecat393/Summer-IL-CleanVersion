package com.nali.summer.entity.memo.server.ssuna;

import com.nali.da.IBothDaNe;
import com.nali.da.IBothDaSn;
import com.nali.small.entity.EntityLeInv;
import com.nali.small.entity.IMixLe;
import com.nali.small.entity.Inventory;
import com.nali.small.entity.memo.server.ServerSleInv;
import com.nali.small.entity.memo.server.ai.MixAIE;
import com.nali.small.entity.memo.server.ai.frame.FrameS;
import com.nali.small.entity.memo.server.ai.frame.floop.FrameSleFLoopDie;
import com.nali.small.entity.memo.server.ai.frame.floopfree.FrameSFLoopFreeHardReady;
import com.nali.small.entity.memo.server.ai.frame.floopfree.FrameSleFLoopFreePSrE;
import com.nali.small.entity.memo.server.ai.frame.floopoffset.FrameSleFLoopOffSetAttackEndWalk;
import com.nali.small.entity.memo.server.ai.frame.shoot.FrameSleShootReloadPlus;
import com.nali.small.entity.memo.server.ai.frame.tloop.FrameSTLoop;
import com.nali.small.entity.memo.server.ai.frame.tloop.FrameSleTLoopAttackStand;
import com.nali.small.entity.memo.server.ai.frame.tloop.FrameSleTLoopAttackWalk;
import com.nali.small.entity.memo.server.ai.frame.tloop.FrameSleTLoopWalk;
import com.nali.small.entity.memo.server.ai.frame.tloopfb.FrameSTLoopFBSit;
import com.nali.sound.ISoundDaLe;

public class ServerSSUna<SD extends ISoundDaLe, BD extends IBothDaNe & IBothDaSn, E extends EntityLeInv, I extends IMixLe<SD, BD, E>, A extends MixAIE<SD, BD, E, I, ?>> extends ServerSleInv<SD, BD, E, I, A>
{
    public static int[][] FRAME_INT_2D_ARRAY = new int[][]
    {
        { 264, 314 },
        { 315, 350 },
        { 470, 483 },
        { 612, 628 },
        { 629, 659 },
        { 232, 263 },
        { 432, 469 },
        { 81, 231 },
        { 660, 690 },
        { 0, 80 },
        { 484, 499 },
        { 500, 513 },
        { 514, 562 },
        { 563, 611 }
    };
    public static byte[] FRAME_BYTE_ARRAY = new byte[]
    {
        0, 0,
        0, 1,
        0, 3, 4,
        0, 2, 10, 11, 2, 13, 12,
        0, 3,
        0, 6,
        0, 7,
        0, 8,
        0, 9
    };
    public FrameS[][] frames_2d_array;

    //    public boolean server_step_reload;
    public ServerSSUna(I i, Inventory inventory)
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
                new FrameSTLoopFBSit(this, 2),
                new FrameSleFLoopOffSetAttackEndWalk(this, 4),
                new FrameSleShootReloadPlus(this, 7/*, (byte)2*/),
                new FrameSleTLoopAttackWalk(this, 13+1+2),
                new FrameSleTLoopWalk(this, 15+1+2),
                new FrameSFLoopFreeHardReady(this, 17+1+2),
                new FrameSleFLoopFreePSrE(this, 19+1+2),
                new FrameSleTLoopAttackStand(this, 21+1+2),
                new FrameSTLoop(this, 23+1+2)
            }
        };
//        () -> this.isZeroMove() && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoop(0),
//        () -> (serverentitiesmemory.current_work_byte_array[workbytes.SIT() / 8] >> workbytes.SIT() % 8 & 1) == 1 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoopFB(1),
//        () -> (serverentitiesmemory.main_work_byte_array[workbytes.ATTACK() / 8] >> workbytes.ATTACK() % 8 & 1) == 1 && this.moveForward == 0 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopOffSet(3, 4),
//        () ->
//        {
//            int id = 13;
//            if (serverentitiesmemory.entitiesaimemory.skinningentitiesattack.magic_point <= 0)
//            {
//                if (serverentitiesmemory.server_step_reload)
//                {
//                    id = 12;
//                }
//            }
//            else
//            {
//                if (this.ticksExisted % 50 == 0)
//                {
//                    serverentitiesmemory.server_step_reload = !serverentitiesmemory.server_step_reload;
//                }
//            }
//
//            return serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setShoot(2, 10, 11, id, false, serverentitiesmemory.entitiesaimemory.skinningentitiesattack);
//        },
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

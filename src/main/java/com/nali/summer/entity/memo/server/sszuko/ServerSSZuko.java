package com.nali.summer.entity.memo.server.sszuko;

import com.nali.da.IBothDaNe;
import com.nali.da.IBothDaSn;
import com.nali.small.entity.EntityLeInv;
import com.nali.small.entity.IMixLe;
import com.nali.small.entity.Inventory;
import com.nali.small.entity.memo.server.ServerSleInv;
import com.nali.small.entity.memo.server.ai.MixAIE;
import com.nali.small.entity.memo.server.ai.frame.FrameS;
import com.nali.sound.ISoundDaLe;

import java.util.function.Supplier;

public class ServerSSZuko<SD extends ISoundDaLe, BD extends IBothDaNe & IBothDaSn, E extends EntityLeInv, I extends IMixLe<SD, BD, E>, A extends MixAIE<SD, BD, E, I, ?>> extends ServerSleInv<SD, BD, E, I, A>
{
    public static int[][] /*SSZUKO_*/FRAME_INT_2D_ARRAY = new int[][]
    {
        { 0, 222 },
        { 0, 222 },
        { 381, 481 },
        { 482, 532 },
        { 223, 380 },
        { 0, 222 },
        { 533, 610 },//spawn
        { 611, 704 },//idle
        { 705, 725 },//act
        { 726, 750 },//end
//    };
//    public static int[][] SEAHOUSE_FRAME_INT_2D_ARRAY = new int[][]
//    {
        { 0, 50 },
        { 0, 0 },
        { 51, 128 },//spawn
        { 129, 222 },//idle
        { 223, 243 },//act
        { 244, 269 }//end
    };
    public static byte[] FRAME_BYTE_ARRAY = new byte[]
    {
    };
    public FrameS[][] frames_2d_array;

    public ServerSSZuko(I i, Inventory inventory)
    {
        super(i, inventory);
    }

    @Override
    public void initFrame()
    {
        {
            () -> this.isZeroMove() && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(0),
            () -> serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setProtect(6, 7, 8, 9, serverentitiesmemory.entitiesaimemory.skinningentitiesprotect),
            () -> (serverentitiesmemory.current_work_byte_array[workbytes.SIT() / 8] >> workbytes.SIT() % 8 & 1) == 1 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(1),
            () -> this.moveForward != 0 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(2),
            () -> (serverentitiesmemory.statentitiesmemory.stat & 4) == 4 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopFree(3, (byte)4),
            () -> ((serverentitiesmemory.statentitiesmemory.stat & 1) == 1 || (serverentitiesmemory.statentitiesmemory.stat & 2) == 2 || (serverentitiesmemory.statentitiesmemory.stat & 8) == 8) && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopFree(4, (byte)(1 + 2 + 8)),
            () -> serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(5)
        };
        {
            () -> serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[1].setProtect(2, 3, 4, 5, serverentitiesmemory.entitiesaimemory.skinningentitiesprotect),
            () -> (serverentitiesmemory.statentitiesmemory.stat & 4) == 4 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[1].setFLoopFree(0, (byte)4),
            () -> serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[1].setTLoop(1)
        };
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

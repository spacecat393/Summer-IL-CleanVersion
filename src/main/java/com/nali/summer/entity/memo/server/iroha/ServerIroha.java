package com.nali.summer.entity.memo.server.iroha;

import com.nali.data.IBothDaNe;
import com.nali.data.IBothDaSn;
import com.nali.small.entity.EntityLeInv;
import com.nali.small.entity.IMixLe;
import com.nali.small.entity.memo.server.ServerSleInv;
import com.nali.small.entity.memo.server.ai.MixAIE;
import com.nali.small.entity.memo.server.ai.frame.FrameS;
import com.nali.sound.ISoundLe;

public class ServerIroha<SD extends ISoundLe, BD extends IBothDaNe & IBothDaSn, E extends EntityLeInv, I extends IMixLe<SD, BD, E>, A extends MixAIE<SD, BD, E, I, ?>> extends ServerSleInv<SD, BD, E, I, A>
{
    public static int[][] FRAME_INT_2D_ARRAY = new int[][]
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
    };

    @Override
    public void initFrame()
    {

    }

    @Override
    public FrameS[] getFrameSArray()
    {
        return ;
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
}

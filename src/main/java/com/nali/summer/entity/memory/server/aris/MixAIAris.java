package com.nali.summer.entity.memory.server.aris;

import com.nali.data.IBothDaNe;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.memo.server.ServerE;
import com.nali.small.entity.memo.server.ai.MixAIEInv;
import net.minecraft.entity.Entity;

public class MixAIAris<SD, BD extends IBothDaNe, E extends Entity, I extends IMixE<SD, BD, E>, S extends ServerE<SD, BD, E, I, ?>> extends MixAIEInv<SD, BD, E, I, S>
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

    public MixAIAris(S s)
    {
        super(s);
    }

    @Override
    public void init()
    {

    }

    @Override
    public int[][] getFrame2DIntArray()
    {
        return FRAME_INT_2D_ARRAY;
    }
}

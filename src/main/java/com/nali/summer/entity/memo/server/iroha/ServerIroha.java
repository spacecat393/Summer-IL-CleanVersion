package com.nali.summer.entity.memo.server.iroha;

import com.nali.da.IBothDaNe;
import com.nali.da.IBothDaSn;
import com.nali.small.entity.EntityLeInv;
import com.nali.small.entity.IMixLe;
import com.nali.small.entity.Inventory;
import com.nali.small.entity.memo.server.ServerSleInv;
import com.nali.small.entity.memo.server.ai.MixAIE;
import com.nali.small.entity.memo.server.ai.frame.FrameS;
import com.nali.small.entity.memo.server.ai.frame.floop.FrameSleFLoopDie;
import com.nali.sound.ISoundDaLe;
import net.minecraft.world.WorldServer;

import java.util.function.Supplier;

public class ServerIroha<SD extends ISoundDaLe, BD extends IBothDaNe & IBothDaSn, E extends EntityLeInv, I extends IMixLe<SD, BD, E>, A extends MixAIE<SD, BD, E, I, ?>> extends ServerSleInv<SD, BD, E, I, A>
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
    public static byte[] FRAME_BYTE_ARRAY = new byte[]
    {
//        0, 14
    };
    public FrameS[][] frames_2d_array;

    public ServerIroha(I i, Inventory inventory)
    {
        super(i, inventory);
    }

    @Override
    public void initFrame()
    {
        this.frames_2d_array = new FrameS[][]
        {
            {
//                new FrameSleFLoopDie(this, 0)
            }
        };
        () ->
        {
            int id = 14;
            boolean result = serverentitiesmemory.skinningentities != null && ((ServerEntitiesMemory)serverentitiesmemory.skinningentities.bothentitiesmemory).entitiesaimemory.skinningentitiesplaywith.first_playwith;
            if (result)
            {
                ((ServerEntitiesMemory)serverentitiesmemory.skinningentities.bothentitiesmemory).entitiesaimemory.skinningentitiesliveframe_array[0].setFLoop(id - 1);
                ((ServerEntitiesMemory)serverentitiesmemory.skinningentities.bothentitiesmemory).entitiesaimemory.skinningentitiesliveframe_array[0].stepFrame();
                if (serverentitiesmemory.frame_int_array[serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].integer_index] == serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].int_2d_array[id][1])
                {
                    ((ServerEntitiesMemory)serverentitiesmemory.skinningentities.bothentitiesmemory).entitiesaimemory.skinningentitiesplaywith.first_playwith = false;
                }
            }

            return result && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoop(id);
        },
        () ->
        {
            int id = 19;
            boolean result = serverentitiesmemory.skinningentities != null && this.isZeroMove() && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoop(id);
            if (result)
            {
                ((ServerEntitiesMemory)serverentitiesmemory.skinningentities.bothentitiesmemory).entitiesaimemory.skinningentitiesliveframe_array[0].setFLoop(id - 1);
                ((ServerEntitiesMemory)serverentitiesmemory.skinningentities.bothentitiesmemory).entitiesaimemory.skinningentitiesliveframe_array[0].stepFrame();
            }

            return result;
        },
        () ->
        {
            int id = 18;
            boolean result = serverentitiesmemory.skinningentities != null && (serverentitiesmemory.current_work_byte_array[workbytes.SIT() / 8] >> workbytes.SIT() % 8 & 1) == 1 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoopFB(id);
            if (result)
            {
                ((ServerEntitiesMemory)serverentitiesmemory.skinningentities.bothentitiesmemory).entitiesaimemory.skinningentitiesliveframe_array[0].setTLoopFB(id - 1);
                ((ServerEntitiesMemory)serverentitiesmemory.skinningentities.bothentitiesmemory).entitiesaimemory.skinningentitiesliveframe_array[0].stepFrame();
            }

            return result;
        },
        () ->
        {
            int id0 = 16;
            int id1 = 17;
            boolean result = serverentitiesmemory.skinningentities != null && this.moveForward == 0 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopOffSet(id0, id1);
            if (result)
            {
                ((ServerEntitiesMemory)serverentitiesmemory.skinningentities.bothentitiesmemory).entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopOffSet(id0 - 1, id1 - 1);
                ((ServerEntitiesMemory)serverentitiesmemory.skinningentities.bothentitiesmemory).entitiesaimemory.skinningentitiesliveframe_array[0].stepFrame();
            }

            return result;
        },
        () ->
        {
            int id0 = 20, id1 = 21, id2 = 22, id3 = 23;
            boolean result = serverentitiesmemory.skinningentities != null && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setShoot(id0, id1, id2, id3, false, serverentitiesmemory.entitiesaimemory.skinningentitiesattack);
            if (result)
            {
                int id;
                int frame = serverentitiesmemory.frame_int_array[0];
                if (frame >= serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].int_2d_array[id0][0] && frame <= serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].int_2d_array[id0][1])
                {
                    id = id0 - 1;
                }
                else if (frame >= serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].int_2d_array[id1][0] && frame <= serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].int_2d_array[id1][1])
                {
                    id = id1 - 1;
                }
                else if (frame >= serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].int_2d_array[id2][0] && frame <= serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].int_2d_array[id2][1])
                {
                    id = id1 - 1;
                }
                else
                {
                    id = id3 - 1;
                }

                ((ServerEntitiesMemory)serverentitiesmemory.skinningentities.bothentitiesmemory).entitiesaimemory.skinningentitiesliveframe_array[0].setFLoop(id);
                ((ServerEntitiesMemory)serverentitiesmemory.skinningentities.bothentitiesmemory).entitiesaimemory.skinningentitiesliveframe_array[0].step = serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].step;
                ((ServerEntitiesMemory)serverentitiesmemory.skinningentities.bothentitiesmemory).entitiesaimemory.skinningentitiesliveframe_array[0].stepFrame();
            }

            return result;
        },
        () ->
        {
            int id = 15;
            boolean result = serverentitiesmemory.skinningentities != null && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(id);
            if (result)
            {
                ((ServerEntitiesMemory)serverentitiesmemory.skinningentities.bothentitiesmemory).entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(id - 1);
                ((ServerEntitiesMemory)serverentitiesmemory.skinningentities.bothentitiesmemory).entitiesaimemory.skinningentitiesliveframe_array[0].stepFrame();
            }

            return result;
        },

        () -> this.isZeroMove() && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoop(0),
        () -> (serverentitiesmemory.current_work_byte_array[workbytes.SIT() / 8] >> workbytes.SIT() % 8 & 1) == 1 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoopFB(1),
        () -> (serverentitiesmemory.main_work_byte_array[workbytes.ATTACK() / 8] >> workbytes.ATTACK() % 8 & 1) == 1 && this.moveForward == 0 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopOffSet(3, 4),
        () -> serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setShoot(2, 11, 12, 13, false, serverentitiesmemory.entitiesaimemory.skinningentitiesattack),
        () -> (serverentitiesmemory.main_work_byte_array[workbytes.ATTACK() / 8] >> workbytes.ATTACK() % 8 & 1) == 1 && this.moveForward != 0 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(3),
        () -> this.moveForward != 0 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(5),
        () -> ((serverentitiesmemory.statentitiesmemory.stat & 1) == 1 || (serverentitiesmemory.statentitiesmemory.stat & 8) == 8) && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopFree(6, (byte)(1 + 8)),
        () -> (serverentitiesmemory.statentitiesmemory.stat & 4) == 4 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopFree(7, (byte)4),
        () -> (serverentitiesmemory.statentitiesmemory.stat & 2) == 2 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopFree(8, (byte)2),
        () -> (serverentitiesmemory.main_work_byte_array[workbytes.ATTACK() / 8] >> workbytes.ATTACK() % 8 & 1) == 1 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoop(9),
        () -> serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(10)
    }

    @Override
    public void updateServer()
    {
//        if (serverentitiesmemory.skinningentities != null && ((WorldServer)this.world).getEntityFromUuid(serverentitiesmemory.skinningentities.getUniqueID()) == null)
//        {
//            serverentitiesmemory.skinningentities = null;
//        }
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

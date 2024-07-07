package com.nali.summer.entity.memo.server.e22locker;

import com.nali.da.IBothDaNe;
import com.nali.da.IBothDaSn;
import com.nali.small.entity.EntityEInv;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.Inventory;
import com.nali.small.entity.memo.server.ServerSeInv;
import com.nali.small.entity.memo.server.ai.MixAIE;
import com.nali.small.entity.memo.server.ai.frame.FrameS;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.world.WorldServer;

import java.util.function.Supplier;

public class ServerE22Locker<SD, BD extends IBothDaNe & IBothDaSn, E extends EntityEInv, I extends IMixE<SD, BD, E>, A extends MixAIE<SD, BD, E, I, ?>> extends ServerSeInv<SD, BD, E, I, A>
{
    public static int[][] FRAME_INT_2D_ARRAY = new int[][]
    {
        { 0, 297 },//react
        { 298, 302 },//noact
        { 303, 386 }//idle
    };
    public static byte[] FRAME_BYTE_ARRAY = new byte[]
    {
    };
    public FrameS[][] frames_2d_array;

    public ServerE22Locker(I i, Inventory inventory)
    {
        super(i, inventory);
    }

    @Override
    public void initFrame()
    {
        serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0] = new SkinningEntitiesLiveFrame(this, 0, FRAME_INT_2D_ARRAY);
        serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].condition_boolean_supplier_array = new Supplier[]
                {
                        () -> serverentitiesmemory.skinningentities != null && (serverentitiesmemory.statentitiesmemory.stat & 16) == 16 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopFree(0, (byte)16),
                        () -> serverentitiesmemory.skinningentities != null && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoop(2),
                        () -> serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(1)
                };
    }

    @Override
    public void updateServer()
    {
        if (serverentitiesmemory.skinningentities != null && ((WorldServer)this.world).getEntityFromUuid(serverentitiesmemory.skinningentities.getUniqueID()) == null)
        {
            serverentitiesmemory.skinningentities = null;
        }

        this.renderYawOffset = this.rotationYaw;
    }

    @Override
    public boolean processInitialInteract(EntityPlayer entityplayer, EnumHand enumhand)
    {
        if (!this.world.isRemote)
        {
            ServerEntitiesMemory serverentitiesmemory = (ServerEntitiesMemory)this.bothentitiesmemory;
            serverentitiesmemory.statentitiesmemory.stat ^= 16;
        }
        return super.processInitialInteract(entityplayer, enumhand);
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

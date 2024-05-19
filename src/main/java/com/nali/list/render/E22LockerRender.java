package com.nali.list.render;

import com.nali.data.client.ClientData;
import com.nali.list.entities.SummerE22Locker;
import com.nali.render.EntitiesRenderMemory;
import com.nali.summer.data.client.E22LockerClientData;
import com.nali.summer.render.skinning.SummerSkinningEntitiesRender;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class E22LockerRender extends SummerSkinningEntitiesRender
{
//    public static int ID;
//    public static DataLoader DATALOADER = RenderHelper.DATALOADER;
//    public static BothData BOTHDATA = SummerE22Locker.BOTHDATA;
    public static ClientData CLIENTDATA = new E22LockerClientData();

    public E22LockerRender(EntitiesRenderMemory entitiesrendermemory, Entity entity)
    {
        super(entitiesrendermemory, SummerE22Locker.BOTHDATA, CLIENTDATA/*, RenderHelper.DATALOADER*/, entity);
//        Arrays.fill(this.texture_index_int_array, 61);
    }

//    @Override
//    public void setGlow()
//    {
//        this.glow_byte_array[6 / 8] ^= 64;//Math.pow(2, 6 % 8)
//        super.setGlow();
//    }
}

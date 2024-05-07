package com.nali.summer.render.skinning;

import com.nali.data.client.ClientData;
import com.nali.list.entities.SummerYuzu;
import com.nali.render.EntitiesRenderMemory;
import com.nali.small.render.SkinningEntitiesRender;
import com.nali.summer.data.client.YuzuClientData;
import com.nali.summer.render.RenderHelper;
import com.nali.system.opengl.memory.OpenGLObjectMemory;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.HashMap;
import java.util.Map;

@SideOnly(Side.CLIENT)
public class YuzuRender extends SkinningEntitiesRender
{
//    public static int ID;
//    public static DataLoader DATALOADER = RenderHelper.DATALOADER;
//    public static BothData BOTHDATA = SummerYuzu.BOTHDATA;
    public static ClientData CLIENTDATA = new YuzuClientData();
    public Map<Integer, Integer> texture_map = new HashMap();//element_array_buffer texture_id

    public YuzuRender(EntitiesRenderMemory entitiesrendermemory, Entity entity)
    {
        super(entitiesrendermemory, SummerYuzu.BOTHDATA, CLIENTDATA, RenderHelper.DATALOADER, entity);
//        this.texture_index_int_array[0] = 62;
//        this.texture_index_int_array[1] = 54;
//        this.texture_index_int_array[2] = 63;
//        this.texture_index_int_array[3] = 63;
//        this.texture_index_int_array[4] = 64;
//        this.texture_index_int_array[5] = 65;
//        this.texture_index_int_array[6] = 64;
//        this.texture_index_int_array[7] = 60;
//        this.texture_index_int_array[8] = 9;
//        this.texture_map.put(this.dataloader.openglobjectmemory_array[CLIENTDATA.StartPart() + 8].element_array_buffer, 9);
        this.texture_map.put(((OpenGLObjectMemory)this.dataloader.object_array[CLIENTDATA.StartPart() + 8]).element_array_buffer, 9);
    }

    @Override
    public int getTextureBuffer(OpenGLObjectMemory openglobjectmemory)
    {
        Integer integer = this.texture_map.get(openglobjectmemory.element_array_buffer);
        if (integer == null)
        {
            return super.getTextureBuffer(openglobjectmemory);
        }
        else
        {
            return (int)this.dataloader.opengltexturememory.texture_array[integer];
        }
    }

    //    @Override
//    public void setGlow()
//    {
//        this.glow_byte_array[7 / 8] ^= 128;//Math.pow(2, 7 % 8)
//        super.setGlow();
//    }
}

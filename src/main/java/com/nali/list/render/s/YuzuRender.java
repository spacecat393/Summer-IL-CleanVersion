package com.nali.list.render.s;

import com.nali.data.IBothDaNe;
import com.nali.data.IBothDaSn;
import com.nali.data.client.ClientData;
import com.nali.data.client.IClientDaS;
import com.nali.list.entity.SummerYuzu;
import com.nali.render.EntitiesRenderMemory;
import com.nali.small.entity.IMixLe;
import com.nali.small.entity.memo.client.ClientSle;
import com.nali.small.entity.memo.client.box.mix.MixBoxSle;
import com.nali.small.entity.memo.client.render.mix.MixRenderE;
import com.nali.sound.ISoundLe;
import com.nali.summer.data.client.YuzuClientDa;
import com.nali.summer.render.skinning.SummerRenderSle;
import com.nali.system.opengl.memo.client.MemoGs;
import com.nali.system.opengl.memo.client.MemoSs;
import com.nali.system.opengl.memo.client.store.StoreS;
import com.nali.system.opengl.memory.OpenGLObjectMemory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.HashMap;
import java.util.Map;

import static com.nali.list.data.SummerData.TEXTURE_STEP;
import static com.nali.system.ClientLoader.OBJECT_LIST;

@SideOnly(Side.CLIENT)
public class YuzuRender<E extends EntityLivingBase, I extends IMixLe<SD, BD, E>, MB extends MixBoxSle<RG, RS, RC, RST, ?, SD, BD, E, I, MR, C>, MR extends MixRenderE<RG, RS, RC, RST, ?, SD, BD, E, I, MB, C>, C extends ClientSle<RG, RS, RC, RST, ?, SD, BD, E, I, MB, MR>, SD extends ISoundLe, BD extends IBothDaNe & IBothDaSn, RG extends MemoGs, RS extends MemoSs, RST extends StoreS<RG, RS>, RC extends IClientDaS> extends SummerRenderSle<E, I, MB, MR, C, SD, BD, RG, RS, RST, RC>
{
//    public static int ID;
//    public static DataLoader DATALOADER = RenderHelper.DATALOADER;
//    public static BothData BOTHDATA = SummerYuzu.BOTHDATA;
    public static ClientData CLIENTDATA = new YuzuClientDa();
    public Map<Integer, Integer> texture_map = new HashMap();//element_array_buffer texture_id

    public YuzuRender(EntitiesRenderMemory entitiesrendermemory, Entity entity)
    {
        super(entitiesrendermemory, SummerYuzu.BOTHDATA, CLIENTDATA/*, RenderHelper.DATALOADER*/, entity);
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
//        this.texture_map.put(((OpenGLObjectMemory)this.dataloader.object_array[CLIENTDATA.StartPart() + 8]).element_array_buffer, 9);
        this.texture_map.put(((OpenGLObjectMemory)OBJECT_LIST.get(CLIENTDATA.StartPart() + 8)).element_array_buffer, 9 + TEXTURE_STEP);
    }

    @Override
    public int getTextureID(OpenGLObjectMemory openglobjectmemory)
    {
        Integer integer = this.texture_map.get(openglobjectmemory.element_array_buffer);
        if (integer == null)
        {
            return super.getTextureID(openglobjectmemory);
        }
        else
        {
//            return (int)this.dataloader.opengltexturememory.texture_array[integer];
            return integer;
        }
    }

    //    @Override
//    public void setGlow()
//    {
//        this.glow_byte_array[7 / 8] ^= 128;//Math.pow(2, 7 % 8)
//        super.setGlow();
//    }
}

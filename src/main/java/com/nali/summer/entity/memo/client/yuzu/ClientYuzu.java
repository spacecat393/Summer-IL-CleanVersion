package com.nali.summer.entity.memo.client.yuzu;

import com.nali.da.IBothDaNe;
import com.nali.da.IBothDaSn;
import com.nali.da.client.IClientDaS;
import com.nali.list.render.s.RenderYuzu;
import com.nali.small.entity.IMixLe;
import com.nali.small.entity.Inventory;
import com.nali.small.entity.memo.client.ClientSleInv;
import com.nali.small.entity.memo.client.box.mix.MixBoxSle;
import com.nali.small.entity.memo.client.render.mix.MixRenderSleInv;
import com.nali.sound.ISoundDaLe;
import com.nali.sound.Sound;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.nali.list.data.SummerData.MODEL_STEP;
import static com.nali.list.data.SummerData.TEXTURE_STEP;
import static com.nali.system.ClientLoader.G_LIST;

@SideOnly(Side.CLIENT)
public class ClientYuzu<RC extends IClientDaS, R extends RenderYuzu<E, I, MB, MR, ?, SD, BD, RC>, SD extends ISoundDaLe, BD extends IBothDaNe & IBothDaSn, E extends EntityLivingBase, I extends IMixLe<SD, BD, E>, MB extends MixBoxSle<RC, R, SD, BD, E, I, MR, ?>, MR extends MixRenderSleInv<RC, R, SD, BD, E, I, MB, ?>> extends ClientSleInv<RC, R, SD, BD, E, I, MB, MR>
{
    public static int[] IV_INT_ARRAY = new int[]
    {
        5+97 + MODEL_STEP, 7105,
        5+97 + MODEL_STEP, 7881,
        /*0+*/97 + MODEL_STEP, 2337,
        5+97 + MODEL_STEP, 689,
        5+97 + MODEL_STEP, 2661,
        8+97 + MODEL_STEP, 69
    };
    public static float[] ROTATION_FLOAT_ARRAY = new float[]
    {
        0.0F, 0.0F,
        0.0F, 0.0F
    };
    public static float[] TRANSFORM_FLOAT_ARRAY = new float[]
    {
        0.0F, -0.55F * 0.5F, 0.0F,
        0.0F, -1.0F * 0.5F, 0.1F * 0.5F,
        0.0F, -1.2F * 0.5F, 0.14F * 0.5F,
        0.0F, -1.15F * 0.5F, 0.14F * 0.5F
    };

    public ClientYuzu(I i, R r, Inventory inventory)
    {
        super(i, r, inventory);
    }

    @Override
    public void updateClient()
    {
        int frame = this.r.frame_int_array[0];

        float scale = this.r.scale;
        RC rc = this.r.rc;
//        RST rst = this.r.rst;
        if (frame > 195 && frame < 222)
        {
//            skinningrender.texture_index_int_array[8] = 66;
//            skinningrender.texture_map.put(skinningrender.dataloader.openglobjectmemory_array[rc.StartPart() + 8].ebo, 66);
//            skinningrender.texture_map.put(((OpenGLObjectMemory)skinningrender.dataloader.object_array[rc.StartPart() + 8]).ebo, 66);
            this.r.texture_map.put(G_LIST.get(rc.StartPart() + 8).ebo, 66 + TEXTURE_STEP);
        }
        else if ((frame > 221 && frame < 250) || (frame > 354 && frame < 429))
        {
//            skinningrender.texture_index_int_array[8] = 67;
//            skinningrender.texture_map.put(skinningrender.dataloader.openglobjectmemory_array[rc.StartPart() + 8].ebo, 67);
            this.r.texture_map.put(G_LIST.get(rc.StartPart() + 8).ebo, 67 + TEXTURE_STEP);
        }
        else if (frame > 249 && frame < 266)
        {
//            skinningrender.texture_index_int_array[8] = 68;
//            skinningrender.texture_map.put(skinningrender.dataloader.openglobjectmemory_array[rc.StartPart() + 8].ebo, 68);
            this.r.texture_map.put(G_LIST.get(rc.StartPart() + 8).ebo, 68 + TEXTURE_STEP);
        }
        else if (frame > 301 && frame < 355)
        {
//            skinningrender.texture_index_int_array[8] = 69;
//            skinningrender.texture_map.put(skinningrender.dataloader.openglobjectmemory_array[rc.StartPart() + 8].ebo, 69);
            this.r.texture_map.put(G_LIST.get(rc.StartPart() + 8).ebo, 69 + TEXTURE_STEP);
        }
        else
        {
//            skinningrender.texture_index_int_array[8] = 9;
//            skinningrender.texture_map.put(skinningrender.dataloader.openglobjectmemory_array[rc.StartPart() + 8].ebo, 9);
            this.r.texture_map.put(G_LIST.get(rc.StartPart() + 8).ebo, 9 + TEXTURE_STEP);
        }

        E e = this.i.getE();
        if (frame > 716 && frame < 768)
        {
            e.width = 1.5F * scale;
            e.height = 0.2F * scale;
        }
        else
        {
            BD bd = this.i.getBD();
            e.width = bd.Width() * scale;
            e.height = bd.Height() * scale;
        }
    }

//    @Override
//    public void initFakeFrame()
//    {
//
//    }

    @Override
    public Sound createSound()
    {
        return new Sound();
    }

    @Override
    public int[] getIVIntArray()
    {
        return IV_INT_ARRAY;
    }

    @Override
    public float[] getRotationFloatArray()
    {
        return ROTATION_FLOAT_ARRAY;
    }

    @Override
    public float[] getTransformFloatArray()
    {
        return TRANSFORM_FLOAT_ARRAY;
    }
}

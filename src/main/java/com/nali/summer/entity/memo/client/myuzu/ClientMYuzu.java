package com.nali.summer.entity.memo.client.myuzu;

import com.nali.data.BothData;
import com.nali.data.IBothDaNe;
import com.nali.data.IBothDaSn;
import com.nali.data.client.IClientDaS;
import com.nali.list.render.s.RenderMYuzu;
import com.nali.small.entities.bytes.WorkBytes;
import com.nali.small.entities.memory.client.ClientEntitiesMemory;
import com.nali.small.entities.skinning.SkinningEntities;
import com.nali.small.entity.IMixLe;
import com.nali.small.entity.memo.client.ClientSleInv;
import com.nali.small.entity.memo.client.box.mix.MixBoxSle;
import com.nali.small.entity.memo.client.render.mix.MixRenderSleInv;
import com.nali.sound.ISoundLe;
import com.nali.system.opengl.memo.client.MemoGs;
import com.nali.system.opengl.memo.client.MemoSs;
import com.nali.system.opengl.memo.client.store.StoreS;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.nali.list.data.SummerData.MODEL_STEP;
import static com.nali.list.data.SummerData.MODEL_S_STEP;

@SideOnly(Side.CLIENT)
public class ClientMYuzu<RG extends MemoGs, RS extends MemoSs, RC extends IClientDaS, RST extends StoreS<RG, RS>, R extends RenderMYuzu<E, I, MB, MR, ?, SD, BD, RG, RS, RST, RC>, SD extends ISoundLe, BD extends IBothDaNe & IBothDaSn, E extends EntityLivingBase, I extends IMixLe<SD, BD, E>, MB extends MixBoxSle<RG, RS, RC, RST, R, SD, BD, E, I, MR, ?>, MR extends MixRenderSleInv<RG, RS, RC, RST, R, SD, BD, E, I, MB, ?>> extends ClientSleInv<RG, RS, RC, RST, R, SD, BD, E, I, MB, MR>
{
    public static int[] IV_INT_ARRAY = new int[]
    {
        5+81 + MODEL_S_STEP, 11946,
        5+81 + MODEL_S_STEP, 10846,
        1+81 + MODEL_S_STEP, 557,
        5+81 + MODEL_S_STEP, 13404,
        5+81 + MODEL_S_STEP, 9960,
        8+81 + MODEL_S_STEP, 69
    };
    public static float[] ROTATION_FLOAT_ARRAY = new float[]
    {
        0.0F, 0.0F,
        0.0F, 0.0F
    };
    public static float[] TRANSFORM_FLOAT_ARRAY = new float[]
    {
        0.0F, -0.55F * 0.5F, 0.0F,
        0.0F, -1.0F * 0.5F, 0.09F * 0.5F,
        0.0F, -1.1F * 0.5F, 0.11F * 0.5F,
        0.0F, -1.05F * 0.5F, 0.11F * 0.5F
    };

    @Override
    public void initFakeFrame()
    {
        ((SkinningRender)this.objectrender).frame_int_array[0] = 110;
    }

    @Override
    public ObjectRender createObjectRender()
    {
        return new RenderMYuzu(new EntitiesRenderMemory(), this.main_skinningentities);
    }

    @Override
    public SoundRender createSoundRender()
    {
        return new NoSoundRender();
    }

    @Override
    public int[] getIVIntArray()
    {
        return IV_INT_ARRAY;
    }
}

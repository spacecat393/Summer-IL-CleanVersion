package com.nali.summer.entity.memo.client.iroha;

import com.nali.data.IBothDaNe;
import com.nali.data.IBothDaSn;
import com.nali.data.client.IClientDaS;
import com.nali.list.render.s.RenderIroha;
import com.nali.small.entity.IMixLe;
import com.nali.small.entity.Inventory;
import com.nali.small.entity.memo.client.ClientSleInv;
import com.nali.small.entity.memo.client.box.mix.MixBoxSle;
import com.nali.small.entity.memo.client.render.mix.MixRenderSleInv;
import com.nali.sound.ISoundLe;
import com.nali.sound.NoSound;
import com.nali.sound.Sound;
import com.nali.system.opengl.memo.client.MemoGs;
import com.nali.system.opengl.memo.client.MemoSs;
import com.nali.system.opengl.memo.client.store.StoreS;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.nali.list.data.SummerData.MODEL_S_STEP;

@SideOnly(Side.CLIENT)
public class ClientIroha<RG extends MemoGs, RS extends MemoSs, RC extends IClientDaS, RST extends StoreS<RG, RS>, R extends RenderIroha<E, I, MB, MR, ?, SD, BD, RG, RS, RST, RC>, SD extends ISoundLe, BD extends IBothDaNe & IBothDaSn, E extends EntityLivingBase, I extends IMixLe<SD, BD, E>, MB extends MixBoxSle<RG, RS, RC, RST, R, SD, BD, E, I, MR, ?>, MR extends MixRenderSleInv<RG, RS, RC, RST, R, SD, BD, E, I, MB, ?>> extends ClientSleInv<RG, RS, RC, RST, R, SD, BD, E, I, MB, MR>
{
    public static int[] IV_INT_ARRAY = new int[]
    {
        8+130 + MODEL_S_STEP, 837,
        8+130 + MODEL_S_STEP, 2145,
        8+130 + MODEL_S_STEP, 10171,
        8+130 + MODEL_S_STEP, 6617,
        8+130 + MODEL_S_STEP, 5653,
        10+130 + MODEL_S_STEP, 39,
        5+130 + MODEL_S_STEP, 26084
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
        0.0F, -1.2F * 0.5F, 0.11F * 0.5F,
        0.0F, -1.15F * 0.5F, 0.11F * 0.5F
    };

    public ClientIroha(I i, R r, Inventory inventory)
    {
        super(i, r, inventory);
    }

    @Override
    public void initFakeFrame()
    {

    }

    @Override
    public Sound createSound()
    {
        return new NoSound();
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

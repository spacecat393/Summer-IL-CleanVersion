package com.nali.summer.entity.memo.client.sshimi;

import com.nali.data.BothData;
import com.nali.data.IBothDaNe;
import com.nali.data.IBothDaSn;
import com.nali.data.client.IClientDaS;
import com.nali.list.render.s.RenderSSHimi;
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
public class ClientSSHimi<RG extends MemoGs, RS extends MemoSs, RC extends IClientDaS, RST extends StoreS<RG, RS>, R extends RenderSSHimi<E, I, MB, MR, ?, SD, BD, RG, RS, RST, RC>, SD extends ISoundLe, BD extends IBothDaNe & IBothDaSn, E extends EntityLivingBase, I extends IMixLe<SD, BD, E>, MB extends MixBoxSle<RG, RS, RC, RST, R, SD, BD, E, I, MR, ?>, MR extends MixRenderSleInv<RG, RS, RC, RST, R, SD, BD, E, I, MB, ?>> extends ClientSleInv<RG, RS, RC, RST, R, SD, BD, E, I, MB, MR>
{
    public static int[] IV_INT_ARRAY = new int[]
    {
        /*0+0 + */MODEL_S_STEP, 9046,
        /*0+0 + */MODEL_S_STEP, 2581,
        4/*+0*/ + MODEL_S_STEP, 1275,
        /*0+0 + */MODEL_S_STEP, 9224,
        /*0+0 + */MODEL_S_STEP, 7860,
        12/*+0*/ + MODEL_S_STEP, 69
    };
    public static float[] ROTATION_FLOAT_ARRAY = new float[]
    {
        0.0F, 0.0F,
        0.0F, 0.0F
    };
    public static float[] TRANSFORM_FLOAT_ARRAY = new float[]
    {
        0.0F, -0.55F * 0.5F, 0.0F,
        0.0F, -1.0F * 0.5F, 0.01F * 0.5F,
        0.0F, -1.2F * 0.5F, 0.14F * 0.5F,
        0.0F, -1.15F * 0.5F, 0.14F * 0.5F
    };

    public ClientSSHimi(SkinningEntities skinningentities, BothData bothdata, WorkBytes workbytes)
    {
        super(skinningentities, bothdata, workbytes);
        this.itemlayerrender.iv_int_array = IV_INT_ARRAY;
        this.itemlayerrender.rotation_float_array = ROTATION_FLOAT_ARRAY;
        this.itemlayerrender.transform_float_array = TRANSFORM_FLOAT_ARRAY;
    }

    @Override
    public void initFakeFrame()
    {
        ((SkinningRender)this.objectrender).frame_int_array[0] = 379;
    }

    @Override
    public ObjectRender createObjectRender()
    {
        return new RenderSSHimi(new EntitiesRenderMemory(), this.main_skinningentities);
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

package com.nali.list.render;

import com.nali.da.IBothDaE;
import com.nali.da.IBothDaO;
import com.nali.da.IBothDaS;
import com.nali.small.entity.EntityLe;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.IMixES;
import com.nali.small.entity.IMixESInv;
import com.nali.small.entity.inv.InvLe;
import com.nali.small.entity.memo.client.ClientLeInv;
import com.nali.small.entity.memo.client.box.mix.MixBoxSleInv;
import com.nali.small.entity.memo.client.ci.MixCIE;
import com.nali.small.entity.memo.client.render.mix.MixRenderSe;
import com.nali.list.da.BothDaYuzu;
import com.nali.summer.render.SummerRenderSe;
import com.nali.system.opengl.memo.client.MemoG;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.HashMap;
import java.util.Map;

import static com.nali.list.data.SummerData.TEXTURE_STEP;
import static com.nali.system.ClientLoader.G_LIST;

@SideOnly(Side.CLIENT)
public class RenderYuzu
<
	IE extends InvLe,
	E extends EntityLe,
	I extends IMixE<BothDaYuzu, E> & IMixES & IMixESInv,
	MC extends MixCIE<BothDaYuzu, ?, E, I, MB, MR, C>,
	MB extends MixBoxSleInv<BothDaYuzu, ?, E, I, MC, MR, C>,
	MR extends MixRenderSe<BothDaYuzu, ?, E, I, MC, MB, C>,
	C extends ClientLeInv<IE, BothDaYuzu, ?, E, I, MC, MB, MR>
> extends SummerRenderSe<E, I, MC, MB, MR, C, BothDaYuzu>
{
	public Map<Integer, Integer> texture_map = new HashMap();//ebo texture_id

	public RenderYuzu()
	{
		super(BothDaYuzu.IDA);
//		this.texture_index_int_array[0] = 62;
//		this.texture_index_int_array[1] = 54;
//		this.texture_index_int_array[2] = 63;
//		this.texture_index_int_array[3] = 63;
//		this.texture_index_int_array[4] = 64;
//		this.texture_index_int_array[5] = 65;
//		this.texture_index_int_array[6] = 64;
//		this.texture_index_int_array[7] = 60;
//		this.texture_index_int_array[8] = 9;
//		this.texture_map.put(this.dataloader.openglobjectmemory_array[CLIENTDATA.O_StartPart() + 8].ebo, 9);
//		this.texture_map.put(((OpenGLObjectMemory)this.dataloader.object_array[CLIENTDATA.O_StartPart() + 8]).ebo, 9);
		this.texture_map.put((G_LIST.get(BothDaYuzu.IDA.O_StartPart() + 8)).ebo, 9 + TEXTURE_STEP);
	}

	@Override
	public int getTextureID(MemoG rg)
	{
		Integer integer = this.texture_map.get(rg.ebo);
		if (integer == null)
		{
			return super.getTextureID(rg);
		}
		else
		{
//			return (int)this.dataloader.opengltexturememory.texture_array[integer];
			return integer;
		}
	}

	//	@Override
//	public void setGlow()
//	{
//		this.glow_byte_array[7 / 8] ^= 128;//Math.pow(2, 7 % 8)
//		super.setGlow();
//	}
}

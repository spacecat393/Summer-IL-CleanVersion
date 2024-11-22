package com.nali.list.render;

import com.nali.list.da.BothDaSaori;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.IMixES;
import com.nali.small.entity.IMixESInv;
import com.nali.small.entity.inv.InvLe;
import com.nali.small.entity.memo.client.ClientLeInv;
import com.nali.small.entity.memo.client.box.mix.MixBoxSleInv;
import com.nali.small.entity.memo.client.ci.MixCIE;
import com.nali.small.entity.memo.client.render.mix.MixRenderSe;
import com.nali.summer.render.SummerRenderSe;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSaori
<
	IE extends InvLe,
	E extends EntityLivingBase,
	I extends IMixE<BothDaSaori, E> & IMixES & IMixESInv,
	MC extends MixCIE<BothDaSaori, ?, E, I, MB, MR, C>,
	MB extends MixBoxSleInv<BothDaSaori, ?, E, I, MC, MR, C>,
	MR extends MixRenderSe<BothDaSaori, ?, E, I, MC, MB, C>,
	C extends ClientLeInv<IE, BothDaSaori, ?, E, I, MC, MB, MR>
> extends SummerRenderSe<E, I, MC, MB, MR, C, BothDaSaori>
{
	public RenderSaori()
	{
		super(BothDaSaori.IDA);
//		this.texture_index_int_array[0] = 70;
//		this.texture_index_int_array[1] = 71;
//		this.texture_index_int_array[2] = 71;
//		this.texture_index_int_array[3] = 72;
//		this.texture_index_int_array[4] = 73;
//		this.texture_index_int_array[5] = 74;
//		this.texture_index_int_array[6] = 74;
//		this.texture_index_int_array[7] = 75;
//		this.texture_index_int_array[8] = 66;
	}

//	@Override
//	public void setGlow()
//	{
//		this.glow_byte_array[7 / 8] ^= 128;//Math.pow(2, 7 % 8)
//		super.setGlow();
//	}
}

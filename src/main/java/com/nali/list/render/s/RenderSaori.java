package com.nali.list.render.s;

import com.nali.da.IBothDaNe;
import com.nali.da.IBothDaSn;
import com.nali.da.client.IClientDaS;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.IMixESoundDa;
import com.nali.small.entity.inv.InvLe;
import com.nali.small.entity.memo.client.ClientLeInv;
import com.nali.small.entity.memo.client.IClientERsInv;
import com.nali.small.entity.memo.client.box.mix.MixBoxSleInv;
import com.nali.small.entity.memo.client.ci.MixCIE;
import com.nali.small.entity.memo.client.render.mix.MixRenderSe;
import com.nali.sound.ISoundDaLe;
import com.nali.summer.da.both.BothDaSaori;
import com.nali.summer.da.client.ClientDaSaori;
import com.nali.summer.render.SummerRenderSe;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSaori
<
	IE extends InvLe,
	E extends EntityLivingBase,
	I extends IMixE<BD, E> & IMixESoundDa<SD>,
	MC extends MixCIE<RC, ?, BD, E, I, MB, MR, C>,
	MB extends MixBoxSleInv<RC, ?, SD, BD, E, I, MC, MR, C>,
	MR extends MixRenderSe<RC, ?, BD, E, I, MC, MB, C>,
	C extends ClientLeInv<IE, RC, ?, SD, BD, E, I, MC, MB, MR> & IClientERsInv,
	SD extends ISoundDaLe,
	BD extends IBothDaNe & IBothDaSn,
	RC extends IClientDaS
> extends SummerRenderSe<E, I, MC, MB, MR, C, BD, RC>
{
//	public static int ID;
//	public static DataLoader DATALOADER = RenderHelper.DATALOADER;
//	public static BothData BOTHDATA = SummerSaori.BOTHDATA;
	public static IClientDaS ICLIENTDAS = new ClientDaSaori();
	public static IBothDaSn IBOTHDASN = BothDaSaori.IBOTHDASN;

	public RenderSaori(RC rc, BD bd)
	{
		super(rc, bd);
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

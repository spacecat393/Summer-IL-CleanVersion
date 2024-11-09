package com.nali.list.render.s;

import com.nali.da.IBothDaNe;
import com.nali.da.IBothDaSn;
import com.nali.da.client.IClientDaS;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.inv.InvLe;
import com.nali.small.entity.memo.client.ClientLeInv;
import com.nali.small.entity.memo.client.IClientERsInv;
import com.nali.small.entity.memo.client.box.mix.MixBoxSleInv;
import com.nali.small.entity.memo.client.ci.MixCIE;
import com.nali.small.entity.memo.client.render.mix.MixRenderSe;
import com.nali.summer.da.both.BothDaMYuzu;
import com.nali.summer.da.client.ClientDaMYuzu;
import com.nali.summer.render.SummerRenderSe;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderMYuzu
<
	IE extends InvLe,
	E extends EntityLivingBase,
	I extends IMixE<BD, E>,
	MC extends MixCIE<RC, ?, BD, E, I, MB, MR, C>,
	MB extends MixBoxSleInv<RC, ?, BD, E, I, MC, MR, C>,
	MR extends MixRenderSe<RC, ?, BD, E, I, MC, MB, C>,
	C extends ClientLeInv<IE, RC, ?, BD, E, I, MC, MB, MR> & IClientERsInv,
	BD extends IBothDaNe & IBothDaSn,
	RC extends IClientDaS
> extends SummerRenderSe<E, I, MC, MB, MR, C, BD, RC>
{
//	public static int ID;
//	public static DataLoader DATALOADER = RenderHelper.DATALOADER;
//	public static BothData BOTHDATA = SummerMYuzu.BOTHDATA;
	public static IClientDaS ICLIENTDAS = new ClientDaMYuzu();
	public static IBothDaSn IBOTHDASN = BothDaMYuzu.IBOTHDASN;

	public RenderMYuzu(RC rc, BD bd)
	{
		super(rc, bd);
//		this.texture_index_int_array[0] = 54;
//		this.texture_index_int_array[1] = 55;
//		this.texture_index_int_array[2] = 56;
//		this.texture_index_int_array[3] = 56;
//		this.texture_index_int_array[4] = 57;
//		this.texture_index_int_array[5] = 58;
//		this.texture_index_int_array[6] = 59;
//		this.texture_index_int_array[7] = 60;
//		this.texture_index_int_array[8] = 9;
	}

//	@Override
//	public void setGlow()
//	{
//		this.glow_byte_array[7 / 8] ^= 128;//Math.pow(2, 7 % 8)
//		super.setGlow();
//	}
}

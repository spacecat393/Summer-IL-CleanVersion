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
import com.nali.summer.da.both.BothDaNatsu;
import com.nali.summer.da.client.ClientDaNatsu;
import com.nali.summer.render.SummerRenderSe;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Arrays;

@SideOnly(Side.CLIENT)
public class RenderNatsu
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
	public static IClientDaS ICLIENTDAS = new ClientDaNatsu();
	public static IBothDaSn IBOTHDASN = BothDaNatsu.IBOTHDASN;
	public byte[] model_byte_array;

	public RenderNatsu(RC rc, BD bd)
	{
		super(rc, bd);
		this.model_byte_array = new byte[(int)Math.ceil((rc.EndPart() - rc.StartPart()) / 8.0D)];
//		this.texture_index_int_array[0] = 10;
//		this.texture_index_int_array[1] = 11;
//		this.texture_index_int_array[2] = 12;
//		this.texture_index_int_array[3] = 12;
//		this.texture_index_int_array[4] = 13;
//		this.texture_index_int_array[5] = 14;
//		this.texture_index_int_array[6] = 18;
//		this.texture_index_int_array[7] = 16;
//		this.texture_index_int_array[8] = 11;
//		this.texture_index_int_array[9] = 17;
//		this.texture_index_int_array[10] = 15;
//		this.texture_index_int_array[11] = 9;
		Arrays.fill(this.model_byte_array, (byte)255);
	}

	@Override
	public void draw(int index)
	{
		int i = index - this.rc.StartPart();
		if ((this.model_byte_array[i / 8] >> i % 8 & 1) == 1)
		{
			super.draw(index);
		}
	}

	@Override
	public void drawLater(int index)
	{
		int i = index - this.rc.StartPart();
		if ((this.model_byte_array[i / 8] >> i % 8 & 1) == 1)
		{
			super.drawLater(index);
		}
	}

//	@Override
//	public void setGlow()
//	{
//		this.glow_byte_array[6 / 8] ^= 64;//Math.pow(2, 6 % 8)
//		super.setGlow();
//	}
}

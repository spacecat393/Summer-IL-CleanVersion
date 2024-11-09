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
import com.nali.summer.da.both.BothDaSSHoshino;
import com.nali.summer.da.client.ClientDaSSHoshino;
import com.nali.summer.render.SummerRenderSe;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Arrays;

@SideOnly(Side.CLIENT)
public class RenderSSHoshino
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
//	public static BothData BOTHDATA = SummerSSHino.BOTHDATA;
	public static IClientDaS ICLIENTDAS = new ClientDaSSHoshino();
	public static IBothDaSn IBOTHDASN = BothDaSSHoshino.IBOTHDASN;
	public byte[] model_byte_array;

	public RenderSSHoshino(RC rc, BD bd)
	{
		super(rc, bd);
		this.model_byte_array = new byte[(int)Math.ceil((rc.EndPart() - rc.StartPart()) / 8.0D)];
//		this.texture_index_int_array[0] = 47;
//		this.texture_index_int_array[1] = 48;
//		this.texture_index_int_array[2] = 49;
//		this.texture_index_int_array[3] = 47;
//		this.texture_index_int_array[4] = 50;
//		this.texture_index_int_array[5] = 51;
//		this.texture_index_int_array[6] = 52;
//		this.texture_index_int_array[7] = 52;
//		this.texture_index_int_array[8] = 52;
//		this.texture_index_int_array[9] = 53;
//		this.texture_index_int_array[10] = 9;
//		this.texture_index_int_array[11] = 50;
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
//		this.glow_byte_array[9 / 8] ^= 2;//Math.pow(2, 9 % 8)
//		super.setGlow();
//	}
}

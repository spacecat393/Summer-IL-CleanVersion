package com.nali.list.render.s;

import com.nali.da.IBothDaNe;
import com.nali.da.IBothDaSn;
import com.nali.da.client.IClientDaS;
import com.nali.small.entity.IMixLe;
import com.nali.small.entity.memo.client.ClientSle;
import com.nali.small.entity.memo.client.box.mix.MixBoxSle;
import com.nali.small.entity.memo.client.render.mix.MixRenderSe;
import com.nali.sound.ISoundDaLe;
import com.nali.summer.da.both.BothDaYuzu;
import com.nali.summer.da.client.ClientDaYuzu;
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
public class RenderYuzu<E extends EntityLivingBase, I extends IMixLe<SD, BD, E>, MB extends MixBoxSle<RC, ?, SD, BD, E, I, MR, C>, MR extends MixRenderSe<RC, ?, SD, BD, E, I, MB, C>, C extends ClientSle<RC, ?, SD, BD, E, I, MB, MR>, SD extends ISoundDaLe, BD extends IBothDaNe & IBothDaSn, RC extends IClientDaS> extends SummerRenderSe<E, I, MB, MR, C, SD, BD, RC>
{
//	public static int ID;
//	public static DataLoader DATALOADER = RenderHelper.DATALOADER;
//	public static BothData BOTHDATA = SummerYuzu.BOTHDATA;
	public static IClientDaS ICLIENTDAS = new ClientDaYuzu();
	public static IBothDaSn IBOTHDASN = BothDaYuzu.IBOTHDASN;
	public Map<Integer, Integer> texture_map = new HashMap();//ebo texture_id

	public RenderYuzu(RC rc, BD bd)
	{
		super(rc, bd);
//		this.texture_index_int_array[0] = 62;
//		this.texture_index_int_array[1] = 54;
//		this.texture_index_int_array[2] = 63;
//		this.texture_index_int_array[3] = 63;
//		this.texture_index_int_array[4] = 64;
//		this.texture_index_int_array[5] = 65;
//		this.texture_index_int_array[6] = 64;
//		this.texture_index_int_array[7] = 60;
//		this.texture_index_int_array[8] = 9;
//		this.texture_map.put(this.dataloader.openglobjectmemory_array[CLIENTDATA.StartPart() + 8].ebo, 9);
//		this.texture_map.put(((OpenGLObjectMemory)this.dataloader.object_array[CLIENTDATA.StartPart() + 8]).ebo, 9);
		this.texture_map.put((G_LIST.get(rc.StartPart() + 8)).ebo, 9 + TEXTURE_STEP);
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

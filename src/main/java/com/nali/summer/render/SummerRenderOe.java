//package com.nali.summer.render;
//
//import com.nali.da.IBothDaE;
//import com.nali.da.IBothDaO;
//import com.nali.render.RenderO;
//import com.nali.small.entity.IMixE;
//import com.nali.small.entity.memo.client.ClientE;
//import com.nali.small.entity.memo.client.box.mix.MixBoxE;
//import com.nali.small.entity.memo.client.ci.MixCIE;
//import com.nali.small.entity.memo.client.render.mix.MixRenderE;
//import com.nali.small.render.IRenderO;
//import com.nali.small.render.RenderOe;
//import net.minecraft.entity.Entity;
//import net.minecraftforge.fml.relauncher.Side;
//import net.minecraftforge.fml.relauncher.SideOnly;
//
//import static com.nali.list.data.SummerData.SHADER_STEP;
//import static com.nali.list.data.SummerData.TEXTURE_STEP;
//
//@SideOnly(Side.CLIENT)
//public class SummerRenderOe
//<
//	E extends Entity,
//	I extends IMixE<BD, E>,
//	MC extends MixCIE<BD, ?, E, I, MB, MR, C>,
//	MB extends MixBoxE<BD, ?, E, I, MC, MR, C>,
//	MR extends MixRenderE<BD, ?, E, I, MC, MB, C>,
//	C extends ClientE<BD, ?, E, I, MC, MB, MR>,
//	BD extends IBothDaE & IBothDaO,
//	R extends RenderO<BD> & IRenderO<BD, R>
//> extends RenderOe<E, I, MC, MB, MR, C, BD, R>
//{
//	public SummerRenderOe(BD bd)
//	{
//		super(bd);
//	}
//
//	@Override
//	public int getTextureID()
//	{
//		return TEXTURE_STEP + super.getTextureID();
//	}
//
//	@Override
//	public int getShaderID()
//	{
//		return SHADER_STEP + super.getShaderID();
//	}
//}

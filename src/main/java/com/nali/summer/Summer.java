package com.nali.summer;

import com.nali.system.opengl.memo.client.MemoC;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = Summer.ID)
public class Summer
{
	public final static String ID = "summer";
	static
	{
		if (FMLCommonHandler.instance().getSide() == Side.CLIENT)
		{
			int max_bone = 220 * 16;
			if (MemoC.MAX_BONE < max_bone)
			{
				MemoC.MAX_BONE = max_bone;
			}
		}
//		count();
	}

//	public static native void run(int[] int_array);
//
//	public static void count()
//	{
//		System.load("/home/nali/Documents/GitHub/SmallRender/build/liblwjgl64.so");
////		int iterations = 100_000_000;
//		int iterations = 100;
////		int iterations = 10;
////		int normalVar = 0;
////		int bufferVar = 0;
//		int[] int_array = new int[iterations];
//
//		long normalStartTime = System.nanoTime();
//		//			normalVar += int_array[i];
//		Arrays.fill(int_array, 10);
//		long normalEndTime = System.nanoTime();
//		long normalDuration = normalEndTime - normalStartTime;
//
////		ByteBuffer buffer = ByteBuffer.allocateDirect(iterations << 2).order(ByteOrder.nativeOrder());
////		for (int i = 0; i < iterations; i++)
////		{
////			buffer.putInt(i);
////		}
////		buffer.flip();
//
//		long bufferStartTime = System.nanoTime();
////		for (int i = 0; i < iterations; i++)
////		{
////			bufferVar += buffer.getInt(i);
////		}
//		run(int_array);
//		long bufferEndTime = System.nanoTime();
//		long bufferDuration = bufferEndTime - bufferStartTime;
//
//		// Results
//		System.out.println("Normal variable access time: " + normalDuration + " ns");//1000000000
//		System.out.println("ByteBuffer access time: " + bufferDuration + " ns");
//		System.out.println("Difference: " + (bufferDuration - normalDuration) + " ns");
//	}

//	public Summer()
//	{
//		SmallRender smallrender = new SmallRender();
//		smallrender.init();
//		smallrender.runtime();
//	}

//	@Mod.Instance
//	public static Summer I;

//	@EventHandler
//	public void onFMLPreInitializationEvent(FMLPreInitializationEvent event)
//	{
//		if (event.getSide().isClient())
//		{
//			DataLoader.setModels(RenderHelper.DATALOADER, Reference.MOD_ID);
//		}
//	}
//
//	@EventHandler
//	public void onFMLInitializationEvent(FMLInitializationEvent event)
//	{
//		if (event.getSide().isClient())
//		{
//			DataLoader.setSounds(RenderHelper.DATALOADER, Reference.MOD_ID);
//		}
//	}
}

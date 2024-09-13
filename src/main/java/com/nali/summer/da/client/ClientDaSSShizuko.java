package com.nali.summer.da.client;

import com.nali.da.client.IClientDaS;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.nali.list.data.SummerData.*;

@SideOnly(Side.CLIENT)
public class ClientDaSSShizuko implements IClientDaS
{
//	public static IClientDaS ICLIENTDAS = new ClientDaSSShizuko();

	@Override
	public int FrameID()
	{
		return FRAME_STEP + 4;
	}

	@Override
	public int StartPart()
	{
		return MODEL_STEP + 37;
	}

	@Override
	public int EndPart()
	{
		return MODEL_STEP + 49;
	}
}

package com.nali.summer;

import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;

import javax.annotation.Nullable;
import java.util.Map;

public class Core implements IFMLLoadingPlugin
{
	@Override
	public String[] getASMTransformerClass()
	{
		return null;
	}

	@Override
	public String getModContainerClass()
	{
		return null;
	}

	@Nullable
	@Override
	public String getSetupClass()
	{
		return null;
	}

	@Override
	public void injectData(Map<String, Object> data)
	{

	}

	@Override
	public String getAccessTransformerClass()
	{
		return null;
	}
}
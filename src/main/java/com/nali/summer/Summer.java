package com.nali.summer;

import com.nali.summer.render.RenderHelper;
import com.nali.summer.system.Reference;
import com.nali.system.DataLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME)
public class Summer
{
    @Instance
    public static Summer I;

    @EventHandler
    public void onFMLPreInitializationEvent(FMLPreInitializationEvent event)
    {
        if (event.getSide().isClient())
        {
            DataLoader.setModels(RenderHelper.DATALOADER, Reference.MOD_ID);
        }
    }

    @EventHandler
    public void onFMLInitializationEvent(FMLInitializationEvent event)
    {
        if (event.getSide().isClient())
        {
            DataLoader.setSounds(RenderHelper.DATALOADER, Reference.MOD_ID);
        }
    }
}

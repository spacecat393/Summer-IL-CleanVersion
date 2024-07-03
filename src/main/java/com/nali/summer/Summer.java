package com.nali.summer;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;

@Mod(modid = Summer.ID)
public class Summer
{
    public final static String ID = "summer";

    @Instance
    public static Summer I;

//    @EventHandler
//    public void onFMLPreInitializationEvent(FMLPreInitializationEvent event)
//    {
//        if (event.getSide().isClient())
//        {
//            DataLoader.setModels(RenderHelper.DATALOADER, Reference.MOD_ID);
//        }
//    }
//
//    @EventHandler
//    public void onFMLInitializationEvent(FMLInitializationEvent event)
//    {
//        if (event.getSide().isClient())
//        {
//            DataLoader.setSounds(RenderHelper.DATALOADER, Reference.MOD_ID);
//        }
//    }
}

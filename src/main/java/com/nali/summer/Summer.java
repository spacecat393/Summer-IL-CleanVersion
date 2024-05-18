package com.nali.summer;

import com.nali.summer.system.Reference;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME)
public class Summer
{
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

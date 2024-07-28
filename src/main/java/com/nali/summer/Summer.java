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
    }

//    @Mod.Instance
//    public static Summer I;

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

package com.nali.summer.entities.memory.client;

import com.nali.data.BothData;
import com.nali.small.entities.bytes.WorkBytes;
import com.nali.small.entities.memory.ClientEntitiesMemory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ClientIbukiMemory extends ClientEntitiesMemory
{
    @SideOnly(Side.CLIENT)
    public int client_eyes_tick;

    public ClientIbukiMemory(BothData bothdata, WorkBytes workbytes)
    {
        super(bothdata, workbytes);
    }
}

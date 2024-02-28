package com.nali.summer.entities.memory.server;

import com.nali.data.BothData;
import com.nali.small.entities.bytes.WorkBytes;
import com.nali.small.entities.memory.server.ServerEntitiesMemory;
import com.nali.small.entities.skinning.SkinningEntities;

public class ServerSSUnaMemory extends ServerEntitiesMemory
{
    public boolean server_step_reload;

    public ServerSSUnaMemory(SkinningEntities skinningentities, BothData bothdata, WorkBytes workbytes)
    {
        super(skinningentities, bothdata, workbytes);
    }
}

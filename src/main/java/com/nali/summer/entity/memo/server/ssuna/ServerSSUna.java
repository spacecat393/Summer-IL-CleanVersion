package com.nali.summer.entity.memo.server.ssuna;

import com.nali.data.BothData;
import com.nali.small.entities.bytes.WorkBytes;
import com.nali.small.entities.memory.server.ServerEntitiesMemory;
import com.nali.small.entities.skinning.SkinningEntities;

public class ServerSSUna extends ServerEntitiesMemory
{
    public boolean server_step_reload;

    public ServerSSUna(SkinningEntities skinningentities, BothData bothdata, WorkBytes workbytes)
    {
        super(skinningentities, bothdata, workbytes);
    }
}

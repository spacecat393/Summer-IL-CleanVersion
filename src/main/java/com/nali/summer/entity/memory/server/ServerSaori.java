package com.nali.summer.entity.memory.server;

import com.nali.data.BothData;
import com.nali.small.entities.bytes.WorkBytes;
import com.nali.small.entities.memory.server.ServerEntitiesMemory;
import com.nali.small.entities.skinning.SkinningEntities;

public class ServerSaori extends ServerEntitiesMemory
{
    public boolean server_how_attack;

    public ServerSaori(SkinningEntities skinningentities, BothData bothdata, WorkBytes workbytes)
    {
        super(skinningentities, bothdata, workbytes);
    }
}

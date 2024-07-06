package com.nali.summer.entity.memo.server.sshino;

import com.nali.data.BothData;
import com.nali.small.entities.bytes.WorkBytes;
import com.nali.small.entities.memory.server.ServerEntitiesMemory;
import com.nali.small.entities.skinning.SkinningEntities;

public class ServerSSHino extends ServerEntitiesMemory
{
    public boolean server_how_die;

    public ServerSSHino(SkinningEntities skinningentities, BothData bothdata, WorkBytes workbytes)
    {
        super(skinningentities, bothdata, workbytes);
    }
}

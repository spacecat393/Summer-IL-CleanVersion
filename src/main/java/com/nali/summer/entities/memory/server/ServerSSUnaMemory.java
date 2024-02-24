package com.nali.summer.entities.memory.server;

import com.nali.data.BothData;
import com.nali.small.entities.bytes.WorkBytes;
import com.nali.small.entities.memory.server.ServerEntitiesMemory;

public class ServerSSUnaMemory extends ServerEntitiesMemory
{
    public boolean server_step_reload;

    public ServerSSUnaMemory(BothData bothdata, WorkBytes workbytes)
    {
        super(bothdata, workbytes);
    }
}

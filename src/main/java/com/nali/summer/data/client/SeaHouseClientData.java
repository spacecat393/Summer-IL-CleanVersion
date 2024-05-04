package com.nali.summer.data.client;

import com.nali.data.client.SkinningClientData;

public class SeaHouseClientData implements SkinningClientData
{
    @Override
    public int AnimationID()
    {
        return 37;
    }

    @Override
    public int StartPart()
    {
        return 38;
    }

    @Override
    public int EndPart()
    {
        return 41;
    }
}

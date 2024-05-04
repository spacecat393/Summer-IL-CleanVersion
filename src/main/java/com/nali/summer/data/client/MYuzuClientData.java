package com.nali.summer.data.client;

import com.nali.data.client.SkinningClientData;

public class MYuzuClientData implements SkinningClientData
{
    @Override
    public int AnimationID()
    {
        return 89;
    }

    @Override
    public int StartPart()
    {
        return 90;
    }

    @Override
    public int EndPart()
    {
        return 99;
    }
}

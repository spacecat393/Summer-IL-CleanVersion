package com.nali.summer.entities.bytes;

import com.nali.small.entities.bytes.WorkBytes;

public class MYuzuBytes implements WorkBytes
{
    @Override
    public int LOCK_INVENTORY()
    {
        return 0;
    }

    @Override
    public int LOCK_DAMAGE()
    {
        return 1;
    }

    @Override
    public int HARD_READY()
    {
        return 2;
    }

    @Override
    public int SOFT_READY()
    {
        return 3;
    }

    @Override
    public int AMMO()
    {
        return 4;
    }

    @Override
    public int ON_REVIVE()
    {
        return 5;
    }

    @Override
    public int ON_PAT()
    {
        return 6;
    }

    @Override
    public int ON_EAT()
    {
        return 6;
    }

    @Override
    public int SIT()
    {
        return 7;
    }

    @Override
    public int LOCATION()
    {
        return 8;
    }

    @Override
    public int FOLLOW()
    {
        return 9;
    }

    @Override
    public int REVIVE()
    {
        return 10;
    }

    @Override
    public int PLAY()
    {
        return -1;
    }

    @Override
    public int HEAL()
    {
        return -1;
    }

    @Override
    public int PROTECT()
    {
        return -1;
    }

    @Override
    public int CARE_OWNER()
    {
        return 11;
    }

    @Override
    public int ATTACK()
    {
        return 12;
    }

    @Override
    public int MINE()
    {
        return 13;
    }

    @Override
    public int PLANT()
    {
        return 14;
    }

    @Override
    public int FIND_ITEM()
    {
        return 15;
    }

    @Override
    public int RANDOM_WALK()
    {
        return 16;
    }

    @Override
    public int RANDOM_LOOK()
    {
        return 17;
    }

    @Override
    public int MAX_WORKS()
    {
        return 18;
    }
}

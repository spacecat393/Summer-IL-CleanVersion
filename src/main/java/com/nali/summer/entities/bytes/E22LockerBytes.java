package com.nali.summer.entities.bytes;

import com.nali.small.entities.bytes.WorkBytes;

public class E22LockerBytes implements WorkBytes
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
        return 2;
    }

    @Override
    public int AMMO()
    {
        return 2;
    }

    @Override
    public int ON_REVIVE()
    {
        return 2;
    }

    @Override
    public int ON_PAT()
    {
        return 2;
    }

    @Override
    public int ON_EAT()
    {
        return 2;
    }

    @Override
    public int WALK_TO()
    {
        return -1;
    }

    @Override
    public int SIT()
    {
        return 2;
    }

    @Override
    public int LOCATION()
    {
        return 3;
    }

    @Override
    public int FOLLOW()
    {
        return -1;
    }

    @Override
    public int REVIVE()
    {
        return -1;
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
        return -1;
    }

    @Override
    public int ATTACK()
    {
        return -1;
    }

    @Override
    public int MINE()
    {
        return -1;
    }

    @Override
    public int PLANT()
    {
        return -1;
    }

    @Override
    public int FIND_ITEM()
    {
        return 4;
    }

    @Override
    public int RANDOM_WALK()
    {
        return -1;
    }

    @Override
    public int LOOK_TO()
    {
        return -1;
    }

    @Override
    public int RANDOM_LOOK()
    {
        return -1;
    }

    @Override
    public int MAX_WORKS()
    {
        return 5;
    }
}

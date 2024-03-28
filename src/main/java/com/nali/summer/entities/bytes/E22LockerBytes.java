package com.nali.summer.entities.bytes;

import com.nali.small.entities.bytes.WorkBytes;

public class E22LockerBytes implements WorkBytes
{
    @Override
    public byte LOCK_INVENTORY()
    {
        return 0;
    }

    @Override
    public byte LOCK_DAMAGE()
    {
        return 1;
    }

    @Override
    public byte WALK_TO()
    {
        return 2;
    }

    @Override
    public byte USE_TO()
    {
        return 3;
    }

    @Override
    public byte SIT()
    {
        return 4;
    }

    @Override
    public byte LOCATION()
    {
        return 5;
    }

    @Override
    public byte FOLLOW()
    {
        return 6;
    }

    @Override
    public byte REVIVE()
    {
        return 7;
    }

    @Override
    public byte PLAY()
    {
        return -1;
    }

    @Override
    public byte HEAL()
    {
        return -1;
    }

    @Override
    public byte PROTECT()
    {
        return -1;
    }

    @Override
    public byte CARE_OWNER()
    {
        return -1;
    }

    @Override
    public byte ATTACK()
    {
        return -1;
    }

    @Override
    public byte MANAGE_ITEM()
    {
        return 8;
    }

    @Override
    public byte GET_ITEM()
    {
        return 9;
    }

    @Override
    public byte FISHING()
    {
        return 10;
    }

    @Override
    public byte PLANT()
    {
        return 11;
    }

    @Override
    public byte MINE()
    {
        return 12;
    }

    @Override
    public byte RANDOM_WALK()
    {
        return 13;
    }

    @Override
    public byte LOOK_TO()
    {
        return 14;
    }

    @Override
    public byte RANDOM_LOOK()
    {
        return 15;
    }

    @Override
    public byte MAX_WORKS()
    {
        return 2;
    }
}

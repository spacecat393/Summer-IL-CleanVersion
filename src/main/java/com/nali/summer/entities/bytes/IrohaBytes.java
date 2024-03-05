package com.nali.summer.entities.bytes;

import com.nali.small.entities.bytes.WorkBytes;

public class IrohaBytes implements WorkBytes
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

//    @Override
//    public int HARD_READY()
//    {
//        return 2;
//    }

//    @Override
//    public int SOFT_READY()
//    {
//        return 3;
//    }

//    @Override
//    public int AMMO()
//    {
//        return 4;
//    }

//    @Override
//    public int ON_REVIVE()
//    {
//        return 5;
//    }

//    @Override
//    public int ON_PAT()
//    {
//        return 6;
//    }

//    @Override
//    public int ON_EAT()
//    {
//        return 6;
//    }

    @Override
    public int WALK_TO()
    {
        return 2;
    }

    @Override
    public int SIT()
    {
        return 3;
    }

    @Override
    public int LOCATION()
    {
        return 4;
    }

    @Override
    public int FOLLOW()
    {
        return 5;
    }

    @Override
    public int REVIVE()
    {
        return 6;
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
        return 7;
    }

    @Override
    public int ATTACK()
    {
        return 8;
    }

    @Override
    public int MINE()
    {
        return 9;
    }

    @Override
    public int PLANT()
    {
        return 10;
    }

    @Override
    public int FISHING()
    {
        return 11;
    }

    @Override
    public int FIND_ITEM()
    {
        return 12;
    }

    @Override
    public int RANDOM_WALK()
    {
        return 13;
    }

    @Override
    public int LOOK_TO()
    {
        return 14;
    }

    @Override
    public int RANDOM_LOOK()
    {
        return 15;
    }

    @Override
    public int MAX_WORKS()
    {
        return 16;
    }
}

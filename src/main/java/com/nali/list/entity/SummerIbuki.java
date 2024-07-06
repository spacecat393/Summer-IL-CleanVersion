package com.nali.list.entity;

import com.nali.data.BothData;
import com.nali.data.IBothDaNe;
import com.nali.small.entities.bytes.WorkBytes;
import com.nali.small.entities.memory.client.ClientEntitiesMemory;
import com.nali.small.entities.memory.server.ServerEntitiesMemory;
import com.nali.small.entities.skinning.SkinningEntities;
import com.nali.small.entities.skinning.ai.frame.SkinningEntitiesLiveFrame;
import com.nali.small.entities.sounds.Sounds;
import com.nali.small.entity.EntityLeInv;
import com.nali.summer.da.both.BothDaIbuki;
import com.nali.summer.da.both.BothDaIroha;
import com.nali.summer.entity.sound.SoundIbuki;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;

public class SummerIbuki extends EntityLeInv
{
    public static int eggPrimary = 0xfef5cb;
    public static int eggSecondary = 0xab6402;

    public final static DataParameter<Byte>[] BYTE_DATAPARAMETER_ARRAY = new DataParameter[BothDaIbuki.MAX_SYNC];
    public final static DataParameter<Integer>[] INTEGER_DATAPARAMETER_ARRAY = new DataParameter[BothDaIbuki.MAX_FRAME + BothDaIroha.MAX_FRAME];
    public final static DataParameter<Float>[] FLOAT_DATAPARAMETER_ARRAY = new DataParameter[2];

    static
    {
        for (int i = 0; i < BYTE_DATAPARAMETER_ARRAY.length; ++i)
        {
            BYTE_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerIbuki.class, DataSerializers.BYTE);
        }

        for (int i = 0; i < INTEGER_DATAPARAMETER_ARRAY.length; ++i)
        {
            INTEGER_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerIbuki.class, DataSerializers.VARINT);
        }

        for (int i = 0; i < FLOAT_DATAPARAMETER_ARRAY.length; ++i)
        {
            FLOAT_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerIbuki.class, DataSerializers.FLOAT);
        }
    }

    public SummerIbuki(World world)
    {
        super(world);
    }

    @Override
    public void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.05D);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(12.0D);
    }

    @Override
    public byte[] getAI()
    {
        return ;
    }

    @Override
    public DataParameter<Byte>[] getByteDataParameterArray()
    {
        return BYTE_DATAPARAMETER_ARRAY;
    }

    @Override
    public DataParameter<Integer>[] getIntegerDataParameterArray()
    {
        return INTEGER_DATAPARAMETER_ARRAY;
    }

    @Override
    public DataParameter<Float>[] getFloatDataParameterArray()
    {
        return FLOAT_DATAPARAMETER_ARRAY;
    }

    @Override
    public void newC()
    {

    }

    @Override
    public void newS()
    {

    }

    @Override
    public IBothDaNe getBD()
    {
        return BothDaIbuki.IBOTHDASN;
    }

    @Override
    public Object getSD()
    {
        return SoundIbuki.ISOUNDLE;
    }

    @Override
    public void collideWithNearbyEntities()
    {
        if (this.world.isRemote || ((ServerEntitiesMemory)this.bothentitiesmemory).entitiesaimemory.skinningentitiesplaywith.playwith_skinningentities == null || !((ServerEntitiesMemory)this.bothentitiesmemory).entitiesaimemory.skinningentitiesplaywith.should_play)
        {
            super.collideWithNearbyEntities();
        }
    }

    @Override
    public boolean canBePushed()
    {
        return this.world.isRemote || ((ServerEntitiesMemory)this.bothentitiesmemory).entitiesaimemory.skinningentitiesplaywith.playwith_skinningentities == null || !((ServerEntitiesMemory)this.bothentitiesmemory).entitiesaimemory.skinningentitiesplaywith.should_play;
    }
}

package com.nali.list.entity;

import com.nali.da.IBothDaNe;
import com.nali.list.render.s.RenderIbuki;
import com.nali.small.entity.EntityLeInv;
import com.nali.small.entity.Inventory;
import com.nali.small.entity.memo.client.box.mix.MixBoxSle;
import com.nali.summer.da.both.BothDaIbuki;
import com.nali.summer.da.client.ClientDaIbuki;
import com.nali.summer.entity.memo.client.ibuki.ClientIbuki;
import com.nali.summer.entity.memo.client.ibuki.MixRenderIbuki;
import com.nali.summer.entity.memo.server.ibuki.MixAIIbuki;
import com.nali.summer.entity.memo.server.ibuki.ServerIbuki;
import com.nali.summer.entity.sound.SoundDaIbuki;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.nali.Nali.I;

public class SummerIbuki extends EntityLeInv
{
    public static int eggPrimary = 0xfef5cb;
    public static int eggSecondary = 0xab6402;

    public final static DataParameter<Byte>[] BYTE_DATAPARAMETER_ARRAY = new DataParameter[BothDaIbuki.MAX_SYNC];
    public final static DataParameter<Integer>[] INTEGER_DATAPARAMETER_ARRAY = new DataParameter[BothDaIbuki.MAX_FRAME/* + BothDaIroha.MAX_FRAME*/];
    public final static DataParameter<Float>[] FLOAT_DATAPARAMETER_ARRAY = new DataParameter[1/*2*/];

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
        return MixAIIbuki.AI_BYTE_ARRAY;
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

    @SideOnly(Side.CLIENT)
    @Override
    public void newC()
    {
        RenderIbuki r = new RenderIbuki(I.clientloader.stores, ClientDaIbuki.ICLIENTDAS, BothDaIbuki.IBOTHDASN);
        ClientIbuki c = new ClientIbuki(this, r, new Inventory(1));
        c.mb = new MixBoxSle(c);
        c.mr = new MixRenderIbuki(c);
        r.c = c;
        this.ibothleinv = c;
    }

    @Override
    public void newS()
    {
        ServerIbuki s = new ServerIbuki(this, new Inventory(1));
        s.a = new MixAIIbuki(s);
        s.initFrame();
        this.ibothleinv = s;
    }

    @Override
    public IBothDaNe getBD()
    {
        return BothDaIbuki.IBOTHDASN;
    }

    @Override
    public Object getSD()
    {
        return SoundDaIbuki.ISOUNDDALE;
    }
}

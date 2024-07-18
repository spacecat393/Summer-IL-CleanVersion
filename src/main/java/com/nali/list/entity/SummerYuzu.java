package com.nali.list.entity;

import com.nali.da.IBothDaNe;
import com.nali.list.render.s.RenderYuzu;
import com.nali.small.entity.EntityLeInv;
import com.nali.small.entity.Inventory;
import com.nali.small.entity.memo.client.box.mix.MixBoxSle;
import com.nali.summer.da.both.BothDaYuzu;
import com.nali.summer.da.client.ClientDaYuzu;
import com.nali.summer.entity.memo.client.yuzu.ClientYuzu;
import com.nali.summer.entity.memo.client.yuzu.MixRenderYuzu;
import com.nali.summer.entity.memo.server.yuzu.MixAIYuzu;
import com.nali.summer.entity.memo.server.yuzu.ServerYuzu;
import com.nali.summer.entity.sound.SoundDaYuzu;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.nali.Nali.I;

public class SummerYuzu extends EntityLeInv
{
    public static int eggPrimary = 0xfbdad0;
    public static int eggSecondary = 0xfc6c78;

    public final static DataParameter<Byte>[] BYTE_DATAPARAMETER_ARRAY = new DataParameter[BothDaYuzu.MAX_SYNC];
    public final static DataParameter<Integer>[] INTEGER_DATAPARAMETER_ARRAY = new DataParameter[BothDaYuzu.MAX_FRAME];
    public final static DataParameter<Float>[] FLOAT_DATAPARAMETER_ARRAY = new DataParameter[1];

    static
    {
        for (int i = 0; i < BYTE_DATAPARAMETER_ARRAY.length; ++i)
        {
            BYTE_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerYuzu.class, DataSerializers.BYTE);
        }

        for (int i = 0; i < INTEGER_DATAPARAMETER_ARRAY.length; ++i)
        {
            INTEGER_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerYuzu.class, DataSerializers.VARINT);
        }

        for (int i = 0; i < FLOAT_DATAPARAMETER_ARRAY.length; ++i)
        {
            FLOAT_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerYuzu.class, DataSerializers.FLOAT);
        }
    }

    public SummerYuzu(World world)
    {
        super(world);
    }

    @Override
    public void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.05D);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(10.0D);
    }

    @Override
    public byte[] getAI()
    {
        return MixAIYuzu.AI_BYTE_ARRAY;
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
        RenderYuzu r = new RenderYuzu(I.clientloader.stores, ClientDaYuzu.ICLIENTDAS, BothDaYuzu.IBOTHDASN);
        ClientYuzu c = new ClientYuzu(this, r, new Inventory(1));
        c.mb = new MixBoxSle(c);
        c.mr = new MixRenderYuzu(c);
        r.c = c;
        this.ibothleinv = c;
    }

    @Override
    public void newS()
    {
        ServerYuzu s = new ServerYuzu(this, new Inventory(1));
        MixAIYuzu a = new MixAIYuzu(s);
        s.a = a;
        a.init();
        s.initFrame();
        this.ibothleinv = s;
    }

    @Override
    public IBothDaNe getBD()
    {
        return BothDaYuzu.IBOTHDASN;
    }

    @Override
    public Object getSD()
    {
        return SoundDaYuzu.ISOUNDDALE;
    }
//    @Override
//    @SideOnly(Side.CLIENT)
//    public Object createObjectRender()
//    {
//        return new YuzuRender(new EntitiesRenderMemory(), this);
//    }
//    @Override
//    @SideOnly(Side.CLIENT)
//    public Object createSoundRender()
//    {
//        return new SoundRender();
//    }
//
//    @Override
//    @SideOnly(Side.CLIENT)
//    public int[] getIVIntArray()
//    {
//        return ClientYuzuMemory.IV_INT_ARRAY;
//    }
}

package com.nali.list.entity;

import com.nali.da.IBothDaNe;
import com.nali.list.render.s.RenderSSUna;
import com.nali.small.entity.EntityLeInv;
import com.nali.small.entity.Inventory;
import com.nali.small.entity.memo.client.box.mix.MixBoxSle;
import com.nali.summer.da.both.BothDaSSUna;
import com.nali.summer.da.client.ClientDaSSUna;
import com.nali.summer.entity.memo.client.ssuna.ClientSSUna;
import com.nali.summer.entity.memo.client.ssuna.MixRenderSSUna;
import com.nali.summer.entity.memo.server.ssuna.MixAISSUna;
import com.nali.summer.entity.memo.server.ssuna.ServerSSUna;
import com.nali.summer.entity.sound.SoundDaSSUna;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SummerSSUna extends EntityLeInv
{
    public static int eggPrimary = 0x7d4a39;
    public static int eggSecondary = 0xf4c4d7;

    public final static DataParameter<Byte>[] BYTE_DATAPARAMETER_ARRAY = new DataParameter[BothDaSSUna.MAX_SYNC];
    public final static DataParameter<Integer>[] INTEGER_DATAPARAMETER_ARRAY = new DataParameter[BothDaSSUna.MAX_FRAME];
    public final static DataParameter<Float>[] FLOAT_DATAPARAMETER_ARRAY = new DataParameter[1];

    static
    {
        for (int i = 0; i < BYTE_DATAPARAMETER_ARRAY.length; ++i)
        {
            BYTE_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerSSUna.class, DataSerializers.BYTE);
        }

        for (int i = 0; i < INTEGER_DATAPARAMETER_ARRAY.length; ++i)
        {
            INTEGER_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerSSUna.class, DataSerializers.VARINT);
        }

        for (int i = 0; i < FLOAT_DATAPARAMETER_ARRAY.length; ++i)
        {
            FLOAT_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerSSUna.class, DataSerializers.FLOAT);
        }
    }

    public SummerSSUna(World world)
    {
        super(world);
    }

//    @Override
//    public AxisAlignedBB getMouthAxisAlignedBB()
//    {
//        ClientEntitiesMemory cliententitiesmemory = (ClientEntitiesMemory)this.bothentitiesmemory;
//        SkinningRender skinningrender = (SkinningRender)cliententitiesmemory.objectrender;
//        int frame = skinningrender.frame_int_array[0];
//
//        if (frame > 314 && frame < 351)
//        {
//            double hw = this.width / 2.0F;
//            double hh = 0.5;
//            Vec3d view_vec3d = this.getVectorForRotation(this.rotationPitch, this.rotationYaw + 90.0F).scale(0.5);
//            double x = this.posX + view_vec3d.x;
//            double y = this.posY + this.height / 2.0F + view_vec3d.y;
//            double z = this.posZ + view_vec3d.z;
//            return new AxisAlignedBB(x - hw, y, z - hw, x + hw, y + hh, z + hw);
//        }
//        else
//        {
//            return super.getMouthAxisAlignedBB();
//        }
//    }

    @Override
    public void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.05D);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(20.0D);
    }

    @Override
    public byte[] getAI()
    {
        return MixAISSUna.AI_BYTE_ARRAY;
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
        RenderSSUna r = new RenderSSUna(ClientDaSSUna.ICLIENTDAS, BothDaSSUna.IBOTHDASN);
        ClientSSUna c = new ClientSSUna(this, r, new Inventory(1));
        c.mb = new MixBoxSle(c);
        c.mr = new MixRenderSSUna(c);
        r.c = c;
        this.ibothleinv = c;
    }

    @Override
    public void newS()
    {
        ServerSSUna s = new ServerSSUna(this, new Inventory(1));
        MixAISSUna a = new MixAISSUna(s);
        s.a = a;
        a.init();
        s.initFrame();
        this.ibothleinv = s;
    }

    @Override
    public IBothDaNe getBD()
    {
        return BothDaSSUna.IBOTHDASN;
    }

    @Override
    public Object getSD()
    {
        return SoundDaSSUna.ISOUNDDALE;
    }

//    @Override
//    @SideOnly(Side.CLIENT)
//    public Object createObjectRender()
//    {
//        return new SSUnaRender(new EntitiesRenderMemory(), this);
//    }

//    @Override
//    @SideOnly(Side.CLIENT)
//    public Object createSoundRender()
//    {
////        return SoundRender.getSoundRender(DATALOADER);
//        return new NoSoundRender();
//    }
//
//    @Override
//    @SideOnly(Side.CLIENT)
//    public int[] getIVIntArray()
//    {
//        return ClientSSUnaMemory.IV_INT_ARRAY;
//    }
}

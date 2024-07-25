package com.nali.list.entity;

import com.nali.da.IBothDaNe;
import com.nali.list.render.s.RenderSSZuko;
import com.nali.small.entity.EntityLeInv;
import com.nali.small.entity.Inventory;
import com.nali.small.entity.memo.client.box.mix.MixBoxSle;
import com.nali.summer.da.both.BothDaSSZuko;
import com.nali.summer.da.both.BothDaSeaHouse;
import com.nali.summer.da.client.ClientDaSSZuko;
import com.nali.summer.entity.memo.client.sszuko.ClientSSZuko;
import com.nali.summer.entity.memo.client.sszuko.MixRenderSSZuko;
import com.nali.summer.entity.memo.server.sszuko.MixAISSZuko;
import com.nali.summer.entity.memo.server.sszuko.ServerSSZuko;
import com.nali.summer.entity.sound.SoundDaSSZuko;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SummerSSZuko extends EntityLeInv
{
    public static int eggPrimary = 0xfff0e2;
    public static int eggSecondary = 0x645353;

    public final static DataParameter<Byte>[] BYTE_DATAPARAMETER_ARRAY = new DataParameter[BothDaSSZuko.MAX_SYNC];
    public final static DataParameter<Integer>[] INTEGER_DATAPARAMETER_ARRAY = new DataParameter[BothDaSSZuko.MAX_FRAME + BothDaSeaHouse.MAX_FRAME];
    public final static DataParameter<Float>[] FLOAT_DATAPARAMETER_ARRAY = new DataParameter[1];

    static
    {
        for (int i = 0; i < BYTE_DATAPARAMETER_ARRAY.length; ++i)
        {
            BYTE_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerSSZuko.class, DataSerializers.BYTE);
        }

        for (int i = 0; i < INTEGER_DATAPARAMETER_ARRAY.length; ++i)
        {
            INTEGER_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerSSZuko.class, DataSerializers.VARINT);
        }

        for (int i = 0; i < FLOAT_DATAPARAMETER_ARRAY.length; ++i)
        {
            FLOAT_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerSSZuko.class, DataSerializers.FLOAT);
        }
    }

    public SummerSSZuko(World world)
    {
        super(world);
    }

//    @Override
//    @SideOnly(Side.CLIENT)
//    public void initFakeFrame()
//    {
//        ClientEntitiesMemory cliententitiesmemory = (ClientEntitiesMemory)this.bothentitiesmemory;
//        SSZukoRender sszukorender = (SSZukoRender)cliententitiesmemory.objectrender;
//        Arrays.fill(sszukorender.seahouserender.model_byte_array, (byte)0);
//    }

//    @Override
//    public AxisAlignedBB getMouthAxisAlignedBB()
//    {
//        ClientEntitiesMemory cliententitiesmemory = (ClientEntitiesMemory)this.bothentitiesmemory;
//        SkinningRender skinningrender = (SkinningRender)cliententitiesmemory.objectrender;
//        int frame = skinningrender.frame_int_array[0];
//
//        if (frame > 532 && frame < 751)
//        {
//            double hw = this.width / 2.0F;
//            double hh = 0.5;
//            Vec3d view_vec3d = this.getVectorForRotation(this.rotationPitch, this.rotationYaw + 180.0F).scale(0.5);
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
        return MixAISSZuko.AI_BYTE_ARRAY;
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
        RenderSSZuko r = new RenderSSZuko(ClientDaSSZuko.ICLIENTDAS, BothDaSSZuko.IBOTHDASN);
        ClientSSZuko c = new ClientSSZuko(this, r, new Inventory(1));
        c.mb = new MixBoxSle(c);
        c.mr = new MixRenderSSZuko(c);
        r.c = c;
        this.ibothleinv = c;
    }

    @Override
    public void newS()
    {
        ServerSSZuko s = new ServerSSZuko(this, new Inventory(1));
        MixAISSZuko a = new MixAISSZuko(s);
        s.a = a;
        a.init();
        s.initFrame();
        this.ibothleinv = s;
    }

    @Override
    public IBothDaNe getBD()
    {
        return BothDaSSZuko.IBOTHDASN;
    }

    @Override
    public Object getSD()
    {
        return SoundDaSSZuko.ISOUNDDALE;
    }

//    @Override
//    @SideOnly(Side.CLIENT)
//    public Object createObjectRender()
//    {
//        return new SSZukoRender(new EntitiesRenderMemory(), this);
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
//        return ClientSSZukoMemory.IV_INT_ARRAY;
//    }
}

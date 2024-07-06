package com.nali.list.entity;

import com.nali.data.IBothDaNe;
import com.nali.list.render.s.RenderAris;
import com.nali.small.entity.EntityLeInv;
import com.nali.small.entity.Inventory;
import com.nali.small.entity.memo.client.box.mix.MixBoxSle;
import com.nali.summer.da.both.BothDaAris;
import com.nali.summer.da.client.ClientDaAris;
import com.nali.summer.entity.memo.client.aris.ClientAris;
import com.nali.summer.entity.memo.client.aris.MixRenderAris;
import com.nali.summer.entity.memo.server.aris.MixAIAris;
import com.nali.summer.entity.memo.server.aris.ServerAris;
import com.nali.summer.entity.sound.SoundAris;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.nali.Nali.I;

public class SummerAris extends EntityLeInv
{
    public static int eggPrimary = 0x454D60;
    public static int eggSecondary = 0xF8E9E4;

    public final static DataParameter<Byte>[] BYTE_DATAPARAMETER_ARRAY = new DataParameter[BothDaAris.MAX_SYNC];
    public final static DataParameter<Integer>[] INTEGER_DATAPARAMETER_ARRAY = new DataParameter[BothDaAris.MAX_FRAME];
    public final static DataParameter<Float>[] FLOAT_DATAPARAMETER_ARRAY = new DataParameter[1];

    static
    {
        for (int i = 0; i < BYTE_DATAPARAMETER_ARRAY.length; ++i)
        {
            BYTE_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerAris.class, DataSerializers.BYTE);
        }

        for (int i = 0; i < INTEGER_DATAPARAMETER_ARRAY.length; ++i)
        {
            INTEGER_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerAris.class, DataSerializers.VARINT);
        }

        for (int i = 0; i < FLOAT_DATAPARAMETER_ARRAY.length; ++i)
        {
            FLOAT_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerAris.class, DataSerializers.FLOAT);
        }
    }

    public SummerAris(World world)
    {
        super(world);
    }

//    @Override
//    @SideOnly(Side.CLIENT)
//    public void updateClient()
//    {
//        ClientEntitiesMemory cliententitiesmemory = (ClientEntitiesMemory)this.bothentitiesmemory;
//        ArisRender skinningrender = (ArisRender)cliententitiesmemory.objectrender;
//        BothData bothdata = cliententitiesmemory.bothdata;
//        int frame = skinningrender.frame_int_array[0];
//
//        if (frame < 205)
//        {
////            skinningrender.model_byte_array[4 / 8] &= 239;//255 - Math.pow(2, 4 % 8)
////            skinningrender.model_byte_array[6 / 8] &= 191;//255 - Math.pow(2, 6 % 8)
//            skinningrender.model_byte_array[0] &= 239 & 191;
//        }
//        else
//        {
////            skinningrender.model_byte_array[4 / 8] |= 16;//Math.pow(2, 4 % 8)
////            skinningrender.model_byte_array[6 / 8] |= 64;//Math.pow(2, 6 % 8)
//            skinningrender.model_byte_array[0] |= 16 | 64;
//        }
//
//        float scale = skinningrender.entitiesrendermemory.scale;
//        if (frame > 834 && frame < 861)
//        {
//            this.width = bothdata.Width() * scale;
//            this.height = 0.65F * scale;
//        }
//        else if (frame > 737 && frame < 784)
//        {
//            this.width = 1.5F * scale;
//            this.height = 0.2F * scale;
//        }
//        else
//        {
//            this.width = bothdata.Width() * scale;
//            this.height = bothdata.Height() * scale;
//        }
//    }

//    @Override
//    public AxisAlignedBB getMouthAxisAlignedBB()
//    {
//        ClientEntitiesMemory cliententitiesmemory = (ClientEntitiesMemory)this.bothentitiesmemory;
//        SkinningRender skinningrender = (SkinningRender)cliententitiesmemory.objectrender;
//        int frame = skinningrender.frame_int_array[0];
//
//        if (frame > 834 && frame < 861)
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

//    @Override
//    public BothData createBothData()
//    {
//        return BOTHDATA;
//    }
//
//    @Override
//    public WorkBytes createWorkBytes()
//    {
//        return WORKBYTES;
//    }

    @Override
    public void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.05D);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(20.0D);
    }

//    @Override
//    public void createServer()
//    {
//        ServerEntitiesMemory serverentitiesmemory = (ServerEntitiesMemory)this.bothentitiesmemory;
//        WorkBytes workbytes = serverentitiesmemory.workbytes;
//
//        serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array = new SkinningEntitiesLiveFrame[1];
//
//        serverentitiesmemory.entitiesaimemory.skinningentitiesattack.attack_frame_int_array = ATTACK_FRAME_INT_ARRAY;
//        serverentitiesmemory.entitiesaimemory.skinningentitiesattack.max_magic_point = 2;
//        serverentitiesmemory.entitiesaimemory.skinningentitiesattack.minimum_distance = 48.0F;
//
//        serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0] = new SkinningEntitiesLiveFrame(this, 0, FRAME_INT_2D_ARRAY);
//        serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].condition_boolean_supplier_array = new Supplier[]
//        {
//            () -> this.isZeroMove() && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoop(0),
//            () -> (serverentitiesmemory.current_work_byte_array[workbytes.SIT() / 8] >> workbytes.SIT() % 8 & 1) == 1 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoopFB(1),
//            () -> (serverentitiesmemory.main_work_byte_array[workbytes.ATTACK() / 8] >> workbytes.ATTACK() % 8 & 1) == 1 && this.moveForward == 0 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopOffSet(3, 4),
//            () -> serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setShoot(2, 10, 11, 12, false, serverentitiesmemory.entitiesaimemory.skinningentitiesattack),
//            () -> (serverentitiesmemory.main_work_byte_array[workbytes.ATTACK() / 8] >> workbytes.ATTACK() % 8 & 1) == 1 && this.moveForward != 0 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(3),
//            () -> this.moveForward != 0 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(5),
//            () -> (serverentitiesmemory.statentitiesmemory.stat & 4) == 4 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopFree(6, (byte)4),
//            () -> ((serverentitiesmemory.statentitiesmemory.stat & 1) == 1 || (serverentitiesmemory.statentitiesmemory.stat & 2) == 2 || (serverentitiesmemory.statentitiesmemory.stat & 8) == 8) && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopFree(7, (byte)(1 + 2 + 8)),
//            () -> (serverentitiesmemory.main_work_byte_array[workbytes.ATTACK() / 8] >> workbytes.ATTACK() % 8 & 1) == 1 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(8),
//            () -> serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(9)
//        };
//    }

    @Override
    public byte[] getAI()
    {
        return MixAIAris.AI_BYTE_ARRAY;
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
        RenderAris r = new RenderAris(I.clientloader.stores, ClientDaAris.ICLIENTDAS, BothDaAris.IBOTHDASN);
        ClientAris c = new ClientAris(this, r, new Inventory(1));
        c.mb = new MixBoxSle(c);
        c.mr = new MixRenderAris(c);
        r.c = c;
        this.ibothleinv = c;
    }

    @Override
    public void newS()
    {
        ServerAris s = new ServerAris(this, new Inventory(1));
        s.a = new MixAIAris(s);
        s.initFrame();
        this.ibothleinv = s;
    }

    @Override
    public IBothDaNe getBD()
    {
        return BothDaAris.IBOTHDASN;
    }

    @Override
    public Object getSD()
    {
        return SoundAris.ISOUNDLE;
    }

//    @Override
//    @SideOnly(Side.CLIENT)
//    public Object createObjectRender()
//    {
//        return new ArisRender(new EntitiesRenderMemory(), this);
//    }

//    @Override
//    public Sounds createSounds()
//    {
//        return SOUNDS;
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
//        return ClientArisMemory.IV_INT_ARRAY;
//    }

//    @Override
//    @SideOnly(Side.CLIENT)
//    public void createClientEntitiesMemory(SkinningEntities skinningentities, BothData bothdata, WorkBytes workbytes)
//    {
//        new ClientArisMemory(skinningentities, bothdata, workbytes);
//    }
}

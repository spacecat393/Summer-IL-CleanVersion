package com.nali.list.entity;

import com.nali.da.IBothDaNe;
import com.nali.list.render.s.RenderReisa;
import com.nali.small.entity.EntityLeInv;
import com.nali.small.entity.Inventory;
import com.nali.small.entity.memo.client.box.mix.MixBoxSle;
import com.nali.summer.da.both.BothDaReisa;
import com.nali.summer.entity.memo.client.reisa.ClientReisa;
import com.nali.summer.entity.memo.client.reisa.MixRenderReisa;
import com.nali.summer.entity.memo.server.reisa.MixAIReisa;
import com.nali.summer.entity.memo.server.reisa.ServerReisa;
import com.nali.summer.entity.sound.SoundDaReisa;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SummerReisa extends EntityLeInv
{
	public static int eggPrimary = 0x4e466d;
	public static int eggSecondary = 0xbdb5ff;

	public final static DataParameter<Byte>[] BYTE_DATAPARAMETER_ARRAY = new DataParameter[BothDaReisa.MAX_SYNC];
	public final static DataParameter<Integer>[] INTEGER_DATAPARAMETER_ARRAY = new DataParameter[BothDaReisa.MAX_FRAME];
	public final static DataParameter<Float>[] FLOAT_DATAPARAMETER_ARRAY = new DataParameter[1];

	static
	{
		for (int i = 0; i < BYTE_DATAPARAMETER_ARRAY.length; ++i)
		{
			BYTE_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerReisa.class, DataSerializers.BYTE);
		}

		for (int i = 0; i < INTEGER_DATAPARAMETER_ARRAY.length; ++i)
		{
			INTEGER_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerReisa.class, DataSerializers.VARINT);
		}

		for (int i = 0; i < FLOAT_DATAPARAMETER_ARRAY.length; ++i)
		{
			FLOAT_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerReisa.class, DataSerializers.FLOAT);
		}
	}

	public SummerReisa(World world)
	{
		super(world);
	}

//	@Override
//	@SideOnly(Side.CLIENT)
//	public void initFakeFrame()
//	{
//		ClientEntitiesMemory cliententitiesmemory = (ClientEntitiesMemory)this.bothentitiesmemory;
//		ResaRender skinningrender = (ResaRender)cliententitiesmemory.objectrender;
//		skinningrender.model_byte_array[0 / 8] &= 255-1;//255 - Math.pow(2, 0 % 8)
////		skinningrender.model_byte_array[5 / 8] |= 32;//Math.pow(2, 5 % 8)
//		skinningrender.model_byte_array[8 / 8] &= 255-1;//255 - Math.pow(2, 8 % 8)
//	}

	@Override
	public void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.05D);
		this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(15.0D);
	}

	@Override
	public byte[] getAI()
	{
		return MixAIReisa.AI_BYTE_ARRAY;
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
		RenderReisa r = new RenderReisa(RenderReisa.ICLIENTDAS, BothDaReisa.IBOTHDASN);
		ClientReisa c = new ClientReisa(this, r, new Inventory(1));
		c.mb = new MixBoxSle(c);
		c.mr = new MixRenderReisa(c);
		r.c = c;
		this.ibothleinv = c;
	}

	@Override
	public void newS()
	{
		ServerReisa s = new ServerReisa(this, new Inventory(1));
		MixAIReisa a = new MixAIReisa(s);
		s.a = a;
		a.init();
		s.initFrame();
		this.ibothleinv = s;
	}

	@Override
	public IBothDaNe getBD()
	{
		return BothDaReisa.IBOTHDASN;
	}

	@Override
	public Object getSD()
	{
		return SoundDaReisa.ISOUNDDALE;
	}

//	@Override
//	@SideOnly(Side.CLIENT)
//	public Object createObjectRender()
//	{
//		return new ResaRender(new EntitiesRenderMemory(), this);
//	}

//	@Override
//	@SideOnly(Side.CLIENT)
//	public Object createSoundRender()
//	{
////		return SoundRender.getSoundRender(DATALOADER);
//		return new NoSoundRender();
//	}
//
//	@Override
//	@SideOnly(Side.CLIENT)
//	public int[] getIVIntArray()
//	{
//		return ClientResaMemory.IV_INT_ARRAY;
//	}
}

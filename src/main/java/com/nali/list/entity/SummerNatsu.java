package com.nali.list.entity;

import com.nali.da.IBothDaNe;
import com.nali.list.render.s.RenderNatsu;
import com.nali.small.entity.EntityLeInv;
import com.nali.small.entity.Inventory;
import com.nali.small.entity.memo.client.box.mix.MixBoxSle;
import com.nali.summer.da.both.BothDaNatsu;
import com.nali.summer.entity.memo.client.natsu.ClientNatsu;
import com.nali.summer.entity.memo.client.natsu.MixRenderNatsu;
import com.nali.summer.entity.memo.server.natsu.MixAINatsu;
import com.nali.summer.entity.memo.server.natsu.ServerNatsu;
import com.nali.summer.entity.sound.SoundDaNatsu;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SummerNatsu extends EntityLeInv
{
	public static int eggPrimary = 0xF1F6F9;
	public static int eggSecondary = 0xFB7290;

	public final static DataParameter<Byte>[] BYTE_DATAPARAMETER_ARRAY = new DataParameter[BothDaNatsu.MAX_SYNC];
	public final static DataParameter<Integer>[] INTEGER_DATAPARAMETER_ARRAY = new DataParameter[BothDaNatsu.MAX_FRAME];
	public final static DataParameter<Float>[] FLOAT_DATAPARAMETER_ARRAY = new DataParameter[1];

	static
	{
		for (int i = 0; i < BYTE_DATAPARAMETER_ARRAY.length; ++i)
		{
			BYTE_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerNatsu.class, DataSerializers.BYTE);
		}

		for (int i = 0; i < INTEGER_DATAPARAMETER_ARRAY.length; ++i)
		{
			INTEGER_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerNatsu.class, DataSerializers.VARINT);
		}

		for (int i = 0; i < FLOAT_DATAPARAMETER_ARRAY.length; ++i)
		{
			FLOAT_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerNatsu.class, DataSerializers.FLOAT);
		}
	}

	public SummerNatsu(World world)
	{
		super(world);
	}

	@Override
	public void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.05D);
		this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5.0D);
	}

	@Override
	public byte[] getAI()
	{
		return MixAINatsu.AI_BYTE_ARRAY;
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
		RenderNatsu r = new RenderNatsu(RenderNatsu.ICLIENTDAS, BothDaNatsu.IBOTHDASN);
		ClientNatsu c = new ClientNatsu(this, r, new Inventory(1));
		c.mb = new MixBoxSle(c);
		c.mr = new MixRenderNatsu(c);
		r.c = c;
		this.ibothleinv = c;
	}

	@Override
	public void newS()
	{
		ServerNatsu s = new ServerNatsu(this, new Inventory(1));
		MixAINatsu a = new MixAINatsu(s);
		s.a = a;
		a.init();
		s.initFrame();
		this.ibothleinv = s;
	}

	@Override
	public IBothDaNe getBD()
	{
		return BothDaNatsu.IBOTHDASN;
	}

	@Override
	public Object getSD()
	{
		return SoundDaNatsu.ISOUNDDALE;
	}

//	@Override
//	@SideOnly(Side.CLIENT)
//	public Object createObjectRender()
//	{
//		return new NasuRender(new EntitiesRenderMemory(), this);
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
//		return ClientNasuMemory.IV_INT_ARRAY;
//	}
}

package com.nali.list.entity;

import com.nali.da.IBothDaNe;
import com.nali.list.render.s.RenderMYuzu;
import com.nali.small.entity.EntityLeInv;
import com.nali.small.entity.IMixESoundDa;
import com.nali.small.entity.inv.InvLe;
import com.nali.small.entity.memo.IBothLeInv;
import com.nali.small.entity.memo.client.box.mix.MixBoxSleInv;
import com.nali.summer.da.both.BothDaMYuzu;
import com.nali.summer.entity.memo.client.myuzu.ClientMYuzu;
import com.nali.summer.entity.memo.client.myuzu.MixCIMYuzu;
import com.nali.summer.entity.memo.client.myuzu.MixRenderMYuzu;
import com.nali.summer.entity.memo.server.myuzu.MixSIMYuzu;
import com.nali.summer.entity.memo.server.myuzu.ServerMYuzu;
import com.nali.summer.entity.sound.SoundDaMYuzu;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SummerMYuzu extends EntityLeInv implements IMixESoundDa
{
	public static int eggPrimary = 0xfbdad0;
	public static int eggSecondary = 0xfc6c78;

	public final static DataParameter<Byte>[] BYTE_DATAPARAMETER_ARRAY = new DataParameter[BothDaMYuzu.MAX_SYNC];
	public final static DataParameter<Integer>[] INTEGER_DATAPARAMETER_ARRAY = new DataParameter[BothDaMYuzu.MAX_FRAME];
	public final static DataParameter<Float>[] FLOAT_DATAPARAMETER_ARRAY = new DataParameter[1];

	public IBothLeInv ibothleinv;

	static
	{
		for (int i = 0; i < BYTE_DATAPARAMETER_ARRAY.length; ++i)
		{
			BYTE_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerMYuzu.class, DataSerializers.BYTE);
		}

		for (int i = 0; i < INTEGER_DATAPARAMETER_ARRAY.length; ++i)
		{
			INTEGER_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerMYuzu.class, DataSerializers.VARINT);
		}

		for (int i = 0; i < FLOAT_DATAPARAMETER_ARRAY.length; ++i)
		{
			FLOAT_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerMYuzu.class, DataSerializers.FLOAT);
		}
	}

	public SummerMYuzu(World world)
	{
		super(world);
	}

//	@Override
//	@SideOnly(Side.CLIENT)
//	public void initFakeFrame()
//	{
//		ClientEntitiesMemory cliententitiesmemory = (ClientEntitiesMemory)this.bothentitiesmemory;
//		((SkinningRender)cliententitiesmemory.objectrender).frame_int_array[0] = 110;
//	}

	@Override
	public void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.05D);
		this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(10.0D);
	}

	@Override
	public byte[] getSI()
	{
		return MixSIMYuzu.SI_BYTE_ARRAY;
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
		RenderMYuzu r = new RenderMYuzu(RenderMYuzu.ICLIENTDAS, BothDaMYuzu.IBOTHDASN);
		ClientMYuzu c = new ClientMYuzu(this, r);
		MixCIMYuzu mc = new MixCIMYuzu(c);
		c.mc = mc;
		mc.init();
		c.mb = new MixBoxSleInv(c);
		c.mr = new MixRenderMYuzu(c);
		r.c = c;
		c.ie = new InvLe();
		this.ibothleinv = c;
	}

	@Override
	public void newS()
	{
		ServerMYuzu s = new ServerMYuzu(this);
		MixSIMYuzu ms = new MixSIMYuzu(s);
		s.ms = ms;
		ms.init();
		s.initFrame();
		s.ie = new InvLe();
		this.ibothleinv = s;
	}

	@Override
	public IBothDaNe getBD()
	{
		return BothDaMYuzu.IBOTHDASN;
	}

	@Override
	public Object getSD()
	{
		return SoundDaMYuzu.ISOUNDDALE;
	}

	@Override
	public IBothLeInv getB()
	{
		return this.ibothleinv;
	}

	@SideOnly(Side.CLIENT)
	public static ClientMYuzu getC()
	{
		RenderMYuzu r = new RenderMYuzu(RenderMYuzu.ICLIENTDAS, BothDaMYuzu.IBOTHDASN);
		ClientMYuzu c = new ClientMYuzu(null, r);
		r.c = c;
		c.mr = new MixRenderMYuzu(c);
		return c;
	}
//	@Override
//	@SideOnly(Side.CLIENT)
//	public Object createObjectRender()
//	{
//		return new MYuzuRender(new EntitiesRenderMemory(), this);
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
//		return ClientMYuzuMemory.IV_INT_ARRAY;
//	}
}

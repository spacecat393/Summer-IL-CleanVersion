package com.nali.list.entity;

import com.nali.NaliConfig;
import com.nali.da.IBothDaE;
import com.nali.extra.gui.page.entity.me.PageSI;
import com.nali.extra.gui.page.entity.si.*;
import com.nali.gui.key.KeyEdit;
import com.nali.gui.key.KeySelect;
import com.nali.gui.page.Page;
import com.nali.gui.page.PageEdit;
import com.nali.gui.page.PageSelect;
import com.nali.list.da.BothDaSSHifumi;
import com.nali.list.entity.ci.CIEFrame;
import com.nali.list.entity.ci.CIESound;
import com.nali.list.entity.si.*;
import com.nali.list.render.RenderSSHifumi;
import com.nali.math.M4x4;
import com.nali.math.V4;
import com.nali.small.entity.EntityLe;
import com.nali.small.entity.IMixES;
import com.nali.small.entity.IMixESInv;
import com.nali.small.entity.memo.IBothLe;
import com.nali.small.entity.memo.client.box.mix.MixBoxSle;
import com.nali.small.entity.memo.client.render.mix.MixRenderSle;
import com.nali.small.entity.memo.server.si.SILeLook;
import com.nali.small.entity.memo.server.si.path.SILeFindMove;
import com.nali.small.entity.memo.server.si.path.SILeMineTo;
import com.nali.sound.SoundE;
import com.nali.summer.entity.memo.client.sshifumi.ClientSSHifumi;
import com.nali.summer.entity.memo.client.sshifumi.MixCISSHifumi;
import com.nali.summer.entity.memo.server.sshifumi.MixSISSHifumi;
import com.nali.summer.entity.memo.server.sshifumi.ServerSSHifumi;
import com.nali.system.Time;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.nali.list.data.SummerData.MODEL_STEP;

public class SummerSSHifumi extends EntityLe implements IMixES, IMixESInv
{
	public static int eggPrimary = 0xBE9478;
	public static int eggSecondary = 0xFFF6AE;

	public final static DataParameter<Byte>[] BYTE_DATAPARAMETER_ARRAY = new DataParameter[BothDaSSHifumi.IDA.E_MaxSync()];
//	public final static DataParameter<Integer>[] INTEGER_DATAPARAMETER_ARRAY = new DataParameter[BothDaSSHifumi.IDA.S_MaxFrame()];
//	public final static DataParameter<Float>[] FLOAT_DATAPARAMETER_ARRAY = new DataParameter[1];

	public static byte[] CI_BYTE_ARRAY;
	public static byte[] SI_BYTE_ARRAY;

	public IBothLe ibothle;

	public static int[] IV_INT_ARRAY;
	public static float[] ROTATION_FLOAT_ARRAY = new float[]
	{
		0.0F, 0.0F,
		0.0F, 0.0F
	};
	public static float[] TRANSFORM_FLOAT_ARRAY = new float[]
	{
		0.0F, -0.55F * 0.5F, 0.0F,
		0.0F, -1.0F * 0.5F, 0.01F * 0.5F,
		0.0F, -1.2F * 0.5F, 0.14F * 0.5F,
		0.0F, -1.15F * 0.5F, 0.14F * 0.5F
	};

	static
	{
		for (int i = 0; i < BYTE_DATAPARAMETER_ARRAY.length; ++i)
		{
			BYTE_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerSSHifumi.class, DataSerializers.BYTE);
		}

//		for (int i = 0; i < INTEGER_DATAPARAMETER_ARRAY.length; ++i)
//		{
//			INTEGER_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerSSHifumi.class, DataSerializers.VARINT);
//		}
//
//		for (int i = 0; i < FLOAT_DATAPARAMETER_ARRAY.length; ++i)
//		{
//			FLOAT_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerSSHifumi.class, DataSerializers.FLOAT);
//		}
	}

	public SummerSSHifumi(World world)
	{
		super(world);
	}

	public static void initID()
	{
		CI_BYTE_ARRAY = new byte[]
		{
			CIEFrame.ID,
			CIESound.ID
		};

		SI_BYTE_ARRAY = new byte[]
		{
			SIESound.ID,

			SIEArea.ID,
			SIEOwner.ID,
			SILeEat.ID,

			SIEPat.ID,

			SIELock.ID,
			SILeLockDMG.ID,
			SILeMineTo.ID,
			SIEUseTo.ID,
			SIESit.ID,
			SIELocation.ID,
			SIEFollow.ID,
			SIERevive.ID,
			SIECareOwner.ID,
			SILeAttack.ID,
			SIEManageItem.ID,
			SIEInv.ID,
			SIERandomWalk.ID,
			SIELookTo.ID,
			SIERandomLook.ID,

			SIEKey.ID,

			SILeFindMove.ID,
			//SILeMove.ID,
			SIEWalkTo.ID,
			SILeLook.ID,
			//SILeJump.ID
		};

		IV_INT_ARRAY = new int[]
		{
			/*0+0 + */MODEL_STEP, 9046,
			/*0+0 + */MODEL_STEP, 2581,
			4/*+0*/ + MODEL_STEP, 1275,
			/*0+0 + */MODEL_STEP, 9224,
			/*0+0 + */MODEL_STEP, 7860,
			11/*+0*/ + MODEL_STEP, 39
		};
	}

//	@SideOnly(Side.CLIENT)
//	public static ClientSSHifumi getC()
//	{
//		RenderSSHifumi r = new RenderSSHifumi();
//		ClientSSHifumi c = new ClientSSHifumi(r);
//		r.c = c;
//		c.mr = new MixRenderSSHifumi(c);
//		return c;
//	}

	@SideOnly(Side.CLIENT)
	public static void setGI()
	{
		if (NaliConfig.NEED_EXTRA)
		{
			PageSelect ps;
			PageEdit pe;
			if (PageSI.GI == SIEArea.ID)
			{
				ps = new PageSIEArea();
				Page.PAGE.set(ps, new KeySelect(ps));
			}
			else if (PageSI.GI == SIEInv.ID)
			{
				ps = new PageSIEInv();
				Page.PAGE.set(ps, new KeySelect(ps));
			}
			else if (PageSI.GI == SIEOwner.ID)
			{
				ps = new PageSIEOwner();
				Page.PAGE.set(ps, new KeySelect(ps));
			}
			else if (PageSI.GI == SIELock.ID)
			{
				ps = new PageSIELock();
				Page.PAGE.set(ps, new KeySelect(ps));
			}
			else if (PageSI.GI == SILeAttack.ID)
			{
				ps = new PageSILeAttack();
				Page.PAGE.set(ps, new KeySelect(ps));
			}
			else if (PageSI.GI == SIEFollow.ID)
			{
				ps = new PageSIEFollow();
				Page.PAGE.set(ps, new KeySelect(ps));
			}
			else if (PageSI.GI == SIEWalkTo.ID)
			{
				ps = new PageSIEWalkTo();
				Page.PAGE.set(ps, new KeySelect(ps));
			}
			else if (PageSI.GI == SIERandomWalk.ID)
			{
				ps = new PageSIERandomWalk();
				Page.PAGE.set(ps, new KeySelect(ps));
			}
			else if (PageSI.GI == SIELook.ID)
			{
				pe = new PageSILeLook();
				Page.PAGE.set(pe, new KeyEdit(pe));
			}
			else if (PageSI.GI == SIELookTo.ID)
			{
				ps = new PageSIELookTo();
				Page.PAGE.set(ps, new KeySelect(ps));
			}
			else if (PageSI.GI == SIERandomLook.ID)
			{
				ps = new PageSIERandomLook();
				Page.PAGE.set(ps, new KeySelect(ps));
			}
			else if (PageSI.GI == SIESit.ID)
			{
				ps = new PageSIESit();
				Page.PAGE.set(ps, new KeySelect(ps));
			}
			else if (PageSI.GI == SIECareOwner.ID)
			{
				ps = new PageSIECareOwner();
				Page.PAGE.set(ps, new KeySelect(ps));
			}
			else if (PageSI.GI == SILeLockDMG.ID)
			{
				ps = new PageSILeLockDMG();
				Page.PAGE.set(ps, new KeySelect(ps));
			}
			else if (PageSI.GI == SIELocation.ID)
			{
				pe = new PageSIELocation();
				Page.PAGE.set(pe, new KeyEdit(pe));
			}
			else if (PageSI.GI == SIEUseTo.ID)
			{
				ps = new PageSIEUseTo();
				Page.PAGE.set(ps, new KeySelect(ps));
			}
			else if (PageSI.GI == SIESound.ID)
			{
				ps = new PageSIESound();
				Page.PAGE.set(ps, new KeySelect(ps));
			}
			else
			{
				ps = new PageSIN();
				Page.PAGE.set(ps, new KeySelect(ps));
			}
		}
	}
//	@Override
//	@SideOnly(Side.CLIENT)
//	public void initFakeFrame()
//	{
//		ClientEntitiesMemory cliententitiesmemory = (ClientEntitiesMemory)this.bothentitiesmemory;
//		((SkinningRender)cliententitiesmemory.objectrender).frame_int_array[0] = 379;
//	}

	@Override
	public void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100.0D);
		//this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.05D);
		this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(40.0D);
	}

	@Override
	public byte[] getCI()
	{
		return CI_BYTE_ARRAY;
	}

	@Override
	public byte[] getSI()
	{
		return SI_BYTE_ARRAY;
	}

	@Override
	public DataParameter<Byte>[] getByteDataParameterArray()
	{
		return BYTE_DATAPARAMETER_ARRAY;
	}

//	@Override
//	public DataParameter<Integer>[] getIntegerDataParameterArray()
//	{
//		return INTEGER_DATAPARAMETER_ARRAY;
//	}
//
//	@Override
//	public DataParameter<Float>[] getFloatDataParameterArray()
//	{
//		return FLOAT_DATAPARAMETER_ARRAY;
//	}

	@SideOnly(Side.CLIENT)
	@Override
	public void newC()
	{
		RenderSSHifumi r = new RenderSSHifumi();
		ClientSSHifumi c = new ClientSSHifumi(this, r, new SoundE());
		MixCISSHifumi mc = new MixCISSHifumi(c);
		c.mc = mc;
		c.mb = new MixBoxSle(c);
//		c.mr = new MixRenderSSHifumi(c);
		MixRenderSle mr = new MixRenderSle(c);
		mr.shadow_opaque = 0.5F;
		mr.shadow_size = 0.25F;
		c.mr = mr;
		r.c = c;
		this.ibothle = c;
	}

	@Override
	public void newS()
	{
		ServerSSHifumi s = new ServerSSHifumi(this);
		MixSISSHifumi ms = new MixSISSHifumi(s);
		s.ms = ms;
		ms.init();
		s.initKey();
		s.init();
		this.ibothle = s;
	}

	@Override
	public IBothDaE getBD()
	{
		return BothDaSSHifumi.IDA;
	}

	@Override
	public IBothLe getB()
	{
		return this.ibothle;
	}
//	@Override
//	@SideOnly(Side.CLIENT)
//	public Object createObjectRender()
//	{
//		return new SSHimiRender(new EntitiesRenderMemory(), this);
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
//		return ClientSSHimiMemory.IV_INT_ARRAY;
//	}

	@Override
	public int[] getIVIntArray()
	{
		return IV_INT_ARRAY;
	}

	@Override
	public float[] getRotationFloatArray()
	{
		return ROTATION_FLOAT_ARRAY;
	}

	@Override
	public float[] getTransformFloatArray()
	{
		return TRANSFORM_FLOAT_ARRAY;
	}

	@Override
	public void mulFrame(float[] skinning_float_array, short[] key_short_array)
	{
		float
			body_rot,
			head_rot,
			head_pitch;

		if (this.world.isRemote)
		{
			this.prev_rotation_yaw_body += (this.rotation_yaw_body - this.prev_rotation_yaw_body) * (float)Time.LINE;
			this.prev_rotation_yaw += (this.rotationYaw - this.prev_rotation_yaw) * (float)Time.LINE;
			this.prev_rotation_pitch += (this.rotationPitch - this.prev_rotation_pitch) * (float)Time.LINE;
			body_rot = (float)Math.toRadians(this.prev_rotation_yaw_body);
			head_rot = (float)Math.toRadians(this.prev_rotation_yaw);
			head_pitch = (float)Math.toRadians(this.prev_rotation_pitch);
		}
		else
		{
			body_rot = (float)Math.toRadians(this.rotation_yaw_body);
			head_rot = (float)Math.toRadians(this.rotationYaw);
			head_pitch = (float)Math.toRadians(this.rotationPitch);
		}

		float net_head_yaw = head_rot - body_rot;

		if (head_pitch > 1.04719755119659774615F)
		{
			head_pitch = 1.04719755119659774615F;
		}
		else if (head_pitch < -1.04719755119659774615F)
		{
			head_pitch = -1.04719755119659774615F;
		}
//		float body_rot = head_rot;
//		float net_head_yaw = head_rot - body_rot;

		V4.q(V4.TV4_FLOAT_ARRAY, 0.0F, 0.0F, body_rot);
		float[] body_m4x4 = V4.getM4X4(V4.TV4_FLOAT_ARRAY);

		if (key_short_array[0] < 575)
		{
			V4.q(V4.TV4_FLOAT_ARRAY, 0, 0, net_head_yaw);
			float[] head_m4x4 = V4.getM4X4(V4.TV4_FLOAT_ARRAY);

			M4x4.m(head_m4x4, skinning_float_array, 0, 16 * 16);
		}
		else
		{
			V4.q(V4.TV4_FLOAT_ARRAY, -head_pitch, 0, net_head_yaw);
			float[] head_m4x4 = V4.getM4X4(V4.TV4_FLOAT_ARRAY);

			M4x4.m(head_m4x4, skinning_float_array, 0, 74 * 16);
		}

		M4x4.m(body_m4x4, skinning_float_array, 0, 0);
	}
}

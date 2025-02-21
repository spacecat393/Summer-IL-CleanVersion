package com.nali.summer.entity.memo.server.sshifumi;

import com.nali.da.IBothDaE;
import com.nali.da.IBothDaNe;
import com.nali.list.entity.ci.CIESound;
import com.nali.list.network.message.ClientMessage;
import com.nali.network.NetworkRegistry;
import com.nali.small.entity.EntityLe;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.memo.server.IServerS;
import com.nali.small.entity.memo.server.ServerLe;
import com.nali.small.entity.memo.server.si.MixSIE;
import com.nali.small.entity.memo.server.si.frame.KeyS;
import com.nali.small.entity.memo.server.si.frame.floop.KeySFLoopSit;
import com.nali.small.entity.memo.server.si.frame.floop.KeySleFLoopDie;
import com.nali.small.entity.memo.server.si.frame.floopfree.KeySFLoopFreeHardReady;
import com.nali.small.entity.memo.server.si.frame.floopfree.KeySFLoopFreeSoftReady;
import com.nali.small.entity.memo.server.si.frame.floopfree.KeySleFLoopFreePE;
import com.nali.small.entity.memo.server.si.frame.floopoffset.KeySleFLoopOffSetAttackEndWalk;
import com.nali.small.entity.memo.server.si.frame.shoot.KeySleShoot;
import com.nali.small.entity.memo.server.si.frame.tloop.KeySTLoop;
import com.nali.small.entity.memo.server.si.frame.tloop.KeySleTLoopAttackStand;
import com.nali.small.entity.memo.server.si.frame.tloop.KeySleTLoopAttackWalk;
import com.nali.small.entity.memo.server.si.frame.tloop.KeySleTLoopWalk;
import com.nali.system.bytes.ByteWriter;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;

public class ServerSSHifumi
<
	BD extends IBothDaE & IBothDaNe,
	E extends EntityLe,
	I extends IMixE<BD, E>,
	MS extends MixSIE<BD, E, I, ?>
> extends ServerLe<BD, E, I, MS> implements IServerS
{
	public static short[] FIX_KEY_SHORT_ARRAY = new short[]
	{
		482, 523,//Tank_Vital_Destroy*
		450, 481,//Tank_Vital_Retreat*
		118, 133,//Attack_Start*
		340, 389,//Tank_Move_Ing*
		390, 449,//Tank_Move_End*
		699, 732,//Cafe_Walk*
		616, 698,//Cafe_Reaction*
		0, 66,//Tank_Appearance*
		733, 783,//Tactical_Start*
		67, 117,//Attack_Delay*
		575, 615,//Cafe_Idle*
		134, 167,//Attack_Ing*
		168, 184,//Attack_End*
		289, 339//Normal_Reload*
	};
	public static byte[] KEY_DATA_BYTE_ARRAY = new byte[]
	{
		0, 0*2,
		0, 1*2,
		0, 3*2, 4*2,
		0, 2*2, 11*2, 12*2, 13*2,
		0, 3*2,
		0, 5*2,
		0, 6*2,
		0, 7*2,
		0, 8*2,
		0, 9*2,
		0, 10*2
	};
	public KeyS[][] keys_2d_array;

	public ServerSSHifumi(I i)
	{
		super(i);
	}

	@Override
	public void init()
	{
		super.init();
		this.sileinv.itemstack_array = new ItemStack[4*9];
	}

	@Override
	public void initKey()
	{
		this.keys_2d_array = new KeyS[][]
		{
			{
				new KeySleFLoopDie(this, (byte)0),
//				new KeySTLoopFBSit(this, (byte)2),
				new KeySFLoopSit(this, (byte)2),
				new KeySleFLoopOffSetAttackEndWalk(this, (byte)4),
				new KeySleShoot(this, (byte)7),
				new KeySleTLoopAttackWalk(this, (byte)12),
				new KeySleTLoopWalk(this, (byte)14),
				new KeySleFLoopFreePE(this, (byte)16),
				new KeySFLoopFreeHardReady(this, (byte)18),
				new KeySFLoopFreeSoftReady(this, (byte)20),
				new KeySleTLoopAttackStand(this, (byte)22),
				new KeySTLoop(this, (byte)24)
			}
		};
//		() -> this.isZeroMove() && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoop(0),
//		() -> (serverentitiesmemory.current_work_byte_array[workbytes.SIT() / 8] >> workbytes.SIT() % 8 & 1) == 1 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoopFB(1),
//		() -> (serverentitiesmemory.main_work_byte_array[workbytes.ATTACK() / 8] >> workbytes.ATTACK() % 8 & 1) == 1 && this.moveForward == 0 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopOffSet(3, 4),
//		() -> serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setShoot(2, 11, 12, 13, false, serverentitiesmemory.entitiesaimemory.skinningentitiesattack),
//		() -> (serverentitiesmemory.main_work_byte_array[workbytes.ATTACK() / 8] >> workbytes.ATTACK() % 8 & 1) == 1 && this.moveForward != 0 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(3),
//		() -> this.moveForward != 0 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(5),
//		() -> ((serverentitiesmemory.statentitiesmemory.stat & 1) == 1 || (serverentitiesmemory.statentitiesmemory.stat & 8) == 8) && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopFree(6, (byte)(1 + 8)),
//		() -> (serverentitiesmemory.statentitiesmemory.stat & 4) == 4 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopFree(7, (byte)4),
//		() -> (serverentitiesmemory.statentitiesmemory.stat & 2) == 2 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopFree(8, (byte)2),
//		() -> (serverentitiesmemory.main_work_byte_array[workbytes.ATTACK() / 8] >> workbytes.ATTACK() % 8 & 1) == 1 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoop(9),
//		() -> serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(10)
	}

	@Override
	public void updateServer()
	{

	}

	@Override
	public KeyS[][] getKeyS2DArray()
	{
		return this.keys_2d_array;
	}

	@Override
	public byte[] getKeyDataByteArray()
	{
		return KEY_DATA_BYTE_ARRAY;
	}

	@Override
	public short[] getFixKeyShortArray()
	{
		return FIX_KEY_SHORT_ARRAY;
	}

	@Override
	public void getHurtSound(DamageSource damagesource)
	{
		byte[] byte_array = new byte[1 + 8 + 1 + 4];
		this.setCCI(byte_array, CIESound.ID);
		ByteWriter.set(byte_array, this.i.getBD().Ne_HURT(), 1 + 8 + 1);
		NetworkRegistry.I.sendToAll(new ClientMessage(byte_array));
	}

	@Override
	public void getDeathSound()
	{
		byte[] byte_array = new byte[1 + 8 + 1 + 4];
		this.setCCI(byte_array, CIESound.ID);
		ByteWriter.set(byte_array, this.i.getBD().Ne_DEATH(), 1 + 8 + 1);
		NetworkRegistry.I.sendToAll(new ClientMessage(byte_array));
	}
}

package com.nali.summer.entity.memo.server.saori;

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
import com.nali.small.entity.memo.server.si.frame.floop.KeySleFLoopDie;
import com.nali.small.entity.memo.server.si.frame.floopfree.KeySFLoopFreeHardReady;
import com.nali.small.entity.memo.server.si.frame.floopfree.KeySleFLoopFreePSrE;
import com.nali.small.entity.memo.server.si.frame.floopoffset.KeySleFLoopOffSetAttackEndWalk;
import com.nali.small.entity.memo.server.si.frame.shoot.KeySleShootAttackPlus;
import com.nali.small.entity.memo.server.si.frame.tloop.*;
import com.nali.system.bytes.ByteWriter;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;

public class ServerSaori
<
	BD extends IBothDaE & IBothDaNe,
	E extends EntityLe,
	I extends IMixE<BD, E>,
	MS extends MixSIE<BD, E, I, ?>
> extends ServerLe<BD, E, I, MS> implements IServerS
{
	public static short[] FIX_KEY_SHORT_ARRAY = new short[]
	{
		890, 942,
		492, 592,
		688, 704,//2 start attack
		593, 608,
		609, 646,
		358, 491,
		943, 979,
		241, 357,
		647, 687,
		0, 240,
		705, 723,//10 loop attack
		724, 742,//11 end attack
		743, 788,//12 reload
		789, 889//13 skill
	//			{ 980, 1013 }//delay attack
	};
	public static byte[] KEY_DATA_BYTE_ARRAY = new byte[]
	{
		0, 0*2, //0
		0, 1*2, //2
		0, 3*2, 4*2, //4
		0, 2, 2*2, 10*2, 13*2, 11*2, 12*2, //7 frameId size startAttack (loop skill) end reload
		0, 3*2, //14
		0, 5*2, //16
		0, 6*2, //18
		0, 7*2, //20
		0, 8*2, //22
		0, 9*2 //24
	};
	public KeyS[][] keys_2d_array;

	//	public boolean server_how_attack;
	public ServerSaori(I i)
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
				new KeySTLoopSit(this, (byte)2),
				new KeySleFLoopOffSetAttackEndWalk(this, (byte)4),
				new KeySleShootAttackPlus(this, (byte)7),
				new KeySleTLoopAttackWalk(this, (byte)14),
				new KeySleTLoopWalk(this, (byte)16),
				new KeySFLoopFreeHardReady(this, (byte)18),
				new KeySleFLoopFreePSrE(this, (byte)20),
				new KeySleTLoopAttackStand(this, (byte)22),
				new KeySTLoop(this, (byte)24)
			}
		};
//		() -> this.isZeroMove() && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoop(0),
//		() -> (serverentitiesmemory.current_work_byte_array[workbytes.SIT() / 8] >> workbytes.SIT() % 8 & 1) == 1 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(1),
//		() -> (serverentitiesmemory.main_work_byte_array[workbytes.ATTACK() / 8] >> workbytes.ATTACK() % 8 & 1) == 1 && this.moveForward == 0 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopOffSet(3, 4),
//		() ->
//		{
//			int id = 10;
//			int start_id = 2;
//
//			if (serverentitiesmemory.server_how_attack)
//			{
//				id = 13;
//				start_id = 13;
//
//				if (serverentitiesmemory.frame_int_array[serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].integer_index] == serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].int_2d_array[id][1] - 1)
//				{
//					start_id = 2;
//					id = 10;
//					serverentitiesmemory.frame_int_array[serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].integer_index] = serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].int_2d_array[2][0];
//					serverentitiesmemory.server_how_attack = false;
//				}
//			}
//
//			if (serverentitiesmemory.frame_int_array[serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].integer_index] == serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].int_2d_array[id][1] - 1)
//			{
//				serverentitiesmemory.server_how_attack = (byte)(this.ticksExisted % 20) == 0;
//			}
//
//			return serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setShoot(start_id, id, 11, 12, false, serverentitiesmemory.entitiesaimemory.skinningentitiesattack);
//		},
//		() -> (serverentitiesmemory.main_work_byte_array[workbytes.ATTACK() / 8] >> workbytes.ATTACK() % 8 & 1) == 1 && this.moveForward != 0 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(3),
//		() -> this.moveForward != 0 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(5),
//		() -> (serverentitiesmemory.statentitiesmemory.stat & 4) == 4 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopFree(6, (byte)4),
//		() -> ((serverentitiesmemory.statentitiesmemory.stat & 1) == 1 || (serverentitiesmemory.statentitiesmemory.stat & 2) == 2 || (serverentitiesmemory.statentitiesmemory.stat & 8) == 8) && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopFree(7, (byte)(1 + 2 + 8)),
//		() -> (serverentitiesmemory.main_work_byte_array[workbytes.ATTACK() / 8] >> workbytes.ATTACK() % 8 & 1) == 1 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(8),
//		() -> serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(9)
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

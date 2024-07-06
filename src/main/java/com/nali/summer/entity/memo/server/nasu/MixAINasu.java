package com.nali.summer.entity.memo.server.nasu;

import com.nali.small.entity.EntityLeInv;
import com.nali.small.entity.IMixLe;
import com.nali.small.entity.memo.server.ServerSleInv;
import com.nali.small.entity.memo.server.ai.MixAIEInv;
import com.nali.sound.ISoundLe;
import com.nali.summer.da.both.BothDaNasu;

public class MixAINasu<SD extends ISoundLe, BD extends BothDaNasu<SD>, E extends EntityLeInv, I extends IMixLe<SD, BD, E>, S extends ServerSleInv<SD, BD, E, I, ?>> extends MixAIEInv<SD, BD, E, I, S>
{
}

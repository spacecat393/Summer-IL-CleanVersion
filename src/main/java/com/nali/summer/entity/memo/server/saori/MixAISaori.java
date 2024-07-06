package com.nali.summer.entity.memo.server.saori;

import com.nali.small.entity.EntityLeInv;
import com.nali.small.entity.IMixLe;
import com.nali.small.entity.memo.server.ServerSleInv;
import com.nali.small.entity.memo.server.ai.MixAIEInv;
import com.nali.sound.ISoundLe;
import com.nali.summer.da.both.BothDaSaori;

public class MixAISaori<SD extends ISoundLe, BD extends BothDaSaori<SD>, E extends EntityLeInv, I extends IMixLe<SD, BD, E>, S extends ServerSleInv<SD, BD, E, I, ?>> extends MixAIEInv<SD, BD, E, I, S>
{
}

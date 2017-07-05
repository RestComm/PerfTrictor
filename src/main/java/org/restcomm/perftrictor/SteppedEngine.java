package org.restcomm.perftrictor;

import org.restcomm.perftrictor.smpp.AbstractScenario;

public class SteppedEngine extends AbstractScenario {

    @Override
    public void createDialog(GlobalContext ctx) throws Exception {
        ScenarioContext sCtx = new ScenarioContext(ctx);
        sCtx.fsm.start(sCtx);
    }

}

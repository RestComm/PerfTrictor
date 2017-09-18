package org.restcomm.perftrictor;

import java.util.concurrent.TimeUnit;
import org.squirrelframework.foundation.fsm.Action;

public class GenerateTrafficAction implements Action<GlobalFSM, GlobalState, GlobalEvent, GlobalContext> {

    private static long NANOS_IN_SEC = 1000000000;
    @Override
    public void execute(GlobalState s, GlobalState s1, GlobalEvent e, GlobalContext ctx, GlobalFSM t) {
        if (ctx.trafficFuture != null) {
            ctx.trafficFuture.cancel(false);
        }
        long rate = NANOS_IN_SEC / ctx.getIntegerProp("smppp.caps");
        ctx.logger.info("starting traffic with rate:" + rate);
        ctx.trafficFuture = ctx.executor.scheduleAtFixedRate(new TrafficTask(ctx), 0,
                rate, TimeUnit.NANOSECONDS);       
    }

    @Override
    public String name() {
        return "GenerateTrafficAction";
    }

    @Override
    public int weight() {
        return 0;
    }

    @Override
    public boolean isAsync() {
        return false;
    }

    @Override
    public long timeout() {
        return 0;
    }


}

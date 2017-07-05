package org.restcomm.perftrictor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScenarioContext {
    public GlobalContext globalContext;
    public Map<String, Object> data = new HashMap();
    public int currentStep = -1;

    public ScenarioFSM fsm;

    public ScenarioContext(GlobalContext gContext) {
        this.globalContext = gContext;
        fsm = ScenarioFSM.createNewInstance(this);
        List sessionList = (List) globalContext.data.get("SMPPSessionList");
        CyclicCounter sessionCounter = (CyclicCounter) gContext.data.get("sessionCounter");     
        int cyclicallyIncrementAndGet = sessionCounter.cyclicallyIncrementAndGet();
        data.put("SmppSession",sessionList.get(cyclicallyIncrementAndGet));
    }

    public GlobalContext getGlobalContext() {
        return globalContext;
    }

    public Map<String, Object> getData() {
        return data;
    }
    
    
    
    
}

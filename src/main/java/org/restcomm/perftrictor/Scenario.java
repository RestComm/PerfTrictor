package org.restcomm.perftrictor;

public interface Scenario {
    void init(GlobalContext ctx);
    void createDialog(GlobalContext ctx) throws Exception ;
}

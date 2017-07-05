package org.restcomm.perftrictor;


public interface StackInitializer  {
    String getStackProtocol();
    void init(GlobalContext ctx) throws Exception;
    void stop(GlobalContext ctx) throws Exception;
}

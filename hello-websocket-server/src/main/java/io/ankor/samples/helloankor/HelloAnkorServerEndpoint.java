package io.ankor.samples.helloankor;

import at.irian.ankor.application.Application;
import at.irian.ankor.system.WebSocketServerEndpoint;

public class HelloAnkorServerEndpoint extends WebSocketServerEndpoint {
    @Override
    protected Application createApplication() {
        return new HelloAnkorApplication();
    }


    @Override
    protected String getPath() {
        return "/websocket/ankor/{clientId}";
    }
}


package io.ankor.samples.tryankor;

import at.irian.ankor.application.Application;
import at.irian.ankor.system.WebSocketServerEndpoint;

public class TryAnkorServerEndpoint extends WebSocketServerEndpoint {
    @Override
    protected Application createApplication() {
        return new TryAnkorApplication();
    }


    @Override
    protected String getPath() {
        return "/websocket/ankor/{clientId}";
    }
}


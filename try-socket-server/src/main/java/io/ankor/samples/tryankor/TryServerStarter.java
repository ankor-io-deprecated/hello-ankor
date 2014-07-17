package io.ankor.samples.tryankor;

import at.irian.ankor.system.SocketStandaloneServer;

public class TryServerStarter {
    public static void main(String[] args) {
        new SocketStandaloneServer(new TryAnkorApplication()).start();
    }
}

package io.ankor.samples.helloankor;

import at.irian.ankor.system.SocketStandaloneServer;

public class HelloServerStarter {
    public static void main(String[] args) {
        new SocketStandaloneServer(new HelloAnkorApplication()).start();
    }
}

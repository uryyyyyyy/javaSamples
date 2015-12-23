package com.github.uryyyyyyy.javaSamples.akka.args;

import akka.actor.UntypedActor;

public class EchoActor extends UntypedActor {
	public EchoActor(String hello, int i) {
		System.out.println("constructor");
        System.out.println(hello);
        System.out.println(i);
	}

	@Override
	public void onReceive(Object message) throws Exception {
		if (message instanceof String) {
			System.out.println("Got message. " + message);
			getSender().tell(message, getSender());
		} else {
			System.out.println("Got unknown type message.");
			unhandled(message);
		}
	}
}

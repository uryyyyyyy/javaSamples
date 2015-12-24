package com.github.uryyyyyyy.javaSamples.akka.router;

import akka.actor.UntypedActor;

public class EchoActor extends UntypedActor {
	public EchoActor() {
		System.out.println("constructor");
	}

	@Override
	public void onReceive(Object message) throws Exception {
		if (message instanceof String) {
			System.out.println("Got message. " + message);
			Thread.sleep(1000);
		} else {
			System.out.println("Got unknown type message.");
			unhandled(message);
		}
	}
}

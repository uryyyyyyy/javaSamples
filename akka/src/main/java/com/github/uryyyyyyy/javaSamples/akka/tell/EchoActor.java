package com.github.uryyyyyyy.javaSamples.akka.tell;

import akka.actor.UntypedActor;

public class EchoActor extends UntypedActor {
	public EchoActor() {
		System.out.println("constructor");
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

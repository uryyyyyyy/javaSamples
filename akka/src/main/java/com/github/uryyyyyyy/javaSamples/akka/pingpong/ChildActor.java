package com.github.uryyyyyyy.javaSamples.akka.pingpong;

import akka.actor.UntypedActor;

public class ChildActor extends UntypedActor {

	@Override
	public void onReceive(Object message) throws Exception {
		if (message instanceof String) {
			System.out.println("pong received: " + message);
			getSender().tell(message, getSender());
		} else {
			System.out.println("Got unknown type message.");
			unhandled(message);
		}
	}
}

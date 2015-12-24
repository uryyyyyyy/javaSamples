package com.github.uryyyyyyy.javaSamples.akka.pingpong;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;

public class ParentActor extends UntypedActor {

	ActorRef echoActorRef = null;

	@Override
	public void onReceive(Object message) throws Exception {
		if (message instanceof String) {
			System.out.println("ping received. " + message);
			System.out.println("ping. unknown object");
			echoActorRef.tell(new Object(), getSelf());
		} else if (message instanceof Long) {
			System.out.println("start ping. " + message);
			echoActorRef = getContext().actorOf(Props.create(ChildActor.class), "childActor");
			echoActorRef.tell(String.valueOf(message), getSelf());
		} else {
			System.out.println("Got unknown type message.");
			unhandled(message);
		}
	}
}

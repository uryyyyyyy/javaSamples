package com.github.uryyyyyyy.javaSamples.akka.pingpong;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		ActorSystem system = ActorSystem.create("EchoSystem");
		ActorRef echoActorRef = system.actorOf(Props.create(ParentActor.class), "EchoActor");
		echoActorRef.tell(10L, ActorRef.noSender());
		Thread.sleep(1000);
		system.stop(echoActorRef);
		system.shutdown();
	}
}

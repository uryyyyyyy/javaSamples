package com.github.uryyyyyyy.javaSamples.akka.router;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.routing.RoundRobinPool;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		ActorSystem system = ActorSystem.create("EchoSystem");

		ActorRef echoActorRef = system.actorOf(new RoundRobinPool(2).props(Props.create(EchoActor.class)));
		echoActorRef.tell("ha", ActorRef.noSender());
		echoActorRef.tell("ha", ActorRef.noSender());
		echoActorRef.tell("ha", ActorRef.noSender());
		echoActorRef.tell("ha", ActorRef.noSender());
		echoActorRef.tell("ha", ActorRef.noSender());
		Thread.sleep(5000);
		system.stop(echoActorRef);
		system.shutdown();
	}
}

package remote

import akka.actor._
import common._

object HelloRemote extends App  {
  val system = ActorSystem("HelloRemoteSystem")
  val remoteActor = system.actorOf(Props[RemoteActor], name = "RemoteActor")
  remoteActor ! Message("The RemoteActor is alive")
}

class RemoteActor extends Actor {
  def receive = {
    case Message(msg) =>
        println(s"RemoteActor received message '$msg'")
        sender ! Message("Hello from the RemoteActor")
    case _ => 
        println("RemoteActor got something unexpected.")

  }
}



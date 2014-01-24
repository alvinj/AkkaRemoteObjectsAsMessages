Akka Remote Example #2: Sending Objects as Messages
===================================================

This example adds one level of difficulty to my original
Akka Remote "Hello, world" example. Where the original example
sent `String` messages between the Local and Remote actors, this
example encapsulates its messages in two simple objects:

1. `Message`
1. `Start`

The differences between this example and the original example are:

1. This code includes a _Common_ project that contains the `Message`
   and `Start` class definitions.
1. The _HelloLocal_ and _HelloRemote_ projects depend on the _Common_ project
   and will automatically include its classes.
1. The actor code in the _HelloLocal_ and _HelloRemote_ projects sends
   messages using the `Message` and `Start` classes. (Technically, `Start`
   is a case object, and `Message` is a case class.)

Assumptions
-----------

For the purposes of this code, I assume you know the following:

1. Scala
1. SBT (the Simple Build Tool)
1. How to use Akka actors within one JVM (i.e., the actor basics)
1. You've run my original Akka Remote "Hello, world" example

Running the Code
----------------

Follow these steps to run the code:

1. Open two(!) terminal windows, `cd` into the project root in both of them
1. Type `sbt remote/run` in one window to start the remote actor system
1. Type `sbt local/run` in the other window to start the local actor system

When the local actor system starts, it will send an initial message
to the remote actor system. The remote actor will send a reply through
its `sender` reference, and this will continue five times. When the
action stops, stop each system by pressing Ctrl-C.

Problems?
---------

If you're having any problems with this code, edit the _application.conf_
file in the _src/main/resources_ directory of each project, and remove the
comments from the debug-related lines.

More Information
----------------

For more information on this project, see the following URL:

http://alvinalexander.com/scala/akka-remote-sending-objects-messages

For information on my original Akka Remote "Hello, world" example,
see this URL:

http://alvinalexander.com/scala/simple-akka-actors-remote-example

You can find me at:

http://alvinalexander.com



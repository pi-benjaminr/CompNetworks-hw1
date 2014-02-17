CompNetworks-hw1
================

The Benchmark client assumes the two servers are already running. It then runs the main method of SimpleClient
some number of times (the constant NUM), for each of the two servers. Both trials are timed, and the times are
then printed. This compares the time it takes to serve an equal number of clients on each server.

For NUM = 10,000 I got the following results:
SimpleServer took 0.07318 seconds.
MTServer took 0.035243 seconds.
The multithreaded server was more than twice as efficient as the single threaded server. For much larger values
of NUM, the difference became much less siginificant. My guess is that this has to do with the Java's threads-
running too many on a limited number of processors (like the two/four in your average laptop) loses its advantage.

In any case, for smaller (less than 1 million) values of NUM, the Benchmarking performed as expected, showing the
Multi Threaded solution was far superior to the Single Threaded solution. This is because multiple clients could
be served simultaneously. The single threaded server has to completely finish with one client before it can move
on to the next. The multi threaded server only has to accept the socket and start its WorkerThread, and then can
receive the next client.

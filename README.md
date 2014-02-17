CompNetworks-hw1
================

The Benchmark client assumes the two servers are already running. It then spawns NUM threads, each of which simply runs the main method of SimpleClient. This causes NUM connections to be sent, almost simultaneously, to the server. The Benchmark client then waits for the last of the threads to finish. Both trials are timed, and the times are
then printed. This compares the time it takes to serve an equal number of clients on each server.

For NUM = 1,000,000 I got the following results:
SimpleServer took 1.057921472 seconds.
MTServer took 0.938224769 seconds.
The multithreaded server was more than twice as efficient as the single threaded server. The Benchmarking performed
as expected, showing the Multi Threaded solution was far superior to the Single Threaded solution. This is because
multiple clients could be served simultaneously. The single threaded server has to completely finish with one client
before it can move on to the next. The multi threaded server only has to accept the socket and start its WorkerThread,
and then can receive the next client.

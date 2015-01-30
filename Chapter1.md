## Overview Threading in Clojure

### Abstract

Clojure is known for having good constructs for easily managing multiple threads and not have threads clobber each other to cause race conditions.
Clojure accomplishes this by not having threads modify data, but instead create an identity to represent data's state at any point in time.

This workshop will get your feet wet with solving a simple concurrency problem the Clojure way.

### Goals

* Learn why multithreaded programming is important as well as the difference between parallelism and concurrency.
* How Clojure solves common multithreading problems like race conditions.
* Several design patterns for solving a simple problem using multiple threads.
** Futures and Delays
** Promises
** Atoms
** Agents
** Vars
** Refs

### Requirements

* java 1.7+
* lein 2.5+
* git 2.1+

## Bass Tacks

Multithreaded programming is a way for us to write more preformat applications by providing simultaneous execution of programs.  Some examples include handling multiple connection requests and collecting and digesting big data. Today we will be solving the problem of simultaneous withdrawls from a checking account.

Machines are very powerful, but they are not becoming a powerful as quickly as they used to. CPU clock speeds have barely increased in recent years and there are more dual core and quad core computers. This means in order to make a program near twice as fast, you have to divide up work between the two cores. Enter multithreaded programming!

   *Concurrency versus Parallelism* _Concurrency_ refers to managing more than one job at the same time. An example of this would be using one hand to juggle multiple balls. _Parallelism_ is executing two jobs at the same time. For example, instead of juggling with one hand you can use both. So now when you juggle each hand can simultaneous try to catch or throw a ball at the same time.

Learning how to write multithreaded programs is tricky. In fact, it is Run DMC Tricky. In the JRuby community there are four rules you need to follow before writing them:

   In general, the safest path to concurrency in JRuby is the same as on any other platform:
   1. Don't do it.
   2. If you must do it, don't share data across threads.
   3. If you must share data across threads, don't share mutable data.
   4. If you must share mutable data across threads, synchronize access to that data.

3 and 4 talk about something called mutable data. Quite frankly, mutable data is just as it sounds. It's data that you can change. Mutable data is dangerous when it is used between multiple threads because if you have more than one thread reading and changing data, it can potentially put it in an inconsistent state that causes something called _RACE CONDITIONS_.

   *Race Condition* A race condition occurs when two or more threads can access shared data and they try to change it at the same time. Because the thread scheduling algorithm can swap between threads at any time, you don't know the order in which the threads will attempt to access the shared data.

Clojure inherently allows us to protect ourselves from this right off the bat. See how easy Clojure makes this for you? Clojure loves you! We'll see more proof for this later.
package net.java.examples.generics.writingGenericClasses.example3.exceptionsAndGenerics;

// NOTE: The first example here shows that we can extend Throwable
// ... well obviously! 

public class CantGenericallyExtendThrowable extends Throwable {
	private static final long serialVersionUID = 1L;
}

// NOTE: However if we uncomment out the code below it fails compilation
// because we cannot generically extend Throwable. Usual erasure reasons
// apply, i.e. no runtime info of generics therefore how do we know what
// we've caught?!

// class ReallyCantGenericallyExtendThrowable<T> extends Throwable {
// T someVariable;
// private static final long serialVersionUID = 1L;
// }

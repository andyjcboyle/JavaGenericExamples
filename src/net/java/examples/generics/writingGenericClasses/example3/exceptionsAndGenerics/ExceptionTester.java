package net.java.examples.generics.writingGenericClasses.example3.exceptionsAndGenerics;

public class ExceptionTester<T extends Throwable> {
	public void test(T exception) throws T {
		throw exception;
	}

	public static void main(String... args) {
	}
}

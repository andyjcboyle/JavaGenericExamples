package net.java.examples.generics.writingGenericClasses.example3.exceptionsAndGenerics;

public class ExceptionTester<T extends Throwable> {
	public void test(T exception) throws T {
		throw exception;
	}

	public static void main(String... args) {
		// NOTE: Compiler still aware of checked exception, as usual i.e.
		// try,catch needed etc
		try {
			new ExceptionTester<ClassNotFoundException>()
					.test(new ClassNotFoundException());
		} catch (Throwable e) {
			System.out.println("Got our exception");
			e.printStackTrace();
		}

		// NOTE: and as expected runtime exception doesn't need try,catch
		new ExceptionTester<NullPointerException>()
				.test(new NullPointerException());
	}
}

package net.java.examples.generics.writingGenericClasses.example4.parameterTypeLimitations;

public class CreateGenericInstanceWithClass<T> {
	
	public void showCannotInstantiateUsingTypeVariable() {
//		T myVar = new T(); // Doesn't compile
	}
	
	// NOTE: The thing to note is that we want to tie 'type' to T
	// the use of raw 'Class' means putting the burden on the user
	// i.e. test1 in no way does this
	public void testInstantiateRawClassType(Class type)  {
		try {
			Object object = type.newInstance();
			System.out.println("Just created a " + object.getClass().getSimpleName());
		} catch (Exception ignore) {
		}
	}
	
	// NOTE: We solve this because 'Class' itself is generified
	public void testInstantiateGenericClassType(Class<T> type) {
		try {
			Object object = type.newInstance();
			System.out.println("Just created a " + object.getClass().getSimpleName());
		} catch (Exception ignore) {
		}
	}
}

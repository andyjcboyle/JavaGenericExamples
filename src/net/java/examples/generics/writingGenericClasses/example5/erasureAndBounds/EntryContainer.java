package net.java.examples.generics.writingGenericClasses.example5.erasureAndBounds;

public class EntryContainer<E extends Entry & Listable & Cacheable> {
	public void someMethod(E anEntry) {}
}

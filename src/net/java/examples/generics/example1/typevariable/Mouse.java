package net.java.examples.generics.example1.typevariable;

public class Mouse {
	private String name;

	public Mouse(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return new String("I'm a mouse, my name is " + name);
	}
}

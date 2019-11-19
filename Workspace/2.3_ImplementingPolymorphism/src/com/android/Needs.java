package com.android;

@FunctionalInterface
public interface Needs<T, V> {

	void drink(T name, V weight);
}

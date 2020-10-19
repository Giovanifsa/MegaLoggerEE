package com.jeeasy.engine.utils.data;

import java.util.function.Function;

public final class ArrayUtils {
	@SuppressWarnings("unchecked")
	public static <I, O> O[] convertArray(I[] array, Function<I, O> converter) {
		Object[] convertedItems = new Object[array.length];
		
		for (int i = 0; i < array.length; i++) {
			convertedItems[i] = converter.apply(array[i]);
		}
		
		return (O[]) convertedItems;
	}
}

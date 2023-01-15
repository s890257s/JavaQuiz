package tw.com.ispan.eeit.javatest.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
	public static void main(String[] args) {

		System.out.println(spinWords("Hey fellow warriors"));
	}

	public static String spinWords(String sentence) {
		return Arrays.stream(sentence.split(" ")).map(s -> s.length() >= 5 ? new StringBuilder(s).reverse() : s)
				.collect(Collectors.joining(" ", "", ""));
	}
}

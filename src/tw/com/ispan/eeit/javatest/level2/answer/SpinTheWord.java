package tw.com.ispan.eeit.javatest.level2.answer;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 【題目】 <br>
 * 請撰寫一支程式，此程式會將輸入的英文字串切割，並檢查每一個單字， <br>
 * 當單字長度>=5時，會將符合條件的單字顛倒過來，以下為範例。 <br>
 * <br>
 * spinWords( "Hey java developer" ) => returns "Hey java repoleved"<br>
 * spinWords( "This is a test") => returns "This is a test" <br>
 * spinWords( "This is another test" )=> returns "This is rehtona test"<br>
 */
public class SpinTheWord {

	public static void main(String[] args) {
		System.out.println(forLoop("Hey java developer"));
		System.out.println(java8Solution("This is another test"));
	}

	/**
	 * 一般for迴圈解法，將句子以split拆解，並逐個單字檢視長度，若符合條件則顛倒單字。
	 */
	public static String forLoop(String sentence) {

		String[] words = sentence.split(" ");
		String outputString = "";
		for (String word : words) {
			if (word.length() >= 5) {
				outputString += new StringBuffer(word).reverse() + " ";
			} else {
				outputString += word + " ";
			}

		}
		return outputString;

	}

	/**
	 * 此解法結合了Java8新增的物件Stream，與其map()方法，<br>
	 * 中間的判斷是使用三元運算子，
	 */
	public static String java8Solution(String sentence) {

		String outputString = Arrays.stream(sentence.split(" "))
				.map(item -> item.length() >= 5 ? new StringBuilder(item).reverse() : item)
				.collect(Collectors.joining(" ", "", ""));
		return outputString;

	}

}

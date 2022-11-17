package tw.com.ispan.eeit.javatest.level2.answer;

/**
 * 【題目】 <br>
 * 請撰寫一支程式，此程式能將輸入的數字拆解並相加， <br>
 * 相加完若為2位數以上，則再次拆解並相加，直到數字為個位數為止，以下為範例。 <br>
 * <br>
 * 16 --> 1 + 6 = 7 <br>
 * 942 --> 9 + 4 + 2 = 15 --> 1 + 5 = 6 <br>
 * 132189 --> 1 + 3 + 2 + 1 + 8 + 9 = 24 --> 2 + 4 = 6 <br>
 * 493193 --> 4 + 9 + 3 + 1+ 9 + 3 = 29 --> 2 + 9 = 11 --> 1 + 1 = 2 <br>
 * <br>
 * 即： <br>
 * 輸入16，輸出7； <br>
 * 輸入942，輸出6； <br>
 * 輸入132189，輸出6...<br>
 * <br>
 * 【備註】 <br>
 * 此題有多項解法，可使用「迴圈」、「遞迴」、「數學」等等 <br>
 */
public class DigitalRoot {
	public static void main(String[] args) {

		System.out.println(whileLoop(16));
		System.out.println(recursion(942));
		System.out.println(math(132189));
		System.out.println(math2(493193));

	}

	// 迴圈解法
	private static int whileLoop(int num) {
		// 若輸入數值大於10，則不斷執行迴圈
		while (num >= 10) {
			// 將數字切割成字串陣列，Ex:942 --> String["9","4","2"]
			String[] sArray = String.valueOf(num).split("");

			// 歸零num，作為新相加的容器
			num = 0;

			// 對sArray做ForEach迴圈，每次迴圈都將內容物轉型成整數並總和到num裡
			for (String s : sArray) {
				num += Integer.valueOf(s);
			}
		}

		return num;
	}

	// 遞迴解法
	private static int recursion(long num) {

		int sum = 0;

		String[] sArray = String.valueOf(num).split("");

		for (String s : sArray) {
			sum += Integer.valueOf(s);
		}

		// 若總和大於10，則再呼叫「自己」(此方法)一次
		if (sum >= 10) {
			// 「自己」運算的結果，若大於10，則在內部又會呼叫「自己」一次；若小於10，則將結果傳給sum
			sum = recursion(sum);
		}

		return sum;
	}

	// 以下皆為網路神人解法，原理就是數學(我也沒看懂OuO)
	private static int math(int num) {
		return (num != 0 && num % 9 == 0) ? 9 : num % 9;
	}

	private static int math2(int num) {
		return (num - 1) % 9 + 1;
	}

}

package tw.com.ispan.eeit.javatest.level1.answer;

import java.util.Scanner;

/**
 * 【題目】 <br>
 * 輸入一個整數，對此數做質因數分解，並輸出結果。<br>
 * <br>
 * 【備註】 <br>
 * 質數為一個大於1的整數，且除了1和本身以外，沒有其他的因數。 <br>
 * 解答僅供參考，並非唯一解。<br>
 */
public class PrimeFactorization {

	public static void main(String[] args) {
		// 取得使用者輸入的數字
		System.out.print("請輸入一個你要分解的正整數：");
		Scanner scan = new Scanner(System.in);
		int number = scan.nextInt();// 獲取輸入的數字
		scan.close();

		System.out.print(number + "=");

		// 雙重迴圈，第一層控制從2開始的「除數」(÷2、÷3、÷5...)
		// 第二層while迴圈在整除時改變「被除數」
		for (int i = 2; i <= number; i++) {

			while (number % i == 0 && number != i) {
				number = number / i;
				System.out.print(i + "*");
			}

			if (number == i) {// 若i無法整除number，則代表number是一個質數
				System.out.print(i);
			}
		}
	}
}

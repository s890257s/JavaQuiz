package tw.com.ispan.eeit.javatest.level1.answer;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 【題目】 
 * 輸入一個整數，輸出 1~此數 之間的所有質數。
 * 
 * 【備註】 
 * 質數為一個大於1的整數，且除了1和本身以外，沒有其他的因數。
 * 解答僅供參考，並非唯一解。
 */
public class PrimeNumber {
	public static void main(String[] args) {
		// 取得使用者輸入的數字
		System.out.println("請輸入一個正整數：");
		Scanner scan = new Scanner(System.in);
		int endNumber = scan.nextInt();
		scan.close();

		// 建立一個ArrayList用以存放質數
		ArrayList<Integer> primeNumberList = new ArrayList<Integer>();

		// 雙重迴圈，第一層控制所有數字，第二層檢查每個數字是否為質數
		for (int i = 2; i <= endNumber; i++) {
			for (int j = 2; j <= i; j++) {
				if (i % j == 0 && i != j) {
					break;
				}
				if (i == j) {
					primeNumberList.add(i);
				}
			}
		}
		System.out.println(primeNumberList);
	}
}

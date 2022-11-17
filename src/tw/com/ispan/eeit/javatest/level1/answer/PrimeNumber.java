package tw.com.ispan.eeit.javatest.level1.answer;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 【題目】 輸入一個整數，輸出 1~此數 之間的所有質數。
 * 
 * 【備註】 質數為一個大於1的整數，且除了1和本身以外，沒有其他的因數。
 */
public class PrimeNumber {
	public static void main(String[] args) {
		// 解答僅供參考，並非唯一解。
		// 此解答提供三種作法，可註解掉某種方法使其不執行，分別觀察效率(輸入數字要夠大才會有差異)。

		// 計算效能使用的變數
		long start, end;

		// 取得使用者輸入的數字
		System.out.println("請輸入一個正整數：");
		Scanner scan = new Scanner(System.in);
		int inputNumber = scan.nextInt();
		scan.close();

		// 方法一
		start = System.currentTimeMillis();
		function1(inputNumber);
		end = System.currentTimeMillis();
		System.out.println("方法一耗費毫秒數：" + (end - start));

		// 方法二
		start = System.currentTimeMillis();
		function2(inputNumber);
		end = System.currentTimeMillis();
		System.out.println("方法二耗費毫秒數：" + (end - start));

		// 方法三
		start = System.currentTimeMillis();
		function3(inputNumber);
		end = System.currentTimeMillis();
		System.out.println("方法三耗費毫秒數：" + (end - start));

	}

	/**
	 * 【解法1】 最直觀的想法，使用雙重迴圈逐一檢查，效率最差。
	 */
	private static void function1(int num) {
		// 建立一個ArrayList用以存放質數
		ArrayList<Integer> primeNumberList = new ArrayList<Integer>();

		// 雙重迴圈，第一層控制所有數字，第二層檢查每個數字是否為質數
		for (int i = 2; i <= num; i++) {
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

	/**
	 * 【解法2】 將判斷式質數的程式獨立成function，效率與解法1相同，但會比較容易閱讀。
	 */
	private static void function2(int num) {
		// 建立一個ArrayList用以存放質數
		ArrayList<Integer> primeNumberList = new ArrayList<Integer>();

		// 此迴圈檢查(2~輸入數)區間內的所有數字
		for (int i = 2; i <= num; i++) {

			// 呼叫判斷function，若為true即加入List
			if (isPrimeForFunction2(i)) {
				primeNumberList.add(i);
			}
		}
		System.out.println(primeNumberList);
	}

	// 方法二使用、判斷是否為質數的function。若傳入的數字為質數，回傳true；若為合數則回傳false
	private static boolean isPrimeForFunction2(int num) {
		// 若傳入的數字為2，直接回傳true(2為質數)
		if (num == 2) {
			return true;
		}
		// 有任何i可以整除引數num，代表num為合數，回傳false
		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		// 以上皆未執行，帶表num為質數，回傳true
		return true;
	}

	/**
	 * 【解法3】 修改解法2的質數判斷程式邏輯，換成演算法「埃拉托斯特尼篩法」(試除法)，可大幅降低運算時間。
	 */
	private static void function3(int num) {
		// 建立一個ArrayList用以存放質數
		ArrayList<Integer> primeNumberList = new ArrayList<Integer>();
		for (int i = 2; i <= num; i++) {
			if (isPrimeForFunction3(i)) {
				primeNumberList.add(i);
			}
		}
		System.out.println(primeNumberList);

	}

	private static boolean isPrimeForFunction3(int num) {
		// 若num小於或等於1，則不可能為質數，回傳false
		if (num <= 1) {
			return false;
		}

		// 「埃拉托斯特尼篩法」(試除法)
		for (int i = 2; i * i <= num; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

}

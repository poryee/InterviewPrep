package basic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;

public class Main {

	public static void main(String[] args) {
		System.out.println(reverseStringJava("asdf"));
		
		for (int i = 1; i < 20; ++i) {
			System.out.println(fibShorthand(i));
		}
		
		printMultiplicationTable(10);
		System.out.println(sumFile("bin/basic/numbers.txt"));
		int[] array = {4, 9, 0, 20, -40};
		System.out.println(findMax(array));
		
		System.out.println(formatRGB(255, 0, 122));
	}

	
	static String reverseString(String str) {
		char[] arr = str.toCharArray();
		int i = 0;
		int j = arr.length-1;
		while (i <= j) {
			char tmp = arr[i];
			arr[i] = arr[j];
			arr[j] = tmp;
			++i;
			--j;
		}
		return new String(arr);
	}
	
	// Knowing that string literals are stored in Java heap, this is
	// a more sensible way to reverse a String ONLY in Java
	static String reverseStringJava(String str) {
		String ret = "";
		for (int i = str.length()-1; i >= 0; --i) {
			ret += str.charAt(i);
		}
		return ret;
	}
	
	// 0, 1, 1, 2, 3, 5, 8, 13, 21, 34
	static int fib(int n) {
		if (n <= 1) {
			return n;
		} 
		else {
			return fib(n-1) + fib(n-2);
		}
	}
	
	// Using a ternary operator, we can make the above method more elegant
	static int fibShorthand(int n) {
        return n <= 1 ? n : fib(n-1) + fib(n-2);
    }
	
	static void printMultiplicationTable(int n) {
		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= n; ++j) {
				System.out.print(String.format("%4d", i*j));
			}
			System.out.println();
		}
	}
	
	// Assumes a file with one integer value per line
	static int sumFile(String filename) {
		int total = 0;
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			for ( String s = br.readLine(); s != null; s = br.readLine()) {
				total += Integer.parseInt(s);
			}
			br.close();
		}
		catch (Exception ex) {
			System.out.println(ex);
		}
		return total;
	}
	
	static int findMax(int[] arr) {
		if (arr == null || arr.length == 0) {
			throw new IllegalArgumentException();
		}
		int max = arr[0];
		for (int i = 0; i < arr.length; ++i) {
			if (max < arr[i]) {
				max = arr[i];
			}
		}
		return max;
	}
	
	static String formatRGB(int r, int g, int b) {
		return String.format("%02X%02X%02X", r, g, b);
	}
}
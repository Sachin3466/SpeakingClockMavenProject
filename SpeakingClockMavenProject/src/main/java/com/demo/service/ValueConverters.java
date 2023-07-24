package com.demo.service;

import java.util.HashMap;
import java.util.Map;

public class ValueConverters {

	static Map<Integer, String> intToString = new HashMap<Integer, String>();

	public static String asWords(int hour) {

		intToString.put(0, "zero");
		intToString.put(1, "one");
		intToString.put(2, "two");
		intToString.put(3, "three");
		intToString.put(4, "four");
		intToString.put(5, "five");
		intToString.put(6, "six");
		intToString.put(7, "seven");
		intToString.put(8, "eight");
		intToString.put(9, "nine");
		intToString.put(10, "ten");
		intToString.put(11, "eleven");
		intToString.put(12, "twelve");
		intToString.put(13, "thirteen");
		intToString.put(14, "fourteen");
		intToString.put(15, "fifteen");
		intToString.put(16, "sixteen");
		intToString.put(17, "seventeen");
		intToString.put(18, "eighteen");
		intToString.put(19, "nineteen");
		intToString.put(20, "twenty");
		intToString.put(21, "twentyone");
		intToString.put(22, "twentytwo");
		intToString.put(23, "twentythree");
		intToString.put(24, "twentyfour");
		intToString.put(25, "twentyfive");
		intToString.put(26, "twentysix");
		intToString.put(27, "twentyseven");
		intToString.put(28, "twentyeight");
		intToString.put(29, "twentynine");
		intToString.put(30, "thirty");
		intToString.put(31, "thirtyone");
		intToString.put(32, "thirtytwo");
		intToString.put(33, "thirtythree");
		intToString.put(34, "thirtyfour");
		intToString.put(35, "thirtyfive");
		intToString.put(36, "thirtysix");
		intToString.put(37, "thirtyseven");
		intToString.put(38, "thirtyeight");
		intToString.put(39, "thirtynine");
		intToString.put(40, "fourty");
		intToString.put(41, "fourtyone");
		intToString.put(42, "fourtytwo");
		intToString.put(43, "fourtythree");
		intToString.put(44, "fourtyfour");
		intToString.put(45, "fourtyfive");
		intToString.put(46, "fourtysix");
		intToString.put(47, "fourtyseven");
		intToString.put(48, "fourtyeight");
		intToString.put(49, "fourtynine");
		intToString.put(50, "fifty");
		intToString.put(51, "fiftyone");
		intToString.put(52, "fiftytwo");
		intToString.put(53, "fiftythree");
		intToString.put(54, "fiftyfour");
		intToString.put(55, "fiftyfive");
		intToString.put(56, "fiftysix");
		intToString.put(57, "fiftyseven");
		intToString.put(58, "fiftyeight");
		intToString.put(59, "fiftynine");
		intToString.put(60, "zero");
		
		System.out.println("Integer.valueOf(hour)" + Integer.valueOf(hour));
		return intToString.get(Integer.valueOf(hour));
	}

	static String numberToWords(char num[]) {
		int len = num.length;
		if (len == 0) {
			System.out.println("The string is empty.");
			return "";
		}
		if (len > 4) {
			System.out.println("\n The given number has more than 4 digits.");
			return "";
		}
		String[] onedigit = new String[] { "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
				"Nine" };
		String[] twodigits = new String[] { "", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
				"Seventeen", "Eighteen", "Nineteen" };
		String[] multipleoftens = new String[] { "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy",
				"Eighty", "Ninety" };
		String[] poweroftens = new String[] { "Hundred", "Thousand" };
		System.out.print(String.valueOf(num) + ": ");
		if (len == 1) {
			System.out.println(onedigit[num[0] - '0']);
			return onedigit[num[0] - '0'];
		}
		int x = 0;
		while (x < num.length) {
			if (len >= 3) {
				if (num[x] - '0' != 0) {
					System.out.print(onedigit[num[x] - '0'] + " ");
					System.out.print(poweroftens[len - 3] + " ");
				}
				--len;
			}

			else {

				if (num[x] - '0' == 1) {

					int sum = num[x] - '0' + num[x + 1] - '0';
					System.out.println(twodigits[sum]);
					return twodigits[sum];
				}

				else if (num[x] - '0' == 2 && num[x + 1] - '0' == 0) {

					System.out.println("Twenty");
					return "Twenty";
				}
//the else block handles the numbers from 21 to 100  
				else {
					int i = (num[x] - '0');
					if (i > 0) {

						System.out.print(multipleoftens[i] + " ");
						return multipleoftens[i] + " ";
					} else {
						System.out.print("");
						++x;
						return "";
					}
					// if (num[x] - '0' != 0) return onedigit[num[x] - '0'];
					// System.out.println(onedigit[num[x] - '0']);
				}
			}

			++x;
		}
		return null;
	}
}
package com.peony.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Vector;

public class order {

	public static void main(String[] args) {
		order.maopao(new int []{51,46,94,23,43,71,45,92,14,19,71,56,47,5,26});
		order.xuanze(new int []{51,46,94,23,43,71,45,92,14,19,71,56,47,5,26});
		order.charu(new int []{51,46,94,23,43,71,45,92,14,19,71,56,47,5,26});
	}

	/**
	 * 初始化测试数组的方法
	 * 
	 * @return 一个初始化好的数组
	 */
	public static int[] createArray() {
		Random random = new Random();
		int[] array = new int[15];
		for (int i = 0; i < 15; i++) {
			array[i] = random.nextInt(100) ;// 生成两个随机数相减，保证生成的数中有负数
		}
		System.out.print("原始序列:");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ",");
		}
		System.out.println();
		return array;
	}

	/*
	 * 冒泡排序只要发现比较的两个数字顺序与排序顺序相反就会进行交换操作，所以每一轮的比较可能需要进行多次交换操作；
	 */
	static void maopao(int a[]) {
		int num = 0;
		int swapNum = 0;
		for (int j = 0; j < a.length; j++) {
			for (int i = 0; i < a.length - j - 1; i++) {
				int temp;
				if (a[i] > a[i + 1]) {
					temp = a[i];
					a[i] = a[i + 1];
					a[i + 1] = temp;
					swapNum++;
				}
				num++;
			}
		}

		System.out.print("maopao：");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ",");
		}
		System.out.println("循环次数：" + num + "，交换次数:" + swapNum);
	}

	/*
	 * 选择排序比较时每次只会记录下最小的（或者最大的）的位置，一轮比较完成之后才会进行对应位置和最小位置（或者最大位置） 的交换操作，所以每一轮的比较只做一次交换操作。 交换次数比冒泡排序少多了,由于交换所需CPU时间比比较所需的CUP时间多，所以选择排序比冒泡排序快。
	 */
	static void xuanze(int a[]) {
		int num = 0;
		int swapNum = 0;
		for (int i = 0; i < a.length; i++) {
			int index = i;
			int min = a[index];
			for (int j = i + 1; j < a.length; j++) {
				if (min > a[j]) {
					index = j;
				}
				num++;
			}
			int temp = a[i];
			a[i] = a[index];
			a[index] = temp;
			swapNum++;

			/*
			 * for (int p = 0; p < a.length; p++) { System.out.print(a[p] + ","); } System.out.println("end");
			 */
		}

		System.out.print("xuanze：");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ",");
		}
		System.out.println("循环次数：" + num + "，交换次数:" + swapNum);
	}

	static void charu(int a[]) {
		int num = 0;
		int swapNum = 0;
		for (int i = 1; i < a.length; i++) {
			for (int j = 0; j < i; j++) {
				if (a[j] > a[i]) {
					int temp = a[j];
					a[j] = a[i];
					a[i] = temp;
					swapNum++;
				}
				num++;
			}
		}

		System.out.print("charu：");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ",");
		}
		System.out.println("循环次数：" + num + "，交换次数:" + swapNum);
	}
	
	public static void aaaa(){
		Hashtable a =new Hashtable();
		Vector v =new Vector();
		List list=new ArrayList(); 
		Set set =new HashSet();
		List aaaa=new LinkedList();
		Map hashMap=new HashMap();
		
		set.add(v);
		set.add(v);
		
	}
	
	static public  void bbb(){
		
	}

}

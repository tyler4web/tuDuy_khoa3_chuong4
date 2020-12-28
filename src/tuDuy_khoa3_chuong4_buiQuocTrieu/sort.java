package tuDuy_khoa3_chuong4_buiQuocTrieu;

import java.util.Scanner;

public class sort {
	final static int MIN = -30;
	final static int MAX = 30;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("----Chương trình sắp xếp và trộn 2 mảng A B thành mảng tăng dần----");
		int n = nhapN(scan);
		System.out.print("\nTạo ngẫu nhiên mảng A");
		int mangA[] = taoMangRanDom(n);
		System.out.println("\nMảng A đã tạo:");
		xuatMang(mangA);
		
		System.out.println("\nMảng A sau khi sắp xếp:");
		quickSort(mangA, 0, mangA.length - 1);
		xuatMang(mangA);
		
		System.out.print("Tạo ngẫu nhiên mảng B \n");
		int m = nhapN(scan);
		int mangB[] = taoMangRanDom(m);
		System.out.println("\nMảng B đã tạo:");
		xuatMang(mangB);
		
		System.out.println("\nMảng B sau khi sắp xếp:");
		quickSort(mangB, 0, mangB.length - 1);
		xuatMang(mangB);
		
		System.out.println("\n\nMảng C giam dan sau khi trộn: ");
		xuatMang(tron2Mang(mangA, mangB));
	}
	
	public static int nhapN(Scanner scan) {
		int n;
		do {
			System.out.print("Nhập n > 0  ");
			n = Integer.parseInt(scan.nextLine());
		} while (n < 1);
		return n;
	}

	public static int[] taoMangRanDom(int n) {
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = MIN + (int) (Math.random() * ((MAX - MIN) + 1));
		}
		return a;
	}

	public static void xuatMang(int a[]) {
		for (int pt : a) {
			System.out.print(pt + "\t");
		}
		System.out.println("\n");
	}
	public static void quickSort(int mang[], int l, int r) {
		int i, j, x;
		x = mang[(l + r) / 2];
		i = l;
		j = r;
		do {
			while (mang[i] < x) {
				i++;
			}
			while (mang[j] > x) {
				j--;
			}
			if (i == j) {
				int temp2 = x;
				mang[(l + r) / 2] = mang[i];
				mang[i] = temp2;
				i++;

			}
			if (i < j) {
				int temp = mang[i];
				mang[i] = mang[j];
				mang[j] = temp;
				i++;
				j--;
			}
		} while (i < j);

		if (l < j)
			quickSort(mang, l, j);
		if (i < r)
			quickSort(mang, i, r);

	}
	
	public static int[] tron2Mang(int[] mang1, int[] mang2) {
		int result[] = new int[mang1.length + mang2.length];
		int index1 = 0;
		int index2 = 0;
		for (int i = 0; i < result.length; i++) {
			if (index1 < mang1.length) {

				if (index2 < mang2.length) {

					if (mang1[index1] <= mang2[index2]) {

						result[result.length-1-i] = mang1[index1];
						index1++;
					} else {
						result[result.length-1-i] = mang2[index2];
						index2++;
					}

				} else {
					result[result.length-1-i] = mang1[index1];
					index1++;
				}

			} else {
				result[result.length-1-i] = mang2[index2];
				index2++;
			}
		}
		return result;
	}


}

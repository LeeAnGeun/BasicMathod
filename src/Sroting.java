import java.util.Arrays;
import java.util.Scanner;

public class Sroting {

	public static void main(String[] args) {
		/*
		  Sorting : 정렬
		  -> 오름차순 , 내림자순
		 */	
		int[] arr = inNumber(); // 배열 생성메소드

		// 3. 오름/내림
		upORdown(arr);
		
		// 결과출력
		System.out.println("재배열된 정렬입니다 = " + Arrays.toString(arr));
	}

	private static void upORdown(int[] arr) {
		Scanner sc = new Scanner(System.in);
	
		int temp1;
	
		// 오름차순 Sorting
		while(true) {
			String ud;
			System.out.print("up And down? ");
			ud = sc.next();
			if(ud.equals("up")) {
				upSorting(arr);	
				break;
			}			
			// 내림차순 Sorting
			else if(ud.equals("down")) {
				downSorting(arr);
				break;
			}		
			else {
				System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
			}
		}
	}

	private static void downSorting(int[] arr) {
		int temp;
		
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if(arr[i]<arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}

	private static void upSorting(int[] arr) {
		int temp;
		
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if(arr[i]>arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}

	private static int[] inNumber() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("num = ");
		int num = sc.nextInt();
		
		int arr[] = new int[num];
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print("arr[" + i + "] =");
			arr[i] = sc.nextInt();
		}
		System.out.println("입력한 정렬 =" + Arrays.toString(arr));
		
		return arr;
	}
}

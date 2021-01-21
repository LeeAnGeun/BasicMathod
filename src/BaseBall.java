import java.util.Arrays;
import java.util.Scanner;

public class BaseBall {

	public static void main(String[] args) {
			/*
		    Baseball Game
		    
		    1 ~ 10 -> 3개
			
			random      user
		    7  1  6 -> 1  4  5  = 1 ball
		    		-> 7  3  4  = 1 strike
		    		-> 7  2  1  = 1 strike 1 ball 
		    		
		    rnum1 != rnum2 != rnum3
		 */			 
		
		boolean clear = game();
		
		// 결과출력
		if(clear) {
			System.out.println("Game Clear!!!");
		}
		else {
			System.out.println("Game Over...");
		}
	}
	// TODO : = 책갈피 용도 22가 오른쪽 슬래쉬 옆에 책갈피가 생긴다.
	
	static boolean game() {
		int r_num[] = ranNumber();  // TODO : com의 입력 메소드  int r_num[] = ranNumber(); 
	
		int w=0;
		boolean clear =false;
		
		while(w<10) {				
			int u_num[] = userNumber(); // 사용자 입력 메소드			
			clear= compare(r_num, u_num); // 비교 메소드
			
			w++;
			if(clear) break;			
		}
		
		return clear;
	}
	
	// r_num을 위한 메소드
	static int[] ranNumber() {
		boolean swit[]= new boolean[10];  // 생성과 동시에 전부 false로 초기화
		int r, w;
		int r_num[] = new int[3];
		w=0;
		
		while(w<3) {
			r = (int)(Math.random()*9);  // 0 ~9
			if(swit[r] == false) {
				swit[r] = true;
				r_num[w] = r+1 ;          // 1~10 사이 수 저장
				w++;
			}
		}
		System.out.println(Arrays.toString(r_num));
		return r_num;
	}
	
	// u_num을 위한 메소드
	static int[] userNumber() {
		Scanner sc = new Scanner(System.in);
		
		int u_num[] = new int[3];
		
		// user input
		while(true) {
			for(int i=0; i<u_num.length ;i++) {
				System.out.print((i+1) + "번째 수 =");
				u_num[i] = sc.nextInt();
			}
			if(u_num[0] == u_num[1] || u_num[0] == u_num[2] || u_num[1] == u_num[2] ) {
				System.out.println("같은 숫자가 존재합니다. 다시 입력해 주십시오");
				continue;
			}
			break;
		}
		System.out.println(Arrays.toString(u_num));	
		return u_num;
	}
	
	// r_num과 n_num 비교 메소드
	static boolean compare(int[] r, int[] u) {
		int strike = 0, ball = 0;
		
		boolean clear = false;
		
		// ball
		for(int i=0; i<r.length; i++) {
			for(int j=0; j< u.length; j++) {
				if(u[i]==r[j] && i != j){
					ball++;
				}
			}
		}
		// strike
		for(int i=0; i<r.length; i++) {
			if(u[i] == r[i]) {
				strike++;
			}
		}
		
		// 정답을 맞췃을 때
		if(strike > 2) {
			clear = true;
		}
		
		// 메시지
		System.out.println(strike + "스트라이크"+ ball +"볼 입니다");
		
		return clear;
	}

}

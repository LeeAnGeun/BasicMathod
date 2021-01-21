import java.util.Scanner;

public class Calculation {

	public static void main(String[] args) {
		
		int num1 = numberInput(); // num1 입력 메소드호출
		System.out.println("num1 = "+ num1);

		int num2 = numberInput(); // num2 입력 메소드호출
		System.out.println("num2 = "+ num2);

		String oper = operator(); // 연산자 입력 메소드호출
		System.out.println("oper = "+ oper);

		// 결과값 출력
		System.out.println("결과 값 = " + num1 + oper + num2 + "=" + caculator(num1, num2, oper));
	}
	
	// 
	static int numberInput() {
		Scanner sc = new Scanner(System.in);

		// 1.입력

		String numStr;
		while(true) {
			System.out.print("num = ");
			numStr = sc.next();
	
			boolean b= isNumber(numStr); // numStr에 숫자가 아닌 다른 것이 있는지 판별해주는 메소드 호출

			if(b==true) { // 숫자를 정상적으로 입력했음
				break; // while문을 빠져나온다.
			}
			System.out.println("숫자가 아닌 문자가 포함되어 있습니다.");
		}
		return Integer.parseInt(numStr);
	}
	
	// numberInput() 메소드에서 넘겨받은 String 숫자가 아닌 다른 것이 있늕 판별해주는 메소드
	static boolean isNumber(String str) {
		boolean b = true;
		for(int i=0; i<str.length(); i++) {
			char ch= str.charAt(i); // int asc = (int)numStr1.charAt(i) => 두줄을 한줄로 대체 할수 있다.
			int index = (int)ch-48; 
			
			if(index<0 || index>9) { // 숫자가 아닌 범위 // asc>47 || asc<57
				b= false;
				break;
			}
		}
		return b;
	}

	// 연산자 출력 메소드
	static String operator() {
		Scanner sc = new Scanner(System.in);
		String op;

		while(true) {
		System.out.print("Operator = ");
		op = sc.next();

		if( op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/")) {
		break;
		}
		System.out.println("연산자를 잘못 입력하셨습니다. 다시 입력해 주십시오.");
		}
		return op;
	}

	// 계산하는 메소드
	static int caculator(int n1, int n2, String op) {
		int result = 0;
		switch(op) { 
			case "+": result = n1 + n2;
			break;
			case "-": result = n1 - n2;
			break;
			case "*": result = n1 * n2;
			break;
			case "/": result = n1 / n2;
			break;
		}
		return result;
	}
}

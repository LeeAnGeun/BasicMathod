import java.util.Scanner;

public class AddressBookClass {

	public static void main(String[] args) {
		/*
		   주소록
		   
		   column : 이름, 나이, 전화번호,   주소,  내용
		   		   홍길동  24  123-4567  서울시 고교동창
		   
		   배열 : row =  100
		   
		   Menu
		   1. 친구추가
		   2. 친구삭제
		   3. 친구검색 이름으로
		   4. 친구수정
		   5. 모든 데이터 출력
		   6. 종료
		 */
		Scanner sc = new Scanner(System.in);
		
		String Menu[] = {"1. 친구추가 ", "2. 친구삭제", "3. 친구검색", "4. 친구수정", "5. 모든 친구보기", "6. 종료"};
		String Member[][] = new String[100][5];
		
		boolean b= true;
		
		while(b) {
			// Menu
			System.out.println("==Manu==");
			for (int i = 0; i < Menu.length; i++) {
				System.out.println(Menu[i]);
			}
			// 입력 1_6
			int worknum;          // Menu 선택을 위한 변수
			System.out.print("항목선택 : ");
			worknum = sc.nextInt();
			System.out.println("===============");
			
			switch(worknum) {  // 해당 Menu로 가기 위한 switch 문
				case 1:
					intsert(Member);  // 친구추가
					break;
				case 2:
					delete(Member);  // 친구삭제 
					break;
				case 3:
					search(Member);  // 친구검색
					break;
				case 4:
					cerrect(Member);  // 친구수정
					break;
				case 5: 
					output(Member);  // 모든 친구보기
					break;
				case 6:
					System.out.println("친구저장하기를 종료합니다");  // 종료
					b=false;
					break; 	
			}
			
		}
	}
	// 친구추가
	static void intsert(String[][] member) {
		Scanner sc = new Scanner(System.in);
		
		String column[] = { "이름", "나이", "전화번호", "주소",  "내용"};
		int num;
	
		while(true) {      // 이미 저장되어있는 번호를 선택했을시 다시 입력받기위한 반복문
			System.out.print("몇번에 추가하시겠습니까? ");
			num = sc.nextInt();
			
			if(member[num][0]!=null) {  // 해당 num에 이미 정보가 저장되어있을시 다시 입력을 받기위한 반복문
				System.out.println("이미 저장되어 있습니다. 다른 번호를 선택해 주십시오.");
				continue;
			}
			else {  
				for (int i = 0; i < member[num].length; i++) {  // 정보저장
					System.out.print(column[i] +" : ");
					member[num][i] = sc.next();
				}
				break;
			}
		}
		
		System.out.println("==================");
	}
	
	// 친구삭제 메소드
	static void delete(String[][] member) {
		Scanner sc = new Scanner(System.in);
		
		String name;		
		System.out.print("삭제할 분의 성함이 무엇입니까? ");
		name = sc.next();
		int searchNum = searchMember(member, name);  // searchMember() 메소드를 통해 찾는 이름의 번지수를 반환받음
	
		
		if(searchNum==101) {  // 찾는 이름이 없을 떄
			System.out.println("해당이름을 찾지 못하였습니다.");
		}
		else {
			System.out.println(member[searchNum][0] + "의 내용이 삭제되었습니다."); 
			for (int i = 0; i < member[searchNum].length; i++) {            // 정보 삭제
				member[searchNum][i] = null;
			}
		}
		
		
		System.out.println("==================");
	}	
	
	// 친구찾기 메소드
	static void search(String[][] member) {
		Scanner sc = new Scanner(System.in);
		
		String column[] = { "이름", "나이", "전화번호", "주소",  "내용"};
		String name;
		System.out.print("찾는 분의 성함이 무엇입니까? ");
		name = sc.next();
		int searchNum = searchMember(member, name); // searchMember() 메소드를 통해 찾는 이름의 번지수를 반환받음
		
		if(searchNum==101) {  // 찾는 이름이 없을 떄
			System.out.println("해당이름을 찾지 못하였습니다.");
		}
		else {
			for (int i = 0; i < member[searchNum].length; i++) {
				System.out.println(column[i] + " : " + member[searchNum][i] );  // 전화번호 수정
			}
		}
		
		System.out.println("==================");
	}
	
	// 친구수정 메소드
	static void cerrect(String[][] member) {
		Scanner sc = new Scanner(System.in);
		
		String name;
		System.out.print("수정할 분의 이름이 무엇입니까? ");
		name = sc.next();
		int searchNum = searchMember(member, name); // searchMember() 메소드를 통해 찾는 이름의 번지수를 반환받음
		
		// 전화번호 수정
		if(searchNum == 101) {    // 수정할 내용이 없을시 넘어가기 위한 조건
			System.out.println("해당이름을 찾지 못하였습니다.");
		}
		else {
			member[searchNum][2] = "null"; 
			System.out.print("수정할 전화번호 : ");
			member[searchNum][2] = sc.next();
		}
		
		System.out.println("==================");
	}
	
	// 모든 친구보기 메소드
	static void output(String[][] member) {
		String column[] = { "이름", "나이", "전화번호", "주소",  "내용"};
		
		System.out.println("현재 추가된 친구목록입니다.");
		for (int i = 0; i < member.length; i++) {
			if(member[i][0]==null) {        // 추가된 친구가 없을시 넘어가기 위한 조건문
				continue;			
			}
			
			for (int j = 0; j < member[i].length; j++) {  // 저장되어있는 모든 친구를 보여주기위한 반복문
				System.out.print(column[j] + " : ");
				System.out.println(member[i][j]);
			}
			
			System.out.println("=====================================");
		
		}
		
	}
	
	// 찾는 이름의 번지수를 찾기위한 메소드
	static int searchMember(String[][] member, String name) {
		int searchNum=101; // 해당 이름이 있는 배열의 번지수를 저장하기 위한 변수
		
		for (int i = 0; i < member.length; i++) {
			if(member[i][0] == null) {		// 추가된 친구가 없을시 넘어가기 위한 조건문
				continue;
			}
			if(member[i][0].equals(name)) {
				searchNum = i;
				break;
			}		
		}
		
		return searchNum;
	}
	
}

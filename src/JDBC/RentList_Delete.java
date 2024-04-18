package JDBC;

import java.util.Scanner;

public class RentList_Delete {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		RentDao rdao = RentDao.getInstance();
		System.out.print("삭제할 대여번호를 선택하세요 : ");
		RentDto rdto = rdao.rentOk((Integer.parseInt(sc.nextLine())));
		if (rdto == null) {
			System.out.println("입력한 번호의 대여기록이 없습니다.\n프로그램을 종료합니다.");
			return;
		}
		int result = rdao.deleteRent(rdto);
		if(result == 1) {
			System.out.println("삭제 성공");
		}else {
			System.out.println("삭제 실패");
		}
	}
}

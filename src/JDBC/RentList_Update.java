package JDBC;

import java.util.Scanner;

public class RentList_Update {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 수정할 대여기록의 번호 입력
		System.out.print("수정할 대여기록의 번호를 입력하세요 : ");
		RentDao rdao = RentDao.getInstance();
		int rentnum = Integer.parseInt(sc.nextLine());
		RentDto rdto = rdao.rentOk(rentnum);
//		System.out.println("입력한값에 대한 수정할dto반환");
//		System.out.println(rdto.toString());
		// 기록이 있는지 확인합니다. 없으면 종료
		if (rdto == null) {
			System.out.println("입력한 번호의 대여기록이 존재하지 않습니다.\n프로그램종료");
			return;
		}

		// 수정할 대여날짜를 선택
		System.out.printf("날짜 : %s\n", rdto.getRentdate());
		System.out.print("대여날짜를 입력하세요(YYYY-MM-DD)(수정하지 않으려면 Enter 입력) : ");
		String rentdate = sc.nextLine();
		if (!rentdate.equals(""))
			rdto.setRentdate(rentdate);

		// 수정할 도서번호를 입력. 입력한 번호의 도서가 없으면 다시 입력
		System.out.printf("도서번호 : %s\n", rdto.getBnum());
		System.out.print("수정할 도서의 도서번호를 입력하세요(수정하지 않으려면 Enter 입력) : ");
		String booknum = sc.nextLine();
		if(!booknum.equals("")) {
			rdto.setBnum(Integer.parseInt(booknum));
		}
		// int result = rdao.bookOk(booknum); // 입력한 번호가 존재하면 1, 없으면 0을 리턴

		// 수정할 회원번호를 입력. 입력한 번호의 회원이 없으면 다시 입력
		System.out.printf("회원번호 : %s\n", rdto.getMnum());
		System.out.print("회원번호를 입력하세요 : ");
		String membernum = sc.nextLine();
		if(!membernum.equals("")) {
			rdto.setMnum(Integer.parseInt(membernum));
		}

		// 수정할 할인금액 입력
		System.out.printf("할인금액 : %s\n", rdto.getDiscount());
		System.out.print("수정할 할인금액 입력. (수정하지 않으면 Enter 입력) : ");
		String discount = sc.nextLine();
		if(!discount.equals("")) {
			rdto.setDiscount(Integer.parseInt(discount));
		}

		int result = rdao.updateRent(rdto);
		if(result==1) {
			System.out.println("수정 성공");
		}else {
			System.out.println("수정 실패");
		}

	}
}

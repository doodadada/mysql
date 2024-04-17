package JDBC;

import java.util.Scanner;

public class RentList_Insert {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		RentDao rdao = RentDao.getInstance();

		int membernum;
		while (true) {
			System.out.print("회원번호를 입력하세요 : ");
			membernum = Integer.parseInt(sc.nextLine());
			int result = rdao.memberOk(membernum); // 입력한 번호가 존재하면 1, 없으면 0을 리턴
			if (result == 0) {
				System.out.println("해당 회원이 없습니다. 다시 입력하세요");
				continue;
			} else {
				break;
			}
		}
		System.out.println("입력된 회원 번호 : " + membernum + "\n");

		int booknum;
		while (true) {
			System.out.print("대여할 도서의 도서번호를 입력하세요 : ");
			booknum = Integer.parseInt(sc.nextLine());
			int result = rdao.bookOk(booknum); // 입력한 번호가 존재하면 1, 없으면 0을 리턴
			if (result == 0) {
				System.out.println("해당 도서가 없습니다. 다시 입력하세요");
				continue;
			} else {
				break;
			}
		}
		System.out.println("입력된 도서 번호 : " + booknum + "\n");

		System.out.println("할인금액을 입력하세요 : ");
		int discount = Integer.parseInt(sc.nextLine());

		RentDto rdto = new RentDto();
		rdto.setBnum(booknum);
		rdto.setMnum(membernum);
		rdto.setDiscount(discount);

		int res = rdao.insertRent(rdto);
		if (res == 1) {
			System.out.println("대여 성공");
		} else {
			System.out.println("대여 실패");
		}
	}
}

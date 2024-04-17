package JDBC;

import java.util.ArrayList;


public class RentList_Select {
	public static void main(String[] args) {
		
		RentDao rdao = RentDao.getInstance();
		ArrayList<RentDto> list = rdao.selectRent();
		
		System.out.println("----------------------------------------------------------------------------------------------------------");
		System.out.println("대여번호\t대여일자\t\t도서번호\t회원번호\t회원이름\t대여가격\t할인가격\t매출액\t\t책제목 ");
		System.out.println("----------------------------------------------------------------------------------------------------------");
		for(RentDto rdto : list) {
			System.out.printf("%s\t\t%s\t%s\t\t%s\t\t%s\t\t%s\t\t%s\t\t%s\t\t%s\n",
					rdto.getNumseq(), rdto.getRentdate(),rdto.getBnum(),
					 rdto.getMnum(), rdto.getName(),rdto.getRentprice(),
					 rdto.getDiscount(), rdto.getAmount(),rdto.getSubject());
		}
		
	}
}

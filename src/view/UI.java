package view;

import java.util.Scanner;

import model.StudentDAO;

public class UI {

	StudentDAO dao = new StudentDAO();

	public void StInfo(Scanner scn) {

		int right=0;
		UI2 ui = new UI2();
		while (right==0) {
			System.out.println("[1]학생정보관리]");
			System.out.println("1.학생정보 입력");
			System.out.println("2.학생정보 조회(전체)");
			System.out.println("3.학생정보 검색");
			System.out.println("4.학생정보 변경");
			System.out.println("5.학생정보 삭제");
			System.out.println("6.첫 화면으로");

			System.out.println("------------------------------");
			System.out.print("선택 :");
			int menu = scn.nextInt();
			System.out.println("==============================");
			switch (menu) {
			case 1:

				ui.StInsert(scn);
				break;
			case 2:
				ui.StView(scn);
				break;
			case 3:

				ui.StSelect(scn);
				break;
			case 4:

				ui.StUpdate(scn);
				break;
			case 5:

				ui.StDelete(scn);
				break;
			case 6:
				right =1 ;
				break;
			default:
				System.out.println("해당 번호가 없음");
				break;
			}

		}
	}

	public void StSco(Scanner scn) {
	}

	public void StMon(Scanner scn) {
	}

	public void StExit(Scanner scn) {

		System.out.println("프로그램을 종료하시겠습니까?(y/n)");
		String y = scn.next();

		if (y == "y") {

			int row = dao.exit();

			if (row == 1) {
				System.out.println("종료 성공");
				
			} else {
				System.out.println("종료 실패");
			}
		
		}
	}

}

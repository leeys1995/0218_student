package main;

import java.util.Scanner;

import view.UI;

public class StudentMain {

	public static void main(String[] args) {

		UI ui = new UI();
		Scanner scn = new Scanner(System.in);
		while (true) {
			System.out.println("<학생정보관리 프로그램>");
			System.out.println("1.학생정보 관리");
			System.out.println("2.성적정보 관리");
			System.out.println("3.장학금 관리");
			System.out.println("4.프로그램 종료");

			System.out.println("------------------------------");
			System.out.print("선택 :");
			int menu = scn.nextInt();
			System.out.println("==============================");
			switch (menu) {
			case 1:
				
				ui.StInfo(scn);
				break;
			case 2:
				ui.StSco(scn);
				break;
			case 3:
				
				ui.StMon(scn);
				break;
			case 4:
				
				ui.StExit(scn);
				System.exit(0);
				break;
			default:
				System.out.println("해당 번호가 없음");
				break;
			}

		}
	}

}

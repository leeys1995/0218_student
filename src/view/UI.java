package view;

import java.util.Scanner;

import model.StudentDAO;

public class UI {

	StudentDAO dao = new StudentDAO();

	public void StInfo(Scanner scn) {

		int right=0;
		UI2 ui = new UI2();
		while (right==0) {
			System.out.println("[1]�л���������]");
			System.out.println("1.�л����� �Է�");
			System.out.println("2.�л����� ��ȸ(��ü)");
			System.out.println("3.�л����� �˻�");
			System.out.println("4.�л����� ����");
			System.out.println("5.�л����� ����");
			System.out.println("6.ù ȭ������");

			System.out.println("------------------------------");
			System.out.print("���� :");
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
				System.out.println("�ش� ��ȣ�� ����");
				break;
			}

		}
	}

	public void StSco(Scanner scn) {
	}

	public void StMon(Scanner scn) {
	}

	public void StExit(Scanner scn) {

		System.out.println("���α׷��� �����Ͻðڽ��ϱ�?(y/n)");
		String y = scn.next();

		if (y == "y") {

			int row = dao.exit();

			if (row == 1) {
				System.out.println("���� ����");
				
			} else {
				System.out.println("���� ����");
			}
		
		}
	}

}

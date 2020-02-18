package main;

import java.util.Scanner;

import view.UI;

public class StudentMain {

	public static void main(String[] args) {

		UI ui = new UI();
		Scanner scn = new Scanner(System.in);
		while (true) {
			System.out.println("<�л��������� ���α׷�>");
			System.out.println("1.�л����� ����");
			System.out.println("2.�������� ����");
			System.out.println("3.���б� ����");
			System.out.println("4.���α׷� ����");

			System.out.println("------------------------------");
			System.out.print("���� :");
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
				System.out.println("�ش� ��ȣ�� ����");
				break;
			}

		}
	}

}

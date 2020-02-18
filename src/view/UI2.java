package view;

import java.util.List;
import java.util.Scanner;

import model.StudentDAO;
import model.StudentVO;

public class UI2 {

	StudentDAO dao = new StudentDAO();

	public void StInsert(Scanner scn) {

		while (true) {

			System.out.println("<�л����� �Է�>");
			System.out.println("�й�:");
			int bun = scn.nextInt();
			if (bun == 0000) {
				break;
			}

			List<StudentVO> list = dao.Hak(bun);

			if (list.isEmpty()) {

				System.out.println("�̸�:");
				String name = scn.next();
				System.out.println("�ּ�:");
				String addr = scn.next();
				System.out.println("��ȭ:");
				String email = scn.next();
				System.out.println("�������:");
				String date = scn.next();

				System.out.println("����Ͻðڽ��ϱ�?(y/n)");
				String y = scn.next();

				if (y.equals("y")) {

					int row = dao.Insert(bun, name, addr, email, date);

					if (row == 1) {
						System.out.println(bun + "�л��� �ԷµǾ����ϴ�.");
						break;
					} else {
						System.out.println("��Ͻ��� ");
						break;
					}

				}
			} else {

				System.out.println("�̹� ��ϵ� �л��Դϴ�.");
				break;
			}
			System.out.println("��� ����ұ��?(y/n):");
			String y1 = scn.next();
			if (y1.equals(("y"))) {

				continue;
			} else {
				break;
			}

		}

	}

	public void StView(Scanner scn) {

		List<StudentVO> list = dao.View();

		int nai = 0;
		System.out.println("��" + list.size() + "���� �л��� ��ȸ�մϴ�.");
		System.out.println("�й�\t�̸�\t��ȭ\t\t����");

		if (!list.isEmpty()) {
			for (int x = 0; x < list.size(); x++) {

				System.out.print(list.get(x).getStudent_bun() + "\t");
				System.out.print(list.get(x).getStudent_name() + "\t");
				System.out.print(list.get(x).getStudent_email() + "\t");

				nai = 2020 - Integer.parseInt(list.get(x).getStudent_birth().substring(0, 4));
				System.out.println(nai);

			}
		} else {
			System.out.println("��ü��� �������");
		}
		System.out.println("���θ޴��� �̵��մϴ�.(y/n):");
		String y = scn.next();

		while (true) {
			if (y.equals("y")) {
				break;
			} else if (y.equals("n")) {
				System.exit(0);
			}

		}
	}

	public void StSelect(Scanner scn) {

		int right = 0;
		while (right == 0) {
			System.out.println("<�л����� �˻�");
			System.out.println("1.�̸����� �˻�");
			System.out.println("2.�й����� �˻�");
			System.out.println("3.�г����� �˻�");
			System.out.println("4.�˻� ��� ");

			System.out.println("------------------------------");
			System.out.print("���� :");
			int menu = scn.nextInt();
			System.out.println("==============================");

			switch (menu) {

			case 1:
				System.out.println("�л��̸��Է�:");
				String name = scn.next();

				List<StudentVO> list = dao.select1(name);

				System.out.println("��" + list.size() + "���� �˻��Ǿ����ϴ�.");

				if (!list.isEmpty()) {
					System.out.println("�й�\t�̸�\t�г�\t�ּ�\t��ȭ\t\t�������");
					for (int x = 0; x < list.size(); x++) {

						System.out.print(list.get(x).getStudent_bun() + "\t");
						System.out.print(list.get(x).getStudent_name() + "\t");
						int hak1 = 0;
						if (list.get(x).getStudent_bun() / 1000 == 1) {
							hak1 = 1;
						} else if (list.get(x).getStudent_bun() / 1000 == 2) {
							hak1 = 2;
						} else if (list.get(x).getStudent_bun() / 1000 == 3) {
							hak1 = 3;
						} else if (list.get(x).getStudent_bun() / 1000 == 4) {
							hak1 = 4;
						}
						System.out.print(hak1 + "\t");
						System.out.print(list.get(x).getStudent_addr() + "\t");
						System.out.print(list.get(x).getStudent_email() + "\t");
						System.out.println(list.get(x).getStudent_birth().substring(0, 10) + "\t");

					}
				}

				break;
			case 2:
				System.out.println("�й��Է�:");
				int bun = scn.nextInt();

				List<StudentVO> list1 = dao.select2(bun);

				System.out.println("��" + list1.size() + "���� �˻��Ǿ����ϴ�.");

				System.out.println("�й�\t�̸�\t�ּ�\t��ȭ\t\t�������");
				if (!list1.isEmpty()) {

					for (int x = 0; x < list1.size(); x++) {

						System.out.print(list1.get(x).getStudent_bun() + "\t");
						System.out.print(list1.get(x).getStudent_name() + "\t");
						System.out.print(list1.get(x).getStudent_addr() + "\t");
						System.out.print(list1.get(x).getStudent_email() + "\t");
						System.out.println(list1.get(x).getStudent_birth().substring(0, 10));

					}
				}

				break;
			case 3:

				System.out.println("�г��Է�:");
				int hakn = scn.nextInt();

				List<StudentVO> list2 = dao.select3(hakn);

				System.out.println("��" + list2.size() + "���� �˻��Ǿ����ϴ�.");

				System.out.println("�й�\t�̸�\t�ּ�\t��ȭ\t\t�������");
				if (!list2.isEmpty()) {

					for (int x = 0; x < list2.size(); x++) {

						System.out.print(list2.get(x).getStudent_bun() + "\t");
						System.out.print(list2.get(x).getStudent_name() + "\t");
						System.out.print(list2.get(x).getStudent_addr() + "\t");
						System.out.print(list2.get(x).getStudent_email() + "\t");
						System.out.println(list2.get(x).getStudent_birth().substring(0, 10) + "\t");

					}
				}

				break;
			case 4:
				System.out.println("�˻� ���");
				right = 1;
				break;
			default:
				System.out.println("�ش� ��ȣ�� ����");
				break;
			}

		}

	}

	public void StUpdate(Scanner scn) {

		while (true) {
			System.out.println("===ȸ����������===");

			System.out.println("�й��Է� :");
			int bun = scn.nextInt();
			List<StudentVO> list = dao.select2(bun);

			String name = null;
			String addr = null;
			String email = null;
			String birth = null;

			if (!list.isEmpty()) {

				for (int x = 0; x < list.size(); x++) {

					System.out.println("�̸�(" + list.get(x).getStudent_name() + "):");
					name = scn.next();
					System.out.println("�ּ�(" + list.get(x).getStudent_addr() + "):");
					addr = scn.next();
					System.out.println("��ȭ(" + list.get(x).getStudent_email() + "):");
					email = scn.next();
					System.out.println("�������(" + list.get(x).getStudent_birth().substring(0, 10) + "):");
					birth = scn.next();

				}

				int row = dao.Update(bun, name, addr, email, birth);

				if (row == 1) {
					System.out.println("����");
					break;

				} else {
					System.out.println("����");
				}
			} else {
				System.out.println("��ϵ� ���̵� �����ϴ�.");
				System.out.println("�ٽ� �����ұ��?(y/n)");
				String y = scn.next();
				if (y.equals("y")) {

					continue;
				} else {
					break;
				}
			}
		}

	}

	public void StDelete(Scanner scn) {

		System.out.println("===ȸ�� ���� ����===");
		System.out.println("�й��Է�:");
		int bun = scn.nextInt();

		List<StudentVO> list = dao.select2(bun);

		if (!list.isEmpty()) {

			for (int x = 0; x < list.size(); x++) {
				System.out.println("�̸�:" + list.get(x).getStudent_name());
				System.out.println("�ּ�:" + list.get(x).getStudent_addr());
				System.out.println("��ȭ:" + list.get(x).getStudent_email());
				System.out.println("�������:" + list.get(x).getStudent_birth());

			}
			System.out.println(bun + "���� ������ �����ұ��?(y/n)");
			String y = scn.next();
			if (y.equals("y")) {

				int row = dao.Delete(bun);

				if (row == 1) {
					System.out.println("����");

				} else {
					System.out.println("����");
				}
			} else {
				System.out.println("�������");
			}
		} else {
			System.out.println("��ϵ� ȸ������");
		}

	}

	// ����
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

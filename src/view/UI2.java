package view;

import java.util.List;
import java.util.Scanner;

import model.StudentDAO;
import model.StudentVO;

public class UI2 {

	StudentDAO dao = new StudentDAO();

	public void StInsert(Scanner scn) {

		while (true) {

			System.out.println("<학생정보 입력>");
			System.out.println("학번:");
			int bun = scn.nextInt();
			if (bun == 0000) {
				break;
			}

			List<StudentVO> list = dao.Hak(bun);

			if (list.isEmpty()) {

				System.out.println("이름:");
				String name = scn.next();
				System.out.println("주소:");
				String addr = scn.next();
				System.out.println("전화:");
				String email = scn.next();
				System.out.println("생년월일:");
				String date = scn.next();

				System.out.println("등록하시겠습니까?(y/n)");
				String y = scn.next();

				if (y.equals("y")) {

					int row = dao.Insert(bun, name, addr, email, date);

					if (row == 1) {
						System.out.println(bun + "학생이 입력되었습니다.");
						break;
					} else {
						System.out.println("등록실패 ");
						break;
					}

				}
			} else {

				System.out.println("이미 등록된 학생입니다.");
				break;
			}
			System.out.println("계속 등록할까요?(y/n):");
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
		System.out.println("총" + list.size() + "명의 학생을 조회합니다.");
		System.out.println("학번\t이름\t전화\t\t나이");

		if (!list.isEmpty()) {
			for (int x = 0; x < list.size(); x++) {

				System.out.print(list.get(x).getStudent_bun() + "\t");
				System.out.print(list.get(x).getStudent_name() + "\t");
				System.out.print(list.get(x).getStudent_email() + "\t");

				nai = 2020 - Integer.parseInt(list.get(x).getStudent_birth().substring(0, 4));
				System.out.println(nai);

			}
		} else {
			System.out.println("전체목록 비어있음");
		}
		System.out.println("메인메뉴로 이동합니다.(y/n):");
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
			System.out.println("<학생정보 검색");
			System.out.println("1.이름으로 검색");
			System.out.println("2.학번으로 검색");
			System.out.println("3.학년으로 검색");
			System.out.println("4.검색 취소 ");

			System.out.println("------------------------------");
			System.out.print("선택 :");
			int menu = scn.nextInt();
			System.out.println("==============================");

			switch (menu) {

			case 1:
				System.out.println("학생이름입력:");
				String name = scn.next();

				List<StudentVO> list = dao.select1(name);

				System.out.println("총" + list.size() + "명이 검색되었습니다.");

				if (!list.isEmpty()) {
					System.out.println("학번\t이름\t학년\t주소\t전화\t\t생년월일");
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
				System.out.println("학번입력:");
				int bun = scn.nextInt();

				List<StudentVO> list1 = dao.select2(bun);

				System.out.println("총" + list1.size() + "명이 검색되었습니다.");

				System.out.println("학번\t이름\t주소\t전화\t\t생년월일");
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

				System.out.println("학년입력:");
				int hakn = scn.nextInt();

				List<StudentVO> list2 = dao.select3(hakn);

				System.out.println("총" + list2.size() + "명이 검색되었습니다.");

				System.out.println("학번\t이름\t주소\t전화\t\t생년월일");
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
				System.out.println("검색 취소");
				right = 1;
				break;
			default:
				System.out.println("해당 번호가 없음");
				break;
			}

		}

	}

	public void StUpdate(Scanner scn) {

		while (true) {
			System.out.println("===회원정보수정===");

			System.out.println("학번입력 :");
			int bun = scn.nextInt();
			List<StudentVO> list = dao.select2(bun);

			String name = null;
			String addr = null;
			String email = null;
			String birth = null;

			if (!list.isEmpty()) {

				for (int x = 0; x < list.size(); x++) {

					System.out.println("이름(" + list.get(x).getStudent_name() + "):");
					name = scn.next();
					System.out.println("주소(" + list.get(x).getStudent_addr() + "):");
					addr = scn.next();
					System.out.println("전화(" + list.get(x).getStudent_email() + "):");
					email = scn.next();
					System.out.println("생년월일(" + list.get(x).getStudent_birth().substring(0, 10) + "):");
					birth = scn.next();

				}

				int row = dao.Update(bun, name, addr, email, birth);

				if (row == 1) {
					System.out.println("성공");
					break;

				} else {
					System.out.println("실패");
				}
			} else {
				System.out.println("등록된 아이디가 없습니다.");
				System.out.println("다시 수정할까요?(y/n)");
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

		System.out.println("===회원 정보 삭제===");
		System.out.println("학번입력:");
		int bun = scn.nextInt();

		List<StudentVO> list = dao.select2(bun);

		if (!list.isEmpty()) {

			for (int x = 0; x < list.size(); x++) {
				System.out.println("이름:" + list.get(x).getStudent_name());
				System.out.println("주소:" + list.get(x).getStudent_addr());
				System.out.println("전화:" + list.get(x).getStudent_email());
				System.out.println("생년월일:" + list.get(x).getStudent_birth());

			}
			System.out.println(bun + "님의 정보를 삭제할까요?(y/n)");
			String y = scn.next();
			if (y.equals("y")) {

				int row = dao.Delete(bun);

				if (row == 1) {
					System.out.println("성공");

				} else {
					System.out.println("실패");
				}
			} else {
				System.out.println("삭제취소");
			}
		} else {
			System.out.println("등록된 회원없음");
		}

	}

	// 종료
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

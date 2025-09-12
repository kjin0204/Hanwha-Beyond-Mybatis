package com.ohgiraffers.dynamic;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("===== 마이바티스 동적 SQL =====");
            System.out.println("1. if 확인하기");
            System.out.println("2. choose(when,otherwise) 확인하기");
            System.out.println("3. foreach 확인하기");
            System.out.println("4. trim(where, set) 확인하기");
            System.out.println("9. 종료하기");
            System.out.println("메뉴를 선택하세요: ");
            int input = sc.nextInt();
            switch (input) {
                case 1:
                    ifSubmenu();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 9:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("번호를 잘못 입력하셨습니다.");

            }
        } while (true);
    }

    private static void ifSubmenu() {
        Scanner sc = new Scanner(System.in);
        MenuService ms = new MenuService();

        do {
            System.out.println("====== if 서브메뉴 ======");
            System.out.println("1. 원하는 금액대에 적합한 추천 메뉴 목록 보여주기");
            System.out.println("9. 이전 메뉴로");
            System.out.println("메뉴 번호를 입력해 주세요: ");
            int input = sc.nextInt();
            switch (input) {
                case 1:
                    ms.findMenuByPrice(inputPrice());
                    break;
                case 9:
                    return;

            }
        } while (true);
    }

    private static int inputPrice() {
        Scanner sc = new Scanner(System.in);
        System.out.println("검색 할 가격대의 최대 금액을 입력해 주세요: "); // 0, 1만, 2만, 3만 구간에서 입력한 가격까지
        return sc.nextInt();

    }
}

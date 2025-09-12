package com.ohgiraffers.section02.javaconfig;


import java.util.List;

public class PrintResult {
    /* 설명. 전체 메뉴 조회 성공 페이지 느낌 */
    public void printMenus(List<MenuDTO> menuList) {
        menuList.forEach(System.out::println);
    }

    /* 설명. Exception Handling을 통한 페이지와 같은 느낌의 메소드 */
    public void printeErrorMessage(String message) {
        System.out.println("에러 메시지: " + message);
    }

    /* 설명. 메뉴 상세 보기 페이지 */
    public void printMenu(MenuDTO menu) {
        System.out.println("menu = " + menu);
    }
    /* 설명. 메뉴 DML작업 성공 페이지 느낌 */
    public void printSuccessMesage(String message) {
        String successMesage = "";
        switch (message) {
            case "regist": successMesage = "신규 메뉴 등록에 성공하셨습니다."; break;
            case "modify": successMesage = "메뉴 수정에 성공하셨습니다."; break;
            case "remove": successMesage = "메뉴 삭제에 성공하셨습니다.";
        }

        System.out.println("DML 성공 메세지: " + successMesage);

    }
}

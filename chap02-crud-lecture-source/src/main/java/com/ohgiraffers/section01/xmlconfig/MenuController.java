package com.ohgiraffers.section01.xmlconfig;

import java.util.List;

public class MenuController {

    private final MenuService menuService;
    private final PrintResult printResult;
    public MenuController() {
        this.menuService = new  MenuService();
        this.printResult = new PrintResult();
    }

    public void findAllMenus() {
        List<MenuDTO> menuList = menuService.findAllMenus();

        if(!menuList.isEmpty()){
            printResult.printMenus(menuList);
        } else {
            printResult.printeErrorMessage("전체 메뉴 조회 실패");
        }
    }
}

package com.ohgiraffers.section01.xmlconfig;

import java.util.List;
import java.util.Map;

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

    public void findMenuByMenuCode(Map<String, String> parameter) {
        int menuCode = Integer.parseInt(parameter.get("menuCode"));

        MenuDTO menu = menuService.findMenuByMenuCode(menuCode);

        if(menu != null){
            printResult.printMenu(menu);
        } else {
            printResult.printeErrorMessage(menuCode + "번의 메뉴는 없습니다.");
        }
    }
}

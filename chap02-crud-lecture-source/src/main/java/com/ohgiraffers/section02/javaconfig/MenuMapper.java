package com.ohgiraffers.section02.javaconfig;

import org.apache.ibatis.annotations.*;

import java.util.List;

/* 설명. 쿼리를 포함한 Mapper용 인터페이스이자 DAO계층 역활도 한다. */
public interface MenuMapper {
    @Results(id="menuResultMap", value ={
            @Result(id=true, property="menuCode", column="MENU_CODE"),
            @Result(property="menuName", column="MENU_NAME"),
            @Result(property="menuPrice", column="MENU_PRICE"),
            @Result(property="categoryCode", column="CATEGORY_CODE"),
            @Result(property="orderableStatus", column="ORERABLE_STATUS"),
    })
    @Select("SELECT\n" +
            "            MENU_CODE\n" +
            "            , MENU_NAME\n" +
            "            , MENU_PRICE\n" +
            "            , CATEGORY_CODE\n" +
            "            , ORDERABLE_STATUS\n" +
            "    FROM TBL_MENU")
    List<MenuDTO> selectAllMenus();

    @Select("SELECT\n" +
            "               MENU_CODE\n" +
            "             , MENU_NAME\n" +
            "             , MENU_PRICE\n" +
            "             , CATEGORY_CODE\n" +
            "             , ORDERABLE_STATUS\n" +
            "         FROM TBL_MENU\n" +
            "        WHERE MENU_CODE = #{menuCode}")
    @ResultMap("menuResultMap")
    MenuDTO selectMenuByCode(int menuCode);

    @Update("\n" +
            "        UPDATE\n" +
            "               TBL_MENU\n" +
            "           SET MENU_NAME = #{menuName}\n" +
            "             , MENU_PRICE = #{menuPrice}\n" +
            "         WHERE MENU_CODE = #{menuCode}")
    int updateMenu(MenuDTO menu);

    @Insert("\n" +
            "        INSERT\n" +
            "          INTO TBL_MENU\n" +
            "        (\n" +
            "          MENU_NAME\n" +
            "        , MENU_PRICE\n" +
            "        , CATEGORY_CODE\n" +
            "        , ORDERABLE_STATUS\n" +
            "        )\n" +
            "        VALUES\n" +
            "        (\n" +
            "          #{menuName}\n" +
            "        , #{menuPrice}\n" +
            "        , #{categoryCode}\n" +
            "        , 'Y'\n" +
            "        )")
    int insertMenu(MenuDTO menu);

    @Delete("\n" +
            "        DELETE\n" +
            "          FROM TBL_MENU\n" +
            "         WHERE MENU_CODE = #{menuCode}")
    int deleteMenu(int menuCode);

}

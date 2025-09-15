package com.ohgiraffers.xmlmapper;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.xmlmapper.Tamplate.getSqlSession;

public class ElementService {
    public void selectResultMapTest() {
        SqlSession sqlSession = getSqlSession();
        ElementMapper mapper = sqlSession.getMapper(ElementMapper.class);

        List<MenuDTO> menus = mapper.selectResultMapTest();
        menus.forEach(System.out::println);

        sqlSession.close();
    }

    public void selectResultMapAssociationTest() {
        SqlSession sqlSession = getSqlSession();
        ElementMapper mapper = sqlSession.getMapper(ElementMapper.class);

        List<MenuAndCategoryDTO> menus = mapper.selectResultMapAssociationTest();
        menus.forEach(System.out::println);

        System.out.println("첫 번째 메뉴의 카테고리 이름 조회: "
                + menus.get(0).getCategory().getCategoryName());

        sqlSession.close();
    }
}

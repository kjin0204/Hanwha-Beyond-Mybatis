package com.ohgiraffers.dynamic;

import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

import static com.ohgiraffers.dynamic.Tamplate.getSqlSession;

public class MenuService {
    public void findMenuByPrice(int maxPrice) {
        SqlSession sqlSession = getSqlSession();
        System.out.println("sqlSession = " + sqlSession);

        MenuMapper mapper =
                sqlSession.getMapper(MenuMapper.class);

        List<MenuDTO> menus = mapper.selectMenuByPrice(maxPrice);
        menus.forEach(System.out::println);

        sqlSession.close();
    }

    public void searchMenu(SearchCriteria searchCriteria) {
        SqlSession sqlSession = getSqlSession();
        MenuMapper mapper = sqlSession.getMapper(MenuMapper.class);

        List<MenuDTO> menus = mapper.searchMenu(searchCriteria);
        menus.forEach(System.out::println);

        sqlSession.close();
    }

    public void searchMenuBySupCategory(SearchCriteria searchCriteria) {
        SqlSession sqlSession = getSqlSession();
        MenuMapper mapper = sqlSession.getMapper(MenuMapper.class);

        List<MenuDTO> menus = mapper.searchMenuBySupCategory(searchCriteria);
        menus.forEach(System.out::println);

        sqlSession.close();

    }

    public void searchMenuByRandomCode(List<Integer> integers) {
        SqlSession sqlSession = getSqlSession();
        MenuMapper mapper = sqlSession.getMapper(MenuMapper.class);

        /* 설명. List형태로 기본적으로는 넘기지 않지만 foreach를 활용하는 동적쿼리는 List 활용 가능(feat. key값 불필요) */
        List<MenuDTO> menus = mapper.searchMenuByRandomMenuCode(integers);
        menus.forEach(System.out::println);

        sqlSession.close();
    }

    public void searchMenuByCodeOrSearchAll(SearchCriteria searchCriteria) {
        SqlSession sqlSession = getSqlSession();
        MenuMapper mapper = sqlSession.getMapper(MenuMapper.class);

        /* 설명. List형태로 기본적으로는 넘기지 않지만 foreach를 활용하는 동적쿼리는 List 활용 가능(feat. key값 불필요) */
        List<MenuDTO> menus = mapper.searchMenuByCodeOrSearchAll(searchCriteria);
        menus.forEach(System.out::println);

        sqlSession.close();
    }

    public void searchMenuByNameOrCategory(Map<String, Object> criteria) {
        SqlSession sqlSession = getSqlSession();
        MenuMapper mapper = sqlSession.getMapper(MenuMapper.class);

        /* 설명. List형태로 기본적으로는 넘기지 않지만 foreach를 활용하는 동적쿼리는 List 활용 가능(feat. key값 불필요) */
        List<MenuDTO> menus = mapper.searchMenuByNameOrCategory(criteria);
        menus.forEach(System.out::println);

        sqlSession.close();
    }

    public void modifyMenu(Map<String, Object> critMap) {
        SqlSession sqlSession = getSqlSession();
        MenuMapper mapper = sqlSession.getMapper(MenuMapper.class);

        /* 설명. List형태로 기본적으로는 넘기지 않지만 foreach를 활용하는 동적쿼리는 List 활용 가능(feat. key값 불필요) */
        int result = mapper.updateMenu(critMap);
        if(result == 1){
            System.out.println("메뉴 정보 변경에 성공하셨습니다.");
            sqlSession.commit();
        } else {
            System.out.println("메뉴 정보 변경에 실패하셨습니다.");
            sqlSession.rollback();
        }


        sqlSession.close();
    }
}

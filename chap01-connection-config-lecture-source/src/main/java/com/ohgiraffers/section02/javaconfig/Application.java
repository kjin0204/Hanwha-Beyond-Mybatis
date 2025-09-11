package com.ohgiraffers.section02.javaconfig;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class Application {
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/menudb";
    private static String user = "swcamp";
    private static String password = "swcamp";

    public static void main(String[] args) {
        /* 설명.
         *  JdbcTransactionFactory: 수동 커밋
         *  ManagedTransactionFactory : 자동커밋
         *  ----------------------------------------
         *  PooledDataSource : ConnectionPool 활용
         *  UnPooledDataSource: ConnectionPool 활용  x
        * */

        Environment environment = new Environment(
                "dev",
                new JdbcTransactionFactory(),
                new PooledDataSource(driver, url, user, password)
        );

        Configuration configuration = new Configuration(environment);
        configuration.addMapper(Mapper.class);

        /* 설명.
         *  SqlSessionFactory: SqlSession 객체를 생서앟기 위한 팩토리 역활의 인터페이스
         *  SqlSessionFactoryBuilder : SqlsessionFactory 인터페이스 타입의 하위 구현 객체를 생성하기
         *                              위한 빌더 역활
         *  build(): 설정에 대한 정보를 담고 있는 Configuration 타입의 객체(java방식) 혹은 외부 설정 파일과
         *          연결된 stream을 매개변수로 전달(xml 방식) 하면 sqlSessionFactory 인퍼테이스 타입의
         *           객체를 반환하는 메소드
        * */

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        SqlSession session = sqlSessionFactory.openSession(false); //수동 커밋

        Mapper mapper = session.getMapper(Mapper.class);    //Mapper의 하위 구현체 생성
        java.util.Date nowDate =  mapper.selectNow();
        System.out.println("nowDate = " + nowDate);

        session.close();
    }
}

package com.ohgiraffers.section02.javaconfig;

import org.apache.ibatis.annotations.Select;

public interface Mapper {
    @Select("select now()")
    java.util.Date selectNow();
}

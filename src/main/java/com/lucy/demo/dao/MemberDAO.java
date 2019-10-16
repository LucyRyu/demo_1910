package com.lucy.demo.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {

  @Autowired
  SqlSessionTemplate sql;

  public String getUserInfo(String name) {
      return sql.selectOne("member.getUserInfo",name);
  }
  
}

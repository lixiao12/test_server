package com.zking.dao;

import com.zking.entity.Person;

public interface PersonDao {
    public Person selectOne(int pid);
    public void add(Person person);
}

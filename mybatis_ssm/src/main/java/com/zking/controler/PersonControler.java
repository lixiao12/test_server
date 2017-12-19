package com.zking.controler;

import com.zking.dao.PersonDao;
import com.zking.entity.Person;
import org.activiti.engine.RepositoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class PersonControler {

    @Resource
    private PersonDao personDao;
    @Resource
    private RepositoryService repositoryService;

    @RequestMapping("add")
    public String add(Person person){
        personDao.add(person);
        return "index";
    }

    @RequestMapping("deploy")
    public String deploy(Person person){
        repositoryService.createDeployment().name("aaa")
                .addClasspathResource("diagrams/studentLeave.bpmn").deploy();
        return "index";
    }

}

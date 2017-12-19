package com.zking.test;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class activitiTest {

    private ProcessEngine processEngine;

    @Before
    public void testCreateTable(){
        processEngine = ProcessEngines.getDefaultProcessEngine();
        System.out.println("创表成功");
        System.out.println("ssss00");
    }

    @Test
    public void testProcessDeploy(){
        Deployment deployment = processEngine.getRepositoryService().createDeployment()
                .name("studentLeave").addClasspathResource("diagrams/studentLeave.bpmn").deploy();
        System.out.println(deployment.getId() + " " + deployment.getName());
    }

    @Test
    public void testProcessRun(){
        ProcessInstance processInstance = processEngine.getRuntimeService().startProcessInstanceByKey("myProcess_1");
        System.out.println(processInstance.getId());
    }

    @Test
    public void testProcessDefQuery(){
        List<ProcessDefinition> list = processEngine.getRepositoryService().createProcessDefinitionQuery().list();
        for (ProcessDefinition processDefinition : list) {
            System.out.println(processDefinition.getId() + " " + processDefinition.getName() + " " + processDefinition.getVersion());
        }
    }

    public void testProcessDefDel(){
        processEngine.getRepositoryService().deleteDeployment("");
    }

    @Test
    public void testProcessState(){
        ProcessInstance processInstance = processEngine.getRuntimeService()
                .createProcessInstanceQuery().processDefinitionId("myProcess_1:1:4").singleResult();
        if(processInstance!=null){
            System.out.println("流程正在进行中");
        }else{
            System.out.println("流程执行完了");
        }
    }

    @Test
    public void testHisProcessInstanceQuery(){
        processEngine.getHistoryService().createHistoricProcessInstanceQuery().list();
    }

    @Test
    public void testHisTask(){
        processEngine.getHistoryService().createHistoricTaskInstanceQuery().taskAssignee("").list();
    }
    @Test
    public void testTaskQuery(){
        Task task = processEngine.getTaskService().createTaskQuery().taskAssignee("张三").singleResult();
        System.out.println(task.getId());

    }

    @Test
    public void testTaskValiSet(){
        processEngine.getTaskService().setVariable("2504","day",5);

    }

    @Test
    public void testTaskValiet(){
        System.out.println(processEngine.getTaskService().getVariable("2504", "day"));


    }


}

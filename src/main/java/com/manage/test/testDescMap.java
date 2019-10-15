package com.manage.test;

import com.manage.dao.HiveTableDescMapper;
import com.manage.model.HiveTableDesc;
import com.manage.service.impl.HiveTableDescServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;

public class testDescMap {

    private static HiveTableDescMapper hiveTableDescMapper;

    @BeforeAll
    public static void before(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-context.xml");
        hiveTableDescMapper =ctx.getBean(HiveTableDescMapper.class);
    }

    @Test
    public void testSearchDesc() {
        HiveTableDesc hiveTableDesc = new HiveTableDesc();
        hiveTableDesc.setDbTable("xxk");
        List<HiveTableDesc> desc = hiveTableDescMapper.searchDesc(hiveTableDesc);
        System.out.println(desc.get(0).getDescContentMD());
        System.out.println(desc.get(0).getCreateDate());
        System.out.println(desc.get(0).getCreateDateStr());
        System.out.println(desc.get(0).getModifyDate());
        System.out.println(desc.get(0).getModifyDateStr());
    }
    @Test
    public void testSearchDescCreatedBy() {
        HiveTableDesc hiveTableDesc = new HiveTableDesc();
        hiveTableDesc.setDbTable("xxk");
        hiveTableDesc.setCreateBy("xu");
        List<HiveTableDesc> desc = hiveTableDescMapper.searchDescCreatedBy(hiveTableDesc);
        System.out.println(desc.get(0).getDbTable()+desc.get(1).getDbTable());
    }
    @Test
    public void testCreateDesc() {
        HiveTableDesc hiveTableDesc = new HiveTableDesc();
        hiveTableDesc.setDbTable("xpf");
        hiveTableDescMapper.createDesc(hiveTableDesc);
//        System.out.println(desc.get(0).getDescContentMD());
    }
    @Test
    public void testUpdateDesc() {
        HiveTableDesc hiveTableDesc = new HiveTableDesc();
        hiveTableDesc.setDbTable("xpf");
        hiveTableDesc.setDescContentMD("xxkxkxkxkxkxkkxkkxkxkxkxkxkxkk");
        hiveTableDescMapper.updateDesc(hiveTableDesc);
//        System.out.println(desc.get(0).getDescContentMD());
    }
    @Test
    public void testDeleteDesc() {
        HiveTableDesc hiveTableDesc = new HiveTableDesc();
        hiveTableDesc.setDbTable("xpf");
        hiveTableDescMapper.deleteDesc(hiveTableDesc);
//        System.out.println(desc.get(0).getDescContentMD());
    }

    @Test
    public void testService(){
        HiveTableDescServiceImpl service = new HiveTableDescServiceImpl();
        Map<String, Object> map = service.searchDescContent("xxk");
        HiveTableDesc model = (HiveTableDesc) map.get("data");
        System.out.println(model.getDescContentMD());
    }
    @Test
    public void testCreateService(){
        HiveTableDescServiceImpl service = new HiveTableDescServiceImpl();

        Map<String, Object> map = service.createDescContent("xxk","sss","xxk");
        String message = (String) map.get("message");
        System.out.println(message);
    }
}

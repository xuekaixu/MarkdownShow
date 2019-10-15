package com.manage.service.impl;

import com.manage.dao.HiveTableDescMapper;
import com.manage.model.HiveTableDesc;
import com.manage.service.HiveTableDescService;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HiveTableDescServiceImpl implements HiveTableDescService {

    @Autowired
    private HiveTableDescMapper hiveTableDescMapper;

    public Map<String, Object> searchDescContent(String dbTable) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        if (StringUtils.isBlank(dbTable)){
            resultMap.put("message", "请输入正确dbTable");
            resultMap.put("result", "fail");
            resultMap.put("data",null);
            return resultMap;
        }
        HiveTableDesc hiveTableDesc = new HiveTableDesc();
        hiveTableDesc.setDbTable(dbTable);
        try {
            List<HiveTableDesc> hiveTableDescs = this.hiveTableDescMapper.searchDesc(hiveTableDesc);

            if (hiveTableDescs == null || hiveTableDescs.isEmpty()) {
                resultMap.put("message", "There is no description of this dbTable: " + dbTable);
                resultMap.put("result", "success");
                resultMap.put("data", null);
            } else if (hiveTableDescs.size() != 1) {
                resultMap.put("message", "Description of the dbTable is not unique！！！");
                resultMap.put("result", "fail");
                resultMap.put("data", hiveTableDescs.get(0));
            } else {
                resultMap.put("data", hiveTableDescs.get(0));
                resultMap.put("message", "success");
                resultMap.put("result", "success");
            }
        }catch (Exception e){
            resultMap.put("message", "error search!!");
            resultMap.put("result", "fail");
            resultMap.put("data", null);
        }
        return resultMap;
    }

    public Map<String, Object> getHiveTableByCreateName(String createName) {

        Map<String, Object> resultMap = new HashMap<String, Object>();
        if (StringUtils.isBlank(createName)){
            resultMap.put("message", "请输入正确createName");
            resultMap.put("result", "fail");
            resultMap.put("data", null);
            return resultMap;
        }
//        if(createName.equals("admin")){
//
//        }
        HiveTableDesc hiveTableDesc = new HiveTableDesc();
        hiveTableDesc.setCreateBy(createName);
        try{
            List<HiveTableDesc> hiveTableDescs = this.hiveTableDescMapper.searchDescCreatedBy(hiveTableDesc);

            if(hiveTableDescs == null || hiveTableDescs.isEmpty()){
                resultMap.put("message", "There is no description created by: " + createName);
                resultMap.put("result", "success");
                resultMap.put("data", null);
            }else {
                List<String> dbTables = new LinkedList<String>();
                for(HiveTableDesc desc: hiveTableDescs){
                    dbTables.add(desc.getDbTable());
                }
                resultMap.put("data", dbTables);
                resultMap.put("message", "success");
                resultMap.put("result", "success");
            }
        }catch (Exception e){
            resultMap.put("data", null);
            resultMap.put("message", "error search");
            resultMap.put("result", "fail");
        }

        return resultMap;
    }

    public Map<String, Object> createDescContent(String dbTable, String descContent, String createName) {

        Map<String, Object> resultMap = new HashMap<String, Object>();
        if(StringUtils.isBlank(dbTable) ){
            resultMap.put("message", "Please select one dbTable to description");
            resultMap.put("result", "fail");
            return resultMap;
        }
        HiveTableDesc hiveTableDesc = new HiveTableDesc();

        if(StringUtils.isNotBlank(dbTable))
            hiveTableDesc.setDbTable(dbTable);
        if(StringUtils.isNotBlank(descContent))
            hiveTableDesc.setDescContentMD(descContent);
        if (StringUtils.isNotBlank(createName)) {
            hiveTableDesc.setCreateBy(createName);
            hiveTableDesc.setModifyBy(createName);
        }
        try{
            this.hiveTableDescMapper.createDesc(hiveTableDesc);  //数据库错误处理？？？
            resultMap.put("message", "Successfully create description!!");
            resultMap.put("result", "success");
        }catch (Exception e){
            resultMap.put("message", "Error when creating the description!!");
            resultMap.put("result", "fail");
        }
        return resultMap;

    }

    public Map<String, Object> updateDescContent(String dbTable, String descContent, String modifyName) {
        Map<String, Object> resultMap = new HashMap<String, Object>();

        if(StringUtils.isBlank(dbTable) ){
            resultMap.put("message", "Please select one dbTable to description");
            resultMap.put("result", "fail");
            return  resultMap;
        }
        HiveTableDesc hiveTableDesc = new HiveTableDesc();

        if(StringUtils.isNotBlank(dbTable))
            hiveTableDesc.setDbTable(dbTable);
        if(StringUtils.isNotBlank(descContent))
            hiveTableDesc.setDescContentMD(descContent);
        if (StringUtils.isNotBlank(modifyName)) {
            hiveTableDesc.setModifyBy(modifyName);
        }
        try{
            this.hiveTableDescMapper.updateDesc(hiveTableDesc);
            resultMap.put("message", "Successfully update description!!");
            resultMap.put("result", "success");
        }catch (Exception e){
            resultMap.put("message", "Error when Updating the description!!");
            resultMap.put("result", "error");
        }
        return resultMap;
    }

    public Map<String, Object> deleteDescContent(String dbTable) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        HiveTableDesc hiveTableDesc = new HiveTableDesc();
        hiveTableDesc.setDbTable(dbTable);

        if (StringUtils.isNotBlank(dbTable)) {
            try {
                this.hiveTableDescMapper.deleteDesc(hiveTableDesc);
                resultMap.put("result", "success");
                resultMap.put("message", "Successfully delete the description of dbTable--" + dbTable);
            }catch (Exception e){
                resultMap.put("result", "fail");
                resultMap.put("message", "Error delete the the description of dbTable--" + dbTable);
            }
        } else {
            resultMap.put("result", "fail");
            resultMap.put("message", "Error delete the the description of dbTable--" + dbTable);
        }
        return resultMap;
    }

    public  Map<String, Object> searchAll() {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try{
            List<HiveTableDesc> list = this.hiveTableDescMapper.searchAll();
            resultMap.put("data",list);
            resultMap.put("message","success search all description");
            resultMap.put("result","success");
        }catch (Exception e){
            resultMap.put("data", null);
            resultMap.put("result", "fail");
            resultMap.put("message", "Error Search");
        }

        return resultMap;
    }
}

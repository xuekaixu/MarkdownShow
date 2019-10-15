package com.manage.service;

import java.util.Map;

public interface HiveTableDescService {
    Map<String, Object> searchDescContent(String dbTable);
    Map<String, Object> getHiveTableByCreateName(String createName);
    Map<String,Object> createDescContent(String dbTable, String descContent, String createName);
    Map<String, Object> updateDescContent(String dbTable, String descContent, String modifyName);
    Map<String, Object> deleteDescContent(String dbTable);
    Map<String, Object> searchAll();


}

package com.manage.dao;


import com.manage.model.HiveTableDesc;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HiveTableDescMapper {
    List<HiveTableDesc> searchDesc(HiveTableDesc paramDesc);
    List<HiveTableDesc> searchDescCreatedBy(HiveTableDesc paramDesc);
    void createDesc(HiveTableDesc paramDesc);
    void updateDesc(HiveTableDesc paramDesc);
    void deleteDesc(HiveTableDesc paramDesc);
    List<HiveTableDesc> searchAll();


}

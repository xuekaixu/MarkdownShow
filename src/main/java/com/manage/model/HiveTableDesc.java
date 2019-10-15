package com.manage.model;

import com.manage.util.DateUtil;

import java.util.Date;

public class HiveTableDesc {

    private Integer id;
    private String dbTable;
    private String descContentMD;
    private Date createDate;
    private Date modifyDate;
    private String createBy;
    private String modifyBy;
    private String createDateStr;
    private String modifyDateStr;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDbTable() {
        return dbTable;
    }

    public void setDbTable(String dbTable) {
        this.dbTable = dbTable;
    }

    public String getDescContentMD() {
        return descContentMD;
    }

    public void setDescContentMD(String descContentMD) {
        this.descContentMD = descContentMD;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
    }


    public String getCreateDateStr() {
        if (this.createDate != null) {
            this.createDateStr = DateUtil.parseDateToStr(this.createDate, "yyyy-MM-dd HH:mm:ss");
        }
        return this.createDateStr;
    }


    public void setCreateDateStr(String createDateStr) { this.createDateStr = createDateStr; }


    public String getModifyDateStr() {
        if (this.modifyDate != null) {
            this.modifyDateStr = DateUtil.parseDateToStr(this.modifyDate, "yyyy-MM-dd HH:mm:ss");
        }
        return this.modifyDateStr;
    }


    public void setModifyDateStr(String setModifyDateStr) { this.modifyDateStr = setModifyDateStr; }

}

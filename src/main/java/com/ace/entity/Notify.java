package com.ace.entity;

import java.sql.Timestamp;

/**
 * Created by leaf.ye on 2016/8/22.
 */
public class Notify {
    private int id;
    private String content;
    private int notifyTemplateId;
    private String platformTemplateId;
    private String paramValues;
    private String status;
    private String phoneNumber;
    private Timestamp createdTime;
    private String createdBy;
    private Timestamp updatedTime;
    private String updatedBy;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getNotifyTemplateId() {
        return notifyTemplateId;
    }

    public void setNotifyTemplateId(int notifyTemplateId) {
        this.notifyTemplateId = notifyTemplateId;
    }

    public String getPlatformTemplateId() {
        return platformTemplateId;
    }

    public void setPlatformTemplateId(String platformTemplateId) {
        this.platformTemplateId = platformTemplateId;
    }

    public String getParamValues() {
        return paramValues;
    }

    public void setParamValues(String paramValues) {
        this.paramValues = paramValues;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Timestamp updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}

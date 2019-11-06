package com.yjiuye.cust.bean;

import java.util.Date;

public class Customer {
    private Integer id;
    //公司名称
    private String comname;
    //公司联系人
    private String companyperson;

    //公司地址
    private String comaddress;

    //联系电话
    private String comphone;

    //座机
    private String camera;

    //公司简介
    private String present;

    //备注
    private String remark;
    //日期
    private Date addtime;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", comname='" + comname + '\'' +
                ", companyperson='" + companyperson + '\'' +
                ", comaddress='" + comaddress + '\'' +
                ", comphone='" + comphone + '\'' +
                ", camera='" + camera + '\'' +
                ", present='" + present + '\'' +
                ", remark='" + remark + '\'' +
                ", addtime=" + addtime +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComname() {
        return comname;
    }

    public void setComname(String comname) {
        this.comname = comname == null ? null : comname.trim();
    }

    public String getCompanyperson() {
        return companyperson;
    }

    public void setCompanyperson(String companyperson) {
        this.companyperson = companyperson == null ? null : companyperson.trim();
    }

    public String getComaddress() {
        return comaddress;
    }

    public void setComaddress(String comaddress) {
        this.comaddress = comaddress == null ? null : comaddress.trim();
    }

    public String getComphone() {
        return comphone;
    }

    public void setComphone(String comphone) {
        this.comphone = comphone == null ? null : comphone.trim();
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera == null ? null : camera.trim();
    }

    public String getPresent() {
        return present;
    }

    public void setPresent(String present) {
        this.present = present == null ? null : present.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

}
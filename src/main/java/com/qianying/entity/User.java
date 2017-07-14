package com.qianying.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

//db.mallUser.update({"phone":"18888888888"},{"$set":{"email":"haha12345678987456325565225525@qq.com"}},false,true)
//db.mallUser.update({"phone":"18888888888"},{"$set":{"name":"买光你茶叶"}},false,true)
//db.mallUser.update({},{"$set":{"becomeMemberDate":new Date("2016-10-03")}},false,true)
//db.mallUser.update({},{"$set":{"directSaleMember":true}},false,true)

//db.mallUser.insert({"password" : "96e79218965eb72c92a549dd5a330112","phone" : "13000000000","registerInviteCode" : "111111","activated" : true,"directSaleMember":true,"becomeMemberDate" : new Date("2016-10-03")})
//db.mallUser.insert({"password" : "96e79218965eb72c92a549dd5a330112","phone" : "13666666666","registerInviteCode" : "111111","activated" : true,"becomeMemberDate" : new Date("2016-10-03")})
//db.mallUser.update({"phone":"13666666666"},{"$set":{"membershipPath" : "/57ac237d2f02c8fa50a9b5f9/57b8c0ed2a0a9820f0a2e6cf/57f3d8413c46b7660c653942"}},false,true)
//db.mallUser.update({"phone":"13000000000"},{"$set":{"membershipPath" : "/57ac237d2f02c8fa50a9b5f9/57f3df3d3c46b7660c653943"}},false,true)
//db.mallUser.find({ "directSaleMember" : true , "becomeMemberDate" : { "$gte" : new Date("2016-10-13T03:59:59.996Z") , "$lt" : new Date("2016-10-13T04:00:00.996Z")}})
//db.mallUser.find({$where:"this.membershipPath == '/'+this._id"})
/*
db.mallUser.insert({ "name" : "谢宇星(测试用)", "password" : "96e79218965eb72c92a549dd5a330112", "registerTime" : new Date(), "phone" : "18670057061", "directSaleMember" : false, "activated" : true, "market" : 0, "becomeMemberDate" : new Date("2017-05-03 13:05"), "lastActivateTime" : new Date()})
db.mallUser.update({"directSaleMember":true},{"$set":{"becomeMemberDate":new Date("2017-05-02 13:05")}},false,true)
db.mallUser.update({},{"$set":{"directSaleMember":true}},false,true)
db.mallUser.update({"phone":"13000000000"},{"$set":{"cost":8800,"directSaleMember":true,"becomeMemberDate" : new Date("2017-05-03 13:25")}},false,true)
db.mallUser.update({},{"$set":{"cost":8800,"directSaleMember":true,"becomeMemberDate" : new Date("2017-05-03 13:25")}},false,true)
 */
@Document(collection = "user")
public class User {

    @Id
    private String id;
    @Field(value = "name")
    @Length(min = 2, max = 20)
    private String name;
    @Field
    private String realName;
    @Field(value = "sex")
    private String sex;
    @Field(value = "height")
    private Integer height;
    @Length(min = 6)
    @Field("password")
    private String password;
    @Field("email")
    @Email
    @Indexed
    private String email;
    @Field(value = "userCategory")
    private String userCategory;//1注册用户 2,。经销商
    //    @DBRef private Set<Address> address;
    @Field("registerTime")
    private Date registerTime;
    @Field("lastActivateTime")
    private Date lastActivateTime;
    @Field("phone")
    private String phone;
    private String loginStatus;

    @Field(value = "addresses")
    private String[] addresses;
    @Field
    private Boolean disabled;//禁用
    @Field(value = "idCardNo")
    private String idCardNo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserCategory() {
        return userCategory;
    }

    public void setUserCategory(String userCategory) {
        this.userCategory = userCategory;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Date getLastActivateTime() {
        return lastActivateTime;
    }

    public void setLastActivateTime(Date lastActivateTime) {
        this.lastActivateTime = lastActivateTime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(String loginStatus) {
        this.loginStatus = loginStatus;
    }

    public String[] getAddresses() {
        return addresses;
    }

    public void setAddresses(String[] addresses) {
        this.addresses = addresses;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }
}

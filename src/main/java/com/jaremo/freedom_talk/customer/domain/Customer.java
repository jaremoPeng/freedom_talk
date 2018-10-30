package com.jaremo.freedom_talk.customer.domain;

import com.jaremo.freedom_talk.background.domain.Question;

import java.util.Objects;

/**
 * @描述: 客户类
 * @Author: pyj
 * @DateTime: 2018/10/30 0030--下午 6:40
 */
public class Customer {

    private String id; // id
    private String loginName; // 登录名
    private String password; // 登录密码
    private String email; // 邮箱地址
    private Integer type; // 客户类型
    private String img; // 客户头像
    private String suggest; // 个性签名
    private String name; // 昵称
    private String sex; // 性别
    private Integer age; // 年龄
    private String birthdate; // 出生日期
    private Question question; // 问题
    private String answer; // 验证问题的答案
    private Integer fansNum; // 粉丝数
    private Integer followNum; // 关注数
    private Integer isUnuse; // 是否禁用
    private Integer isBm; // 是否为版主

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", type=" + type +
                ", img='" + img + '\'' +
                ", suggest='" + suggest + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", birthdate='" + birthdate + '\'' +
                ", question=" + question +
                ", answer='" + answer + '\'' +
                ", fansNum=" + fansNum +
                ", followNum=" + followNum +
                ", isUnuse=" + isUnuse +
                ", isBm=" + isBm +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) &&
                Objects.equals(loginName, customer.loginName) &&
                Objects.equals(password, customer.password) &&
                Objects.equals(email, customer.email) &&
                Objects.equals(type, customer.type) &&
                Objects.equals(img, customer.img) &&
                Objects.equals(suggest, customer.suggest) &&
                Objects.equals(name, customer.name) &&
                Objects.equals(sex, customer.sex) &&
                Objects.equals(age, customer.age) &&
                Objects.equals(birthdate, customer.birthdate) &&
                Objects.equals(question, customer.question) &&
                Objects.equals(answer, customer.answer) &&
                Objects.equals(fansNum, customer.fansNum) &&
                Objects.equals(followNum, customer.followNum) &&
                Objects.equals(isUnuse, customer.isUnuse) &&
                Objects.equals(isBm, customer.isBm);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, loginName, password, email, type, img, suggest, name, sex, age, birthdate, question, answer, fansNum, followNum, isUnuse, isBm);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getSuggest() {
        return suggest;
    }

    public void setSuggest(String suggest) {
        this.suggest = suggest;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getFansNum() {
        return fansNum;
    }

    public void setFansNum(Integer fansNum) {
        this.fansNum = fansNum;
    }

    public Integer getFollowNum() {
        return followNum;
    }

    public void setFollowNum(Integer followNum) {
        this.followNum = followNum;
    }

    public Integer getIsUnuse() {
        return isUnuse;
    }

    public void setIsUnuse(Integer isUnuse) {
        this.isUnuse = isUnuse;
    }

    public Integer getIsBm() {
        return isBm;
    }

    public void setIsBm(Integer isBm) {
        this.isBm = isBm;
    }
}

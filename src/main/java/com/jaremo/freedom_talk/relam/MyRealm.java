package com.jaremo.freedom_talk.relam;

import com.jaremo.freedom_talk.customer.dao.CustomerDao;
import com.jaremo.freedom_talk.customer.domain.Customer;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.Sha256CredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * @描述: 自定义relam类
 * @Author: pyj
 * @DateTime: 2018/10/26 0026--下午 3:55
 */
@Component
public class MyRealm extends AuthorizingRealm{

    @Autowired
    private CustomerDao customerDao;

    public MyRealm(){
        this.setCredentialsMatcher(new Sha256CredentialsMatcher()); // 设置加密类型
    }

    /*
        授权
            多表查询出该用户的角色以及权限
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String userName = principalCollection.getPrimaryPrincipal().toString();
//        Set<String> roles = userMapper.queryRoleByUserName(userName);
//        Set<String> perms = userMapper.queryPermByUserName(userName);

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
//        authorizationInfo.setRoles(roles);
//        authorizationInfo.setStringPermissions(perms);
        return authorizationInfo;
    }

    /*
        认证
            controller层传入参数 与数据库的中的数据进行比较
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal(); // 拿到用户传进来的用户名
        Customer tempUser = customerDao.findCustomerByLoginName(username);
        if(tempUser!=null){
            SimpleAccount simpleAccount = new SimpleAccount(username,tempUser.getPassword(),"myRealm");
            simpleAccount.setCredentialsSalt( ByteSource.Util.bytes(tempUser.getId())); // 解密
            return simpleAccount;
        }
        return null;
    }
}

package com.jaremo.freedom_talk.relam;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * @描述: 自定义relam类
 * @Author: pyj
 * @DateTime: 2018/10/26 0026--下午 3:55
 */
@Component
public class MyRealm extends AuthorizingRealm{

//    @Autowired
//    private UserMapper userMapper;

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
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
//        User tempUser = userMapper.queryUserByUserName(token.getUsername());
//        if(tempUser!=null && tempUser.getPassword().equals(new String(token.getPassword()))){
//            SimpleAccount sa = new SimpleAccount(token.getUsername(),token.getPassword(),"MyRealm");
//            return sa;
//        }
        return null;
    }
}

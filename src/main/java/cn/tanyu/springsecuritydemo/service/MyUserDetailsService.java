package cn.tanyu.springsecuritydemo.service;

import cn.tanyu.springsecuritydemo.entity.Role;
import cn.tanyu.springsecuritydemo.entity.SecurityUser;
import cn.tanyu.springsecuritydemo.entity.User;
import cn.tanyu.springsecuritydemo.entity.UserRole;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author tanyu
 * @version 1.0
 * @description: TODO
 * @date 2020/11/15 10:40 上午
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserRoleService userRoleService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getOne(Wrappers.<User>lambdaQuery().eq(User::getUsername, username));
        List<UserRole> userRoleList = userRoleService.list(Wrappers.<UserRole>lambdaQuery().eq(UserRole::getUserId, user.getId()));
        List<Long> roleIds = userRoleList.stream().map(UserRole::getRoleId).collect(Collectors.toList());
        List<Role> roleList = roleService.list(Wrappers.<Role>lambdaQuery().in(Role::getId, roleIds));

//        List<RolePermission> rolePermissionList = rolePermissionService.list(Wrappers.<RolePermission>lambdaQuery().in(RolePermission::getRoleId, roleIds));
//        List<Long> permissionIds = rolePermissionList.stream().map(RolePermission::getPermissionId).collect(Collectors.toList());
//        List<Permission> permissionList = permissionService.list(Wrappers.<Permission>lambdaQuery().in(Permission::getId, permissionIds));

        SecurityUser securityUser = new SecurityUser();
        BeanUtils.copyProperties(user, securityUser);
        securityUser.setAuthorities(roleList.stream().map(e -> new SimpleGrantedAuthority(e.getName())).collect(Collectors.toList()));

        return securityUser;
    }
}


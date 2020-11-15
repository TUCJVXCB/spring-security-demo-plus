package cn.tanyu.springsecuritydemo.service.impl;

import cn.tanyu.springsecuritydemo.entity.Permission;
import cn.tanyu.springsecuritydemo.entity.Role;
import cn.tanyu.springsecuritydemo.mapper.PermissionMapper;
import cn.tanyu.springsecuritydemo.mapper.RoleMapper;
import cn.tanyu.springsecuritydemo.service.PermissionService;
import cn.tanyu.springsecuritydemo.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author tanyu
 * @version 1.0
 * @description: TODO
 * @date 2020/11/15 10:41 上午
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {
}

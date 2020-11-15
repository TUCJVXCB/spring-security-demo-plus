package cn.tanyu.springsecuritydemo.service.impl;

import cn.tanyu.springsecuritydemo.entity.User;
import cn.tanyu.springsecuritydemo.mapper.UserMapper;
import cn.tanyu.springsecuritydemo.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author tanyu
 * @version 1.0
 * @description: TODO
 * @date 2020/11/15 10:41 上午
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}

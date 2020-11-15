package cn.tanyu.springsecuritydemo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author tanyu
 * @version 1.0
 * @description: TODO
 * @date 2020/11/15 10:34 上午
 */
@Data
@TableName(value = "sec_role_permission")
public class RolePermission {

    private Long roleId;

    private Long permissionId;
}

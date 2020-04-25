-- 公司层面的关联关系
-- 公司 -> 组织（一对多）
-- 组织 -> 用户（一对多）
-- 岗位 -> 用户（多对多）

-- 系统层面的关联关系
-- 角色 -> 用户（多对多）
-- 用户 -> 项目（多对多）
-- 项目 -> 资源（一对多）

-- 权限控制
-- 角色 -> 组织（多对多）（数据权限的控制）（控制公司层面的数据，因为相同的岗位在不同的组织具有不同的职权，所以绑定在组织层级）
-- 角色 -> 资源（多对多）（资源权限的控制）

-- enterprise.sys_company definition

CREATE TABLE `sys_company` (
  `pk_company_id` varchar(32) NOT NULL COMMENT '公司ID',
  `company_code` varchar(16) NOT NULL COMMENT '公司代码',
  `company_name` varchar(32) NOT NULL COMMENT '公司名称',
  `company_name_en` varchar(32) DEFAULT NULL COMMENT '公司英文名称',
  `contact_person` varchar(16) DEFAULT NULL COMMENT '联系人',
  `contact_number` varchar(16) DEFAULT NULL COMMENT '联系电话',
  `contact_email` varchar(16) DEFAULT NULL COMMENT '联系邮箱',
  `sort` int(8) DEFAULT NULL COMMENT '排序规则',
  `create_id` varchar(32) NOT NULL COMMENT '创建人ID',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_id` varchar(32) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `data_status` varchar(8) NOT NULL DEFAULT 'Enable' COMMENT '数据状态 - Enable:启用,Disable:禁用',
  `is_delete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除 - 0：否，1：是',
  `version` int(8) NOT NULL DEFAULT '0' COMMENT '版本（乐观锁）',
  PRIMARY KEY (`pk_company_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='公司信息';


-- enterprise.sys_organization_type definition

CREATE TABLE `sys_organization_type` (
  `pk_organization_type_id` varchar(32) NOT NULL COMMENT '组织类型ID',
  `organization_type_code` varchar(16) NOT NULL COMMENT '组织类型代码',
  `organization_type_name` varchar(32) NOT NULL COMMENT '组织类型名称',
  `organization_type_name_en` varchar(32) DEFAULT NULL COMMENT '组织类型英文名称',
  `create_id` varchar(32) NOT NULL COMMENT '创建人ID',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_id` varchar(32) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `data_status` varchar(8) NOT NULL DEFAULT 'Enable' COMMENT '数据状态 - Enable:启用,Disable:禁用',
  `is_delete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除 - 0：否，1：是',
  `version` int(8) NOT NULL DEFAULT '0' COMMENT '版本（乐观锁）',
  PRIMARY KEY (`pk_organization_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='组织类型信息';


-- enterprise.sys_post definition

CREATE TABLE `sys_post` (
  `pk_post_id` varchar(32) NOT NULL COMMENT '岗位ID',
  `post_code` varchar(16) NOT NULL COMMENT '岗位代码',
  `post_name` varchar(32) NOT NULL COMMENT '岗位名称',
  `post_name_en` varchar(32) DEFAULT NULL COMMENT '岗位英文名称',
  `sort` int(8) DEFAULT NULL COMMENT '排序规则',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `create_id` varchar(32) NOT NULL COMMENT '创建人ID',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_id` varchar(32) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `data_status` varchar(8) NOT NULL DEFAULT 'Enable' COMMENT '数据状态 - Enable:启用,Disable:禁用',
  `is_delete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除 - 0：否，1：是',
  `version` int(8) NOT NULL DEFAULT '0' COMMENT '版本（乐观锁）',
  PRIMARY KEY (`pk_post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='岗位信息';


-- enterprise.sys_project definition

CREATE TABLE `sys_project` (
  `pk_project_id` varchar(32) NOT NULL COMMENT '项目ID',
  `project_code` varchar(16) NOT NULL COMMENT '项目代码',
  `project_name` varchar(32) NOT NULL COMMENT '项目名称',
  `create_id` varchar(32) NOT NULL COMMENT '创建人ID',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_id` varchar(32) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `data_status` varchar(8) NOT NULL DEFAULT 'Enable' COMMENT '数据状态 - Enable:启用,Disable:禁用',
  `is_delete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除 - 0：否，1：是',
  `version` int(8) NOT NULL DEFAULT '0' COMMENT '版本（乐观锁）',
  PRIMARY KEY (`pk_project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='项目信息';


-- enterprise.sys_role definition

CREATE TABLE `sys_role` (
  `pk_role_id` varchar(32) NOT NULL COMMENT '角色ID',
  `role_code` varchar(16) NOT NULL COMMENT '角色代码',
  `role_name` varchar(32) NOT NULL COMMENT '角色名称',
  `role_name_en` varchar(32) DEFAULT NULL COMMENT '角色英文名称',
  `sort` int(8) DEFAULT NULL COMMENT '排序规则',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `data_auth_type` varchar(8) NOT NULL COMMENT '数据权限类型',
  `resource_auth_type` varchar(8) NOT NULL COMMENT '资源权限类型',
  `create_id` varchar(32) NOT NULL COMMENT '创建人ID',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_id` varchar(32) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `data_status` varchar(8) NOT NULL DEFAULT 'Enable' COMMENT '数据状态 - Enable:启用,Disable:禁用',
  `is_delete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除 - 0：否，1：是',
  `version` int(8) NOT NULL DEFAULT '0' COMMENT '版本（乐观锁）',
  PRIMARY KEY (`pk_role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色信息';


-- enterprise.sys_organization definition

CREATE TABLE `sys_organization` (
  `pk_organization_id` varchar(32) NOT NULL COMMENT '组织ID',
  `organization_code` varchar(16) NOT NULL COMMENT '组织代码',
  `organization_name` varchar(32) NOT NULL COMMENT '组织名称',
  `organization_name_en` varchar(32) DEFAULT NULL COMMENT '组织英文名称',
  `sort` int(8) DEFAULT NULL COMMENT '排序规则',
  `fk_company_id` varchar(32) NOT NULL COMMENT '公司ID',
  `fk_organization_type_id` varchar(32) NOT NULL COMMENT '组织类型ID',
  `sr_organization_id` varchar(32) DEFAULT NULL COMMENT '上级组织ID',
  `sr_organization_id_path` varchar(160) NOT NULL COMMENT '上级组织ID路径',
  `is_top` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否顶级 - 0：否，1：是',
  `create_id` varchar(32) NOT NULL COMMENT '创建人ID',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_id` varchar(32) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `data_status` varchar(8) NOT NULL DEFAULT 'Enable' COMMENT '数据状态 - Enable:启用,Disable:禁用',
  `is_delete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除 - 0：否，1：是',
  `version` int(8) NOT NULL DEFAULT '0' COMMENT '版本（乐观锁）',
  PRIMARY KEY (`pk_organization_id`),
  KEY `sys_organization_fk` (`fk_company_id`),
  KEY `sys_organization_fk_1` (`fk_organization_type_id`),
  KEY `sys_organization_fk_2` (`sr_organization_id`),
  CONSTRAINT `sys_organization_fk` FOREIGN KEY (`fk_company_id`) REFERENCES `sys_company` (`pk_company_id`),
  CONSTRAINT `sys_organization_fk_1` FOREIGN KEY (`fk_organization_type_id`) REFERENCES `sys_organization_type` (`pk_organization_type_id`),
  CONSTRAINT `sys_organization_fk_2` FOREIGN KEY (`sr_organization_id`) REFERENCES `sys_organization` (`pk_organization_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='组织信息';


-- enterprise.sys_resource definition

CREATE TABLE `sys_resource` (
  `pk_resource_id` varchar(32) NOT NULL COMMENT '资源ID',
  `resource_type` varchar(8) NOT NULL COMMENT '资源类型',
  `resource_name` varchar(16) NOT NULL COMMENT '资源名称',
  `resource_path` varchar(64) DEFAULT NULL COMMENT '资源路径',
  `permission` varchar(16) DEFAULT NULL COMMENT '权限',
  `fk_project_id` varchar(32) NOT NULL COMMENT '项目ID',
  `sr_resource_id` varchar(32) DEFAULT NULL COMMENT '上级资源ID',
  `sr_resource_id_path` varchar(160) NOT NULL COMMENT '上级资源ID路径',
  `is_top` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否顶级 - 0：否，1：是',
  `open_type` varchar(8) DEFAULT 'BOOKMARK' COMMENT '打开方式 - WINDOW:窗口,BOOKMARK:页签',
  `resource_icon` varchar(16) DEFAULT NULL COMMENT '资源ICON',
  `sort` int(8) DEFAULT NULL COMMENT '排序规则',
  `create_id` varchar(32) NOT NULL COMMENT '创建人ID',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_id` varchar(32) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `data_status` varchar(8) NOT NULL DEFAULT 'Enable' COMMENT '数据状态 - Enable:启用,Disable:禁用',
  `is_delete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除 - 0：否，1：是',
  `version` int(8) NOT NULL DEFAULT '0' COMMENT '版本（乐观锁）',
  PRIMARY KEY (`pk_resource_id`),
  KEY `sys_resource_fk` (`fk_project_id`),
  KEY `sys_resource_fk_1` (`sr_resource_id`),
  CONSTRAINT `sys_resource_fk` FOREIGN KEY (`fk_project_id`) REFERENCES `sys_project` (`pk_project_id`),
  CONSTRAINT `sys_resource_fk_1` FOREIGN KEY (`sr_resource_id`) REFERENCES `sys_resource` (`pk_resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='资源信息';


-- enterprise.sys_user definition

CREATE TABLE `sys_user` (
  `pk_user_id` varchar(32) NOT NULL COMMENT '用户ID',
  `user_code` varchar(16) NOT NULL COMMENT '用户代码',
  `user_name` varchar(32) NOT NULL COMMENT '用户名称',
  `account` varchar(8) NOT NULL COMMENT '账号',
  `password` varchar(8) NOT NULL COMMENT '密码',
  `fk_organization_id` varchar(32) NOT NULL COMMENT '组织ID',
  `user_name_en` varchar(32) DEFAULT NULL COMMENT '用户英文名称',
  `phone_number` varchar(11) DEFAULT NULL COMMENT '手机号',
  `email` varchar(32) DEFAULT NULL COMMENT '邮箱',
  `sex` varchar(1) DEFAULT NULL COMMENT '性别',
  `sort` int(8) DEFAULT NULL COMMENT '排序规则',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `create_id` varchar(32) NOT NULL COMMENT '创建人ID',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_id` varchar(32) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `data_status` varchar(8) NOT NULL DEFAULT 'Enable' COMMENT '数据状态 - Enable:启用,Disable:禁用',
  `is_delete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除 - 0：否，1：是',
  `version` int(8) NOT NULL DEFAULT '0' COMMENT '版本（乐观锁）',
  PRIMARY KEY (`pk_user_id`),
  KEY `sys_user_fk` (`fk_organization_id`),
  CONSTRAINT `sys_user_fk` FOREIGN KEY (`fk_organization_id`) REFERENCES `sys_organization` (`pk_organization_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户信息';


-- enterprise.re_sys_role_organization definition

CREATE TABLE `re_sys_role_organization` (
  `pk_re_role_organization_id` varchar(32) NOT NULL COMMENT '关联角色组织ID',
  `fk_role_id` varchar(32) NOT NULL COMMENT '角色ID',
  `fk_organization_id` varchar(32) NOT NULL COMMENT '组织ID',
  `create_id` varchar(32) NOT NULL COMMENT '创建人ID',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_id` varchar(32) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `data_status` varchar(8) NOT NULL DEFAULT 'Enable' COMMENT '数据状态 - Enable:启用,Disable:禁用',
  `is_delete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除 - 0：否，1：是',
  `version` int(8) NOT NULL DEFAULT '0' COMMENT '版本（乐观锁）',
  PRIMARY KEY (`pk_re_role_organization_id`),
  KEY `re_sys_role_organization_fk` (`fk_role_id`),
  KEY `re_sys_role_organization_fk_1` (`fk_organization_id`),
  CONSTRAINT `re_sys_role_organization_fk` FOREIGN KEY (`fk_role_id`) REFERENCES `sys_role` (`pk_role_id`),
  CONSTRAINT `re_sys_role_organization_fk_1` FOREIGN KEY (`fk_organization_id`) REFERENCES `sys_organization` (`pk_organization_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='关联角色组织信息';


-- enterprise.re_sys_role_resource definition

CREATE TABLE `re_sys_role_resource` (
  `pk_re_role_resource_id` varchar(32) NOT NULL COMMENT '关联角色资源ID',
  `fk_role_id` varchar(32) NOT NULL COMMENT '角色ID',
  `fk_resource_id` varchar(32) NOT NULL COMMENT '资源ID',
  `create_id` varchar(32) NOT NULL COMMENT '创建人ID',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_id` varchar(32) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `data_status` varchar(8) NOT NULL DEFAULT 'Enable' COMMENT '数据状态 - Enable:启用,Disable:禁用',
  `is_delete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除 - 0：否，1：是',
  `version` int(8) NOT NULL DEFAULT '0' COMMENT '版本（乐观锁）',
  PRIMARY KEY (`pk_re_role_resource_id`),
  KEY `re_sys_role_resource_fk` (`fk_role_id`),
  KEY `re_sys_role_resource_fk_1` (`fk_resource_id`),
  CONSTRAINT `re_sys_role_resource_fk` FOREIGN KEY (`fk_role_id`) REFERENCES `sys_role` (`pk_role_id`),
  CONSTRAINT `re_sys_role_resource_fk_1` FOREIGN KEY (`fk_resource_id`) REFERENCES `sys_resource` (`pk_resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='关联角色资源信息';


-- enterprise.re_sys_user_post definition

CREATE TABLE `re_sys_user_post` (
  `pk_re_user_post_id` varchar(32) NOT NULL COMMENT '关联用户岗位ID',
  `fk_user_id` varchar(32) NOT NULL COMMENT '用户ID',
  `fk_post_id` varchar(32) NOT NULL COMMENT '岗位ID',
  `create_id` varchar(32) NOT NULL COMMENT '创建人ID',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_id` varchar(32) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `data_status` varchar(8) NOT NULL DEFAULT 'Enable' COMMENT '数据状态 - Enable:启用,Disable:禁用',
  `is_delete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除 - 0：否，1：是',
  `version` int(8) NOT NULL DEFAULT '0' COMMENT '版本（乐观锁）',
  PRIMARY KEY (`pk_re_user_post_id`),
  KEY `re_sys_user_post_fk` (`fk_user_id`),
  KEY `re_sys_user_post_fk_1` (`fk_post_id`),
  CONSTRAINT `re_sys_user_post_fk` FOREIGN KEY (`fk_user_id`) REFERENCES `sys_user` (`pk_user_id`),
  CONSTRAINT `re_sys_user_post_fk_1` FOREIGN KEY (`fk_post_id`) REFERENCES `sys_post` (`pk_post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='关联用户岗位信息';


-- enterprise.re_sys_user_project definition

CREATE TABLE `re_sys_user_project` (
  `pk_re_user_project_id` varchar(32) NOT NULL COMMENT '关联用户项目ID',
  `fk_user_id` varchar(32) NOT NULL COMMENT '用户ID',
  `fk_project_id` varchar(32) NOT NULL COMMENT '项目ID',
  `create_id` varchar(32) NOT NULL COMMENT '创建人ID',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_id` varchar(32) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `data_status` varchar(8) NOT NULL DEFAULT 'Enable' COMMENT '数据状态 - Enable:启用,Disable:禁用',
  `is_delete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除 - 0：否，1：是',
  `version` int(8) NOT NULL DEFAULT '0' COMMENT '版本（乐观锁）',
  PRIMARY KEY (`pk_re_user_project_id`),
  KEY `re_sys_user_project_fk` (`fk_user_id`),
  KEY `re_sys_user_project_fk_1` (`fk_project_id`),
  CONSTRAINT `re_sys_user_project_fk` FOREIGN KEY (`fk_user_id`) REFERENCES `sys_user` (`pk_user_id`),
  CONSTRAINT `re_sys_user_project_fk_1` FOREIGN KEY (`fk_project_id`) REFERENCES `sys_project` (`pk_project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='关联用户项目信息';


-- enterprise.re_sys_user_role definition

CREATE TABLE `re_sys_user_role` (
  `pk_re_user_role_id` varchar(32) NOT NULL COMMENT '关联用户角色ID',
  `fk_user_id` varchar(32) NOT NULL COMMENT '用户ID',
  `fk_role_id` varchar(32) NOT NULL COMMENT '角色ID',
  `create_id` varchar(32) NOT NULL COMMENT '创建人ID',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_id` varchar(32) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `data_status` varchar(8) NOT NULL DEFAULT 'Enable' COMMENT '数据状态 - Enable:启用,Disable:禁用',
  `is_delete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除 - 0：否，1：是',
  `version` int(8) NOT NULL DEFAULT '0' COMMENT '版本（乐观锁）',
  PRIMARY KEY (`pk_re_user_role_id`),
  KEY `re_sys_user_role_fk` (`fk_user_id`),
  KEY `re_sys_user_role_fk_1` (`fk_role_id`),
  CONSTRAINT `re_sys_user_role_fk` FOREIGN KEY (`fk_user_id`) REFERENCES `sys_user` (`pk_user_id`),
  CONSTRAINT `re_sys_user_role_fk_1` FOREIGN KEY (`fk_role_id`) REFERENCES `sys_role` (`pk_role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='关联用户角色信息';
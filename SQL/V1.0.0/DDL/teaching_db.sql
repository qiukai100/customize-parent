-- 数据库定义语言
CREATE TABLE `tb_clazz` (
  `pk_clazz_id` varchar(32) NOT NULL COMMENT '主键',
  `create_id` varchar(32) NOT NULL COMMENT '创建人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `is_delete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除 - 0：否，1：是',
  `update_id` varchar(32) NOT NULL COMMENT '修改人',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `clazz_name` varchar(8) NOT NULL COMMENT '班级名称',
  PRIMARY KEY (`pk_clazz_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='班级';

CREATE TABLE `tb_grade` (
  `pk_grade_id` varchar(32) NOT NULL COMMENT '主键',
  `create_id` varchar(32) NOT NULL COMMENT '创建人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `is_delete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除 - 0：否，1：是',
  `update_id` varchar(32) NOT NULL COMMENT '修改人',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `grade_name` varchar(8) NOT NULL COMMENT '年级名称',
  `level` tinyint(1) NOT NULL COMMENT '等级（等级越小，年级越小）',
  PRIMARY KEY (`pk_grade_id`),
  UNIQUE KEY `UK_tml5au0ia081d6i4n28a2oqhg` (`level`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='年级';

CREATE TABLE `tb_school` (
  `pk_school_id` varchar(32) NOT NULL COMMENT '主键',
  `create_id` varchar(32) NOT NULL COMMENT '创建人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `is_delete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除 - 0：否，1：是',
  `update_id` varchar(32) NOT NULL COMMENT '修改人',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `address` varchar(128) NOT NULL COMMENT '学校地址',
  `build_date` datetime NOT NULL COMMENT '建校日期',
  `charge_person_name` varchar(8) NOT NULL COMMENT '负责人姓名',
  `charge_person_phone` int(11) NOT NULL COMMENT '负责人手机号',
  `pic_url` varchar(128) NOT NULL COMMENT '照片路径',
  `school_name` varchar(16) NOT NULL COMMENT '学校名称',
  PRIMARY KEY (`pk_school_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学校';

CREATE TABLE `tb_student` (
  `pk_stu_id` varchar(32) NOT NULL COMMENT '主键',
  `create_id` varchar(32) NOT NULL COMMENT '创建人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `is_delete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除 - 0：否，1：是',
  `update_id` varchar(32) NOT NULL COMMENT '修改人',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `born_date` datetime NOT NULL COMMENT '出生日期',
  `enter_school_date` datetime NOT NULL COMMENT '入学日期',
  `home_address` varchar(128) DEFAULT NULL COMMENT '家庭住址',
  `id_card` varchar(32) DEFAULT NULL COMMENT '身份证号',
  `leave_school_date` datetime DEFAULT NULL COMMENT '毕业（开除）日期',
  `name` varchar(8) NOT NULL COMMENT '姓名',
  `pic_url` varchar(128) NOT NULL COMMENT '照片路径',
  `sex` tinyint(1) NOT NULL COMMENT '性别 - 1：男，2：女',
  `stu_no` varchar(16) NOT NULL COMMENT '编号（yyMMddHHmmssSSS0）',
  PRIMARY KEY (`pk_stu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生';

CREATE TABLE `tb_teacher` (
  `pk_teacher_id` varchar(32) NOT NULL COMMENT '主键',
  `create_id` varchar(32) NOT NULL COMMENT '创建人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `is_delete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除 - 0：否，1：是',
  `update_id` varchar(32) NOT NULL COMMENT '修改人',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `born_date` datetime NOT NULL COMMENT '出生日期',
  `enter_school_date` datetime NOT NULL COMMENT '入校日期',
  `home_address` varchar(128) DEFAULT NULL COMMENT '家庭住址',
  `id_card` varchar(32) NOT NULL COMMENT '身份证号',
  `leave_school_date` datetime NOT NULL COMMENT '离校日期',
  `mobile_phone` int(11) NOT NULL COMMENT '手机号',
  `name` varchar(8) NOT NULL COMMENT '姓名',
  `pic_url` varchar(128) NOT NULL COMMENT '照片路径',
  `sex` tinyint(1) NOT NULL COMMENT '性别 - 1：男，2：女',
  `start_work_date` datetime NOT NULL COMMENT '开始工作日期',
  `teacher_no` varchar(16) NOT NULL COMMENT '编号（yyMMddHHmmssSSS1）',
  PRIMARY KEY (`pk_teacher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='老师';


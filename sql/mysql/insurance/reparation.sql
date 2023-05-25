-- ----------------------------
-- Table structure for 维修管理
-- ----------------------------
DROP TABLE IF EXISTS `insurance_reparation`;
CREATE TABLE `insurance_reparation`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '维修表单主键',
  `user_id` bigint NOT NULL COMMENT '申请人的用户编号',
  -- 业务字段
  `user_dept_id` bigint NOT NULL COMMENT '提交人所在单位',
  `user_nickname` varchar(63) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '报险人姓名',
  `user_mobile` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '报险人手机号码',
  `endusage_dept_id` bigint NOT NULL COMMENT '使用单位编号',
  `endusage_dept_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '使用单位',
  `endusage_dept_manager_id` bigint  COMMENT '使用单位负责人',
  `elevtr_id` bigint NOT NULL COMMENT '电梯id',
  `elevtr_number` varchar(63) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci  COMMENT '梯号',
  `maintain_dept_id` bigint NOT NULL COMMENT '维保单位编号',
  `maintain_dept_name` varchar(63) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci   COMMENT '维保单位',
  `registration_id` varchar(63) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci  COMMENT '注册代码',
  `total_price` decimal DEFAULT 0 COMMENT '配件总价格',
  
  -- 业务字段结束.
  `process_instance_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '流程实例的编号',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '电梯报修申请表';

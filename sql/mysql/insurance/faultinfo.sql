-- ----------------------------
-- Table structure for 维修管理
-- ----------------------------
DROP TABLE IF EXISTS `insurance_faultinfo`;
CREATE TABLE `insurance_faultinfo`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '故障信息主键',
  `reparation_id` bigint NOT NULL COMMENT '报修单号',
  -- 业务字段
  `community_pic` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci  COMMENT '小区照片',
  `unit_pic` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci  COMMENT '单元照片',
  `elevtr_pic` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci  COMMENT '电梯照片',
  `fault_pic` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci  COMMENT '故障现场照片',
  `fault_pic2` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci  COMMENT '故障现场照片2',
  `fault_pic3` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci  COMMENT '故障现场照片3',
  `fault_pic4` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci  COMMENT '故障现场照片4',
  -- 业务字段结束.
  `result` tinyint NOT NULL COMMENT '流程状态',
  `process_instance_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '流程实例的编号',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '故障信息子表';
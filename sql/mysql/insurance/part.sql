-- ----------------------------
-- Table structure for 维修管理
-- ----------------------------
DROP TABLE IF EXISTS `insurance_part`;
CREATE TABLE `insurance_part`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '报修零件主键',
  `reparation_id` bigint NOT NULL COMMENT '报修单号',
  -- 业务字段
  `part_name` varchar(200) NOT NULL COMMENT '配件名称',
  `part_unit_id` tinyint NOT NULL default 0 COMMENT '单位',
  `part_unit_pirce` decimal NOT NULL default 0  COMMENT '单价',
  `part_quantity` decimal NOT NULL default 0  COMMENT '数量',
  `part_total` decimal NOT NULL default 0  COMMENT '小计',
  -- 业务字段结束.
  `process_instance_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '流程实例的编号',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '报修零件子表';
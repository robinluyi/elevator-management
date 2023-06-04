UPDATE `ruoyi-vue-pro`.infra_file_config 
SET  config='{"@class":"cn.iocoder.yudao.framework.file.core.client.db.DBFileClientConfig","domain":"http://192.168.31.33:48080"}'
WHERE id=4;


INSERT INTO `ruoyi-vue-pro`.system_dict_data 
(sort, label, value, dict_type, status, color_type, css_class, 
remark, creator, create_time, updater, update_time, deleted) 
VALUES(30, '扩展属性制定的流程变量值', '22', 'bpm_task_assign_script', 0, '', '',
'任务分配自定义脚本 - 扩展属性制定的流程变量值', '103', '2023-05-26 00:54:24', '103', '2023-05-26 00:54:24', 0);



INSERT INTO `ruoyi-vue-pro`.system_dict_data (sort, label, value, dict_type, status, color_type, css_class, remark, creator, create_time, updater, update_time, deleted) 
VALUES(102, '已报案', '102', 'bpm_process_instance_result', 0, 'default', '', '', '1', '2023-05-29 14:57:26', '1', '2023-05-29 14:57:26', 0);

INSERT INTO `ruoyi-vue-pro`.system_dict_data (sort, label, value, dict_type, status, color_type, css_class, remark, creator, create_time, updater, update_time, deleted) 
VALUES(103, '已受理', '103', 'bpm_process_instance_result', 0, 'default', '', '', '1', '2023-05-29 14:57:26', '1', '2023-05-29 14:57:26', 0);

INSERT INTO `ruoyi-vue-pro`.system_dict_data (sort, label, value, dict_type, status, color_type, css_class, remark, creator, create_time, updater, update_time, deleted) 
VALUES(104, '待审核', '104', 'bpm_process_instance_result', 0, 'default', '', '', '1', '2023-05-29 14:57:26', '1', '2023-05-29 14:57:26', 0);

INSERT INTO `ruoyi-vue-pro`.system_dict_data (sort, label, value, dict_type, status, color_type, css_class, remark, creator, create_time, updater, update_time, deleted) 
VALUES(105, '已审核', '105', 'bpm_process_instance_result', 0, 'default', '', '', '1', '2023-05-29 14:57:26', '1', '2023-05-29 14:57:26', 0);

INSERT INTO `ruoyi-vue-pro`.system_dict_data (sort, label, value, dict_type, status, color_type, css_class, remark, creator, create_time, updater, update_time, deleted) 
VALUES(106, '待确认', '106', 'bpm_process_instance_result', 0, 'default', '', '', '1', '2023-05-29 14:57:26', '1', '2023-05-29 14:57:26', 0);

INSERT INTO `ruoyi-vue-pro`.system_dict_data (sort, label, value, dict_type, status, color_type, css_class, remark, creator, create_time, updater, update_time, deleted) 
VALUES(107, '已确认', '107', 'bpm_process_instance_result', 0, 'default', '', '', '1', '2023-05-29 14:57:26', '1', '2023-05-29 14:57:26', 0);

INSERT INTO `ruoyi-vue-pro`.system_dict_data (sort, label, value, dict_type, status, color_type, css_class, remark, creator, create_time, updater, update_time, deleted) 
VALUES(201, '待维修确认', '201', 'bpm_process_instance_result', 0, 'default', '', '', '1', '2023-05-29 14:57:26', '1', '2023-05-29 14:57:26', 0);

INSERT INTO `ruoyi-vue-pro`.system_dict_data (sort, label, value, dict_type, status, color_type, css_class, remark, creator, create_time, updater, update_time, deleted) 
VALUES(202, '待物业确认', '202', 'bpm_process_instance_result', 0, 'default', '', '', '1', '2023-05-29 14:57:26', '1', '2023-05-29 14:57:26', 0);


INSERT INTO `ruoyi-vue-pro`.system_menu
(id, name, permission, `type`, sort, parent_id, `path`, icon, component, component_name, status, visible, keep_alive, always_show, creator, create_time, updater, update_time, deleted)
VALUES(2162, '保险管理', '', 1, 110, 0, '/insurance', 'ep:office-building', '', '', 0, 1, 1, 1, '1', '2023-05-22 13:56:39', '1', '2023-05-22 14:52:58', 0);
INSERT INTO `ruoyi-vue-pro`.system_menu
(id, name, permission, `type`, sort, parent_id, `path`, icon, component, component_name, status, visible, keep_alive, always_show, creator, create_time, updater, update_time, deleted)
VALUES(2163, '保单管理', '', 2, 0, 2162, 'order', '', 'insurance/order/index', 'InsuranceOrder', 0, 1, 1, 1, '', '2023-05-22 06:38:25', '1', '2023-05-22 14:52:21', 0);
INSERT INTO `ruoyi-vue-pro`.system_menu
(id, name, permission, `type`, sort, parent_id, `path`, icon, component, component_name, status, visible, keep_alive, always_show, creator, create_time, updater, update_time, deleted)
VALUES(2164, '保单查询', 'insurance:order:query', 3, 1, 2163, '', '', '', NULL, 0, 1, 1, 1, '', '2023-05-22 06:38:25', '', '2023-05-22 06:38:25', 0);
INSERT INTO `ruoyi-vue-pro`.system_menu
(id, name, permission, `type`, sort, parent_id, `path`, icon, component, component_name, status, visible, keep_alive, always_show, creator, create_time, updater, update_time, deleted)
VALUES(2165, '保单创建', 'insurance:order:create', 3, 2, 2163, '', '', '', NULL, 0, 1, 1, 1, '', '2023-05-22 06:38:25', '', '2023-05-22 06:38:25', 0);
INSERT INTO `ruoyi-vue-pro`.system_menu
(id, name, permission, `type`, sort, parent_id, `path`, icon, component, component_name, status, visible, keep_alive, always_show, creator, create_time, updater, update_time, deleted)
VALUES(2166, '保单更新', 'insurance:order:update', 3, 3, 2163, '', '', '', NULL, 0, 1, 1, 1, '', '2023-05-22 06:38:25', '', '2023-05-22 06:38:25', 0);
INSERT INTO `ruoyi-vue-pro`.system_menu
(id, name, permission, `type`, sort, parent_id, `path`, icon, component, component_name, status, visible, keep_alive, always_show, creator, create_time, updater, update_time, deleted)
VALUES(2167, '保单删除', 'insurance:order:delete', 3, 4, 2163, '', '', '', NULL, 0, 1, 1, 1, '', '2023-05-22 06:38:25', '', '2023-05-22 06:38:25', 0);
INSERT INTO `ruoyi-vue-pro`.system_menu
(id, name, permission, `type`, sort, parent_id, `path`, icon, component, component_name, status, visible, keep_alive, always_show, creator, create_time, updater, update_time, deleted)
VALUES(2168, '保单导出', 'insurance:order:export', 3, 5, 2163, '', '', '', NULL, 0, 1, 1, 1, '', '2023-05-22 06:38:25', '', '2023-05-22 06:38:25', 0);
INSERT INTO `ruoyi-vue-pro`.system_menu
(id, name, permission, `type`, sort, parent_id, `path`, icon, component, component_name, status, visible, keep_alive, always_show, creator, create_time, updater, update_time, deleted)
VALUES(2169, '电梯报修申请管理', '', 2, 0, 2162, 'reparation', '', 'insurance/reparation/index', 'Reparation', 0, 1, 1, 1, '', '2023-05-25 06:09:43', '', '2023-05-25 06:09:43', 0);
INSERT INTO `ruoyi-vue-pro`.system_menu
(id, name, permission, `type`, sort, parent_id, `path`, icon, component, component_name, status, visible, keep_alive, always_show, creator, create_time, updater, update_time, deleted)
VALUES(2170, '电梯报修申请查询', 'insurance:reparation:query', 3, 1, 2169, '', '', '', NULL, 0, 1, 1, 1, '', '2023-05-25 06:09:43', '', '2023-05-25 06:09:43', 0);
INSERT INTO `ruoyi-vue-pro`.system_menu
(id, name, permission, `type`, sort, parent_id, `path`, icon, component, component_name, status, visible, keep_alive, always_show, creator, create_time, updater, update_time, deleted)
VALUES(2171, '电梯报修申请创建', 'insurance:reparation:create', 3, 2, 2169, '', '', '', NULL, 0, 1, 1, 1, '', '2023-05-25 06:09:43', '', '2023-05-25 06:09:43', 0);
INSERT INTO `ruoyi-vue-pro`.system_menu
(id, name, permission, `type`, sort, parent_id, `path`, icon, component, component_name, status, visible, keep_alive, always_show, creator, create_time, updater, update_time, deleted)
VALUES(2172, '电梯报修申请更新', 'insurance:reparation:update', 3, 3, 2169, '', '', '', NULL, 0, 1, 1, 1, '', '2023-05-25 06:09:43', '', '2023-05-25 06:09:43', 0);
INSERT INTO `ruoyi-vue-pro`.system_menu
(id, name, permission, `type`, sort, parent_id, `path`, icon, component, component_name, status, visible, keep_alive, always_show, creator, create_time, updater, update_time, deleted)
VALUES(2173, '电梯报修申请删除', 'insurance:reparation:delete', 3, 4, 2169, '', '', '', NULL, 0, 1, 1, 1, '', '2023-05-25 06:09:43', '', '2023-05-25 06:09:43', 0);
INSERT INTO `ruoyi-vue-pro`.system_menu
(id, name, permission, `type`, sort, parent_id, `path`, icon, component, component_name, status, visible, keep_alive, always_show, creator, create_time, updater, update_time, deleted)
VALUES(2174, '电梯报修申请导出', 'insurance:reparation:export', 3, 5, 2169, '', '', '', NULL, 0, 1, 1, 1, '', '2023-05-25 06:09:43', '', '2023-05-25 06:09:43', 0);
INSERT INTO `ruoyi-vue-pro`.system_menu
(id, name, permission, `type`, sort, parent_id, `path`, icon, component, component_name, status, visible, keep_alive, always_show, creator, create_time, updater, update_time, deleted)
VALUES(2175, '故障信息子表管理', '', 2, 0, 2162, 'faultinfo', '', 'insurance/faultinfo/index', 'Faultinfo', 0, 1, 1, 1, '', '2023-05-25 08:59:38', '', '2023-05-25 08:59:38', 0);
INSERT INTO `ruoyi-vue-pro`.system_menu
(id, name, permission, `type`, sort, parent_id, `path`, icon, component, component_name, status, visible, keep_alive, always_show, creator, create_time, updater, update_time, deleted)
VALUES(2176, '故障信息子表查询', 'insurance:faultinfo:query', 3, 1, 2175, '', '', '', NULL, 0, 1, 1, 1, '', '2023-05-25 08:59:39', '', '2023-05-25 08:59:39', 0);
INSERT INTO `ruoyi-vue-pro`.system_menu
(id, name, permission, `type`, sort, parent_id, `path`, icon, component, component_name, status, visible, keep_alive, always_show, creator, create_time, updater, update_time, deleted)
VALUES(2177, '故障信息子表创建', 'insurance:faultinfo:create', 3, 2, 2175, '', '', '', NULL, 0, 1, 1, 1, '', '2023-05-25 08:59:39', '', '2023-05-25 08:59:39', 0);
INSERT INTO `ruoyi-vue-pro`.system_menu
(id, name, permission, `type`, sort, parent_id, `path`, icon, component, component_name, status, visible, keep_alive, always_show, creator, create_time, updater, update_time, deleted)
VALUES(2178, '故障信息子表更新', 'insurance:faultinfo:update', 3, 3, 2175, '', '', '', NULL, 0, 1, 1, 1, '', '2023-05-25 08:59:39', '', '2023-05-25 08:59:39', 0);
INSERT INTO `ruoyi-vue-pro`.system_menu
(id, name, permission, `type`, sort, parent_id, `path`, icon, component, component_name, status, visible, keep_alive, always_show, creator, create_time, updater, update_time, deleted)
VALUES(2179, '故障信息子表删除', 'insurance:faultinfo:delete', 3, 4, 2175, '', '', '', NULL, 0, 1, 1, 1, '', '2023-05-25 08:59:39', '', '2023-05-25 08:59:39', 0);
INSERT INTO `ruoyi-vue-pro`.system_menu
(id, name, permission, `type`, sort, parent_id, `path`, icon, component, component_name, status, visible, keep_alive, always_show, creator, create_time, updater, update_time, deleted)
VALUES(2180, '故障信息子表导出', 'insurance:faultinfo:export', 3, 5, 2175, '', '', '', NULL, 0, 1, 1, 1, '', '2023-05-25 08:59:39', '', '2023-05-25 08:59:39', 0);
INSERT INTO `ruoyi-vue-pro`.system_menu
(id, name, permission, `type`, sort, parent_id, `path`, icon, component, component_name, status, visible, keep_alive, always_show, creator, create_time, updater, update_time, deleted)
VALUES(2181, '报修零件子表管理', '', 2, 0, 2162, 'part', '', 'insurance/part/index', 'Part', 0, 1, 1, 1, '', '2023-05-25 09:00:01', '1', '2023-05-25 17:11:58', 0);
INSERT INTO `ruoyi-vue-pro`.system_menu
(id, name, permission, `type`, sort, parent_id, `path`, icon, component, component_name, status, visible, keep_alive, always_show, creator, create_time, updater, update_time, deleted)
VALUES(2182, '报修零件子表查询', 'insurance:part:query', 3, 1, 2181, '', '', '', NULL, 0, 1, 1, 1, '', '2023-05-25 09:00:01', '', '2023-05-25 09:00:01', 0);
INSERT INTO `ruoyi-vue-pro`.system_menu
(id, name, permission, `type`, sort, parent_id, `path`, icon, component, component_name, status, visible, keep_alive, always_show, creator, create_time, updater, update_time, deleted)
VALUES(2183, '报修零件子表创建', 'insurance:part:create', 3, 2, 2181, '', '', '', NULL, 0, 1, 1, 1, '', '2023-05-25 09:00:01', '', '2023-05-25 09:00:01', 0);
INSERT INTO `ruoyi-vue-pro`.system_menu
(id, name, permission, `type`, sort, parent_id, `path`, icon, component, component_name, status, visible, keep_alive, always_show, creator, create_time, updater, update_time, deleted)
VALUES(2184, '报修零件子表更新', 'insurance:part:update', 3, 3, 2181, '', '', '', NULL, 0, 1, 1, 1, '', '2023-05-25 09:00:01', '', '2023-05-25 09:00:01', 0);
INSERT INTO `ruoyi-vue-pro`.system_menu
(id, name, permission, `type`, sort, parent_id, `path`, icon, component, component_name, status, visible, keep_alive, always_show, creator, create_time, updater, update_time, deleted)
VALUES(2185, '报修零件子表删除', 'insurance:part:delete', 3, 4, 2181, '', '', '', NULL, 0, 1, 1, 1, '', '2023-05-25 09:00:01', '', '2023-05-25 09:00:01', 0);
INSERT INTO `ruoyi-vue-pro`.system_menu
(id, name, permission, `type`, sort, parent_id, `path`, icon, component, component_name, status, visible, keep_alive, always_show, creator, create_time, updater, update_time, deleted)
VALUES(2186, '报修零件子表导出', 'insurance:part:export', 3, 5, 2181, '', '', '', NULL, 0, 1, 1, 1, '', '2023-05-25 09:00:01', '', '2023-05-25 09:00:01', 0);
INSERT INTO `ruoyi-vue-pro`.system_menu
(id, name, permission, `type`, sort, parent_id, `path`, icon, component, component_name, status, visible, keep_alive, always_show, creator, create_time, updater, update_time, deleted)
VALUES(2193, '我的报修', '', 2, 5, 2162, 'mylist', '', 'insurance/reparationpart/index4user', '', 0, 1, 1, 1, '1', '2023-06-04 08:38:34', '1', '2023-06-04 08:38:34', 0);
INSERT INTO `ruoyi-vue-pro`.system_menu
(id, name, permission, `type`, sort, parent_id, `path`, icon, component, component_name, status, visible, keep_alive, always_show, creator, create_time, updater, update_time, deleted)
VALUES(2194, '物业报修', '', 2, 6, 2162, 'enduserlist', '', 'insurance/reparationpart/index4endusage', '', 0, 1, 1, 1, '1', '2023-06-04 09:44:43', '1', '2023-06-04 10:31:57', 0);
INSERT INTO `ruoyi-vue-pro`.system_menu
(id, name, permission, `type`, sort, parent_id, `path`, icon, component, component_name, status, visible, keep_alive, always_show, creator, create_time, updater, update_time, deleted)
VALUES(2195, '全部报修', '', 2, 7, 2162, 'alllist', '', 'insurance/reparationpart/index4insurance', '', 0, 1, 1, 1, '1', '2023-06-04 10:45:42', '1', '2023-06-04 10:51:27', 0);

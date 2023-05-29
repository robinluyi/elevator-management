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

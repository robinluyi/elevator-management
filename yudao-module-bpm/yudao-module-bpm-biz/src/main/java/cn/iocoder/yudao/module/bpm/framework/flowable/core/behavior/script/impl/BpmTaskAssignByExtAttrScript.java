package cn.iocoder.yudao.module.bpm.framework.flowable.core.behavior.script.impl;

import cn.iocoder.yudao.framework.common.util.collection.SetUtils;
import cn.iocoder.yudao.framework.common.util.number.NumberUtils;
import cn.iocoder.yudao.module.bpm.enums.definition.BpmTaskRuleScriptEnum;
import cn.iocoder.yudao.module.bpm.framework.flowable.core.behavior.script.BpmTaskAssignScript;
import cn.iocoder.yudao.module.bpm.service.task.BpmProcessInstanceService;
import cn.iocoder.yudao.module.bpm.service.task.BpmTaskService;
import org.flowable.bpmn.model.BpmnModel;
import org.flowable.bpmn.model.ExtensionAttribute;
import org.flowable.bpmn.model.ExtensionElement;
import org.flowable.bpmn.model.FlowElement;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.runtime.ProcessInstance;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;

/**
 * 根据流程定义的扩展属性 'assigneeVar' 得到一个key
 * 在流程变量里面使用这个key获取assignee id;
 *
 * @author 芋道源码
 */
@Component
public class BpmTaskAssignByExtAttrScript implements BpmTaskAssignScript {

    public static final String ASSIGEN_EXT_VAR_KEY = "assigneeVar";

    @Resource
    @Lazy // 解决循环依赖
    private BpmProcessInstanceService bpmProcessInstanceService;
    @Resource
    @Lazy // 解决循环依赖
    BpmTaskService bpmTaskService;

    @Override
    public Set<Long> calculateTaskCandidateUsers(DelegateExecution execution) {
        ProcessInstance processInstance = bpmProcessInstanceService.getProcessInstance(execution.getProcessInstanceId());
        Map<String, String> extAttrMap = bpmTaskService.getExtAttribute(execution);
        String key = extAttrMap.get(ASSIGEN_EXT_VAR_KEY);
        Long assignee = (Long) processInstance.getProcessVariables().get(key);
        return SetUtils.asSet(assignee);
    }

    @Override
    public BpmTaskRuleScriptEnum getEnum() {
        return BpmTaskRuleScriptEnum.ASSIGEN_EXT_VAR_KEY;
    }

}

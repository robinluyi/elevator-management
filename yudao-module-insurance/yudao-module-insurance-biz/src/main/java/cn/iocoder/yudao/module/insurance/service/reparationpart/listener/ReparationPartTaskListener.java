package cn.iocoder.yudao.module.insurance.service.reparationpart.listener;

import cn.iocoder.yudao.module.bpm.enums.task.TaskMonitorFieldConstants;
import cn.iocoder.yudao.module.bpm.service.definition.BpmProcessDefinitionService;
import cn.iocoder.yudao.module.bpm.service.task.BpmProcessInstanceService;
import cn.iocoder.yudao.module.bpm.service.task.BpmTaskService;
import cn.iocoder.yudao.module.insurance.dal.dataobject.reparation.ReparationDO;
import cn.iocoder.yudao.module.insurance.dal.mysql.reparation.ReparationMapper;
import cn.iocoder.yudao.module.insurance.service.reparationpart.ReparationPartService;
import com.google.common.collect.ImmutableSet;
import org.flowable.common.engine.api.delegate.event.FlowableEngineEntityEvent;
import org.flowable.common.engine.api.delegate.event.FlowableEngineEventType;
import org.flowable.common.engine.impl.event.FlowableEntityEventImpl;
import org.flowable.engine.delegate.event.AbstractFlowableEngineEventListener;
import org.flowable.engine.delegate.event.impl.FlowableEntityWithVariablesEventImpl;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.service.impl.persistence.entity.TaskEntityImpl;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.Map;
import java.util.Set;

@Component
public class ReparationPartTaskListener extends AbstractFlowableEngineEventListener {
    
    @Resource
    @Lazy
    private ReparationPartService reparationPartService;
    @Resource
    @Lazy
    private BpmProcessInstanceService processInstanceService;
    @Lazy
    @Resource
    private BpmProcessDefinitionService bpmDefinitionService;
    @Resource
    @Lazy
    private BpmTaskService bpmTaskService;
    @Lazy
    @Resource
    private ReparationMapper reparationMapper;

    public static final Set<FlowableEngineEventType> TASK_EVENTS = ImmutableSet.<FlowableEngineEventType>builder()
            .add(FlowableEngineEventType.TASK_ASSIGNED)
            .add(FlowableEngineEventType.TASK_CREATED)
            .add(FlowableEngineEventType.TASK_COMPLETED)
            .build();

    public ReparationPartTaskListener(){
        super(TASK_EVENTS);
    }

    @Override
    protected void taskCreated(FlowableEngineEntityEvent event) {
        super.taskCreated(event);
        if (find(event)) {
            setMarkToBizTableOnCreate(event);
        }
    }

    @Override
    protected void taskAssigned(FlowableEngineEntityEvent event) {
        super.taskAssigned(event);
    }

    @Override
    protected void taskCompleted(FlowableEngineEntityEvent event) {
        super.taskCompleted(event);
        if (find(event)) {
            setMarkToBizTableOnComplated(event);
        }
    }

    private boolean find(FlowableEngineEntityEvent event) {
        //String taskId = ((TaskEntityImpl) ((FlowableEntityWithVariablesEventImpl) event).getEntity()).getId();
        ProcessDefinition processDefinition = bpmDefinitionService.getProcessDefinition(event.getProcessDefinitionId());
        return reparationPartService.PROCESS_KEY.equals(processDefinition.getKey());
    }

    private void setMarkToBizTableOnComplated(@NotNull FlowableEngineEntityEvent event) {
        String taskDefinitionKey = ((TaskEntityImpl) ((FlowableEntityWithVariablesEventImpl) event).getEntity()).getTaskDefinitionKey();
        Map variables = bpmTaskService.getExtAttribute(event.getProcessDefinitionId(),taskDefinitionKey);
        String marks = (String) variables.get(TaskMonitorFieldConstants.FIELD_MARKS_ON_COMPLETED);
        marks = StringUtils.hasText(marks)? marks:"";
        ProcessInstance processInstance = processInstanceService.getProcessInstance( event.getProcessInstanceId());
        reparationMapper.updateById(new ReparationDO().setId( Long.parseLong(processInstance.getBusinessKey())).setMarks(marks));
    }
    private void setMarkToBizTableOnCreate(@NotNull FlowableEngineEntityEvent event) {
        String taskDefinitionKey = ((TaskEntityImpl) ((FlowableEntityEventImpl) event).getEntity()).getTaskDefinitionKey();
        Map variables = bpmTaskService.getExtAttribute(event.getProcessDefinitionId(),taskDefinitionKey);
        String marks = (String) variables.get(TaskMonitorFieldConstants.FIELD_MARKS_ON_CREATED);
        marks = StringUtils.hasText(marks)? marks:"";
        ProcessInstance processInstance = processInstanceService.getProcessInstance( event.getProcessInstanceId());
        reparationMapper.updateById(new ReparationDO().setId( Long.parseLong(processInstance.getBusinessKey())).setMarks(marks));
    }

}

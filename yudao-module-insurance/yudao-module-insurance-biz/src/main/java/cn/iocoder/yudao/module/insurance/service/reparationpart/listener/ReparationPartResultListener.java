package cn.iocoder.yudao.module.insurance.service.reparationpart.listener;

import cn.iocoder.yudao.module.bpm.framework.bpm.core.event.BpmProcessInstanceResultEvent;
import cn.iocoder.yudao.module.bpm.framework.bpm.core.event.BpmProcessInstanceResultEventListener;
import cn.iocoder.yudao.module.insurance.service.reparationpart.ReparationPartService;
import cn.iocoder.yudao.module.insurance.service.reparationpart.ReparationPartServiceImpl;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class ReparationPartResultListener extends BpmProcessInstanceResultEventListener {
    @Resource
    ReparationPartService reparationPartService;

    @Override
    protected String getProcessDefinitionKey() {
        return ReparationPartServiceImpl.PROCESS_KEY;
    }

    @Override
    protected void onEvent(BpmProcessInstanceResultEvent event) {
        reparationPartService.updateReparationPart(Long.parseLong(event.getBusinessKey()),event.getResult());
    }
}

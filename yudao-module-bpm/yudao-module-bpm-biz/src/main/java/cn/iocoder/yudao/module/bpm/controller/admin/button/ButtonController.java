package cn.iocoder.yudao.module.bpm.controller.admin.button;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.bpm.controller.admin.button.vo.InsuranceButtonRespVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "管理后台 - 按钮")
@RestController
@RequestMapping("/bpm/button")
@Validated
public class ButtonController {



    @GetMapping("/get")
    @Operation(summary = "获得按钮")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('bpm:process-instance:query')")
    public CommonResult<List<InsuranceButtonRespVO>> getFaultinfo(@RequestParam("id") Long id) {
        List<InsuranceButtonRespVO> list = new ArrayList<>();
        InsuranceButtonRespVO vo = new InsuranceButtonRespVO();
        vo.setId("1");
        vo.setType("success");
        vo.setIcon("ep:select");
        vo.setText("通过");
        vo.setPath("1");
        vo.setTask("reparationStep3");
        list.add(vo);

        vo = new InsuranceButtonRespVO();
        vo.setId("2");
        vo.setType("danger");
        vo.setIcon("ep:close");
        vo.setText("拒赔");
        vo.setPath("0");
        vo.setTask("reparationStep3");
        list.add(vo);

        vo = new InsuranceButtonRespVO();
        vo.setId("3");
        vo.setType("primary");
        vo.setIcon("ep:back");
        vo.setText("退回-物业确认");
        vo.setPath("-1");
        vo.setTask("reparationStep3");
        list.add(vo);

        vo = new InsuranceButtonRespVO();
        vo.setId("4");
        vo.setType("warning");
        vo.setIcon("ep:back");
        vo.setText("退回-维保确认");
        vo.setPath("-2");
        vo.setTask("reparationStep3");
        list.add(vo);

        return success(list);
    }


}

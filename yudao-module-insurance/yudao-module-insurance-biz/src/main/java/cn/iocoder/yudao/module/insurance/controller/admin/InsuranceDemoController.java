package cn.iocoder.yudao.module.insurance.controller.admin;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理保险 - 测试")
@RestController
@RequestMapping("/insurance/demo")
@Validated
public class InsuranceDemoController {
    @GetMapping("/get")
    @Operation(summary = "获得字典类型")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    //@PreAuthorize("@ss.hasPermission('infra:test-demo:query')")
    public CommonResult<String> getTestDemo(@RequestParam("id") Long id) {
        return success("OK");
    }
}

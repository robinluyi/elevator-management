package cn.iocoder.yudao.module.insurance.controller.admin.reparationpart.vo;
import cn.iocoder.yudao.module.insurance.controller.admin.part.vo.PartCreateReqVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.AssertTrue;
import java.util.List;

@Schema(description = "管理后台 - 请假申请创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ReparationPartCreateReqVO extends ReparationPartBaseVO {
    @Schema(description = "零件列表", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    public List<PartCreateReqVO> parts;
}

package cn.iocoder.yudao.module.insurance.controller.admin.reparationpart.vo;

import cn.iocoder.yudao.module.insurance.controller.admin.faultinfo.vo.FaultinfoCreateReqVO;
import cn.iocoder.yudao.module.insurance.controller.admin.part.vo.PartRespVO;
import cn.iocoder.yudao.module.insurance.controller.admin.reparation.vo.ReparationBaseVO;
import cn.iocoder.yudao.module.insurance.controller.admin.reparation.vo.ReparationUpdateReqVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.List;

@Schema(description = "管理后台 - 电梯报修申请更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ReparationPartUpdateReqVO extends ReparationUpdateReqVO {

    @Schema(description = "维修表单主键", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "维修表单主键不能为空")
    private Long id;
    @Schema(description = "零件列表", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    public List<PartRespVO> parts;
    @Schema(description = "故障列表", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    public List<FaultinfoCreateReqVO> faults;

}

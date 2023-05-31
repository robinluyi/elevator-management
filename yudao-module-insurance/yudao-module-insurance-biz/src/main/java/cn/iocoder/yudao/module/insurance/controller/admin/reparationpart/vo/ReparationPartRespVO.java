package cn.iocoder.yudao.module.insurance.controller.admin.reparationpart.vo;

import cn.iocoder.yudao.module.insurance.controller.admin.faultinfo.vo.FaultinfoCreateReqVO;
import cn.iocoder.yudao.module.insurance.controller.admin.faultinfo.vo.FaultinfoRespVO;
import cn.iocoder.yudao.module.insurance.controller.admin.part.vo.PartCreateReqVO;
import cn.iocoder.yudao.module.insurance.controller.admin.part.vo.PartRespVO;
import cn.iocoder.yudao.module.insurance.controller.admin.reparation.vo.ReparationRespVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 请假申请 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ReparationPartRespVO extends ReparationRespVO {

    @Schema(description = "零件列表", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    public List<PartRespVO> parts;
    @Schema(description = "故障列表", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    public List<FaultinfoRespVO> faults;
    /**
     * 用于流程相关的标记 使用逗号分割,例如:
     * "showEndUserPic,editEndUserPic,editForm" 等
     */
    public String marks;
    public String userDeptName;
    public String endusageDeptManagerName;
    public String endusageDeptManagerPhone;
}

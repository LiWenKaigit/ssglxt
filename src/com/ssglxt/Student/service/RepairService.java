package com.ssglxt.Student.service;

import com.ssglxt.domain.DO.ssglxt_repair;
import com.ssglxt.domain.VO.RepairVO;

public interface RepairService {

public	boolean addRepair(ssglxt_repair repair);//添加报修

public boolean updateRepair(ssglxt_repair repair);//修改报修

public boolean deleteRepair(String repairIDAll);//删除报修

public RepairVO getRepairListBysearchPage(RepairVO repairVO);//分页查找报修信息

public ssglxt_repair getRepairById(String repair_id);//根据id得到报修信息

public void getRepairOkListBysearchPage(RepairVO repairVO);//得到待处理的维修物品信息

public boolean updateRepairChange(String repair_id, String repair_status);//处理维修物品

}

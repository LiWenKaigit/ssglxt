package com.ssgxlt.Student.dao;

import com.ssglxt.domain.DO.ssglxt_repair;
import com.ssglxt.domain.VO.RepairVO;

public interface RepairDao {

public	boolean addRepair(ssglxt_repair repair);//添加报修

public boolean updateRepair(ssglxt_repair repair);//修改报修

public void deleteRepair(String repair_id);//删除报修

public int getCountRepairList(RepairVO repairVO);

public RepairVO getRepairListByPage(RepairVO repairVO);

public ssglxt_repair getRepairById(String repair_id);//根据id得到报修信息

public int getCountRepairOkList(RepairVO repairVO);

public void getRepairOkListByPage(RepairVO repairVO);

public boolean updateRepairChange(ssglxt_repair repair);//处理维修物品

}

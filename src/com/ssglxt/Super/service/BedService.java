package com.ssglxt.Super.service;

import java.util.List;

import com.ssglxt.domain.DO.ssglxt_bed;
import com.ssglxt.domain.VO.BedVO;

public interface BedService {

public 	boolean addBed(ssglxt_bed bed);//添加床位

public boolean updateBed(ssglxt_bed bed);//修改床位

public boolean deleteBed(String bedIDAll);//删除床位

public BedVO getBedListBysearchPage(BedVO bedVO);//分页查找床位信息

public ssglxt_bed getBedById(String bed_id);//根据id得到床位信息

public List<ssglxt_bed> getBedByDormitoryAndDormitoryBuilding(ssglxt_bed bed);//根据宿舍楼和宿舍房间得到床位

}

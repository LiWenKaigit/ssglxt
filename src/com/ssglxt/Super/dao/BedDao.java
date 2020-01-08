package com.ssglxt.Super.dao;

import java.util.List;

import com.ssglxt.domain.DO.ssglxt_bed;
import com.ssglxt.domain.VO.BedVO;

public interface BedDao {

public	boolean addBed(ssglxt_bed bed);//添加床位

public boolean updateBed(ssglxt_bed bed);//修改床位

public void deleteBed(String bed_id);//删除床位

public int getCountBedList(BedVO bedVO);

public BedVO getBedListByPage(BedVO bedVO);

public ssglxt_bed getBedById(String bed_id);//根据id得到床位信息

public List<ssglxt_bed> getBedByDormitoryAndDormitoryBuilding(ssglxt_bed bed);//根据宿舍楼和宿舍房间得到床位

}

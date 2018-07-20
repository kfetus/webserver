package base.biz.schedule.impl;

import java.util.List;
import java.util.Map;

import base.comm.dbio.ProjectMapper;

@ProjectMapper("myScheduleMapper")
public interface MyScheduleMapper {

	public List<Map<String, Object>> selectScheduleList(Map<String, Object> map) throws Exception;

}

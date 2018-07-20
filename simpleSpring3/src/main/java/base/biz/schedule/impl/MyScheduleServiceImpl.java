package base.biz.schedule.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import base.biz.schedule.MyScheduleService;

@Service("myScheduleService")
public class MyScheduleServiceImpl implements MyScheduleService {

	@Resource(name="myScheduleMapper")
	private MyScheduleMapper myScheduleMapper;
	
	@Override
	public List<Map<String, Object>> selectScheduleList(Map<String, Object> map) throws Exception {
//		return myScheduleDAO.selectScheduleList(map);
		return myScheduleMapper.selectScheduleList(map);
	}

	
}

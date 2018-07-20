package base.biz.schedule;

import java.util.List;
import java.util.Map;

public interface MyScheduleService {

	public List<Map<String,Object>> selectScheduleList(Map<String,Object> map) throws Exception;
}

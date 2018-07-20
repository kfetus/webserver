package base.biz.schedule;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyScheduleController {

	protected Log log = LogFactory.getLog(this.getClass());
	
	@Resource(name="myScheduleService")
	private MyScheduleService myScheduleService;
	
	/**
	 * 
	 * @param locale
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/scheduleList.do", method = RequestMethod.GET)
	public ModelAndView scheduleList(@RequestParam Map<String,Object> map) throws Exception {
		log.info("Welcome home! The client locale is {}.");
		log.debug("한글 로그 테스트"+map);
		
		ModelAndView mv = new ModelAndView("scheduleList");
		List<Map<String,Object>> returnList = myScheduleService.selectScheduleList(map); 
		mv.addObject("list", returnList );
		log.debug("##############"+returnList);
		return mv;
	}
}

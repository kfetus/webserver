package base.biz.schedule;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping(value = "/schedule")
@Controller
public class MyScheduleController {

	private Log log = LogFactory.getLog(this.getClass());
	
	@Resource(name="myScheduleService")
	private MyScheduleService myScheduleService;
	
	@RequestMapping(value = "/scheduleList.do")
	public ModelAndView scheduleList(@RequestParam Map<String,Object> map) throws Exception {
		log.info("Welcome home! The client locale is {}.");
		log.debug("한글 로그 테스트"+map);
		
		ModelAndView mv = new ModelAndView("biz/schedule/scheduleList");
		List<Map<String,Object>> returnList = myScheduleService.selectScheduleList(map); 
		mv.addObject("list", returnList );
		mv.addAllObjects(map);
		log.debug("##############"+returnList);
		return mv;
	}

	@RequestMapping(value = "/scheduleInsertView.do")
	public String scheduleInsertView(@RequestParam Map<String,Object> map, Model model) throws Exception {
		log.debug("등록 화면 이동"+map);
		
		model.addAllAttributes(map);

		return "biz/schedule/scheduleInsert";
	}

	@RequestMapping(value = "/scheduleInsert.do")
	public String scheduleInsert(@RequestParam Map<String,Object> map) throws Exception {
		log.debug("등록 테스트"+map);
		
		myScheduleService.insertSchedule(map);

//		return "forward:/schedule/scheduleList.do"; request,response 공유
		return "redirect:/schedule/scheduleList.do"; //새로운 request,response 생성
	}

	@RequestMapping(value = "/scheduleView.do")
	public String scheduleView(@RequestParam Map<String,Object> map, Model model) throws Exception {
		log.debug("view start="+map);
		
		String pk = (String) map.get("pk");
		List<Map<String,Object>> returnList = myScheduleService.selectScheduleView(pk); 
		model.addAttribute("list", returnList );
		
		ObjectMapper om = new ObjectMapper();
		String outJson = om.writeValueAsString(returnList);
		model.addAttribute("jsonList",outJson);

		log.debug("outJson="+outJson);
		log.debug("model="+model);

		return "biz/schedule/scheduleView";
	}
	
	@RequestMapping(value = "/scheduleUpdate.do")
	public String scheduleUpdate(@RequestParam Map<String,Object> map, Model model) throws Exception {
		log.debug("수정 테스트"+map);
		myScheduleService.updateSchedule(map);
		model.addAttribute("status", "ok");
		return "jsonView";
	}

	@RequestMapping(value = "/scheduleDelete.do")
	public String scheduleDelete(@RequestParam Map<String,Object> map, Model model) throws Exception {
		log.debug("수정 테스트"+map);
		myScheduleService.deleteSchedule(map);
		model.addAttribute("status", "ok");
		return "jsonView";
	}

	
}


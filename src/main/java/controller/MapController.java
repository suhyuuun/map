package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import dto.LibmapDTO;
import service.LibService;

// http://localhost:8090/myapp/map.do

@Controller
public class MapController {
	private LibService service;

	public MapController() {

	}

	public void setService(LibService service) {
		this.service = service;
	}

	@RequestMapping("/map.do")
	public String mapFrom() {
		return "map";
	}

	@ResponseBody
	@RequestMapping(value = "/libmap.do", method = RequestMethod.POST)
	public ModelAndView libraryMap(int pageNo, int pageSize, String keyword, ModelAndView mav) {
		int countAll = service.f_countAllProcess(keyword);
		int totalPage = countAll / pageSize;
		if ((countAll % pageSize) > 0)
			totalPage++;

		List<LibmapDTO> aList = service.f_listProcess(pageNo, pageSize, keyword);
		mav.addObject("aList", aList);
		mav.addObject("pageNo", pageNo);
		mav.addObject("totalPage", totalPage);
		mav.setViewName("jsonView");
		return mav;
	}

	@RequestMapping("/detailpage.do")
	public String detailpageMethod(HttpServletRequest httpServletRequest, Model model) {
		String latitude = httpServletRequest.getParameter("latitude");
		String longitude = httpServletRequest.getParameter("longitude");
		String foodtype = httpServletRequest.getParameter("foodtype");
		String img_url = httpServletRequest.getParameter("img_url");
		String foodstore_id = httpServletRequest.getParameter("foodstore_id");
		String foodstroe_num = httpServletRequest.getParameter("foodstroe_num");
		String road_name = httpServletRequest.getParameter("road_name");
		String rate = httpServletRequest.getParameter("rate");
		String openinghours = httpServletRequest.getParameter("openinghours");

		model.addAttribute("latitude", latitude);
		model.addAttribute("longitude", longitude);
		model.addAttribute("foodtype", foodtype);
		model.addAttribute("img_url", img_url);
		model.addAttribute("foodstore_id", foodstore_id);
		model.addAttribute("foodstroe_num", foodstroe_num);
		model.addAttribute("road_name", road_name);
		model.addAttribute("rate", rate);
		model.addAttribute("openinghours", openinghours);
		return "detailpage";
	}

}

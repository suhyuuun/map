package controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
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
	}//end libraryMap()

	@ResponseBody
	@RequestMapping(value = "/libmap.do", method = RequestMethod.POST)
	public ModelAndView libraryMap(int pageNo, int pageSize, String keyword, String res_num, ModelAndView mav) {
		int countAll = service.f_countAllProcess(keyword);
		int totalPage = countAll / pageSize;
		if ((countAll % pageSize) > 0)
			totalPage++;

		List<LibmapDTO> aList = service.f_listProcess(pageNo, pageSize, keyword, res_num);
		mav.addObject("aList", aList);
		mav.addObject("pageNo", pageNo);
		mav.addObject("totalPage", totalPage);
		mav.setViewName("jsonView");
		return mav;
	}//end libraryMap()

	@RequestMapping("/detailpage.do")
	public String detailpageMethod(HttpServletRequest httpServletRequest, Model model) throws UnsupportedEncodingException {
		String latitude = httpServletRequest.getParameter("latitude");
		String longitude = httpServletRequest.getParameter("longitude");
		String foodtype = httpServletRequest.getParameter("foodtype");
		String img_url = httpServletRequest.getParameter("img_url");
		String foodstore_id = httpServletRequest.getParameter("foodstore_id");
		String foodstroe_num = httpServletRequest.getParameter("foodstroe_num");
		String road_name = httpServletRequest.getParameter("road_name");
		String openinghours = httpServletRequest.getParameter("openinghours");
		String rate = httpServletRequest.getParameter("rate");
		String menu_namesearch = URLDecoder.decode(httpServletRequest.getParameter("menu_namesearch"), "UTF-8");
		String menu_pricesearch = URLDecoder.decode(httpServletRequest.getParameter("menu_pricesearch"), "UTF-8");

		model.addAttribute("latitude", latitude);
		model.addAttribute("longitude", longitude);
		model.addAttribute("foodtype", foodtype);
		model.addAttribute("img_url", img_url);
		model.addAttribute("foodstore_id", foodstore_id);
		model.addAttribute("foodstroe_num", foodstroe_num);
		model.addAttribute("road_name", road_name);
		model.addAttribute("openinghours", openinghours);
		model.addAttribute("rate", rate);
		model.addAttribute("menu_namesearch", menu_namesearch);
		model.addAttribute("menu_pricesearch",menu_pricesearch);
		
		return "detailpage";
	}//end detailpageMethod()
}
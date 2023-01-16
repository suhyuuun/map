package service;

import java.util.HashMap;
import java.util.List;

import dao.LibDao;
import dto.LibmapDTO;

public class LibServiceImp  implements LibService{
	private LibDao dao;
	
	public LibServiceImp() {
	
	}

	public void setDao(LibDao dao) {
		this.dao = dao;
	}

	@Override
	public List<LibmapDTO> f_listProcess(int pageNo, int pageSize, String keyword, String res_num) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("startpage", ((pageNo - 1) * pageSize)+1);
		map.put("endpage", pageNo * pageSize);
		map.put("keyword", keyword); //키워드
		map.put("res_num", res_num);
		return dao.lib_list(map);
	}

	@Override
	public int f_countAllProcess(String data) {
		return dao.lib_countAll(data);
	}

	@Override
	public List<LibmapDTO> f_list(LibmapDTO pv) {
		return dao.list(pv);
	}

	@Override
	public List<LibmapDTO> f_list_match(String res_num) {
		return dao.list_match(res_num);
	}
	
	
	
	
}

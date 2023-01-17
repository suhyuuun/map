package service;

import java.util.List;

import dto.LibmapDTO;

public interface LibService {
	public List<LibmapDTO> f_listProcess(int pageNo, int pageSize, String keyword, String res_num);
	public int f_countAllProcess(String data);
//	public List<LibmapDTO> f_list(LibmapDTO pv);
	public List<LibmapDTO> f_list_match(String res_num);

}

package dao;

import java.util.HashMap;
import java.util.List;

import dto.LibmapDTO;

public interface LibDao {
	public List<LibmapDTO> lib_list(HashMap<String, Object> map);
	public int lib_countAll(String data); 
	public List<LibmapDTO> list(LibmapDTO pv);
	public List<LibmapDTO> list_match(String res_num);
}

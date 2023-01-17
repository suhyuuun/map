package dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import dto.LibmapDTO;

public class LibDaoImp  implements LibDao{
	
	private SqlSessionTemplate sqlSession;
	
	public LibDaoImp() {
	
	}
	
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<LibmapDTO> lib_list(HashMap<String, Object> map) {
		return sqlSession.selectList("lib.lib_list", map);
	}

	@Override
	public int lib_countAll(String data) {
		return sqlSession.selectOne("lib.lib_countAll",data);
	}

//	@Override
//	public List<LibmapDTO> list(LibmapDTO pv) {
//		return sqlSession.selectList("lib.list",pv);
//	}

	@Override
	public List<LibmapDTO> list_match(String res_num) {
		return sqlSession.selectList("lib.list_match",res_num);
	}
}

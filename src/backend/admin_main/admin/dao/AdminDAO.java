package com.ict.project.admin.dao;

import java.util.List;

import com.ict.project.admin.vo.AdminVO;

public interface AdminDAO {
	public List<AdminVO> adminList(int offset, int limit);
	public int adminUpdate(AdminVO avo);
	public int adminDelete(AdminVO avo);
	public int adminInsert(AdminVO avo);
	public AdminVO adminDetail(String a_idx);
	public int adminCount();
	
		
}

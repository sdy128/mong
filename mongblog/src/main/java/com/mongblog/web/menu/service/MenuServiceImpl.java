package com.mongblog.web.menu.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.mongblog.web.menu.dao.MenuDAO;
import com.mongblog.web.menu.model.MenuVO;

@Service
public class MenuServiceImpl implements MenuService {

	@Inject
	private MenuDAO menuDAO;
	
	@Override
	public List<MenuVO> getMenuList() throws Exception {
		// TODO Auto-generated method stub
		return menuDAO.getMenuList();
	}

	@Override
	public void saveMenu(MenuVO menuVO) throws Exception {
		// TODO Auto-generated method stub
		menuDAO.saveMenu(menuVO);

	}

	@Override
	public void updateMenu(MenuVO menuVO) throws Exception {
		// TODO Auto-generated method stub
		menuDAO.updateMenu(menuVO);
	}

	@Override
	public void deleteMenu(String code) throws Exception {
		// TODO Auto-generated method stub
		menuDAO.deleteMenu(code);
	}

}

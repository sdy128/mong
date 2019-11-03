package com.mongblog.web.user.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.mongblog.web.user.dao.UserDAO;
import com.mongblog.web.user.model.UserVO;

@Repository
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Inject
	private UserDAO userDAO;
	
	@Override
	public List<UserVO> getUserList() throws Exception {
		return userDAO.getUserList();
	}

	@Override
	public UserVO getUserInfo(String uid) throws Exception {
		return userDAO.getUserInfo(uid);
	}

	@Override
	public void insertUser(UserVO userVO) throws Exception {
		userDAO.insertUser(userVO);

	}

	@Override
	public void updateUser(UserVO userVO) throws Exception {
		userDAO.updateUser(userVO);

	}

	@Override
	public void deleteUser(String uid) throws Exception {
		userDAO.deleteUser(uid);

	}

	@Override
	public boolean loginCheck(UserVO userVO) throws Exception {
		return userDAO.loginCheck(userVO);
	}

}

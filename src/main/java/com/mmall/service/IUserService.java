package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.User;

/**
 * Created by kexi955 on 4/23/2024.
 */
public interface IUserService {
      ServerResponse<User> login(String username, String password);


}

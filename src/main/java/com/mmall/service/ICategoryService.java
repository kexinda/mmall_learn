package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.Category;

import java.util.List;

/**
 * Created by kexi955 on 5/3/2024.
 */
public interface ICategoryService {
    ServerResponse addCategory(String categoryName, Integer parentID);
    ServerResponse updateCategoryName(Integer categoryId, String categoryName);
    ServerResponse<List<Category>> getChildrenParallelCategory(Integer categoryId);
    ServerResponse<List<Integer>> selectCategoryAndDeepChildrenCategory(Integer categoryID);

}

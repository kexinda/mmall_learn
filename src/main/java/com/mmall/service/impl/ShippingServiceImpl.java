package com.mmall.service.impl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.mmall.common.ServerResponse;
import com.mmall.dao.ShippingMapper;
import com.mmall.pojo.Shipping;
import com.mmall.service.IShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * Created by kexi955 on 5/8/2024.
 */
@Service("iShippingService")
public class ShippingServiceImpl implements IShippingService{
    @Autowired
    private ShippingMapper shippingMapper;


    public ServerResponse add(Integer userId, Shipping shipping){
        shipping.setUserId(userId);
        int rowCount = shippingMapper.insert(shipping);
        if(rowCount > 0){
              Map result = Maps.newHashMap();
              result.put("shippingId", shipping.getId());
              return ServerResponse.createBySuccessMessage("create new address success", result);

        }
        return ServerResponse.createByErrorMessage("create new address failed");
    }

    public ServerResponse<String> del(Integer userId, Integer shippingId){
        int resultCount = shippingMapper.deleteByShippingIdUserId(userId, shippingId);
        if(resultCount > 0){
            return ServerResponse.createBySuccessMessage("delete new address success");
        }
        return ServerResponse.createByErrorMessage("delete new address failed");
    }


    public ServerResponse update(Integer userId, Shipping shipping){
        shipping.setUserId(userId);
        int rowCount = shippingMapper.updateByShipping(shipping);
        if(rowCount > 0){
            return ServerResponse.createBySuccessMessage("update new address success");

        }
        return ServerResponse.createByErrorMessage("update new address failed");
    }

    public ServerResponse<Shipping> select(Integer userId, Integer shippingId){
        Shipping shipping = shippingMapper.selectByShippingIdUserId(userId, shippingId);
        if(shipping == null){
            return ServerResponse.createByErrorMessage("cannot found the address");
        }
        return ServerResponse.createBySuccessMessage("found new address success", shipping);
    }

    public ServerResponse<PageInfo> list(Integer userId, Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<Shipping> shippingList = shippingMapper.selectByUserId(userId);
        PageInfo pageInfo = new PageInfo(shippingList);
        return ServerResponse.createBySuccess(pageInfo);

    }


}

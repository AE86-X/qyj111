package com.ssm.service.impl;


import com.ssm.commons.APIURlUtils;


import com.ssm.commons.MD5Utils;
import com.ssm.dto.ResponseDto;
import com.ssm.service.UserService;
import com.ssm.utils.HttpClientUtils;
import com.ssm.utils.JsonUtils;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl  implements UserService {
    @Override
    public ResponseDto login(String userAccount, String password) {
        /**
         * HttpClient调用shop-api的接口
         */
        Map<String,String> map=new HashMap<>();
        map.put("userAccount",userAccount);
        map.put("password",MD5Utils.encrypt(password));
        String jsonStr = HttpClientUtils.post(APIURlUtils.LOGIN, map);
        System.out.println(jsonStr+"jsonStr");

        //把字符串转成java对象
        ResponseDto responseDto = JsonUtils.jsonToPojo(jsonStr, ResponseDto.class);

        return responseDto;
    }



}

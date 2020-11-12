package com.junyu.forum;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : xrj
 * @Date : 2020/9/30 13:55
 */
public class test {
    public static void main(String[] args) {
        Map<String ,Object> map = new HashMap<>();
        Map<String ,Object> map1 = new HashMap<>();

        map1.put("1",12312);
        map1.put("2",12312);
        map1.put("3",12312);
        map1.put("4",12312);

//        map.put("map1",map1);

        System.out.println(JSON.toJSONString(map.get("map1")));
        Map map2 = JSONObject.parseObject("{\"fd_3738da881c58ac\":\"\",\"fd_3738dd6829e498\":0.0,\"fd_3726ba4617a3ba\":1245.0,\"fd_37a6e52ff60678\":\"\",\"fd_3738dbb21b85c2\":1599408000000,\"fdId\":\"174de0bf6905b71a30febb242ce8d29e\",\"fd_3738daeebdf1f6\":\"sd\",\"fd_37a6e52defa40e\":\"sd\"}" ,Map.class);

        for (Object o:map2.values() ) {
            System.out.println(o);
        }
    }
}

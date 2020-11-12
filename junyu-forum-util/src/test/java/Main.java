import com.alibaba.fastjson.JSON;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : xrj
 * @Date : 2020/11/2 22:38
 */
public class Main {
    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,1);
        map.put(1,1);
        map.put(1,1);
        map.put(1,1);
        map.put(1,1);
        System.out.println(JSON.toJSONString(map));


        BigDecimal bigDecimal = new BigDecimal(0);
        bigDecimal.
    }
}

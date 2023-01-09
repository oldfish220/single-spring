package cn.oldfish.springframework.beans;

import java.util.HashMap;
import java.util.Map;

public class UserDao {

    private static Map<String, String> hashMap = new HashMap<>();

    public void initDataMethod(){
        System.out.println("执行：init-method");
        hashMap.put("001", "张三");
        hashMap.put("002", "李四");
        hashMap.put("003", "王五");
        hashMap.put("004", "赵六");
        hashMap.put("005", "田七");
        hashMap.put("006", "王八");
        hashMap.put("007", "oldfish");
    }

    public void destroyDataMethod(){
        System.out.println("执行：destroy-method");
        hashMap.clear();
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }

}

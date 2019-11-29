package com.meizhi.zDemo.hutoolUtilDemo;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.meizhi.model.Role;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonUtilDemo{
    public static void main(String[] args) {

        List<Role> roleList = new ArrayList<>();
        Role role = new Role();
        role.setRoleName("普通用户");
        Role role2= new Role();
        role2.setRoleName("管理员");
        roleList.add(role);
        roleList.add(role2);

        HashMap<String, Role> map = new HashMap<>();
        map.put("角色1", role);
        map.put("角色2", role2);

        HashMap<String, List<Role>> listMap = new HashMap<>();
        listMap.put("list_one", roleList);
        listMap.put("list_two", roleList);

        // bean -> json
        String roleStr = JSONUtil.toJsonStr(role);
        System.err.println(roleStr);

        //json -> bean
        Role roleBean = JSONUtil.toBean(roleStr, Role.class);
        System.err.println(roleBean);

        // List<Bean> -> json
        String ListJson = JSONUtil.toJsonStr(roleList);
        System.err.println(ListJson);

        // json -> List<Bean> ***
        List<Role> roleList1 = JSONUtil.toList(JSONUtil.parseArray(ListJson), Role.class);
        System.err.println(roleList1);

        // map<String,Object> -> json
        String mapJson = JSONUtil.toJsonStr(map);
        System.err.println(mapJson);

        // json -> map<String,Object>
        Map map1 = JSONUtil.toBean(mapJson, Map.class);
        System.err.println(map1);

        // map<String,List<Role>> -> json
        String listMapJson = JSONUtil.toJsonStr(listMap);
        System.err.println(listMapJson);

        // json -> map<String,List<Role>>
        Map map2 = JSONUtil.toBean(listMapJson, Map.class);
        System.err.println(map2);

        List list_one = (List) map2.get("list_one");
        System.out.println(list_one);

        JSONObject role4 = (JSONObject) list_one.get(1);
        Role role1 = JSONUtil.toBean(role4, Role.class);
        System.out.println(role1);


    }








}

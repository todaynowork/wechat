package com.tn.wechat.rest;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
//import java.util.Iterator;
import java.util.Map;
//import java.util.Set;

/**
 * Created by chengchao.dong on 9/13/2017.
 */

public class JsonTransfer {
    public static Map<String, Object> readJson2Map(String value) {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = value;
        Map<String, Object> maps = new HashMap();
        try {
            maps  = objectMapper.readValue(json, Map.class);
//            System.out.println("mapsize :" + maps.size());
//            Set<String> key = maps.keySet();
//            Iterator<String> iter = key.iterator();
//            while (iter.hasNext()) {
//                String field = iter.next();
//                System.out.println(field + ":" + maps.get(field));
//            }
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return maps;
    }

//    public static void main(String[] args){
//        readJson2Map();
//    }

}

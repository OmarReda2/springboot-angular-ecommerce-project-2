package com.myapp.ecommerce.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {

//    public static ResponseEntity<Object> generateResponse(HttpStatus status, Object responseObj, int count){
//
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("status", status.value());
//        map.put("count", count);
//        map.put("data", responseObj);
//
//        return new ResponseEntity<Object>(map, status);
//    }





//    public static ResponseEntity<Object> generateResponse(HttpStatus status, Object responseObj, int count ){
    public static ResponseEntity<Object> generateResponse(HttpStatus status, Object responseObj){


        ProductResponse res = new ProductResponse();
        res.set_embedded(responseObj);
//        res.setCount(count);
//        res.setStatus(HttpStatus.OK.value());

        return new ResponseEntity<>(res, status);
    }







//    public static ResponseEntity<Object> generateNamedResponse(HttpStatus status, Object responseObj, int count,  String dataName){
    public static ResponseEntity<Object> generateNamedResponse(HttpStatus status, Object responseObj,  String dataName){


        Map<String,Object> map = new HashMap<>();
        map.put(dataName, responseObj);

        ProductResponse res = new ProductResponse();
        res.set_embedded(map);
//        res.setStatus(HttpStatus.OK.value());
//        res.setCount(count);

        return new ResponseEntity<>(res, status);
    }








//    public static ResponseEntity<Object> generatePageResponse(HttpStatus status, Object responseObj, Object pageInfo,int count,  String dataName){
    public static ResponseEntity<Object> generatePageResponse(HttpStatus status, Object responseObj, Object pageInfo, String dataName){

        Map<String,Object> map = new HashMap<>();
        map.put(dataName, responseObj);

        ProductResponse res = new ProductResponse();
        res.set_embedded(map);
        res.setPage(pageInfo);
//        res.setStatus(HttpStatus.OK.value());
//        res.setCount(count);

        return new ResponseEntity<>(res, status);
    }

}

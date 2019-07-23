package com.wenhao.mykt.mykttwo.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface GatewayHandlerMapper {

   /**
    * 获取第一个GatewayHandler
    * 
    * @return
    */
   @Select("SELECT  handler_name AS handlerName,handler_id AS handlerid ,prev_handler_id AS prevhandlerid ,next_handler_id AS nexthandlerid  FROM gateway_handler WHERE  prev_handler_id is null;")
   public GatewayHandlerEntity getFirstGatewayHandler();

   @Select("SELECT  handler_name AS handlerName,handler_id AS handlerid ,prev_handler_id AS prevhandlerid ,next_handler_id AS nexthandlerid   FROM gateway_handler WHERE  handler_id=#{handlerId}")
   public GatewayHandlerEntity getByHandler(String handlerId);

}
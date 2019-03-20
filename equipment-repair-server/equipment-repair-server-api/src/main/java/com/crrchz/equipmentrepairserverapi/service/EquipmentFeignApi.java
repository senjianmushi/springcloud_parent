package com.crrchz.equipmentrepairserverapi.service;

import com.crrchz.equipmentrepairserverapi.hystrix.EquipmentFeignHystrix;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "equipment-repair-server", fallback = EquipmentFeignHystrix.class)
public class EquipmentFeignApi {


}

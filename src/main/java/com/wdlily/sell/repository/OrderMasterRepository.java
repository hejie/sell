package com.wdlily.sell.repository;

import com.wdlily.sell.dataobject.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wangDi
 * @description
 * @date 2017/10/21 18:46
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {
}

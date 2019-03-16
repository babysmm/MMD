package com.mmd.mmdshop.mapper.order;

import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mmd.mmdshop.dbdo.*;

@Mapper
public interface OrderMapper extends BaseMapper<OrderTDO>{
	
}

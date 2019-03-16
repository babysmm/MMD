<<<<<<< HEAD
package com.mmd.mmdshop.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mmd.mmdshop.dbdo.*;

@Mapper
public interface ChangeTypeMapper  extends BaseMapper<ChangeTypeDO>{
	
	@Update("UPDATE change_type SET `name`=#{name},change_time = NOW(),change_user_id = #{changeUserId} WHERE change_id = #{changeId}; ")
	int upDataChangeType(ChangeTypeDO changeTypeDO);
}
=======
package com.mmd.mmdshop.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mmd.mmdshop.dbdo.*;

@Mapper
public interface ChangeTypeMapper extends BaseMapper<ChangeTypeDO>{

}
>>>>>>> d7e69f43594d178de4114880955737a167083d98

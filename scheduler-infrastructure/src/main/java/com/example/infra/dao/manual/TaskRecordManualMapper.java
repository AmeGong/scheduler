package com.example.infra.dao.manual;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.*;

import com.example.infra.po.TaskRecordDO;

@Mapper
public interface TaskRecordManualMapper {
    @ResultMap("BaseResultMap")
    @Select("select * from task_record where record_id = #{recordId} for update nowait;")
    TaskRecordDO lock(@Param("recordId") Integer recordId);

    @Update("update task_record set task_status = #{targetStatus} where record_id = #{recordId} and task_status = #{previousStatus};")
    int optimisticLockByTaskStats(@Param("recordId") Integer recordId, @Param("previousStatus") String previousStatus, @Param("targetStatus") String targetStatus);
}

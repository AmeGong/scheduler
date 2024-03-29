package com.example.test.infrastructure;

import com.example.Bootstrap;
import com.example.daemon.TaskSplitorImpl;
import com.example.domain.entity.TaskRecord;
import com.example.infra.repository.TaskRecordRepository;
import com.example.types.enums.TaskStatus;
import com.example.types.enums.TaskType;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Bootstrap.class)
@ActiveProfiles("test")
public class TaskRecordRepositoryTest {

    @Autowired
    private TaskRecordRepository taskRecordRepository;

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Autowired
    private TaskSplitorImpl taskSplitor;

    @Test
    public void saveTest() {
        TaskRecord taskRecord = new TaskRecord();
        taskRecord.setTaskContext("taskContext");
        taskRecord.setTaskType(TaskType.DEMO);
        taskRecord.setTaskStatus(TaskStatus.INITIAL);
        taskRecordRepository.save(taskRecord);
    }

    @Test
    public void splitorTest() {
        taskSplitor.split(new Date());
    }

}

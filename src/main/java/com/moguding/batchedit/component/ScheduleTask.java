package com.moguding.batchedit.component;

import com.moguding.batchedit.service.BatchEditService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


/**
 * @author yxb
 * @version 1.0
 * @description TODO
 * @date 2020/6/5 10:20
 */
@Slf4j
@Component
public class ScheduleTask {

    @Resource
    BatchEditService batchEditService;



    /**
     * 定时任务
     * 每天9，12，15，18，21点执行
     * 测试用：0/1 * * * * ?
     */
    @Scheduled(cron = "0 0 9,12,15,18,21 * * ?")
    private void configureTasks() {

        log.info("开始审核");
        batchEditService.batheAll();
        log.info("审核结束");
    }

}

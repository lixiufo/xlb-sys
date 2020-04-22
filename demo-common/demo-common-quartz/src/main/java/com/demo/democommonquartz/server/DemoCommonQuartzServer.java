package com.demo.democommonquartz.server;

import lombok.extern.slf4j.Slf4j;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.DateBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.quartz.QuartzJobBean;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author WPF
 * @version xlb-sys
 * @date 2020/3/21.
 */
@Slf4j
public class DemoCommonQuartzServer {

    @Resource
    private Scheduler scheduler;

    @Bean
    public DemoCommonQuartzServer demoCommonQuartzServer() {
        return new DemoCommonQuartzServer();
    }


    @PostConstruct
    public void startScheduler() {
        try {
            scheduler.start();
        } catch (SchedulerException e) {
            log.error(e.getMessage());
        }
    }

    /**
     * 增加一个job
     *
     * @param jobClass
     *         任务实现类
     * @param jobName
     *         任务名称
     * @param jobGroupName
     *         任务组名
     * @param jobTime
     *         时间表达式 (这是每隔多少秒为一次任务)
     * @param jobTimes
     *         运行的次数 （<0:表示不限次数）
     * @param jobData
     *         参数
     */
    public void addJob(Class<? extends QuartzJobBean> jobClass, String jobName, String jobGroupName, String description, int jobTime,
                       int jobTimes, Map jobData) {
        try {
            // 任务名称和组构成任务key
            JobDetail jobDetail = JobBuilder.newJob(jobClass).withIdentity(jobName, jobGroupName)
                    .build();
            // 设置job参数
            if (jobData != null && jobData.size() > 0) {
                jobDetail.getJobDataMap().putAll(jobData);
            }
            // 使用simpleTrigger规则
            Trigger trigger;
            if (jobTimes < 0) {
                trigger = TriggerBuilder.newTrigger()
                        .withIdentity(jobName, jobGroupName)
                        .withDescription(description)
                        .withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(1).withIntervalInSeconds(jobTime))
                        .startNow()
                        .build();
            } else {
                trigger = TriggerBuilder.newTrigger()
                        .withIdentity(jobName, jobGroupName)
                        .withSchedule(SimpleScheduleBuilder
                                .repeatSecondlyForever(1).withIntervalInSeconds(jobTime).withRepeatCount(jobTimes))
                        .startNow().build();
            }
            scheduler.scheduleJob(jobDetail, trigger);
        } catch (SchedulerException e) {
            log.error(e.getMessage());
        }
    }

    /**
     * 增加一个job
     *
     * @param jobClass
     *         任务实现类
     * @param jobName
     *         任务名称(建议唯一)
     * @param jobGroupName
     *         任务组名
     * @param jobTime
     *         时间表达式 （如：0/5 * * * * ? ）
     * @param jobData
     *         参数
     */
    public void addJob(Class<? extends QuartzJobBean> jobClass, String jobName, String jobGroupName, String description, String jobTime, Map jobData) {
        try {
            // 创建jobDetail实例，绑定Job实现类
            // 指明job的名称，所在组的名称，以及绑定job类
            // 任务名称和组构成任务key
            JobDetail jobDetail = JobBuilder.newJob(jobClass).withIdentity(jobName, jobGroupName)
                    .build();
            // 设置job参数
            if (jobData != null && jobData.size() > 0) {
                jobDetail.getJobDataMap().putAll(jobData);
            }
            // 定义调度触发规则
            // 使用cornTrigger规则
            // 触发器key
            Trigger trigger = TriggerBuilder.newTrigger().withIdentity(jobName, jobGroupName)
                    .startAt(DateBuilder.futureDate(1, DateBuilder.IntervalUnit.SECOND))
                    .withSchedule(CronScheduleBuilder.cronSchedule(jobTime))
                    .withDescription(description)
                    .startNow()
                    .build();
            // 把作业和触发器注册到任务调度中
            scheduler.scheduleJob(jobDetail, trigger);
        } catch (Exception e) {
            log.error(e.getMessage());
            try {
                scheduler.resumeJob(new JobKey(jobName, jobGroupName));
            } catch (SchedulerException ex) {
                log.error(e.getMessage());
            }
        }
    }

    /**
     * 修改 一个job的 时间表达式
     *
     * @param jobName
     * @param jobGroupName
     * @param jobTime
     */
    public void updateJob(String jobName, String jobGroupName, String jobTime) {
        try {
            TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroupName);
            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
            trigger = trigger.getTriggerBuilder().withIdentity(triggerKey)
                    .withSchedule(CronScheduleBuilder.cronSchedule(jobTime)).build();
            // 重启触发器
            scheduler.rescheduleJob(triggerKey, trigger);
        } catch (SchedulerException e) {
            log.error(e.getMessage());
        }
    }

    /**
     * 删除任务一个job
     *
     * @param jobName
     *         任务名称
     * @param jobGroupName
     *         任务组名
     */
    public void deleteJob(String jobName, String jobGroupName) {
        try {
            scheduler.deleteJob(new JobKey(jobName, jobGroupName));
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    /**
     * 暂停一个job
     *
     * @param jobName
     *         nn
     * @param jobGroupName
     *         nn
     */
    public void pauseJob(String jobName, String jobGroupName) {
        try {
            JobKey jobKey = JobKey.jobKey(jobName, jobGroupName);
            scheduler.pauseJob(jobKey);
        } catch (SchedulerException e) {
            log.error(e.getMessage());
        }
    }

    /**
     * 恢复一个job
     *
     * @param jobName
     *         nn
     * @param jobGroupName
     *         nn
     */
    public void resumeJob(String jobName, String jobGroupName) {
        try {
            JobKey jobKey = JobKey.jobKey(jobName, jobGroupName);
            scheduler.resumeJob(jobKey);
        } catch (SchedulerException e) {
            log.error(e.getMessage());
        }
    }

    /**
     * 立即执行一个job
     *
     * @param jobName
     *         nn
     * @param jobGroupName
     *         nn
     */
    public void runAJobNow(String jobName, String jobGroupName) {
        try {
            JobKey jobKey = JobKey.jobKey(jobName, jobGroupName);
            scheduler.triggerJob(jobKey);
        } catch (SchedulerException e) {
            log.error(e.getMessage());
        }
    }

    /**
     * 获取所有计划中的任务列表
     *
     * @return nn
     */
    public List<Map<String, Object>> queryAllJob() {
        List<Map<String, Object>> jobList = null;
        try {
            GroupMatcher<JobKey> matcher = GroupMatcher.anyJobGroup();
            Set<JobKey> jobKeys = scheduler.getJobKeys(matcher);
            jobList = new ArrayList<>();
            for (JobKey jobKey : jobKeys) {
                List<? extends Trigger> triggers = scheduler.getTriggersOfJob(jobKey);
                for (Trigger trigger : triggers) {
                    Map<String, Object> map = new HashMap<>(8);
                    map.put("jobName", jobKey.getName());
                    map.put("jobGroupName", jobKey.getGroup());
                    map.put("trigger", "触发器:" + trigger.getKey());
                    map.put("description", trigger.getDescription());
                    Trigger.TriggerState triggerState = scheduler.getTriggerState(trigger.getKey());
                    map.put("jobStatus", triggerState.name());
                    if (trigger instanceof CronTrigger) {
                        CronTrigger cronTrigger = (CronTrigger) trigger;
                        String cronExpression = cronTrigger.getCronExpression();
                        map.put("jobTime", cronExpression);
                    }
                    jobList.add(map);
                }
            }
        } catch (SchedulerException e) {
            log.error(e.getMessage(),e);
        }
        return jobList;
    }

    /**
     * 获取所有正在运行的job
     *
     * @return nn
     */
    public List<Map<String, Object>> queryRunJob() {
        List<Map<String, Object>> jobList = null;
        try {
            List<JobExecutionContext> executingJobs = scheduler.getCurrentlyExecutingJobs();
            jobList = new ArrayList<>(executingJobs.size());
            for (JobExecutionContext executingJob : executingJobs) {
                Map<String, Object> map = new HashMap<>(8);
                JobDetail jobDetail = executingJob.getJobDetail();
                JobKey jobKey = jobDetail.getKey();
                Trigger trigger = executingJob.getTrigger();
                map.put("jobName", jobKey.getName());
                map.put("jobGroupName", jobKey.getGroup());
                map.put("trigger", "触发器:" + trigger.getKey());
                map.put("description", trigger.getDescription());
                Trigger.TriggerState triggerState = scheduler.getTriggerState(trigger.getKey());
                map.put("jobStatus", triggerState.name());
                if (trigger instanceof CronTrigger) {
                    CronTrigger cronTrigger = (CronTrigger) trigger;
                    String cronExpression = cronTrigger.getCronExpression();
                    map.put("jobTime", cronExpression);
                }
                jobList.add(map);
            }
        } catch (SchedulerException e) {
            log.error(e.getMessage());
        }
        return jobList;
    }

}

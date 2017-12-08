package com.xy.task;

import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.lite.api.JobScheduler;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.reg.base.CoordinatorRegistryCenter;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;

public class CodeTask {

	public CodeTask() {
		new JobScheduler(createRegistryCenter(), createJobConfiguration()).init();
	}
	
	private static CoordinatorRegistryCenter createRegistryCenter() {
        CoordinatorRegistryCenter regCenter = new ZookeeperRegistryCenter(new ZookeeperConfiguration("127.0.0.1:2181", "job-task"));
        regCenter.init();
        return regCenter;
    }
    
    private static LiteJobConfiguration createJobConfiguration() {
    	// 定义作业核心配置
		JobCoreConfiguration simpleCoreConfig = JobCoreConfiguration.newBuilder("codeTask", "0/15 * * * * ?", 2).build();
		// 定义SIMPLE类型配置
		SimpleJobConfiguration simpleJobConfig = new SimpleJobConfiguration(simpleCoreConfig, MyXmlTask.class.getCanonicalName());
		// 定义Lite作业根配置
		return LiteJobConfiguration.newBuilder(simpleJobConfig).build();
    }
}

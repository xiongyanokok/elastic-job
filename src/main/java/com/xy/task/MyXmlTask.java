package com.xy.task;

import java.util.Date;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;

public class MyXmlTask implements SimpleJob {

	@Override
	public void execute(ShardingContext shardingContext) {
		switch (shardingContext.getShardingItem()) {
            case 0: 
                System.out.println(new Date() +""+ shardingContext.toString());
                break;
            case 1: 
            	System.out.println(new Date() +""+ shardingContext.toString());
                break;
            case 2: 
            	System.out.println(new Date() +""+ shardingContext.toString());
                break;
            default:
            	break;
        }
	}

}

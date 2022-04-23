package com.example.sharding.algorithm;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

/**
 * 自定义分片算法
 */
public class ShardingAlgorithm implements PreciseShardingAlgorithm<Long> {

	@Override
	public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Long> shardingValue) {

		String s = String.valueOf(shardingValue.getValue());
		int lastNum = Character.digit(s.charAt(s.length() - 1), 10);
		for (String tableName : availableTargetNames) {
			if (tableName.endsWith(lastNum % availableTargetNames.size() + "")) {
				return tableName;
			}
		}
		throw new IllegalArgumentException();
	}

}

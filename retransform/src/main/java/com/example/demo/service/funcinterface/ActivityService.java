/*
 * Project: retransformDemo
 *
 * File Created at 2022/3/26
 *
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */

package com.example.demo.service.funcinterface;

import com.example.demo.common.enums.ActivityOptionEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;

/**
 * @author liudongwei
 * @Type ActivityService
 * @Desc  利用函数式接口避免写很多的if else 语句  note： 这里其实完全是可以按照策略模式去写的，
 * @date 2022-03-26 10:29
 */
@Slf4j
@Component
public class ActivityService {

    private ConcurrentHashMap<Integer, BiFunction<String, Integer, Boolean>> sourceMap = new ConcurrentHashMap<>();

    // 这里也可以采用构造器方式
/*
    public ActivityService() {
        sourceMap.put(ActivityOptionEnum.TOUTIAO,(userId, source)->toutiaoReward(userId));
        sourceMap.put(ActivityOptionEnum.WEIXIN, (userId, source) -> wxReward(userId));
    }
*/

    @PostConstruct
    private void dispatch() {
        sourceMap.put(ActivityOptionEnum.TOUTIAO.getCode(), (userId, source) -> toutiaoReward(userId, source));
        sourceMap.put(ActivityOptionEnum.WEIXIN.getCode(), (userId, source) -> wxReward(userId, source));
    }


    public Boolean getReward(String userId, Integer source) {
        BiFunction<String, Integer, Boolean> function = sourceMap.get(source);
        if (null != function) {
            return function.apply(userId, source);
        }
        return Boolean.FALSE;
    }


    private Boolean toutiaoReward(String userId, Integer source) {
        log.info("头条渠道用户奖励50元红包!,userId:{} source:{}", userId, source);
        return Boolean.TRUE;
    }

    private Boolean wxReward(String userId, Integer source) {
        log.info("微信渠道用户{}奖励100元红包!,userId:{} source:{}", userId, source);
        return Boolean.TRUE;
    }


}

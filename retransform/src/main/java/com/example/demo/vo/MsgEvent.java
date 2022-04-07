/*
 * Project: mybatis_hello
 *
 * File Created at 2022/4/5
 *
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */

package com.example.demo.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author liudongwei
 * @Type MsgEvent
 * @Desc  note: Disruptor 通过 EventFactory 在 RingBuffer 中预创建 Event 的实例。一个 Event 实例实际上被用作一个“数据槽”
 *              发布者发布前，先从 RingBuffer 获得一个 Event 的实例，然后往 Event 实例中填充数据，之后再发布到 RingBuffer 中，
 *              之后由 Consumer 获得该 Event 实例并从中读取数据。
 * @date 2022-04-05 16:46
 */

@Data
public class MsgEvent<T> implements Serializable {

    private T value;


}

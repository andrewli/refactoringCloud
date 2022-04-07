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

package com.example.demo.service.disruptor;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.common.constant.Constant;
import com.example.demo.vo.MsgEvent;
import com.example.demo.vo.User;
import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.EventHandlerGroup;
import com.lmax.disruptor.dsl.ProducerType;
import io.reactivex.rxjava3.functions.Action;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.Executors;

/**
 * @author liudongwei
 * @Type DisruptorTest
 * @Desc 详解： https://www.cnblogs.com/pku-liuqiang/p/8544700.html  https://www.cnblogs.com/pku-liuqiang/p/8532737.html
 * @date 2022-04-05 16:16
 */
@Slf4j
@Service
public class DisruptorService {
    /*
     简介： Disruptor是一个高性能的并发框架,是线程间通信的高效低延时的内存消息组件，即在同一个JVM进程中的多线程间消息传递，
     利用RingBuffer中的预分配内存实现内存的可重复利用，降低了GC的频率。 与 Kafka、RabbitMQ 用于服务间的消息队列不同，
     disruptor 一般用于一个JVM 中多个线程间消息的传递。从功能上来看，Disruptor 实现了“队列”的功能，而且是一个有界队列(事实上它是一个无锁的线程间通信库)
     作用与 ArrayBlockingQueue 有相似之处，但是 disruptor 从功能、性能上又都远好于 ArrayBlockingQueue。

     note： disruptor.shutdown 失效原因
      ① disruptor.shutdown 方法仅仅能关闭当前已经启动了的消费者线程，对于调用时尚未启动的消费者线程不起作用。
        在disruptor.shutdown如果能正确的关闭程序，需要满足两个条件：
        1. 生产者的生产线程必须执行在disruptor.shutdown方法之前。
        2. disruptor.shutdown方法必须执行在所有消费者线程启动之前。
      ② 在实际使用中，disruptor.shutdown 失效问题也许并不常见。原因在于：线上环境中，生产者线程往往已经运行了一段时间，这段时间内，
        足够线程池调用所有的消费者线程并运行。但如果生产者运行的时间过短，导致shutdown提前调用在消费者线程启动之前，则会产生问题。

     note： 以下两个demo示例是不依赖与spring框架
     */

    /**
     * 单生产者(ProducerType.SINGLE)多消费者：每个消费者竞争消费消息，一个消息只能被一个消费者组消费一次
     */
    public static void oneProMultiConDemo() throws Exception {
        Disruptor<MsgEvent> disruptor = new Disruptor<>(new MsgEventFactory(),
                Constant.ringBufferSize,
                Executors.defaultThreadFactory(),
                ProducerType.SINGLE,
                new BlockingWaitStrategy());

        //定义消费者
        MsgWorkHandlerConsumer work1 = new MsgWorkHandlerConsumer("work1");
        MsgWorkHandlerConsumer work2 = new MsgWorkHandlerConsumer("work2");

        // 绑定配置关系
        disruptor.handleEventsWithWorkerPool(work1, work2);
        disruptor.start();

        // 定义要发送的数据
        MsgProducer msgProducer = new MsgProducer(disruptor);
        msgProducer.send(Arrays.asList("a", "b", "c"));
        //为了保证消费者线程已经启动，留足足够的时间
        Thread.sleep(1000);
        //方法会阻塞，但该方法执行结束后，并不一定会使程序关闭
        disruptor.shutdown();

    }

    /**
     * 多生产者(ProducerType.MULTI)多消费者：每个消费者并行消费消息，一个消息被各消费者组各消费一次
     */
    public static void multiProMultiConDemo() throws Exception {
        Disruptor<MsgEvent> disruptor = new Disruptor<>(new MsgEventFactory(),
                Constant.ringBufferSize,
                Executors.defaultThreadFactory(),
                ProducerType.MULTI,
                new BlockingWaitStrategy());
        //定义消费者
        MsgEventHandlerConsumer consumer1 = new MsgEventHandlerConsumer("1");
        MsgEventHandlerConsumer consumer2 = new MsgEventHandlerConsumer("2");
        // 绑定配置关系
        disruptor.handleEventsWith(consumer1, consumer2);
        disruptor.start();
        // 多生产者发送数据
        for (int num = 0; num < 3; num++) {
            Runnable action = () -> {
                for (int i = 0; i < 3; i++) {
                    new MsgProducer(disruptor).send(Thread.currentThread().getName() + "'s " + i + "th message");
                }
            };
            new Thread(action, "producer thread " + num).start();
        }
        //为了保证消费者线程已经启动，留足足够的时间
        Thread.sleep(1000);
        //方法会阻塞，但该方法执行结束后，并不一定会使程序关闭
        disruptor.shutdown();
    }


    @Autowired
    private Disruptor disruptor;

    /**
    * 生产消息
    * @Param [users]
    * @Return void
    */
    public void produceMessage(Collection<User> users) {
        MsgProducer producer = new MsgProducer(disruptor);
        users.stream().forEach(e->{
            producer.send(JSONObject.toJSONString(e));
        });
    }

}

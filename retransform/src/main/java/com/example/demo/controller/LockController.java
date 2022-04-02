
package com.example.demo.controller;


import com.example.demo.constant.Result;
import com.example.demo.service.lock.LockService;
import com.example.demo.vo.DelayJob;
import com.example.demo.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liudongwei
 * @Type
 * @Desc
 * @date 2021-09-26 17:42
 */
@Slf4j
@RestController
public class LockController extends BaseController {


    @Autowired
    private LockService lockService;


    @PostMapping("/setJsonContent")
    public Result setJsonContent(@RequestParam(value = "key") String key) {
        lockService.setJsonContent(key);
        return Result.create();
    }


    @GetMapping("/lock")
    public Result lock() {
        return lockService.lock();
    }


    @GetMapping("/readLock")
    public Result readLock(@RequestParam(value = "redisKey") String redisKey) {

        lockService.readLock(redisKey);
        return Result.create();
    }


    @GetMapping("/writeLock")
    public Result writeLock(@RequestParam(value = "redisKey") String redisKey) {
        lockService.writeLock(redisKey);
        return Result.create();
    }


    /**
    * 添加一个延时队列的job
    * @Param [delayJob]
    * @Return Result
    */
    @PostMapping("/delayQueue/putJob")
    public Result putJob(@RequestBody DelayJob<User> delayJob) {

        lockService.offerDelayJob(delayJob);
        return Result.create();
    }

}

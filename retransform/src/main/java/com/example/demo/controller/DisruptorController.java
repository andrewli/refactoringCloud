
package com.example.demo.controller;


import com.example.demo.constant.Result;
import com.example.demo.service.disruptor.DisruptorService;
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

import java.util.List;

/**
 * @author liudongwei
 * @Type
 * @Desc
 * @date 2021-09-26 17:42
 */
@Slf4j
@RestController
public class DisruptorController extends BaseController {


    @Autowired
    private DisruptorService disruptorService;


    @PostMapping("/disruptor/produceMsg")
    public Result produceMsg(@RequestBody List<User> users) {
        disruptorService.produceMessage(users);
        return Result.create();
    }



}

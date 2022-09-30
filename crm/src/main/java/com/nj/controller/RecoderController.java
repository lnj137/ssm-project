package com.nj.controller;

import com.nj.bean.RecoderBean;
import com.nj.bean.RecoderQuery;
import com.nj.service.RecoderService;
import com.nj.utils.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Li
 * @version 1.0
 * @date:2022-09-08 19:12
 */
@RestController
@RequestMapping("recoder")
@Api(description = "记录的维护")
public class RecoderController {
    @Autowired
    private RecoderService service;

    @GetMapping("getAll")
    @ApiOperation("获取所有跟踪记录加分页和模糊查询")
    public ResponseUtil getAll(RecoderQuery recoderQuery){
        return service.findAll(recoderQuery);
    }

    @PostMapping("saveRecoder")
    @ApiOperation("添加记录")
    public ResponseUtil saveRecoder(@RequestBody RecoderBean recoder){
        return service.addRecoder(recoder);
    }

    @PutMapping("editRecoder")
    @ApiOperation("修改记录")
    public ResponseUtil editRecoder(@RequestBody RecoderBean recoder){
        return service.modifyRecoder(recoder);
    }
}

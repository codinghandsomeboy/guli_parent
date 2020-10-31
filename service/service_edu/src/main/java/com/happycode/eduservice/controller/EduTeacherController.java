package com.happycode.eduservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.happycode.commonutils.R;
import com.happycode.eduservice.entity.EduTeacher;
import com.happycode.eduservice.entity.vo.TeacherQuery;
import com.happycode.eduservice.service.EduTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * è®²å¸ˆ 前端控制器
 * </p>
 *
 * @author ljl
 * @since 2020-10-31
 */
@Api("讲师管理")
@RestController
@RequestMapping("/eduservice/teacher")
public class EduTeacherController {

    @Autowired
    private EduTeacherService teacherService;

    @ApiOperation("查询所有讲师")
    @GetMapping("/findAll")
    public R findAll() {
        List<EduTeacher> teachers = teacherService.list(null);
        return R.ok().data("item",teachers);
    }

    @ApiOperation("逻辑删除")
    @DeleteMapping("{id}")
    public boolean deleteTeacher(@PathVariable String id) {
        return teacherService.removeById(id);
    }

    @ApiOperation("分页查询数据")
    @GetMapping("pageTeacher/{current}/{limit}")
    public R pageTeacher(@PathVariable long current,@PathVariable long limit) {
        Page<EduTeacher> pageTeacher = new Page<>(current,limit);
        teacherService.page(pageTeacher,null);
        long total = pageTeacher.getTotal();
        List<EduTeacher> records = pageTeacher.getRecords();
        return R.ok().data("total",total).data("rows",records);
    }

    @ApiOperation("分页条件查询")
    @PostMapping("pageTeacherCondition/{current}/{limit}")
    public R pageTeacherCondition(@PathVariable long current,@PathVariable long limit,
                                  @RequestBody(required = false) TeacherQuery teacherQuery) {
        Page<EduTeacher> pageTeacher = new Page<>(current,limit);
        QueryWrapper<EduTeacher> queryWrapper = new QueryWrapper<>();
        String name = teacherQuery.getName();
        Integer level = teacherQuery.getLevel();
        String begin = teacherQuery.getBegin();
        String end = teacherQuery.getEnd();
        if(!StringUtils.isEmpty(name)) {
            queryWrapper.like("name",name);
        }
        if(!StringUtils.isEmpty(level)) {
            queryWrapper.eq("level",level);
        }
        if(!StringUtils.isEmpty(begin)) {
            queryWrapper.ge("gmt_create",begin);
        }
        if(!StringUtils.isEmpty(end)) {
            queryWrapper.le("gmt_create",end);
        }
        teacherService.page(pageTeacher,queryWrapper);
        long total = pageTeacher.getTotal();
        List<EduTeacher> records = pageTeacher.getRecords();
        return R.ok().data("total",total).data("rows",records);

    }

    @ApiOperation("根据id查询讲师")
    @GetMapping("getTeacher/{id}")
    public R getTeacher(@PathVariable String id) {
        EduTeacher teacher = teacherService.getById(id);
        return R.ok().data("item",teacher);
    }

    @ApiOperation("添加讲师")
    @PostMapping("addTeacher")
    public R addTeacher(@RequestBody EduTeacher eduTeacher) {
        boolean save = teacherService.save(eduTeacher);
        return save ? R.ok():R.error();
    }


    @ApiOperation(("更新讲师"))
    @PostMapping("updateTeacher")
    public R updateTeacher(@RequestBody EduTeacher eduTeacher) {
        boolean flag = teacherService.update(eduTeacher,null);
        return flag ? R.ok() :R.error();
    }

}


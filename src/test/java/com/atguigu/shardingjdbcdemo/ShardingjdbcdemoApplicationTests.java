package com.atguigu.shardingjdbcdemo;

import com.atguigu.shardingjdbcdemo.entity.Course;
import com.atguigu.shardingjdbcdemo.mapper.CourseMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
class ShardingjdbcdemoApplicationTests {

    //注入 mapper
    @Resource
    private CourseMapper courseMapper;

    //添加课程的方法
    @Test
    void addCourse() {
        for (int i = 1; i <= 20; i++) {
            Course course = new Course();
            course.setCid(i+10000000L);
            course.setCname("java" + i);
            course.setUserId(100L+i+1);
            course.setStatus("Normal" + i);
            courseMapper.insert(course);
        }
    }

    //查询课程的方法
    @Test
    public void findCourse() {
        QueryWrapper<Course> wrapper = new QueryWrapper<>();
        wrapper.eq("cid", 10000010L);
        wrapper.eq("user_id", 110);
        Course course = courseMapper.selectOne(wrapper);
        System.out.println(course);
    }
}



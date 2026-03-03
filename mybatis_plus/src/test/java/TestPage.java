import CRUD.SqlSpringBoot;
import CRUD.baseMapper.UseeMapper;
import CRUD.resource.Usee;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = SqlSpringBoot.class)
public class TestPage {
    @Autowired
    private UseeMapper useeMapper;
    @Test
    public void test_page() {
        LambdaQueryWrapper<Usee> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        IPage<Usee> page = new Page<Usee>(0,3);
        useeMapper.selectPage(page, lambdaQueryWrapper);
        System.out.println("当前："+page.getCurrent());
        System.out.println(page.getSize());
    }
    @Test
    public void test_pagepro() {
        IPage<Usee> page = new Page<Usee>(0,3);
        useeMapper.pageByName(page, "孙悟空");
        System.out.println("当前："+page.getCurrent());
        System.out.println(page.getSize());
    }
}

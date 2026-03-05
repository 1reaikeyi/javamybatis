package CRUD.BaseMapper;

import CRUD.resource.Usee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Repository;

@Repository
public interface UseeMapper extends BaseMapper<Usee> {
    Usee selectByName(String name);
    IPage<Usee> pageByName(IPage<Usee> page,String name);
}

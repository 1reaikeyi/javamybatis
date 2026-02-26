package CRUD.baseMapper;

import CRUD.resource.Usee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.springframework.stereotype.Repository;

@Repository
public interface UseeMapper extends BaseMapper<Usee> {
    Usee selectByName(String name);
}

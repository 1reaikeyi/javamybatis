package annotion;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface Dao {
    @Update("update shuihu set name = #{name},age = #{age},address = #{address},salary = #{salary},job = #{job},gender = #{gender} where id = #{id}")
    int update(Usee usee);
    @Delete("delete from shuihu where id = #{id}")
    int delete(int id);
    @Insert("insert into shuihu(name,age,address,salary,job,gender) values(#{name},#{age},#{address},#{salary},#{job},#{gender})")
    int insert(Usee usee);
    @Select("select * from shuihu where id = #{id}")
    Usee selectOne(int id);
    @Select("select * from shuihu")
    List<Usee> selectAll();

}

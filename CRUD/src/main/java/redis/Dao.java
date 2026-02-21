package redis;

public interface Dao {
    void selectById(int id);
    Usee selectOne(int id);
    int  insertOne(Usee usee);
}

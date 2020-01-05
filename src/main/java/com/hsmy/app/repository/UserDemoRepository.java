package com.hsmy.app.repository;

import com.hsmy.app.bean.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDemoRepository extends ElasticsearchRepository<User, Integer> {
    //参考：https://docs.spring.io/spring-data/elasticsearch/docs/3.1.4.RELEASE/reference/html/
    //自定义方法，不用实现

    /**
     根据名称模糊查询
     */
    List<User> findUserByNameLike(String name);

    /**
     * 自定义方法，根据名称精确查询
     * @param name
     * @return
     */
    List<User> findUserByName(String name);

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    User findUserById(Integer id);
}

package com.hsmy.app.service.impl;

import com.hsmy.app.bean.User;
import com.hsmy.app.repository.UserDemoRepository;
import com.hsmy.app.service.UserService;
import org.elasticsearch.index.query.MatchPhraseQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDemoRepository userDemoRepository;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Override
    public long count() {
        return userDemoRepository.count();
    }

    @Override
    public User save(User user) {
        return userDemoRepository.save(user);
    }

    @Override
    public void delete(User user) {
        userDemoRepository.delete(user);
    }

    @Override
    public Iterable<User> getAll() {
        return userDemoRepository.findAll();
    }

    /**
     * //根据用户名精确查询用户
     * @param name
     * @return
     */
    @Override
    public List<User> getByName(String name) {
        List<User> user = userDemoRepository.findUserByName(name);
        return user;
    }

    /**
     *对用户姓名进行分页查询
     */
    @Override
    public Page<User> pageQuery(Integer pageNum, Integer pageSize, String q) {
        //matchPhraseQuery ：对查询条件不分词，当做一个整体查询
        //mathQuery:对查询条件进行分词，之后再查询

        //分页
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        //指定查询字段-单字段
        MatchPhraseQueryBuilder queryBuilder = QueryBuilders.matchPhraseQuery("name", q);

        //指定查询字段-多字段
        //MultiMatchQueryBuilder queryBuilder1 = QueryBuilders.multiMatchQuery(q, "name", "address");

        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(queryBuilder)
                .withPageable(pageable)
                .build();
        Page<User> users = userDemoRepository.search(searchQuery);

        return users;
    }

}

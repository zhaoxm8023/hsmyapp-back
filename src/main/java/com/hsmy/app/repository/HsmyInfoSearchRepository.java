package com.hsmy.app.repository;

import com.hsmy.app.bean.HsmyInfoSearch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HsmyInfoSearchRepository extends ElasticsearchRepository<HsmyInfoSearch,String> {

//    @org.springframework.data.elasticsearch.annotations.Query("{\"bool\": {\"must\": {\"match\" :{\"content\": \"?0\"}}}}," +
//            "\"highlight \": {\n" +
//            "\t\"fields \": {\n" +
//            "\t\t\"content\": {}\n" +
//            "\t}")
    @Query("{\"range\": { \"id\": {  \"gte\": 1,\"lte\": 3}}}")
    Page<HsmyInfoSearch> findSth(String name, Pageable pageable);

}

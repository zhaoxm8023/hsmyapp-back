package com.hsmy.app.service.impl;

import com.hsmy.app.bean.HsmyInfoSearch;
import com.hsmy.app.repository.HsmyInfoSearchRepository;
import com.hsmy.app.service.HsmyInfoSearchService;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.SearchResultMapper;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.aggregation.impl.AggregatedPageImpl;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HsmyInfoSearchServiceImpl  implements HsmyInfoSearchService {

    @Autowired
    private HsmyInfoSearchRepository hsmyInfoSearchRepository;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;


    @Override
    public long count() {
        return hsmyInfoSearchRepository.count();
    }

    @Override
    public HsmyInfoSearch save(HsmyInfoSearch hsmyInfoSearch) {
        return hsmyInfoSearchRepository.save(hsmyInfoSearch);
    }

    @Override
    public void delete(HsmyInfoSearch hsmyInfoSearch) {
        hsmyInfoSearchRepository.delete(hsmyInfoSearch);
    }

    @Override
    public Iterable<HsmyInfoSearch> queryAll() {
        return hsmyInfoSearchRepository.findAll();
    }


    //matchPhraseQuery ：对查询条件不分词，当做一个整体查询
    //mathQuery:对查询条件进行分词，之后再查询
    @Override
    public Page<HsmyInfoSearch> infoContentQuery(Integer pageNum, Integer pageSize, String qryString) {
        return getInfoListByContentAndTtile(qryString,pageNum,pageSize);
    }

    @Override
    public Page<HsmyInfoSearch> infoTitleQuery(String query, Pageable pageable) {
        BoolQueryBuilder qb = QueryBuilders.boolQuery();
        if (query != null) {
            qb.must(QueryBuilders.matchQuery("title", query));
        }
        return hsmyInfoSearchRepository.search(qb, pageable);
    }

    @Override
    public Page<HsmyInfoSearch> infoSth(String query, Pageable pageable) {
        return hsmyInfoSearchRepository.findSth(query, pageable);
    }


    public AggregatedPage<HsmyInfoSearch> getInfoListByContentAndTtile(String content, Integer pageNum, Integer pageSzie) {
        Pageable pageable = PageRequest.of(pageNum, pageSzie);

        String preTag = "<font color='#dd4b39'>";//google的色值
        String postTag = "</font>";

        SearchQuery searchQuery = new NativeSearchQueryBuilder().
                withQuery(matchQuery("title", content)).
                withQuery(matchQuery("content", content)).
                withHighlightFields(new HighlightBuilder.Field("title").preTags(preTag).postTags(postTag),
                        new HighlightBuilder.Field("content").preTags(preTag).postTags(postTag)).build();
        searchQuery.setPageable(pageable);

        // 不需要高亮直接return ideas
//      Page<HsmyInfoSearch> ideas = hsmyInfoSearchRepository.search(searchQuery);

        // 高亮字段
        AggregatedPage<HsmyInfoSearch> hsmyInfoSearchResult = elasticsearchTemplate.queryForPage(searchQuery, HsmyInfoSearch.class, new SearchResultMapper() {
            @Override
            public <T> AggregatedPage<T> mapResults(SearchResponse response, Class<T> clazz, Pageable pageable) {
                List<HsmyInfoSearch> chunk = new ArrayList<>();
                for (SearchHit searchHit : response.getHits()) {
                    if (response.getHits().getHits().length <= 0) {
                        return null;
                    }
                    //原始临时数据
                    HsmyInfoSearch hsmyInfoSearch = new HsmyInfoSearch();
                    hsmyInfoSearch.setId((String)searchHit.getSourceAsMap().get("id"));
                    hsmyInfoSearch.setAuthor((String)searchHit.getSourceAsMap().get("author"));
                    hsmyInfoSearch.setTitle((String)searchHit.getSourceAsMap().get("title"));
                    hsmyInfoSearch.setContent((String)searchHit.getSourceAsMap().get("content"));
                    //高亮数据
                    HighlightField ideaTitle = searchHit.getHighlightFields().get("title");
                    if (ideaTitle != null) {
                        hsmyInfoSearch.setTitle(ideaTitle.fragments()[0].toString());
                    }
                    HighlightField ideaContent = searchHit.getHighlightFields().get("content");
                    if (ideaContent != null) {
                        hsmyInfoSearch.setContent(ideaContent.fragments()[0].toString());
                    }
                    chunk.add(hsmyInfoSearch);
                }
                if (chunk.size() > 0) {
                    return new AggregatedPageImpl<>((List<T>) chunk);
                }
                return null;
            }
        });
        return hsmyInfoSearchResult;
    }


    public BoolQueryBuilder matchQuery(String field,String qryString){
        BoolQueryBuilder qb = QueryBuilders.boolQuery();
        qb.must(QueryBuilders.queryStringQuery(qryString).field(field));
        return qb;
    }


//        Pageable pageable = PageRequest.of(pageNum, pageSize);
//        BoolQueryBuilder qb = QueryBuilders.boolQuery();
//        qb.must(QueryBuilders.queryStringQuery(qryString).field("content"));
//        //指定查询字段-单字段
//        //MatchPhraseQueryBuilder queryBuilder = QueryBuilders.matchPhraseQuery("conten", qryString);
//        //指定查询字段-多字段
//        //MultiMatchQueryBuilder queryBuilder1 = QueryBuilders.multiMatchQuery(q, "name", "address");
//        //highlight
//        HighlightBuilder highlightBuilder = new HighlightBuilder();
//        HighlightBuilder.Field highlightTitle = new HighlightBuilder.Field("content");
//        highlightTitle.preTags("<span class=\"highlight\">");
//        highlightTitle.postTags("</span>");
//        highlightBuilder.field(highlightTitle);
//
//        SearchQuery searchQuery = new NativeSearchQueryBuilder()
//                .withQuery(qb)
//                .withPageable(pageable)
//                .withHighlightBuilder(highlightBuilder)
//                .build();
//        Page<HsmyInfoSearch> infoLists = hsmyInfoSearchRepository.search(searchQuery);
//        return infoLists;
}
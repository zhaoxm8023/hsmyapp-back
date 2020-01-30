package com.hsmy.app.service;

import com.hsmy.app.bean.HsmyInfoSearch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;

public interface HsmyInfoSearchService {

    long count();

    HsmyInfoSearch save(HsmyInfoSearch hsmyInfoSearch);

    void delete(HsmyInfoSearch hsmyInfoSearch);

    Iterable<HsmyInfoSearch> queryAll();

    Page<HsmyInfoSearch> infoContentQuery(Integer pageNum, Integer pageSize, String qryString);

    Page<HsmyInfoSearch> infoTitleQuery(String query, @PageableDefault(page = 0, size = 5, sort = "time", direction = Sort.Direction.DESC) Pageable pageable);

    Page<HsmyInfoSearch> infoSth(String query, Pageable pageable) ;
}

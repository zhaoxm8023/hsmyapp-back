package com.hsmy.app.web;

import com.hsmy.app.bean.HsmyInfoSearch;
import com.hsmy.app.service.HsmyInfoSearchService;
import io.swagger.annotations.ApiOperation;
import jodd.util.URLDecoder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HsmySearchController {
    private static final Log logger = LogFactory.getLog(HsmySearchController.class);

    @Autowired
    private HsmyInfoSearchService hsmyInfoSearchService;

    //查询全部信息 注意翻页查询！
    @ApiOperation(value = "模糊查询文本信息")
    @RequestMapping(path = "/hsmy/infosearch/count", method = RequestMethod.GET)
    public long count() {
        return hsmyInfoSearchService.count();
    }


    //查询全部信息 注意翻页查询！
    @ApiOperation(value = "插入文本信息")
    @RequestMapping(path = "/hsmy/infosearch/save", method = RequestMethod.POST)
    @ResponseBody
    public HsmyInfoSearch save(@RequestBody HsmyInfoSearch hsmyInfoSearch)  {
        hsmyInfoSearchService.save(hsmyInfoSearch);
        return  hsmyInfoSearch;
    }


    @RequestMapping(value = "/hsmy/infosearch/title/{pageNum}/{pageSize}/{qryString}",method = RequestMethod.GET)
    @ResponseBody
    public List<HsmyInfoSearch> infoTitleQuery(@PathVariable("pageNum") Integer pageNum,
                                @PathVariable("pageSize") Integer pageSize,
                                @PathVariable("qryString") String qryString) {
        Pageable pageable = new PageRequest(pageNum, pageSize, Sort.Direction.DESC,"title");
        Page<HsmyInfoSearch> infoList = hsmyInfoSearchService.infoTitleQuery(URLDecoder.decode(qryString,"UTF-8"),pageable);
        List<HsmyInfoSearch> content = infoList.getContent();
        return content;
    }


    @RequestMapping(value = "/hsmy/infosearch/content/{pageNum}/{pageSize}/{qryString}",method = RequestMethod.GET)
    @ResponseBody
    public Page<HsmyInfoSearch> infoContentQuery(@PathVariable("pageNum") Integer pageNum,
                                          @PathVariable("pageSize") Integer pageSize,
                                          @PathVariable("qryString") String qryString) {
        Page<HsmyInfoSearch> infoList = hsmyInfoSearchService.infoContentQuery(pageNum,pageSize,URLDecoder.decode(qryString,"UTF-8"));
//        List<HsmyInfoSearch> content = infoList.getContent();
//        return content;
        return infoList;
    }


    @RequestMapping(value = "/hsmy/infosearch/sth/{pageNum}/{pageSize}/{qryString}",method = RequestMethod.GET)
    @ResponseBody
    public Page<HsmyInfoSearch> infoSth(@PathVariable("pageNum") Integer pageNum,
                                                 @PathVariable("pageSize") Integer pageSize,
                                                 @PathVariable("qryString") String qryString) {
        Pageable pageable = new PageRequest(pageNum, pageSize, Sort.Direction.DESC,"title");
        Page<HsmyInfoSearch> infoList = hsmyInfoSearchService.infoSth(URLDecoder.decode(qryString,"UTF-8"),pageable);
        //List<HsmyInfoSearch> content = infoList.getContent();
        return infoList;
    }
}

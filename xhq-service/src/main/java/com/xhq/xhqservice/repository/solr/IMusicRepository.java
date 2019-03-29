/**
 * Project Name: cmam-museum-search
 * File Name: IMusicRepository
 * Package Name: com.migu.cmam.museum.search.repository
 * Date: 2019-02-22  9:31:35 AM
 * All rights Reserved, Designed By MiGu. Copyright: Copyright(C) 2018-2020.
 * Company MiGu Co., Ltd.
 */
package com.xhq.xhqservice.repository.solr;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;

import com.xhq.xhqservice.entity.Music;

/**
 * Description: 音乐solr查询接口.
 *
 * @author wangmingxing
 * @version 1.0
 * @see
 */
public interface IMusicRepository extends SolrCrudRepository<Music, String> {

    /**
     * 搜索音乐
     * 
     * @param keyword  关键字
     * @param pageable 分页信息
     * @return Page<Music>
     */
    // filters = { "contentType:?1 and " }
    @Query(value = "contentName:?0 OR singer:?0 OR albumName:?0 OR composerList:?0 OR lyricistList:?0 OR publishCompany:?0")
    Page<Music> find(String keyword, Pageable pageable);

    /**
     * 查询特定音乐
     * 
     * @param cmamId
     * @return Music
     */
    Music findByCmamId(String cmamId);
}

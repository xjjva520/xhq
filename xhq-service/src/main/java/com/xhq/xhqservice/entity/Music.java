/**
 * Project Name: cmam-museum-search
 * File Name: Music
 * Package Name: com.migu.cmam.museum.search.model
 * Date: 2019-02-21  6:29:29 PM
 * All rights Reserved, Designed By MiGu. Copyright: Copyright(C) 2018-2020.
 * Company MiGu Co., Ltd.
 */
package com.xhq.xhqservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;


/**
 * Description: 音乐信息solr数据结构.
 *
 * @author wangmingxing
 * @version 1.0
 * @see
 */
@SolrDocument(solrCoreName = "my_core")
public class Music  implements SearchableMusicDef {
	 
    private @Id @Indexed String id;
    private @Indexed(CMAMID_FIELD) String cmamId;
    private @Indexed(CONTENTNAME_FIELD) String contentName;
    private @Indexed(CONTENTTYPE_FIELD) String contentType;
    private @Indexed(SINGER_FIELD) String singer;
    private @Indexed(LANGUAGE_FIELD) String language;
    private @Indexed(ALBUMNAME_FIELD) String albumName;
    private @Indexed(INTRO_FIELD) String intro;
    private @Indexed(LYRICISTLIST_FIELD) String lyricistList;
    private @Indexed(COMPOSERLIST_FIELD) String composerList;
    private @Indexed(PUBLISHDATE_FIELD) String publishDate;
    private @Indexed(SONGPATH_FIELD) String songPath;
    private @Indexed(PUBLISHCOMPANY_FIELD) String publishCompany;
    private @Indexed(ISPLAY_FIELD) String isPlay = "1";
    private @Indexed(ALBUMPICS_FIELD) String albumPicS;
    private @Indexed(CMAMCOPYRIGHTID_FIELD) String cmamCopyrightId;
    private @Indexed(DURATION_FIELD) String duration;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCmamId() {
		return cmamId;
	}
	public void setCmamId(String cmamId) {
		this.cmamId = cmamId;
	}
	public String getContentName() {
		return contentName;
	}
	public void setContentName(String contentName) {
		this.contentName = contentName;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getAlbumName() {
		return albumName;
	}
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getLyricistList() {
		return lyricistList;
	}
	public void setLyricistList(String lyricistList) {
		this.lyricistList = lyricistList;
	}
	public String getComposerList() {
		return composerList;
	}
	public void setComposerList(String composerList) {
		this.composerList = composerList;
	}
	public String getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	public String getSongPath() {
		return songPath;
	}
	public void setSongPath(String songPath) {
		this.songPath = songPath;
	}
	public String getPublishCompany() {
		return publishCompany;
	}
	public void setPublishCompany(String publishCompany) {
		this.publishCompany = publishCompany;
	}
	public String getIsPlay() {
		return isPlay;
	}
	public void setIsPlay(String isPlay) {
		this.isPlay = isPlay;
	}
	public String getAlbumPicS() {
		return albumPicS;
	}
	public void setAlbumPicS(String albumPicS) {
		this.albumPicS = albumPicS;
	}
	public String getCmamCopyrightId() {
		return cmamCopyrightId;
	}
	public void setCmamCopyrightId(String cmamCopyrightId) {
		this.cmamCopyrightId = cmamCopyrightId;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	@Override
	public String toString() {
		return "Music [id=" + id + ", cmamId=" + cmamId + ", contentName=" + contentName + ", contentType="
				+ contentType + ", singer=" + singer + ", language=" + language + ", albumName=" + albumName
				+ ", intro=" + intro + ", lyricistList=" + lyricistList + ", composerList=" + composerList
				+ ", publishDate=" + publishDate + ", songPath=" + songPath + ", publishCompany=" + publishCompany
				+ ", isPlay=" + isPlay + ", albumPicS=" + albumPicS + ", cmamCopyrightId=" + cmamCopyrightId
				+ ", duration=" + duration + "]";
	}
    
    
    
}

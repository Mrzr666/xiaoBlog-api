package com.shimh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shimh.entity.Tag;
import com.shimh.dao.TagMapper;
import com.shimh.service.TagService;
import com.shimh.vo.TagVO;

/**
 * @author shimh
 * <p>
 * 2018年1月25日
 */
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;


    @Override
    public List<Tag> findAll() {
        return tagMapper.findAll();
    }

    @Override
    public Tag getTagById(Integer id) {
        return tagMapper.getOne(id);
    }

    @Override
    @Transactional
    public Integer saveTag(Tag tag) {

        return tagMapper.save(tag).getId();
    }

    @Override
    @Transactional
    public Integer updateTag(Tag tag) {
        Tag oldTag = tagMapper.getOne(tag.getId());

        oldTag.setTagname(tag.getTagname());
        oldTag.setAvatar(tag.getAvatar());

        return oldTag.getId();
    }

    @Override
    @Transactional
    public void deleteTagById(Integer id) {
        tagMapper.delete(id);
    }

    @Override
    public List<Tag> listHotTags(int limit) {

        return tagMapper.listHotTagsByArticleUse(limit);
    }

    @Override
    public List<TagVO> findAllDetail() {
        return tagMapper.findAllDetail();
    }

    @Override
    public TagVO getTagDetail(Integer tagId) {
        return tagMapper.getTagDetail(tagId);
    }
}

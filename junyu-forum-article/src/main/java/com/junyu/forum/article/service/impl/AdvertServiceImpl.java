package com.junyu.forum.article.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.junyu.forum.article.mapper.AdvertMapper;
import com.junyu.forum.article.service.IAdvertService;
import com.junyu.forum.article.req.AdvertREQ;
import com.junyu.forum.entities.Advert;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.junyu.forum.util.aliyun.AliyunUtil;
import com.junyu.forum.util.base.Result;
import com.junyu.forum.util.properties.BlogProperties;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 广告信息表 服务实现类
 * </p>
 *
 * @author 梦学谷-www.mengxuegu.com
 */
@Service
public class AdvertServiceImpl extends ServiceImpl<AdvertMapper, Advert> implements IAdvertService {

    @Override
    public Result queryPage(AdvertREQ req) {
        QueryWrapper<Advert> wrapper = new QueryWrapper<>();

        if(StringUtils.isNotEmpty(req.getTitle())) {
            wrapper.like("title", req.getTitle());
        }

        if(req.getStatus() != null) {
            wrapper.eq("status", req.getStatus());
        }

        IPage<Advert> page = baseMapper.selectPage(req.getPage(), wrapper);
        return Result.ok(page);
    }

    @Autowired
    private BlogProperties blogProperties;

    @Transactional
    @Override
    public Result deleteById(String id) {
        // 1. 先通过广告id查询图片url
        String imageUrl = baseMapper.selectById(id).getImageUrl();

        // 2. 先删除表中的广告信息
        baseMapper.deleteById(id);

        // 3. 删除oss上的图片
        if(StringUtils.isNotEmpty(imageUrl)) {
            AliyunUtil.delete(imageUrl, blogProperties.getAliyun());
        }
        return Result.ok();
    }

    @Override
    public Result findByPosition(int position) {
        QueryWrapper<Advert> wrapper = new QueryWrapper<>();
        // 状态是正常的 status=1
        wrapper.eq("status", 1);
        // 位置
        wrapper.eq("position", position);
        // 排序 sort 升序
        wrapper.orderByAsc("sort");

        return Result.ok( baseMapper.selectList(wrapper) );
    }
}

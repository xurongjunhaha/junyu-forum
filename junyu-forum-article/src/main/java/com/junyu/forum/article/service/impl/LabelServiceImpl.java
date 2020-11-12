package com.junyu.forum.article.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.junyu.forum.article.mapper.LabelMapper;
import com.junyu.forum.article.req.LabelREQ;
import com.junyu.forum.entities.Label;
import com.junyu.forum.article.service.ILabelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.junyu.forum.util.base.Result;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 * 标签表 服务实现类
 * </p>
 *
 * @author 梦学谷-www.mengxuegu.com
 */
@Service
public class LabelServiceImpl extends ServiceImpl<LabelMapper, Label> implements ILabelService {

    @Override
    public Result queryPage(LabelREQ req) {
        // 条件分页查询
        IPage<Label> page = baseMapper.queryPage(req.getPage(), req);
        return Result.ok(page);
    }

    @Override
    public boolean updateById(Label label) {
        label.setUpdateDate(new Date());
        return super.updateById(label);
    }
}

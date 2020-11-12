package com.junyu.forum.article.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.junyu.forum.article.req.ArticleListREQ;
import com.junyu.forum.article.req.ArticleREQ;
import com.junyu.forum.article.req.ArticleUserREQ;
import com.junyu.forum.entities.Article;
import com.junyu.forum.feign.req.UserInfoREQ;
import com.junyu.forum.util.base.Result;
import com.junyu.forum.util.enums.ArticleStatusEnum;

/**
 * <p>
 * 文章信息表 服务类
 * </p>
 *
 * @author 梦学谷-www.mengxuegu.com
 */
public interface IArticleService extends IService<Article> {

    /**
     * 条件分页查询文章列表
     * @param req
     * @return
     */
    Result queryPage(ArticleREQ req);

    /**
     * 通过文章id查询文章详情及标签
     * @param id 文章id
     * @return
     */
    Result findArticleAndLabelById(String id);

    /**
     * 修改或新增文章
     * @param article
     * @return
     */
    Result updateOrSave(Article article);

    /**
     * 修改状态：
     * @param id 文章id
     * @param statusEnum 状态枚举类
     * @return
     */
    Result updateStatus(String id, ArticleStatusEnum statusEnum);

    /**
     * 根据用户ID查询公开或未公开的文章列表
     * @param req
     * @return
     */
    Result findListByUserId(ArticleUserREQ req);

    /**
     * 根据文章id更新点赞数
     * @param id 文章id
     * @param count 点赞接收+1，取消点赞 -1
     * @return
     */
    Result updateThumhup(String id, int count);

    /**
     * 更新文章浏览次数
     * @param id 文章id
     * @return
     */
    Result updateViewCount(String id);

    /**
     * 通过分类id或标签id查询公开且已审核通过的文章列表
     * @param req 分类id或标签id、分页对象
     * @return
     */
    Result findListByLabelIdOrCategoryId(ArticleListREQ req);

    /**
     * 统计公开且审核通过的文章数
     * @return
     */
    Result getArticleTotal();

    /**
     * 统计每个分类下的文章数
     * @return
     */
    Result selectCategoryTotal();

    /**
     * 统计近6个月发布的文章数
     * @return
     */
    Result selectMonthArticleTotal();

    /**
     * 更新文章和评论表中的用户信息
     * @param req
     * @return
     */
    boolean updateUserInfo(UserInfoREQ req);

}

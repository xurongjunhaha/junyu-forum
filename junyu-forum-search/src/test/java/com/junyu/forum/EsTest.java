package com.junyu.forum;

import com.junyu.forum.entities.Article;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Date;

/**
 * @author : xrj
 * @Date : 2020/10/17 19:55
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EsTest {

    @Autowired
    JestClient jestClient;

    @Test
    public void test(){
        Article article = new Article();
        article.setId("1");
        article.setCreateDate(new Date());
        article.setTitle("你大爷");
        article.setStatus(1);

        Index index = new Index.Builder(article).index("junyu").type("forum").id("2").build();

        try {
            jestClient.execute(index);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.example.elasticSearch;

import com.alibaba.fastjson.JSON;
import com.example.SJMS.obersver.Teacher;
import com.example.SJMS.obersver.User;
import com.example.SpringbootdemoApplication;
import org.assertj.core.util.Lists;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.common.xcontent.XContentType;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootdemoApplication.class)
public class TestElasticSearch {
//    @Autowired
//    @Qualifier("restHighLevelClient")
//    private RestHighLevelClient client;

    @Autowired
    @Qualifier("restClient2")
    RestHighLevelClient restClient2;

    //测试索引的创建
    @Test
   public void testCreateIndex() throws IOException {

      /*  RestHighLevelClient restClient=new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("127.0.0.1",9200,"http")));*/

        System.out.println("--------CREATE-------");
        //1.创建索引的请求
        CreateIndexRequest request = new CreateIndexRequest("lisen_index2");

        //2客户端执行请求，请求后获得响应
        CreateIndexResponse response = restClient2.indices().create(request, RequestOptions.DEFAULT);
        System.out.println(response);
    }



    //测试索引的创建
    @Test
    public void testDeleteIndex() throws IOException {

        System.out.println("--------DELETE-------");
        //1.创建索引的请求
        DeleteIndexRequest request = new DeleteIndexRequest("lisen_index2");
        //2客户端执行请求，请求后获得响应
        AcknowledgedResponse response = restClient2.indices().delete(request, RequestOptions.DEFAULT);
        System.out.println(response.isAcknowledged());
    }


    //测试为索引添加文档
    @Test
    public void testAddDocument() throws IOException {
        //User userDocumeng=new User("JINGGANG3");
        Teacher userDocumeng =new Teacher();
        userDocumeng.setLevel("A");
        userDocumeng.setName("teacher wu");
        userDocumeng.setStudents(Lists.newArrayList("xiaoxiao"));

        IndexRequest irequest=new IndexRequest("lisen_index2");
        irequest.id("4");
        irequest.timeout("1s");
        System.out.println("----"+JSON.toJSONString(userDocumeng));
        irequest.source(JSON.toJSONString(userDocumeng), XContentType.JSON);

        IndexResponse iresponse=restClient2.index(irequest, RequestOptions.DEFAULT);
        System.out.println(iresponse.toString());



    }

}

package com.example.elasticSearch;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.IOException;

@SpringBootTest
public class TestElasticSearch {
//    @Autowired
//    @Qualifier("restHighLevelClient")
//    private RestHighLevelClient client;

    //测试索引的创建
    @Test
   public void testCreateIndex() throws IOException {

        RestHighLevelClient client=new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("127.0.0.1",9200,"http")));


        System.out.println("---------------");
        //1.创建索引的请求
        CreateIndexRequest request = new CreateIndexRequest("lisen_index");
        //2客户端执行请求，请求后获得响应
        CreateIndexResponse response = client.indices().create(request, RequestOptions.DEFAULT);
        System.out.println(response);
    }


}

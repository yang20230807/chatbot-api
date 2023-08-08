package com.y.chat.api.test;


import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import java.io.IOException;

public class ApiTest {

    @Test
    public void all() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/28885415881451/topics?scope=all&count=20");
        get.addHeader("cookie","sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22189ca2b2ca01f6a-010771d9173f47b-7c546c76-2359296-189ca2b2ca11646%22%2C%22first_id%22%3A%22%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg5Y2EyYjJjYTAxZjZhLTAxMDc3MWQ5MTczZjQ3Yi03YzU0NmM3Ni0yMzU5Mjk2LTE4OWNhMmIyY2ExMTY0NiJ9%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%22%2C%22value%22%3A%22%22%7D%2C%22%24device_id%22%3A%22189ca2b2ca01f6a-010771d9173f47b-7c546c76-2359296-189ca2b2ca11646%22%7D; zsxq_access_token=1FACA765-C7CE-CBC5-D904-540CBC4C4855_F3D1E6EC88314F5A; abtest_env=product; zsxqsessionid=613961f0dc414226518c2e3381d901c0"
        );
        get.addHeader("Content-Type", "application/json;charset=UTF-8");
        CloseableHttpResponse response = httpClient.execute(get);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);

        }else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void comments() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/411882248452128/comments");

        post.addHeader("cookie","sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22189ca2b2ca01f6a-010771d9173f47b-7c546c76-2359296-189ca2b2ca11646%22%2C%22first_id%22%3A%22%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg5Y2EyYjJjYTAxZjZhLTAxMDc3MWQ5MTczZjQ3Yi03YzU0NmM3Ni0yMzU5Mjk2LTE4OWNhMmIyY2ExMTY0NiJ9%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%22%2C%22value%22%3A%22%22%7D%2C%22%24device_id%22%3A%22189ca2b2ca01f6a-010771d9173f47b-7c546c76-2359296-189ca2b2ca11646%22%7D; zsxq_access_token=1FACA765-C7CE-CBC5-D904-540CBC4C4855_F3D1E6EC88314F5A; abtest_env=product; zsxqsessionid=613961f0dc414226518c2e3381d901c0"
        );
        post.addHeader("Content-Type", "application/json;charset=UTF-8");
        String paramJson = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"我不会\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"mentioned_user_ids\": []\n" +
                "  }\n" +
                "}";
        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "utf-8"));
        post.setEntity(stringEntity);
        CloseableHttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);

        }else {
            System.out.println(response.getStatusLine().getStatusCode());
        }

    }
}

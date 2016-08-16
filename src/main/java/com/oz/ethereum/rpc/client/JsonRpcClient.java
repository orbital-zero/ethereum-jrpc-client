package com.oz.ethereum.rpc.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oz.utils.StringUtils;
import lombok.Setter;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * <p><b>Created:</b> 16/08/16, 03:42 PM</p>
 * @author <a href="mailto:samuel.quintana@globant.com">samuel</a>
 * @since 1.0
 */
public class JsonRpcClient {

    @Setter
    private ObjectMapper mapper;
    @Setter
    private String urlJsonRpcEthereum;
    private CloseableHttpClient httpClient;

    public JsonRpcClient(String urlJsonRpcEthereum) {
        super();
        this.urlJsonRpcEthereum = urlJsonRpcEthereum;
        this.mapper = new ObjectMapper();
        this.httpClient = HttpClients.createDefault();
    }

    public <U> U execute(JsonRpcRequest dataIn, Class<U> classOut) throws IOException {
        String json = this.mapper.writeValueAsString(dataIn);
        HttpPost post = new HttpPost(this.urlJsonRpcEthereum);
        StringEntity body = new StringEntity(json);
        post.setEntity(body);
        CloseableHttpResponse response = httpClient.execute(post);
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String line;
        StringBuilder sb = new StringBuilder();

        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }

        return this.mapper.readValue(sb.toString(), classOut);
    }

}

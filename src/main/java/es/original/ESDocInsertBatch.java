package es.original;

import com.alibaba.fastjson.JSON;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.common.xcontent.XContentType;
import es.vo.User;

public class ESDocInsertBatch extends AbstractESOperation {

    public ESDocInsertBatch(String address,int port,String schema){
        super(address, port, schema);
    }

    @Override
    public Object doAction() throws Exception {

        BulkRequest request = new BulkRequest();

        request.add(new IndexRequest().index("userexample").id("10001").source(JSON.toJSONString(new User("xiao min yan","male",33,"coding")),XContentType.JSON));

        request.add(new IndexRequest().index("userexample").id("10002").source(JSON.toJSONString(new User("chen zhan","female",30,"working")),XContentType.JSON));

        request.add(new IndexRequest().index("userexample").id("10003").source(JSON.toJSONString(new User("xiao min long","male",33,"playing")),XContentType.JSON));

        request.add(new IndexRequest().index("userexample").id("10004").source(JSON.toJSONString(new User("xiao chen xi","male",2,"destroying")),XContentType.JSON));

        BulkResponse responses = esClient.bulk(request, RequestOptions.DEFAULT);

        return responses;
    }
}

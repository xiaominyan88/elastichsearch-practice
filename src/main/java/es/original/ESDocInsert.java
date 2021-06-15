package es.original;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.common.xcontent.XContentType;
import es.vo.User;

public class ESDocInsert extends AbstractESOperation {

    public ESDocInsert(String address,int port,String schema){
        super(address,port,schema);
    }

    @Override
    public Object doAction() throws Exception {

        IndexRequest request = new IndexRequest();
        request.index("userexample").id("10001");

        ObjectMapper mapper = new ObjectMapper();
        String userJSON = mapper.writeValueAsString(new User("xiao min yan","male",33,"coding"));
        request.source(userJSON,XContentType.JSON);

        IndexResponse response = esClient.index(request, RequestOptions.DEFAULT);

        return response;

    }
}

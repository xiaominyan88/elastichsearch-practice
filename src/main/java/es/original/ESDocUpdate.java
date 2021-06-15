package es.original;

import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.common.xcontent.XContentType;

public class ESDocUpdate extends AbstractESOperation {

    public ESDocUpdate(String address,int port,String schema){
        super(address,port,schema);
    }

    @Override
    public Object doAction() throws Exception {

        UpdateRequest request = new UpdateRequest();
        request.index("userexample").id("10001").doc(XContentType.JSON,"age","28");

        UpdateResponse updateResponse = esClient.update(request, RequestOptions.DEFAULT);
        return updateResponse;
    }
}

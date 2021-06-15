package es.original;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.metrics.MaxAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;

public class ESDocQueryAggregationPeak extends AbstractESOperation {

    public ESDocQueryAggregationPeak(String address,int port,String schema){
        super(address, port, schema);
    }

    @Override
    public Object doAction() throws Exception {
        SearchRequest request = new SearchRequest();
        request.indices("userexample");
        MaxAggregationBuilder builder = AggregationBuilders.max("ageMax").field("age");
        SearchSourceBuilder aggregation = new SearchSourceBuilder().aggregation(builder);
        request.source(aggregation);
        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
        return response;
    }
}

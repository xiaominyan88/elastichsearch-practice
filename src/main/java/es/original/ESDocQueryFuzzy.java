package es.original;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.FuzzyQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;

public class ESDocQueryFuzzy extends AbstractESOperation {

    public ESDocQueryFuzzy(String address,int port,String schema){
        super(address,port,schema);
    }

    @Override
    public Object doAction() throws Exception {
        SearchRequest request = new SearchRequest();
        request.indices("userexample");
        FuzzyQueryBuilder fuzzyQueryBuilder = QueryBuilders.fuzzyQuery("name", "xiao").fuzziness(Fuzziness.AUTO);
        SearchSourceBuilder query = new SearchSourceBuilder().query(fuzzyQueryBuilder);
        request.source(query);
        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
        return response;
    }
}

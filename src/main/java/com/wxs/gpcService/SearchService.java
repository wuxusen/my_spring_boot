package com.wxs.gpcService;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.wxs.grpc.GRpcService;
import com.wxs.grpc.LogInterceptor;
import com.wxs.model.Country;
import com.wxs.service.CountryService;
import io.grpc.examples.SearchGrpc;
import io.grpc.examples.SearchProto;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Administrator on 2017/2/22.
 */
@GRpcService(interceptors = { LogInterceptor.class })
public class SearchService extends SearchGrpc.SearchImplBase {

    @Autowired
    private CountryService countryService;

    @Override
    public void sayHello(SearchProto.SearchRequest request, StreamObserver<SearchProto.SearchReply> responseObserver) {
        // 获得请求数据
        String query = request.getQuery();
        int number = request.getPageNumber();
        int page = request.getResultPerPage();

        // ---------------------此处 处理业务逻辑----------------------------
        Country country = new Country();
        country.setPage(number);
        country.setRows(page);
        List<Country> list = countryService.getAll(country);
        PageInfo<Country> pageInfo = new PageInfo<>(list);

        Gson gson = new Gson();
        String str = gson.toJson(pageInfo);
        //--------------------------------------------------

        //  构建响应数据
        SearchProto.SearchReply.Builder replyBuilder = SearchProto.SearchReply.newBuilder().
                                    setMessage(str).setPageNumber(number).setResultPerPage(page).setTotalPage("");

        // 返回响应数据
        responseObserver.onNext(replyBuilder.build());
        // 响应完成
        responseObserver.onCompleted();

    }
}

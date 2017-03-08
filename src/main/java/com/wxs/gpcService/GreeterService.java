package com.wxs.gpcService;

import com.alibaba.druid.support.json.JSONUtils;
import com.google.gson.Gson;
import com.wxs.grpc.GRpcService;
import com.wxs.grpc.LogInterceptor;
import com.wxs.model.Country;
import com.wxs.service.CountryService;
import io.grpc.examples.GreeterGrpc;
import io.grpc.examples.HelloWorldProto;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@GRpcService(interceptors = { LogInterceptor.class })
public class GreeterService extends GreeterGrpc.GreeterImplBase {

	@Autowired
	private CountryService countryService;

	@Override
	public void sayHello(HelloWorldProto.HelloRequest request, StreamObserver<HelloWorldProto.HelloReply> responseObserver) {

		List<Country> all = countryService.getAll(null);
		Gson gson = new Gson();
		String str = gson.toJson(all);
		final HelloWorldProto.HelloReply.Builder replyBuilder = HelloWorldProto.HelloReply.newBuilder().setMessage("服务器返回数据 ： " + str);
		responseObserver.onNext(replyBuilder.build());
		responseObserver.onCompleted();
	}
}
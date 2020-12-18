package study.spring.springhelper.helper;

import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Slf4j
public class RetrofitHelper
{
	/*
	Retrofit 객체를 생성하고 기본 설정들을 적용한 후 리턴한다.
	@param baseUrl - 접근하고자 하는 API의 기본 주소 (ex: http//도메인)
	@return Retrofit 객체
	*/
	public Retrofit getRetrofit(String baseUrl)
	{
		// 통신 객체를 생성하기 위한 Builer 객체 정의 -> import okhttp3.OkHttpClient;
		OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
		
		// Builder를 통해 통신객체 생성 -> import okhttp3.OkHttpClient;
		OkHttpClient httpClient = httpClientBuilder.build();
		
		// Retrofit을 생성하는 기능을 수행하는 객체 정의
		Retrofit.Builder builder = new Retrofit.Builder();
		
		// 기본 주소를 지정한다.
		builder.baseUrl(baseUrl);
		
		// 통신 결과를 Gson 객체를 통해 처리하도록 Gson을 연결한다. --> JSON 파싱 자동화
		builder.addConverterFactory(GsonConverterFactory.create());
		
		// 통신객체를 연결한다.
		builder.client(httpClient);
		
		// 모든 설정이 반영된 Retrofit 객체 생성 -> import retrofit2.Retrofit;
		Retrofit retrofit = builder.build();
		
		// 결과 리턴
		return retrofit;
		
	}

}

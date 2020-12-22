package study.spring.springhelper.service;

import retrofit2.Call;
import retrofit2.http.GET;
import study.spring.springhelper.model.Simple;

public interface ApiSimpleService
{
	public static final String BASE_URL = "http://itpater.co.kr";
	
	@GET("/demo/java/simple.json") 	// baseUrl과 조합되어 완전한 URL을 구서앻야 함
	Call<Simple> getSimple();

}

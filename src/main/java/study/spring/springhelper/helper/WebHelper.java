package study.spring.springhelper.helper;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.AbstractView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WebHelper
{
	private String encType;

	private HttpServletRequest request;
	private HttpServletResponse response;

	public void init(HttpServletRequest request, HttpServletResponse response)
	{
		this.request = request;
		this.response = response;

		String methodName = request.getMethod();
		String url = request.getRequestURL().toString();
		String queryString = request.getQueryString();

		if (queryString != null)
		{
			url = url + "?" + queryString;
		}

		log.debug(String.format("[%s] %s", methodName, url));

		try
		{
			this.request.setCharacterEncoding(this.encType);
			this.response.setCharacterEncoding(this.encType);
		} catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
	}

	/*
	 * 메시지 표시 후, 페이지를 지정된 곳으로 이동한다.
	 * 
	 * @param url - 이동할 페이지의 URL, Null일 경우 이전페이지로 이동
	 * 
	 * @param msg - 화면에 표시할 메시지. Null일 경우 표시 안함
	 * 
	 * @return ModelAndView
	 */
	public ModelAndView redirect(String url, String msg)
	{

		// 획득한 정보를 로그로 표시한다.
		log.debug(String.format("--> [redirect] %s >> %s", url, msg));

		// 가상의 View로 만들기 위한 HTML 태그 구성
		String html = "<!doctype html>";
		html += "<html>";
		html += "<head>";
		html += "<meta charset='" + this.encType + "'>";

		if (msg != null)
		{
			html += "<script type='text/javascript'>alert('" + msg + "');</script>";
		}

		if (url != null)
		{
			html += "<meta http-equiv='refresh' content='0; url=" + url + "'/>";
		} else
		{
			html += "<script type='text/javascript'>history.back();</script>";
		}
		html += "</head>";
		html += "<body></body>";
		html += "</html>";

		return this.virtualView(html);

	}

	/*
	 * 파라미터로 받은 내용을 가상의 View로 생성후 리턴한다. 브라우저에게 전달할 HTML, CSS, JS 조합을 출력하기 위해 사용한다.
	 * 
	 * @param body - 브라우저에게 전달할 HTML, CSS, JS 조합 문자열
	 * 
	 * @return ModelAndView
	 */
	public ModelAndView virtualView(final String body)
	{
		// 가상의 View를 익명 클래스 방식으로 생성하여 리턴
		View view = new AbstractView()
		{

			@Override
			protected void renderMergedOutputModel(Map<String, Object> map, HttpServletRequest request,
					HttpServletResponse response) throws Exception
			{
				PrintWriter out = response.getWriter();
				out.println(body);
				out.flush();
			}
		};

		// 가상의 뷰를 리턴한다.
		return new ModelAndView(view);
	}

	// Getter, Setter
	public String getEncType()
	{
		return encType;
	}

	public void setEncType(String encType)
	{
		this.encType = encType;
	}

	public HttpServletRequest getRequest()
	{
		return request;
	}

	public void setRequest(HttpServletRequest request)
	{
		this.request = request;
	}

	public HttpServletResponse getResponse()
	{
		return response;
	}

	public void setResponse(HttpServletResponse response)
	{
		this.response = response;
	}
}

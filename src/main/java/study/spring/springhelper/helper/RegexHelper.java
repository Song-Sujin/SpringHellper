package study.spring.springhelper.helper;

import java.util.regex.Pattern;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RegexHelper
{
	// 빈 문자열 여부 검사를 위한 메서드
	public boolean isValue(String str)
	{
		boolean result = false;
		if (str != null)
		{
			result = !str.trim().equals("");
		}
		if (result)
		{
			log.debug(String.format("(regex) -> '%s' (은)는 빈 문자열이 아닙니다.", str));
		} else
		{
			log.debug(String.format("(regex) -> '%s' (은)는 빈 문자열입니다.", str));
		}
		return result;
	}

	// 숫자형식이 맞는지 검사하는 메서드
	public boolean isNum(String str)
	{
		boolean result = false;
		if (isValue(str))
		{
			result = Pattern.matches("^[0-9]*$", str);
		}
		if (result)
		{
			log.debug(String.format("(regex) -> '%s' (은)는 숫자 형식이 맞습니다.", str));
		} else
		{
			log.debug(String.format("(regex) -> '%s' (은)는 숫자 형식이 아닙니다.", str));
		}
		return result;
	}

	// 영문으로만 구성되었는지 검사하는 메서드
	public boolean isEng(String str)
	{
		boolean result = false;
		if (isValue(str))
		{
			result = Pattern.matches("^[a-zA-Z]*$", str);
		}
		if (result)
		{
			log.debug(String.format("(regex) -> '%s' (은)는 영어로만 구성되어 있습니다.", str));
		} else
		{
			log.debug(String.format("(regex) -> '%s' (은)는 영어로만 구성되어 있지 않습니다.", str));
		}
		return result;
	}

	// 한글여부를 검사하는 메서드
	public boolean isKor(String str)
	{
		boolean result = false;
		if (isValue(str))
		{
			result = Pattern.matches("^[ㄱ-ㅎ가-힣]*$", str);
		}
		if (result)
		{
			log.debug(String.format("(regex) -> '%s' (은)는 한글로만 구성되어 있습니다.", str));
		} else
		{
			log.debug(String.format("(regex) -> '%s' (은)는 한글로만 구성되어 있지 않습니다.", str));
		}
		return result;
	}

	// 영문과 숫자로 구성되었는지 검사하는 메서드
	public boolean isEngNum(String str)
	{
		boolean result = false;
		if (isValue(str))
		{
			result = Pattern.matches("^[a-zA-Z0-9]*$", str);
		}
		if (result)
		{
			log.debug(String.format("(regex) -> '%s' (은)는 영어+숫자 조합이 맞습니다.", str));
		} else
		{
			log.debug(String.format("(regex) -> '%s' (은)는 영어+숫자 조합이 아닙니다.", str));
		}
		return result;
	}

	// 한글과 숫자로만 구성되었는지 검사하는 메서드
	public boolean isKorNum(String str)
	{
		boolean result = false;
		if (isValue(str))
		{
			result = Pattern.matches("^[ㄱ-ㅎ가-힣0-9]*$", str);
		}
		if (result)
		{
			log.debug(String.format("(regex) -> '%s' (은)는 한글+숫자 조합이 맞습니다.", str));
		} else
		{
			log.debug(String.format("(regex) -> '%s' (은)는 한글+숫자 조합이 아닙니다.", str));
		}
		return result;
	}

	// 이메일 형식이 맞는지 검사하는 메서드
	public boolean isEmail(String str)
	{
		boolean result = false;
		if (isValue(str))
		{
			result = Pattern.matches("^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$",
					str);
		}
		if (result)
		{
			log.debug(String.format("(regex) -> '%s' (은)는 이메일 형식이 맞습니다.", str));
		} else
		{
			log.debug(String.format("(regex) -> '%s' (은)는 이메일 형식이 아닙니다.", str));
		}
		return result;
	}

	// 핸드폰 형식이 맞는지 검사하는 메서드
	public boolean isCellphone(String str)
	{
		boolean result = false;
		if (isValue(str))
		{
			result = Pattern.matches("^01(?:0|1|[6-9])(?:\\d{3}|\\d{4})\\d{4}$", str);
		}
		if (result)
		{
			log.debug(String.format("(regex) -> '%s' (은)는 핸드폰 번호 형식이 맞습니다.", str));
		} else
		{
			log.debug(String.format("(regex) -> '%s' (은)는 핸드폰 번호 형식이 아닙니다.", str));
		}
		return result;
	}

	// 전화번호 형식이 맞는지 검사하는 메서드
	public boolean isTel(String str)
	{
		boolean result = false;
		if (isValue(str))
		{
			result = Pattern.matches("^\\d{2,3}\\d{3,4}\\d{4}$", str);
		}
		if (result)
		{
			log.debug(String.format("(regex) -> '%s' (은)는 전화번호 형식이 맞습니다.", str));
		} else
		{
			log.debug(String.format("(regex) -> '%s' (은)는 전화번호 형식이 아닙니다.", str));
		}
		return result;
	}

	// 주민번호 형식검사
	public boolean isJumin(String str)
	{
		boolean result = false;
		if (isValue(str))
		{
			result = Pattern.matches("^\\d{6}[1-4]\\d{6}", str);
		}
		if (result)
		{
			log.debug(String.format("(regex) -> '%s' (은)는 주민번호 형식이 맞습니다.", str));
		} else
		{
			log.debug(String.format("(regex) -> '%s' (은)는 주민번호 형식이 아닙니다.", str));
		}
		return result;
	}
}

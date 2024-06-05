package http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpGetClient {

	public static void main(String[] args) {

		// 자바 기본 코드로 http 요청을 만들어 보자.

		// HTTP 통신을 하기 위한 준비물
		// 서버 주소(경로 준비)
		String urlString = "https://jsonplaceholder.typicode.com/todos/5";
		// 링크 => 자바 기준으로는 아직 문자열임.

		// 1. URL 클래스를 만들어준다.
		// 2. Connection 객체를 만들어 준다. (URL --> 멤버로 Connection 객체를 뽑을 수 있다.)

		try {
			URL url = new URL(urlString);
			// url.openConnection() 연결 요청 진행
			HttpURLConnection conn = (HttpURLConnection) url.openConnection(); // 다운 캐스팅

			// 추가 설정을 할 수 있다.
			// Method 방식 설정(약속) -- GET 요청은 해당 서버의 자원 요청이다.
			conn.setRequestMethod("GET");

			// HTTP 응답 메시지에서 데이터를 추출할 수 있다.
			int responseCode = conn.getResponseCode();
			System.out.println("HTTP CODE : " + responseCode);
			// 200 -> 통신 성공(네이버 서버가 클라이언트에게 응답함)
			// 404 --> 자원, 프로토콜, 페이지를 찾을 수 없다.

			BufferedReader brIn = new BufferedReader(new InputStreamReader(conn.getInputStream())); 
			// 소켓 기반이라 스트림을 열어서 데이터를 받을 수 있다.
			
			String inputLine;
			StringBuffer responseBuffer = new StringBuffer(); // 메모리 낭비가 심하기 때문에 StringBuffer 사용

			while ((inputLine = brIn.readLine()) != null) {
				responseBuffer.append(inputLine);
			}
			brIn.close();
			// System.out.println(responseBuffer.toString());
			String[] strHtmls = responseBuffer.toString().split("\\s"); // 긴 문자열을 잘라서 인덱스만큼 넣음
			System.out.println("index count : " + strHtmls.length);
			for (String word : strHtmls) {
				System.out.println(word);
				// System.out.println(); // 한 줄 띄우기
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}// end of main
}

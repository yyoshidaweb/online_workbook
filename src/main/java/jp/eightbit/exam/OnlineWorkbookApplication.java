package jp.eightbit.exam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class OnlineWorkbookApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(OnlineWorkbookApplication.class, args);
	}
	
//	Warファイル作成のための記述
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(OnlineWorkbookApplication.class);
	}

}

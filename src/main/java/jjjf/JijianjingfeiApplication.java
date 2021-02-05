package jjjf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@ServletComponentScan
@SpringBootApplication
//@ComponentScan(basePackages = "jjjf.*")
@MapperScan(basePackages = "jjjf.**.dao")
public class JijianjingfeiApplication {

	public static void main(String[] args) {
		SpringApplication.run(JijianjingfeiApplication.class, args);
	}

}

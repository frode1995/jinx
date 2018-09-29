package frode.jinx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/*@EntityScan(basePackages = "frode.jinx.domain")
@EnableJpaRepositories(basePackages = "frode.jinx.dao")*/
@SpringBootApplication
public class JinxApplication {

    public static void main(String[] args) {
        SpringApplication.run(JinxApplication.class, args);
    }
}

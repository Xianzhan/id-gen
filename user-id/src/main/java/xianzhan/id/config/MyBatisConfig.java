package xianzhan.id.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author xianzhan
 * @since 2020-07-15
 */
@Configuration
@MapperScan("xianzhan.id.mapper")
public class MyBatisConfig {
}

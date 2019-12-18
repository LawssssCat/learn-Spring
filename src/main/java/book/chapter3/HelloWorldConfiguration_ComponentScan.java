package book.chapter3;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//扫描包（子包）内标签
//@Component、@Service、(会扫描，但这里没有@Controller、@Repository)
@ComponentScan(basePackages = {"book.chapter3"})
@Configuration
public class HelloWorldConfiguration_ComponentScan {}

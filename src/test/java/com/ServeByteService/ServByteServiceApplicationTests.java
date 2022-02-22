package com.ServeByteService;

//import com.ServeByteService.data.repository.CityRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
//@Sql(scripts = "/data/insert.sql")
@Slf4j
class ServByteServiceApplicationTests {
	@Value("${test.property.name}")
	private String testName;

	@Autowired
	private DataSource dataSource;

	@Test
	void valueExistsTest() {
		assertThat(testName).isEqualTo("ServByte");
		log.info(testName);
	}

}

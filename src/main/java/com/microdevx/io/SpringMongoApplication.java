package com.microdevx.io;

import com.microdevx.io.constants.Gender;
import com.microdevx.io.model.Address;
import com.microdevx.io.model.Student;
import com.microdevx.io.repository.StudentRepository;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class SpringMongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMongoApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(StudentRepository studentRepository)
	{
		return args -> {
			Address address = Address
					.builder()
					.cityName("Karachi")
					.country("Pakistan")
					.postCode("123")
					.build();
			String email = "khosozain@gmail.com";
			Student student = Student
					.builder()
					.firstName("Zain")
					.lastName("Ali")
					.email(email)
					.favoriteSubjects(Arrays.asList("Java","Maths"))
					.gender(Gender.MALE)
					.totalSpentInBooks(BigDecimal.valueOf(200))
					.createdAt(LocalDate.now())
					.address(address)
					.build();

			studentRepository
					.findStudentByEmail(email)
					.ifPresentOrElse(
							s->  System.out.println("User already exits with this email."),
							()-> studentRepository.insert(student));
		};
	}

}

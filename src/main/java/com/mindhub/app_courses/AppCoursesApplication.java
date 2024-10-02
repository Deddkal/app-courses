package com.mindhub.app_courses;

import com.mindhub.app_courses.models.*;
import com.mindhub.app_courses.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

@SpringBootApplication
public class AppCoursesApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppCoursesApplication.class, args);
	}

	@Autowired
	private PasswordEncoder passwordEncoder;
	@Bean
	public CommandLineRunner initData(AdminRepository adminRepository, StudentRepository studentRepository, PersonRepository personRepository, TeacherRepository teacherRepository, CourseRepository courseRepository,
									  WorkshopRepository workshopRepository, ClassRoomRepository classRoomRepository){
		return args -> {
			Admin admin = new Admin( "Admin", "admin@mindhub.com", passwordEncoder.encode("123456") );
			adminRepository.save(admin);
			Student student = new Student("Student" , "student@mindhub.com", passwordEncoder.encode("123456"), "Melba");
			studentRepository.save(student);
			Teacher teacher = new Teacher("Teacher", "teacher@mindhub.com", passwordEncoder.encode("123456"), "JAVA");
			teacherRepository.save(teacher);

			Course course = new Course("JAVA", "Course of JAVA");
			teacher.addCourse(course);
			courseRepository.save(course);

			ClassRoom classRoom = new ClassRoom( 20, "AO123" );
			classRoomRepository.save(classRoom);
			ClassRoom classRoom1 = new ClassRoom( 20, "AO123" );
			classRoomRepository.save(classRoom1);

			WorkShop workShop = new WorkShop(LocalDateTime.now().plusHours(1L));
			course.addWorkshop(workShop);
			classRoom.addWorkshop(workShop);
			workshopRepository.save(workShop);

			student.addWorkshop(workShop);
//			studentRepository.save(student);
			workshopRepository.save(workShop);
//			Person algo = personRepository.findById(1L).orElse(null);
//
//			System.out.println( algo instanceof Student);
			System.out.println(workshopRepository.existsByStartDateBetween(LocalDateTime.now().minusMinutes(30L), LocalDateTime.now().plusMinutes(30L)));

			System.out.println(workshopRepository.existsByStartDateBetweenOrEndDateBetween(
					LocalDateTime.now().minusMinutes(30L), LocalDateTime.now().plusMinutes(30L),
					LocalDateTime.now().plusMinutes(30L), LocalDateTime.now().plusMinutes(160L)));

			System.out.println(workshopRepository.existsByClassRoomAndEndDateBetween(
					classRoom1,
					LocalDateTime.now().plusMinutes(30L), LocalDateTime.now().plusMinutes(160L)));
		};
	}
}

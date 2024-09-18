package com.mindhub.app_courses;

import com.mindhub.app_courses.models.*;
import com.mindhub.app_courses.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class AppCoursesApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppCoursesApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(AdminRepository adminRepository, StudentRepository studentRepository, PersonRepository personRepository, TeacherRepository teacherRepository, CourseRepository courseRepository,
									  WorkshopRepository workshopRepository, ClassRoomRepository classRoomRepository){
		return args -> {
			Admin admin = new Admin( "Admin", "admin@mindhub.com", "123456" );
			adminRepository.save(admin);
			Student student = new Student("Student" , "student@mindhub.com", "123456", "Melba");
			studentRepository.save(student);
			Teacher teacher = new Teacher("Teacher", "teacher@mindhub.com", "123456", "JAVA");
			teacherRepository.save(teacher);

			Course course = new Course("JAVA", "Course of JAVA");
			teacher.addCourse(course);
			courseRepository.save(course);

			ClassRoom classRoom = new ClassRoom( 20, "AO123" );
			classRoomRepository.save(classRoom);

			WorkShop workShop = new WorkShop(LocalDateTime.now().plusHours(2L));
			course.addWorkshop(workShop);
			classRoom.addWorkshop(workShop);
			workshopRepository.save(workShop);

			student.addWorkshop(workShop);
//			studentRepository.save(student);
			workshopRepository.save(workShop);
//			Person algo = personRepository.findById(1L).orElse(null);
//
//			System.out.println( algo instanceof Student);

		};
	}
}

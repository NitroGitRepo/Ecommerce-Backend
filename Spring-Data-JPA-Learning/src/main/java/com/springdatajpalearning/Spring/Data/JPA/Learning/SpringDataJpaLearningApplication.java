package com.springdatajpalearning.Spring.Data.JPA.Learning;

import com.springdatajpalearning.Spring.Data.JPA.Learning.models.Laptop;
import com.springdatajpalearning.Spring.Data.JPA.Learning.models.Student;
import com.springdatajpalearning.Spring.Data.JPA.Learning.models.models2.Category;
import com.springdatajpalearning.Spring.Data.JPA.Learning.models.models2.Product;
import com.springdatajpalearning.Spring.Data.JPA.Learning.models1.Address;
import com.springdatajpalearning.Spring.Data.JPA.Learning.models1.Student1;
import com.springdatajpalearning.Spring.Data.JPA.Learning.repositories.CategoryRepository;
import com.springdatajpalearning.Spring.Data.JPA.Learning.repositories.LaptopRepository;
import com.springdatajpalearning.Spring.Data.JPA.Learning.repositories.ProductRepository;
import com.springdatajpalearning.Spring.Data.JPA.Learning.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringDataJpaLearningApplication {

	static StudentRepository studentRepository;
	static LaptopRepository laptopRepository;
	SpringDataJpaLearningApplication(StudentRepository studentRepository, LaptopRepository laptopRepository){
		this.studentRepository  = studentRepository;
		this.laptopRepository = laptopRepository;
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaLearningApplication.class, args);
//
//			Student st1 = new Student();
//			st1.setStudentName("Rajneesh Yadav");
//			st1.setAbout("Software Engioneer");
//			st1.setStudentId(101);
//			studentRepository.save(st1);
//
//
//		Student st2 = new Student();
//		st2.setStudentName("Rohan Jain");
//		st2.setAbout("Software Engioneer");
//		st2.setStudentId(102);
//		studentRepository.save(st2);
//
//
//		Laptop l1 = new Laptop();
//		l1.setLaptopId(101);
//		l1.setBrand("Apple");
//		l1.setModelNumber("App5233");
//		l1.setStudent(st1);
//
//		//laptopRepository.save(l1);
//
//
//
//			System.out.println(st1);



		//one to many
//		Student1 st = new Student1();
//		st.setStudentName("Rajneesh");
//		st.setAbout("Engineer");
//		st.setStudentId(101);
//
//		Address a1 = new Address();
//		a1.setStreet("Jabalputr");
//		a1.setCity("Lucknow");
//		a1.setCountry("Indoa");
//		a1.setStudent1(st);
//
//		Address a2 = new Address();
//		a2.setStreet("Japan");
//		a2.setCity("Lucknow");
//		a2.setCountry("Indoa");
//
//
//		ArrayList<Address> al = new ArrayList();
//		al.add(a1);
//		al.add(a2);
//
//		st.setAddress(al);
//
//		studentRepository.save(st);


		//many to many
//		Product p1 = new Product();
//		p1.setPId("101");
//		p1.setProductName("Samsung s23");
//
//		Product p2 = new Product();
//		p2.setProductName("Samsung s24");
//		p2.setPId("102");
//
//		Product p3 = new Product();
//		p3.setProductName("Samsung s25");
//		p3.setPId("103");
//
//
//		Category c1  =new Category();
//		c1.setCId("1");
//		c1.setTitle("Electronics");
//
//		Category c2 =  new Category();
//		c2.setCId("2");
//        c2.setTitle("Mobile");
//
//
//		List<Product> category1 = c1.getProductList();
//		category1.add(p1);
//		category1.add(p2);
//		category1.add(p3);
//
//		List<Product> category2 = c2.getProductList();
//		category2.add(p1);
//		category2.add(p2);
//
//		categoryRepository.save(c1);
//		categoryRepository.save(c2);




	}

	@Autowired
	public static CategoryRepository categoryRepository;

	@Autowired
	public ProductRepository productRepository;

}

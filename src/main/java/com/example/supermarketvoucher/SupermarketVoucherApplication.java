package com.example.supermarketvoucher;

import com.example.supermarketvoucher.dao.ProductDao;
import com.example.supermarketvoucher.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
@RequiredArgsConstructor
public class SupermarketVoucherApplication {

	private final ProductDao productDao;

	@Bean
	@Transactional
//	@Profile("data")
	public ApplicationRunner runner(){
			return r ->{

				Product product1 = new Product("Beef",2000,"http://source.unsplash.com/400x300/?beef");
				Product product2 = new Product("Shampoo",5000,"http://source.unsplash.com/400x300/?shampoo");
				Product product3 = new Product("Makeup",3000,"http://source.unsplash.com/400x300/?makeup");
				Product product4 = new Product("Wine",10000,"http://source.unsplash.com/400x300/?winebottle");
				Product product5 = new Product("Clothes",15000,"http://source.unsplash.com/400x300/?clothes");
				Product product6 = new Product("pizza",2000,"http://source.unsplash.com/400x300/?pizza");

				productDao.save(product1);
				productDao.save(product2);
				productDao.save(product3);
				productDao.save(product4);
				productDao.save(product5);
				productDao.save(product6);

			};
	}

	public static void main(String[] args) {
		SpringApplication.run(SupermarketVoucherApplication.class, args);
	}

}

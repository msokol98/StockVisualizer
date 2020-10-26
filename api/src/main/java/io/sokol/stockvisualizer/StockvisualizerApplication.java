package io.sokol.stockvisualizer;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class StockvisualizerApplication{
	public static void main(String[] args) {
		SpringApplication.run(StockvisualizerApplication.class, args);
	}
}
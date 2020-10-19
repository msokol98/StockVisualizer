package io.sokol.stockvisualizer;

import io.sokol.stockvisualizer.entity.StockDay;
import io.sokol.stockvisualizer.repository.StockDayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@EnableScheduling
public class StockvisualizerApplication implements CommandLineRunner {

	@Autowired
	private StockDayRepository sdr;

	public static void main(String[] args) {
		SpringApplication.run(StockvisualizerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<StockDay> stockDays = sdr.findByDate(LocalDate.of(1990, 6, 19));
		stockDays.stream().filter(stockDay -> stockDay.getStock().getSymbol().contentEquals("AAPL")).forEach(System.out::println);
	}
}

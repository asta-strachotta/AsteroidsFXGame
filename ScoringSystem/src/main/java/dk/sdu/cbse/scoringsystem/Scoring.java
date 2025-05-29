package dk.sdu.cbse.scoringsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class Scoring{

	private int totalScore = 0;

	public static void main(String[] args) {
		SpringApplication.run(Scoring.class, args);
	}

	@GetMapping("/score/get")
	public int getScore() {
		return totalScore;
	}


	@PutMapping("/score/add/{score}")
	public int putScore(@PathVariable(value = "score") int score){
		totalScore += score;
		return totalScore;
	}
}

package dk.sdu.cbse.scoringservice;

import dk.sdu.cbse.common.services.IScoreService;
import org.springframework.web.client.RestTemplate;

public class ScoringService implements IScoreService {

    private RestTemplate restTemplate = new RestTemplate();
    private final String URL = "http://localhost:8080";

    public ScoringService(){}

    @Override
    public void putScore(int score) {
        restTemplate.put(URL + "/score/add/" + score, null);
        System.out.println("put score: " + score);
    }

    @Override
    public String getScore() {
        String score = restTemplate.getForObject(URL + "/score/get", String.class);
        System.out.println("get score: " + score);
        return score;
    }
}

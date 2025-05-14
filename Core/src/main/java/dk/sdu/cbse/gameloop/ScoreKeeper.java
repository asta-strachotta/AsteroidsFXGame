package dk.sdu.cbse.gameloop;


import dk.sdu.cbse.common.services.IScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ScoreKeeper implements IScoreService {

    private RestTemplate restTemplate;

    @Autowired
    public ScoreKeeper(RestTemplate rt){
        restTemplate = rt;
    }


    @Override
    public void postScore(int score) {

    }
}

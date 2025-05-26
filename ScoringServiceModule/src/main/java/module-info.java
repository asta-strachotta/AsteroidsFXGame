import dk.sdu.cbse.common.services.IScoreService;
import dk.sdu.cbse.scoringservice.ScoringService;

module ScoringServiceModule {
    requires Common;
    requires spring.web;

    provides IScoreService with ScoringService;


}
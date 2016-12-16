package lombok.foods;

import lombok.Builder;
import lombok.ToString;
import lombok.extern.java.Log;
import org.joda.time.LocalDate;

/**
 * Created by kicsen on 2016. 12. 12..
 */
@ToString(callSuper = true)
@Log
public class Barley extends AbstractHorseFood {
    @Builder
    protected Barley(Long weight, Float qualityMultiplier, LocalDate expirationDate) {
        super("Barley", weight, weight * 5L, qualityMultiplier, expirationDate);
    }
}

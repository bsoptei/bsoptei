package lombok.foods;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.joda.time.LocalDate;

/**
 * Created by kicsen on 2016. 12. 12..
 */
@EqualsAndHashCode
@ToString(callSuper = true)
public abstract class AbstractHorseFood extends AbstractFood implements HorseFood {
    @Getter
    protected LocalDate expirationDate;

    public AbstractHorseFood(String name, Long weight, Long calories, Float qualityMultiplier, LocalDate expirationDate) {
        super(name, weight, calories, qualityMultiplier);
        this.expirationDate = expirationDate;
    }

    protected boolean canEqual(Object other) {
        return other instanceof AbstractHorseFood;
    }

}

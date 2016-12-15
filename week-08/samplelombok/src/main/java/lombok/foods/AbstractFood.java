package lombok.foods;

import lombok.*;
import org.joda.time.LocalDate;

/**
 * Created by kicsen on 2016. 12. 12..
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public abstract class AbstractFood implements Food {
    @Setter(AccessLevel.NONE)
    private String name;
    @Setter(AccessLevel.NONE)
    private Long weight;
    @Setter(AccessLevel.NONE)
    private Long calories;
    @Setter(AccessLevel.NONE)
    private LocalDate creationDate;
    protected Float qualityMultiplier;

    public AbstractFood(String name, Long weight, Long calories, Float qualityMultiplier) {
        this(name, weight, calories, new LocalDate(), qualityMultiplier);
    }

    protected boolean canEqual(Object other) {
        return other instanceof AbstractFood;
    }

}

package -------------;

import --------------;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientForm {
    @Min(0) @Max(7)   private Integer exerciseDaysPerWeek;
    @Min(0) @Max(40)  private Integer cigarettesPerDay;
    @Min(0) @Max(10)  private Integer alcoholPerWeek;
    @Min(0) @Max(10)  private Integer healthyFoodScore;
}

package --------------------;

import java.io.File;
import org.springframework.stereotype.Service;
import com.example.myapp.domain.PatientForm;
import weka.classifiers.functions.LinearRegression;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
@Service
public class HeartAttackRiskService {

    public double intercept;
    public double coefExercise;
    public double coefCigarettes;
    public double coefAlcohol;
    public double coefHealthyFood;
    private final String FILE_PATH="data/heartAttackRisk.csv";

    public void loadModel() {
        File dataFile = new File(FILE_PATH);
        if (!dataFile.exists()) {
            System.out.println("El archivo de datos no se encuentra en /data.");
            System.exit(0);
        }
        try {
            // Cargar datos
            DataSource source = new DataSource(dataFile.getPath());
            Instances dataset = source.getDataSet();

            // Último atributo como variable objetivo
            if (dataset.classIndex() == -1) {
                dataset.setClassIndex(dataset.numAttributes() - 1); 
            }
            // Crear y entrenar el modelo de regresión lineal
            LinearRegression model = new LinearRegression();
            model.buildClassifier(dataset); 
            // Extraer los coeficientes y asignarlos a variables del servicio
            double[] coefficients = model.coefficients();
            this.intercept = coefficients[coefficients.length - 1];
            this.coefExercise = coefficients[0]; // Ejercicio
            this.coefCigarettes = coefficients[1]; // Cigarrillos
            this.coefAlcohol = coefficients[2]; // Alcohol
            this.coefHealthyFood = coefficients[3]; // Comida saludable
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }    }
   
	public double calculateRisk(PatientForm patientForm) {
        double heartAttackRiskProb = (intercept +
                coefExercise * patientForm.getExerciseDaysPerWeek() +
                coefCigarettes * patientForm.getCigarettesPerDay() +
                coefAlcohol * patientForm.getAlcoholPerWeek() +
                coefHealthyFood * patientForm.getHealthyFoodScore()) * 100;
        return Math.round(heartAttackRiskProb * 100) / 100.0;
    }  
}

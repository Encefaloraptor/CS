package com.example.myapp.services;

import java.io.File;

import org.springframework.stereotype.Service;

import com.example.myapp.domain.PatientForm;

import weka.classifiers.Classifier;
import weka.classifiers.trees.J48;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

@Service
public class DiabetesPredictionService {

    Classifier j48Tree;
    Instances dataset;
    private final String FILE_PATH = "data/diabetes.csv";

    public String calculatePrediction(PatientForm patientForm) {

        // Crear una nueva instancia con valores concretos
        Instance instance = new DenseInstance(dataset.numAttributes());
        instance.setDataset(dataset); // Asocia la instancia al esquema del conjunto de datos
        // Asigna valores específicos a los atributos de la instancia
        instance.setValue(0, patientForm.getEmbarazos()); // Pregnancies (0-17)
        instance.setValue(1, patientForm.getGlucosa()); // Glucose (0-199)
        instance.setValue(2, patientForm.getPresionSangre()); // Blood Pressure (0-122)
        instance.setValue(3, patientForm.getGrosorPiel()); // SkinThickness (0-99)
        instance.setValue(4, patientForm.getInsulina()); // Insulin (0-846)
        instance.setValue(5, patientForm.getIndiceMasaCorporal()); // Body Mass Index (0-67)
        instance.setValue(6, patientForm.getHerencia()); // Diabetes Pedigree Func (0-2)
        instance.setValue(7, patientForm.getEdad()); // Age (21-81)

        // Realizar prediccion y obtener el valor de la clase predicha
        try {
            double predictionJ48 = j48Tree.classifyInstance(instance);
            return dataset.classAttribute().value((int) predictionJ48);

        } catch (Exception e) {
            return null;
        }
    }

    public void loadModel() {
        File dataFile = new File(FILE_PATH);

        if (!dataFile.exists()) {
            System.out.println("El archivo de datos no se encuentra en /data.");
            System.exit(0);
        }
        try {
            // Cargar datos
            DataSource source = new DataSource(dataFile.getPath());
            dataset = source.getDataSet();

            // Último atributo como variable objetivo
            if (dataset.classIndex() == -1) {
                dataset.setClassIndex(dataset.numAttributes() - 1);
            }
            // Crear y entrenar el árbol de decisión (J48)
            j48Tree = new J48();
            j48Tree.buildClassifier(dataset);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }
}

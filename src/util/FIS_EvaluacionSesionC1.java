package util;

import com.fuzzylite.Engine;
import com.fuzzylite.FuzzyLite;
import com.fuzzylite.Op;
import com.fuzzylite.activation.General;
import com.fuzzylite.defuzzifier.Centroid;
import com.fuzzylite.defuzzifier.LargestOfMaximum;
import com.fuzzylite.defuzzifier.WeightedAverage;
import com.fuzzylite.imex.FldExporter;
import com.fuzzylite.imex.FllImporter;
import com.fuzzylite.norm.s.AlgebraicSum;
import com.fuzzylite.norm.s.EinsteinSum;
import com.fuzzylite.norm.s.Maximum;
import com.fuzzylite.norm.t.AlgebraicProduct;
import com.fuzzylite.norm.t.Minimum;
import com.fuzzylite.rule.Rule;
import com.fuzzylite.rule.RuleBlock;
import com.fuzzylite.term.Constant;
import com.fuzzylite.term.PiShape;
import com.fuzzylite.term.Ramp;
import com.fuzzylite.term.SShape;
import com.fuzzylite.term.Term;
import com.fuzzylite.term.Trapezoid;
import com.fuzzylite.term.Triangle;
import com.fuzzylite.term.ZShape;
import com.fuzzylite.variable.InputVariable;
import com.fuzzylite.variable.OutputVariable;

import java.util.ArrayList;
import java.util.Iterator;

public class FIS_EvaluacionSesionC1
{
    Engine engine;
    InputVariable EVALUACION_PROMEDIO;
    InputVariable CANT_DIAS;
    OutputVariable CALIFICACION;
    RuleBlock R1;
    
    private static FIS_EvaluacionSesionC1 instance;


    private FIS_EvaluacionSesionC1()
    {
        inicializar();
    }
    
    public static FIS_EvaluacionSesionC1 getInstance() {
        // If the instance is null, create a new instance
        if (instance == null) {
            instance = new FIS_EvaluacionSesionC1();
        }
        // Return the single instance
        return instance;
    }
    

    private void inicializar()
    {
        //Code automatically generated with fuzzylite 6.0.

        engine = new Engine();
        engine.setName("EVALUACION_SESION");
        engine.setDescription("evalua la sesion del juego");

        CANT_DIAS = new InputVariable();
        CANT_DIAS.setName("CANT_DIAS");
        CANT_DIAS.setDescription("Cantidad normalizada de evaluaciones diarias sobresalientes");
        CANT_DIAS.setEnabled(true);
        CANT_DIAS.setRange(0.000, 10.000);
        CANT_DIAS.setLockValueInRange(false);
        CANT_DIAS.addTerm(new ZShape("MINORIA", 4.100, 6.700));
        CANT_DIAS.addTerm(new PiShape("MITAD", 2.600, 5.500, 5.500, 10.000));
        CANT_DIAS.addTerm(new SShape("MAYORIA", 5.000, 10.000));
        engine.addInputVariable(CANT_DIAS);

        EVALUACION_PROMEDIO = new InputVariable();
        EVALUACION_PROMEDIO.setName("EVALUACION_PROMEDIO");
        EVALUACION_PROMEDIO.setDescription("");
        EVALUACION_PROMEDIO.setEnabled(true);
        EVALUACION_PROMEDIO.setRange(0.000, 10.000);
        EVALUACION_PROMEDIO.setLockValueInRange(false);
        EVALUACION_PROMEDIO.addTerm(new ZShape("REPROBADO", 2.400, 5.000));
        EVALUACION_PROMEDIO.addTerm(new PiShape("MEDIOCRE", 2.500, 5.000, 5.000, 7.500));
        EVALUACION_PROMEDIO.addTerm(new PiShape("APROBADO", 5.000, 7.500, 7.500, 10.000));
        EVALUACION_PROMEDIO.addTerm(new SShape("SOBRESALIENTE", 7.500, 10.000));
        engine.addInputVariable(EVALUACION_PROMEDIO);
        engine.addInputVariable(EVALUACION_PROMEDIO);

        CALIFICACION = new OutputVariable();
        CALIFICACION.setName("CALIFICACION");
        CALIFICACION.setDescription("calificacion de la sesion");
        CALIFICACION.setEnabled(true);
        CALIFICACION.setRange(0.000, 10.000);
        CALIFICACION.setLockValueInRange(false);
        CALIFICACION.setAggregation(new EinsteinSum());
        CALIFICACION.setDefuzzifier(new LargestOfMaximum(100));
        CALIFICACION.setDefaultValue(Double.NaN);
        CALIFICACION.setLockPreviousValue(false);
        CALIFICACION.addTerm(new ZShape("DESAPRUEBA", 0.000, 5.000));
        CALIFICACION.addTerm(new PiShape("REPASA", 0.000, 5.000, 5.000, 10.000));
        CALIFICACION.addTerm(new SShape("PROMUEVE", 5.000, 10.000));
        engine.addOutputVariable(CALIFICACION);

        RuleBlock R1 = new RuleBlock();
        R1.setName("R1");
        R1.setDescription("");
        R1.setEnabled(true);
        R1.setConjunction(new AlgebraicProduct());
        R1.setDisjunction(new Maximum());
        R1.setImplication(new AlgebraicProduct());
        R1.setActivation(new General());
        R1.addRule(Rule.parse("if CANT_DIAS is MINORIA then CALIFICACION is DESAPRUEBA", engine));
        R1.addRule(Rule.parse("if CANT_DIAS is MITAD and EVALUACION_PROMEDIO is SOBRESALIENTE then CALIFICACION is PROMUEVE",
                              engine));
        R1.addRule(Rule.parse("if CANT_DIAS is MITAD and EVALUACION_PROMEDIO is APROBADO then CALIFICACION is REPASA",
                              engine));
        R1.addRule(Rule.parse("if CANT_DIAS is MITAD and EVALUACION_PROMEDIO is MEDIOCRE then CALIFICACION is DESAPRUEBA",
                              engine));
        R1.addRule(Rule.parse("if CANT_DIAS is MITAD and EVALUACION_PROMEDIO is REPROBADO then CALIFICACION is DESAPRUEBA",
                              engine));
        R1.addRule(Rule.parse("if CANT_DIAS is MAYORIA and EVALUACION_PROMEDIO is SOBRESALIENTE then CALIFICACION is PROMUEVE",
                              engine));
        R1.addRule(Rule.parse("if CANT_DIAS is MAYORIA and EVALUACION_PROMEDIO is APROBADO then CALIFICACION is PROMUEVE",
                              engine));
        R1.addRule(Rule.parse("if CANT_DIAS is MAYORIA and EVALUACION_PROMEDIO is MEDIOCRE then CALIFICACION is REPASA",
                              engine));
        R1.addRule(Rule.parse("if CANT_DIAS is MAYORIA and EVALUACION_PROMEDIO is REPROBADO then CALIFICACION is DESAPRUEBA",
                              engine));
        engine.addRuleBlock(R1);
    }

    public double getEvaluacionSesion(double cant_dias, double evaluacion_promedio)
    {
        CANT_DIAS.setValue(cant_dias);
        EVALUACION_PROMEDIO.setValue(evaluacion_promedio);
        engine.process();
        return CALIFICACION.getValue();
    }

    public String getEvaluacionSesionString(double cant_dias, double evaluacion_promedio)
    {
        CANT_DIAS.setValue(cant_dias);
        EVALUACION_PROMEDIO.setValue(evaluacion_promedio);
        engine.process();
        //ArrayList<Term> lista_terminos = (ArrayList<Term>) CALIFICACION.getTerms();
        //Iterator iter_terminos = lista_terminos.iterator();
        return  CALIFICACION.fuzzyOutputValue();
    }

    public static void main(String[] args)
    {
        System.out.println("fis");
        FIS_EvaluacionSesionC1 fIS_EvaluacionSesionC1 = new FIS_EvaluacionSesionC1();
        System.out.println("Evaluacion diaria:" + fIS_EvaluacionSesionC1.getEvaluacionSesion(7, 9));
        System.out.println("evaluacion string:" + fIS_EvaluacionSesionC1.getEvaluacionSesionString(7,9));
    }
}

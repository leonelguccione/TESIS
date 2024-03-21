package util;

import com.fuzzylite.Engine;
import com.fuzzylite.activation.General;
import com.fuzzylite.defuzzifier.Centroid;
import com.fuzzylite.norm.s.AlgebraicSum;
import com.fuzzylite.norm.s.Maximum;
import com.fuzzylite.norm.t.AlgebraicProduct;
import com.fuzzylite.norm.t.Minimum;
import com.fuzzylite.rule.Rule;
import com.fuzzylite.rule.RuleBlock;
import com.fuzzylite.term.PiShape;
import com.fuzzylite.term.SShape;
import com.fuzzylite.term.Term;
import com.fuzzylite.term.ZShape;
import com.fuzzylite.variable.InputVariable;
import com.fuzzylite.variable.OutputVariable;


import java.util.ArrayList;

public class FIS_EvaluacionDiariaC1
{
    Engine engine;
    InputVariable GD;
    InputVariable BGE_EVAL;
    OutputVariable EVALUACION_DIARA;
    RuleBlock R1;
    
    private static FIS_EvaluacionDiariaC1 instance;
    
    private FIS_EvaluacionDiariaC1()
    {
        inicializar();
    }

    public static FIS_EvaluacionDiariaC1 getInstance()
    {
        if(instance == null)
        {
            instance = new FIS_EvaluacionDiariaC1();
        }
        return instance;
    }
    private void inicializar()
    {
        //Code automatically generated with fuzzylite 6.0.

        engine = new Engine();
        engine.setName("GD");
        engine.setDescription("Grado de dificultad del dia");

        GD = new InputVariable();
        GD.setName("GD");
        GD.setDescription("Grado de dificultad");
        GD.setEnabled(true);
        GD.setRange(-1.000, 1.000);
        GD.setLockValueInRange(false);
        GD.addTerm(new ZShape("BAJA", -1.000, 0.000));
        GD.addTerm(new PiShape("MEDIA", -1.000, 0.000, 0.000, 1.000));
        GD.addTerm(new SShape("ALTA", 0.000, 1.000));
        engine.addInputVariable(GD);

        BGE_EVAL = new InputVariable();
        BGE_EVAL.setName("BGE_EVAL");
        BGE_EVAL.setDescription("eleccion del Banco de Baterias");
        BGE_EVAL.setEnabled(true);
        BGE_EVAL.setRange(-1.000, 1.000);
        BGE_EVAL.setLockValueInRange(false);
        BGE_EVAL.addTerm(new PiShape("BUENA", 0.000, 0.500, 0.500, 1.000));
        BGE_EVAL.addTerm(new SShape("MUYBUENA", 0.500, 1.000));
        BGE_EVAL.addTerm(new ZShape("MALA", -1.000, 0.500));
        engine.addInputVariable(BGE_EVAL);

        EVALUACION_DIARA = new OutputVariable();
        EVALUACION_DIARA.setName("EVALUACION_DIARA");
        EVALUACION_DIARA.setDescription("");
        EVALUACION_DIARA.setEnabled(true);
        EVALUACION_DIARA.setRange(0.000, 10.000);
        EVALUACION_DIARA.setLockValueInRange(false);
        EVALUACION_DIARA.setAggregation(new AlgebraicSum());
        EVALUACION_DIARA.setDefuzzifier(new Centroid(100));
        EVALUACION_DIARA.setDefaultValue(Double.NaN);
        EVALUACION_DIARA.setLockPreviousValue(false);
        EVALUACION_DIARA.addTerm(new ZShape("REPROBADO", 2.400, 5.000));
        EVALUACION_DIARA.addTerm(new PiShape("MEDIOCRE", 2.500, 5.000, 5.000, 7.500));
        EVALUACION_DIARA.addTerm(new PiShape("APROBADO", 5.000, 7.500, 7.500, 10.000));
        EVALUACION_DIARA.addTerm(new SShape("SOBRESALIENTE", 7.500, 10.000));
        engine.addOutputVariable(EVALUACION_DIARA);

        R1 = new RuleBlock();
        R1.setName("R1");
        R1.setDescription("");
        R1.setEnabled(true);
        R1.setConjunction(new Minimum());
        R1.setDisjunction(new Maximum());
        R1.setImplication(new AlgebraicProduct());
        R1.setActivation(new General());   
        R1.addRule(Rule.parse("if GD is ALTA and BGE_EVAL is BUENA then EVALUACION_DIARA is APROBADO", engine));
        R1.addRule(Rule.parse("if GD is ALTA and BGE_EVAL is MALA then EVALUACION_DIARA is REPROBADO", engine));
        R1.addRule(Rule.parse("if GD is MEDIA and BGE_EVAL is MUYBUENA then EVALUACION_DIARA is APROBADO", engine));
        R1.addRule(Rule.parse("if GD is MEDIA and BGE_EVAL is BUENA then EVALUACION_DIARA is MEDIOCRE", engine));
        R1.addRule(Rule.parse("if GD is MEDIA and BGE_EVAL is MALA then EVALUACION_DIARA is REPROBADO", engine));
        R1.addRule(Rule.parse("if GD is BAJA and BGE_EVAL is MUYBUENA then EVALUACION_DIARA is MEDIOCRE", engine));
        R1.addRule(Rule.parse("if GD is BAJA and BGE_EVAL is BUENA then EVALUACION_DIARA is MEDIOCRE", engine));
        R1.addRule(Rule.parse("if GD is BAJA and BGE_EVAL is MALA then EVALUACION_DIARA is REPROBADO", engine));
        engine.addRuleBlock(R1);
    }

    /**
     * @param grado_dificultad, es el grado de dificultad normalizado
     * @param bge_eval, banco de generadores electos evaluacion
     * @return
     */
    public double getEvaluacionDiaria(double grado_dificultad, double bge_eval)
    {
        GD.setValue(grado_dificultad);
        BGE_EVAL.setValue(bge_eval);
        engine.process();
        return EVALUACION_DIARA.getValue();
    }
    
    public String getEvaluacionDiaria_fuzzy(double grado_dificultad, double bge_eval)
    {
        GD.setValue(grado_dificultad);
        BGE_EVAL.setValue(bge_eval);
        engine.process();
        ArrayList<Term> terminos = (ArrayList<Term>) EVALUACION_DIARA.getTerms();
        terminos.get(0).getName();
        return terminos.get(0).toString();
    }
    

    public static void main(String[] args)
    {
        System.out.println("fis");
        FIS_EvaluacionDiariaC1 fis_EvaluacionDiariaC1 =  FIS_EvaluacionDiariaC1.getInstance();
        System.out.println("Evaluacion diaria:" + fis_EvaluacionDiariaC1.getEvaluacionDiaria(0.3, 0.4));
    }


}

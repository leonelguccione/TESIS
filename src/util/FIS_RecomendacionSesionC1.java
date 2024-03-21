package util;

import com.fuzzylite.Engine;
import com.fuzzylite.activation.General;
import com.fuzzylite.defuzzifier.LargestOfMaximum;
import com.fuzzylite.norm.s.EinsteinSum;
import com.fuzzylite.norm.s.Maximum;
import com.fuzzylite.norm.t.AlgebraicProduct;
import com.fuzzylite.rule.Rule;
import com.fuzzylite.rule.RuleBlock;
import com.fuzzylite.term.PiShape;
import com.fuzzylite.term.SShape;
import com.fuzzylite.term.Term;
import com.fuzzylite.term.ZShape;
import com.fuzzylite.variable.InputVariable;
import com.fuzzylite.variable.OutputVariable;

import java.util.ArrayList;
import java.util.Iterator;

public class FIS_RecomendacionSesionC1
{
    Engine engine;
    InputVariable CALIFICACION;
    OutputVariable EDC1;
    OutputVariable ERC1;
    OutputVariable EPC1;
    RuleBlock R1;
    
    private static FIS_RecomendacionSesionC1 instance;
    
    private FIS_RecomendacionSesionC1()
    {
        inicializar();
    }
    
    public static FIS_RecomendacionSesionC1 getInstance() {
        // If the instance is null, create a new instance
        if (instance == null) {
            instance = new FIS_RecomendacionSesionC1();
        }
        // Return the single instance
        return instance;
    }
    
    private void inicializar()
    {
        //Code automatically generated with fuzzylite 6.0.

        engine = new Engine();
        engine.setName("RECOMENDACION_C1");
        engine.setDescription("recomendacion");

        CALIFICACION = new InputVariable();
        CALIFICACION.setName("CALIFICACION");
        CALIFICACION.setDescription("calificacion de la sesion");
        CALIFICACION.setEnabled(true);
        CALIFICACION.setRange(0.000, 10.000);
        CALIFICACION.setLockValueInRange(false);
        CALIFICACION.addTerm(new ZShape("DESAPRUEBA", 0.000, 5.000));
        CALIFICACION.addTerm(new PiShape("REPASA", 0.000, 5.000, 5.000, 10.000));
        CALIFICACION.addTerm(new SShape("PROMUEVE", 5.000, 10.000));
        engine.addInputVariable(CALIFICACION);

        EDC1 = new OutputVariable();
        EDC1.setName("EDC1");
        EDC1.setDescription("");
        EDC1.setEnabled(true);
        EDC1.setRange(0.000, 10.000);
        EDC1.setLockValueInRange(false);
        EDC1.setAggregation(new Maximum());
        EDC1.setDefuzzifier(new LargestOfMaximum(100));
        EDC1.setDefaultValue(Double.NaN);
        EDC1.setLockPreviousValue(false);
        EDC1.addTerm(new SShape("ALTA", 2.500, 7.500));
        EDC1.addTerm(new ZShape("BAJA", 2.500, 7.500));
        engine.addOutputVariable(EDC1);

        ERC1 = new OutputVariable();
        ERC1.setName("ERC1");
        ERC1.setDescription("");
        ERC1.setEnabled(true);
        ERC1.setRange(0.000, 10.000);
        ERC1.setLockValueInRange(false);
        ERC1.setAggregation(new Maximum());
        ERC1.setDefuzzifier(new LargestOfMaximum(100));
        ERC1.setDefaultValue(Double.NaN);
        ERC1.setLockPreviousValue(false);
        ERC1.addTerm(new SShape("ALTA", 2.500, 7.500));
        ERC1.addTerm(new ZShape("BAJA", 2.500, 7.500));
        engine.addOutputVariable(ERC1);

        EPC1 = new OutputVariable();
        EPC1.setName("EPC1");
        EPC1.setDescription("");
        EPC1.setEnabled(true);
        EPC1.setRange(0.000, 10.000);
        EPC1.setLockValueInRange(false);
        EPC1.setAggregation(new Maximum());
        EPC1.setDefuzzifier(new LargestOfMaximum(100));
        EPC1.setDefaultValue(Double.NaN);
        EPC1.setLockPreviousValue(false);
        EPC1.addTerm(new SShape("ALTA", 2.500, 7.500));
        EPC1.addTerm(new ZShape("BAJA", 2.500, 7.500));
        engine.addOutputVariable(EPC1);

        R1 = new RuleBlock();
        R1.setName("R1");
        R1.setDescription("");
        R1.setEnabled(true);
        R1.setConjunction(new AlgebraicProduct());
        R1.setDisjunction(new Maximum());
        R1.setImplication(new AlgebraicProduct());
        R1.setActivation(new General());
        R1.addRule(Rule.parse("if CALIFICACION is DESAPRUEBA then EDC1 is ALTA and ERC1 is BAJA and EPC1 is BAJA", engine));
        R1.addRule(Rule.parse("if CALIFICACION is REPASA then EDC1 is BAJA and ERC1 is ALTA and EPC1 is BAJA", engine));
        R1.addRule(Rule.parse("if CALIFICACION is PROMUEVE then EDC1 is ALTA and ERC1 is BAJA and EPC1 is BAJA", engine));
        engine.addRuleBlock(R1);        
    }

    
    private void setRecomendaciones(double calificacion)
    {
        CALIFICACION.setValue(calificacion);
        engine.process();
    }
    
    public double getEDC1(double calificacion)
    {
        this.setRecomendaciones(calificacion);
        return EDC1.getValue();
    }
    
    public double getERC1(double calificacion)
    {
        this.setRecomendaciones(calificacion);
        return ERC1.getValue();
    }
    
    public double getEPC1(double calificacion)
    {
        this.setRecomendaciones(calificacion);
        return EPC1.getValue();
    }

    
    public static void main(String[] args)
    {
        double calificacion = 6.0;
        System.out.println("fis");
        FIS_RecomendacionSesionC1 fis_RecomendacionSesionC1 = new FIS_RecomendacionSesionC1();
        System.out.println("Recomendacion de desaprobar:" + fis_RecomendacionSesionC1.getEDC1(calificacion));
    }
}

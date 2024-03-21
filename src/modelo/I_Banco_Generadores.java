package modelo;

import java.util.List;

public interface I_Banco_Generadores
{
    Id_Banco_Generadores getId_banco_generadores();

    @Override
    int hashCode();

    void add(Generador unGenerador);

    double calcularProductividadMaxima();

    List<Generador> getLista_generadores();

    double getProductividadMaxima();

    void setLista_generadores(List<Generador> lista_generadores);

    void setCant_gen_nafta(int cant_gen_nafta);

    int getCant_gen_nafta();

    void setCant_gen_carbon(int cant_gen_carbon);

    int getCant_gen_carbon();

    void setCant_gen_eolico(int cant_gen_eolico);

    int getCant_gen_eolico();

    void setCant_nafta(double cant_nafta);

    double getCant_nafta();

    void setCant_carbon(double cant_carbon);

    double getCant_carbon();

    void setProductividadMaxima(double productividadMaxima);

    void setCant_gen(int cant_gen);

    int getCant_gen();

    @Override
    boolean equals(Object o);

    @Override
    String toString();
}

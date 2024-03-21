package modelo;

import java.util.Collection;

public interface I_Recursos_Sesion
{
    I_Recursos_Dia getRecursosDia(int dia);
    
    int getInitMainEnergia();

    int getInitMainEnergiaMax();

    int getInitNafta();

    int getInitCarbon();

    int getInitDia();

    int getInitMinutos();

    int getInitHoras();

    Generador_Carbon getGc();

    Generador_Nafta getGn();

    Generador_Eolico getGe();

    Bateria getBateria();
    
    int getDias();


}

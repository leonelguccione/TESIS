package iu;
import negocio.Sistema;

public interface I_Configuracion_iu
{
    void puedeSalvar(boolean v);

    void setSistema(Sistema sistema);

    int getCant_Gen_Carbon_dia(int dia);

    int getCant_Gen_Nafta_dia(int dia);

    int getCant_Gen_Eolico_dia(int dia);

    void setCant_Gen_Carbon_dia(int dia, int cant);

    void setCant_Gen_Nafta_dia(int dia, int cant);

    void setCant_Gen_Eolico_dia(int dia, int cant);

    int getInitNafta();

    void setInitNafta(int initNafta);

    int getInitCarbon();

    void setInitCarbon(int initCarbon);

    double getItem6ConsumoGen();

    int getItem6Costo();

    double getItem6Productividad();

    double getItem7ConsumoGen();

    int getItem7Costo();

    double getItem7Productividad();

    double getItem8ConsumoGen();

    int getItem8Costo();

    double getItem8Productividad();


    int[] getItem6Day();

    void setItem6Day(int[] item6Day);

    int[] getItem7Day();

    void setItem7Day(int[] item7Day);

    int[] getItem8Day();

    void setItem8Day(int[] item8Day);

    int[] getCarbonDay();

    void setCarbonDay(int[] carbonDay);

    int[] getNaftaDay();

    void setNaftaDay(int[] naftaDay);


}

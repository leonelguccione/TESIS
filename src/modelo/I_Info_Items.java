package modelo;

import java.io.IOException;

import java.util.ArrayList;

public interface I_Info_Items
{
    /*    Generador_Carbon getGenerador_Carbon();

    Generador_Nafta getGenerador_Nafta();

    Generador_Eolico getGenerador_Eolico(); */

    int getCant_Gen_Carbon_dia(int dia);

    int getCant_Gen_Nafta_dia(int dia);

    int getCant_Gen_Eolico_dia(int dia);

    /*     int getCant_Gen_Carbon(int dia);

    int getCant_Gen_Nafta(int dia);

    int getCant_Gen_Eolico(int dia); */

    int getInitMainEnergia();

    void setInitMainEnergia(int initMainEnergia);

    int getInitMainEnergiaMax();

    void setInitMainEnergiaMax(int initMainEnergiaMax);

    int getInitNafta();

    void setInitNafta(int initNafta);

    int getInitCarbon();

    void setInitCarbon(int initCarbon);

    int getInitDia();

    void setInitDia(int initDia);

    int getInitMinutos();

    void setInitMinutos(int initMinutos);

    int getInitHoras();

    void setInitHoras(int initHoras);

    double getConsumoFijo();

    void setConsumoFijo(double consumoFijo);

    double getWariningPercentage();

    void setWariningPercentage(double wariningPercentage);

    double getLamaparaFactorConsumo();

    void setLamaparaFactorConsumo(double lamaparaFactorConsumo);

    String getConsumoText();

    void setConsumoText(String consumoText);

    String getDanoText();

    void setDanoText(String danoText);

    String getWattText();

    void setWattText(String wattText);

    String getLumenText();

    void setLumenText(String lumenText);

    String getTutoText();

    void setTutoText(String tutoText);

    double getItem1ConsumoWatt();

    void setItem1ConsumoWatt(double item1ConsumoWatt);

    double getItem1Lumenes();

    void setItem1Lumenes(double item1Lumenes);

    String getItem1Texto();

    void setItem1Texto(String item1Texto);

    double getItem2ConsumoWatt();

    void setItem2ConsumoWatt(double item2ConsumoWatt);

    double getItem2Lumenes();

    void setItem2Lumenes(double item2Lumenes);

    String getItem2Texto();

    void setItem2Texto(String item2Texto);

    double getItem3ConsumoWatt();

    void setItem3ConsumoWatt(double item3ConsumoWatt);

    double getItem3Lumenes();

    void setItem3Lumenes(double item3Lumenes);

    String getItem3Texto();

    void setItem3Texto(String item3Texto);

    double getItem4ConsumoWatt();

    void setItem4ConsumoWatt(double item4ConsumoWatt);

    double getItem4Lumenes();

    void setItem4Lumenes(double item4Lumenes);

    String getItem4Texto();

    void setItem4Texto(String item4Texto);

    int getItem5Capacidad();

    void setItem5Capacidad(int item5Capacidad);

    String getItem5Texto();

    void setItem5Texto(String item5Texto);

    double getGeneradorFactorConsumo();

    void setGeneradorFactorConsumo(double generadorFactorConsumo);

    double getGeneradorFactorProduccion();

    void setGeneradorFactorProduccion(double generadorFactorProduccion);

    double getGeneradorFactorCosto();

    void setGeneradorFactorCosto(double generadorFactorCosto);

    String getGeneradorProduccionText();

    void setGeneradorProduccionText(String generadorProduccionText);

    String getCostoText();

    void setCostoText(String costoText);

    String getProduccionText();

    void setProduccionText(String produccionText);

    int getItem6ConsumoGen();

    void setItem6ConsumoGen(int item6ConsumoGen);

    int getItem6Costo();

    void setItem6Costo(int item6Costo);

    int getItem6Combustible();

    void setItem6Combustible(int item6Combustible);

    double getItem6Productividad();

    void setItem6Productividad(double item6Productividad);

    String getItem6Texto();

    void setItem6Texto(String item6Texto);

    int getItem7ConsumoGen();

    void setItem7ConsumoGen(int item7ConsumoGen);

    int getItem7Costo();

    void setItem7Costo(int item7Costo);

    int getItem7Combustible();

    void setItem7Combustible(int item7Combustible);

    double getItem7Productividad();

    void setItem7Productividad(double item7Productividad);

    String getItem7Texto();

    void setItem7Texto(String item7Texto);

    int getItem8ConsumoGen();

    void setItem8ConsumoGen(int item8ConsumoGen);

    int getItem8Costo();

    void setItem8Costo(int item8Costo);

    int getItem8Combustible();

    void setItem8Combustible(int item8Combustible);

    double getItem8Productividad();

    void setItem8Productividad(double item8Productividad);

    String getItem8Texto();

    void setItem8Texto(String item8Texto);

    double getPlayerHealth();

    void setPlayerHealth(double playerHealth);

    double getPlayerSpeed();

    void setPlayerSpeed(double playerSpeed);

    double getPlayerDamage();

    void setPlayerDamage(double playerDamage);

    double getPlayerRecuperacion();

    void setPlayerRecuperacion(double playerRecuperacion);

    double getLinternaBatery();

    void setLinternaBatery(double linternaBatery);

    double getLinternaBateryMax();

    void setLinternaBateryMax(double linternaBateryMax);

    double getLinternaDamage();

    void setLinternaDamage(double linternaDamage);

    double getLinternaConsumo();

    void setLinternaConsumo(double linternaConsumo);

    double getLinternaCarga();

    void setLinternaCarga(double linternaCarga);

    int[] getItem1Day();

    void setItem1Day(int[] item1Day);

    int[] getItem2Day();

    void setItem2Day(int[] item2Day);

    int[] getItem3Day();

    void setItem3Day(int[] item3Day);

    int[] getItem4Day();

    void setItem4Day(int[] item4Day);

    int[] getItem5Day();

    void setItem5Day(int[] item5Day);

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

    int[] getZombieDay();

    void setZombieDay(int[] zombieDay);

    String toString();
   
    Double getCant_Nafta_dia(int dia);

    Double getCant_Carbon_dia(int dia);
    
    /* Bateria getBateria();
   
    String getJsonText(); */
}

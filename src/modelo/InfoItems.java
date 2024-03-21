package modelo;

import java.util.Arrays;

public class InfoItems implements I_Info_Items
{

    private int initMainEnergia;
    private int initMainEnergiaMax;
    private int initNafta;
    private int initCarbon;
    private int initDia;
    private int initMinutos;
    private int initHoras;
    private double consumoFijo;
    private double wariningPercentage;
    private double lamaparaFactorConsumo;

    private String consumoText;
    private String danoText;
    private String wattText;
    private String lumenText;

    private String tutoText;

    //ITEMS
    //Luz Incandescente
    private double item1ConsumoWatt;
    private double item1Lumenes;
    private String item1Texto;

    //Luz Halogena
    private double item2ConsumoWatt;
    private double item2Lumenes;
    private String item2Texto;

    //Luz Bajo Consumo
    private double item3ConsumoWatt;
    private double item3Lumenes;
    private String item3Texto;

    //Luz LED
    private double item4ConsumoWatt;
    private double item4Lumenes;
    private String item4Texto;

    //Bateria
    private int item5Capacidad;
    private String item5Texto;

    private double generadorFactorConsumo;
    private double generadorFactorProduccion;
    private double generadorFactorCosto;
    private String generadorProduccionText;
    private String costoText;
    private String produccionText;
    //Generador a Carbon
    private int item6ConsumoGen;
    private int item6Costo;
    private int item6Combustible;
    private double item6Productividad;
    private String item6Texto;
    //Generador a Nafta
    private int item7ConsumoGen;
    private int item7Costo;
    private int item7Combustible;
    private double item7Productividad;
    private String item7Texto;
    //Generador Eolico
    private int item8ConsumoGen;
    private int item8Costo;
    private int item8Combustible;
    private double item8Productividad;
    private String item8Texto;

    private double playerHealth;
    private double playerSpeed;
    private double playerDamage;
    private double playerRecuperacion;

    private double linternaBatery;
    private double linternaBateryMax;
    private double linternaDamage;
    private double linternaConsumo;
    private double linternaCarga;


    //# cada columna representa un dia. 10 columnas
    //# Cada constante representa la asignacion del recurso ITEM para cada dia de la sesion.
    private int[] item1Day; //halogena
    private int[] item2Day; //incandescente
    private int[] item3Day; //bajo consumo
    private int[] item4Day; //led
    private int[] item5Day; //bateria
    private int[] item6Day; //Generador a Carbon 0-9
    private int[] item7Day; //Generador a Nafta
    private int[] item8Day; //Generador Eolico
    //inventory contiene los itmes de 1 a 8
    private int[] carbonDay;
    private int[] naftaDay;
    private int[] zombieDay;

    public int getCant_Gen_Carbon_dia(int dia)
    {
        return item6Day[dia - 1];
    }

    public int getCant_Gen_Nafta_dia(int dia)
    {
        return item7Day[dia - 1];
    }

    public int getCant_Gen_Eolico_dia(int dia)
    {
        return item8Day[dia - 1];
    }

    /* public int getCant_Gen_Carbon(int dia)
    {
        return item6Day[dia];
    }

    public int getCant_Gen_Nafta(int dia)
    {
        return item7Day[dia];
    }

    public int getCant_Gen_Eolico(int dia)
    {
        return item8Day[dia];
    } */

    public int getInitMainEnergia()
    {
        return initMainEnergia;
    }


    public void setInitMainEnergia(int initMainEnergia)
    {
        this.initMainEnergia = initMainEnergia;
    }

    public int getInitMainEnergiaMax()
    {
        return initMainEnergiaMax;
    }

    public void setInitMainEnergiaMax(int initMainEnergiaMax)
    {
        this.initMainEnergiaMax = initMainEnergiaMax;
    }

    public int getInitNafta()
    {
        return initNafta;
    }


    public void setInitNafta(int initNafta)
    {
        this.initNafta = initNafta;
    }

    public int getInitCarbon()
    {
        return initCarbon;
    }

    public void setInitCarbon(int initCarbon)
    {
        this.initCarbon = initCarbon;
    }

    public int getInitDia()
    {
        return initDia;
    }

    public void setInitDia(int initDia)
    {
        this.initDia = initDia;
    }

    public int getInitMinutos()
    {
        return initMinutos;
    }

    public void setInitMinutos(int initMinutos)
    {
        this.initMinutos = initMinutos;
    }

    public int getInitHoras()
    {
        return initHoras;
    }

    public void setInitHoras(int initHoras)
    {
        this.initHoras = initHoras;
    }

    public double getConsumoFijo()
    {
        return consumoFijo;
    }

    public void setConsumoFijo(double consumoFijo)
    {
        this.consumoFijo = consumoFijo;
    }

    public double getWariningPercentage()
    {
        return wariningPercentage;
    }

    public void setWariningPercentage(double wariningPercentage)
    {
        this.wariningPercentage = wariningPercentage;
    }

    public double getLamaparaFactorConsumo()
    {
        return lamaparaFactorConsumo;
    }

    public void setLamaparaFactorConsumo(double lamaparaFactorConsumo)
    {
        this.lamaparaFactorConsumo = lamaparaFactorConsumo;
    }

    public String getConsumoText()
    {
        return consumoText;
    }

    public void setConsumoText(String consumoText)
    {
        this.consumoText = consumoText;
    }

    public String getDanoText()
    {
        return danoText;
    }

    public void setDanoText(String danoText)
    {
        this.danoText = danoText;
    }

    public String getWattText()
    {
        return wattText;
    }

    public void setWattText(String wattText)
    {
        this.wattText = wattText;
    }

    public String getLumenText()
    {
        return lumenText;
    }

    public void setLumenText(String lumenText)
    {
        this.lumenText = lumenText;
    }

    public String getTutoText()
    {
        return tutoText;
    }

    public void setTutoText(String tutoText)
    {
        this.tutoText = tutoText;
    }

    public double getItem1ConsumoWatt()
    {
        return item1ConsumoWatt;
    }

    public void setItem1ConsumoWatt(double item1ConsumoWatt)
    {
        this.item1ConsumoWatt = item1ConsumoWatt;
    }


    public double getItem1Lumenes()
    {
        return item1Lumenes;
    }


    public void setItem1Lumenes(double item1Lumenes)
    {
        this.item1Lumenes = item1Lumenes;
    }


    public String getItem1Texto()
    {
        return item1Texto;
    }


    public void setItem1Texto(String item1Texto)
    {
        this.item1Texto = item1Texto;
    }


    public double getItem2ConsumoWatt()
    {
        return item2ConsumoWatt;
    }


    public void setItem2ConsumoWatt(double item2ConsumoWatt)
    {
        this.item2ConsumoWatt = item2ConsumoWatt;
    }


    public double getItem2Lumenes()
    {
        return item2Lumenes;
    }


    public void setItem2Lumenes(double item2Lumenes)
    {
        this.item2Lumenes = item2Lumenes;
    }


    public String getItem2Texto()
    {
        return item2Texto;
    }


    public void setItem2Texto(String item2Texto)
    {
        this.item2Texto = item2Texto;
    }


    public double getItem3ConsumoWatt()
    {
        return item3ConsumoWatt;
    }


    public void setItem3ConsumoWatt(double item3ConsumoWatt)
    {
        this.item3ConsumoWatt = item3ConsumoWatt;
    }


    public double getItem3Lumenes()
    {
        return item3Lumenes;
    }


    public void setItem3Lumenes(double item3Lumenes)
    {
        this.item3Lumenes = item3Lumenes;
    }


    public String getItem3Texto()
    {
        return item3Texto;
    }


    public void setItem3Texto(String item3Texto)
    {
        this.item3Texto = item3Texto;
    }


    public double getItem4ConsumoWatt()
    {
        return item4ConsumoWatt;
    }


    public void setItem4ConsumoWatt(double item4ConsumoWatt)
    {
        this.item4ConsumoWatt = item4ConsumoWatt;
    }


    public double getItem4Lumenes()
    {
        return item4Lumenes;
    }


    public void setItem4Lumenes(double item4Lumenes)
    {
        this.item4Lumenes = item4Lumenes;
    }


    public String getItem4Texto()
    {
        return item4Texto;
    }


    public void setItem4Texto(String item4Texto)
    {
        this.item4Texto = item4Texto;
    }


    public int getItem5Capacidad()
    {
        return item5Capacidad;
    }


    public void setItem5Capacidad(int item5Capacidad)
    {
        this.item5Capacidad = item5Capacidad;
    }


    public String getItem5Texto()
    {
        return item5Texto;
    }


    public void setItem5Texto(String item5Texto)
    {
        this.item5Texto = item5Texto;
    }


    public double getGeneradorFactorConsumo()
    {
        return generadorFactorConsumo;
    }


    public void setGeneradorFactorConsumo(double generadorFactorConsumo)
    {
        this.generadorFactorConsumo = generadorFactorConsumo;
    }


    public double getGeneradorFactorProduccion()
    {
        return generadorFactorProduccion;
    }


    public void setGeneradorFactorProduccion(double generadorFactorProduccion)
    {
        this.generadorFactorProduccion = generadorFactorProduccion;
    }


    public double getGeneradorFactorCosto()
    {
        return generadorFactorCosto;
    }


    public void setGeneradorFactorCosto(double generadorFactorCosto)
    {
        this.generadorFactorCosto = generadorFactorCosto;
    }


    public String getGeneradorProduccionText()
    {
        return generadorProduccionText;
    }


    public void setGeneradorProduccionText(String generadorProduccionText)
    {
        this.generadorProduccionText = generadorProduccionText;
    }


    public String getCostoText()
    {
        return costoText;
    }


    public void setCostoText(String costoText)
    {
        this.costoText = costoText;
    }


    public String getProduccionText()
    {
        return produccionText;
    }


    public void setProduccionText(String produccionText)
    {
        this.produccionText = produccionText;
    }


    public int getItem6ConsumoGen()
    {
        return item6ConsumoGen;
    }


    public void setItem6ConsumoGen(int item6ConsumoGen)
    {
        this.item6ConsumoGen = item6ConsumoGen;
    }


    public int getItem6Costo()
    {
        return item6Costo;
    }


    public void setItem6Costo(int item6Costo)
    {
        this.item6Costo = item6Costo;
    }


    public int getItem6Combustible()
    {
        return item6Combustible;
    }


    public void setItem6Combustible(int item6Combustible)
    {
        this.item6Combustible = item6Combustible;
    }


    public double getItem6Productividad()
    {
        return item6Productividad;
    }


    public void setItem6Productividad(double item6Productividad)
    {
        this.item6Productividad = item6Productividad;
    }


    public String getItem6Texto()
    {
        return item6Texto;
    }


    public void setItem6Texto(String item6Texto)
    {
        this.item6Texto = item6Texto;
    }


    public int getItem7ConsumoGen()
    {
        return item7ConsumoGen;
    }


    public void setItem7ConsumoGen(int item7ConsumoGen)
    {
        this.item7ConsumoGen = item7ConsumoGen;
    }


    public int getItem7Costo()
    {
        return item7Costo;
    }


    public void setItem7Costo(int item7Costo)
    {
        this.item7Costo = item7Costo;
    }


    public int getItem7Combustible()
    {
        return item7Combustible;
    }


    public void setItem7Combustible(int item7Combustible)
    {
        this.item7Combustible = item7Combustible;
    }


    public double getItem7Productividad()
    {
        return item7Productividad;
    }


    public void setItem7Productividad(double item7Productividad)
    {
        this.item7Productividad = item7Productividad;
    }


    public String getItem7Texto()
    {
        return item7Texto;
    }


    public void setItem7Texto(String item7Texto)
    {
        this.item7Texto = item7Texto;
    }


    public int getItem8ConsumoGen()
    {
        return item8ConsumoGen;
    }


    public void setItem8ConsumoGen(int item8ConsumoGen)
    {
        this.item8ConsumoGen = item8ConsumoGen;
    }


    public int getItem8Costo()
    {
        return item8Costo;
    }


    public void setItem8Costo(int item8Costo)
    {
        this.item8Costo = item8Costo;
    }


    public int getItem8Combustible()
    {
        return item8Combustible;
    }


    public void setItem8Combustible(int item8Combustible)
    {
        this.item8Combustible = item8Combustible;
    }


    public double getItem8Productividad()
    {
        return item8Productividad;
    }


    public void setItem8Productividad(double item8Productividad)
    {
        this.item8Productividad = item8Productividad;
    }


    public String getItem8Texto()
    {
        return item8Texto;
    }


    public void setItem8Texto(String item8Texto)
    {
        this.item8Texto = item8Texto;
    }


    public double getPlayerHealth()
    {
        return playerHealth;
    }


    public void setPlayerHealth(double playerHealth)
    {
        this.playerHealth = playerHealth;
    }


    public double getPlayerSpeed()
    {
        return playerSpeed;
    }


    public void setPlayerSpeed(double playerSpeed)
    {
        this.playerSpeed = playerSpeed;
    }


    public double getPlayerDamage()
    {
        return playerDamage;
    }


    public void setPlayerDamage(double playerDamage)
    {
        this.playerDamage = playerDamage;
    }


    public double getPlayerRecuperacion()
    {
        return playerRecuperacion;
    }


    public void setPlayerRecuperacion(double playerRecuperacion)
    {
        this.playerRecuperacion = playerRecuperacion;
    }


    public double getLinternaBatery()
    {
        return linternaBatery;
    }


    public void setLinternaBatery(double linternaBatery)
    {
        this.linternaBatery = linternaBatery;
    }


    public double getLinternaBateryMax()
    {
        return linternaBateryMax;
    }


    public void setLinternaBateryMax(double linternaBateryMax)
    {
        this.linternaBateryMax = linternaBateryMax;
    }


    public double getLinternaDamage()
    {
        return linternaDamage;
    }


    public void setLinternaDamage(double linternaDamage)
    {
        this.linternaDamage = linternaDamage;
    }


    public double getLinternaConsumo()
    {
        return linternaConsumo;
    }


    public void setLinternaConsumo(double linternaConsumo)
    {
        this.linternaConsumo = linternaConsumo;
    }


    public double getLinternaCarga()
    {
        return linternaCarga;
    }


    public void setLinternaCarga(double linternaCarga)
    {
        this.linternaCarga = linternaCarga;
    }


    public int[] getItem1Day()
    {
        return item1Day;
    }


    public void setItem1Day(int[] item1Day)
    {
        this.item1Day = item1Day;
    }


    public int[] getItem2Day()
    {
        return item2Day;
    }


    public void setItem2Day(int[] item2Day)
    {
        this.item2Day = item2Day;
    }


    public int[] getItem3Day()
    {
        return item3Day;
    }


    public void setItem3Day(int[] item3Day)
    {
        this.item3Day = item3Day;
    }


    public int[] getItem4Day()
    {
        return item4Day;
    }


    public void setItem4Day(int[] item4Day)
    {
        this.item4Day = item4Day;
    }


    public int[] getItem5Day()
    {
        return item5Day;
    }


    public void setItem5Day(int[] item5Day)
    {
        this.item5Day = item5Day;
    }


    public int[] getItem6Day()
    {
        return item6Day;
    }


    public void setItem6Day(int[] item6Day)
    {
        this.item6Day = item6Day;
    }


    public int[] getItem7Day()
    {
        return item7Day;
    }


    public void setItem7Day(int[] item7Day)
    {
        this.item7Day = item7Day;
    }


    public int[] getItem8Day()
    {
        return item8Day;
    }


    public void setItem8Day(int[] item8Day)
    {
        this.item8Day = item8Day;
    }


    public int[] getCarbonDay()
    {
        return carbonDay;
    }


    public void setCarbonDay(int[] carbonDay)
    {
        this.carbonDay = carbonDay;
    }


    public int[] getNaftaDay()
    {
        return naftaDay;
    }


    public void setNaftaDay(int[] naftaDay)
    {
        this.naftaDay = naftaDay;
    }


    public int[] getZombieDay()
    {
        return zombieDay;
    }


    public void setZombieDay(int[] zombieDay)
    {
        this.zombieDay = zombieDay;
    }


    public String toString2()
    {
        String texto = "InfoJSONItems  zombieDay=" + Arrays.toString(zombieDay);
        return texto;
    }


    @Override
    public String toString()
    {
        String texto1 =
            "InfoJSONItems [initMainEnergia=" + initMainEnergia + ", initMainEnergiaMax=" + initMainEnergiaMax +
            ", initNafta=" + initNafta + ", initCarbon=" + initCarbon + ", initDia=" + initDia + ", initMinutos=" +
            initMinutos + ", initHoras=" + initHoras + ", consumoFijo=" + consumoFijo + ", wariningPercentage=" +
            wariningPercentage + ", lamaparaFactorConsumo=" + lamaparaFactorConsumo + ", consumoText=" + consumoText +
            ", danoText=" + danoText + ", wattText=" + wattText + ", lumenText=" + lumenText + ", tutoText=" +
            tutoText + ", item1ConsumoWatt=" + item1ConsumoWatt + ", item1Lumenes=" + item1Lumenes + ", item1Texto=" +
            item1Texto + ", item2ConsumoWatt=" + item2ConsumoWatt + ", item2Lumenes=" + item2Lumenes + ", item2Texto=" +
            item2Texto + ", item3ConsumoWatt=" + item3ConsumoWatt + ", item3Lumenes=" + item3Lumenes + ", item3Texto=" +
            item3Texto + ", item4ConsumoWatt=" + item4ConsumoWatt + ", item4Lumenes=" + item4Lumenes + ", item4Texto=" +
            item4Texto + ", item5Capacidad=" + item5Capacidad + ", item5Texto=" + item5Texto +
            ", generadorFactorConsumo=" + generadorFactorConsumo + ", generadorFactorProduccion=" +
            generadorFactorProduccion + ", generadorFactorCosto=" + generadorFactorCosto +
            ", generadorProduccionText=" + generadorProduccionText + ", costoText=" + costoText + ", produccionText=" +
            produccionText + ", item6ConsumoGen=" + item6ConsumoGen + ", item6Costo=" + item6Costo +
            ", item6Combustible=" + item6Combustible + ", item6Productividad=" + item6Productividad + ", item6Texto=" +
            item6Texto + ", item7ConsumoGen=" + item7ConsumoGen + ", item7Costo=" + item7Costo + ", item7Combustible=" +
            item7Combustible + ", item7Productividad=" + item7Productividad + ", item7Texto=" + item7Texto +
            ", item8ConsumoGen=" + item8ConsumoGen + ", item8Costo=" + item8Costo + ", item8Combustible=" +
            item8Combustible + ", item8Productividad=" + item8Productividad + ", item8Texto=" + item8Texto +
            ", playerHealth=" + playerHealth + ", playerSpeed=" + playerSpeed + ", playerDamage=" + playerDamage +
            ", playerRecuperacion=" + playerRecuperacion + ", linternaBatery=" + linternaBatery +
            ", linternaBateryMax=" + linternaBateryMax + ", linternaDamage=" + linternaDamage + ", linternaConsumo=" +
            linternaConsumo + ", linternaCarga=" + linternaCarga + ", item1Day=" + Arrays.toString(item1Day) +
            ", item2Day=" + Arrays.toString(item2Day) + ", item3Day=" + Arrays.toString(item3Day) + ", item4Day=" +
            Arrays.toString(item4Day) + ", item5Day=" + Arrays.toString(item5Day) + ", item6Day=" +
            Arrays.toString(item6Day) + ", item7Day=" + Arrays.toString(item7Day) + ", item8Day=" +
            Arrays.toString(item8Day) + ", carbonDay=" + Arrays.toString(carbonDay) + ", naftaDay=" +
            Arrays.toString(naftaDay) + ", zombieDay=" + Arrays.toString(zombieDay) + "]";
        return texto1;
    }


    @Override
    public Double getCant_Nafta_dia(int dia)
    {
        return new Double(naftaDay[dia - 1]);
    }

    @Override
    public Double getCant_Carbon_dia(int dia)
    {
        return new Double(carbonDay[dia - 1]);
    }

    
}

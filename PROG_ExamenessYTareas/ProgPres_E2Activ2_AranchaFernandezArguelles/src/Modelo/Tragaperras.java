
package Modelo;

public class Tragaperras {

    // ATRIBUTOS
    private Slot slot1, slot2, slot3;
    private Alarma alarma;
    private Palanca palanca;
    private DepositoMonedas depositoMonedas;
    private ContadorCreditos contadorCreditos;
    private int minimoParaPremio;
    private int valorPremio1, valorPremio2, valorPremio3;
    private DAO_Resultado daoResultado;

    // MÉTODOS
    // Getters + Setters
    public Alarma getAlarma() {
        return alarma;
    }

    public void setAlarma(Alarma alarma) {
        this.alarma = alarma;
    }

    public Slot getSlot1() {
        return slot1;
    }

    public void setSlot1(Slot slot1) {
        this.slot1 = slot1;
    }

    public Slot getSlot2() {
        return slot2;
    }

    public void setSlot2(Slot slot2) {
        this.slot2 = slot2;
    }

    public Slot getSlot3() {
        return slot3;
    }

    public void setSlot3(Slot slot3) {
        this.slot3 = slot3;
    }

    public Palanca getPalanca() {
        return palanca;
    }

    public void setPalanca(Palanca palanca) {
        this.palanca = palanca;
    }

    public DepositoMonedas getDepositoMonedas() {
        return depositoMonedas;
    }

    public void setDepositoMonedas(DepositoMonedas depositoMonedas) {
        this.depositoMonedas = depositoMonedas;
    }

    public ContadorCreditos getContadorCreditos() {
        return contadorCreditos;
    }

    public void setContadorCreditos(ContadorCreditos contadorCreditos) {
        this.contadorCreditos = contadorCreditos;
    }

    public int getMinimoParaPremio() {
        return minimoParaPremio;
    }

    public void setMinimoParaPremio(int minimoParaPremio) {
        this.minimoParaPremio = minimoParaPremio;
    }

    public int getValorPremio1() {
        return valorPremio1;
    }

    public void setValorPremio1(int valorPremio1) {
        this.valorPremio1 = valorPremio1;
    }

    public int getValorPremio2() {
        return valorPremio2;
    }

    public void setValorPremio2(int valorPremio2) {
        this.valorPremio2 = valorPremio2;
    }

    public int getValorPremio3() {
        return valorPremio3;
    }

    public void setValorPremio3(int valorPremio3) {
        this.valorPremio3 = valorPremio3;
    }

    public DAO_Resultado getDaoResultado() {
        return daoResultado;
    }

    public void setDaoResultado(DAO_Resultado daoResultado) {
        this.daoResultado = daoResultado;
    }

    
    
    // toString
    @Override
    public String toString() {
        return "Tragaperras{" + "slot1=" + slot1 + ", slot2=" + slot2 + ", slot3=" + slot3 + ", alarma=" + alarma + ", palanca=" + palanca + ", depositoMonedas=" + depositoMonedas + ", contadorCreditos=" + contadorCreditos + ", minimoParaPremio=" + minimoParaPremio + ", valorPremio1=" + valorPremio1 + ", valorPremio2=" + valorPremio2 + ", valorPremio3=" + valorPremio3 + '}';
    }

    /**
     * Constructor por defecto con los valores de nuestro ejercicio en concreto
     */
    public Tragaperras() {
        slot1 = new Slot();
        slot2 = new Slot();
        slot3 = new Slot();
        alarma = new Alarma();
        palanca = new Palanca();
        depositoMonedas = new DepositoMonedas(50);
        contadorCreditos = new ContadorCreditos();
        minimoParaPremio = 20;
        valorPremio1 = 10;
        valorPremio2 = 5;
        valorPremio3 = 1;
        daoResultado=new DAO_Resultado();
    }

    /**
     * Constructor introduciendo por parámetro el valor de todos los atributos
     * configurables
     */
    public Tragaperras(int minimoParaPremio, int valorPremio1, int valorPremio2, int valorPremio3, int valorMonedas) {
        slot1 = new Slot();
        slot2 = new Slot();
        slot3 = new Slot();
        alarma = new Alarma();
        palanca = new Palanca();
        depositoMonedas = new DepositoMonedas(valorMonedas);
        contadorCreditos = new ContadorCreditos();
        this.minimoParaPremio = minimoParaPremio;
        this.valorPremio1 = valorPremio1;
        this.valorPremio2 = valorPremio2;
        this.valorPremio3 = valorPremio3;
        daoResultado=new DAO_Resultado();
    }

    /**
     * Método para activar la alarma true = se ha activado false = ya estaba
     * activada
     */
    public boolean activarAlarma() {
        if (!alarma.isActivada()) {
            alarma.activar();
            return true;
        } else {
            return false;
        }
    }

    /**
     * Método para desactivar la alarma true = se ha desactivado false = ya
     * estaba desactivada
     */
    public boolean desactivarAlarma() {
        if (alarma.isActivada()) {
            alarma.desactivar();
            return true;
        } else {
            return false;
        }
    }

    /**
     * Método para activar la palanca true = se ha activado false = ya estaba
     * activada
     */
    public boolean activarPalanca() {
        if (!palanca.isActivada()) {
            palanca.activar();
            return true;
        } else {
            return false;
        }
    }

    /**
     * Método para desactivar la palanca true = se ha desactivado false = ya
     * estaba desactivada
     */
    public boolean desactivarPalanca() {
        if (palanca.isActivada()) {
            palanca.desactivar();
            return true;
        } else {
            return false;
        }
    }

    /**
     * Método para introducir dinero, devuelve la cantidad final de créditos
     */
    public int meterDinero(int valorMonedas) {
        contadorCreditos.sumarCreditos(valorMonedas);
        depositoMonedas.meterMonedas(valorMonedas);
        // Puede haberse introducido 0€, hay que comprobar que hay créditos para
        // desbloquear la palanca
        if (contadorCreditos.getCantidadCreditos() > 0) {
            palanca.desbloquear();
        }
        return contadorCreditos.getCantidadCreditos();
    }

    /**
     * Método para hacer una tirada: true = se ha podido realizar la tirada,
     * false = no se ha podido realizar la tirada. Debe haber créditos y la
     * palanca no debe estar activa (es decir, no se debe estar ya en el
     * transcurso de una tirada en ese momento). No hace falta comprobar que la
     * palanca está desbloqueada (se desbloquea al meter dinero, y no se vuelve
     * a bloquear a menos que se acaben los créditos al finalizar una tirada)
     */
    public boolean tirar() {
        if (palanca.isDesbloqueada() && !palanca.isActivada()) {
            palanca.activar();
            contadorCreditos.restarCreditos();
            slot1.girarSlot();
            slot2.girarSlot();
            slot3.girarSlot();
            return true;
        } else {
            return false;
        }
    }

    /**
     * Método para comprobar si ha tocado premio, devuelve el valor del premio
     * (0 si no ha tocado) 
     * 
     * Ejecutará el método de daoResultado para sumar el premio correspondiente
     */
    public int comprobarSiPremio() {
        int auxPremio;
        if (slot1.compararSlots(slot2) && slot1.compararSlots(slot3)) {
            switch (slot1.getValor()) {
                case 0:
                    alarma.activar();
                    depositoMonedas.sacarMonedas(valorPremio1);
                    auxPremio = valorPremio1;
                    daoResultado.getResultado().sumarPremio1(valorPremio1);
                    break;
                default:
                    alarma.activar();
                    depositoMonedas.sacarMonedas(valorPremio2);
                    auxPremio = valorPremio2;
                    daoResultado.getResultado().sumarPremio2(valorPremio2);
            }
        } else if (slot1.compararSlots(slot2) || slot2.compararSlots(slot3)) {
            alarma.activar();
            depositoMonedas.sacarMonedas(valorPremio3);
            auxPremio = valorPremio3;
            daoResultado.getResultado().sumarPremio3(valorPremio3);
        } else {
            auxPremio = 0;
        }
        return auxPremio;
    }

    /**
     * Método para finalizar una tirada: true = había una tirada en marcha,
     * false = no había una tirada en marcha. Devuelve todos los parámetros a su
     * estado por defecto para que se pueda efectuar una nueva acción
     */
    public boolean terminarTirada() {
        if (palanca.isActivada()) {
            palanca.desactivar();
            alarma.desactivar();
            if (contadorCreditos.getCantidadCreditos() == 0) {
                palanca.bloquear();
            }
            return true;
        } else {
            return false;
        }
    }
  
}

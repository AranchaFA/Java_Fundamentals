/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author
 */
public class CalculoIRPF {

    public static float impuestos(float baseImponible) {
        // Array con los tipos impositivos para cada tramo (en orden ascendente)
        float[] tiposImpositivos = {0.19F, 0.24F, 0.30F, 0.37F, 0.45F};
        // Array con el tope de ingresos de cada tramo (en orden ascendente)
        float[] tramosIRPF = {12450, 20200, 35200, 60000};
        // Array con los totales a pagar por TODOS los tramos superados (en orden ascendente)
        float[] cuotasPorTramo = new float[4];
        // Inicializamos el primer valor y completamos el resto referenciándonos al inmediatamente anterior
        cuotasPorTramo[0] = tiposImpositivos[0] * tramosIRPF[0];
        for (int i = 1; i < cuotasPorTramo.length; i++) {
            cuotasPorTramo[i] = cuotasPorTramo[i - 1] + tiposImpositivos[i] * (tramosIRPF[i]-tramosIRPF[i-1]);
        }
        // NOTA: Con IF-ELSE nos ahorramos el return final (que sería obligatorio con una sucesión de if simples,
        // y además devolvería un valor incorrecto porque no responde a ningún cálculo) y la sentencia a evaluar
        // del último supuesto (cuando superamos el último tope de tramo)
        if (baseImponible <= tramosIRPF[0]) {
            return (baseImponible * tiposImpositivos[0]);
        } else if (baseImponible >= tramosIRPF[0] && baseImponible <= tramosIRPF[1]) {
            return (cuotasPorTramo[0] + (baseImponible - tramosIRPF[0]) * tiposImpositivos[1]);
        } else if (baseImponible >= tramosIRPF[1] && baseImponible <= tramosIRPF[2]) {
            return (cuotasPorTramo[1] + (baseImponible - tramosIRPF[1]) * tiposImpositivos[2]);
        } else if (baseImponible >= tramosIRPF[2] && baseImponible <= tramosIRPF[3]) {
            return (cuotasPorTramo[2] + (baseImponible - tramosIRPF[2]) * tiposImpositivos[3]);
        } else {
            return (cuotasPorTramo[3] + (baseImponible - tramosIRPF[3]) * tiposImpositivos[4]);
        }

    }
}

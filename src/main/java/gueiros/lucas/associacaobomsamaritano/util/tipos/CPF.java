/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gueiros.lucas.associacaobomsamaritano.util.tipos;

/**
 *
 * @author lucasgueiros
 */
public class CPF {

    private long numero;

    private int digitosVerificadores;

    public CPF() {
    }

    public CPF(long numero, int digitosVerificadores) {
        this.numero = numero;
        /*if(digitosVerificadores != gerarDigitosVerificadores(numero)) {
            throw new DigitosDeVerificacaoException();
        }*/
        this.digitosVerificadores = digitosVerificadores;
    }
    
    /**
     * Get the value of digitosVerificadores
     *
     * @return the value of digitosVerificadores
     */
    public int getDigitosVerificadores() {
        return digitosVerificadores;
    }

    /**
     * Get the value of numero
     *
     * @return the value of numero
     */
    public long getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return numero+"-"+digitosVerificadores;
    }
    
    /*public static int gerarDigitosVerificadores(long numero){
        int dv1 = 0;
        ArrayList<Character> cpfCharArray = new ArrayList<>(11);
        int paraMultiplicar = 10;
        cpfCharArray.ensureCapacity(8);
        for (int i = 0; i < 8; i++) {    
            cpfCharArray.add(Long.toString(numero).toCharArray()[i]);
            int d = Integer.parseInt(String.valueOf(cpfCharArray.get(i)));
            d *= paraMultiplicar;
            paraMultiplicar--;
            dv1 += d;
        }
        dv1 %= 11;
        dv1 = dv1<2 ? 0 : 11 - dv1;
        
        cpfCharArray.add(Long.toString(dv1).charAt(0));
        int dv2 = 0;
        paraMultiplicar = 11;
        for (int i = 0; i < 9; i++) {
            int d = Integer.parseInt(String.valueOf(cpfCharArray.get(i)));
            d *= paraMultiplicar;
            paraMultiplicar--;
            dv2 += d;
        }
        dv2 %= 11;
        dv2 = dv2<2 ? 0 : 11 - dv2;
        
        return (dv1*10) + dv2;
    }*/

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public void setDigitosVerificadores(int digitosVerificadores) {
        this.digitosVerificadores = digitosVerificadores;
    }
        

    
}

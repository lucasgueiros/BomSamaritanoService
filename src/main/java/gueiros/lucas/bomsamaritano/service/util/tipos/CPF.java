/* 
 * Copyright 2018 Lucas Gueiros 
 *
 * This file is part of BomSamaritanoService.
 * BomSamaritanoService is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package gueiros.lucas.bomsamaritano.service.util.tipos;

/**
 *
 * @author lucasgueiros
 */
public class CPF {

    private long numero;

    private int digitosVerificadores;

    /**
     *
     */
    public CPF() {
    }

    /**
     *
     * @param numero
     * @param digitosVerificadores
     */
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

    /**
     *
     * @param numero
     */


    public void setNumero(long numero) {
        this.numero = numero;
    }

    /**
     *
     * @param digitosVerificadores
     */
    public void setDigitosVerificadores(int digitosVerificadores) {
        this.digitosVerificadores = digitosVerificadores;
    }
        

    
}

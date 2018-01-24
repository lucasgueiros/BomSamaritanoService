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
package gueiros.lucas.associacaobomsamaritano.util.tipos;

/**
 *
 * @author lucasgueiros
 */
public class NIS {
    
    private final long nis;

    public NIS(long nis) {
        this.nis = nis;
    }

    /**
     * Get the value of nis
     *
     * @return the value of nis
     */
    public long getNis() {
        return nis;
    }

}

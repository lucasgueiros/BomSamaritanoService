/*******************************************************************************
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
 *******************************************************************************/
package gueiros.lucas.bomsamaritano.service.util.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

	// Aos alunos http://www.guj.com.br/articles/7

	private Connection con;
	private String url = "jdbc:postgresql://localhost:5432/bomsamaritanobd"; // TODO propriedade
	private String usuario = "postgres"; // TODO propriedade
	private String senha = "postgres"; // TODO propriedade

	public Conexao() {
	}

	public boolean conecta() {
		try {
			// Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url, usuario, senha);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean desconecta() {
		try {
			con.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public Connection getConnection() {
		return con;
	}

}

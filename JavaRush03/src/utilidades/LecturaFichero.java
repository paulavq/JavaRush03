package utilidades;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import modelo.Juego;

public class LecturaFichero {

	public static final String SEPARADOR = ",";

	static BufferedReader lector = null;

	public static ArrayList<Juego> cargaInicial() {

		ArrayList<Juego> lista = new ArrayList<Juego>();

		try {

			// Abrimos el .csv en el buffer de lectura
			lector = new BufferedReader(new FileReader("vgsales.csv"));

			// Leer una linea del archivo

			String linea = lector.readLine();

			while (linea != null) {
				// Separar la linea leida con el separador definido previamente

				String[] campos = linea.split(SEPARADOR);

				// Creamos el juego a introducir

				Juego j = new Juego();
				j.setRank(Integer.parseInt(campos[0]));
				j.setNombre(campos[1]);
				j.setPlataforma(campos[2]);
				j.setAno(Integer.parseInt(campos[3]));
				j.setGenero(campos[4]);
				j.setEditor(campos[5]);

				// A�adimos juego a la lista
				lista.add(j);

				// Leemos la siguiente linea
				linea = lector.readLine();

			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			// Cerramos el lector
			try {
				lector.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return lista;

	}

}

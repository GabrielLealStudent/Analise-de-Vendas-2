package applications;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import entities.Sale;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Entre o caminho do arquivo: ");
		String path = sc.nextLine();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			Set<Sale> set = new HashSet<>();

			String line = br.readLine();
			while (line != null) {

				String[] fields = line.split(",");
				int month = Integer.parseInt(fields[0]);
				int year = Integer.parseInt(fields[1]);
				int items = Integer.parseInt(fields[3]);
				double total = Double.parseDouble(fields[4]);

				set.add(new Sale(month, year, fields[2], items, total));

				line = br.readLine();
			}

			Map<String, Double> salesBySeller = set.stream()
					.collect(Collectors.groupingBy(Sale::getSeller, Collectors.summingDouble(Sale::getTotal)));

			for (Map.Entry<String, Double> entry : salesBySeller.entrySet()) {
				System.out.println(entry.getKey() + " - R$ " + String.format("%.2f", entry.getValue()));
			}

		} catch (IOException e) {
			System.out.println("Erro: " + path + " (O sistema não pode encontrar o arquivo especificado) ");
		}

		sc.close();

	}

}
package application;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Program {
    public static void main(String[] args) {
        /*Na contagem de votos de uma eleição, são gerados vários registros
de votação contendo o nome do candidato e a quantidade de votos
(formato .csv) que ele obteve em uma urna de votação. Você deve
fazer um programa para ler os registros de votação a partir de um
arquivo, e daí gerar um relatório consolidado com os totais de cada
candidato.*/

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter file full path: ");
        String path = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            Map<String, Integer> vote = new LinkedHashMap<>();
            String line= br.readLine();

            while (line != null) {
                String[] tokens = line.split(",");
                String name = tokens[0];
                Integer quantiVote = Integer.parseInt(tokens[1]);

                if (vote.containsKey(name)) {
                    vote.put(name, vote.get(name) + quantiVote);
                } else {
                    vote.put(name, quantiVote);
                }
                line = br.readLine();
            }
            for(String votes : vote.keySet()){
                System.out.println(votes+": "+vote.get(votes));
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
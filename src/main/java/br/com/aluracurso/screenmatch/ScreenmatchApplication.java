package br.com.aluracurso.screenmatch;

import br.com.aluracurso.screenmatch.model.DadosSerie;
import br.com.aluracurso.screenmatch.servicos.ConsumoAPI;
import br.com.aluracurso.screenmatch.servicos.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {

        SpringApplication.run(ScreenmatchApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        var consumoAPI = new ConsumoAPI();
        var json = consumoAPI.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=f47b3cf1");
        //System.out.println(json);
        /*json = consumoAPI.obterDados("https://coffee.alexflipnote.dev/random.json");
        System.out.println(json);
        */
        ConverteDados conversor = new ConverteDados();
        DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
        System.out.println(dados);

    }
}

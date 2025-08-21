package br.com.alura.screenmatch;

import br.com.alura.screenmatch.model.DadosEpisodio;
import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        var consumoApi = new ConsumoApi();
        var json = consumoApi.obterDados("https://www.omdbapi.com/?apikey=b3073b5a&t=The+Last+Of+Us&type=series");
        System.out.println(json);
        ConverteDados conversor = new ConverteDados();
        DadosSerie dados = conversor.obterdados(json, DadosSerie.class);
        System.out.println(dados);

        json = consumoApi.obterDados("https://www.omdbapi.com/?apikey=b3073b5a&t=The+Last+Of+Us&season=1&episode=2&type=series");
        DadosEpisodio dadosEpisodio = conversor.obterdados(json, DadosEpisodio.class);

        System.out.println(dadosEpisodio);



    }
}

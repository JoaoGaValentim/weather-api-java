package com.github.joaogavalentim.climatic.app;

import java.io.IOException;
import java.util.Scanner;

import com.github.joaogavalentim.climatic.app.models.Weather;
import com.github.joaogavalentim.climatic.app.services.WeatherService;
import com.github.joaogavalentim.climatic.app.services.exceptions.NotFoundException;

public class App {
    public static void main(String[] args) throws IOException, InterruptedException {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Informe uma cidade: ");
            WeatherService service = new WeatherService();
            Weather weather = service.getWeatherResponse(sc.nextLine());

            System.out.println("País = " + weather.getCountry());
            System.out.println("Cidade = " + weather.getCity());
            System.out.println("Ultima atualização = " + weather.getDateTime());
            System.out.println("Temperatura atual = " + weather.getActualTemperature() + " ˚C");
            System.out.println("Sensação térmica = " + weather.getFeelsLike() + " ˚C");
            System.out.println("Condição do tempo = " + weather.getTimeCondition());
            System.out.println("Humidade do ar = " + weather.getHumidity() + "%");
            System.out.println("Velocidade do vento = " + weather.getWindSpeed() + " km/h");
            System.out.println("Pressão atmosférica = " + weather.getAtmosphericPressure() + " mb");
        } catch (NotFoundException e) {
            System.out.println("Dados climáticos não encontrados :/");
        }
    }
}

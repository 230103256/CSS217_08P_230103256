package task01;

/** Клиент: работает только с HomeTheaterFacade. */
public class Main {
    public static void main(String[] args) {
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(
                new Amplifier(), new Projector(), new StreamingPlayer(), new TheaterLights());

        // Сеанс 1
        homeTheater.watchMovie("The Java Chronicles");
        System.out.println();
        homeTheater.endMovie();

        System.out.println("\n----------------------------------------\n");

        // Сеанс 2: проверяем, что после выключения система снова запускается чисто
        homeTheater.watchMovie("Design Patterns: The Movie");
        System.out.println();
        homeTheater.endMovie();
    }
}

// Subsystem 2: Controls video projection and screen input

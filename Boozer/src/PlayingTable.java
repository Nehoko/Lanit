public class PlayingTable {
    public static void main(String[] args) {
        //Создание ботов
        Player Petya = new Player("Петя");
        Player Vacya = new Player("Вася");
        Player Kolya = new Player("Коля");
        Player Sanya = new Player("Саня");

        //Запуск игры и запись ботов на игру
        CardGame boozer = new Boozer(Petya, Vacya, Kolya, Sanya);
        boozer.play();
    }
}
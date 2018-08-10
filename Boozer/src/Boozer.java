import java.util.*;

import static java.lang.Integer.MAX_VALUE;

class Boozer {

    Boozer(Player player1, Player player2, Player player3, Player player4){
        ArrayList<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);
        play(players);
    }
    private void play(ArrayList<Player> players){
        //Создание колоды карт
        ArrayList<Card> cards = new ArrayList<>(36);
        cards.add(new Card(6,"6 Черви"));
        cards.add(new Card(6,"6 Крести"));
        cards.add(new Card(6,"6 Пики"));
        cards.add(new Card(6,"6 Буби"));
        cards.add(new Card(7,"7 Черви"));
        cards.add(new Card(7,"7 Крести"));
        cards.add(new Card(7,"7 Пики"));
        cards.add(new Card(7,"7 Буби"));
        cards.add(new Card(8,"8 Черви"));
        cards.add(new Card(8,"8 Кретси"));
        cards.add(new Card(8,"8 Пики"));
        cards.add(new Card(8,"8 Буби"));
        cards.add(new Card(9,"9 Черви"));
        cards.add(new Card(9,"9 Крести"));
        cards.add(new Card(9,"9 Пики"));
        cards.add(new Card(9,"9 Буби"));
        cards.add(new Card(10,"10 Черви"));
        cards.add(new Card(10,"10 Крести"));
        cards.add(new Card(10,"10 Пики"));
        cards.add(new Card(10,"10 Буби"));
        cards.add(new Card(11,"Валет Черви"));
        cards.add(new Card(11,"Валет Крести"));
        cards.add(new Card(11,"Валет Пики"));
        cards.add(new Card(11,"Валет Буби"));
        cards.add(new Card(12,"Дама Черви"));
        cards.add(new Card(12,"Дама Крести"));
        cards.add(new Card(12,"Дама Пики"));
        cards.add(new Card(12,"Дама Буби"));
        cards.add(new Card(13,"Король Черви"));
        cards.add(new Card(13,"Король Крести"));
        cards.add(new Card(13,"Король Пики"));
        cards.add(new Card(13,"Король Буби"));
        cards.add(new Card(14,"Туз Черви"));
        cards.add(new Card(14,"Туз Крести"));
        cards.add(new Card(14,"Туз Пики"));
        cards.add(new Card(14,"Туз Буби"));

        //Раздача карт на руки
        int j = 0;
        while(!cards.isEmpty()){
            Random random = new Random();
            int i = random.nextInt(cards.size());
            players.get(j).addCard(cards.get(i));
            cards.remove(i);
            j++;
            if (j==4) j = 0;
        }
        //Начало игры
        HashSet<Card> table = new HashSet<>();
        HashMap<Player, Integer> round = new HashMap<>();
        boolean notBroken = true;
        while(notBroken) {
            //Скидывание карт на стол
            int min = MAX_VALUE;
            boolean matched = false;
            for (Player player : players) {
                if (player.getHand()>=36) {//Условие прерывания
                    notBroken = false;
                    System.out.println("Игрок " + player.getName() + " проиграл!");
                    break;
                }
                Card card = player.dropCard();
                if(card == null){
                    System.out.println("Игрок " + player.getName() + " вышел из игры победителем!");
                }else {
                    System.out.println("Игрок " + player.getName() + ": " + card.getName());
                    int number = card.getValue();
                    round.put(player, number);
                    table.add(card);
                    if (number == min){
                        matched = true;
                    }else if (number < min){
                        min = number;
                        matched = false;
                    }
                }
            }
            //Кто скинул наименьшую карту, тот забирает стол
            for (Map.Entry<Player, Integer> entry : round.entrySet()) {
                if (entry.getValue() == min && !matched) {
                    entry.getKey().addTable(table);
                    table.clear();
                    System.out.println("Игрок " + entry.getKey().getName() + " забирает стол.");
                }
            }
        }
    }
}
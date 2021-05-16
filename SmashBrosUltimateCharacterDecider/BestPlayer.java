import java.util.Scanner;

public class BestPlayer {

    private static int[][] characterChart;
    private static String[] characterList;

    public static void main(String[] args) {

        characterList = createCharacterList();
        characterChart = addChartValues(createGraph());

        run();
    }

    private static void run(){

        Scanner sc = new Scanner(System.in);
        int[] opponents = {-1,-1,-1,-1,-1,-1,-1,-1};
        int i = 0;

        System.out.println("Who are you facing? (Type '-' to end)");

        while((i < 8)){

            String opponent = sc.nextLine();
            if(opponent.equals("-")){
                break;
            }
            for(int j = 0; j < characterList.length; j++){
                if(characterList[j].equals(opponent)){
                    opponents[i] = j;
                    i++;
                }
            }
        }
        System.out.println(bestCounterCharacter(opponents));
    }

    private static String bestCounterCharacter(int[] opponents){

        int[] score = new int[characterList.length];

        for(int i = 0; i < opponents.length; i++){
            for(int j = 0; j < characterList.length; j++) {
                if (opponents[i] != -1) {
                    if (characterChart[opponents[i]][j] == 1) {
                        score[j] += 1;
                    }
                }
            }
        }
        int maxScore = 0;
        int maxScoreIndex = -1;
        for(int i = 0; i < score.length; i++){
            if(score[i] > maxScore){
                maxScore = score[i];
                maxScoreIndex = i;
            }
        }
        return characterList[maxScoreIndex];
    }

    private static int[][] createGraph() {

        int characterChart[][] = new int[80][80];

        for (int i = 0; i < characterChart.length; i++) {
            for (int j = 0; j < characterChart.length; j++) {
                characterChart[i][j] = 0;
            }
        }
        return characterChart;
    }

    private static void printGraph(int[][] graph) {

        System.out.println(graph.length);

        System.out.print("{");
        for (int i = 0; i < 80; i++) {
            System.out.print("{");
            for (int j = 0; j < 80; j++) {
                System.out.print(graph[i][j]);
                if (j < 79) {
                    System.out.print(",");
                }
            }
            System.out.println("}");
        }
        System.out.println("}");
    }

    private static void addChartValuesUI(){

        int characterIndex = -1;
        int whoIndex = -1;
        StringBuilder  printString = new StringBuilder();

        Scanner sc = new Scanner(System.in);
        System.out.println("What character?");

        String character = sc.nextLine();
        for(int i = 0; i < characterList.length; i++){
            if(characterList[i].equals(character)){
                characterIndex = i;
                break;
            }
        }

        printString.append("// " + character+ "\n");

        while(true){

            System.out.println("Who");

            String who = sc.nextLine();

            if(who.equals("q")){
                break;
            }
            else {
                for (int i = 0; i < characterList.length; i++) {
                    if (characterList[i].equals(who)) {
                        whoIndex = i;
                        break;
                    }
                }
                printString.append("chart[" + characterIndex + "][" + whoIndex + "] = 1;\n");
            }
        }
        System.out.println(printString.toString());
    }

    private static String[] createCharacterList(){

        String[] characterList = {"Banjo And Kazooie", "Bayonetta", "Bowser", "Bowser Jr.", "Captain Falcon", "Charizard", "Chrom", "Cloud", "Corrin", "Daisy", "Dark Pit", "Dark Samus", "Diddy Kong", "Donkey Kong",
                "Dr. Mario", "Duck Hunt", "Falco", "Fox", "Ganondorf", "Greninja", "Hero", "Ice Climbers", "Ike", "Incineroar", "Inkling", "Isabelle", "Ivysaur", "Jigglypuff", "Joker", "Ken", "King Dedede",
                "King K. Rool", "Kirby", "Link", "Little Mac", "Lucario", "Lucas", "Lucina", "Luigi", "Mario", "Marth", "Mega Man", "Meta Knight", "Mewtwo",
                "Mii Brawler", "Mii Gunner", "Mii Swordfighter", "Mr. Game And Watch", "Ness", "Olimar", "Pac-Man", "Palutena", "Peach",
                "Pichu", "Pikachu", "Piranha Plant", "Pit", "R.O.B.", "Richter", "Ridley", "Robin", "Rosalina And Luma", "Roy", "Ryu",
                "Samus", "Sheik", "Shulk", "Simon", "Snake", "Sonic", "Squirtle", "Toon Link", "Villager", "Wario", "Wii Fit Trainer",
                "Wolf", "Yoshi", "Young Link", "Zelda", "Zero Suit Samus"};
        return characterList;
    }

    private static int[][] addChartValues(int[][] chart) {

        //Banjo And Kazooie
        chart[0][61] = 1;
        chart[0][28] = 1;
        chart[0][54] = 1;
        chart[0][34] = 1;

        //Bayonetta
        chart[1][35] = 1;
        chart[1][53] = 1;
        chart[1][51] = 1;
        chart[1][77] = 1;
        chart[1][26] = 1;

        //Bowser
        chart[2][77] = 1;
        chart[2][64] = 1;
        chart[2][11] = 1;
        chart[2][40] = 1;
        chart[2][48] = 1;

        //Bowser Jr.
        chart[3][75] = 1;
        chart[3][66] = 1;
        chart[3][10] = 1;
        chart[3][33] = 1;
        chart[3][67] = 1;

        //Captain Falcon
        chart[4][54] = 1;
        chart[4][66] = 1;
        chart[4][68] = 1;
        chart[4][22] = 1;
        chart[4][25] = 1;

        //Charizard
        chart[5][53] = 1;
        chart[5][22] = 1;
        chart[5][67] = 1;
        chart[5][79] = 1;
        chart[5][33] = 1;

        //Chrom
        chart[6][77] = 1;
        chart[6][70] = 1;
        chart[6][54] = 1;
        chart[6][37] = 1;
        chart[6][40] = 1;

        //Cloud
        chart[7][54] = 1;
        chart[7][40] = 1;
        chart[7][24] = 1;
        chart[7][75] = 1;
        chart[7][66] = 1;

        // Corrin
        chart[8][67] = 1;
        chart[8][11] = 1;
        chart[8][64] = 1;
        chart[8][68] = 1;
        chart[8][2] = 1;

        // Daisy
        chart[9][7] = 1;
        chart[9][75] = 1;
        chart[9][37] = 1;
        chart[9][77] = 1;
        chart[9][40] = 1;

        // Dark Pit
        chart[10][3] = 1;
        chart[10][53] = 1;
        chart[10][77] = 1;
        chart[10][22] = 1;
        chart[10][54] = 1;

        // Dark Samus
        chart[11][75] = 1;
        chart[11][6] = 1;
        chart[11][77] = 1;
        chart[11][16] = 1;
        chart[11][17] = 1;

        // Diddy Kong
        chart[12][57] = 1;
        chart[12][53] = 1;
        chart[12][64] = 1;
        chart[12][38] = 1;
        chart[12][54] = 1;

        // Donkey Kong
        chart[13][53] = 1;
        chart[13][54] = 1;
        chart[13][41] = 1;
        chart[13][57] = 1;
        chart[13][58] = 1;

        // Dr. Mario
        chart[14][40] = 1;
        chart[14][51] = 1;
        chart[14][37] = 1;
        chart[14][71] = 1;
        chart[14][62] = 1;

        // Duck Hunt
        chart[15][78] = 1;
        chart[15][62] = 1;
        chart[15][30] = 1;
        chart[15][26] = 1;
        chart[15][65] = 1;

        // Falco
        chart[16][57] = 1;
        chart[16][53] = 1;
        chart[16][54] = 1;
        chart[16][33] = 1;
        chart[16][76] = 1;

        // Fox
        chart[17][57] = 1;
        chart[17][37] = 1;
        chart[17][54] = 1;
        chart[17][52] = 1;
        chart[17][75] = 1;

        // Ganondorf
        chart[18][58] = 1;
        chart[18][48] = 1;
        chart[18][68] = 1;
        chart[18][25] = 1;
        chart[18][77] = 1;

        // Greninja
        chart[19][77] = 1;
        chart[19][68] = 1;
        chart[19][51] = 1;
        chart[19][2] = 1;
        chart[19][71] = 1;

        // Hero
        chart[20][3] = 1;
        chart[20][71] = 1;
        chart[20][48] = 1;
        chart[20][0] = 1;
        chart[20][57] = 1;

        // Ice Climbers
        chart[21][67] = 1;
        chart[21][58] = 1;
        chart[21][68] = 1;
        chart[21][77] = 1;
        chart[21][57] = 1;

        // Ike
        chart[22][53] = 1;
        chart[22][77] = 1;
        chart[22][67] = 1;
        chart[22][70] = 1;
        chart[22][24] = 1;

        // Incineroar
        chart[23][58] = 1;
        chart[23][67] = 1;
        chart[23][36] = 1;
        chart[23][75] = 1;
        chart[23][25] = 1;

        // Inkling
        chart[24][37] = 1;
        chart[24][7] = 1;
        chart[24][40] = 1;
        chart[24][62] = 1;
        chart[24][57] = 1;

        // Isabelle
        chart[25][54] = 1;
        chart[25][53] = 1;
        chart[25][37] = 1;
        chart[25][51] = 1;
        chart[25][77] = 1;

        // Ivysaur
        chart[26][41] = 1;
        chart[26][51] = 1;
        chart[26][75] = 1;
        chart[26][22] = 1;
        chart[26][53] = 1;

        // Jigglypuff
        chart[27][22] = 1;
        chart[27][37] = 1;
        chart[27][40] = 1;
        chart[27][6] = 1;
        chart[27][7] = 1;

        // Joker
        chart[28][24] = 1;
        chart[28][23] = 1;
        chart[28][75] = 1;
        chart[28][2] = 1;
        chart[28][6] = 1;

        // Ken
        chart[29][48] = 1;
        chart[29][27] = 1;
        chart[29][54] = 1;
        chart[29][53] = 1;
        chart[29][64] = 1;

        // King Dedede
        chart[30][51] = 1;
        chart[30][54] = 1;
        chart[30][53] = 1;
        chart[30][78] = 1;
        chart[30][67] = 1;

        // King K. Rool
        chart[31][25] = 1;
        chart[31][68] = 1;
        chart[31][72] = 1;
        chart[31][67] = 1;
        chart[31][69] = 1;

        // Kirby
        chart[32][22] = 1;
        chart[32][37] = 1;
        chart[32][6] = 1;
        chart[32][62] = 1;
        chart[32][8] = 1;

        // Link
        chart[33][75] = 1;
        chart[33][53] = 1;
        chart[33][16] = 1;
        chart[33][54] = 1;
        chart[33][6] = 1;

        // Little Mac
        chart[34][3] = 1;
        chart[34][59] = 1;
        chart[34][25] = 1;
        chart[34][75] = 1;
        chart[34][57] = 1;

        // Lucario
        chart[35][2] = 1;
        chart[35][48] = 1;
        chart[35][16] = 1;
        chart[35][6] = 1;
        chart[35][37] = 1;

        // Lucas
        chart[36][52] = 1;
        chart[36][7] = 1;
        chart[36][51] = 1;
        chart[36][37] = 1;
        chart[36][76] = 1;

        // Lucina
        chart[37][77] = 1;
        chart[37][58] = 1;
        chart[37][68] = 1;
        chart[37][24] = 1;
        chart[37][67] = 1;

        // Luigi
        chart[38][77] = 1;
        chart[38][37] = 1;
        chart[38][41] = 1;
        chart[38][33] = 1;
        chart[38][11] = 1;

        // Mario
        chart[39][37] = 1;
        chart[39][40] = 1;
        chart[39][51] = 1;
        chart[39][7] = 1;
        chart[39][22] = 1;

        // Marth
        chart[40][77] = 1;
        chart[40][71] = 1;
        chart[40][22] = 1;
        chart[40][9] = 1;
        chart[40][42] = 1;

        // Mega Man
        chart[41][75] = 1;
        chart[41][53] = 1;
        chart[41][17] = 1;
        chart[41][54] = 1;
        chart[41][51] = 1;

        // Meta Knight
        chart[42][41] = 1;
        chart[42][48] = 1;
        chart[42][7] = 1;
        chart[42][45] = 1;
        chart[42][8] = 1;

        // Mewtwo
        chart[43][53] = 1;
        chart[43][70] = 1;
        chart[43][76] = 1;
        chart[43][4] = 1;
        chart[43][16] = 1;

        // Mii Brawler
        chart[44][53] = 1;
        chart[44][8] = 1;
        chart[44][78] = 1;
        chart[44][7] = 1;
        chart[44][75] = 1;

        // Mii Gunner
        chart[45][53] = 1;
        chart[45][76] = 1;
        chart[45][26] = 1;
        chart[45][8] = 1;
        chart[45][28] = 1;

        // Mii Swordfighter
        chart[46][53] = 1;
        chart[46][75] = 1;
        chart[46][7] = 1;
        chart[46][51] = 1;
        chart[46][33] = 1;

        // Mr. Game And Watch
        chart[47][22] = 1;
        chart[47][7] = 1;
        chart[47][40] = 1;
        chart[47][66] = 1;
        chart[47][8] = 1;

        // Ness
        chart[48][77] = 1;
        chart[48][37] = 1;
        chart[48][75] = 1;
        chart[48][22] = 1;
        chart[48][71] = 1;

        // Olimar
        chart[49][57] = 1;
        chart[49][8] = 1;
        chart[49][52] = 1;
        chart[49][58] = 1;
        chart[49][67] = 1;

        // Pac-Man
        chart[50][17] = 1;
        chart[50][16] = 1;
        chart[50][53] = 1;
        chart[50][68] = 1;
        chart[50][67] = 1;

        // Palutena
        chart[51][53] = 1;
        chart[51][24] = 1;
        chart[51][17] = 1;
        chart[51][54] = 1;
        chart[51][19] = 1;

        // Peach
        chart[52][37] = 1;
        chart[52][33] = 1;
        chart[52][7] = 1;
        chart[52][40] = 1;
        chart[52][62] = 1;

        // Pichu
        chart[53][37] = 1;
        chart[53][40] = 1;
        chart[53][68] = 1;
        chart[53][62] = 1;
        chart[53][6] = 1;

        // Pikachu
        chart[54][48] = 1;
        chart[54][76] = 1;
        chart[54][49] = 1;
        chart[54][52] = 1;
        chart[54][20] = 1;

        // Piranha Plant
        chart[55][2] = 1;
        chart[55][16] = 1;
        chart[55][28] = 1;
        chart[55][64] = 1;
        chart[55][20] = 1;

        // Pit
        chart[56][37] = 1;
        chart[56][54] = 1;
        chart[56][6] = 1;
        chart[56][68] = 1;
        chart[56][53] = 1;

        // R.O.B.
        chart[57][53] = 1;
        chart[57][7] = 1;
        chart[57][68] = 1;
        chart[57][17] = 1;
        chart[57][43] = 1;

        // Richter
        chart[58][53] = 1;
        chart[58][54] = 1;
        chart[58][7] = 1;
        chart[58][51] = 1;
        chart[58][12] = 1;

        // Ridley
        chart[59][54] = 1;
        chart[59][53] = 1;
        chart[59][48] = 1;
        chart[59][77] = 1;
        chart[59][51] = 1;

        // Robin
        chart[60][53] = 1;
        chart[60][54] = 1;
        chart[60][75] = 1;
        chart[60][70] = 1;
        chart[60][16] = 1;

        // Rosalina And Luma
        chart[61][6] = 1;
        chart[61][74] = 1;
        chart[61][54] = 1;
        chart[61][51] = 1;
        chart[61][78] = 1;

        // Roy
        chart[62][58] = 1;
        chart[62][68] = 1;
        chart[62][77] = 1;
        chart[62][67] = 1;
        chart[62][61] = 1;

        // Ryu
        chart[63][58] = 1;
        chart[63][67] = 1;
        chart[63][32] = 1;
        chart[63][40] = 1;
        chart[63][70] = 1;

        // Samus
        chart[64][17] = 1;
        chart[64][75] = 1;
        chart[64][51] = 1;
        chart[64][16] = 1;
        chart[64][53] = 1;

        // Sheik
        chart[65][6] = 1;
        chart[65][76] = 1;
        chart[65][53] = 1;
        chart[65][19] = 1;
        chart[65][70] = 1;

        // Shulk
        chart[66][68] = 1;
        chart[66][36] = 1;
        chart[66][54] = 1;
        chart[66][17] = 1;
        chart[66][26] = 1;

        // Simon
        chart[67][54] = 1;
        chart[67][53] = 1;
        chart[67][77] = 1;
        chart[67][19] = 1;
        chart[67][42] = 1;

        // Snake
        chart[68][48] = 1;
        chart[68][36] = 1;
        chart[68][77] = 1;
        chart[68][54] = 1;
        chart[68][33] = 1;

        // Sonic
        chart[69][75] = 1;
        chart[69][54] = 1;
        chart[69][41] = 1;
        chart[69][26] = 1;
        chart[69][25] = 1;

        // Squirtle
        chart[70][53] = 1;
        chart[70][66] = 1;
        chart[70][54] = 1;
        chart[70][57] = 1;
        chart[70][17] = 1;

        // Toon Link
        chart[71][17] = 1;
        chart[71][7] = 1;
        chart[71][75] = 1;
        chart[71][39] = 1;
        chart[71][58] = 1;

        // Villager
        chart[72][51] = 1;
        chart[72][17] = 1;
        chart[72][41] = 1;
        chart[72][76] = 1;
        chart[72][16] = 1;

        // Wario
        chart[73][37] = 1;
        chart[73][7] = 1;
        chart[73][40] = 1;
        chart[73][53] = 1;
        chart[73][75] = 1;

        // Wii Fit Trainer
        chart[74][53] = 1;
        chart[74][24] = 1;
        chart[74][41] = 1;
        chart[74][70] = 1;
        chart[74][52] = 1;

        // Wolf
        chart[75][53] = 1;
        chart[75][37] = 1;
        chart[75][54] = 1;
        chart[75][70] = 1;
        chart[75][40] = 1;

        // Yoshi
        chart[76][7] = 1;
        chart[76][40] = 1;
        chart[76][37] = 1;
        chart[76][33] = 1;
        chart[76][77] = 1;

        // Young Link
        chart[77][75] = 1;
        chart[77][17] = 1;
        chart[77][7] = 1;
        chart[77][51] = 1;
        chart[77][6] = 1;

        // Zelda
        chart[78][66] = 1;
        chart[78][24] = 1;
        chart[78][76] = 1;
        chart[78][70] = 1;
        chart[78][62] = 1;

        // Zero Suit Samus
        chart[79][53] = 1;
        chart[79][54] = 1;
        chart[79][17] = 1;
        chart[79][70] = 1;
        chart[79][19] = 1;

        //printGraph(chart);

        return chart;
    }

}

/*
0. Banjo And Kazooie
1. Bayonetta
2. Bowser
3. Bowser Jr.
4. Captain Falcon
5. Charizard
6. Chrom
7. Cloud
8. Corrin
9. Daisy
10. Dark Pit
11. Dark Samus
12. Diddy Kong
13. Donkey Kong
14. Dr. Mario
15. Duck Hunt
16. Falco
17. Fox
18. Ganondorf
19. Greninja
20. Hero
21. Ice Climbers
22. Ike
23. Incineroar
24. Inkling
25. Isabelle
26. Ivysaur
27. Jigglypuff
28. Joker
29. Ken
30. King Dedede
31. King K. Rool
32. Kirby
33. Link
34. Little Mac
35. Lucario
36. Lucas
37. Lucina
38. Luigi
39. Mario
40. Marth
41. Mega Man
42. Meta Knight
43. Mewtwo
44. Mii Brawler
45. Mii Gunner
46. Mii Swordfighter
47. Mr. Game And Watch
48. Ness
49. Olimar
50. Pac-Man
51. Palutena
52. Peach
53. Pichu
54. Pikachu
55. Piranha Plant
56. Pit
57. R.O.B.
58. Richter
59. Ridley
60. Robin
61. Rosalina And Luma
62. Roy
63. Ryu
64. Samus
65. Sheik
66. Shulk
67. Simon
68. Snake
69. Sonic
70. Squirtle
71. Toon Link
72. Villager
73. Wario
74. Wii Fit Trainer
75. Wolf
76. Yoshi
77. Young Link
78. Zelda
79. Zero Suit Samus
 */
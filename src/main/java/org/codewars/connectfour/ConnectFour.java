package org.codewars.connectfour;

import java.util.*;

public class ConnectFour {
    public static String whoIsWinner(List<String> piecesPositionList) {
        piecesPositionList.forEach(s -> System.out.println("\"" + s + "\","));
        //boolean[][] gameArray = new boolean[6][7];
        ArrayList<ArrayList<String>> columns = new ArrayList<>();
        for(int i = 0; i < 7; i++) columns.add(new ArrayList<String>());

        for (String s : piecesPositionList) {
            int column = s.codePointAt(0) - 65;
            if(s.contains("Red")) columns.get(column).add("R");
            else columns.get(column).add("Y");
        }

        for(int row = 0; row < 6; row++) {
            int r = 0; int y = 0;
            for(int col = 0; col < 7; col++) {
                if(columns.get(col).size() > row) {
                    String c = columns.get(col).get(row);
                    if(c.equals("R")) {
                        r++;
                        y = 0;
                        if(r == 4) return "Red";
                    } else {
                        y++;
                        r = 0;
                        if(y == 4) return "Yellow";
                    }
                } else {
                    r = 0; y = 0;
                }
            }
        }

        for(int col = 0; col < 7; col++) {
            int r = 0; int y = 0;
            for(int row = 0; row < 6; row++) {
                if(columns.get(col).size() > row) {
                    String c = columns.get(col).get(row);
                    if(c.equals("R")) {
                        r++;
                        y = 0;
                        if(r == 4) return "Red";
                    } else {
                        y++;
                        r = 0;
                        if(y == 4) return "Yellow";
                    }
                } else {
                    r = 0; y = 0;
                }
            }
        }

        for(int q = 0; q < 6; q++)
        for(int i = q; i < 4; i++) {
            int r = 0; int y = 0;
            for (int col = i, row = 0; col < 7; col++, row++) {
                if (columns.get(col).size() > row) {
                    String c = columns.get(col).get(row);
                    if (c.equals("R")) {
                        r++;
                        y = 0;
                        if (r == 4) return "Red";
                    } else {
                        y++;
                        r = 0;
                        if (y == 4) return "Yellow";
                    }
                } else {
                    r = 0;
                    y = 0;
                }
            }
        }

        for(int q = 0; q < 6; q++)
        for(int i = 7; i >=0; i--) {
            int r = 0; int y = 0;
            for (int col = i, row = q; col < 7; col++, row++) {
                if (columns.get(col).size() > row) {
                    String c = columns.get(col).get(row);
                    if (c.equals("R")) {
                        r++;
                        y = 0;
                        if (r == 4) return "Red";
                    } else {
                        y++;
                        r = 0;
                        if (y == 4) return "Yellow";
                    }
                } else {
                    r = 0;
                    y = 0;
                }
            }
        }

        return "Draw";
    }
}
package org.codewars.insane_coloured_triangles;


public class Kata {

    public static char triangle(final String row) {
        System.out.println(row);
        char[] previousRow = row.toCharArray();
        while(previousRow.length > 1) {
            char[] nextRow = new char[previousRow.length - 1];
            for(int i = 0; i < previousRow.length - 1; i++) {
                nextRow[i] = reducingFromTwoToOne(previousRow[ i ], previousRow[ i + 1 ]);
            }
            previousRow = nextRow;
        }
        return previousRow[0];
    }
    public static char reducingFromTwoToOne(char char1, char char2) {
        if(char1 == 'R') {
            if(char2 == 'G')
                return 'B';
            if(char2 == 'B')
                return 'G';
            else
                return 'R';
        } else if(char1 == 'G') {
            if(char2 == 'R')
                return 'B';
            if(char2 == 'B')
                return 'R';
            else
                return 'G';
        } else if(char1 == 'B') {
            if(char2 == 'R')
                return 'G';
            if(char2 == 'G')
                return 'R';
            else
                return 'B';
        }

        return 'G';
    }

}
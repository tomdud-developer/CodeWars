package org.codewars.secretdetective;

import java.util.Arrays;

public class SecretDetective {

    public String recoverSecret(char[][] triplets) {
        StringBuilder stringBuilder = new StringBuilder();
        for(char[] tt : triplets)
            for(char t : tt)
                if(stringBuilder.indexOf(String.valueOf(t)) == -1) {
                    stringBuilder.append(t);
                }
        for(int i = 0; i < stringBuilder.length()/2; i++)
        for(char[] tt : triplets) {
            char c1 = tt[0];
            char c2 = tt[1];
            char c3 = tt[2];

            int c2Position = stringBuilder.indexOf(String.valueOf(c2));
            int c3Position = stringBuilder.indexOf(String.valueOf(c3));
            int c1Position = stringBuilder.indexOf(String.valueOf(c1));


            // 2 must be after 1
            if(c2Position < c1Position) {
                stringBuilder.insert(c2Position, c1);
                stringBuilder.deleteCharAt(c2Position + 1);

                stringBuilder.insert(c1Position, c2);
                stringBuilder.deleteCharAt(c1Position + 1);

                c2Position = c1Position;
            }

            // 3 must be after 2
            if(c3Position < c2Position) {
                stringBuilder.insert(c3Position, c2);
                stringBuilder.deleteCharAt(c3Position + 1);

                stringBuilder.insert(c2Position, c3);
                stringBuilder.deleteCharAt(c2Position + 1);
            }
        }

        return stringBuilder.toString();
    }

}

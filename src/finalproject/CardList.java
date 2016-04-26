/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package finalproject;

/**
 * Project:
 * Author: Davin
 * Date: 8-Apr-2016
 * Teacher: Mr. Wachs 
 */
public class CardList {
    public static Card[] cardList= new Card[100];

    public CardList() {
        for (int i = 0; i < cardList.length; i++) {
            cardList[i] = new Card(1, 1, 1, 0, null, "");
        }
    }
    
}

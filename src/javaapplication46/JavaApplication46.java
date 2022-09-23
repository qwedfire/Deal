package javaapplication46;

/**
 *
 * @author LAND
 */
public class JavaApplication46 {

    /**
     * @param args the command line arguments
     */
    public static final int MaxCard = 52;

    public static void main(String[] args) {
        // 1. 利用genCards創建兩副牌(cards)
        CardLinkedList card1 = new CardLinkedList();
        CardLinkedList card2 = new CardLinkedList();
        card1.genCards();
        card2.genCards();
        //2. 將兩副牌利用shuffle打亂並利用printCards印出
        card1.shuffle(card1.getcardlist(), MaxCard);
        card2.shuffle(card2.getcardlist(), MaxCard);
        System.out.println("牌組一");
        card1.printCards(card1.getcardlist());
        System.out.println();
        System.out.println("牌組二");
        card2.printCards(card2.getcardlist());
        //3. 比較兩副牌的第 1 個位置的大小並輸出(位置從0開始)輸出結果如右 card1較大/相等/card2較大
        int c1 = card1.getPoint(1);
        int c2 = card2.getPoint(1);
        int a = card1.comparePoint(c1, c2);
        System.out.print("\ncard1:" + c1 + " card2:" + c2 + "  結果為:");
        if (a > 0) {
            System.out.println("card1較大");
        } else if (a < 0) {
            System.out.println("card2較大");
        } else {
            System.out.println("相等");
        }
        //4. 將兩副牌利用sort排序並利用printCards印出
        card1.sort((t1, t2) -> t1 - t2); //Lambda
        card2.sort(new CardLinkedList.Comparator() {
            @Override
            public int compare(int t1, int t2) {
                return (int) (t1 - t2);
            }
        });
        System.out.println("-------------------------------------------------排序後-------------------------------------------------------------");
        System.out.println("牌組一");
        card1.printCards(card1.getcardlist());
        System.out.println("\n牌組二");
        card2.printCards(card2.getcardlist());
    }
}

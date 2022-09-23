/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication46;

/**
 *
 * @author LAND
 */
public class CardLinkedList {
    /**
     * 比較器排序大小
     */
    public interface Comparator{
        public int compare(int t1,int t2);
    }
    private static final int MaxCard=52;  //52張牌
    private static final int MaxNumber=13;  //數字最大的值
    private LinkedList<Integer> cardlist;   
    /**
     * CardLinkedList()的建構子
     */
    public CardLinkedList(){
        cardlist=new LinkedList<Integer>();        
    }
    /**
     * 取得linklist
     */
    public LinkedList<Integer> getcardlist(){
        return cardlist;
    }
    /**
     * 新增52張卡牌
     */
    public void genCards(){        
        for(int i=0;i<MaxCard;i++){
            cardlist.add(i+1);
        }        
    }
    /**
     * 交換linkedlist兩筆的資料
     * @param list 取得linkedlist 
     * @param t1 第一筆
     * @param t2 第二筆
     */
    public  void swap(LinkedList<Integer> list,int t1, int t2){             
        if(t1<0||t1>51){
            return;
        }
        if(t2<0||t2>51){
            return;
        }
        int index1 = list.get(t1);
        int index2 = list.get(t2);        
        list.set(t1,index2);
        list.set(t2, index1);
    }
    /**
     * 洗牌
     * @param input
     * @param count 
     */
    public void shuffle(LinkedList<Integer> input,int count){
        int cardswaptimes=10000;  //交換次數
        for(int i=0;i<cardswaptimes;i++){
            int rand1=(int)(Math.random()*52); //隨機挑選第一筆位置
            int rand2=(int)(Math.random()*52); //隨機挑選第二筆位置
            swap(input,rand1,rand2); 
        }
    }
    /**
     * 氣泡排序
     * @param c 
     */
    public void sort(Comparator c){
        for(int i=0;i<MaxCard-1;i++){
            for(int n=0;n<MaxCard-1-i;n++){
                if(c.compare(cardlist.get(n),cardlist.get(n+1))>0){
                    swap(cardlist,n,n+1);
                }
            }
        }
    }
    /**
     * 取得花色
     * @param card
     * @return 
     */
    public String getSuit(int card){   
        if(card<1||card>MaxCard){
            return "";
        }
        String type[]={"黑桃","紅心","方塊","梅花"};        
        return type[(cardlist.get(card-1)-1)/13];
    }
    /**
     * 取得卡牌數值
     * @param card
     * @return 
     */
    public int getPoint(int card){
        if(card<1||card>MaxCard){
            return -1;
        }
        if(cardlist.get(card-1)%MaxNumber!=0){
            return cardlist.get(card-1)%MaxNumber;
        }
        return MaxNumber;
    }
    /**
     * 印出花色_卡牌數值
     * @param arr 
     */
    public void printCards(LinkedList<Integer> arr){
        for(int i=1;i<=MaxCard;i++){
            System.out.print(getSuit(i)+"_"+getPoint(i)+" ");
        }
    } 
    /**
     * 比較兩張卡牌大小
     * @param card1
     * @param card2
     * @return 
     */
    public int comparePoint(int card1, int card2){
        if(card1>card2){
            return 1;
        }
        else if(card1<card2){
            return -1;
        }
        else {
            return 0;
        }       
    } 
}
